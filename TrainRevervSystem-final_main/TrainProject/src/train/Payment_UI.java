package train;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.search.Search_Train_Panel;
import train.search.component.ReservBtn;
import train.ticket.Rev_detail;
import train.dao.Train_Api_DAO;
import train.dto.Search_TableDTO;
import train.food.FoodCourtMainPanel;
import javax.swing.JList;
import java.awt.Component;
// 결제창 클래스로 차내식에서 다음으로 이동시 선택한 내용을 결제화면에 출력
public class Payment_UI extends JDialog {
	
	private String date_text = TrainReserv_Main.date_text.getText();
	private String st_sub = TrainReserv_Main.st_sub_btn.getText();
	private String en_sub = TrainReserv_Main.en_sub_btn.getText();
	private final JPanel payment_info_panel = new JPanel();
	private String name = ReservBtn.name;
	private String num = ReservBtn.num;
	private String st_time = ReservBtn.st_time;
	private String en_time = ReservBtn.en_time;
	private String timetaken = ReservBtn.timetaken;
	private int carNum = TrainReserv_Main.carNum;
	private int train_price = Integer.parseInt(ReservBtn.price);
	private List<String> seatlist = TrainReserv_Main.seatSelectString;
	private String seatNum;
	private String[] food_table = FoodCourtMainPanel.food_table;
	private int food_total = Integer.parseInt(FoodCourtMainPanel.totalPrice_Lab.getText().split("원")[0]);
	private JTable table;
	private boolean user_who = train.TrainReserv_Main.login_who;
	static TrainReserv_Main reserv_main;
	/**
	 * @author LJH
	 */
	public static void main(String[] args) {
		try {
			Payment_UI dialog = new Payment_UI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 인원 선택 별 가격 할인율 적용
	public int price_calc(int train_price, int food_price) { 
		// 우대인원은 50%할인, 유아, 경로는 30%할인 티켓가격 적용
		int total_price = 0;
		int[] person = new int[4];
		person[0] = Integer.parseInt(Peopel_select.textField1.getText());
		person[1] = Integer.parseInt(Peopel_select.textField2.getText());
		person[2] = Integer.parseInt(Peopel_select.textField3.getText());
		person[3] = Integer.parseInt(Peopel_select.textField4.getText());
		for(int i =0; i < 4 ; ++i) {
			if(i == 0) {
				total_price += person[i]*train_price;
				
			}else if(i == 1) {
				total_price += person[i]*(train_price*0.7);
				
			}else if(i == 2) {
				total_price += person[i]*(train_price*0.7);
				
			}else if(i == 3) {
				total_price += person[i]*(train_price*0.5);
				
			}
		}
		
		return total_price + food_price;
	}
	/**
	 * Create the dialog.
	 */
	public Payment_UI() {
		setBounds(500, 20, 951, 1000);
		getContentPane().setLayout(new CardLayout(0, 0));
		payment_info_panel.setBackground(new Color(255, 255, 255));
		payment_info_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(payment_info_panel, "payment_info_panel");
		payment_info_panel.setLayout(null);
		JPanel boarding_date_label = new JPanel();
		boarding_date_label.setBackground(new Color(192, 192, 192));
		boarding_date_label.setBounds(11, 93, 912, 48);
		payment_info_panel.add(boarding_date_label);
		boarding_date_label.setLayout(null);
		
		JLabel riding_Date_Label = new JLabel("승차일");
		riding_Date_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 25));
		riding_Date_Label.setBounds(12, 0, 98, 48);
		boarding_date_label.add(riding_Date_Label);
		
		JLabel riding_Date = new JLabel(date_text);
		riding_Date.setFont(new Font("HY헤드라인M", Font.BOLD, 25));
		riding_Date.setBounds(122, 0, 192, 48);
		boarding_date_label.add(riding_Date);
		
		JButton card_Payment_Btn = new JButton("카드결제");
		card_Payment_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "cardpay_panel");
			}
		});

		card_Payment_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
		card_Payment_Btn.setForeground(new Color(255, 255, 255));
		card_Payment_Btn.setBackground(new Color(64, 0, 64));
		card_Payment_Btn.setBounds(11, 808, 421, 143);
		payment_info_panel.add(card_Payment_Btn);
		
		JLabel pay_Price_Label = new JLabel("결제금액");
		pay_Price_Label.setVerticalAlignment(SwingConstants.CENTER);
		pay_Price_Label.setHorizontalAlignment(SwingConstants.CENTER);
		pay_Price_Label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pay_Price_Label.setBounds(12, 663, 420, 139);
		payment_info_panel.add(pay_Price_Label);
		
		JScrollPane scrollPane = new JScrollPane();
		JTextArea textarea = new JTextArea();
		
		textarea.setLineWrap(true); // JTextArea의 줄바꿈 설정
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollPane.setViewportView(textarea);
		
		scrollPane.setBounds(10, 141, 915, 512);
		payment_info_panel.add(scrollPane);
		
		
		JPanel count_1 = new JPanel();
		count_1.setBackground(new Color(255, 255, 255));
		count_1.setBounds(12, 21, 911, 684);
		count_1.setLayout(null);
		count_1.setPreferredSize(new Dimension(900,600));
		count_1.setAutoscrolls(true);
		scrollPane.setViewportView(count_1);
		
		JLabel start_point_name = new JLabel(st_sub);
		start_point_name.setHorizontalAlignment(JLabel.CENTER);
		start_point_name.setVerticalAlignment(JLabel.CENTER);
		start_point_name.setFont(new Font("굴림", Font.BOLD, 35));
		start_point_name.setBounds(10, 62, 203, 90);
		count_1.add(start_point_name);
		
		JLabel destination_name = new JLabel(en_sub);
		destination_name.setHorizontalAlignment(JLabel.CENTER);
		destination_name.setVerticalAlignment(JLabel.CENTER);
		destination_name.setFont(new Font("굴림", Font.BOLD, 35));
		destination_name.setBounds(281, 62, 203, 90);
		count_1.add(destination_name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(496, 10, 392, 250);
		count_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel train_Boarding_Label = new JLabel();
		train_Boarding_Label.setText("호차 번호");
		train_Boarding_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		train_Boarding_Label.setVerticalAlignment(SwingConstants.CENTER);
		train_Boarding_Label.setHorizontalAlignment(SwingConstants.CENTER);
		train_Boarding_Label.setForeground(new Color(255, 255, 255));
		train_Boarding_Label.setBackground(new Color(0, 124, 192));
		train_Boarding_Label.setBorder(new LineBorder(Color.BLACK,2));
		train_Boarding_Label.setOpaque(true);
		train_Boarding_Label.setBounds(0, 0, 196, 125);
		panel_1.add(train_Boarding_Label);
		
		JLabel seat_Num_Label = new JLabel("좌석 번호");
		seat_Num_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		seat_Num_Label.setVerticalAlignment(SwingConstants.CENTER);
		seat_Num_Label.setHorizontalAlignment(SwingConstants.CENTER);
		seat_Num_Label.setForeground(new Color(255, 255, 255));
		seat_Num_Label.setBackground(new Color(0, 124, 192));
		seat_Num_Label.setBorder(new LineBorder(Color.BLACK,2));
		seat_Num_Label.setOpaque(true);
		seat_Num_Label.setBounds(196, 0, 196, 125);
		panel_1.add(seat_Num_Label);
		
		JLabel train_Boarding_Num = new JLabel(carNum+"호차");
		train_Boarding_Num.setFont(new Font("굴림", Font.BOLD, 20));
		train_Boarding_Num.setVerticalAlignment(SwingConstants.CENTER);
		train_Boarding_Num.setHorizontalAlignment(SwingConstants.CENTER);
		train_Boarding_Num.setBorder(new LineBorder(Color.BLACK,2));
		train_Boarding_Num.setBounds(0, 125, 196, 125);
		panel_1.add(train_Boarding_Num);
		if(seatlist.size() > 1) {
			int nm = seatlist.size();
			seatNum = seatlist.get(0) + "외 "+ (nm -1)+ "개"; 
		}else if(seatlist.size() == 1) {
			seatNum = seatlist.get(0);
		}
		JLabel seat_Num = new JLabel(seatNum);
		seat_Num.setFont(new Font("굴림", Font.BOLD, 20));
		seat_Num.setVerticalAlignment(SwingConstants.CENTER);
		seat_Num.setHorizontalAlignment(SwingConstants.CENTER);
		seat_Num.setBorder(new LineBorder(Color.BLACK,2));
		seat_Num.setBounds(196, 125, 196, 125);
		panel_1.add(seat_Num);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		Border border1 = BorderFactory.createLineBorder(Color.BLUE, 2);
		
		JLabel start_Time = new JLabel(st_time);
		start_Time.setHorizontalAlignment(JLabel.CENTER);
		start_Time.setVerticalAlignment(JLabel.CENTER);
		start_Time.setFont(new Font("굴림", Font.BOLD, 30));
		start_Time.setBounds(10, 162, 231, 63);
		count_1.add(start_Time);
		
		JLabel arrive_Time = new JLabel(en_time);
		arrive_Time.setHorizontalAlignment(JLabel.CENTER);
		arrive_Time.setVerticalAlignment(JLabel.CENTER);
		arrive_Time.setFont(new Font("굴림", Font.BOLD, 30));
		arrive_Time.setBounds(253, 162, 231, 63);
		count_1.add(arrive_Time);
		
		JLabel ticket_Info_Label = new JLabel("티켓정보");
		ticket_Info_Label.setForeground(new Color(255, 255, 255));
		ticket_Info_Label.setOpaque(true); // 불투명하게 설정
		ticket_Info_Label.setBackground(new Color(0, 124, 192)); // 파란색으로 색상 설정
		ticket_Info_Label.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Info_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Info_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		ticket_Info_Label.setBounds(10, 10, 474, 42);
		count_1.add(ticket_Info_Label);
		
		JLabel fnb_Info_Label = new JLabel("차내식");
		fnb_Info_Label.setVerticalAlignment(SwingConstants.CENTER);
		fnb_Info_Label.setOpaque(true);
		fnb_Info_Label.setHorizontalAlignment(SwingConstants.CENTER);
		fnb_Info_Label.setForeground(Color.WHITE);
		fnb_Info_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		fnb_Info_Label.setBackground(new Color(0, 124, 192));
		fnb_Info_Label.setBounds(10, 270, 474, 42);
		count_1.add(fnb_Info_Label);
		
		JLabel train_Num_Label = new JLabel(name+"-"+num+"번 열차");
		train_Num_Label.setHorizontalAlignment(JLabel.CENTER);
		train_Num_Label.setVerticalAlignment(JLabel.CENTER);
		train_Num_Label.setFont(new Font("굴림", Font.BOLD, 25));
		train_Num_Label.setBounds(10, 224, 474, 36);
		count_1.add(train_Num_Label);
		
		JLabel arrow_Label = new JLabel("→");
		arrow_Label.setForeground(new Color(255, 0, 0));
		arrow_Label.setFont(new Font("굴림", Font.BOLD, 35));
		arrow_Label.setBounds(225, 62, 57, 90);
		arrow_Label.setVerticalAlignment(SwingConstants.CENTER);
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		count_1.add(arrow_Label);
		
		JLabel seat_Class = new JLabel("일반실");
		seat_Class.setFont(new Font("굴림", Font.BOLD, 15));
		seat_Class.setBounds(496, 270, 120, 18);
		seat_Class.setHorizontalAlignment(JLabel.CENTER);
		seat_Class.setVerticalAlignment(JLabel.CENTER);
		count_1.add(seat_Class);
		
		JLabel seat_Drection = new JLabel("순방향");
		seat_Drection.setFont(new Font("굴림", Font.BOLD, 15));
		seat_Drection.setBounds(628, 270, 120, 18);
		seat_Drection.setHorizontalAlignment(JLabel.CENTER);
		seat_Drection.setVerticalAlignment(JLabel.CENTER);
		count_1.add(seat_Drection);
		
		JLabel age_Class = new JLabel("어른");
		age_Class.setFont(new Font("굴림", Font.BOLD, 15));
		age_Class.setBounds(760, 270, 120, 18);
		age_Class.setHorizontalAlignment(JLabel.CENTER);
		age_Class.setVerticalAlignment(JLabel.CENTER);
		count_1.add(age_Class);
		
		JLabel ticket_Unique_Num_Label = new JLabel("승차권 번호 : ");
		ticket_Unique_Num_Label.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num_Label.setFont(new Font("굴림", Font.BOLD, 15));
		ticket_Unique_Num_Label.setBounds(496, 294, 120, 18);
		count_1.add(ticket_Unique_Num_Label);
		
		JLabel ticket_Unique_Num = new JLabel("123-456-789");
		ticket_Unique_Num.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num.setFont(new Font("굴림", Font.BOLD, 15));
		ticket_Unique_Num.setBounds(628, 294, 260, 18);
		count_1.add(ticket_Unique_Num);
		
		JScrollPane user_sp = new JScrollPane((Component) null);
		user_sp.setBounds(10, 322, 878, 185);
		count_1.add(user_sp);
		
		
		String[] orderTableColumnName = {"좌석번호", "음식이름", "가격", "수량"};
		DefaultTableModel model = new DefaultTableModel(orderTableColumnName, 0);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		// 중앙 정렬
		// 차내식 테이블의 정보를 가져오기
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		if(!(food_total == 0)) {
			for(int i =0; i < food_table.length; i++) {
				String[] food_model = food_table[i].split(" ");
				model.insertRow(i, food_model);
			}
			
			table = new JTable(model);
			table.setRowHeight(50);
			table.getColumn("좌석번호").setCellRenderer(celAlignCenter);
			table.getColumn("음식이름").setCellRenderer(celAlignCenter);
			table.getColumn("가격").setCellRenderer(celAlignCenter);
			table.getColumn("수량").setCellRenderer(celAlignCenter);
			table.getTableHeader().setFont(new Font("HY견고딕", Font.PLAIN, 30));
			table.setAutoCreateRowSorter(true);
			table.setFont(new Font("HY견고딕", Font.PLAIN, 25));
			user_sp.setViewportView(table);
		}
		
		
		JLabel krw_Label = new JLabel("원");
		krw_Label.setHorizontalAlignment(JLabel.CENTER);
		krw_Label.setVerticalAlignment(JLabel.CENTER);
		krw_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		krw_Label.setBounds(858, 663, 65, 139);
		payment_info_panel.add(krw_Label);
		DecimalFormat dc = new DecimalFormat("###,###,###,###");
		int sum_price = price_calc(train_price, food_total);
		JLabel price = new JLabel(dc.format(sum_price));
		price.setHorizontalAlignment(JLabel.RIGHT);
//		price.setVerticalAlignment(JLabel.RIGHT);
		price.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		price.setBounds(444, 663, 402, 139);
		payment_info_panel.add(price);
		
		JLabel check_payment_information_Label = new JLabel("결제정보 확인");
		check_payment_information_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		check_payment_information_Label.setBounds(11, 0, 912, 91);
		check_payment_information_Label.setVerticalAlignment(SwingConstants.CENTER);
		check_payment_information_Label.setHorizontalAlignment(SwingConstants.CENTER);
		payment_info_panel.add(check_payment_information_Label);
		
		JButton Payment_Cancel_Btn = new JButton("취소/돌아가기");
		Payment_Cancel_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Payment_Cancel_Btn.setForeground(Color.WHITE);
		Payment_Cancel_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
		Payment_Cancel_Btn.setBackground(new Color(64, 0, 64));
		Payment_Cancel_Btn.setBounds(502, 808, 421, 143);
		payment_info_panel.add(Payment_Cancel_Btn);
		
		JPanel cardpay_panel = new JPanel();
		cardpay_panel.setLayout(null);
		cardpay_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		cardpay_panel.setBackground(Color.WHITE);
		getContentPane().add(cardpay_panel, "cardpay_panel");
		
		JLabel insertCard_Icon = new JLabel(new ImageIcon("resource\\cardpay.PNG"));
		insertCard_Icon.setBounds(252, 259, 420, 300);
		cardpay_panel.add(insertCard_Icon);
		
		JButton cancel_Btn = new JButton("취소");
		cancel_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "payment_info_panel");
			}
		});
		cancel_Btn.setForeground(Color.WHITE);
		cancel_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		cancel_Btn.setBackground(new Color(64, 0, 64));
		cancel_Btn.setBounds(252, 725, 420, 143);
		cardpay_panel.add(cancel_Btn);
		
		JLabel insertCard_Label = new JLabel("카드를 투입구에 넣어주세요");
		insertCard_Label.setVerticalAlignment(SwingConstants.CENTER);
		insertCard_Label.setHorizontalAlignment(SwingConstants.CENTER);
		insertCard_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		insertCard_Label.setBounds(12, 569, 911, 150);
		cardpay_panel.add(insertCard_Label);
		
		JLabel upper_Rim = new JLabel("");
		upper_Rim.setOpaque(true);
		upper_Rim.setBackground(Color.BLACK);
		upper_Rim.setBounds(12, 10, 911, 15);
		cardpay_panel.add(upper_Rim);
		
		JLabel lower_Rim = new JLabel("");
		lower_Rim.setOpaque(true);
		lower_Rim.setBackground(Color.BLACK);
		lower_Rim.setBounds(12, 936, 911, 15);
		cardpay_panel.add(lower_Rim);
		
		JLabel left_Rim = new JLabel("");
		left_Rim.setOpaque(true);
		left_Rim.setBackground(Color.BLACK);
		left_Rim.setBounds(12, 23, 15, 913);
		cardpay_panel.add(left_Rim);
		
		JLabel right_Rim = new JLabel("");
		right_Rim.setOpaque(true);
		right_Rim.setBackground(Color.BLACK);
		right_Rim.setBounds(908, 23, 15, 913);
		cardpay_panel.add(right_Rim);
		
		JPanel payment_successful_panel = new JPanel();
		payment_successful_panel.setLayout(null);
		payment_successful_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		payment_successful_panel.setBackground(Color.WHITE);
		getContentPane().add(payment_successful_panel, "payment_successful_panel");
		
		JButton Previous_Btn = new JButton("처음으로");
		Previous_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TrainReserv_Main.frame.dispose();
				setVisible(false);
				Train_Main main_return = new Train_Main();
				main_return.main(null);
			}
		});
		Previous_Btn.setForeground(Color.WHITE);
		Previous_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		Previous_Btn.setBackground(new Color(64, 0, 64));
		Previous_Btn.setBounds(252, 725, 420, 143);
		payment_successful_panel.add(Previous_Btn);
		
		JLabel sucessPay_Label = new JLabel("결제 성공!");
		sucessPay_Label.setVerticalAlignment(SwingConstants.CENTER);
		sucessPay_Label.setHorizontalAlignment(SwingConstants.CENTER);
		sucessPay_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		sucessPay_Label.setBounds(12, 569, 911, 150);
		payment_successful_panel.add(sucessPay_Label);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(12, 10, 911, 15);
		payment_successful_panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(12, 936, 911, 15);
		payment_successful_panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setBackground(Color.BLACK);
		lblNewLabel_2_2.setBounds(12, 23, 15, 913);
		payment_successful_panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setBackground(Color.BLACK);
		lblNewLabel_2_1_1.setBounds(908, 23, 15, 913);
		payment_successful_panel.add(lblNewLabel_2_1_1);
		
		JLabel card_icon_1 = new JLabel(new ImageIcon("resource\\paysuccess.png"));
		card_icon_1.setBounds(252, 224, 420, 335);
		payment_successful_panel.add(card_icon_1);
		
		//결제 완료 화면 자동 전환 타이머
		Timer timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 패널 전환 코드 추가
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.show(getContentPane(), "payment_successful_panel");
                Train_Api_DAO dao = new Train_Api_DAO();
                train.dao.FoodDAO foodDao = new train.dao.FoodDAO();
                List<String> apilist = new ArrayList();
                List<String> holist = new ArrayList();
                List<String> ticketlist= new ArrayList();
                
                apilist.add(name);
                apilist.add(num);
                apilist.add(date_text);
                apilist.add(st_sub);
                apilist.add(st_time);
                apilist.add(en_sub);
                apilist.add(en_time);
                apilist.add(timetaken);
                System.out.println(apilist.toString());
                // 열차 입력
                int chk = dao.chk_train(apilist);
                if (chk == 0) {
                	dao.setAllSearch(apilist); // 없으면 insert
                }
             
                chk = dao.chk_train(apilist); // 체크 및 열차 pk
                // 호차 입력
                holist.add(""+carNum);
                if(carNum < 4) {
                	holist.add("specialSeat");
                	holist.add("30");
                }else {
                	holist.add("standardSeat");
                	holist.add("40");
                }
                // 호차 넣기
                int chktrain = dao.chkTrain_Table(holist, chk);
                if(chktrain == 0) {
                	dao.setTrain_ho(holist, chk); // 체크 및 호차 pk
                }
                chktrain = dao.chkTrain_Table(holist, chk); // 체크 및 호차 pk
                // 좌석 입력
                for(String sn : seatlist) {
                	List<String> seatlist = new ArrayList();
                	List<String> foodlist = new ArrayList();
                	seatlist.add(sn);
                	if(sn.equals("1A") || sn.equals("1B")||sn.equals("1C")||sn.equals("1D") && carNum == 1 || carNum == 4) {
                		seatlist.add("wheel");
                	}else {
                		seatlist.add("nomal");
                	}
                	seatlist.add(""+train_price);
                	dao.setSeatDown(chktrain);
                	dao.setSeat(seatlist, chktrain);
                	// 티켓 입력
                	ticketlist.add(""+train_price);
                	int food_price = 0;
                	if (!(food_total == 0)) {
                		for(int i =0; i<food_table.length; ++i) {
                    		if(food_table[i].contains(sn)) {
                    			food_price += Integer.parseInt(food_table[i].split(" ")[2]);
                    			foodlist.add(food_table[i].split(" ")[1]);
                    			System.out.println(food_table[i].split(" ")[1]); //이름
                    			foodlist.add(food_table[i].split(" ")[3]);
                    			System.out.println(food_table[i].split(" ")[3]); // 수량
                    			foodlist.add(food_table[i].split(" ")[2]);
                    			System.out.println(food_table[i].split(" ")[2]); // 가격
                    			ticketlist.add(""+food_price);
                            	
                    		}else {
                    			ticketlist.add("0");
                    		}
                    	}
                		ticketlist.add(date_text);
                		// 로그인 여부에 따라 차내식 비회원, 회원 DB 넣기
                    	if(user_who) {
                    		dao.settikect(ticketlist, seatlist, chktrain);
                    		if (!foodlist.isEmpty()) {
                    			foodDao.setLoginFood(foodlist, seatlist, chktrain);
                    		}
                    	}else {
                    		dao.set_unmem_tikect(ticketlist, seatlist, chktrain);
                    		if (!foodlist.isEmpty()) {
                    			foodDao.setUnLoginFood(foodlist, seatlist, chktrain);
                    		}
                    	}
                	}else { // 회원, 비회원 티켓 DB 입력
                		ticketlist.add(""+train_price);
                		ticketlist.add(date_text);
                		if(user_who) {
                    		dao.settikect(ticketlist, seatlist, chktrain);
                		}else {
                    		dao.set_unmem_tikect(ticketlist, seatlist, chktrain);
                		}
                	}
                	
                	TrainReserv_Main.count_panel =0;
                }
            }
        });
        timer.setRepeats(false); // 타이머 반복 실행 비활성화
		
        cardpay_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timer.start();
            }
        });
        
	}
}
