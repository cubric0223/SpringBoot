package train.food.table_button;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument.Content;

public class TableCellReader extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Table_btn_panel action = new Table_btn_panel();
		return action;
	}
}
