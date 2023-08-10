package train.jungjun.login_join_page;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

import train.Train_Main;
import train.db.OjdbcConnection;
// 사용
public class CheckDAO {
	String chk = Train_Main.id4;
	boolean result4 = chk.matches("^\\W*\\w*\\W*$");
	boolean result1 = chk.matches("^\\w*admin+\\w*$");
	boolean result2 = chk.matches("^\\w*Admin+\\w*$");
	boolean result3 = chk.matches("^\\w*ADMIN+\\w*$");
	boolean result5 = chk.matches("^\\w*\\W*\\w*$");
	
	public static String alrim = "";
	
	public void id_check() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		String query = "SELECT * FROM user_info WHERE id = ?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1,Train_Main.id4);
			
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						alrim = "이미 존재하는 아이디입니다";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}else if(!(rs.next()) && chk.equals("")){
						alrim = "아이디를 입력하세요";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}else if(!(rs.next()) && (result1 || result2 || result3)){
						alrim = "admin은 사용할 수 없는 아이디입니다";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}else if(!(rs.next()) && (!(result4 || result5))) {
						alrim = "영문과 숫자만 입력하세요";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}else if(!(rs.next())){
						alrim = "중복 없는 아이디 입니다";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}else {
						alrim = "도대체 무슨 짓을 한거죠?";
						CheckDAO_alrim alrim = new CheckDAO_alrim();
						alrim.main(null);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}