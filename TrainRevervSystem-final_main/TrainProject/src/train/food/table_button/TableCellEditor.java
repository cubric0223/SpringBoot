package train.food.table_button;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;

import train.search.Search_Train_Panel;

public class TableCellEditor extends DefaultCellEditor {

	private TableActionEvent event;
	
	public TableCellEditor(TableActionEvent evet) {
		super(new JCheckBox());
		this.event = event;
	}


	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		
		Table_btn_panel action = new Table_btn_panel();
		action.initEvent(event, row);
		return action;
	}
}
