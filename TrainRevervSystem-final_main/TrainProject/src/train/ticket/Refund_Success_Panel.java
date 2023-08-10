package train.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.dao.TicketDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
// 티켓 반환이 성공 했을때 다이얼로그
public class Refund_Success_Panel extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Refund_Success_Panel dialog = new Refund_Success_Panel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Refund_Success_Panel() {
		setBounds(100, 100, 717, 623);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel refund_Remind = new JLabel("환불요청이 완료되었습니다.");
			refund_Remind.setVerticalAlignment(SwingConstants.CENTER);
			refund_Remind.setHorizontalAlignment(SwingConstants.CENTER);
			refund_Remind.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
			refund_Remind.setBounds(12, 10, 677, 330);
			contentPanel.add(refund_Remind);
		}
		{
			JButton btnNewButton = new JButton("처음으로");
			btnNewButton.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(12, 350, 677, 224);
			btnNewButton.setBackground(new Color(64, 0, 64));
			contentPanel.add(btnNewButton);
		}
	}

}
