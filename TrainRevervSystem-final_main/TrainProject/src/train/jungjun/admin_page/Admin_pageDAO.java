package train.jungjun.admin_page;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;

public class Admin_pageDAO {
	public static String alrim = "";
	
	public boolean login_chk() {
		String query ="SELECT * FROM admin_info WHERE admin_num_pk = ? AND admin_pw = ?";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
				pstmt.setString(1, train.Train_Main.id);
				pstmt.setString(2, train.Train_Main.pw);
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						alrim = "로그인에 성공했습니다";
						Admin_pageDAO_alrim alrim = new Admin_pageDAO_alrim();
						alrim.main(null);
						return true;
					}else {
						alrim = "로그인에 실패했습니다_1";
						Admin_pageDAO_alrim alrim = new Admin_pageDAO_alrim();
						alrim.main(null);
						return false;
					}
				}catch(Exception e) {
					alrim = "로그인에 실패했습니다_2";
					Admin_pageDAO_alrim alrim = new Admin_pageDAO_alrim();
					alrim.main(null);
					e.printStackTrace();
					return false;
				}
		}catch(Exception e) {
			alrim = "로그인에 실패했습니다_3";
			Admin_pageDAO_alrim alrim = new Admin_pageDAO_alrim();
			alrim.main(null);
			e.printStackTrace();
			return false;
		}
	}
}