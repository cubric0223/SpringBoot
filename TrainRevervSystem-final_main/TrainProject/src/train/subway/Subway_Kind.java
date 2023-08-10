package train.subway;

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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import train.TrainReserv_Main;

//열차 종류를 선택하는 패널
public class Subway_Kind extends JPanel {

	/**
	 * @author LJH
	 */
	public Subway_Kind() {
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 255, 255));
		rightPanel.setLayout(null);
		// KTX를 선택할 때 메인 예매 열차 변경
		JButton subKtxBtn = new JButton("KTX");
		subKtxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subKtxBtn.setBackground(new Color(255, 251, 217));
		subKtxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subKtxBtn.getText());
			}
		});
		subKtxBtn.setBounds(293, 370, 400, 150);
		rightPanel.add(subKtxBtn);
		// SRT를 선택할 때 메인 예매 열차 변경
		JButton subSrtBtn = new JButton("SRT");
		subSrtBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subSrtBtn.setBackground(new Color(255, 251, 217));
		subSrtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subSrtBtn.getText());
			}
		});
		subSrtBtn.setBounds(705, 370, 400, 150);
		rightPanel.add(subSrtBtn);
		// 새마을호를 선택할 때 메인 예매 열차 변경
		JButton subNewBtn = new JButton("새마을호");
		subNewBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subNewBtn.setBackground(new Color(255, 251, 217));
		subNewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewBtn.getText());
			}
		});
		subNewBtn.setBounds(293, 530, 400, 150);
		rightPanel.add(subNewBtn);
		// 무궁화호 선택할 때 메인 예매 열차 변경
		JButton subFlowerBtn = new JButton("무궁화호");
		subFlowerBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subFlowerBtn.setBackground(new Color(255, 251, 217));
		subFlowerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subFlowerBtn.getText());
			}
		});
		subFlowerBtn.setBounds(705, 530, 400, 150);
		rightPanel.add(subFlowerBtn);
		// ITX-청춘 선택할 때 메인 예매 열차 변경
		JButton subYungItxBtn = new JButton("ITX-청춘");
		subYungItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subYungItxBtn.setBackground(new Color(255, 251, 217));
		subYungItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subYungItxBtn.getText());
			}
		});
		subYungItxBtn.setBounds(293, 690, 400, 150);
		rightPanel.add(subYungItxBtn);
		// ITX-새마을 선택할 때 메인 예매 열차 변경
		JButton subNewItxBtn = new JButton("ITX-새마을");
		subNewItxBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		subNewItxBtn.setBackground(new Color(255, 251, 217));
		subNewItxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(subNewItxBtn.getText());
			}
		});
		subNewItxBtn.setBounds(705, 690, 400, 150);
		rightPanel.add(subNewItxBtn);
		// 전체 선택할 때 메인 예매 열차 변경
		JButton allSubBtn = new JButton("전체");
		allSubBtn.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		allSubBtn.setBackground(new Color(255, 251, 217));
		allSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText(allSubBtn.getText());
			}
		});
		allSubBtn.setBounds(450, 182, 500, 150);
		rightPanel.add(allSubBtn);
		
		JLabel typeLabel1_4_1 = new JLabel("열차선택");
		typeLabel1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel1_4_1.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		typeLabel1_4_1.setBounds(543, 50, 335, 100);
		rightPanel.add(typeLabel1_4_1);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
					.addContainerGap())
		);
		// 다음 버튼
		JButton nextBtn = new JButton();
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "select");
				TrainReserv_Main.count_panel = 3;
			}
		});
		nextBtn.setBorderPainted(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);
		nextBtn.setBackground(new Color(0, 128, 129));
		nextBtn.setBounds(1180, 10, 195, 117);
		rightPanel.add(nextBtn);
		// 이전 버튼
		JButton previousBtn = new JButton();
		previousBtn.setBackground(new Color(0, 128, 129));
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.selectsubBtn.setText("전체");
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "calender");
				TrainReserv_Main.count_panel = 2;
			}
		});
		previousBtn.setBorderPainted(false);
		previousBtn.setContentAreaFilled(false);
		previousBtn.setFocusPainted(false);
		previousBtn.setBounds(12, 10, 195, 117);
		rightPanel.add(previousBtn);
		setLayout(groupLayout);
		
		try {
			nextBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_next.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
			previousBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_back.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
