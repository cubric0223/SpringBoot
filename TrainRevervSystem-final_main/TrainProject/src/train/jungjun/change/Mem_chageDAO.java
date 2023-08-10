package train.jungjun.change;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

import train.Train_Main;
import train.db.OjdbcConnection;
import train.ticket.Rev_detail;

public class Mem_chageDAO {
	public static String alrim = "";
	public static String user_code;
	public boolean DAO() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query ="SELECT * FROM user_info WHERE id =? AND password=?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, Train_Main.id6);
				pstmt.setString(2, Train_Main.pw7);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
//						alrim = "로그인에 성공했습니다";
//						Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
						user_code = rs.getString("usernum_pk");
//						mca.main(null);
						Rev_detail rev_search = new Rev_detail();
						rev_search.chk_login = true;
						rev_search.chk_search = false;
						rev_search.main(null);
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
						mca.main(null);
						return false;
					}
				}
		}catch(Exception e) {
			alrim = "로그인에 실패했습니다_2";
			Mem_changeDAO_alrim mca = new Mem_changeDAO_alrim();
			mca.main(null);
			e.printStackTrace();
			return false;
		}
	}
}
