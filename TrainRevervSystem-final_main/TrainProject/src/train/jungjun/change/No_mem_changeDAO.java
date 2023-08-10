package train.jungjun.change;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

import train.TrainReserv_Main;
import train.Train_Main;
import train.db.OjdbcConnection;
import train.ticket.Rev_detail;

public class No_mem_changeDAO {
	public static String alrim = "";
	public static String pk;
	public boolean NCDAO() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query = "SELECT * FROM non_mem_info WHERE phone_number =? AND password =?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {					
				pstmt.setString(1, Train_Main.pn2);
				pstmt.setString(2, Train_Main.pw3);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
//						alrim = "로그인에 성공했습니다";
//						No_mem_changeDAO_alrim alrim = new No_mem_changeDAO_alrim();
//						alrim.main(null);
						Rev_detail rev_search = new Rev_detail();
						rev_search.chk_login = false;
						rev_search.chk_search = false;
						rev_search.main(null);
						pk = rs.getString("no_mem_pk");
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						No_mem_changeDAO_alrim alrim = new No_mem_changeDAO_alrim();
						alrim.main(null);
						return false;
					}
				}
		} catch (Exception e) {
			alrim = "로그인에 실패했습니다_2";
			No_mem_changeDAO_alrim alrim = new No_mem_changeDAO_alrim();
			alrim.main(null);
			e.printStackTrace();
			return false;
		}
	}
}
