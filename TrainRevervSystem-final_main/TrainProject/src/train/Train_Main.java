package train;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import train.admin.AdminPanel;
import train.jungjun.No_login_alrim;
import train.jungjun.No_login_faild_alrim;
import train.jungjun.No_login_joinDAO;
import train.jungjun.No_login_join_Num_chk;
import train.jungjun.No_login_join_pw_chk;
import train.jungjun.admin_page.Admin_pageDAO;
import train.jungjun.change.Mem_chageDAO;
import train.jungjun.change.Mem_change_find_id_jd;
import train.jungjun.change.Mem_change_find_pw_jd;
import train.jungjun.change.Mem_change_jd;
import train.jungjun.change.Mem_change_pwDAO;
import train.jungjun.change.No_mem_changeDAO;
import train.jungjun.login_join_page.Birthday_chk;
import train.jungjun.login_join_page.CheckDAO;
import train.jungjun.login_join_page.CheckDiscount;
import train.jungjun.login_join_page.Email_chk;
import train.jungjun.login_join_page.Find_id_jd;
import train.jungjun.login_join_page.Find_pwDAO;
import train.jungjun.login_join_page.Find_pw_Jd;
import train.jungjun.login_join_page.Find_pw_select_btn_alrim;
import train.jungjun.login_join_page.ID_chk;
import train.jungjun.login_join_page.JoinDAO;
import train.jungjun.login_join_page.Login_and_joinDAO;
import train.jungjun.login_join_page.Name_chk;
import train.jungjun.login_join_page.Number_chk;
import train.jungjun.login_join_page.PW_chk;
import train.jungjun.login_join_page.Select_default_alrim;

public class Train_Main extends JFrame {
   
   private JPanel contentPane;
   public static String id = "";
   public static String pw = "";
   
   public static String pn = "";
   public static String pw2 = "";
   
   public static String pn2 = "";
   public static String pw3 = "";
   
   public static String id2 = ""; // 회원조회/로그인
   public static String pw4 = "";
   
   public static String name = ""; // 아이디 찾기
   public static String pn3 = "";
   
   public static String id3 = ""; // 비밀번호 찾기
   public static String name2 = "";
   public static String pn4 = "";
   
   public static String id4 = ""; // 회원가입
   public static String preferential_treatment = ""; // 우대 사항 여부
   public static boolean preferential_treatment_chk_B = false;
   public static String discount = "";
   public static String pw5 = "";
   public static boolean pw_chk_B = false;
   public static String alrim = "";
   public static String alrim2 = "";
   public static String name3 = "";
   public static boolean name_chk_B = false;
   public static String email = "";
   public static boolean email_chk_B = false;
   public static String phone_number = "";
   public static boolean num_chk_B = false;
   public static String birthday = "";
   public static boolean birthday_chk_B = false;
   public static String id5 = "";
   public static boolean id_chk_B = false;
   
   public static String pn5 = "";
   public static String pw6 = "";
   
   public static String id6 = "";
   public static String pw7 = "";
   
   public static String name4 = "";
   public static String pn6 = "";
   
   public static String id7 = "";
   public static String name5 = "";
   public static String pn7 = "";
   
   public static boolean radio_btn2 = false;
   public static boolean radio_btn3 = false;
   
   private JTextField id_textField;
   private JPasswordField pw_passwordField;
   
   public static ImageIcon img12 = new ImageIcon
           ("resource\\radio_button_off.png");
   public static ImageIcon img13 = new ImageIcon
           ("resource\\radio_button_on.png");
    
   public static JRadioButton default_radio_btn; 
   public static JRadioButton disabled_radio_btn;
   public static JRadioButton national_merit_radio_btn;
   
    private JTextField num_textField;
    private JPasswordField passwordField;
    private JTextField num_textField_2;
    private JPasswordField passwordField_1;
    private JTextField id_textField_2;
    private JPasswordField passwordField_2;
    private JTextField name_textField;
    private JTextField pn_textField;
    private JTextField name_textField_2;
    private JTextField id_textField_3;
    private JTextField pn_textField_2;
    private JTextField id_textField_4;
    private JPasswordField passwordField_3;
    private JTextField name_textField_3;
    private JTextField pn_textField_3;
    private JTextField birthday_textField;
    private JTextField email_textField;
    
    private static JLabel pw_alrim;
    private static JLabel email_alrim;
    private static JLabel number_alrim;
    private static JLabel name_alrim;
    private static JLabel birthday_alrim;
    private static JLabel id_alrim;
    private JTextField id_textField_5;
    private JPasswordField passwordField_4;
    private JTextField name_textField_4;
    private JTextField pn_textField_4;
    private JTextField id_textField_6;
    private JTextField name_textField_5;
    private JTextField pn_textField_5;
    
