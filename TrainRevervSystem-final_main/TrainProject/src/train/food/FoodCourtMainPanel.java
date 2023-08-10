package train.food;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import train.Payment_UI;
import train.Train_Main;
import train.dao.FoodDAO;
import train.dto.FoodDTO;
import train.food.component.FoodBtn;
import train.food.component.FoodLab;
import train.food.component.OrderTable;
import train.ticket.Rev_detail;

/**
 * @author KSJ
 *
 */


// 기차 예매 - 차내식 패널
public class FoodCourtMainPanel extends JPanel {
	// [하] 총 가격 라벨 (버튼 액션 시, 토탈 가격 바뀌어야 되서 static 설정)
	public static JLabel totalPrice_Lab;	
	public static String[] food_table;
	public static boolean closing = true;
	/** [하] 테이블에 따라 총 가격을 구하여 totalPrice 라벨에 업로드 하는 메서드 */
	public static void getTotalPrice(JTable order_table) {
		int sum = 0;
		
		for (int i = 0; i < order_table.getRowCount(); ++i) {
			int qty = 0;
			
			if (order_table.getColumnCount() != 0) {
				qty = (int) order_table.getValueAt(i, OrderTable.QTYROW);
			}
			
			sum += (int) order_table.getValueAt(i, OrderTable.PRICEROW) * qty;
		}
		totalPrice_Lab.setText(String.valueOf(sum) + "원");
	}
	
	String mainpont = "HY헤드라인M";
	
	FoodDAO foodDao = new FoodDAO();
	
	/**
	 * Create the panel.
	 */
	
