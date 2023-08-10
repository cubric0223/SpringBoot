package train.jungjun.admin_page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Admin_page extends JFrame {

	private JPanel contentPane;
	private JTextField id_textField;
	private JPasswordField pw_passwordField;
	ImageIcon img1 = new ImageIcon
			("C:/java_PJJ/Java_project_Jungjun/Application/images/E-RAIL.png");
			//("C:/Users/USER/git/TrainRevervSystem/TrainProject/images/E-RAIL.png");
	ImageIcon img2 = new ImageIcon
	("C:/java_PJJ/Java_project_Jungjun/Application/images/back.png");
			//("C:/Users/USER/git/TrainRevervSystem/TrainProject/images/back.png");
	
	private JPanel login;
	public static String id = "";
	public static String pw = "";
	
	Image img = img1.getImage();
 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
    ImageIcon updateIcon = new ImageIcon(updateImg);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page frame = new Admin_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_page() {
		//frame = new JFrame();
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		login = new JPanel();
		login.setBackground(Color.WHITE);
		login.setBounds(0, 0, 1920, 1080);
		getContentPane().add(login);
		login.setLayout(null);
		
		JLabel id_label = new JLabel("아이디");
		id_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_label.setBounds(600, 500, 200, 100);
		login.add(id_label);
		
		JLabel pw_label = new JLabel("비밀번호");
		pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pw_label.setBounds(600, 650, 250, 100);
		login.add(pw_label);
		
		id_textField = new JTextField();
		id_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_textField.setBounds(900, 500, 400, 100);
		login.add(id_textField);
		id_textField.setColumns(10);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 50));
		pw_passwordField.setBounds(900, 650, 400, 100);
		login.add(pw_passwordField);
		
		JButton check_btn = new JButton("로그인");
		check_btn.setForeground(Color.WHITE);
		check_btn.setBackground(new Color(0, 128, 192));
		check_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				id = id_textField.getText();
				pw = pw_passwordField.getText();
				
				Admin_pageDAO dao = new Admin_pageDAO();
				boolean login_result = dao.login_chk();
				System.out.println(login_result);
			}	
		});
		check_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		check_btn.setBounds(600, 800, 700, 100);
		login.add(check_btn);
		
		JLabel E_RAIL = new JLabel(updateIcon);
		E_RAIL.setBounds(750, 20, 400, 330);
		login.add(E_RAIL);
		
		JButton back_main_btn2 = new JButton(img2);
		back_main_btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.Train_Main main_frame =
						new train.Train_Main();
				main_frame.main(null);
				dispose();
			}
		});
		back_main_btn2.setBounds(10, 10, 136, 136);
		login.add(back_main_btn2);
		back_main_btn2.setBorderPainted(false);
		back_main_btn2.setContentAreaFilled(false);
		back_main_btn2.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("관리자 로그인");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(750, 375, 400, 100);
		login.add(lblNewLabel);
	}

}
