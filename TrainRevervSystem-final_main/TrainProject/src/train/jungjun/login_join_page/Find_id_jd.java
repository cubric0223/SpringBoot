package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Find_id_jd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static boolean gopwfind = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Find_id_jd dialog = new Find_id_jd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Find_id_jd() {
		setBounds(800, 300, 600, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 584, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		Find_id_jdDAO DAO = new Find_id_jdDAO();
		JLabel show_id = new JLabel("아이디는 "+ DAO.find_id() + "입니다");
		show_id.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		show_id.setBounds(40, 80, 500, 75);
		contentPanel.add(show_id);
		
//		JButton okButton = new JButton("비밀번호 찾기");
//		okButton.setBounds(25, 190, 250, 60);
//		okButton.setBackground(new Color(0, 128, 192));
//		okButton.setForeground(Color.WHITE);
//		okButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Login_and_join.gofindpw = true;
//				Login_and_join and = new Login_and_join();
//				and.main(null);
//				dispose();
//			}
//		});
//		okButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
//		contentPanel.add(okButton);
		
		JButton cancelButton = new JButton("닫기");
		cancelButton.setBounds(135, 190, 250, 60);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(new Color(0, 128, 192));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		contentPanel.add(cancelButton);	
	}
}