	public FoodCourtMainPanel() {
		
		// ★ [하]
		
		// @ OrderTable 패널
		JPanel orderTable_panel = new JPanel();
		orderTable_panel.setVisible(true);
		orderTable_panel.setBackground(new Color(255, 255, 255));
		orderTable_panel.setBounds(90, 700, 894, 180);
		orderTable_panel.setLayout(new BorderLayout(10, 10));
		add(orderTable_panel);
		
			// @ 하단 타이틀 라벨
			JLabel orderTableMainTitle_Lab = new JLabel("【 선택한 메뉴 】");
			orderTable_panel.add(orderTableMainTitle_Lab, BorderLayout.NORTH);
			orderTableMainTitle_Lab.setFont(new Font(mainpont, Font.PLAIN, 20));
			
			// @ user_table
			OrderTable order_table = new OrderTable();
			JScrollPane user_sp = new JScrollPane(order_table);
			
			orderTable_panel.add(user_sp, BorderLayout.CENTER); // 오더 테이블 패널에 JTable 넣음
		
		// ★ [중] - 하단 total Price 때문에 [하] 밑으로 넣음
		
			// @ 메뉴 카드들을 넣을 부모 패널 (카드 레이아웃 설정됨)
			CardLayout cardLayout = new CardLayout();
			
			JPanel main_Menupanel = new JPanel();
			main_Menupanel.setLayout(cardLayout);
			main_Menupanel.setBounds(90, 139, 1306, 538);
		
		// @ 자식 패널들		
						// ＠ 1번 - 식사류 패널
						JPanel meal_panel = new JPanel();
						meal_panel.setBounds(100, 100, 1200, 2000);
						meal_panel.setBackground(new Color(255, 255, 255));
						meal_panel.setLayout(new GridLayout(0, 3));
						
							// 1번 카드 스크롤
						JScrollPane meal_sf = new JScrollPane(meal_panel);
						meal_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						meal_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						meal_sf.getVerticalScrollBar().setUnitIncrement(30);
						meal_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 2번 - 면류 패널
						JPanel noodle_panel = new JPanel();
						noodle_panel.setBounds(100, 100, 1200, 2000);
						noodle_panel.setBackground(new Color(255, 255, 255));
						noodle_panel.setLayout(new GridLayout(0, 3));
							// 2번 카드 스크롤
						JScrollPane noodle_sf = new JScrollPane(noodle_panel);
						noodle_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						noodle_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						noodle_sf.getVerticalScrollBar().setUnitIncrement(30);
						noodle_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 3번 - 간식류 패널
						JPanel snack_panel = new JPanel();
						snack_panel.setBounds(100, 100, 1200, 2000);
						snack_panel.setBackground(new Color(255, 255, 255));
						snack_panel.setLayout(new GridLayout(0, 3));
							// 3번 스크롤
						JScrollPane snack_sf = new JScrollPane(snack_panel);
						snack_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						snack_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						snack_sf.getVerticalScrollBar().setUnitIncrement(30);
						snack_sf.setBounds(90, 180, 1306, 497);
						
						// ＠ 4번 - 음료 패널
						JPanel drink_panel = new JPanel();
						drink_panel.setBounds(100, 100, 1200, 2000);
						drink_panel.setBackground(new Color(255, 255, 255));
						drink_panel.setLayout(new GridLayout(0, 3));
							// 4번 스크롤
						JScrollPane drink_sf = new JScrollPane(drink_panel);
						drink_sf.setBorder(new LineBorder(new Color(0, 128, 192), 5, true));
						drink_sf.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						drink_sf.getVerticalScrollBar().setUnitIncrement(30);
						drink_sf.setBounds(90, 180, 1306, 497);
					
		// @ 패널 내부 메뉴 버튼들						
						List<FoodDTO> allFoodList = foodDao.getFoodAll();
						FoodBtn[] foodBtns = new FoodBtn[allFoodList.size()];
						FoodLab[] foodName_Lab = new FoodLab[allFoodList.size()];
						FoodLab[] foodPrice_Lab = new FoodLab[allFoodList.size()];
						
						for (int i = 0; i < allFoodList.size(); ++i) {							
							foodBtns[i] = new FoodBtn(allFoodList.get(i), order_table);
							foodName_Lab[i] = new FoodLab(foodBtns[i].getName());
							foodPrice_Lab[i] = new FoodLab(foodBtns[i].getPrice() + "원");
							
							if (foodBtns[i].getfoodtype().equals("식사류")) {								
								meal_panel.add(foodBtns[i]);
								meal_panel.add(foodName_Lab[i]);
								meal_panel.add(foodPrice_Lab[i]);
								
							} else if (foodBtns[i].getfoodtype().equals("면류")) {
								noodle_panel.add(foodBtns[i]);
								noodle_panel.add(foodName_Lab[i]);
								noodle_panel.add(foodPrice_Lab[i]);
								
							} else if (foodBtns[i].getfoodtype().equals("간식류")) {
								snack_panel.add(foodBtns[i]);
								snack_panel.add(foodName_Lab[i]);
								snack_panel.add(foodPrice_Lab[i]);
								
							} else if (foodBtns[i].getfoodtype().equals("음료")){
								drink_panel.add(foodBtns[i]);
								drink_panel.add(foodName_Lab[i]);
								drink_panel.add(foodPrice_Lab[i]);
							}
						}						
						// @ 메뉴 부모 패널들에 자식 스크롤 추가
						main_Menupanel.add("meal", meal_sf);
						main_Menupanel.add("noodle", noodle_sf);
						main_Menupanel.add("snack", snack_sf);
						main_Menupanel.add("drink", drink_sf);
						
						add(main_Menupanel); // [중] - 끝 -
		
		// ★ [상] - card 패널 show 때문에 [중] 밑으로 두었음
			
			// @ 메뉴 버튼들
			
			JButton meal_MenuBtn = new JButton("식사류");
			JButton noodle_MenuBtn = new JButton("면류");
			JButton snack_MenuBtn = new JButton("간식류");
			JButton drink_MenuBtn = new JButton("음료");
			
			meal_MenuBtn.setForeground(Color.white);
			meal_MenuBtn.setBackground(new Color(0, 128, 192));
			meal_MenuBtn.setFont(new Font(mainpont, Font.BOLD, 40));
			meal_MenuBtn.setBounds(94,  29, 240, 80);
			meal_MenuBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					meal_MenuBtn.setForeground(Color.white);
					
					noodle_MenuBtn.setForeground(Color.LIGHT_GRAY);
					snack_MenuBtn.setForeground(Color.LIGHT_GRAY);
					drink_MenuBtn.setForeground(Color.LIGHT_GRAY);
					
					cardLayout.show(main_Menupanel, "meal");
				}
			});
			add(meal_MenuBtn);
			
			noodle_MenuBtn.setForeground(Color.LIGHT_GRAY);
			noodle_MenuBtn.setBackground(new Color(0, 128, 192));
			noodle_MenuBtn.setFont(new Font(mainpont, Font.BOLD, 40));
			noodle_MenuBtn.setBounds(440, 29, 240, 80);
			noodle_MenuBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					noodle_MenuBtn.setForeground(Color.white);
					
					meal_MenuBtn.setForeground(Color.LIGHT_GRAY);					
					snack_MenuBtn.setForeground(Color.LIGHT_GRAY);
					drink_MenuBtn.setForeground(Color.LIGHT_GRAY);	
					
					cardLayout.show(main_Menupanel, "noodle");
				}
			});
			add(noodle_MenuBtn);
			
			snack_MenuBtn.setForeground(Color.LIGHT_GRAY);
			snack_MenuBtn.setBackground(new Color(0, 128, 192));
			snack_MenuBtn.setFont(new Font(mainpont, Font.BOLD, 40));
			snack_MenuBtn.setBounds(778, 29, 240, 80);
			snack_MenuBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					snack_MenuBtn.setForeground(Color.white);
					
					meal_MenuBtn.setForeground(Color.LIGHT_GRAY);
					noodle_MenuBtn.setForeground(Color.LIGHT_GRAY);
					drink_MenuBtn.setForeground(Color.LIGHT_GRAY);
					
					cardLayout.show(main_Menupanel, "snack");
				}
			});
			add(snack_MenuBtn);
			
			drink_MenuBtn.setForeground(Color.LIGHT_GRAY);
			drink_MenuBtn.setBackground(new Color(0, 128, 192));
			drink_MenuBtn.setFont(new Font(mainpont, Font.BOLD, 40));
			drink_MenuBtn.setBounds(1148, 29, 240, 80);
			drink_MenuBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					drink_MenuBtn.setForeground(Color.white);
					
					meal_MenuBtn.setForeground(Color.LIGHT_GRAY);
					noodle_MenuBtn.setForeground(Color.LIGHT_GRAY);
					snack_MenuBtn.setForeground(Color.LIGHT_GRAY);
					
					cardLayout.show(main_Menupanel, "drink");
				}
			});
			add(drink_MenuBtn); // [상] - 끝 -
			
		// ★ [하] 총계만 써진 단순 라벨
		    JLabel total_Lab = new JLabel("총 계 :");
			total_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
			total_Lab.setBounds(742, 880, 106, 44);
			add(total_Lab);
			
			// @ FoodBtn을 누르면, 총 합계가 들어갈 가격 라벨
			totalPrice_Lab = new JLabel("0원");
			totalPrice_Lab.setFont(new Font(mainpont, Font.PLAIN, 30));
			totalPrice_Lab.setBounds(860, 880, 141, 44);
			add(totalPrice_Lab);
			
			// @ 전체 취소 버튼 누르면, JTable 내용 모두 삭제
			JButton cancel_Btn = new JButton("<html>전체<br> 취소</html>");
			cancel_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
			cancel_Btn.setForeground(Color.white);
			cancel_Btn.setBackground(new Color(0, 128, 192));
			cancel_Btn.setBounds(1016, 734, 178, 146);
			add(cancel_Btn);
			// 액션 시, 버튼 삭제
			cancel_Btn.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					((DefaultTableModel)order_table.getModel()).setRowCount(0);
					((DefaultTableModel)order_table.getModel()).fireTableDataChanged(); // 데이터 저장				
					order_table.repaint(); // 데이터 새로고침
					
					getTotalPrice(order_table); // 가격 새로고침
				}
			});
			
			// @ 다음 누르면, 다음 단계로			
			JButton select_Btn = new JButton("다음");
			select_Btn.setFont(new Font(mainpont, Font.PLAIN, 30));
			select_Btn.setForeground(Color.white);
			select_Btn.setBackground(new Color(0, 128, 192));
			select_Btn.setBounds(1218, 734, 178, 146);
			add(select_Btn);
				// 액션 시, 좌석 번호 받고 / 테이블 DB값 DB에 올리기 -> 결제 창 출력
			select_Btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					order_table.userChoiceFoods();
					if (order_table.getRowCount() == 0) {
						System.out.println("아무것도 선택 안되면 데이터 없이 다음으로 이동");
					} else {
						// 0 좌석번호, 1 음식이름, 2 가격, 3 food_number_pk, 4 수량, 5 - 버튼 (null), 6 취소 버튼 (null)
						TableModel model = order_table.getModel();
						food_table = new String[model.getRowCount()];
						for (int idx = 0; idx < model.getRowCount(); idx++) {
							String rows = "";
							String pays = "";
							for (int cdx = 0; cdx < model.getColumnCount(); cdx++) {
								Object val = model.getValueAt(idx, cdx);
								rows = rows + " " + val;
								if(cdx == 0 || cdx == 1 || cdx == 2 || cdx == 4) {
									pays = pays + model.getValueAt(idx, cdx)+ " ";
								}
							}
							food_table[idx] = pays;
							System.out.println(rows);
						}

					}
					Payment_UI pay_panel = new Payment_UI();
					pay_panel.setVisible(true);
					
				}
			});  // [하] - 끝 -
		
		// ★ 패널 기본 셋팅
		setBackground(new Color(255, 255, 255));
		setBounds(441, 80, 1483, 931);
		setLayout(null); 
	}

}