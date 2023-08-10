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

import train.TrainReserv_Main;
import train.Train_Main;

public class No_login_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No_login_alrim dialog = new No_login_alrim();
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
	public No_login_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 250, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Train_Main.alrim);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setBounds(45, 85, 800, 100);
		getContentPane().add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel(No_login_join.alrim2);
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 35));
//		lblNewLabel_1.setBounds(45, 225, 800, 100);
//		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(325, 400, 250, 100);
		getContentPane().add(btnNewButton);
		
//		JLabel lblNewLabel_2 = new JLabel("비회원 확인번호를 분실할 시 책임질 수 없습니다");
//		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
//		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_2.setBounds(55, 342, 790, 48);
//		getContentPane().add(lblNewLabel_2);

	}

}
