package train.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import train.TrainReserv_Main;
import train.admin.component.MemSearchBtn;
import train.admin.component.NoMemSearchBtn;
import train.dao.Check_Rev_DAO;
import train.jungjun.No_login_joinDAO;
import train.jungjun.change.Mem_chageDAO;
import train.jungjun.change.No_mem_changeDAO;
import train.jungjun.login_join_page.Login_and_joinDAO;
// 회원, 비회원 티켓 조회 화면 다이얼로그
public class Rev_detail extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public static JButton refund_Btn;
	String[] columnNames = {"티켓번호","열차이름", "열차번호", "예매일", "출발지", "도착지", "출발시간", "도착시간", "호차", "좌석"};
	DefaultTableModel ticketModel = new DefaultTableModel(columnNames, 0);
	public static String[] columnNames2 = {"티켓번호","좌석번호", "음식이름", "수량","가격"};
	public static DefaultTableModel ticket_food_model = new DefaultTableModel(columnNames2, 0);
	public static JScrollPane fnb_scrollPane;
	public static JTable table;
	public static JPanel copy_Panel;
	public static boolean chk_search;
	public static boolean chk_login;
	public static boolean chk_admin = false;
	String date_text;
	String user_code;
	
	Check_Rev_DAO checkDAO = new Check_Rev_DAO();
	
	public static void main(String[] args) {
	
		try {
			Rev_detail dialog = new Rev_detail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String[] orderTableColumnName = {"좌석번호", "음식이름", "가격", "수량"};
	/**
	 * Create the dialog.
	 */

	public Rev_detail() {
		
		setBounds(500, 0, 951, 1050);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel payment_Info_Panel = new JPanel();
		payment_Info_Panel.setLayout(null);
		payment_Info_Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		payment_Info_Panel.setBackground(Color.WHITE);
		payment_Info_Panel.setBounds(0, 0, 935, 1011);
		contentPanel.add(payment_Info_Panel);
		
		JPanel boarding_Label = new JPanel();
		boarding_Label.setLayout(null);
		boarding_Label.setBackground(Color.LIGHT_GRAY);
		boarding_Label.setBounds(21, 93, 902, 48);
		payment_Info_Panel.add(boarding_Label);
		
		JLabel boarding_Date_Label = new JLabel("승차일");
		boarding_Date_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 25));
		boarding_Date_Label.setBounds(12, 0, 98, 48);
		boarding_Label.add(boarding_Date_Label);
		
		JLabel boarding_Date = new JLabel(date_text);
		boarding_Date.setFont(new Font("HY헤드라인M", Font.BOLD, 25));
		boarding_Date.setBounds(122, 0, 192, 48);
		boarding_Label.add(boarding_Date);
		System.out.println("로그인 체크 : "+ chk_admin);
		// 로그인이 되었을때 티켓조회의 회원 티켓, 회원 차내식 조회
		if(chk_admin) {
			
			if(chk_login){
				
				System.out.println(MemSearchBtn.ticket_code);
				checkDAO.chk_train_admin(ticketModel,MemSearchBtn.ticket_code);
			}else {
				
				System.out.println(MemSearchBtn.ticket_code);
				checkDAO.no_mem_chk_train_admin(ticketModel,NoMemSearchBtn.ticket_code);
			}
			
		// 비회원 일때 티켓조회의 비회원 티켓 조회	
		}else {
			System.out.println("로그인 체크 : "+ chk_search + chk_login);
			// Refund 버튼의 ActionListener
						refund_Btn = new JButton("반환");
						
						refund_Btn.setEnabled(false); // 초기에는 비활성화 상태로 설정합니다.
						refund_Btn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Refund 버튼이 클릭되었을 때의 동작을 정의합니다.
								
								Refund_panel rp = new Refund_panel();
								rp.main(null);
								
								// 반환 및 취소 버튼이 있는 패널 생성
								JPanel buttonPanel = new JPanel();
				                JButton button1 = new JButton("반환");
				                JButton button2 = new JButton("취소");
				                
				                button1.setFont(new Font("HY헤드라인M", Font.BOLD, 100));
				                button2.setFont(new Font("HY헤드라인M", Font.BOLD, 100));
				                button2.addActionListener(new ActionListener() {
				                    @Override
				                    public void actionPerformed(ActionEvent e) {
				                        // 버튼 '취소'를 눌렀을 때 창 닫기
				                    	Window window = SwingUtilities.windowForComponent(button1);
				                        if (window != null) {
				                            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
				                        }
				                        
				                    }
				                });
							}
						});
						refund_Btn.setForeground(Color.WHITE);
						refund_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
						refund_Btn.setBackground(new Color(64, 0, 64));
						refund_Btn.setBounds(21, 858, 401, 143);
						payment_Info_Panel.add(refund_Btn);
			if(chk_login) {
				if (chk_search) {
					date_text = TrainReserv_Main.date_text.getText();
					System.out.println(date_text);
					user_code = Login_and_joinDAO.user_code;
					checkDAO.chk_train(ticketModel,user_code, date_text);
				}else {
					Calendar calendar = Calendar.getInstance();
					LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
					String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
					date_text = date;
					user_code = Mem_chageDAO.user_code;
					
					
					System.out.println(user_code);
					System.out.println(date_text);
					checkDAO.chk_train(ticketModel,user_code, date_text);
				}
				
			}else {
				if (chk_search) {
					date_text = TrainReserv_Main.date_text.getText();
					checkDAO.no_mem_chk_train(ticketModel, date_text);
				}else {
					Calendar calendar = Calendar.getInstance();
					LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
					String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
					date_text = date;
					user_code = No_mem_changeDAO.pk;
					System.out.println(user_code);
					System.out.println(date_text);
					checkDAO.no_mem_chk_train(ticketModel, date_text);
				}
				
			}
		}
		
		
		
		JPanel ticketRev_Panel = new JPanel();
		int panelHeight;
		
		// 스크롤 패널을 패널로 바꾸기
		JPanel all_BackPane = new JPanel();
		all_BackPane.setBackground(new Color(255, 255, 255));
		all_BackPane.setBounds(10, 141, 915, 707);
		payment_Info_Panel.add(all_BackPane);
		
		JLabel fnb_Info_Label = new JLabel("차내식");
		fnb_Info_Label.setVerticalAlignment(SwingConstants.CENTER);
		fnb_Info_Label.setOpaque(true);
		fnb_Info_Label.setHorizontalAlignment(SwingConstants.CENTER);
		fnb_Info_Label.setForeground(Color.WHITE);
		fnb_Info_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		fnb_Info_Label.setBackground(new Color(0, 124, 192));
		
		fnb_scrollPane = new JScrollPane();
		
		JScrollPane ticket_Scroll_panel = new JScrollPane();
		
		GroupLayout gl_all_BackPane = new GroupLayout(all_BackPane);
		gl_all_BackPane.setHorizontalGroup(
			gl_all_BackPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_all_BackPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_all_BackPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(fnb_scrollPane, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
						.addComponent(ticket_Scroll_panel, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
						.addComponent(fnb_Info_Label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_all_BackPane.setVerticalGroup(
			gl_all_BackPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_all_BackPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(ticket_Scroll_panel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fnb_Info_Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(fnb_scrollPane, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ticket_Scroll_panel.getVerticalScrollBar().setUnitIncrement(16);
		

//		JPanel fnb_Panel = new JPanel();
//		fnb_Panel.setPreferredSize(new Dimension(869, 288));
//		fnb_scrollPane.setViewportView(fnb_Panel);
//		
//		DefaultTableModel order_dtm = new DefaultTableModel(orderTableColumnName, 0);
		
		// 오더테이블 값 가져오기
//		OrderTable orderTable = new OrderTable(order_dtm);
//		orderTable.setBounds(0, 0, 881, 278);
//		
//		orderTable.getTableAllValue();
//		fnb_Panel.setLayout(null);
//		fnb_Panel.add(orderTable);
		// 여기까지
		
		
		
		for(int i = 0; i < ticketModel.getRowCount(); i ++) {
			List train_list = new ArrayList(); 
			for(int j =0; j< columnNames.length; ++j) {
				train_list.add(ticketModel.getValueAt(i, j));
				System.out.println(ticketModel.getValueAt(i, j));
			}
			copy_Panel = new Ticket_Info(train_list);
			copy_Panel.setPreferredSize(new Dimension(869, 288));
			copy_Panel.setBounds(10, i * 300, 869, 288);
			ticketRev_Panel.add(copy_Panel);
		}
		panelHeight = 300 * ticketModel.getRowCount();
		
		ticketRev_Panel.setLayout(null);
		ticketRev_Panel.setPreferredSize(new Dimension(860, panelHeight));
		ticketRev_Panel.setBackground(Color.WHITE);
		ticket_Scroll_panel.setViewportView(ticketRev_Panel);
		all_BackPane.setLayout(gl_all_BackPane);
		
		// 여기까지-------------------
		
		JLabel check_Payment_Info_Label = new JLabel("결제정보 확인");
		check_Payment_Info_Label.setVerticalAlignment(SwingConstants.CENTER);
		check_Payment_Info_Label.setHorizontalAlignment(SwingConstants.CENTER);
		check_Payment_Info_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		check_Payment_Info_Label.setBounds(11, 0, 912, 91);
		payment_Info_Panel.add(check_Payment_Info_Label);
		
		JButton Payment_Cancel_Btn = new JButton("확인");
		Payment_Cancel_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Payment_Cancel_Btn.setForeground(Color.WHITE);
		Payment_Cancel_Btn.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
		Payment_Cancel_Btn.setBackground(new Color(64, 0, 64));
		Payment_Cancel_Btn.setBounds(522, 858, 401, 143);
		payment_Info_Panel.add(Payment_Cancel_Btn);
		
		
	}

}
