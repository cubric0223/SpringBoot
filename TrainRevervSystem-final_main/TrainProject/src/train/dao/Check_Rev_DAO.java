package train.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import train.TrainReserv_Main;
import train.Train_Main;
import train.db.OjdbcConnection;
import train.jungjun.login_join_page.Login_and_joinDAO;
import train.search.component.ReservBtn;

public class Check_Rev_DAO {
//   private String user_code = Login_and_joinDAO.user_code;
//   private String date = TrainReserv_Main.date_text.getText();
//   ArrayList<train.dto.Ticket_Train_DTO> train_list;

	public void no_mem_chk_train_admin(DefaultTableModel model, String ticket_code) {
		   String query = "SELECT * FROM train_unmember_ticket tt "
		            + "JOIN seat_table seat ON tt.seat_code = seat.seat_code "
		            + "JOIN train_table train ON seat.train_code = train.train_code "
		            + "JOIN train_api api ON train.train_num = api.train_num "
		            + "WHERE tt.ticket_num = ?";
		      try (
		            Connection conn = OjdbcConnection.getConnection();
		            PreparedStatement pstmt = conn.prepareStatement(query);
		         ) {
		    	  	
		    	  	System.out.println(ticket_code);
		            pstmt.setString(1, ticket_code);
		            ResultSet rs = pstmt.executeQuery();
		            
		            while(rs.next()) {
		            	Vector<Object> list = new Vector<>();
		            	list.add(rs.getString("ticket_num"));
		            	list.add(rs.getString("train_type"));
		            	list.add(rs.getString("train_num_name"));
		            	list.add(rs.getString("train_date"));
		            	list.add(rs.getString("starting_subway"));
		            	list.add(rs.getString("ending_subway"));
		            	list.add(rs.getString("start_time"));
		            	list.add(rs.getString("end_time"));
		            	list.add(rs.getString("train_ho_num"));
		            	list.add(rs.getString("seat_name"));
		            	model.addRow(list);
		            }
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   
	   }
   public void no_mem_chk_train(DefaultTableModel model, String date) {
	   String query1 = "SELECT * FROM non_mem_info WHERE phone_number = ? AND password = ?";
	   String query = "SELECT * FROM non_mem_info us "
	            + "RIGHT JOIN train_unmember_ticket tt ON us.no_mem_pk = tt.no_mem_pk "
	            + "RIGHT JOIN seat_table seat ON tt.seat_code = seat.seat_code "
	            + "RIGHT JOIN train_table train ON seat.train_code = train.train_code "
	            + "RIGHT JOIN train_api api ON train.train_num = api.train_num "
	            + "WHERE us.no_mem_pk = ? AND api.train_date = ?";
	      try (
	            Connection conn = OjdbcConnection.getConnection();
	    		PreparedStatement pstmt1 = conn.prepareStatement(query1);
	            PreparedStatement pstmt = conn.prepareStatement(query);
	         ) {
	    	  	
	    	  	pstmt1.setString(1, Train_Main.pn2);
				pstmt1.setString(2, Train_Main.pw3);
				ResultSet rs1 = pstmt1.executeQuery();
	    	  	
	    	  	if(rs1.next()) {
	    	  		System.out.println(rs1.getString("NO_MEM_PK"));
	    	  		pstmt.setString(1, rs1.getString("NO_MEM_PK"));
		            pstmt.setString(2, date);
//		            pstmt.setString(2, "20230523");
		            ResultSet rs = pstmt.executeQuery();
		            
		            while(rs.next()) {
		            	Vector<Object> list = new Vector<>();
		            	list.add(rs.getString("ticket_num"));
		            	list.add(rs.getString("train_type"));
		            	list.add(rs.getString("train_num_name"));
		            	list.add(rs.getString("train_date"));
		            	list.add(rs.getString("starting_subway"));
		            	list.add(rs.getString("ending_subway"));
		            	list.add(rs.getString("start_time"));
		            	list.add(rs.getString("end_time"));
		            	list.add(rs.getString("train_ho_num"));
		            	list.add(rs.getString("seat_name"));
		            	model.addRow(list);
		            }
	    	  	}
	            
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   
   }
   
   public void chk_train_admin(DefaultTableModel model, String user_code) {
	      String query = "SELECT * FROM train_ticket tt "
	            + "RIGHT JOIN seat_table seat ON tt.seat_code = seat.seat_code "
	            + "RIGHT JOIN train_table train ON seat.train_code = train.train_code "
	            + "RIGHT JOIN train_api api ON train.train_num = api.train_num "
	            + "WHERE tt.ticket_num_pk = ?";
	      try (
	            Connection conn = OjdbcConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	         ) {
	    	 
	            pstmt.setString(1, user_code);
//	            pstmt.setString(2, "20230523");
	            ResultSet rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	            	Vector<Object> list = new Vector<>();
	            	list.add(rs.getString("ticket_num_pk"));
	            	list.add(rs.getString("train_type"));
	            	list.add(rs.getString("train_num_name"));
	            	list.add(rs.getString("train_date"));
	            	list.add(rs.getString("starting_subway"));
	            	list.add(rs.getString("ending_subway"));
	            	list.add(rs.getString("start_time"));
	            	list.add(rs.getString("end_time"));
	            	list.add(rs.getString("train_ho_num"));
	            	list.add(rs.getString("seat_name"));
	            	model.addRow(list);
	            }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
   
   public void chk_train(DefaultTableModel model, String user_code, String date) {
      String query = "SELECT * FROM user_info us "
            + "RIGHT JOIN train_ticket tt ON us.usernum_pk = tt.usernum_pk "
            + "RIGHT JOIN seat_table seat ON tt.seat_code = seat.seat_code "
            + "RIGHT JOIN train_table train ON seat.train_code = train.train_code "
            + "RIGHT JOIN train_api api ON train.train_num = api.train_num "
            + "WHERE us.usernum_pk = ? AND api.train_date = ?";
      try (
            Connection conn = OjdbcConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
         ) {
    	 
            pstmt.setString(1, user_code);
            pstmt.setString(2, date);
//            pstmt.setString(2, "20230523");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	Vector<Object> list = new Vector<>();
            	list.add(rs.getString("ticket_num_pk"));
            	list.add(rs.getString("train_type"));
            	list.add(rs.getString("train_num_name"));
            	list.add(rs.getString("train_date"));
            	list.add(rs.getString("starting_subway"));
            	list.add(rs.getString("ending_subway"));
            	list.add(rs.getString("start_time"));
            	list.add(rs.getString("end_time"));
            	list.add(rs.getString("train_ho_num"));
            	list.add(rs.getString("seat_name"));
            	model.addRow(list);
            }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   
   
   public void chk_food(List<String> ticket_num, DefaultTableModel model) {
	      String query = "SELECT tt.ticket_num_pk, tf.food_name, seat_choice_qty, seat_choice_price FROM train_ticket tt "
	            + "LEFT JOIN ticket_mem_food memfood ON tt.ticket_num_pk = memfood.ticket_num_pk "
	            + "LEFT JOIN trainfood tf ON memfood.food_number = tf.food_number "
	            + "WHERE tt.ticket_num_pk = ?";
	      String query2 = "SELECT seat.seat_name FROM train_ticket tt "
		            + "LEFT JOIN seat_table seat ON tt.seat_code = seat.seat_code "
		            + "WHERE tt.ticket_num_pk = ?";
	      try (
	            Connection conn = OjdbcConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	    		PreparedStatement pstmt2 = conn.prepareStatement(query2);
	         ) {
	    	  	for(int i = 0; i < ticket_num.size(); ++i) {
	    	  		pstmt.setString(1, ticket_num.get(i));
	    	  		pstmt2.setString(1, ticket_num.get(i));
//		            pstmt.setString(2, TrainReserv_Main.date_text.getText());
		            ResultSet rs = pstmt.executeQuery();
		            ResultSet rs2 = pstmt2.executeQuery();
		            while(rs.next() && rs2.next()) {
		            	Vector<Object> list = new Vector<>();
		            	list.add(rs.getString("ticket_num_pk"));
		            	list.add(rs2.getString("seat_name"));
		            	list.add(rs.getString("food_name"));
		            	list.add(rs.getString("seat_choice_qty"));
		            	list.add(rs.getString("seat_choice_price"));
		            	model.addRow(list);
		            	
		            }
		            
	    	  	}
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
   public void no_mem_chk_food(List<String> ticket_num, DefaultTableModel model) {
	      String query = "SELECT tt.ticket_num, tf.food_name, seat_choice_qty, seat_choice_price FROM train_unmember_ticket tt "
	            + "LEFT JOIN ticket_unmem_food unmemfood ON tt.ticket_num = unmemfood.ticket_num "
	            + "LEFT JOIN trainfood tf ON unmemfood.food_number = tf.food_number "
	            + "WHERE tt.ticket_num = ?";
	      String query2 = "SELECT seat.seat_name FROM train_unmember_ticket tt "
		            + "LEFT JOIN seat_table seat ON tt.seat_code = seat.seat_code "
		            + "WHERE tt.ticket_num = ?";
	      try (
	            Connection conn = OjdbcConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	    		PreparedStatement pstmt2 = conn.prepareStatement(query2);
	         ) {
	    	  	for(int i = 0; i < ticket_num.size(); ++i) {
	    	  		pstmt.setString(1, ticket_num.get(i));
	    	  		pstmt2.setString(1, ticket_num.get(i));
//		            pstmt.setString(2, TrainReserv_Main.date_text.getText());
		            ResultSet rs = pstmt.executeQuery();
		            ResultSet rs2 = pstmt2.executeQuery();
		            while(rs.next() && rs2.next()) {
		            	Vector<Object> list = new Vector<>();
		            	list.add(rs.getString("ticket_num"));
		            	list.add(rs2.getString("seat_name"));
		            	list.add(rs.getString("food_name"));
		            	list.add(rs.getString("seat_choice_qty"));
		            	list.add(rs.getString("seat_choice_price"));
		            	model.addRow(list);
		            	
		            }
		            
	    	  	}
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
   public void chk_seat() {
      String query = "SELECT * FROM seat_table seat "
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
            pstmt.setString(2, "20230523");
            pstmt.setString(3, TrainReserv_Main.st_sub_btn.getText());
            pstmt.setString(4, TrainReserv_Main.en_sub_btn.getText());
            pstmt.setString(5, ReservBtn.st_time);
            pstmt.setString(6, ReservBtn.en_time);
//            List<Ticket_Check_DTO> train_dto = new ArrayList();
            try(ResultSet rs = pstmt.executeQuery(
                  );){
               while(rs.next()) {
                  System.out.println(rs.getString("seat_name"));
               }
            }
            
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}