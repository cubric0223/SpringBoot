package train.jungjun.change;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.Train_Main;
import train.db.OjdbcConnection;

public class Mem_change_find_pw_jdDAO {
	public boolean change_pw() {
		String query ="UPDATE user_info SET password =? WHERE id =?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {	
				if(Mem_change_find_pw_jd.chk) {
					pstmt.setString(1, Mem_change_find_pw_jd.pw);
					pstmt.setString(2, Train_Main.id7);
					
					try(ResultSet rs = pstmt.executeQuery();){
						if(rs.next()) {
							return true;
						}else {
							return false;
						}
					}
				}
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
