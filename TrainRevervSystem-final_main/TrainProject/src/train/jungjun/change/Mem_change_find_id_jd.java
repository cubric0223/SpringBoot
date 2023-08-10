package train.jungjun.change;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Mem_change_find_id_jd extends JDialog {
	
	public static boolean gofindpw = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mem_change_find_id_jd dialog = new Mem_change_find_id_jd();
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
	public Mem_change_find_id_jd() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(800, 300, 600, 300);
		getContentPane().setLayout(null);
		
		Mem_change_find_id_jdDAO DAO = new Mem_change_find_id_jdDAO();
		JLabel lblNewLabel = new JLabel("아이디는 "+ DAO.find_id() + "입니다");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		lblNewLabel.setBounds(40, 80, 500, 75);
		getContentPane().add(lblNewLabel);
		
//		JButton btnNewButton = new JButton("비밀번호 찾기");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				gofindpw = true;
//				dispose();
//			}
//		});
//		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
//		btnNewButton.setBounds(10, 200, 250, 50);
//		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 128, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		btnNewButton_1.setBounds(150, 200, 250, 50);
		getContentPane().add(btnNewButton_1);

	}

}
