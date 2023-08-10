package train.jungjun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import train.TrainReserv_Main;
import train.Train_Main;
import train.db.OjdbcConnection;

public class No_login_joinDAO {
	public static String pk;
	public boolean no_loginDAO() {
		No_login_join_Num_chk nchk = new No_login_join_Num_chk();
		No_login_join_pw_chk pchk = new No_login_join_pw_chk();
		String query = 
				"INSERT INTO non_mem_info (phone_number,password,no_mem_pk) VALUES (?,?,ZBF_GET_SEQ_NO_MEM('next'))";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {	
				if(nchk.num_chk() && pchk.pw_chk()) {
					pstmt.setString(1, Train_Main.pn5);
				pstmt.setString(2, Train_Main.pw6);
				pstmt.executeUpdate();
				return true;
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