    public static JPanel card_panel;
    public static CardLayout card;
    public static Train_Main frame;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               frame = new Train_Main();
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
   public Train_Main() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1940, 1050);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      
      try { 
    	  
         card_panel = new JPanel();
         card = new CardLayout();
         card_panel.setBounds(0, 0, 1924, 1011);
         contentPane.add(card_panel);
         card_panel.setLayout(card);
         
         JPanel main_home = new JPanel();
         main_home.setLayout(null);
         main_home.setBackground(Color.WHITE);
         card_panel.add(main_home, "main_home");         
         
         JButton train_reserv_btn_1 = new JButton();
         train_reserv_btn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               card.show(card_panel, "main_reserv");
            }
         });
         train_reserv_btn_1.setFocusPainted(false);
         train_reserv_btn_1.setContentAreaFilled(false);
         train_reserv_btn_1.setBorderPainted(false);
         train_reserv_btn_1.setBounds(485, 613, 420, 270);
         main_home.add(train_reserv_btn_1);
         
         JButton tiket_btn_1 = new JButton();
         tiket_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "chk_change");
         	}
         });
         tiket_btn_1.setFocusPainted(false);
         tiket_btn_1.setContentAreaFilled(false);
         tiket_btn_1.setBorderPainted(false);
         tiket_btn_1.setBounds(1011, 613, 420, 270);
         main_home.add(tiket_btn_1);
         
         JButton admin_login_btn_1 = new JButton();
         admin_login_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "admin_page");
         	}
         });
         admin_login_btn_1.setFocusPainted(false);
         admin_login_btn_1.setContentAreaFilled(false);
         admin_login_btn_1.setBorderPainted(false);
         admin_login_btn_1.setBounds(1790, 48, 100, 100);
         main_home.add(admin_login_btn_1);
         
         JLabel logo_label_1 = new JLabel();
         logo_label_1.setBounds(682, 105, 586, 471);
         main_home.add(logo_label_1);  
         
         train_reserv_btn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/기차예매.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
      	
    	 tiket_btn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/조회변경.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
			
    	 admin_login_btn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/admin.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
			
    	 logo_label_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(586, 471, Image.SCALE_AREA_AVERAGING))); 
         // 첫번쨰 메인
         
         JPanel main_reserv = new JPanel();
         main_reserv.setLayout(null);
         main_reserv.setBackground(Color.WHITE);
         card_panel.add(main_reserv, "main_reserv");
         
         JLabel logo = new JLabel();
         logo.setBounds(682, 105, 586, 471);
         main_reserv.add(logo);
         
         JButton goMain_btn = new JButton();
         goMain_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               card.show(card_panel, "main_home");
            }
         });
         goMain_btn.setBorderPainted(false);
         goMain_btn.setContentAreaFilled(false);
         goMain_btn.setFocusPainted(false);
         goMain_btn.setBounds(1790, 40, 100, 100);
         main_reserv.add(goMain_btn);
         
         JButton membership_btn = new JButton();
         membership_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "login_join_login");
         	}
         });
         membership_btn.setFocusPainted(false);
         membership_btn.setContentAreaFilled(false);
         membership_btn.setBorderPainted(false);
         membership_btn.setBounds(485, 613, 420, 270);
         main_reserv.add(membership_btn);
         
         JButton no_membership_btn = new JButton();
         no_membership_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "no_login_join");
         	}
         });
         no_membership_btn.setFocusPainted(false);
         no_membership_btn.setContentAreaFilled(false);
         no_membership_btn.setBorderPainted(false);
         no_membership_btn.setBounds(1011, 613, 420, 270);
         main_reserv.add(no_membership_btn);
         
         JButton back_btn = new JButton();
         back_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               card.previous(card_panel);
            }
         });
         back_btn.setFocusPainted(false);
         back_btn.setContentAreaFilled(false);
         back_btn.setBorderPainted(false);
         back_btn.setBounds(10, 10, 136, 136);
         main_reserv.add(back_btn);
         
         logo.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(586, 471, Image.SCALE_AREA_AVERAGING)));
         goMain_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
         membership_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/회원예매.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
         no_membership_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/비회원예매.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
         back_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         //  ~ 2번째 메인
         
         JPanel admin_page = new JPanel();
         admin_page.setBackground(Color.WHITE);
         card_panel.add(admin_page, "admin_page");
         admin_page.setLayout(null);
         
         JPanel admin = new AdminPanel(); // 관리자 페이지 연결
         card_panel.add(admin, "admin"); 
         
 		// ★ 관리자 로그아웃 누르면 Home으로 돌아감
 		JButton homeBtn = new JButton("Logout");
 		homeBtn.setBackground(new Color(255, 251, 217));
 		homeBtn.setForeground(new Color(0, 0, 0));
 		homeBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
 		homeBtn.setBounds(1714, 30, 153, 79);
 		homeBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);				
				if (ans == 0) {
					card.show(card_panel, "main_home");
					((AdminPanel) admin).reset();
				}
			}
		});
 		admin.add(homeBtn);
         
         JLabel id_label = new JLabel("아이디");
         id_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_label.setBounds(599, 510, 200, 100);
         admin_page.add(id_label);
         
         JLabel pw_label = new JLabel("비밀번호");
         pw_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         pw_label.setBounds(599, 643, 250, 100);
         admin_page.add(pw_label);
         
         id_textField = new JTextField();
         id_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_textField.setColumns(10);
         id_textField.setBounds(899, 510, 400, 100);
         admin_page.add(id_textField);
         
         pw_passwordField = new JPasswordField();
         pw_passwordField.setFont(new Font("굴림", Font.PLAIN, 50));
         pw_passwordField.setBounds(899, 643, 400, 100);
         admin_page.add(pw_passwordField);
         
         JButton check_btn = new JButton("로그인");
         check_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id = id_textField.getText();
				pw = pw_passwordField.getText();
				
				Admin_pageDAO dao = new Admin_pageDAO();
				boolean login_result = dao.login_chk();
				if (login_result) {
					card.show(card_panel, "admin");
				}
				System.out.println(login_result);
         	}
         });
         check_btn.setForeground(Color.WHITE);
         check_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         check_btn.setBackground(new Color(0, 128, 192));
         check_btn.setBounds(599, 775, 700, 100);
         admin_page.add(check_btn);
         
         JLabel E_RAIL = new JLabel();
         E_RAIL.setBounds(798, 61, 300, 280);
         admin_page.add(E_RAIL);

         JButton back_main_btn2 = new JButton();
         back_main_btn2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "main_home");
         		id_textField.setText(null);
         		pw_passwordField.setText(null);
         	}
         });
         back_main_btn2.setFocusPainted(false);
         back_main_btn2.setContentAreaFilled(false);
         back_main_btn2.setBorderPainted(false);
         back_main_btn2.setBounds(1790, 48, 100, 100);
         admin_page.add(back_main_btn2);
         
         JLabel lblNewLabel = new JLabel("관리자 로그인");
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         lblNewLabel.setBounds(750, 375, 400, 100);
         admin_page.add(lblNewLabel);
         
         back_main_btn2.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
         E_RAIL.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         // ~ 관리자 로그인 페이지
         
         // 조회 변경 페이지
         JPanel chk_change = new JPanel();
         chk_change.setBackground(Color.WHITE);
         card_panel.add(chk_change, "chk_change");
         chk_change.setLayout(null);
         
         JButton mem_check_btn = new JButton();
         mem_check_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "mem_change");
         	}
         });
         mem_check_btn.setFocusPainted(false);
         mem_check_btn.setContentAreaFilled(false);
         mem_check_btn.setBorderPainted(false);
         mem_check_btn.setBounds(485, 613, 420, 270);
         chk_change.add(mem_check_btn);
         
         JButton no_mem_check_btn = new JButton();
         no_mem_check_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "no_mem_change");
         	}
         });
         no_mem_check_btn.setFocusPainted(false);
         no_mem_check_btn.setContentAreaFilled(false);
         no_mem_check_btn.setBorderPainted(false);
         no_mem_check_btn.setBounds(1011, 613, 420, 270);
         chk_change.add(no_mem_check_btn);
         
         JLabel logo_1 = new JLabel();
         logo_1.setBounds(682, 105, 586, 471);
         chk_change.add(logo_1);
         
         JButton home_btn = new JButton();
         home_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn.setFocusPainted(false);
         home_btn.setContentAreaFilled(false);
         home_btn.setBorderPainted(false);
         home_btn.setBounds(1783, 10, 109, 109);
         chk_change.add(home_btn);
         
         JButton back_btn_1 = new JButton();
         back_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		card.show(card_panel, "main_home");
         	}
         });
         back_btn_1.setFocusPainted(false);
         back_btn_1.setContentAreaFilled(false);
         back_btn_1.setBorderPainted(false);
         back_btn_1.setBounds(10, 10, 136, 136);
         chk_change.add(back_btn_1);
         
        mem_check_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/회원조회.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
		no_mem_check_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/비회원조회.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));	
		back_btn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
		home_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
		logo_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(586, 471, Image.SCALE_AREA_AVERAGING)));

         // 비회원 로그인 페이지
         JPanel no_login_join = new JPanel();
         no_login_join.setBackground(Color.WHITE);
         card_panel.add(no_login_join, "no_login_join");
         no_login_join.setLayout(null);
         
         JLabel num_label = new JLabel("전화번호");
         num_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 45));
         num_label.setBounds(605, 485, 220, 75);
         no_login_join.add(num_label);
         
         num_textField = new JTextField();
         num_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         num_textField.setColumns(10);
         num_textField.setBounds(959, 475, 400, 100);
         no_login_join.add(num_textField);
         
         JLabel pw_label_1 = new JLabel("티켓 확인 비밀번호");
         pw_label_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pw_label_1.setBounds(595, 645, 364, 75);
         no_login_join.add(pw_label_1);
         
         passwordField = new JPasswordField();
         passwordField.setFont(new Font("굴림", Font.PLAIN, 40));
         passwordField.setBounds(959, 629, 400, 100);
         no_login_join.add(passwordField);
         
         JLabel lblNewLabel_1 = new JLabel("숫자 4자리를 입력해주세요");
         lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
         lblNewLabel_1.setBounds(1039, 739, 312, 63);
         no_login_join.add(lblNewLabel_1);
         
         JButton check_btn_1 = new JButton("확인");
         check_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		pn5 = num_textField.getText();
         		pw6 = passwordField.getText();
         		No_login_joinDAO DAO = new No_login_joinDAO();
				No_login_join_Num_chk nchk  = new No_login_join_Num_chk();
				No_login_join_pw_chk pchk = new No_login_join_pw_chk();
				if(DAO.no_loginDAO()) {
//					alrim = "비회원 가입에 성공했습니다";
//					No_login_alrim alrim = new No_login_alrim();
//					alrim.main(null);
//					System.out.println("비회원 가입 성공 여부 " + DAO.no_loginDAO());
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
         check_btn_1.setForeground(Color.WHITE);
         check_btn_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         check_btn_1.setBackground(new Color(0, 128, 192));
         check_btn_1.setBounds(605, 825, 745, 100);
         no_login_join.add(check_btn_1);
         
         JLabel E_RAIL_1 = new JLabel();
         E_RAIL_1.setBounds(820, 39, 300, 280);
         no_login_join.add(E_RAIL_1);
         
         JButton back_btn_2 = new JButton();
         back_btn_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField.setText(null);
         		num_textField.setText(null);
         		card.show(card_panel, "main_reserv");
         	}
         });
         back_btn_2.setFocusPainted(false);
         back_btn_2.setContentAreaFilled(false);
         back_btn_2.setBorderPainted(false);
         back_btn_2.setBounds(10, 10, 136, 136);
         no_login_join.add(back_btn_2);
         
         JButton home_btn_1 = new JButton();
         home_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField.setText(null);
         		num_textField.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn_1.setFocusPainted(false);
         home_btn_1.setContentAreaFilled(false);
         home_btn_1.setBorderPainted(false);
         home_btn_1.setBounds(1795, 10, 109, 109);
         no_login_join.add(home_btn_1);
         
         JLabel no_mem_label = new JLabel("비회원 예매");
         no_mem_label.setHorizontalAlignment(SwingConstants.CENTER);
         no_mem_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         no_mem_label.setBounds(797, 343, 350, 100);
         no_login_join.add(no_mem_label);
         
        back_btn_2.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
        home_btn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));	
		E_RAIL_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));

         
         // 회원         
         JPanel mem_change = new JPanel();
         mem_change.setBackground(Color.WHITE);
         card_panel.add(mem_change, "mem_change");
         mem_change.setLayout(null);
         
         JLabel logo_3 = new JLabel();
         logo_3.setBounds(820, 39, 300, 280);
         mem_change.add(logo_3);
         
         JButton home_btn_3 = new JButton();
         home_btn_3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_4.setText(null);
         		id_textField_5.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn_3.setFocusPainted(false);
         home_btn_3.setContentAreaFilled(false);
         home_btn_3.setBorderPainted(false);
         home_btn_3.setBounds(1790, 48, 100, 100);
         mem_change.add(home_btn_3);
         
         JButton back_btn_4 = new JButton();
         back_btn_4.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_4.setText(null);
         		id_textField_5.setText(null);
         		card.show(card_panel, "chk_change");
         	}
         });
         back_btn_4.setFocusPainted(false);
         back_btn_4.setContentAreaFilled(false);
         back_btn_4.setBorderPainted(false);
         back_btn_4.setBounds(10, 10, 136, 136);
         mem_change.add(back_btn_4);
         
         JLabel id_label_4 = new JLabel("아이디");
         id_label_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_label_4.setBounds(649, 492, 200, 75);
         mem_change.add(id_label_4);
         
         JLabel lblNewLabel_4 = new JLabel("비밀번호");
         lblNewLabel_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         lblNewLabel_4.setBounds(649, 640, 200, 75);
         mem_change.add(lblNewLabel_4);
         
         id_textField_5 = new JTextField();
         id_textField_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_textField_5.setColumns(10);
         id_textField_5.setBounds(949, 489, 400, 100);
         mem_change.add(id_textField_5);
         
         passwordField_4 = new JPasswordField();
         passwordField_4.setFont(new Font("굴림", Font.PLAIN, 50));
         passwordField_4.setBounds(949, 630, 400, 100);
         mem_change.add(passwordField_4);
         
         JButton login_btn = new JButton("로그인");
         login_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id6 = id_textField_5.getText();
         		pw7 = passwordField_4.getText();
         		Mem_chageDAO CDAO = new Mem_chageDAO();
				boolean login_result = CDAO.DAO();
				System.out.println("로그인 성공 여부" + login_result);
         	}
         });
         login_btn.setForeground(Color.WHITE);
         login_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         login_btn.setBackground(new Color(0, 128, 192));
         login_btn.setBounds(649, 762, 700, 100);
         mem_change.add(login_btn);
         
         JButton find_id_btn_1 = new JButton("ID 찾기");
         find_id_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_4.setText(null);
         		id_textField_5.setText(null);
         		card.show(card_panel, "mem_change_find_id");
         	}
         });
         find_id_btn_1.setForeground(new Color(0, 128, 192));
         find_id_btn_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         find_id_btn_1.setFocusPainted(false);
         find_id_btn_1.setContentAreaFilled(false);
         find_id_btn_1.setBorderPainted(false);
         find_id_btn_1.setBounds(691, 872, 200, 85);
         mem_change.add(find_id_btn_1);
         
         JButton find_pw_btn_1 = new JButton("PASSWORD 변경");
         find_pw_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_4.setText(null);
         		id_textField_5.setText(null);
         		card.show(card_panel, "mem_change_find_pw");
         	}
         });
         find_pw_btn_1.setForeground(new Color(0, 128, 192));
         find_pw_btn_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         find_pw_btn_1.setFocusPainted(false);
         find_pw_btn_1.setContentAreaFilled(false);
         find_pw_btn_1.setBorderPainted(false);
         find_pw_btn_1.setBounds(989, 864, 362, 100);
         mem_change.add(find_pw_btn_1);
         
         JLabel lblNewLabel_3_1 = new JLabel("회원 조회");
         lblNewLabel_3_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         lblNewLabel_3_1.setBounds(841, 343, 350, 100);
         mem_change.add(lblNewLabel_3_1);
         
         back_btn_4.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         home_btn_3.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));	
         logo_3.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         JLabel lblNewLabel_5 = new JLabel("ㅣ");
         lblNewLabel_5.setForeground(new Color(0, 128, 192));
         lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 50));
         lblNewLabel_5.setBackground(new Color(255, 255, 255));
         lblNewLabel_5.setBounds(926, 881, 65, 63);
         mem_change.add(lblNewLabel_5);
         
         // 비회원 조회
         JPanel no_mem_change = new JPanel();
         no_mem_change.setBackground(Color.WHITE);
         card_panel.add(no_mem_change, "no_mem_change");
         no_mem_change.setLayout(null);
         
         JLabel logo_2 = new JLabel();
         logo_2.setBounds(820, 39, 300, 280);
         no_mem_change.add(logo_2);
         
         JButton back_btn_3 = new JButton();
         back_btn_3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_1.setText(null);
         		num_textField_2.setText(null);
         		card.show(card_panel, "chk_change");
         	}
         });
         back_btn_3.setFocusPainted(false);
         back_btn_3.setContentAreaFilled(false);
         back_btn_3.setBorderPainted(false);
         back_btn_3.setBounds(10, 10, 136, 136);
         no_mem_change.add(back_btn_3);
         
         JButton home_btn_2 = new JButton();
         home_btn_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		passwordField_1.setText(null);
         		num_textField_2.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn_2.setFocusPainted(false);
         home_btn_2.setContentAreaFilled(false);
         home_btn_2.setBorderPainted(false);
         home_btn_2.setBounds(1795, 10, 109, 109);
         no_mem_change.add(home_btn_2);
         
         JLabel no_mem_look_up = new JLabel("비회원 조회");
         no_mem_look_up.setHorizontalAlignment(SwingConstants.CENTER);
         no_mem_look_up.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         no_mem_look_up.setBounds(797, 343, 350, 100);
         no_mem_change.add(no_mem_look_up);
         
         JLabel pn_label = new JLabel("전화번호");
         pn_label.setHorizontalAlignment(SwingConstants.TRAILING);
         pn_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 45));
         pn_label.setBounds(605, 492, 200, 75);
         no_mem_change.add(pn_label);
         
         num_textField_2 = new JTextField();
         num_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         num_textField_2.setColumns(10);
         num_textField_2.setBounds(955, 493, 400, 100);
         no_mem_change.add(num_textField_2);
         
         JLabel t_pw = new JLabel("확인 비밀번호");
         t_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         t_pw.setBounds(605, 641, 292, 75);
         no_mem_change.add(t_pw);
         
         passwordField_1 = new JPasswordField();
         passwordField_1.setFont(new Font("굴림", Font.PLAIN, 40));
         passwordField_1.setBounds(955, 630, 400, 100);
         no_mem_change.add(passwordField_1);
         
         JLabel lblNewLabel_2 = new JLabel("숫자 4자리를 입력해주세요");
         lblNewLabel_2.setForeground(new Color(140, 140, 140));
         lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         lblNewLabel_2.setBounds(955, 741, 400, 53);
         no_mem_change.add(lblNewLabel_2);
         
         JButton select_btn = new JButton("확인");
         select_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		pn2 = num_textField_2.getText();
         		pw3 = passwordField_1.getText();
         		No_mem_changeDAO DAO = new No_mem_changeDAO();
				boolean result = DAO.NCDAO();
				System.out.println("로그인 여부" + result);
         	}
         });
         select_btn.setForeground(Color.WHITE);
         select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         select_btn.setBackground(new Color(0, 128, 192));
         select_btn.setBounds(610, 825, 745, 100);
         no_mem_change.add(select_btn);
         
         back_btn_3.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         home_btn_2.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
		 logo_2.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         // 회원 로그인
         JPanel login_join_login = new JPanel();
         login_join_login.setBackground(Color.WHITE);
         card_panel.add(login_join_login, "login_join_login");
         login_join_login.setLayout(null);
         
         JLabel id_label_1 = new JLabel("아이디");
         id_label_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_label_1.setBounds(636, 491, 200, 75);
         login_join_login.add(id_label_1);
         
         JLabel pw_label_2 = new JLabel("비밀번호");
         pw_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         pw_label_2.setBounds(636, 639, 200, 75);
         login_join_login.add(pw_label_2);
         
         id_textField_2 = new JTextField();
         id_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_textField_2.setColumns(10);
         id_textField_2.setBounds(936, 488, 400, 100);
         login_join_login.add(id_textField_2);
         
         passwordField_2 = new JPasswordField();
         passwordField_2.setFont(new Font("굴림", Font.PLAIN, 50));
         passwordField_2.setBounds(936, 629, 400, 100);
         login_join_login.add(passwordField_2);
         
         JButton check_btn_2 = new JButton("로그인");
         check_btn_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id2 = id_textField_2.getText();
				pw4 = passwordField_2.getText();
				
				Login_and_joinDAO dao = new Login_and_joinDAO();
				boolean login_result = dao.login_chk();
				System.out.println("로그인 성공 여부 " + login_result);
				
         	}
         });
         check_btn_2.setForeground(Color.WHITE);
         check_btn_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         check_btn_2.setBackground(new Color(0, 128, 192));
         check_btn_2.setBounds(636, 762, 700, 100);
         login_join_login.add(check_btn_2);
         
         JLabel E_RAIL_2 = new JLabel();
         E_RAIL_2.setBounds(820, 39, 300, 280);
         login_join_login.add(E_RAIL_2);
         
         JButton back_main_btn = new JButton();
         back_main_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_2.setText(null);
         		passwordField_2.setText(null);
         		card.show(card_panel, "main_reserv");
         	}
         });
         back_main_btn.setFocusPainted(false);
         back_main_btn.setContentAreaFilled(false);
         back_main_btn.setBorderPainted(false);
         back_main_btn.setBounds(10, 10, 136, 136);
         login_join_login.add(back_main_btn);
         
         JButton join_btn = new JButton("회원가입");
         join_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_2.setText(null);
         		passwordField_2.setText(null);
         		card.show(card_panel, "login_join_join");
         	}
         });
         join_btn.setForeground(new Color(0, 128, 192));
         join_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         join_btn.setFocusPainted(false);
         join_btn.setContentAreaFilled(false);
         join_btn.setBorderPainted(false);
         join_btn.setBounds(1164, 872, 200, 75);
         login_join_login.add(join_btn);
         
         JButton find_id_btn = new JButton("ID 찾기");
         find_id_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_2.setText(null);
         		passwordField_2.setText(null);
         		card.show(card_panel, "login_join_find_id");
         	}
         });
         find_id_btn.setForeground(new Color(0, 128, 192));
         find_id_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         find_id_btn.setFocusPainted(false);
         find_id_btn.setContentAreaFilled(false);
         find_id_btn.setBorderPainted(false);
         find_id_btn.setBounds(615, 872, 182, 75);
         login_join_login.add(find_id_btn);
         
         JButton find_pw_btn = new JButton("PASSWORD 변경");
         find_pw_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_2.setText(null);
         		passwordField_2.setText(null);
         		card.show(card_panel, "login_join_find_pw");
         	}
         });
         find_pw_btn.setForeground(new Color(0, 128, 192));
         find_pw_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         find_pw_btn.setFocusPainted(false);
         find_pw_btn.setContentAreaFilled(false);
         find_pw_btn.setBorderPainted(false);
         find_pw_btn.setBounds(809, 859, 336, 100);
         login_join_login.add(find_pw_btn);
         
         JButton gomain_btn1 = new JButton();
         gomain_btn1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_2.setText(null);
         		passwordField_2.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         gomain_btn1.setFocusPainted(false);
         gomain_btn1.setContentAreaFilled(false);
         gomain_btn1.setBorderPainted(false);
         gomain_btn1.setBounds(1783, 10, 109, 109);
         login_join_login.add(gomain_btn1);
         
         back_main_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         gomain_btn1.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         E_RAIL_2.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         JLabel lblNewLabel_3 = new JLabel("회원 예매");
         lblNewLabel_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         lblNewLabel_3.setBounds(828, 342, 350, 100);
         login_join_login.add(lblNewLabel_3);
         
         JLabel lblNewLabel_6 = new JLabel("｜");
         lblNewLabel_6.setForeground(new Color(0, 128, 192));
         lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 45));
         lblNewLabel_6.setBounds(781, 886, 45, 45);
         login_join_login.add(lblNewLabel_6);
         
         JLabel lblNewLabel_6_1 = new JLabel("｜");
         lblNewLabel_6_1.setForeground(new Color(0, 128, 192));
         lblNewLabel_6_1.setFont(new Font("굴림", Font.PLAIN, 45));
         lblNewLabel_6_1.setBounds(1123, 886, 45, 45);
         login_join_login.add(lblNewLabel_6_1);
         
         // 회원 로그인
         JPanel login_join_find_id = new JPanel();
         login_join_find_id.setBackground(Color.WHITE);
         card_panel.add(login_join_find_id, "login_join_find_id");
         login_join_find_id.setLayout(null);
         
         JLabel find_id = new JLabel("아이디 찾기");
         find_id.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         find_id.setBounds(838, 342, 350, 100);
         login_join_find_id.add(find_id);
         
         JButton back_login_btn3 = new JButton();
         back_login_btn3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField.setText(null);
         		pn_textField.setText(null);
         		card.show(card_panel, "login_join_login");
         	}
         });
         back_login_btn3.setFocusPainted(false);
         back_login_btn3.setContentAreaFilled(false);
         back_login_btn3.setBorderPainted(false);
         back_login_btn3.setBounds(10, 10, 136, 136);
         login_join_find_id.add(back_login_btn3);
         
         JLabel name_label_2 = new JLabel("이름");
         name_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         name_label_2.setEnabled(true);
         name_label_2.setBounds(646, 491, 200, 75);
         login_join_find_id.add(name_label_2);
         
         name_textField = new JTextField();
         name_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_textField.setColumns(10);
         name_textField.setBounds(946, 488, 400, 100);
         login_join_find_id.add(name_textField);
         
         JLabel phone_label_2 = new JLabel("전화번호");
         phone_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         phone_label_2.setBounds(646, 639, 200, 75);
         login_join_find_id.add(phone_label_2);
         
         pn_textField = new JTextField();
         pn_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pn_textField.setColumns(10);
         pn_textField.setBounds(946, 629, 400, 100);
         login_join_find_id.add(pn_textField);
         
         JButton find_id_select_btn = new JButton("확인");
         find_id_select_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name = name_textField.getText();
         		pn3 = pn_textField.getText();
         		Find_id_jd id_jd = new Find_id_jd();
				id_jd.setVisible(true);
         	}
         });
         find_id_select_btn.setForeground(Color.WHITE);
         find_id_select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         find_id_select_btn.setBackground(new Color(0, 128, 192));
         find_id_select_btn.setBounds(646, 762, 700, 100);
         login_join_find_id.add(find_id_select_btn);
         
         JLabel E_RAIL_2_1 = new JLabel();
         E_RAIL_2_1.setBounds(820, 39, 300, 280);
         login_join_find_id.add(E_RAIL_2_1);
         
         JButton gomain_btn4 = new JButton();
         gomain_btn4.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField.setText(null);
         		pn_textField.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         gomain_btn4.setFocusPainted(false);
         gomain_btn4.setContentAreaFilled(false);
         gomain_btn4.setBorderPainted(false);
         gomain_btn4.setBounds(1783, 10, 109, 109);
         login_join_find_id.add(gomain_btn4);
         
         JButton change_pw = new JButton("비밀번호 변경");
         change_pw.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField.setText(null);
         		pn_textField.setText(null);
         		card.show(card_panel, "login_join_find_pw");
         	}
         });
         change_pw.setForeground(new Color(0, 128, 192));
         change_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         change_pw.setFocusPainted(false);
         change_pw.setContentAreaFilled(false);
         change_pw.setBorderPainted(false);
         change_pw.setBounds(1038, 872, 344, 87);
         login_join_find_id.add(change_pw);

         back_login_btn3.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         gomain_btn4.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         E_RAIL_2_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         // 비밀번호 재설정
         JPanel login_join_find_pw = new JPanel();
         login_join_find_pw.setBackground(Color.WHITE);
         card_panel.add(login_join_find_pw, "login_join_find_pw");
         login_join_find_pw.setLayout(null);
         
         JButton back_login_btn2 = new JButton();
         back_login_btn2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_3.setText(null);
         		name_textField_2.setText(null);
         		pn_textField_2.setText(null);
         		card.show(card_panel, "login_join_login");
         	}
         });
         back_login_btn2.setFocusPainted(false);
         back_login_btn2.setContentAreaFilled(false);
         back_login_btn2.setBorderPainted(false);
         back_login_btn2.setBounds(10, 10, 136, 136);
         login_join_find_pw.add(back_login_btn2);
         
         JLabel id_label_3 = new JLabel("아이디");
         id_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         id_label_3.setBounds(655, 460, 200, 75);
         login_join_find_pw.add(id_label_3);
         
         JLabel name_label_3 = new JLabel("이름");
         name_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_label_3.setBounds(655, 571, 200, 75);
         login_join_find_pw.add(name_label_3);
         
         name_textField_2 = new JTextField();
         name_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_textField_2.setColumns(10);
         name_textField_2.setBounds(955, 571, 400, 75);
         login_join_find_pw.add(name_textField_2);
         
         id_textField_3 = new JTextField();
         id_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         id_textField_3.setColumns(10);
         id_textField_3.setBounds(955, 460, 400, 75);
         login_join_find_pw.add(id_textField_3);
         
         JLabel phone_label_3 = new JLabel("전화번호");
         phone_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         phone_label_3.setBounds(655, 674, 250, 75);
         login_join_find_pw.add(phone_label_3);
         
         pn_textField_2 = new JTextField();
         pn_textField_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pn_textField_2.setColumns(10);
         pn_textField_2.setBounds(955, 674, 400, 75);
         login_join_find_pw.add(pn_textField_2);
         
         JButton find_pw_select_btn = new JButton("확인");
         find_pw_select_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id3 = id_textField_3.getText();
         		name2 = name_textField_2.getText();
         		pn4 = pn_textField_2.getText();
         		Find_pwDAO DAO = new Find_pwDAO();
				if(DAO.find_pw()) {
					Find_pw_Jd pw_jd = new Find_pw_Jd();
					pw_jd.setVisible(true);
				}else {
					alrim = "정확히 입력하세요";
					Find_pw_select_btn_alrim alrim = new Find_pw_select_btn_alrim();
					alrim.main(null);
				}
         	}
         });
         find_pw_select_btn.setForeground(Color.WHITE);
         find_pw_select_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
         find_pw_select_btn.setBackground(new Color(0, 128, 192));
         find_pw_select_btn.setBounds(655, 762, 700, 100);
         login_join_find_pw.add(find_pw_select_btn);
         
         JLabel find_pw = new JLabel("비밀번호 재설정");
         find_pw.setHorizontalAlignment(SwingConstants.CENTER);
         find_pw.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         find_pw.setBounds(735, 342, 486, 100);
         login_join_find_pw.add(find_pw);
         
         JLabel E_RAIL_3 = new JLabel();
         E_RAIL_3.setBounds(820, 39, 300, 280);
         login_join_find_pw.add(E_RAIL_3);
         
         JButton gomain_btn3 = new JButton();
         gomain_btn3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_3.setText(null);
         		name_textField_2.setText(null);
         		pn_textField_2.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         gomain_btn3.setFocusPainted(false);
         gomain_btn3.setContentAreaFilled(false);
         gomain_btn3.setBorderPainted(false);
         gomain_btn3.setBounds(1783, 10, 109, 109);
         login_join_find_pw.add(gomain_btn3);
         
         back_login_btn2.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         gomain_btn3.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         E_RAIL_3.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         // 회원가입         
         JPanel login_join_join = new JPanel();
         login_join_join.setBackground(Color.WHITE);
         card_panel.add(login_join_join, "login_join_join");
         login_join_join.setLayout(null);
         
         JButton back_login_btn = new JButton();
         back_login_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_4.setText(null);
         		passwordField_3.setText(null);
         		name_textField_3.setText(null);
         		birthday_textField.setText(null);
         		pn_textField_3.setText(null);
         		email_textField.setText(null);
         		card.show(card_panel, "login_join_login");
         	}
         });
         back_login_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
         back_login_btn.setFocusPainted(false);
         back_login_btn.setContentAreaFilled(false);
         back_login_btn.setBorderPainted(false);
         back_login_btn.setBounds(10, 10, 136, 136);
         login_join_join.add(back_login_btn);
         
         JLabel join_label = new JLabel("회원가입");
         join_label.setHorizontalAlignment(SwingConstants.CENTER);
         join_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 70));
         join_label.setBounds(125, 150, 400, 100);
         login_join_join.add(join_label);
         
         JLabel id_label_2 = new JLabel("아이디");
         id_label_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         id_label_2.setBounds(609, 147, 200, 75);
         login_join_join.add(id_label_2);         
         
         JLabel pw_label_2_1 = new JLabel("비밀번호");
         pw_label_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pw_label_2_1.setBounds(609, 235, 200, 75);
         login_join_join.add(pw_label_2_1);
         
         id_textField_4 = new JTextField();
         id_textField_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         id_textField_4.setColumns(10);
         id_textField_4.setBounds(859, 150, 400, 75);
         login_join_join.add(id_textField_4);
         
         passwordField_3 = new JPasswordField();
         passwordField_3.setFont(new Font("굴림", Font.PLAIN, 40));
         passwordField_3.setBounds(859, 235, 400, 75);
         login_join_join.add(passwordField_3);
         
         JLabel name_label = new JLabel("이름");
         name_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_label.setBounds(609, 320, 200, 75);
         login_join_join.add(name_label);
         
         JLabel phone_label = new JLabel("전화번호");
         phone_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         phone_label.setBounds(609, 485, 250, 75);
         login_join_join.add(phone_label);
         
         name_textField_3 = new JTextField();
         name_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_textField_3.setColumns(10);
         name_textField_3.setBounds(859, 320, 400, 75);
         login_join_join.add(name_textField_3);
         
         pn_textField_3 = new JTextField();
         pn_textField_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pn_textField_3.setColumns(10);
         pn_textField_3.setBounds(859, 485, 400, 75);
         login_join_join.add(pn_textField_3);
         
         JLabel birthday_label = new JLabel("생년월일");
         birthday_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         birthday_label.setBounds(609, 400, 200, 75);
         login_join_join.add(birthday_label);
         
         JLabel email_label = new JLabel("이메일");
         email_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         email_label.setBounds(609, 570, 250, 75);
         login_join_join.add(email_label);
         
         birthday_textField = new JTextField();
         birthday_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         birthday_textField.setColumns(10);
         birthday_textField.setBounds(859, 405, 400, 75);
         login_join_join.add(birthday_textField);
         
         email_textField = new JTextField();
         email_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         email_textField.setColumns(10);
         email_textField.setBounds(859, 570, 400, 75);
         login_join_join.add(email_textField);
         
         JButton check_btn_2_1 = new JButton("가입 완료");
         check_btn_2_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id5 = id_textField_4.getText();
				pw5 = passwordField_3.getText();
				name3 = name_textField_3.getText();
				phone_number = pn_textField_3.getText();
				birthday = birthday_textField.getText();
				email = email_textField.getText();
				
				JoinDAO dao2 = new JoinDAO();
				boolean join_result = dao2.join_chk();
				System.out.println("회원가입 성공 여부 : " + join_result);
         	}
         });
         check_btn_2_1.setForeground(Color.WHITE);
         check_btn_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         check_btn_2_1.setBackground(new Color(0, 128, 192));
         check_btn_2_1.setBounds(609, 775, 665, 100);
         login_join_join.add(check_btn_2_1);
         
         JButton chk_overlap_btn = new JButton("중복 확인");
         chk_overlap_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id4 = id_textField_4.getText();
         		CheckDAO dao3 = new CheckDAO();
				dao3.id_check();
         	}
         });
         chk_overlap_btn.setForeground(Color.WHITE);
         chk_overlap_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
         chk_overlap_btn.setBackground(new Color(0, 128, 192));
         chk_overlap_btn.setBounds(1309, 160, 180, 60);
         login_join_join.add(chk_overlap_btn);
         
         pw_alrim = new JLabel();
         pw_alrim.setText("6자리이상 영어 대문자,소문자,숫자,특수문자를 포함하세요");
         pw_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         pw_alrim.setBounds(1309, 235, 500, 60);
         login_join_join.add(pw_alrim);
         
         email_alrim = new JLabel();
         email_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         email_alrim.setBounds(1309, 570, 400, 60);
         login_join_join.add(email_alrim);
         
         number_alrim = new JLabel();
         number_alrim.setText("010-0000-0000");
         number_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         number_alrim.setBounds(1309, 485, 400, 60);
         login_join_join.add(number_alrim);
         
         birthday_alrim = new JLabel();
         birthday_alrim.setText("YYYY-MM-DD");
         birthday_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         birthday_alrim.setBounds(1309, 400, 400, 60);
         login_join_join.add(birthday_alrim);
         
         JLabel preferential_treatment_label = new JLabel("우대 사항");
         preferential_treatment_label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         preferential_treatment_label.setBounds(609, 659, 250, 75);
         login_join_join.add(preferential_treatment_label);
         
