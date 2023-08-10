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

import train.dao.TicketDAO;

/**
 * @author KSJ
 *
 */


// 회원 티켓 관리 JTable 내부에 반환 버튼 생성 클래스
public class MemRefundBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton cancelBtn;
	boolean success;

	TicketDAO ticketdao = new TicketDAO();

	public MemRefundBtn(String text, JTable orderTable) {

		cancelBtn = new JButton();
		cancelBtn.setText(text);
		cancelBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		cancelBtn.setForeground(Color.white);
		cancelBtn.setBackground(Color.red);

		cancelBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int ans = JOptionPane.showConfirmDialog(null, "정말 반환하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (ans == 0) { // 확인 버튼 누르면 티켓 반환됨
					int row = orderTable.getSelectedRow();
	
					String ticketNum = String.valueOf(orderTable.getValueAt(orderTable.getSelectedRow(), 0));
					int trainNum = (int) orderTable.getValueAt(orderTable.getSelectedRow(), 2);
	
					success = ticketdao.refundMemTicket(ticketNum, trainNum);
	
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
		return cancelBtn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		return cancelBtn;
	}      

}
