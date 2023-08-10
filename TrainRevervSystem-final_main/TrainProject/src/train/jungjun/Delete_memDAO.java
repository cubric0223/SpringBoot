package train.jungjun;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;

public class Delete_memDAO {
	 
	public void delDAO() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query = "DELETE user_info WHERE usernum_pk =?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {
				pstmt.setString(1, AdminBtn.str);
				
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"회원을 삭제하였습니다");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
