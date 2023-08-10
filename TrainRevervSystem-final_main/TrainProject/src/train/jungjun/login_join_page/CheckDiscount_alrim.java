package train.jungjun.login_join_page;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CheckDiscount_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckDiscount_alrim dialog = new CheckDiscount_alrim();
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
	public CheckDiscount_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(550,250,900,600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(CheckDiscount.alrim);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 125, 800, 100);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(300, 400, 250, 100);
		getContentPane().add(btnNewButton);

	}

}
