package train.jungjun.login_join_page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import train.Train_Main;

public class Find_pw_select_btn_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_pw_select_btn_alrim dialog = new Find_pw_select_btn_alrim();
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
	public Find_pw_select_btn_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(800, 300, 600, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Train_Main.alrim);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		lblNewLabel.setBounds(100, 30, 400, 100);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		btnNewButton.setBounds(200, 150, 200, 100);
		getContentPane().add(btnNewButton);

	}

}
