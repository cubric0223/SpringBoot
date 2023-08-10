package train.dao;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.db.OjdbcConnection;
import train.dto.MemberDTO;

// 회원 DAO
public class MemberDAO {

	/** 회원 조회 메서드 */
	public MemberDTO getMember(String phoneNum) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 35));
		
		MemberDTO dto = null;
		String query ="SELECT * FROM user_info WHERE phone_number = '" + phoneNum + "'";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		) {	
			
				if (!rs.next()) {
					JOptionPane.showMessageDialog(null, "회원 정보가 존재하지 않습니다.");
					return null;
				} else {
					dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(4)
							, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
					return dto;
				}
				
		} catch (NullPointerException e1) {
			return null;
		} catch (SQLException e2) {
			return null;
		}
	}

	/** 비회원 조회 메서드 */
	public List<String> getNoMember(String phoneNum) {
		
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 35));
		
		List<String> nomember = new ArrayList<>();
		String query ="SELECT * FROM non_mem_info WHERE phone_number = '" + phoneNum + "'";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		) {
			if(!rs.next()) {	
				JOptionPane.showMessageDialog(null, "비회원 정보가 존재하지 않습니다.");
				return null;
			} else {				
				nomember.add(rs.getString("no_mem_pk"));
				nomember.add(rs.getString("phone_number"));
				return nomember;				
			}

		} catch (NullPointerException e1) {
			return null;
		} catch (SQLException e2) {
			return null;
		}
	}

	/** 회원 탈퇴 메서드 */
	public boolean withdraw(String usernum_pk) {

		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 35));

		String query1 = "SELECT COUNT(*) FROM train_ticket WHERE usernum_pk = '"+ usernum_pk +"'";		
		String query2 = "DELETE user_info WHERE usernum_pk = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				ResultSet rs = pstmt1.executeQuery();
				PreparedStatement pstmt2= conn.prepareStatement(query2);
				) {				
			if (rs.next()) {

				if (rs.getInt(1) > 0) {
					JOptionPane.showMessageDialog(null,"구매 티켓이 존재합니다. 티켓 환불을 먼저 진행해주세요.");
					return false;
				} else {
					pstmt2.setString(1, usernum_pk);
					if(pstmt2.executeUpdate() == 1) {
						JOptionPane.showMessageDialog(null,"회원을 삭제하였습니다");
						return true;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
