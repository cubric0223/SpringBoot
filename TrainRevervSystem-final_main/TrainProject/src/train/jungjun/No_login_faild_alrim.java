package train.jungjun;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import train.Train_Main;

public class No_login_faild_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No_login_faild_alrim dialog = new No_login_faild_alrim();
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
	public No_login_faild_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 250, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Train_Main.alrim);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setBounds(45, 150, 800, 100);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(325, 400, 250, 100);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel(Train_Main.alrim2);
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 300, 800, 90);
		getContentPane().add(lblNewLabel_1);

	}
}
