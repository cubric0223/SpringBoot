package train.food.table_button;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Table_btn_panel extends JPanel {
	private Table_button cmdonEdit;
	
	public void initEvent(TableActionEvent event, int row) {
		cmdonEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				event.onEdit(row);
				
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public Table_btn_panel() {
		setLayout(new BorderLayout(0, 0));
		
		JButton table_btn = new Table_button();
		table_btn.setText("예매");
		
		add(table_btn);
		
	}
}
