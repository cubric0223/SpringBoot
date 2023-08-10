package train.jungjun.login_join_page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.Train_Main;
import train.db.OjdbcConnection;

public class Find_pwDAO {
	
	public boolean find_pw() {
		String query ="SELECT * FROM user_info WHERE id =? AND name=? AND phone_number=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {			
				pstmt.setString(1, Train_Main.id3);
				pstmt.setString(2, Train_Main.name2);
				pstmt.setString(3, Train_Main.pn4);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return true;
					}else {
						return false;
					}
				}		
		}catch(Exception e) {
		e.printStackTrace();
		return false;
		}
	}
}

