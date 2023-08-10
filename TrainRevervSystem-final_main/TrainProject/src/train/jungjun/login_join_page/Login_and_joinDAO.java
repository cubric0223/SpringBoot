package train.jungjun.login_join_page;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

import train.TrainReserv_Main;
import train.Train_Main;
import train.db.OjdbcConnection;

// 사용

public class Login_and_joinDAO {
	public static String alrim = "";
	public static String user_code;
	public static String preferential = null;
	public boolean login_chk() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query ="SELECT * FROM user_info WHERE id =? AND password=?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, Train_Main.id2);
				pstmt.setString(2, Train_Main.pw4);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
//						alrim = "로그인에 성공하셨습니다";
//						Login_alrim alrim = new Login_alrim();
						user_code = rs.getString("usernum_pk");
						preferential = rs.getString("PREFERENTIAL_TREATMENT");
						Train_Main.card.show(Train_Main.card_panel, "loading");
						TrainReserv_Main reserv_main = new TrainReserv_Main();
						reserv_main.main(null);
//						alrim.main(null);
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						Login_alrim alrim = new Login_alrim();
						alrim.main(null);
						return false;
					}
				}catch(Exception e) {
					alrim = "로그인에 실패했습니다_2";
					Login_alrim alrim = new Login_alrim();
					alrim.main(null);
					e.printStackTrace();
					return false;
				}
		}catch(Exception e) {
			alrim = "로그인에 실패했습니다_3";
			Login_alrim alrim = new Login_alrim();
			alrim.main(null);
			e.printStackTrace();
			return false;
		}
	}
	
	
}