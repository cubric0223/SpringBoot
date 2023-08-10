package train.jungjun.change;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.jungjun.Change_main;
import train.jungjun.GoMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class No_mem_change extends JFrame {

	private JPanel contentPane;
	public static String pn = "";
	public static String pw = "";
	
	ImageIcon img1 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/E-RAIL.png");
	ImageIcon img2 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/back.png");
	ImageIcon img3 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/home.png");
	
	Image img = img1.getImage();
 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
    ImageIcon updateIcon = new ImageIcon(updateImg);
    private JTextField pn_textField;
    private JPasswordField pw_passwordField;
    
    static No_mem_change frame = new No_mem_change();
    
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
					//No_mem_change frame = new No_mem_change();
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
	public No_mem_change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel(updateIcon);
		logo.setBounds(800, 40, 400, 330);
		contentPane.add(logo);
		
		JButton back_btn = new JButton(img2);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.Change_main cmain = new Change_main();
				cmain.main(null);
				dispose();
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		contentPane.add(back_btn);
		
		JButton home_btn = new JButton(img3);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.GoMain gomain = new GoMain();
				gomain.main(null);
			}
		});
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		home_btn.setBounds(1795, 10, 109, 109);
		contentPane.add(home_btn);
		
		JLabel no_mem_look_up = new JLabel("비회원 조회");
		no_mem_look_up.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		no_mem_look_up.setHorizontalAlignment(SwingConstants.CENTER);
		no_mem_look_up.setBounds(190, 30, 350, 100);
		contentPane.add(no_mem_look_up);
		
		JLabel pn_label = new JLabel("전화번호");
		pn_label.setHorizontalAlignment(SwingConstants.TRAILING);
		pn_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		pn_label.setBounds(487, 500, 363, 100);
		contentPane.add(pn_label);
		
		pn_textField = new JTextField();
		pn_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pn_textField.setBounds(900, 500, 500, 100);
		contentPane.add(pn_textField);
		pn_textField.setColumns(10);
		
		JLabel t_pw = new JLabel("티켓 확인 비밀번호");
		t_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		t_pw.setBounds(500, 650, 350, 100);
		contentPane.add(t_pw);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 40));
		pw_passwordField.setBounds(900, 650, 350, 100);
		contentPane.add(pw_passwordField);
		
		JLabel lblNewLabel = new JLabel("비밀번호는 4자리입니다");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		lblNewLabel.setBounds(1300, 650, 350, 100);
		contentPane.add(lblNewLabel);
		
		JButton select_btn = new JButton("확인");
		select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn = pn_textField.getText();
				pw = pw_passwordField.getText();
				No_mem_changeDAO DAO = new No_mem_changeDAO();
				boolean result = DAO.NCDAO();
				System.out.println("로그인 여부" + result);
			}
		});
		select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		select_btn.setForeground(Color.WHITE);
		select_btn.setBackground(new Color(0, 128, 192));
		select_btn.setBounds(500, 850, 900, 100);
		contentPane.add(select_btn);
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
