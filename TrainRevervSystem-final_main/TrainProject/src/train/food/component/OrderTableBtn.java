package train.food.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import train.food.FoodCourtMainPanel;

/**
 * @author KSJ
 *
 */


// 차내식 하단 JTable에 들어갈 +, - , x 버튼
public class OrderTableBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer, MouseListener {
    
	JButton count_Btn;
	JTable user_table;
	String mainpont = "HY헤드라인M";
	
    public OrderTableBtn(String text, JTable user_table) {
    	this.user_table = user_table;
    	
    	count_Btn = new JButton();
    	count_Btn.setText(text);

    	count_Btn.setFont(new Font(mainpont, Font.PLAIN, 18));
    	count_Btn.setForeground(Color.white);
    	count_Btn.setBackground(new Color(0, 49, 74));
    	
    	count_Btn.addMouseListener(this);
    	
    	count_Btn.addActionListener(e -> {
    		
    		if (text.equals("+")) {
    			// 수량 + 1
    			int addQty = (int) user_table.getValueAt(user_table.getSelectedRow(), OrderTable.QTYROW) + 1;	
    			
    			if (addQty < 1) {
    				addQty = 1;
    			}
    			
    			user_table.setValueAt(addQty, user_table.getSelectedRow(), OrderTable.QTYROW);
    			
    		} else if (text.equals("-")) {
    			// 수량 - 1
    			int minusQty = (int) user_table.getValueAt(user_table.getSelectedRow(), OrderTable.QTYROW) - 1;	
    			
    			if (minusQty < 1) {
    				minusQty = 1;
    			}		
    			user_table.setValueAt(minusQty, user_table.getSelectedRow(), OrderTable.QTYROW);
    			
    		} else if (text.equals("X")) {	    			
    			
    			// 테이블 행 삭제 전에, 테이블 변경을 중지하고 삭제 진행	
    			if (user_table.isEditing()) {
    				user_table.getCellEditor().stopCellEditing();
    				((DefaultTableModel)user_table.getModel()).removeRow(user_table.getSelectedRow());
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
        return count_Btn;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        return count_Btn;
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FoodCourtMainPanel.getTotalPrice(user_table); // 버튼 액션 시, 총 가격 업데이트
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}	
}