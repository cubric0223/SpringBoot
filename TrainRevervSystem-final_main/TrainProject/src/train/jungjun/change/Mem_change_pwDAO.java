package train.jungjun.change;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.Train_Main;
import train.db.OjdbcConnection;

public class Mem_change_pwDAO {
	public boolean find_pw() {
		String query ="SELECT * FROM user_info WHERE id =? AND name=? AND phone_number=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {			
				pstmt.setString(1, Train_Main.id7);
				pstmt.setString(2, Train_Main.name5);
				pstmt.setString(3, Train_Main.pn7);
				
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
