package train.food.table_button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Table_button extends JButton {
	public Table_button() {
//		setContentAreaFilled(false);
//		setBorder(new EmptyBorder(1,1,1,1));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("예매 버튼");
			}
		});
	}
}
