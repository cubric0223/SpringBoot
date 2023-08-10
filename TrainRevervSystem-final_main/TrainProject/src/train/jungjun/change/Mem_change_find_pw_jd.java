package train.jungjun.change;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import train.jungjun.login_join_page.Login_and_join;
import train.jungjun.login_join_page.PW_chk;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mem_change_find_pw_jd extends JDialog {
	private JTextField pw_textField;
	private JTextField chk_pw_textField;
	
	public static String pw = "";
	public static String pw2 = "";
	
	public static String alrim = "";
	public static boolean chk = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mem_change_find_pw_jd dialog = new Mem_change_find_pw_jd();
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
	public Mem_change_find_pw_jd() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(800, 300, 600, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("비밀번호 재설정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		lblNewLabel.setBounds(100, 40, 400, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel pw_label = new JLabel("비밀번호");
		pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		pw_label.setBounds(40, 150, 150, 60);
		getContentPane().add(pw_label);
		
		pw_textField = new JTextField();
		pw_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		pw_textField.setBounds(250, 150, 300, 60);
		getContentPane().add(pw_textField);
		pw_textField.setColumns(10);
		
		JLabel chk_pw_label = new JLabel("비밀번호 확인");
		chk_pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		chk_pw_label.setBounds(40, 300, 200, 60);
		getContentPane().add(chk_pw_label);
		
		chk_pw_textField = new JTextField();
		chk_pw_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		chk_pw_textField.setBounds(250, 300, 300, 60);
		getContentPane().add(chk_pw_textField);
		chk_pw_textField.setColumns(10);
		
		JButton reset_btn = new JButton("재설정");
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw = pw_textField.getText();
				pw2 = chk_pw_textField.getText();
				if(pw.equals(pw2)) {
					chk = true;
				}else {
					chk = false;
				}
				PW_chk chk2 = new PW_chk();
				Mem_change_find_pw_jdDAO DAO = new Mem_change_find_pw_jdDAO();
				if(DAO.change_pw() && chk && chk2.pw_chk(pw)) {
					alrim = "비밀번호가 변경되었습니다";
					Mem_change_find_pw_jd_alrim alrim = new Mem_change_find_pw_jd_alrim();
					alrim.main(null);
				}else {
					alrim = "6자리이상 영어 대문자,소문자,숫자,특수문자를 포함하세요";
					Mem_change_find_pw_jd_alrim alrim = new Mem_change_find_pw_jd_alrim();
					alrim.main(null);
				}
			}
		});
		reset_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		reset_btn.setBackground(new Color(0, 128, 192));
		reset_btn.setForeground(Color.WHITE);
		reset_btn.setBounds(75, 450, 200, 60);
		getContentPane().add(reset_btn);
		
		JButton close_btn = new JButton("닫기");
		close_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		close_btn.setForeground(Color.WHITE);
		close_btn.setBackground(new Color(0, 128, 192));
		close_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		close_btn.setBounds(320, 450, 200, 60);
		getContentPane().add(close_btn);

	}

}
