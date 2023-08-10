package train.admin.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.dao.MemberDAO;

/**
 * @author KSJ
 *
 */


// 회원 티켓 관리 JTable 내부에 탈퇴 버튼 생성 클래스
public class MemQuitBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton quitBtn;
	boolean success;

	MemberDAO Memdao = new MemberDAO();

	public MemQuitBtn(String text, JTable orderTable) {

		quitBtn = new JButton();
		quitBtn.setText(text);
		quitBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		quitBtn.setForeground(Color.white);
		quitBtn.setBackground(Color.red);

		quitBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int ans = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (ans == 0) { // 확인 버튼 누르면 DB에서 회원 탈퇴됨
					int row = orderTable.getSelectedRow();
	
					String userNum = (String) orderTable.getValueAt(row, 0);
	
					success = Memdao.withdraw(userNum);
	
					if (success && orderTable.isEditing()) {
						orderTable.getCellEditor().stopCellEditing();
						((DefaultTableModel)orderTable.getModel()).removeRow(row);
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
		return quitBtn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		return quitBtn;
	}      

}