//         JButton preferential_treatment_btn = new JButton("확인");
//         preferential_treatment_btn.setForeground(Color.WHITE);
//         preferential_treatment_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
//         preferential_treatment_btn.setBackground(new Color(0, 128, 192));
//         preferential_treatment_btn.setBounds(1350, 650, 130, 60);
//         login_join_join.add(preferential_treatment_btn);
         
         default_radio_btn = new JRadioButton("없음");
         default_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         default_radio_btn.setBackground(Color.WHITE);
         default_radio_btn.setBounds(859, 659, 125, 75);
         default_radio_btn.setIcon(img12);
         login_join_join.add(default_radio_btn);
         
         disabled_radio_btn = new JRadioButton("장애인");
         disabled_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         disabled_radio_btn.setBackground(Color.WHITE);
         disabled_radio_btn.setBounds(989, 659, 150, 75);
         disabled_radio_btn.setIcon(img12);
         login_join_join.add(disabled_radio_btn);
         
         national_merit_radio_btn = new JRadioButton("국가유공자");
         national_merit_radio_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
         national_merit_radio_btn.setBackground(Color.WHITE);
         national_merit_radio_btn.setBounds(1149, 659, 250, 75);
         national_merit_radio_btn.setIcon(img12);
         login_join_join.add(national_merit_radio_btn);
         
         default_radio_btn.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				preferential_treatment = "default";
				preferential_treatment_chk_B = true;
 				Select_default_alrim sd = new Select_default_alrim();
				sd.main(null);
 			}
 		});
 		
 		disabled_radio_btn.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				discount = "장애인";
				CheckDiscount dc = new CheckDiscount();
				dc.main(null);
 			}
 		});
 		
 		national_merit_radio_btn.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				discount = "국가유공자";
				CheckDiscount dc = new CheckDiscount();
				dc.main(null);
 			}
 		});
 		
