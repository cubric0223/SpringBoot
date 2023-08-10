package train.jungjun.login_join_page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.Train_Main;
import train.db.OjdbcConnection;

public class ChangePW {
	
	public boolean change_pw() {
		String query ="UPDATE user_info SET password =? WHERE id =?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {					
				pstmt.setString(1, Find_pw_Jd.pw1);
				pstmt.setString(2, Train_Main.id3);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}