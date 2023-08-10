package train.jungjun;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.Second_main;
import train.TrainReserv_Main;
import train.Train_Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class No_login_join extends JFrame {

	private JPanel panel;
	private JTextField num_textField;
	private JPasswordField pw_passwordField;
	public static String phone_num = "";
	public static String pw = "";
	
	public static String alrim = "";
	public static String alrim2 = "";
	
	static No_login_join frame = new No_login_join();
	
	public void runApplication() {
        // 애플리케이션 실행에 필요한 로직 작성
    	if(GoMain.close) {
			frame.dispose();
		}
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//No_login_join frame = new No_login_join();
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
	public No_login_join() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		
		ImageIcon img1 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/E-RAIL.png");
		ImageIcon img2 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/back.png");
		ImageIcon img3 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/home.png");
		
		Image img = img1.getImage();
	 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
	    ImageIcon updateIcon = new ImageIcon(updateImg);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel num_label = new JLabel("전화번호");
		num_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		num_label.setBounds(600, 500, 175, 100);
		panel.add(num_label);
		
		num_textField = new JTextField();
		num_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		num_textField.setBounds(900, 500, 500, 100);
		panel.add(num_textField);
		num_textField.setColumns(10);
		
		JLabel pw_label = new JLabel("티켓 확인 비밀번호");
		pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		pw_label.setBounds(500, 650, 350, 100);
		panel.add(pw_label);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 40));
		pw_passwordField.setBounds(900, 650, 350, 100);
		panel.add(pw_passwordField);
		
		JLabel lblNewLabel = new JLabel("비밀번호는 4자리입니다");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		lblNewLabel.setBounds(1300, 650, 350, 100);
		panel.add(lblNewLabel);
		
		JButton check_btn = new JButton("확인");
		check_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phone_num = num_textField.getText();
				pw = pw_passwordField.getText();
				No_login_joinDAO DAO = new No_login_joinDAO();
				No_login_join_Num_chk nchk  = new No_login_join_Num_chk();
				No_login_join_pw_chk pchk = new No_login_join_pw_chk();
				if(DAO.no_loginDAO()) {
//					alrim = "비회원 가입에 성공했습니다";
//					No_login_alrim alrim = new No_login_alrim();
//					alrim.main(null);
//					System.out.println("비회원 가입 성공 여부 " + DAO.no_loginDAO());
					Train_Main.card.show(Train_Main.card_panel, "loading");
					TrainReserv_Main reserv_main = new TrainReserv_Main();
					reserv_main.login_who = false;
					reserv_main.main(null);
				}else if(!nchk.num_chk()) {
					alrim = "전화번호를 정확히 입력하세요";
					No_login_alrim alrim = new No_login_alrim();
					alrim.main(null);
					System.out.println("비회원 가입 성공 여부 " + DAO.no_loginDAO());
				}else if(!pchk.pw_chk()) {
					alrim = "비밀번호를 정확히 입력하세요";
					No_login_alrim alrim = new No_login_alrim();
					alrim.main(null);
					System.out.println("비회원 가입 성공 여부 " + DAO.no_loginDAO());
				}else {
					alrim = "비회원 가입에 실패했습니다";
					alrim2 = "(같은 전화번호를 입력하지 마세요)";
					No_login_faild_alrim alrim = new No_login_faild_alrim();
					alrim.main(null);
					System.out.println("비회원 가입 성공 여부 " + DAO.no_loginDAO());
				}
			}
		});
		check_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		check_btn.setBackground(new Color(0, 128, 192));
		check_btn.setForeground(Color.WHITE);
		check_btn.setBounds(500, 878, 900, 100);
		panel.add(check_btn);
		
		JLabel E_RAIL = new JLabel(updateIcon);
		E_RAIL.setBounds(800, 80, 400, 330);
		panel.add(E_RAIL);
		
		JButton back_btn = new JButton(img2);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second_main main2 = new Second_main();
				main2.main(null);
				dispose();
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		panel.add(back_btn);
		
		JButton home_btn = new JButton(img3);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoMain gomain = new GoMain();
				gomain.setVisible(true);
			}
		});
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		home_btn.setBounds(1795, 10, 109, 109);
		panel.add(home_btn);
		
		JLabel no_mem_label = new JLabel("비회원 예매");
		no_mem_label.setHorizontalAlignment(SwingConstants.CENTER);
		no_mem_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		no_mem_label.setBounds(190, 30, 350, 100);
		panel.add(no_mem_label);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
