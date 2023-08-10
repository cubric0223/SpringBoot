package train.jungjun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.db.OjdbcConnection;

public class MemDAO {
	public void memDAO() {
		String query ="SELECT * FROM user_info";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				try(ResultSet rs = pstmt.executeQuery();){
					while(rs.next()) {
						String mn = rs.getString(1);
						String id = rs.getString(2);
						//String pw = rs.getString(3);
						String name = rs.getString(4);
						String pn = rs.getString(5);
						String bd = rs.getString(6);
						String email = rs.getString(7);
						String pt = rs.getString(8);
						
						String data[] = {mn,id,name,pn,bd,email,pt};
						Admin_page_mem.model.addRow(data);
					}
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
