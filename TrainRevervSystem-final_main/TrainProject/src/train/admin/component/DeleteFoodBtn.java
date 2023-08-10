package train.admin.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.dao.FoodDAO;
import train.dao.MemberDAO;
import train.dao.TicketDAO;

/**
 * @author KSJ
 *
 */


// 차내식 JTable 내부에 삭제 버튼 생성 클래스
public class DeleteFoodBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	
	JButton cancelBtn;

	TicketDAO ticketdao = new TicketDAO();
	FoodDAO fooddao = new FoodDAO();
	MemberDAO memberdao = new MemberDAO();

	public DeleteFoodBtn(String text, JTable orderTable) {
		
		cancelBtn = new JButton();
		cancelBtn.setText(text);
		cancelBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBackground(Color.red);

		cancelBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int ans = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (ans == 0) { // 확인 버튼 누르면 DB에서 차내식 삭제 및 이미지 파일도 삭제
					int row = orderTable.getSelectedRow();					
						
					String foodNum = orderTable.getValueAt(row, 0).toString();	
					String imageFileName = orderTable.getValueAt(row, 4).toString();
	
					String destinationFolder = "resource/";
					Path filePath = Paths.get(destinationFolder + imageFileName);
	
					fooddao.delectFood(foodNum);
					
					if (orderTable.isEditing()) {
						orderTable.getCellEditor().stopCellEditing();
						((DefaultTableModel)orderTable.getModel()).removeRow(row);
					}
					
					try {
						Files.delete(filePath);
					} catch (NoSuchFileException err1) {
						System.err.println("삭제하려는 파일 / 디렉토리가 없습니다");
					} catch (IOException err2) {
						err2.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return cancelBtn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		return cancelBtn;
	}      

}
