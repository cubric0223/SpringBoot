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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class Mem_change extends JFrame {

	private JPanel contentPane;
	public static String id = "";
	public static String pw = "";
	
	public static String name = "";
	public static String pn = "";
	
	public static String id2 ="";
	public static String name2 ="";
	public static String pn2 ="";
	
	public static String alrim = "";
	
	ImageIcon img1 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/E-RAIL.png");
	ImageIcon img2 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/back.PNG");
	ImageIcon img3 = new ImageIcon
			("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/home.png");
	Image img = img1.getImage();
 	Image updateImg = img.getScaledInstance(400, 330, Image.SCALE_SMOOTH);
    ImageIcon updateIcon = new ImageIcon(updateImg);
    private JTextField id_textField;
    private JPasswordField pw_passwordField;
    
    static Mem_change frame = new Mem_change();
    private JTextField name_textField;
    private JTextField pn_textField;
    private JTextField id_textField_2;
    private JTextField name_textField_3;
    private JTextField pn_textField_3;
    
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
					//Mem_change frame = new Mem_change();
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
	public Mem_change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1920, 1080);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		login.setBackground(Color.WHITE);
		layeredPane.add(login, "name_1049015325295800");
		login.setLayout(null);
		
		JLabel logo = new JLabel(updateIcon);
		logo.setLocation(750, 30);
		logo.setSize(400, 330);
		login.add(logo, "name_1049015133618400");
		
		JButton home_btn = new JButton(img3);
		home_btn.setSize(109, 109);
		home_btn.setLocation(1800, 10);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.GoMain gomain = new GoMain();
				gomain.main(null);
			}
		});
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		login.add(home_btn);
		
		JButton back_btn = new JButton(img2);
		back_btn.setSize(136, 136);
		back_btn.setLocation(10, 10);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.Change_main Cmain = new Change_main();
				Cmain.main(null);
				dispose();
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		login.add(back_btn);
		
		JLabel id_label = new JLabel("아이디");
		id_label.setSize(200, 100);
		id_label.setLocation(585, 437);
		id_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		login.add(id_label);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setSize(250, 100);
		lblNewLabel.setLocation(585, 567);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		login.add(lblNewLabel);
		
		id_textField = new JTextField();
		id_textField.setSize(400, 100);
		id_textField.setLocation(885, 437);
		id_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		login.add(id_textField);
		id_textField.setColumns(10);
		
		pw_passwordField = new JPasswordField();
		pw_passwordField.setSize(400, 100);
		pw_passwordField.setLocation(885, 567);
		pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 50));
		login.add(pw_passwordField);
		
		JButton login_btn = new JButton("로그인");
		login_btn.setSize(700, 100);
		login_btn.setLocation(585, 727);
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = id_textField.getText();
				pw = pw_passwordField.getText();
				Mem_chageDAO CDAO = new Mem_chageDAO();
				boolean login_result = CDAO.DAO();
				System.out.println("로그인 성공 여부" + login_result);
			}
		});
		login_btn.setBackground(new Color(0, 128, 192));
		login_btn.setForeground(Color.WHITE);
		login_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		login.add(login_btn);
		
		JPanel find_id = new JPanel();
		find_id.setBackground(Color.WHITE);
		layeredPane.add(find_id, "name_1049829518475000");
		find_id.setLayout(null);
		
		JButton find_id_btn = new JButton("ID 찾기");
		find_id_btn.setSize(275, 100);
		find_id_btn.setLocation(475, 857);
		find_id_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(find_id);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		find_id_btn.setBorderPainted(false);
		find_id_btn.setContentAreaFilled(false);
		find_id_btn.setFocusPainted(false);
		find_id_btn.setForeground(new Color(0, 128, 192));
		find_id_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		login.add(find_id_btn);
		
		JPanel find_pw = new JPanel();
		find_pw.setBackground(Color.WHITE);
		layeredPane.add(find_pw, "name_1056879099727600");
		find_pw.setLayout(null);
		
		JButton find_pw_btn = new JButton("PASSWORD 변경");
		find_pw_btn.setSize(650, 100);
		find_pw_btn.setLocation(750, 857);
		find_pw_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(find_pw);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		find_pw_btn.setForeground(new Color(0, 128, 192));
		find_pw_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
		find_pw_btn.setFocusPainted(false);
		find_pw_btn.setContentAreaFilled(false);
		find_pw_btn.setBorderPainted(false);
		login.add(find_pw_btn);
		
		JLabel lblNewLabel_3 = new JLabel("회원 조회");
		lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		lblNewLabel_3.setBounds(190, 30, 300, 100);
		login.add(lblNewLabel_3);
		
		JLabel logo_2 = new JLabel(updateIcon);
		logo_2.setBounds(675, 30, 400, 330);
		find_id.add(logo_2);
		
		JButton back_btn_2 = new JButton(img2);
		back_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		back_btn_2.setBorderPainted(false);
		back_btn_2.setContentAreaFilled(false);
		back_btn_2.setFocusPainted(false);
		back_btn_2.setBounds(10, 10, 136, 136);
		find_id.add(back_btn_2);
		
		JButton home_btn_2 = new JButton(img3);
		home_btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoMain Gomain = new GoMain();
				Gomain.setVisible(true);
			}
		});
		home_btn_2.setBorderPainted(false);
		home_btn_2.setContentAreaFilled(false);
		home_btn_2.setFocusPainted(false);
		home_btn_2.setBounds(1800, 10, 109, 109);
		find_id.add(home_btn_2);
		
		JLabel name_Label = new JLabel("이름");
		name_Label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_Label.setBounds(550, 400, 200, 75);
		find_id.add(name_Label);
		
		JLabel phone_number_Label = new JLabel("전화번호");
		phone_number_Label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		phone_number_Label.setBounds(550, 600, 200, 75);
		find_id.add(phone_number_Label);
		
		name_textField = new JTextField();
		name_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		name_textField.setBounds(800, 400, 400, 75);
		find_id.add(name_textField);
		name_textField.setColumns(10);
		
		pn_textField = new JTextField();
		pn_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		pn_textField.setBounds(800, 600, 400, 75);
		find_id.add(pn_textField);
		pn_textField.setColumns(10);
		
		JButton find_btn = new JButton("확인");
		find_btn.setBackground(new Color(0, 128, 192));
		find_btn.setForeground(Color.WHITE);
		find_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = name_textField.getText();
				pn = pn_textField.getText();
				Mem_change_pwDAO DAO = new Mem_change_pwDAO();
				if(DAO.find_pw()) {
					Mem_change_find_pw_jd pwjd = new Mem_change_find_pw_jd();
					pwjd.main(null);
				}else {
					alrim = "값을 정확히 입력하세요";
					Mem_change_jd jd = new Mem_change_jd();
					jd.main(null);
				}
			}
		});
		find_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		find_btn.setBounds(550, 800, 300, 100);
		find_id.add(find_btn);
		
		JLabel lblNewLabel_2 = new JLabel("아이디 찾기");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(170, 60, 350, 100);
		find_id.add(lblNewLabel_2);
		
		JButton change_pw = new JButton("비밀번호 변경");
		change_pw.setForeground(new Color(0, 128, 192));
		change_pw.setFocusPainted(false);
		change_pw.setContentAreaFilled(false);
		change_pw.setBorderPainted(false);
		change_pw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(find_pw);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		change_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		change_pw.setBounds(900, 800, 450, 100);
		find_id.add(change_pw);
		
		JButton back_btn_3 = new JButton(img2);
		back_btn_3.setFocusPainted(false);
		back_btn_3.setContentAreaFilled(false);
		back_btn_3.setBorderPainted(false);
		back_btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		back_btn_3.setBounds(10, 10, 136, 136);
		find_pw.add(back_btn_3);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 재설정");
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(170, 60, 375, 100);
		find_pw.add(lblNewLabel_1);
		
		JLabel logo_3 = new JLabel(updateIcon);
		logo_3.setBounds(675, 30, 400, 330);
		find_pw.add(logo_3);
		
		JButton home_btn_3 = new JButton(img3);
		home_btn_3.setFocusPainted(false);
		home_btn_3.setContentAreaFilled(false);
		home_btn_3.setBorderPainted(false);
		home_btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoMain Gomain = new GoMain();
				Gomain.setVisible(true);
			}
		});
		home_btn_3.setBounds(1800, 10, 109, 109);
		find_pw.add(home_btn_3);
		
		JLabel id_label_2 = new JLabel("아이디");
		id_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_label_2.setBounds(550, 375, 200, 75);
		find_pw.add(id_label_2);
		
		id_textField_2 = new JTextField();
		id_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		id_textField_2.setBounds(800, 375, 400, 75);
		find_pw.add(id_textField_2);
		id_textField_2.setColumns(10);
		
		JLabel name_label_3 = new JLabel("이름");
		name_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		name_label_3.setBounds(550, 525, 200, 75);
		find_pw.add(name_label_3);
		
		name_textField_3 = new JTextField();
		name_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		name_textField_3.setBounds(800, 525, 400, 75);
		find_pw.add(name_textField_3);
		name_textField_3.setColumns(10);
		
		JLabel pn_label_3 = new JLabel("전화번호");
		pn_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pn_label_3.setBounds(550, 675, 250, 75);
		find_pw.add(pn_label_3);
		
		pn_textField_3 = new JTextField();
		pn_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		pn_textField_3.setBounds(800, 675, 400, 75);
		find_pw.add(pn_textField_3);
		pn_textField_3.setColumns(10);
		
		JButton join_btn = new JButton("확인");
		join_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id2 = id_textField_2.getText();
				name2 = name_textField_3.getText();
				pn2 = pn_textField_3.getText();
				Mem_change_pwDAO DAO = new Mem_change_pwDAO();
				if(DAO.find_pw()) {
					Mem_change_find_pw_jd pwjd = new Mem_change_find_pw_jd();
					pwjd.main(null);
				}else {
					alrim = "값을 정확히 입력하세요";
					Mem_change_jd jd = new Mem_change_jd();
					jd.main(null);
				}
			}
		});
		join_btn.setBackground(new Color(0, 128, 192));
		join_btn.setForeground(Color.WHITE);
		join_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		join_btn.setBounds(550, 800, 300, 100);
		find_pw.add(join_btn);
		
		if(Mem_change_find_id_jd.gofindpw) {
			layeredPane.removeAll();
			layeredPane.add(find_pw);
			layeredPane.repaint();
			layeredPane.revalidate();
			//Mem_change_find_id_jd.gofindpw = false;
		}
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
