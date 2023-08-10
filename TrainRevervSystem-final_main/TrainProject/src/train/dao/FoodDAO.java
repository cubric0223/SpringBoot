package train.dao;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import train.Train_Main;
import train.db.OjdbcConnection;
import train.dto.FoodDTO;
import train.jungjun.No_login_join;

// 차내식 DAO
public class FoodDAO {
	
	/** 음식 DB에서 음식 전체 리스트를 가져오는 메서드 */
	public List<FoodDTO> getFoodAll() {
		
		List<FoodDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM trainfood ORDER BY food_number";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					list.add(new FoodDTO(
							rs.getString("food_number"),
							rs.getString("food_type"),
							rs.getString("food_name"),
							rs.getInt("food_price"),
							rs.getString("food_image_location")
					));
				}				
				return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void setLoginFood(List<String> foodlist, List<String> seatlist, int train_ho) {
		
		String query1 = "SELECT food_number FROM trainfood WHERE food_name = '"+foodlist.get(0)+"'";
		String query2 = "INSERT INTO ticket_mem_food VALUES(?,?,?,?)";
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				ResultSet rs2 = pstmt1.executeQuery();
			) {
				String user_code = train.jungjun.login_join_page.Login_and_joinDAO.user_code;
				
				
				if(rs2.next()) {
					pstmt2.setString(1, train_ho+seatlist.get(0)+user_code);
					pstmt2.setString(2, rs2.getString("food_number"));
					pstmt2.setInt(3, Integer.parseInt(foodlist.get(1)));
					pstmt2.setInt(4, Integer.parseInt(foodlist.get(2)));
					pstmt2.executeUpdate();
				}				
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	String user_code;
	public void setUnLoginFood(List<String> foodlist, List<String> seatlist, int train_ho) {
		String query1 = "SELECT * FROM non_mem_info WHERE phone_number = ? AND password = ?";
		String query2 = "SELECT food_number FROM trainfood WHERE food_name = ?";
		String query3 = "INSERT INTO ticket_unmem_food VALUES(?,?,?,?)";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
				PreparedStatement pstmt3 = conn.prepareStatement(query3);
			) {
				pstmt1.setString(1, Train_Main.pn5);
				pstmt1.setString(2, Train_Main.pw6);
				
				pstmt2.setString(1, foodlist.get(0));
				pstmt2.executeUpdate();
				try(ResultSet rs2 = pstmt2.executeQuery();
					ResultSet rs1 = pstmt1.executeQuery();){
					if(rs2.next() && rs1.next()) {
						user_code = rs1.getString("NO_MEM_PK");
						System.out.println("확인"+ rs1.getString(1));
						pstmt3.setString(1, train_ho+seatlist.get(0)+user_code);
						pstmt3.setString(2, rs2.getString("food_number"));
						pstmt3.setInt(3, Integer.parseInt(foodlist.get(1)));
						pstmt3.setInt(4, Integer.parseInt(foodlist.get(2)));
						pstmt3.executeUpdate();
						
					}
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/** DB로 차내식을 추가하는 메서드 */
	public boolean addFood(FoodDTO food) {
		
		UIManager.put("OptionPane.minimumSize",new Dimension(400, 400));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 35));
		
		String query1 = "SELECT * FROM trainfood WHERE food_name = '" + food.getFood_name() + "'";
		String query2 = "INSERT INTO trainfood VALUES('F' || lpad(food_number_seq.nextval, 4, '0'),?,?,?,?)";				
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
				PreparedStatement pstmt2 = conn.prepareStatement(query2);
			) {
			
				try (
					ResultSet rs = pstmt1.executeQuery()
				){
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "<html>이미 존재하는 메뉴입니다.<br>다시 입력하세요.</html>");
						return false;
					} else {
						pstmt2.setString(1, food.getfood_type());
						pstmt2.setString(2, food.getFood_name());
						pstmt2.setInt(3, food.getFood_price());
						pstmt2.setString(4, food.getImage_location()); // 이미지 파일명만...
						
						if (pstmt2.executeUpdate() == 1) {
							JOptionPane.showMessageDialog(null, "메뉴가 추가되었습니다.");
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
	
	/** DB에서 차내식 메뉴를 삭제하는 메서드 */
	public void delectFood(String foodNum) {
			
		String query = "DELETE FROM trainfood WHERE food_number = ?";		
		
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			) {

				pstmt.setString(1, foodNum);	
				
				if (pstmt.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "선택한 메뉴를 삭제하였습니다");
				}

		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	/** 차내식을 업데이트하는 메서드 */
	public boolean updateFood(FoodDTO food) {
		String query1 = "SELECT * FROM trainfood WHERE food_number = ?";
		String query2 = "UPDATE trainfood SET food_type = ?, food_name = ?, food_price = ?, food_image_location = ? WHERE food_number = ?";	
		FoodDTO original = null;
		
		try (	
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(query1);
		) {			
			pstmt1.setString(1, food.getFood_number());
			try(
					ResultSet rs = pstmt1.executeQuery();					
					PreparedStatement pstmt2 = conn.prepareStatement(query2);
			) {
				if (rs.next()) {
					original = new FoodDTO(food.getFood_number(), food.getfood_type(),food.getFood_name(), food.getFood_price(), food.getImage_location());
				} else {
					JOptionPane.showMessageDialog(null, "잘못된 메뉴를 선택하셨습니다. 메뉴를 확인해주세요.");
					return false;
				}
				
				pstmt2.setString(1, original.getfood_type().equals(food.getfood_type())? original.getfood_type(): food.getfood_type());
				pstmt2.setString(2, original.getFood_name().equals(food.getFood_name())? original.getFood_name(): food.getFood_name());
				pstmt2.setInt(3, original.getFood_price() == food.getFood_price()? original.getFood_price(): food.getFood_price());
				pstmt2.setString(4, original.getImage_location().equals(food.getImage_location())? original.getImage_location() : food.getImage_location());
				pstmt2.setString(5, food.getFood_number());
				if (pstmt2.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "메뉴 업데이트가 완료되었습니다.");
				}
				return true;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}