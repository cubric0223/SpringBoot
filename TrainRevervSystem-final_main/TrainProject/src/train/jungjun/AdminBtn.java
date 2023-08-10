package train.jungjun;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/** JTable내부에 반환버튼생성 클래스 */
   public class AdminBtn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
      JButton ticketReturnBtn;
      private static Object value;
      public static String str;
      public AdminBtn(String text, JTable table) {
         ticketReturnBtn = new JButton();
         ticketReturnBtn.setText(text);
         ticketReturnBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
         ticketReturnBtn.setForeground(Color.white);
         ticketReturnBtn.setBackground(Color.red);
         
         ticketReturnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn() - 8;
				value = table.getValueAt(row, col);
				str = value.toString();
//				System.out.println(row+"번째 버튼");
//				System.out.println(value);
				Delete_memDAO DAO = new Delete_memDAO();
				DAO.delDAO();
				((DefaultTableModel)table.getModel()).removeRow(row);
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
         return ticketReturnBtn;
      }

      @Override
      public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
         return ticketReturnBtn;
      }

   }
