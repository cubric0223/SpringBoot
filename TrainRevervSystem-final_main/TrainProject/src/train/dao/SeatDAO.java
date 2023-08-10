package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import train.TrainReserv_Main;
import train.db.OjdbcConnection;
import train.search.component.ReservBtn;

public class SeatDAO {

	
	public static ArrayList <String> bookedSeatList1 = new ArrayList<>(); // 1호차에서 예약된 좌석의 목록
	public static ArrayList <String> bookedSeatList2 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList3 = new ArrayList<>();
	public static ArrayList <String> bookedSeatList4 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList5 = new ArrayList<>();
	public static ArrayList <String> bookedSeatList6 = new ArrayList<>();
	public static ArrayList <String> bookedSeatList7 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList8 = new ArrayList<>(); 
	public static ArrayList <String> bookedSeatList9 = new ArrayList<>();
	public static ArrayList <String> bookedSeatList10 = new ArrayList<>(); 
	
	
	
	/** 예매 버튼을 눌렀을 때 해당 기차에 예약된 좌석의 리스트를 가져오는 메서드*/
	public void getBookedSeats() {		
		//train_ho_num : 호차번호
		//seat_name : 좌석번호
	
		String query = "SELECT train_ho_num, seat_name FROM seat_table seat "
	              +"RIGHT JOIN train_table train ON seat.train_code = train.train_code "
	              +"RIGHT JOIN train_api api ON train.train_num = api.train_num "
	              +"WHERE api.train_type = ? AND api.train_date = ? AND "
	                  +"api.starting_subway = ? AND api.ending_subway = ? AND "
	                  +"api.start_time = ? AND api.end_time = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
		) {

			pstmt.setString(1, ReservBtn.name);
			pstmt.setString(2, TrainReserv_Main.date_text.getText());
			pstmt.setString(3, TrainReserv_Main.st_sub_btn.getText());
			pstmt.setString(4, TrainReserv_Main.en_sub_btn.getText());
			pstmt.setString(5, ReservBtn.st_time);
			pstmt.setString(6, ReservBtn.en_time);

	
			try (ResultSet rs = pstmt.executeQuery();) {
				 while(rs.next()) {

	                  if(rs.getString("train_ho_num").equals("1")) {
	                	  bookedSeatList1.add(rs.getString("seat_name"));
	                	  
	                  }else if(rs.getString("train_ho_num").equals("2")) {
	                	  bookedSeatList2.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("3")) {
	                	  bookedSeatList3.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("4")) {
	                	  bookedSeatList4.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("5")) {
	                	  bookedSeatList5.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("6")) {
	                	  bookedSeatList6.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("7")) {
	                	  bookedSeatList7.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("8")) {
	                	  bookedSeatList8.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("9")) {
	                	  bookedSeatList9.add(rs.getString("seat_name"));
	                  }
	                  else if(rs.getString("train_ho_num").equals("10")) {
	                	  bookedSeatList10.add(rs.getString("seat_name"));
	                  }
	                  
	               }

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 선택된 기차의 잔여 좌석수를 가져옴 */ 
	public String[] getTrainName() {
		String[] seatnum = new String[10];
		String query = "select train_seat_qty, train_ho_num from train_table t, train_api a "
				+ "where t.train_num = a.train_num "
				+ "and a.train_date = ? and a.starting_subway = ? and a.ending_subway = ? "
				+ "and a.start_time = ? and a.end_time = ? ";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
		) {
			pstmt.setString(1, TrainReserv_Main.date_text.getText());
			pstmt.setString(2, TrainReserv_Main.st_sub_btn.getText());
			pstmt.setString(3, TrainReserv_Main.en_sub_btn.getText());
			pstmt.setString(4, ReservBtn.st_time);
			pstmt.setString(5, ReservBtn.en_time);
			
			try( ResultSet rs = pstmt.executeQuery();){
				
					// 해당 기차가 예약된 이력이 있는 경우에만 api테이블에 해당 기차가 존재한다
					// 해당 기차가 예약된 이력이 없을 경우에는 null을 리턴하여 기본값이 나오게 한다
					//
				while (rs.next()) {
				// 해당하는 기차 정보가 DB에 존재할 경우
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					for (int i = 0; i < seatnum.length; i++) {
						if (rs.getString("train_ho_num").equals("" + (i + 1))) {
							seatnum[i] = rs.getString(1); // 잔여 좌석수
						}
					}
				}
				System.out.println("그만하자 이제 :"+Arrays.toString(seatnum));
			}
//					break;
//			rs.getString(1);
			return seatnum;
				
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
//		return seatnum;

	}

}
