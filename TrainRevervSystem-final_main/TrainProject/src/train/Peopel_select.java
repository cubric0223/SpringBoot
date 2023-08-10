package train;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import train.search.Search_Train_Panel;
// 인원 선택 패널
/**
 * @author LJH
 */
public class Peopel_select extends JPanel {
	public static JTextField textField1;
	public static JTextField textField2;
	public static JTextField textField3;
	public static JTextField textField4;
	private boolean login_who = train.TrainReserv_Main.login_who;
	// 인원 + 클릭시 메서드로 최대 9명 까지 더하기
	private int pluspeople(String str) {
		int num = Integer.parseInt(str)+1;
		if(num < 9 && num > 0) {
			return num;
		}else {
			return 9;
		}
	}
	// 우대인원 + 클릭시 메서드로 최대 1명 까지 더하기 
	private int pluspre(String str) {
		int num = Integer.parseInt(str)+1;
		if(num < 2 && num > 0) {
			return num;
		}else {
			return 1;
		}
	}
	// 인원 - 클릭시 메서드로 최소 0명까지 빼기
	private int minuspeople(String str) {
		int num = Integer.parseInt(str)-1;
		if(num < 9 && num > 0) {
			return num;
		}else {
			return 0;
		}
	}
	// 우대인원 - 클릭시 메서드로 최소 0명까지 빼기
	private int minuspre(String str) {
		int num = Integer.parseInt(str)-1;
		if(num < 2 && num > 0) {
			return num;
		}else {
			return 0;
		}
	}
	// 모든 인원 더해서 메인 예매 프레임에 인원 합하여 넣기
	private int sumPeople(String str1, String str2, String str3, String str4) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		int num3 = Integer.parseInt(str3);
		int num4 = Integer.parseInt(str4);
		int sum = num1 + num2 + num3 + num4;
		if(sum != 0) {
			return sum;
		}else {
			return 0;
		}
	}
	/**
	 * Create the panel.
	 */
	public Peopel_select() {
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 255));
		leftPanel.setLayout(null);
		
		JLabel typeLabel1 = new JLabel("어른(만 13세 이상)");
		typeLabel1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1.setBounds(295, 282, 516, 66);
		leftPanel.add(typeLabel1);
		// 새로고침시 모든 인원 0으로 바꾸기
		JButton returnBtn = new JButton("새로고침");
		returnBtn.setFont(new Font("HY견고딕", Font.BOLD, 35));
		returnBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField1.setText("0");
				textField2.setText("0");
				textField3.setText("0");
				textField4.setText("0");
				
			}
		});
		returnBtn.setBounds(823, 598, 304, 112);
		leftPanel.add(returnBtn);
		
		JButton minusBtn1 = new JButton("-");
		minusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+minuspeople(str));
			}
		});
		minusBtn1.setBounds(823, 263, 100, 80);
		leftPanel.add(minusBtn1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField1.setText("0");
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setColumns(10);
		textField1.setBounds(935, 263, 80, 80);
		leftPanel.add(textField1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, 1419, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		JButton plusBtn1 = new JButton("+");
		plusBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField1.getText();
				textField1.setText(""+pluspeople(str));
			}
		});
		plusBtn1.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn1.setBounds(1027, 263, 100, 80);
		leftPanel.add(plusBtn1);
		
		JLabel typeLabel1_1 = new JLabel("어린이(만 6세 ~ 만 12세)");
		typeLabel1_1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_1.setBounds(295, 358, 516, 66);
		leftPanel.add(typeLabel1_1);
		
		JButton minusBtn2 = new JButton("-");
		minusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+minuspeople(str));
			}
		});
		minusBtn2.setBounds(823, 344, 100, 80);
		leftPanel.add(minusBtn2);
		
		textField2 = new JTextField();
		textField2.setText("0");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField2.setColumns(10);
		textField2.setBounds(935, 344, 80, 80);
		leftPanel.add(textField2);
		
		JButton plusBtn2 = new JButton("+");
		plusBtn2.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField2.getText();
				textField2.setText(""+pluspeople(str));
			}
		});
		plusBtn2.setBounds(1027, 344, 100, 80);
		leftPanel.add(plusBtn2);
		
		JLabel typeLabel1_2 = new JLabel("경로(65세이상)");
		typeLabel1_2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_2.setBounds(295, 434, 516, 66);
		leftPanel.add(typeLabel1_2);
		
		JButton minusBtn3 = new JButton("-");
		minusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+minuspeople(str));
			}
		});
		minusBtn3.setBounds(823, 426, 100, 80);
		leftPanel.add(minusBtn3);
		
		textField3 = new JTextField();
		textField3.setText("0");
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField3.setColumns(10);
		textField3.setBounds(935, 426, 80, 80);
		leftPanel.add(textField3);
		
		JButton plusBtn3 = new JButton("+");
		plusBtn3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField3.getText();
				textField3.setText(""+pluspeople(str));
			}
		});
		plusBtn3.setBounds(1027, 426, 100, 80);
		leftPanel.add(plusBtn3);
		
		JLabel typeLabel1_3 = new JLabel("우대 인원");
		typeLabel1_3.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		typeLabel1_3.setBounds(295, 510, 516, 66);
		leftPanel.add(typeLabel1_3);
		
		JButton minusBtn4 = new JButton("-");
		minusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		minusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+minuspre(str));
			}
		});
		minusBtn4.setBounds(823, 508, 100, 80);
		leftPanel.add(minusBtn4);
		
		textField4 = new JTextField();
		textField4.setText("0");
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		textField4.setColumns(10);
		textField4.setBounds(935, 508, 80, 80);
		leftPanel.add(textField4);
		
		JButton plusBtn4 = new JButton("+");
		plusBtn4.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		plusBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField4.getText();
				textField4.setText(""+pluspre(str));
			}
		});
		plusBtn4.setBounds(1027, 508, 100, 80);
		leftPanel.add(plusBtn4);
		
		JLabel typeLabel1_4 = new JLabel("인원 선택");
		typeLabel1_4.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		typeLabel1_4.setBounds(502, 100, 335, 66);
		leftPanel.add(typeLabel1_4);
		// 다음 버튼 클릭시 인원이 0명 이상일때 다음으로 넘어가기
		JButton returnBtn_1 = new JButton();
		returnBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectPeopleLabel.setText(""+sumPeople(
						textField1.getText(), textField2.getText(),textField3.getText(),textField4.getText()));
				UIManager.put("OptionPane.messageFont", new Font("HY헤드라인M", Font.BOLD, 40));
			    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("HY헤드라인M",Font.PLAIN, 30)));
				if(sumPeople(textField1.getText(), textField2.getText(),textField3.getText(),textField4.getText()) == 0) {
					JOptionPane.showMessageDialog(null,"인원을 선택해주십시오.");
				}else if(TrainReserv_Main.date_text.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"날짜를 선택해주십시오.");
				}else {
					JPanel search_panel = new Search_Train_Panel();
					TrainReserv_Main.card_panel.setBounds(441,80,1483,931);
					TrainReserv_Main.card_panel.add(search_panel, "기차API");
					TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "기차API");
				}
				TrainReserv_Main.count_panel = 4;
			}
		});
		returnBtn_1.setBorderPainted(false);
		returnBtn_1.setContentAreaFilled(false);
		returnBtn_1.setFocusPainted(false);	
		returnBtn_1.setBounds(1280, 10, 110, 110);
		leftPanel.add(returnBtn_1);
		
		JButton previousBtn = new JButton();
		previousBtn.setBorderPainted(false);
		previousBtn.setContentAreaFilled(false);
		previousBtn.setFocusPainted(false);	
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectPeopleLabel.setText("X");
				textField1.setText("0");
				textField2.setText("0");
				textField3.setText("0");
				textField4.setText("0");
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subkind");
				TrainReserv_Main.count_panel = 3;
			}
		});
		previousBtn.setBounds(50, 10, 110, 110);
		leftPanel.add(previousBtn);
		setLayout(groupLayout);
		// 회원, 비회원 로그인 시 경로, 유아 버튼 활성화여부
		// 회원일때도 우대여부가 인증 되었을 시 우대인원 활성화
		if(login_who) {
			try {
				if(train.jungjun.login_join_page.Login_and_joinDAO.preferential != null) {
					if(train.jungjun.login_join_page.Login_and_joinDAO.preferential.equals("default")) {
						minusBtn4.setEnabled(false);
						plusBtn4.setEnabled(false);
						textField4.setEnabled(false);
						
					}else if(train.jungjun.login_join_page.Login_and_joinDAO.preferential.equals("disabled") ||
							train.jungjun.login_join_page.Login_and_joinDAO.preferential.equals("national_merit")) {
						minusBtn4.setEnabled(true);
						plusBtn4.setEnabled(true);
						textField4.setEnabled(true);
					}
				}
				
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}else{
			minusBtn2.setEnabled(false);
			minusBtn3.setEnabled(false);
			minusBtn4.setEnabled(false);
			plusBtn2.setEnabled(false);
			plusBtn3.setEnabled(false);
			plusBtn4.setEnabled(false);
			textField2.setEnabled(false);
			textField3.setEnabled(false);
			textField4.setEnabled(false);
		}
		
		try {
			returnBtn_1.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_next.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
			previousBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_back.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
