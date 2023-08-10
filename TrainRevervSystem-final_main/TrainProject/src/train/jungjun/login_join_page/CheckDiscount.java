package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import train.Train_Main;

public class CheckDiscount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CardNum_textField;
	public static String CardNum = "";
	public static String alrim = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CheckDiscount dialog = new CheckDiscount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CheckDiscount() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
		UIManager.put("OptionPane.messageFont",
				new Font("HY헤드라인M", Font.BOLD, 50));
		setBounds(800, 300, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel alram = new JLabel("복지카드번호를 입력해주세요");
			alram.setHorizontalAlignment(SwingConstants.CENTER);
			alram.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			alram.setBounds(75, 125, 450, 75);
			contentPanel.add(alram);
		}
		{
			JLabel cardNum = new JLabel("복지카드번호");
			cardNum.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			cardNum.setBounds(180, 225, 200, 75);
			contentPanel.add(cardNum);
		}
		{
			CardNum_textField = new JTextField();
			CardNum_textField.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			CardNum_textField.setBounds(35, 300, 500, 100);
			contentPanel.add(CardNum_textField);
			CardNum_textField.setColumns(10);
		}
		{
			JButton OK = new JButton("확인");
			OK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardNum = CardNum_textField.getText();
					CheckDiscountRegex regex = new CheckDiscountRegex();
					if(regex.regex1() && Train_Main.discount.equals("장애인")) {
						Train_Main.preferential_treatment = "disabled";
						Train_Main.preferential_treatment_chk_B = true;
						alrim = "인증에 성공했습니다";
						Train_Main.default_radio_btn.setIcon(Train_Main.img12);
						Train_Main.disabled_radio_btn.setIcon(Train_Main.img13);
						Train_Main.national_merit_radio_btn.setIcon(Train_Main.img12);
						CheckDiscount_alrim alrim = new CheckDiscount_alrim();
						alrim.main(null);
					}else if(regex.regex2() && Train_Main.discount.equals("국가유공자")){
						Train_Main.preferential_treatment = "national_merit";
						Train_Main.preferential_treatment_chk_B = true;
						Train_Main.default_radio_btn.setIcon(Train_Main.img12);
						Train_Main.disabled_radio_btn.setIcon(Train_Main.img12);
						Train_Main.national_merit_radio_btn.setIcon(Train_Main.img13);
						alrim = "인증에 성공했습니다";
						CheckDiscount_alrim alrim = new CheckDiscount_alrim();
						alrim.main(null);
					}else if(regex.regex1() && Train_Main.discount.equals("국가유공자")){
						Train_Main.preferential_treatment_chk_B = false;
						alrim = "장애인를 선택해주세요";
						CheckDiscount_alrim alrim = new CheckDiscount_alrim();
						alrim.main(null);
					}else if(regex.regex2() && Train_Main.discount.equals("장애인")){
						Train_Main.preferential_treatment_chk_B = false;
						alrim = "국가유공자를 선택해주세요";
						CheckDiscount_alrim alrim = new CheckDiscount_alrim();
						alrim.main(null);
					}else {
						alrim = "정확한 값을 입력하세요";
						CheckDiscount_alrim alrim = new CheckDiscount_alrim();
						alrim.main(null);
					}
				}
			});
			OK.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
			OK.setForeground(Color.WHITE);
			OK.setBackground(new Color(0, 128, 192));
			OK.setBounds(35, 450, 200, 75);
			contentPanel.add(OK);
		}
		{
			JButton Cancel = new JButton("닫기");
			Cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			Cancel.setBackground(new Color(0, 128, 192));
			Cancel.setForeground(Color.WHITE);
			Cancel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
			Cancel.setBounds(335, 450, 200, 75);
			contentPanel.add(Cancel);
		}
		
		JLabel lblNewLabel = new JLabel(Train_Main.discount + "이(가) 선택되었습니다");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		lblNewLabel.setBounds(75, 30, 450, 75);
		contentPanel.add(lblNewLabel);
	}
}
