package train.search.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.TrainReserv_Main;
import train.dao.SeatDAO;
import train.seat_special.SpecialSeatSelect;
import train.seat_standard.StandardSeatSelect;
// 열차 예매 버튼 클릭시 이벤트 클래스
/**
 @author LJH
 */
public class ReservBtn  extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
	JButton reservBtn;
	String mainpont = "HY헤드라인M";
	
	private String fisrtH = "<html>";
	private String middleH = "<br> /";
	
	
	public static String name; // 기차타입
	public static String num; 
	public static String st_time; // 출발시간
	public static String en_time; // 도착시간 
	public static String price; // 가격
	public static String timetaken; // 소요시간
	public static SpecialSeatSelect sd;
	public static StandardSeatSelect sb;
	// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5

	String ho_num;
	
	public ReservBtn(String text, JTable stp_table) {
		reservBtn = new JButton();
		reservBtn.setText(text);

		reservBtn.setFont(new Font(mainpont, Font.PLAIN, 18));
		reservBtn.setForeground(Color.white);
		reservBtn.setBackground(new Color(0, 49, 74));
    	
		reservBtn.addActionListener(e -> {
				// 특실 예매시 좌석 선택 다이얼로그 출력
	    		if (text.equals("특실예매")) {
	    			System.out.println(stp_table.getSelectedRow());
	    			sd = new SpecialSeatSelect();
	    			int row = stp_table.getSelectedRow();
	    			name = (String) stp_table.getValueAt(row, 0);
	    			num = String.valueOf(stp_table.getValueAt(row, 1)) ;
	    			st_time = String.valueOf(stp_table.getValueAt(row, 2));
	    			en_time = String.valueOf(stp_table.getValueAt(row, 3));
	    			price = String.valueOf(stp_table.getValueAt(row, 4));
	    			timetaken = String.valueOf(stp_table.getValueAt(row, 5));
	    			System.out.println(en_time);
	    			price = String.valueOf(stp_table.getValueAt(row, 5));
	    			System.out.println(price);
	    			timetaken = String.valueOf(stp_table.getValueAt(row, 4));
	    			System.out.println(timetaken);
	    			sd.setVisible(true);

	    			SeatDAO seat = new SeatDAO();
	    			seat.getBookedSeats();

	    			
	    			//우등예매 버튼을 눌렀을 때 (콤보박스를 선택하지 않아도)1호차가 기본으로 표출된다
				ho_num = (String) SpecialSeatSelect.trainInfoComboBox.getSelectedItem();
				List<String> booked;
				seat.getTrainName();
				String[] seatnum;
				if (ho_num.contains("1호차")) {
					 seatnum = seat.getTrainName();
	        		 if(seatnum[0] == null) {
	        			 SpecialSeatSelect.trainInfoLabel.setText("잔여 30석 총 30석");
	        	      }else { 
	        	    	  SpecialSeatSelect.trainInfoLabel.setText("잔여 " + seatnum[0]  +"석 총 30석");
	        	      }
	        		 booked = SeatDAO.bookedSeatList1;
					for (JToggleButton button : SpecialSeatSelect.leftBtns1) {
						for (String seatname : booked) {

							if (button.getText().contains(fisrtH)) {
								String[] seatarr = button.getText().split("<|>");

								if (seatarr[2].equals(seatname.trim())) {
									button.setEnabled(false);
								}
							} else {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
					}
					for (JToggleButton button : SpecialSeatSelect.rightBtns1) {
						for (String seatname : booked ) {

							if (button.getText().contains(fisrtH)) {
								String[] seatarr = button.getText().split("<|>");

								if (seatarr[2].equals(seatname.trim())) {
									button.setEnabled(false);
								}

							} else {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
					}

				}
	    				
	    		// 일반예매 버튼 선택시 좌석 예매 다이얼로그 출력
	    		} else if (text.equals("일반예매")) {
	    			System.out.println(stp_table.getSelectedRow());
	    			sb = new StandardSeatSelect();
	    			int row = stp_table.getSelectedRow();
	    			name = (String) stp_table.getValueAt(row, 0);
	    			num = String.valueOf(stp_table.getValueAt(row, 1));
	    			st_time = String.valueOf(stp_table.getValueAt(row, 2));
	    			en_time = String.valueOf(stp_table.getValueAt(row, 3));
	    			price = String.valueOf(stp_table.getValueAt(row, 7));
	    			timetaken = String.valueOf(stp_table.getValueAt(row, 4));
	    			sb.setVisible(true);
	    			
	    			SeatDAO seat = new SeatDAO();
	    			seat.getBookedSeats();
	    			//4~10호차의 예약된 좌석 목록만 받아오면 됨
	    			ho_num = (String) StandardSeatSelect.trainInfoComboBox.getSelectedItem();
					List<String> booked;
					seat.getTrainName();
					String[] seatnum;
					if (ho_num.contains("4호차")) {
		            	  seatnum = seat.getTrainName();
		        	      if(seatnum[3] == null) {
		        	    	  StandardSeatSelect.trainInfoLabel.setText("잔여 40석 총 40석");
		        	      }else { 
		        	    	  StandardSeatSelect.trainInfoLabel.setText("잔여 " + seatnum[3] +"석 총 40석");
		        	      }


		        		 booked = SeatDAO.bookedSeatList4;
						for (JToggleButton button : StandardSeatSelect.leftBtns4) {
							for (String seatname : booked) {

								if (button.getText().contains(fisrtH)) {
									String[] seatarr = button.getText().split("<|>");

									if (seatarr[2].equals(seatname.trim())) {
										button.setEnabled(false);
									}
								} else {
									if (button.getText().equals(seatname.trim())) {
										button.setEnabled(false);
									}
								}
							}
						}
						for (JToggleButton button : StandardSeatSelect.rightBtns4) {
							for (String seatname : booked) {

								if (button.getText().contains(fisrtH)) {
									String[] seatarr = button.getText().split("<|>");

									if (seatarr[2].equals(seatname.trim())) {
										button.setEnabled(false);
									}

								} else {
									if (button.getText().equals(seatname.trim())) {
										button.setEnabled(false);
									}
								}
							}
						}

					
					}

					
	    			// 수량 - 1
//	    			int minusQty = (int) reserv_dtm.getValueAt(rev_table.getSelectedRow(), 3) - 1;	
//	    			
//	    			if (minusQty < 1) {
//	    				minusQty = 1;
//	    			}		
//	    			reserv_dtm.setValueAt(minusQty, rev_table.getSelectedRow(), 3);
	    		}
		});
	}
    			
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return reservBtn;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return reservBtn;
	}

}
