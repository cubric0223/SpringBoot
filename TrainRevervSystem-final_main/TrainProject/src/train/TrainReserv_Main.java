package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import train.calender.CalenderMain;
import train.calender.Calender_Panel;
import train.subway.SubwayPanel;
import train.subway.Subway_Kind;
import train.food.*;
import train.search.Search_Train_Panel;
import train.search.component.ReservBtn;
import train.seat_special.SpecialSeatSelect;
import train.seat_standard.StandardSeatSelect;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.github.lgooddatepicker.components.DatePicker;
//import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 	예매 메인 클래스 프레임 - 이종현
 	기차역 선택, 날짜, 열차종류, 인원 선택, 열차 시간표, 좌석 선택, 차내식 선택, 결제까지 연결 하는 메인
 	
 */


/**
 * @author LJH
 *
 */
public class TrainReserv_Main extends JFrame {

	private JPanel contentPane;
	private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
    public static JTextField date_text; // 날짜 텍스트
    public static JButton st_sub_btn; // 기차 출발역
    public static JButton en_sub_btn; // 기차 도착역
    public static String subSelectText; // 선택한 열차 종류
    public static JButton selectsubBtn; // 열차 종류
    public static String seatSelect; // 선택 좌석
    public static int carNum; // 호차 번호
    public static JLabel selectPeopleLabel; // 전체 선택 인원 합
    public static List<String> seatSelectString; // 좌석 선택 리스트
    public static JLabel seatSelectLabel; // 좌석 선택
    public static CardLayout card; // 카드 레이아웃
    public static JPanel card_panel; // 카드 레이아웃 패널
    public static boolean sub_select = true; // 출발지 true, 도착지 false
    public static boolean login_who = true; // 회원 true, 비회원 false
    public static TrainReserv_Main frame; // 현재 예매 프레임
    public static int count_panel = 0; // 카드 레이아웃 패널 선택 번호
    								   /* 출/도착지 0
    								    * 달력 1
    								    * 열차 종류 2
    								    * 인원 선택 3
    								    * 기차 선택 4
    								    * 차내식 5
    									*/
    /**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TrainReserv_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	/**
	 * Create the frame.
	 */
	public TrainReserv_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 전체 패널 기준 카드레이아웃
		card = new CardLayout();
		card_panel = new JPanel();
		card_panel.setBackground(new Color(255, 255, 255));
		card_panel.setBounds(441, 80, 1483, 931);
		contentPane.add(card_panel);
		card_panel.setLayout(card);
		// 출/도착지 패널
		JPanel subway_panel = new SubwayPanel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(subway_panel, "subway");
		// 달력 패널
		JPanel calendar_panel = new Calender_Panel();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(calendar_panel, "calender");
		// 열차 종류 패널
		JPanel subway_kind = new Subway_Kind();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(subway_kind, "subkind");
		// 좌석 패널
		JPanel seat_panel = new Peopel_select();
		card_panel.setBounds(441,80,1483,931);
		card_panel.add(seat_panel, "select");
		// 차내식
		JPanel food_panel = new FoodCourtMainPanel();
		food_panel.setBounds(441, 80, 1483, 931);
		card_panel.add(food_panel, "food");
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(54, 124, 179));
		main_panel.setBounds(0, 0, 1924, 1011);
		contentPane.add(main_panel);
		// 메인 홈으로 가는 버튼
		JButton home_btn = new JButton();
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		home_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 홈버튼 누르면 홈으로 이동			
				Train_Main first_frame = new Train_Main();
				first_frame.main(null);
				dispose();			
			}
		});
		// 예매 패널의 선택한 사항 확인 패널
		JPanel reserv_panel = new JPanel();
		reserv_panel.setAutoscrolls(true);
		reserv_panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		reserv_panel.setBackground(new Color(187, 214, 234));
		reserv_panel.setLayout(null);
		
		JLabel start_place_label = new JLabel("출발");
		start_place_label.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		start_place_label.setBounds(168, 31, 63, 29);
		reserv_panel.add(start_place_label);
		
		JLabel lblNewLabel_1_1 = new JLabel("도착");
		lblNewLabel_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(169, 158, 63, 29);
		reserv_panel.add(lblNewLabel_1_1);
		
		st_sub_btn = new JButton("서울");
		st_sub_btn.setForeground(Color.WHITE);
		st_sub_btn.setBackground(new Color(0, 128, 192));
		st_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = true; // 출발지를 선택하였을때
			}
		});
		st_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		st_sub_btn.setBounds(45, 82, 319, 49);
		reserv_panel.add(st_sub_btn);
		
		en_sub_btn = new JButton("부산");
		en_sub_btn.setForeground(Color.WHITE);
		en_sub_btn.setBackground(new Color(0, 128, 192));
		en_sub_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub_select = false; // 도착지를 선택하였을때
			}
		});
		en_sub_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		en_sub_btn.setBounds(45, 209, 319, 49);
		reserv_panel.add(en_sub_btn);
		
		JLabel start_date_label = new JLabel("출발일");
		start_date_label.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		start_date_label.setBounds(157, 292, 86, 34);
		reserv_panel.add(start_date_label);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("열차 조회");
		lblNewLabel_1_1_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_1_1_1_1.setBounds(146, 415, 114, 34);
		reserv_panel.add(lblNewLabel_1_1_1_1);
		
		ButtonGroup group = new ButtonGroup();
		Calendar calendar = Calendar.getInstance();
		LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
		String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		// 날짜 선택 텍스트필드
		date_text = new JTextField(date);
		date_text.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		date_text.setColumns(10);
		date_text.setBounds(99, 343, 186, 41);
		date_text.setEditable(false);
		reserv_panel.add(date_text);
		
		selectsubBtn = new JButton("전체");
		selectsubBtn.setForeground(Color.WHITE);
		selectsubBtn.setBackground(new Color(0, 128, 192));
		selectsubBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		selectsubBtn.setBounds(86, 459, 211, 49);
		reserv_panel.add(selectsubBtn);
		
		JLabel lblNewLabel_1 = new JLabel("전체 인원 :");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(12, 550, 152, 54);
		reserv_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("좌석 선택 :");
		lblNewLabel_1_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(12, 661, 152, 54);
		reserv_panel.add(lblNewLabel_1_2);
		
		seatSelectLabel = new JLabel("X");
		seatSelectLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		seatSelectLabel.setBounds(205, 673, 174, 70);
		reserv_panel.add(seatSelectLabel);
		
		selectPeopleLabel = new JLabel("X");
		selectPeopleLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		selectPeopleLabel.setBounds(205, 562, 80, 31);
		reserv_panel.add(selectPeopleLabel);
		// 다음 버튼을 눌러 패널 교체
		JButton previous_btn = new JButton();
		previous_btn.setBorderPainted(false);
		previous_btn.setContentAreaFilled(false);
		previous_btn.setFocusPainted(false);
		previous_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(count_panel);
				if(count_panel == 1) { // 현재 패널이 달력일때
					st_sub_btn.setText("서울");
					en_sub_btn.setText("부산");
					JPanel calendar_panel = new Calender_Panel();
					card_panel.setBounds(441,80,1483,931);
					card_panel.add(calendar_panel, "calender");
					Calendar calendar = Calendar.getInstance();
					LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
					// 현재 날짜 불러오기
					String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
					date_text.setText(date);
					card.show(card_panel, "subway"); // 기차 선택 패널로 이동
					count_panel = 0;
				}else if(count_panel == 2) { // 현재 패널이 열차 종류 선택일때
					selectsubBtn.setText("전체");
					JPanel calendar_panel = new Calender_Panel();
					card_panel.setBounds(441,80,1483,931);
					card_panel.add(calendar_panel, "calender");
					Calendar calendar = Calendar.getInstance();
					LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
					String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
					date_text.setText(date);
					card.show(card_panel, "calender"); // 달력 패널로 이동
					count_panel = 1;
				}else if(count_panel == 3) { // 현재 패널이 인원 선택일 때 
					selectsubBtn.setText("전체");
					selectPeopleLabel.setText("X");
					Peopel_select.textField1.setText("0");
					Peopel_select.textField2.setText("0");
					Peopel_select.textField3.setText("0");
					Peopel_select.textField4.setText("0");
					card.show(card_panel, "subkind"); // 열차 종류선택으로 이동
					count_panel = 2;
				}else if(count_panel == 4) { // 현재 패널이 기차 선택일 때
					selectPeopleLabel.setText("X");
					Peopel_select.textField1.setText("0");
					Peopel_select.textField2.setText("0");
					Peopel_select.textField3.setText("0");
					Peopel_select.textField4.setText("0");
					card.show(card_panel, "select"); // 인원 선택으로 이동
					count_panel = 3;
				}else if(count_panel == 5) { // 현재 패널이 차내식일때
					seatSelectLabel.setText("X");
					card.show(card_panel, "기차API");
					JPanel food_panel = new FoodCourtMainPanel();
					food_panel.setBounds(441, 80, 1483, 931);
					card_panel.add(food_panel, "food");
					count_panel = 4;
				}
			}
		});

		GroupLayout gl_main_panel = new GroupLayout(main_panel);
		gl_main_panel.setHorizontalGroup(
			gl_main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_main_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_main_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(previous_btn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(1700)
							.addComponent(home_btn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(reserv_panel, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		gl_main_panel.setVerticalGroup(
			gl_main_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_main_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(home_btn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addGroup(gl_main_panel.createSequentialGroup()
							.addGroup(gl_main_panel.createParallelGroup(Alignment.LEADING)
								.addGap(20)
								.addComponent(previous_btn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addComponent(reserv_panel, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		main_panel.setLayout(gl_main_panel);
		
		try {
			home_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/Home.png")).getScaledInstance(70, 60, Image.SCALE_AREA_AVERAGING)));
			
			previous_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/main_back.png")).getScaledInstance(110, 50, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
