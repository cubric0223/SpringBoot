package train.jungjun.login_join_page;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Join_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_alrim dialog = new Join_alrim();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Join_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 250, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(JoinDAO.alrim);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 125, 850, 150);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(300, 400, 250, 100);
		getContentPane().add(btnNewButton);

	}

}
