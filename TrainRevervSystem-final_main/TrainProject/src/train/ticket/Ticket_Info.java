package train.ticket;

import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import train.dao.Check_Rev_DAO;
import train.food.component.OrderTable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
// 티켓조회 창에 티켓정보 출력하기 
public class Ticket_Info extends JPanel {
	String[] columnNames = {"티켓번호","좌석번호", "음식이름", "수량","가격"};
	DefaultTableModel ticket_food_model = new DefaultTableModel(columnNames, 0);
	Check_Rev_DAO checkDAO = new Check_Rev_DAO();
	public static List<String> tnum_li = new ArrayList<>();
	public Ticket_Info(List<String> train_list) {
		setBackground(new Color(255, 255, 255));
		
		setLayout(null);
		
		JPanel reserve_Ticket_Panel = new JPanel();
		reserve_Ticket_Panel.setLayout(null);
		reserve_Ticket_Panel.setBackground(new Color(255, 255, 255));
		reserve_Ticket_Panel.setBounds(0, 10, 869, 296);
		add(reserve_Ticket_Panel);
		
		JLabel ticket_Info_Label = new JLabel("티켓정보");
		ticket_Info_Label.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Info_Label.setOpaque(true);
		ticket_Info_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Info_Label.setForeground(Color.WHITE);
		ticket_Info_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		ticket_Info_Label.setBackground(new Color(0, 124, 192));
		ticket_Info_Label.setBounds(0, 2, 474, 42);
		reserve_Ticket_Panel.add(ticket_Info_Label);
		
		JLabel train_Boarding_Label = new JLabel("호차 번호");
		train_Boarding_Label.setVerticalAlignment(SwingConstants.CENTER);
		train_Boarding_Label.setOpaque(true);
		train_Boarding_Label.setHorizontalAlignment(SwingConstants.CENTER);
		train_Boarding_Label.setForeground(Color.WHITE);
		train_Boarding_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		train_Boarding_Label.setBorder(new LineBorder(Color.BLACK,2));
		train_Boarding_Label.setBackground(new Color(0, 124, 192));
		train_Boarding_Label.setBounds(478, 2, 189, 39);
		reserve_Ticket_Panel.add(train_Boarding_Label);
		
		JLabel seat_Num_Label = new JLabel("좌석 번호");
		seat_Num_Label.setVerticalAlignment(SwingConstants.CENTER);
		seat_Num_Label.setOpaque(true);
		seat_Num_Label.setHorizontalAlignment(SwingConstants.CENTER);
		seat_Num_Label.setForeground(Color.WHITE);
		seat_Num_Label.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		seat_Num_Label.setBorder(new LineBorder(Color.BLACK,2));
		seat_Num_Label.setBackground(new Color(0, 124, 192));
		seat_Num_Label.setBounds(665, 2, 183, 39);
		reserve_Ticket_Panel.add(seat_Num_Label);
		
		JLabel arrow_Label = new JLabel("→");
		arrow_Label.setVerticalAlignment(SwingConstants.CENTER);
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		arrow_Label.setForeground(Color.RED);
		arrow_Label.setFont(new Font("굴림", Font.BOLD, 35));
		arrow_Label.setBounds(215, 52, 57, 90);
		reserve_Ticket_Panel.add(arrow_Label);
		
		JLabel start_Point_Label = new JLabel(train_list.get(4));
		start_Point_Label.setVerticalAlignment(SwingConstants.CENTER);
		start_Point_Label.setHorizontalAlignment(SwingConstants.CENTER);
		start_Point_Label.setFont(new Font("굴림", Font.BOLD, 35));
		start_Point_Label.setBounds(0, 52, 203, 90);
		reserve_Ticket_Panel.add(start_Point_Label);
		
		JLabel destination_Label = new JLabel(train_list.get(5));
		destination_Label.setVerticalAlignment(SwingConstants.CENTER);
		destination_Label.setHorizontalAlignment(SwingConstants.CENTER);
		destination_Label.setFont(new Font("굴림", Font.BOLD, 35));
		destination_Label.setBounds(271, 52, 203, 90);
		reserve_Ticket_Panel.add(destination_Label);
		
		JLabel seat_Num = new JLabel(train_list.get(9));
		seat_Num.setVerticalAlignment(SwingConstants.CENTER);
		seat_Num.setHorizontalAlignment(SwingConstants.CENTER);
		seat_Num.setFont(new Font("굴림", Font.BOLD, 20));
		seat_Num.setBorder(new LineBorder(Color.BLACK,2));
		seat_Num.setBounds(665, 38, 183, 63);
		reserve_Ticket_Panel.add(seat_Num);
		
		JLabel train_Boarding_Num = new JLabel(train_list.get(8));
		train_Boarding_Num.setVerticalAlignment(SwingConstants.CENTER);
		train_Boarding_Num.setHorizontalAlignment(SwingConstants.CENTER);
		train_Boarding_Num.setFont(new Font("굴림", Font.BOLD, 20));
		train_Boarding_Num.setBorder(new LineBorder(Color.BLACK,2));
		train_Boarding_Num.setBounds(478, 38, 189, 63);
		reserve_Ticket_Panel.add(train_Boarding_Num);
		
		JLabel train_Num_Label = new JLabel(train_list.get(1) + "-"+ train_list.get(2)+"번 열차");
		train_Num_Label.setVerticalAlignment(SwingConstants.CENTER);
		train_Num_Label.setHorizontalAlignment(SwingConstants.CENTER);
		train_Num_Label.setFont(new Font("굴림", Font.BOLD, 25));
		train_Num_Label.setBounds(486, 113, 362, 36);
		reserve_Ticket_Panel.add(train_Num_Label);
		
		JLabel start_Time = new JLabel(train_list.get(6));
		start_Time.setVerticalAlignment(SwingConstants.CENTER);
		start_Time.setHorizontalAlignment(SwingConstants.CENTER);
		start_Time.setFont(new Font("굴림", Font.BOLD, 30));
		start_Time.setBounds(0, 152, 231, 63);
		reserve_Ticket_Panel.add(start_Time);
		
		JLabel arrive_Time = new JLabel(train_list.get(7));
		arrive_Time.setVerticalAlignment(SwingConstants.CENTER);
		arrive_Time.setHorizontalAlignment(SwingConstants.CENTER);
		arrive_Time.setFont(new Font("굴림", Font.BOLD, 30));
		arrive_Time.setBounds(243, 152, 231, 63);
		reserve_Ticket_Panel.add(arrive_Time);
		
		JLabel ticket_Unique_Num_Label = new JLabel("승차권 번호 : ");
		ticket_Unique_Num_Label.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num_Label.setFont(new Font("굴림", Font.BOLD, 15));
		ticket_Unique_Num_Label.setBounds(486, 179, 120, 18);
		reserve_Ticket_Panel.add(ticket_Unique_Num_Label);
		
		JLabel ticket_Unique_Num = new JLabel(train_list.get(0));
		ticket_Unique_Num.setVerticalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num.setHorizontalAlignment(SwingConstants.CENTER);
		ticket_Unique_Num.setFont(new Font("굴림", Font.BOLD, 15));
		ticket_Unique_Num.setBounds(618, 179, 230, 18);
		reserve_Ticket_Panel.add(ticket_Unique_Num);
		// 선택한 티켓의 값을 반환할 것인지 선택
		// 티켓이 선택되면 반환 버튼 활성화
		JCheckBox select_chkbox = new JCheckBox("선택");
		select_chkbox.addItemListener(new ItemListener() {
			// 선택 시 차내식 정보 테이블에 티켓 값에 해당하는 값 넣기
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					Rev_detail.refund_Btn.setEnabled(true); // 버튼 활성화
                	tnum_li.add(train_list.get(0));
                	ticket_food_model = new DefaultTableModel(columnNames, 0);
					Check_Rev_DAO chkDAO = new Check_Rev_DAO();
					if (Rev_detail.chk_login) {
						chkDAO.chk_food(tnum_li, ticket_food_model);
					}else {
						chkDAO.no_mem_chk_food(tnum_li, ticket_food_model);
					}
					JTable table = new JTable(ticket_food_model);
					table.setRowHeight(80);
					table.setAutoCreateRowSorter(true);
					table.setFont(new Font("HY견고딕", Font.PLAIN, 18));
					table.getTableHeader().setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
					Rev_detail.fnb_scrollPane.setViewportView(table);
				// 선택 취소 차내식 정보 테이블에 티켓 값에 해당하는 값 빼고 선택한 값 넣기
				}else if(e.getStateChange() == 2){
					Rev_detail.refund_Btn.setEnabled(false); // 버튼 비활성화
                	System.out.println(train_list.get(0));
                	
                	for(int i =0 ; i< tnum_li.size(); ++i) {
                		if (tnum_li.get(i).equals(train_list.get(0)) && tnum_li.size() > 0) {
                			tnum_li.remove(i);
                		}
                	}
                	// 선택한 티켓의 차내식 정보 가져오기
                	ticket_food_model = new DefaultTableModel(columnNames, 0);
                	Check_Rev_DAO chkDAO = new Check_Rev_DAO();
					if (Rev_detail.chk_login) {
						chkDAO.chk_food(tnum_li, ticket_food_model);
					}else {
						chkDAO.no_mem_chk_food(tnum_li, ticket_food_model);
					}
					JTable table = new JTable(ticket_food_model);
					table.setRowHeight(80);
					table.setAutoCreateRowSorter(true);
					table.setFont(new Font("HY견고딕", Font.PLAIN, 18));
					table.getTableHeader().setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
					Rev_detail.fnb_scrollPane.setViewportView(table);
                	
				}
				
			}
		});
		
		select_chkbox.setBackground(new Color(192, 192, 192));
		select_chkbox.setVerticalAlignment(SwingConstants.CENTER);
		select_chkbox.setHorizontalAlignment(SwingConstants.CENTER);
		select_chkbox.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		select_chkbox.setBounds(0, 221, 869, 67);
		reserve_Ticket_Panel.add(select_chkbox);
		
		

	}
}
