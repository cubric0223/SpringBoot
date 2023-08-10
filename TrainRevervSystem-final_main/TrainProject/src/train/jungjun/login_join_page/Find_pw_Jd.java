package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Find_pw_Jd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pw_chk_textField_1;
	private JTextField pw_chk_textField_2;
	public static String pw1 = "";
	public static String pw2 = "";
	
	public static String alrim = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Find_pw_Jd dialog = new Find_pw_Jd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Find_pw_Jd() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(800, 300, 600, 600);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 10, 584, 465);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel reset_pw = new JLabel("비밀번호 재설정");
		reset_pw.setHorizontalAlignment(SwingConstants.CENTER);
		reset_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		reset_pw.setBounds(100, 40, 400, 60);
		contentPanel.add(reset_pw);
		
		JLabel pw_chk_1 = new JLabel("비밀번호");
		pw_chk_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		pw_chk_1.setBounds(40, 150, 150, 60);
		contentPanel.add(pw_chk_1);
		
		JLabel pw_chk_2 = new JLabel("비밀번호 확인");
		pw_chk_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 31));
		pw_chk_2.setBounds(40, 300, 200, 60);
		contentPanel.add(pw_chk_2);
		
		pw_chk_textField_1 = new JTextField();
		pw_chk_textField_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		pw_chk_textField_1.setBounds(250, 150, 300, 60);
		contentPanel.add(pw_chk_textField_1);
		pw_chk_textField_1.setColumns(10);
		
		pw_chk_textField_2 = new JTextField();
		pw_chk_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		pw_chk_textField_2.setColumns(10);
		pw_chk_textField_2.setBounds(250, 300, 300, 60);
		contentPanel.add(pw_chk_textField_2);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 501, 584, 60);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("변경");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 128, 192));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pw1 = pw_chk_textField_1.getText();
						pw2 = pw_chk_textField_2.getText();
						ChangePW change = new ChangePW();
						PW_chk chk = new PW_chk();
						if(change.change_pw() && pw1.equals(pw2) && chk.pw_chk(pw1)) {
							alrim = "비밀번호가 변경되었습니다";
							Find_pw_jd_alrim alrim = new Find_pw_jd_alrim();
							alrim.main(null);
						}else {
							alrim = "6자리이상 영어 대문자,소문자,숫자,특수문자를 포함하세요";
							Find_pw_jd_alrim alrim = new Find_pw_jd_alrim();
							alrim.main(null);
						}
					}
				});
				okButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				okButton.setBounds(30, 0, 200, 60);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("확인");
				cancelButton.setBackground(new Color(0, 128, 192));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				cancelButton.setBounds(350, 0, 200, 60);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}