// 		preferential_treatment_btn.addActionListener(new ActionListener() {
//         	public void actionPerformed(ActionEvent e) {
//         		if (default_radio_btn.isSelected()) {
//					 preferential_treatment = "default";
//					 preferential_treatment_chk_B = true;
//					 Select_default_alrim sd = new Select_default_alrim();
//					 sd.main(null);
//				 }else if(disabled_radio_btn.isSelected()) {
//					 discount = "장애인";
//					 CheckDiscount dc = new CheckDiscount();
//					 dc.main(null);
//				 }else if(national_merit_radio_btn.isSelected()) {
//					 discount = "국가유공자";
//					 CheckDiscount dc = new CheckDiscount();
//					 dc.main(null);
//				 }
//         	}
//         });
 		
 		ButtonGroup group = new ButtonGroup();
 		group.add(default_radio_btn);
 		group.add(disabled_radio_btn);
 		group.add(national_merit_radio_btn);
         
         id_alrim = new JLabel();
         id_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         id_alrim.setBounds(1509, 160, 400, 60);
         login_join_join.add(id_alrim);
         
         name_alrim = new JLabel();
         name_alrim.setText("2자리 이상 한글을 입력하세요");
         name_alrim.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
         name_alrim.setBounds(1309, 320, 400, 60);
         login_join_join.add(name_alrim);
         
         JButton gomain_btn2 = new JButton();
         gomain_btn2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_4.setText(null);
         		passwordField_3.setText(null);
         		name_textField_3.setText(null);
         		birthday_textField.setText(null);
         		pn_textField_3.setText(null);
         		email_textField.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         gomain_btn2.setFocusPainted(false);
         gomain_btn2.setContentAreaFilled(false);
         gomain_btn2.setBorderPainted(false);
         gomain_btn2.setBounds(1800, 10, 109, 109);
         login_join_join.add(gomain_btn2);
         
         back_login_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         gomain_btn2.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         
         JPanel mem_change_find_id = new JPanel();
         mem_change_find_id.setBackground(Color.WHITE);
         card_panel.add(mem_change_find_id, "mem_change_find_id");
         mem_change_find_id.setLayout(null);
         
         JLabel logo_2_1 = new JLabel();
         logo_2_1.setBounds(820, 39, 300, 280);
         mem_change_find_id.add(logo_2_1);
         
         JButton back_btn_2_1 = new JButton();
         back_btn_2_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField_4.setText(null);
         		pn_textField_4.setText(null);
         		card.show(card_panel, "mem_change");
         	}
         });
         back_btn_2_1.setFocusPainted(false);
         back_btn_2_1.setContentAreaFilled(false);
         back_btn_2_1.setBorderPainted(false);
         back_btn_2_1.setBounds(10, 10, 136, 136);
         mem_change_find_id.add(back_btn_2_1);
         
         JButton home_btn_2_1 = new JButton();
         home_btn_2_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField_4.setText(null);
         		pn_textField_4.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn_2_1.setFocusPainted(false);
         home_btn_2_1.setContentAreaFilled(false);
         home_btn_2_1.setBorderPainted(false);
         home_btn_2_1.setBounds(1783, 10, 109, 109);
         mem_change_find_id.add(home_btn_2_1);
         
         JLabel name_Label = new JLabel("이름");
         name_Label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_Label.setBounds(647, 491, 200, 75);
         mem_change_find_id.add(name_Label);
         
         JLabel phone_number_Label = new JLabel("전화번호");
         phone_number_Label.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         phone_number_Label.setBounds(647, 639, 200, 75);
         mem_change_find_id.add(phone_number_Label);
         
         name_textField_4 = new JTextField();
         name_textField_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         name_textField_4.setColumns(10);
         name_textField_4.setBounds(947, 488, 400, 100);
         mem_change_find_id.add(name_textField_4);
         
         pn_textField_4 = new JTextField();
         pn_textField_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         pn_textField_4.setColumns(10);
         pn_textField_4.setBounds(947, 629, 400, 100);
         mem_change_find_id.add(pn_textField_4);
         
         JButton find_btn = new JButton("확인");
         find_btn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name4 = name_textField_4.getText();
         		pn6 = pn_textField_4.getText();
         		Mem_change_find_id_jd jd = new Mem_change_find_id_jd();
				jd.main(null);
         	}
         });
         find_btn.setForeground(Color.WHITE);
         find_btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         find_btn.setBackground(new Color(0, 128, 192));
         find_btn.setBounds(647, 762, 700, 100);
         mem_change_find_id.add(find_btn);
         
         JLabel lblNewLabel_2_1 = new JLabel("아이디 찾기");
         lblNewLabel_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         lblNewLabel_2_1.setBounds(839, 342, 350, 100);
         mem_change_find_id.add(lblNewLabel_2_1);
         
         JButton change_pw_1 = new JButton("비밀번호 변경");
         change_pw_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		name_textField_4.setText(null);
         		pn_textField_4.setText(null);
         		card.show(card_panel, "mem_change_find_pw");
         	}
         });
         change_pw_1.setForeground(new Color(0, 128, 192));
         change_pw_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
         change_pw_1.setFocusPainted(false);
         change_pw_1.setContentAreaFilled(false);
         change_pw_1.setBorderPainted(false);
         change_pw_1.setBounds(1038, 872, 359, 100);
         mem_change_find_id.add(change_pw_1);
         
         JPanel loading = new JPanel();
         loading.setBackground(Color.WHITE);
         JLabel typeLabel1 = new JLabel();
		 typeLabel1.setBounds(470, 30, 1000, 1000);
		 loading.add(typeLabel1);
		 typeLabel1.setIcon(new ImageIcon(ImageIO.read(new File("resource\\Loading_logo.png")).getScaledInstance(1000, 700, Image.SCALE_AREA_AVERAGING)));
         card_panel.add(loading, "loading");
         loading.setLayout(null);
         
         back_btn_2_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         home_btn_2_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         logo_2_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         
         
         JPanel mem_change_find_pw = new JPanel();
         mem_change_find_pw.setBackground(Color.WHITE);
         card_panel.add(mem_change_find_pw, "mem_change_find_pw");
         mem_change_find_pw.setLayout(null);
         
         JButton back_btn_3_1 = new JButton();
         back_btn_3_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_6.setText(null);
         		name_textField_5.setText(null);
         		pn_textField_5.setText(null);
         		card.show(card_panel, "mem_change");
         	}
         });
         back_btn_3_1.setFocusPainted(false);
         back_btn_3_1.setContentAreaFilled(false);
         back_btn_3_1.setBorderPainted(false);
         back_btn_3_1.setBounds(10, 10, 136, 136);
         mem_change_find_pw.add(back_btn_3_1);
         
         JLabel lblNewLabel_1_1 = new JLabel("비밀번호 재설정");
         lblNewLabel_1_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         lblNewLabel_1_1.setBounds(768, 342, 466, 100);
         mem_change_find_pw.add(lblNewLabel_1_1);
         
         JLabel logo_3_1 = new JLabel();
         logo_3_1.setBounds(820, 39, 400, 280);
         mem_change_find_pw.add(logo_3_1);
         
         JButton home_btn_3_1 = new JButton();
         home_btn_3_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id_textField_6.setText(null);
         		name_textField_5.setText(null);
         		pn_textField_5.setText(null);
         		card.show(card_panel, "main_home");
         	}
         });
         home_btn_3_1.setFocusPainted(false);
         home_btn_3_1.setContentAreaFilled(false);
         home_btn_3_1.setBorderPainted(false);
         home_btn_3_1.setBounds(1800, 10, 109, 109);
         mem_change_find_pw.add(home_btn_3_1);
         
         back_btn_3_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
         home_btn_3_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
         logo_3_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(300, 280, Image.SCALE_AREA_AVERAGING)));
         
         JLabel id_label_2_1 = new JLabel("아이디");
         id_label_2_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_label_2_1.setBounds(649, 457, 200, 75);
         mem_change_find_pw.add(id_label_2_1);
         
         id_textField_6 = new JTextField();
         id_textField_6.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         id_textField_6.setColumns(10);
         id_textField_6.setBounds(949, 457, 400, 75);
         mem_change_find_pw.add(id_textField_6);
         
         JLabel name_label_3_1 = new JLabel("이름");
         name_label_3_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         name_label_3_1.setBounds(649, 563, 200, 75);
         mem_change_find_pw.add(name_label_3_1);
         
         name_textField_5 = new JTextField();
         name_textField_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         name_textField_5.setColumns(10);
         name_textField_5.setBounds(949, 563, 400, 75);
         mem_change_find_pw.add(name_textField_5);
         
         JLabel pn_label_3 = new JLabel("전화번호");
         pn_label_3.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         pn_label_3.setBounds(649, 671, 250, 75);
         mem_change_find_pw.add(pn_label_3);
         
         pn_textField_5 = new JTextField();
         pn_textField_5.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
         pn_textField_5.setColumns(10);
         pn_textField_5.setBounds(949, 671, 400, 75);
         mem_change_find_pw.add(pn_textField_5);
         
         JButton join_btn_1 = new JButton("확인");
         join_btn_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		id7 = id_textField_6.getText();
         		name5 = name_textField_5.getText();
         		pn7 = pn_textField_5.getText();
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
         join_btn_1.setForeground(Color.WHITE);
         join_btn_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
         join_btn_1.setBackground(new Color(0, 128, 192));
         join_btn_1.setBounds(649, 762, 700, 100);
         mem_change_find_pw.add(join_btn_1);
         
         }catch(Exception e) {
            e.printStackTrace();
         }
      
      passwordField_3.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				PW_chk pw = new PW_chk();
				pw5 = passwordField_3.getText();
				if(pw.pw_chk(pw5)) {
					pw_alrim.setText("사용 가능한 비밀번호입니다");
					pw_chk_B = true;
				}else {
					pw_alrim.setText("6자리이상 영어 대문자,소문자,숫자,특수문자를 포함하세요");
					pw_chk_B = false;
				}
			}
		});
      name_textField_3.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				name3 = name_textField_3.getText();
				Name_chk name = new Name_chk();
				if(name.name_chk()) {
					name_alrim.setText("올바른 이름입니다");
					name_chk_B = true;
				}else {
					name_alrim.setText("2자리 이상 한글을 입력하세요");
					name_chk_B = false;
				}
			}
		});
      
      email_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				email = email_textField.getText();
				Email_chk email_1 = new Email_chk();
				if(email_1.email_chk()) {
					email_alrim.setText("이메일을 정확히 입력하셨습니다");
					email_chk_B = true;
				}else {
					email_alrim.setText("이메일을 정확히 입력하세요");
					email_chk_B = false;
				}
			}
		});
      pn_textField_3.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				phone_number = pn_textField_3.getText();
				Number_chk number_1 = new Number_chk();
				if(number_1.number_chk()) {
					number_alrim.setText("올바른 전화번호입니다");
					num_chk_B = true;
				}else {
					number_alrim.setText("-를 포함하여 입력하세요");
					num_chk_B = false;
				}
			}
		});
      birthday_textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				birthday = birthday_textField.getText();
				Birthday_chk chk_birthday = new Birthday_chk();
				if(chk_birthday.birthday_chk()) {
					birthday_alrim.setText("올바른 생년월일입니다");
					birthday_chk_B = true;
				}else {
					birthday_alrim.setText("-를 포함하여 올바른 값을 입력하세요");
					birthday_chk_B = false;
				}
			}
		});
      id_textField_4.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				id5 = id_textField_4.getText();
				boolean result1 = id2.matches("^\\w*admin+\\w*$");
				boolean result2 = id2.matches("^\\w*Admin+\\w*$");
				boolean result3 = id2.matches("^\\w*ADMIN+\\w*$");
				ID_chk id = new ID_chk();
				if(result1 || result2 || result3) {
					id_alrim.setText("admin을 포함하지 마세요");
					id_chk_B = false;
				}else if(id.id_chk()){
					id_alrim.setText("올바른 아이디입니다");
					id_chk_B = true;
				}else {
					id_alrim.setText("4~20자리 영문자,숫자를 입력하세요");
					id_chk_B = false;
				}
			}
		});      
      
   }
}