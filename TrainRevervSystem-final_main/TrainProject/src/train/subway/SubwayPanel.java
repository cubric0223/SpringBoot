package train.subway;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import train.TrainReserv_Main;
import train.Train_Main;
// 기차역 선택 패널
public class SubwayPanel extends JPanel implements MouseListener{
	private String train_name;
	
	/**
	 * @author KYJ
	 */
	public SubwayPanel(){
		setBounds(0,0,1450, 1500);
		ImageIcon img_main = new ImageIcon
				("resource\\subway_main.jpg");
		ImageIcon img_ga = new ImageIcon
				("resource\\ㄱ.jpg");
		ImageIcon img_na = new ImageIcon
				("resource\\ㄴ.jpg");
		ImageIcon img_da = new ImageIcon
				("resource\\ㄷ.jpg");
		ImageIcon img_la = new ImageIcon
				("resource\\ㄹ.jpg");
		ImageIcon img_ma = new ImageIcon
				("resource\\ㅁ.jpg");
		ImageIcon img_ba = new ImageIcon
				("resource\\ㅂ.jpg");
		ImageIcon img_sa = new ImageIcon
				("resource\\ㅅ.jpg");
		ImageIcon img_ah = new ImageIcon
				("resource\\ㅇ.jpg");
		ImageIcon img_ja = new ImageIcon
				("resource\\ㅈ.jpg");
		ImageIcon img_cha = new ImageIcon
				("resource\\ㅊ.jpg");
		ImageIcon img_ka = new ImageIcon
				("resource\\ㅋ.jpg");
		ImageIcon img_ta = new ImageIcon
				("resource\\ㅌ.jpg");
		ImageIcon img_pa = new ImageIcon
				("resource\\ㅍ.jpg");
		ImageIcon img_ha = new ImageIcon
				("resource\\ㅎ.jpg");
		Panel panel_main = new Panel();
		panel_main.setBounds(10, 0, 1485, 1530);
		panel_main.setBackground(new Color(255, 255, 255));
		panel_main.setLayout(null);
		
		JButton button_ktx_main = new JButton(img_main);
		button_ktx_main.setBounds(50, 94, 173, 67);
		panel_main.add(button_ktx_main);
		
		JButton button_ga = new JButton(img_ga);
		button_ga.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ga.setBounds(50, 179, 76, 48);
		panel_main.add(button_ga);
		
		JButton button_na = new JButton(img_na);
		button_na.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_na.setBounds(147, 179, 76, 48);
		panel_main.add(button_na);
		
		JButton button_da = new JButton(img_da);
		button_da.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_da.setBounds(244, 179, 76, 48);
		panel_main.add(button_da);
		
		JButton button_la = new JButton(img_la);
		button_la.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_la.setBounds(341, 179, 76, 48);
		panel_main.add(button_la);
		
		JButton button_ma = new JButton(img_ma);
		button_ma.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ma.setBounds(436, 179, 76, 48);
		panel_main.add(button_ma);
		
		JButton button_ba = new JButton(img_ba);
		button_ba.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ba.setBounds(533, 179, 76, 48);
		panel_main.add(button_ba);
		
		JButton button_sa = new JButton(img_sa);
		button_sa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_sa.setBounds(634, 179, 76, 48);
		panel_main.add(button_sa);
		
		JButton button_ah = new JButton(img_ah);
		button_ah.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ah.setBounds(736, 179, 76, 48);
		panel_main.add(button_ah);
		
		JButton button_za = new JButton(img_ja);
		button_za.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_za.setBounds(833, 179, 76, 48);
		panel_main.add(button_za);
		
		JButton button_cha = new JButton(img_cha);
		button_cha.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_cha.setBounds(930, 179, 76, 48);
		panel_main.add(button_cha);
		
		JButton button_ka = new JButton(img_ka);
		button_ka.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ka.setBounds(1027, 179, 76, 48);
		panel_main.add(button_ka);
		
		JButton button_ta = new JButton(img_ta);
		button_ta.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ta.setBounds(1124, 179, 76, 48);
		panel_main.add(button_ta);
		
		JButton button_pa = new JButton(img_pa);
		button_pa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_pa.setBounds(1221, 179, 76, 48);
		panel_main.add(button_pa);
		
		JButton button_ha = new JButton(img_ha);
		button_ha.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		button_ha.setBounds(1318, 179, 76, 48);
		panel_main.add(button_ha);
		
		JPanel panel_card = new JPanel();
		panel_card.setBounds(50, 250, 1350, 672);
		panel_main.add(panel_card); 
		CardLayout cl = new CardLayout();
		panel_card.setLayout(cl);
		
		
		
		//버튼_ktx_main 액션
		button_ktx_main.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_mainKTX");
            }
		});
		
		//버튼_가 액션
		button_ga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ga");
            }
        });
		//버튼_나 액션
			button_na.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	cl.show(panel_card, "panel_na");
	            }
        });
		//버튼_다 액션
		button_da.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_da");
            }
        });
		//버튼_라 액션
		button_la.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_la");
            }
        });
		//버튼_마 액션
		button_ma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ma");
            }
        });
		//버튼_바 액션
		button_ba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ba");
            }
        });
		//버튼_사 액션
		button_sa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_sa");
            }
        });
		//버튼_아 액션
		button_ah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ah");
            }
        });
		//버튼_자 액션
		button_za.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_za");
            }
        });
		//버튼_차 액션
		button_cha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_cha");
            }
        });
		//버튼_카 액션
		button_ka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ka");
            }
        });
		//버튼_타 액션
		button_ta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ta");
            }
        });
		//버튼_파 액션
		button_pa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_pa");
            }
        });
		//버튼_하 액션
		button_ha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cl.show(panel_card, "panel_ha");
            }
        });
		JScrollPane panel_mainKTX = new JScrollPane((Component) null);
		panel_mainKTX.getVerticalScrollBar().setUnitIncrement(30);
		panel_mainKTX.setPreferredSize(new Dimension(1344, 437));
		panel_card.add(panel_mainKTX, "panel_mainKTX");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel_mainKTX.setViewportView(panel);
		panel.setPreferredSize(new Dimension(900, 900));
		panel.setAutoscrolls(true);
		
		JPanel panel_mainKTX_1 = new JPanel();
		panel_mainKTX_1.setLayout(null);
		panel_mainKTX_1.setBounds(0, 0, 1331, 798);
		panel.add(panel_mainKTX_1);
		
		JButton btn_Seoul = new JButton("서울");
		btn_Seoul.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btn_Seoul.setBounds(12, 10, 206, 120);
		btn_Seoul.addMouseListener(this);
		panel_mainKTX_1.add(btn_Seoul);
		
		
		JButton btn_Yongsan = new JButton("용산");
		btn_Yongsan.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btn_Yongsan.setBounds(230, 10, 206, 120);
		btn_Yongsan.addMouseListener(this);
		panel_mainKTX_1.add(btn_Yongsan);
		
		JButton btn_Yeongdeungpo = new JButton("영등포");
		btn_Yeongdeungpo.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btn_Yeongdeungpo.setBounds(448, 10, 206, 120);
		btn_Yeongdeungpo.addMouseListener(this);
		panel_mainKTX_1.add(btn_Yeongdeungpo);
		
		JButton btnNewButton_3_4_1 = new JButton("광명");
		btnNewButton_3_4_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_1.setBounds(666, 10, 206, 120);
		btnNewButton_3_4_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_3_4_1);
		
		JButton btnNewButton_4_4_1 = new JButton("수원");
		btnNewButton_4_4_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_1.setBounds(884, 10, 206, 120);
		btnNewButton_4_4_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_4_4_1);
		
		JButton btnNewButton_5_4_1 = new JButton("천안아산");
		btnNewButton_5_4_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_1.setBounds(1102, 10, 206, 120);
		btnNewButton_5_4_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_5_4_1);
		
		JButton btnNewButton_6_3_1 = new JButton("오송");
		btnNewButton_6_3_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_3_1.setBounds(12, 140, 206, 120);
		btnNewButton_6_3_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_6_3_1);
		
		JButton btnNewButton_7_3_1 = new JButton("대전");
		btnNewButton_7_3_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_3_1.setBounds(230, 140, 206, 120);
		btnNewButton_7_3_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_7_3_1);
		
		JButton btnNewButton_8_1_1 = new JButton("서대전");
		btnNewButton_8_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_1_1.setBounds(448, 140, 206, 120);
		btnNewButton_8_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_8_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("김천구미");
		btnNewButton_1_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_1_1.setBounds(884, 140, 206, 120);
		btnNewButton_1_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("동대구");
		btnNewButton_2_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_1_1.setBounds(1102, 140, 206, 120);
		btnNewButton_2_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("포항");
		btnNewButton_3_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_1_1.setBounds(12, 270, 206, 120);
		btnNewButton_3_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_3_1_1_1);
		
		JButton btnNewButton_4_1_1_1 = new JButton("밀양");
		btnNewButton_4_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_1_1.setBounds(230, 270, 206, 120);
		btnNewButton_4_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_4_1_1_1);
		
		JButton btnNewButton_5_1_1_1 = new JButton("구포");
		btnNewButton_5_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_1_1.setBounds(448, 270, 206, 120);
		btnNewButton_5_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_5_1_1_1);
		
		JButton btnNewButton_6_1_1_1 = new JButton("부산");
		btnNewButton_6_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_1_1.setBounds(666, 270, 206, 120);
		btnNewButton_6_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_6_1_1_1);
		
		JButton btnNewButton_7_1_1_1 = new JButton("울산(통도사)");
		btnNewButton_7_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_1_1.setBounds(884, 270, 206, 120);
		btnNewButton_7_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_7_1_1_1);
		
		JButton btnNewButton_9_1_1 = new JButton("마산");
		btnNewButton_9_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_1_1.setBounds(666, 140, 206, 120);
		btnNewButton_9_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_9_1_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("창원중앙");
		btnNewButton_1_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_1_1.setBounds(12, 400, 206, 120);
		btnNewButton_1_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_2_2_1_1 = new JButton("경산");
		btnNewButton_2_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_1_1.setBounds(230, 400, 206, 120);
		btnNewButton_2_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_2_2_1_1);
		
		JButton btnNewButton_3_2_1_1 = new JButton("논산");
		btnNewButton_3_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_1_1.setBounds(448, 400, 206, 120);
		btnNewButton_3_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_3_2_1_1);
		
		JButton btnNewButton_4_2_1_1 = new JButton("익산");
		btnNewButton_4_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_1_1.setBounds(666, 400, 206, 120);
		btnNewButton_4_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_4_2_1_1);
		
		JButton btnNewButton_5_2_1_1 = new JButton("정읍");
		btnNewButton_5_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_1_1.setBounds(884, 400, 206, 120);
		btnNewButton_5_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_5_2_1_1);
		
		JButton btnNewButton_6_2_1_1 = new JButton("광주송정");
		btnNewButton_6_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_1_1.setBounds(1102, 400, 206, 120);
		btnNewButton_6_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_6_2_1_1);
		
		JButton btnNewButton_7_2_1_1 = new JButton("목포");
		btnNewButton_7_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2_1_1.setBounds(12, 660, 206, 120);
		btnNewButton_7_2_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_7_2_1_1);
		
		JButton btnNewButton_10_1_1 = new JButton("전주");
		btnNewButton_10_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10_1_1.setBounds(1102, 270, 206, 120);
		btnNewButton_10_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_10_1_1);
		
		JButton btnNewButton_1_3_1_1 = new JButton("순천");
		btnNewButton_1_3_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3_1_1.setBounds(12, 530, 206, 120);
		btnNewButton_1_3_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_1_3_1_1);
		
		JButton btnNewButton_2_3_1_1 = new JButton("여수EXPO");
		btnNewButton_2_3_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3_1_1.setBounds(230, 530, 206, 120);
		btnNewButton_2_3_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_2_3_1_1);
		
		JButton btnNewButton_3_3_1_1 = new JButton("청량리");
		btnNewButton_3_3_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3_1_1.setBounds(448, 530, 206, 120);
		btnNewButton_3_3_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_3_3_1_1);
		
		JButton btnNewButton_4_3_1_1 = new JButton("강릉");
		btnNewButton_4_3_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3_1_1.setBounds(666, 530, 206, 120);
		btnNewButton_4_3_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_4_3_1_1);
		
		JButton btnNewButton_5_3_1_3 = new JButton("행신");
		btnNewButton_5_3_1_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_1_3.setBounds(884, 530, 206, 120);
		btnNewButton_5_3_1_3.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_5_3_1_3);
		
		JButton btnNewButton_5_3_1_1_1 = new JButton("신경주");
		btnNewButton_5_3_1_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_1_1_1.setBounds(1102, 530, 206, 120);
		btnNewButton_5_3_1_1_1.addMouseListener(this);
		panel_mainKTX_1.add(btnNewButton_5_3_1_1_1);
		
		JButton btnNewButton_5_3_1_2_1 = new JButton("정동진");
		btnNewButton_5_3_1_2_1.setBounds(230, 660, 206, 120);
		btnNewButton_5_3_1_2_1.addMouseListener(this);
		btnNewButton_5_3_1_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		panel_mainKTX_1.add(btnNewButton_5_3_1_2_1);
		
		
		JPanel panel_ga = new JPanel();
		panel_card.add(panel_ga, "panel_ga");
		panel_ga.setLayout(null);
		
		// JButton
		
		JButton btnNewButton = new JButton("가남");
		btnNewButton.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton.setBounds(12, 10, 206, 120);
		btnNewButton.addMouseListener(this);
		panel_ga.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("가평");
		btnNewButton_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1.setBounds(230, 10, 206, 120);
		btnNewButton_1.addMouseListener(this);
		panel_ga.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("각계");
		btnNewButton_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2.setBounds(448, 10, 206, 120);
		btnNewButton_2.addMouseListener(this);
		panel_ga.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("감곡장호원");
		btnNewButton_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3.setBounds(666, 10, 206, 120);
		btnNewButton_3.addMouseListener(this);
		panel_ga.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("강경");
		btnNewButton_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4.setBounds(884, 10, 206, 120);
		btnNewButton_4.addMouseListener(this);
		panel_ga.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("강구");
		btnNewButton_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5.setBounds(1102, 10, 206, 120);
		btnNewButton_5.addMouseListener(this);
		panel_ga.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("강릉");
		btnNewButton_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6.setBounds(12, 140, 206, 120);
		btnNewButton_6.addMouseListener(this);
		panel_ga.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("강촌");
		btnNewButton_7.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7.setBounds(230, 140, 206, 120);
		btnNewButton_7.addMouseListener(this);
		panel_ga.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("개포");
		btnNewButton_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8.setBounds(448, 140, 206, 120);
		btnNewButton_8.addMouseListener(this);
		panel_ga.add(btnNewButton_8);
		
		JButton btnNewButton_1_1 = new JButton("건천");
		btnNewButton_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(666, 140, 206, 120);
		btnNewButton_1_1.addMouseListener(this);
		panel_ga.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("경산");
		btnNewButton_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(884, 140, 206, 120);
		btnNewButton_2_1.addMouseListener(this);
		panel_ga.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("계룡");
		btnNewButton_3_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1.addMouseListener(this);
		panel_ga.add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("고한");
		btnNewButton_4_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(12, 270, 206, 120);
		btnNewButton_4_1.addMouseListener(this);
		panel_ga.add(btnNewButton_4_1);
		
		JButton btnNewButton_5_1 = new JButton("곡성");
		btnNewButton_5_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1.setBounds(230, 270, 206, 120);
		btnNewButton_5_1.addMouseListener(this);
		panel_ga.add(btnNewButton_5_1);
		
		JButton btnNewButton_6_1 = new JButton("공주");
		btnNewButton_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1.setBounds(448, 270, 206, 120);
		btnNewButton_6_1.addMouseListener(this);
		panel_ga.add(btnNewButton_6_1);
		
		JButton btnNewButton_7_1 = new JButton("광명");
		btnNewButton_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1.setBounds(666, 270, 206, 120);
		btnNewButton_7_1.addMouseListener(this);
		panel_ga.add(btnNewButton_7_1);
		
		JButton btnNewButton_9 = new JButton("광양");
		btnNewButton_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9.setBounds(884, 270, 206, 120);
		btnNewButton_9.addMouseListener(this);
		panel_ga.add(btnNewButton_9);
		
		JButton btnNewButton_1_2 = new JButton("광주");
		btnNewButton_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2.addMouseListener(this);
		panel_ga.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("광주송정");
		btnNewButton_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2.setBounds(12, 400, 206, 120);
		btnNewButton_2_2.addMouseListener(this);
		panel_ga.add(btnNewButton_2_2);
		
		JButton btnNewButton_3_2 = new JButton("광천");
		btnNewButton_3_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2.setBounds(230, 400, 206, 120);
		btnNewButton_3_2.addMouseListener(this);
		panel_ga.add(btnNewButton_3_2);
		
		JButton btnNewButton_4_2 = new JButton("구례구");
		btnNewButton_4_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2.setBounds(448, 400, 206, 120);
		btnNewButton_4_2.addMouseListener(this);
		panel_ga.add(btnNewButton_4_2);
		
		JButton btnNewButton_5_2 = new JButton("구미");
		btnNewButton_5_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2.setBounds(666, 400, 206, 120);
		btnNewButton_5_2.addMouseListener(this);
		panel_ga.add(btnNewButton_5_2);
		
		JButton btnNewButton_6_2 = new JButton("구포");
		btnNewButton_6_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2.setBounds(884, 400, 206, 120);
		btnNewButton_6_2.addMouseListener(this);
		panel_ga.add(btnNewButton_6_2);
		
		JButton btnNewButton_7_2 = new JButton("군복");
		btnNewButton_7_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2.setBounds(1102, 400, 206, 120);
		btnNewButton_7_2.addMouseListener(this);
		panel_ga.add(btnNewButton_7_2);
		
		JButton btnNewButton_10 = new JButton("군산");
		btnNewButton_10.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10.setBounds(12, 530, 206, 120);
		btnNewButton_10.addMouseListener(this);
		panel_ga.add(btnNewButton_10);
		
		JButton btnNewButton_1_3 = new JButton("극락강");
		btnNewButton_1_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(230, 530, 206, 120);
		btnNewButton_1_3.addMouseListener(this);
		panel_ga.add(btnNewButton_1_3);
		
		JButton btnNewButton_2_3 = new JButton("기장");
		btnNewButton_2_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3.setBounds(448, 530, 206, 120);
		btnNewButton_2_3.addMouseListener(this);
		panel_ga.add(btnNewButton_2_3);
		
		JButton btnNewButton_3_3 = new JButton("김제");
		btnNewButton_3_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3.setBounds(666, 530, 206, 120);
		btnNewButton_3_3.addMouseListener(this);
		panel_ga.add(btnNewButton_3_3);
		
		JButton btnNewButton_4_3 = new JButton("김천");
		btnNewButton_4_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3.setBounds(884, 530, 206, 120);
		btnNewButton_4_3.addMouseListener(this);
		panel_ga.add(btnNewButton_4_3);
		
		JButton btnNewButton_5_3 = new JButton("김천구미");
		btnNewButton_5_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3.setBounds(1102, 530, 206, 120);
		btnNewButton_5_3.addMouseListener(this);
		panel_ga.add(btnNewButton_5_3);
		
		JPanel panel_na = new JPanel();
		panel_na.setLayout(null);
		panel_card.add(panel_na, "panel_na");
		
		JButton btnNewButton_12 = new JButton("나전");
		btnNewButton_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_12.setBounds(12, 10, 206, 120);
		btnNewButton_12.addMouseListener(this);
		panel_na.add(btnNewButton_12);
		
		JButton btnNewButton_1_5 = new JButton("나주");
		btnNewButton_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_5.setBounds(230, 10, 206, 120);
		btnNewButton_1_5.addMouseListener(this);
		panel_na.add(btnNewButton_1_5);
		
		JButton btnNewButton_2_5 = new JButton("남성현");
		btnNewButton_2_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_5.setBounds(448, 10, 206, 120);
		btnNewButton_2_5.addMouseListener(this);
		panel_na.add(btnNewButton_2_5);
		
		JButton btnNewButton_3_5 = new JButton("남원");
		btnNewButton_3_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_5.setBounds(666, 10, 206, 120);
		btnNewButton_3_5.addMouseListener(this);
		panel_na.add(btnNewButton_3_5);
		
		JButton btnNewButton_4_5 = new JButton("남창");
		btnNewButton_4_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_5.setBounds(884, 10, 206, 120);
		btnNewButton_4_5.addMouseListener(this);
		panel_na.add(btnNewButton_4_5);
		
		JButton btnNewButton_5_5 = new JButton("남춘천");
		btnNewButton_5_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_5.setBounds(1102, 10, 206, 120);
		btnNewButton_5_5.addMouseListener(this);
		panel_na.add(btnNewButton_5_5);
		
		JButton btnNewButton_6_5 = new JButton("논산");
		btnNewButton_6_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_5.setBounds(12, 140, 206, 120);
		btnNewButton_6_5.addMouseListener(this);
		panel_na.add(btnNewButton_6_5);
		
		JButton btnNewButton_7_5 = new JButton("능주");
		btnNewButton_7_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_5.setBounds(230, 140, 206, 120);
		btnNewButton_7_5.addMouseListener(this);
		panel_na.add(btnNewButton_7_5);
		
		JPanel panel_da = new JPanel();
		panel_da.setLayout(null);
		panel_card.add(panel_da, "panel_da");
		
		JButton btnNewButton_13 = new JButton("다시");
		btnNewButton_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_13.setBounds(12, 10, 206, 120);
		btnNewButton_13.addMouseListener(this);
		panel_da.add(btnNewButton_13);
		
		JButton btnNewButton_1_6 = new JButton("단양");
		btnNewButton_1_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_6.setBounds(230, 10, 206, 120);
		btnNewButton_1_6.addMouseListener(this);
		panel_da.add(btnNewButton_1_6);
		
		JButton btnNewButton_2_6 = new JButton("대구");
		btnNewButton_2_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_6.setBounds(448, 10, 206, 120);
		btnNewButton_2_6.addMouseListener(this);
		panel_da.add(btnNewButton_2_6);
		
		JButton btnNewButton_3_6 = new JButton("대야");
		btnNewButton_3_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_6.setBounds(666, 10, 206, 120);
		btnNewButton_3_6.addMouseListener(this);
		panel_da.add(btnNewButton_3_6);
		
		JButton btnNewButton_4_6 = new JButton("대전");
		btnNewButton_4_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_6.setBounds(884, 10, 206, 120);
		btnNewButton_4_6.addMouseListener(this);
		panel_da.add(btnNewButton_4_6);
		
		JButton btnNewButton_5_6 = new JButton("대천");
		btnNewButton_5_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_6.setBounds(1102, 10, 206, 120);
		btnNewButton_5_6.addMouseListener(this);
		panel_da.add(btnNewButton_5_6);
		
		JButton btnNewButton_6_6 = new JButton("덕소");
		btnNewButton_6_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_6.setBounds(12, 140, 206, 120);
		btnNewButton_6_6.addMouseListener(this);
		panel_da.add(btnNewButton_6_6);
		
		JButton btnNewButton_7_6 = new JButton("덕하");
		btnNewButton_7_6.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_6.setBounds(230, 140, 206, 120);
		btnNewButton_7_6.addMouseListener(this);
		panel_da.add(btnNewButton_7_6);
		
		JButton btnNewButton_8_2 = new JButton("도계");
		btnNewButton_8_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_2.setBounds(448, 140, 206, 120);
		btnNewButton_8_2.addMouseListener(this);
		panel_da.add(btnNewButton_8_2);
		
		JButton btnNewButton_1_1_2 = new JButton("도고온천");
		btnNewButton_1_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_2.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_2_1_2 = new JButton("도라산");
		btnNewButton_2_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_2.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_3_1_2 = new JButton("동대구");
		btnNewButton_3_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_2.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_3_1_2);
		
		JButton btnNewButton_4_1_2 = new JButton("동백산");
		btnNewButton_4_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_2.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_4_1_2);
		
		JButton btnNewButton_5_1_2 = new JButton("동탄");
		btnNewButton_5_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_2.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_6_1_2 = new JButton("동해");
		btnNewButton_6_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_2.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_6_1_2);
		
		JButton btnNewButton_7_1_2 = new JButton("동화");
		btnNewButton_7_1_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_2.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_2.addMouseListener(this);
		panel_da.add(btnNewButton_7_1_2);
		
		JButton btnNewButton_9_2 = new JButton("둔내");
		btnNewButton_9_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_2.setBounds(884, 270, 206, 120);
		btnNewButton_9_2.addMouseListener(this);
		panel_da.add(btnNewButton_9_2);
		
		JButton btnNewButton_1_2_2 = new JButton("득량");
		btnNewButton_1_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_2.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_2.addMouseListener(this);
		panel_da.add(btnNewButton_1_2_2);
		
		JPanel panel_la = new JPanel();
		panel_la.setLayout(null);
		panel_card.add(panel_la, "panel_la");
		
		JLabel lblNewLabel = new JLabel("역정보 없음");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 80));
		lblNewLabel.setBounds(12, 0, 1326, 700);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_la.add(lblNewLabel);
		
		JPanel panel_ma = new JPanel();
		panel_ma.setLayout(null);
		panel_card.add(panel_ma, "panel_ma");
		
		JButton btnNewButton_15 = new JButton("마산");
		btnNewButton_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_15.setBounds(12, 10, 206, 120);
		btnNewButton_15.addMouseListener(this);
		panel_ma.add(btnNewButton_15);
		
		JButton btnNewButton_1_8 = new JButton("마석");
		btnNewButton_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_8.setBounds(230, 10, 206, 120);
		btnNewButton_1_8.addMouseListener(this);
		panel_ma.add(btnNewButton_1_8);
		
		JButton btnNewButton_2_8 = new JButton("만종");
		btnNewButton_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_8.setBounds(448, 10, 206, 120);
		btnNewButton_2_8.addMouseListener(this);
		panel_ma.add(btnNewButton_2_8);
		
		JButton btnNewButton_3_8 = new JButton("매곡");
		btnNewButton_3_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_8.setBounds(666, 10, 206, 120);
		btnNewButton_3_8.addMouseListener(this);
		panel_ma.add(btnNewButton_3_8);
		
		JButton btnNewButton_4_8 = new JButton("명봉");
		btnNewButton_4_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_8.setBounds(884, 10, 206, 120);
		btnNewButton_4_8.addMouseListener(this);
		panel_ma.add(btnNewButton_4_8);
		
		JButton btnNewButton_5_8 = new JButton("목포");
		btnNewButton_5_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_8.setBounds(1102, 10, 206, 120);
		btnNewButton_5_8.addMouseListener(this);
		panel_ma.add(btnNewButton_5_8);
		
		JButton btnNewButton_6_8 = new JButton("몽탄");
		btnNewButton_6_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_8.setBounds(12, 140, 206, 120);
		btnNewButton_6_8.addMouseListener(this);
		panel_ma.add(btnNewButton_6_8);
		
		JButton btnNewButton_7_8 = new JButton("무안");
		btnNewButton_7_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_8.setBounds(230, 140, 206, 120);
		btnNewButton_7_8.addMouseListener(this);
		panel_ma.add(btnNewButton_7_8);
		
		JButton btnNewButton_8_4 = new JButton("묵호");
		btnNewButton_8_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_4.setBounds(448, 140, 206, 120);
		btnNewButton_8_4.addMouseListener(this);
		panel_ma.add(btnNewButton_8_4);
		
		JButton btnNewButton_1_1_4 = new JButton("문산");
		btnNewButton_1_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_4.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_4.addMouseListener(this);
		panel_ma.add(btnNewButton_1_1_4);
		
		JButton btnNewButton_2_1_4 = new JButton("물금");
		btnNewButton_2_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_4.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_4.addMouseListener(this);
		panel_ma.add(btnNewButton_2_1_4);
		
		JButton btnNewButton_3_1_4 = new JButton("민둥산");
		btnNewButton_3_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_4.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_4.addMouseListener(this);
		panel_ma.add(btnNewButton_3_1_4);
		
		JButton btnNewButton_4_1_4 = new JButton("밀양");
		btnNewButton_4_1_4.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_4.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_4.addMouseListener(this);
		panel_ma.add(btnNewButton_4_1_4);
		
		JPanel panel_ba = new JPanel();
		panel_ba.setLayout(null);
		panel_card.add(panel_ba, "panel_ba");
		
		JButton btnNewButton_16 = new JButton("반곡");
		btnNewButton_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_16.setBounds(12, 10, 206, 120);
		btnNewButton_16.addMouseListener(this);
		panel_ba.add(btnNewButton_16);
		
		JButton btnNewButton_1_9 = new JButton("반성");
		btnNewButton_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_9.setBounds(230, 10, 206, 120);
		btnNewButton_1_9.addMouseListener(this);
		panel_ba.add(btnNewButton_1_9);
		
		JButton btnNewButton_2_9 = new JButton("백양리");
		btnNewButton_2_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_9.setBounds(448, 10, 206, 120);
		btnNewButton_2_9.addMouseListener(this);
		panel_ba.add(btnNewButton_2_9);
		
		JButton btnNewButton_3_9 = new JButton("백양사");
		btnNewButton_3_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_9.setBounds(666, 10, 206, 120);
		btnNewButton_3_9.addMouseListener(this);
		panel_ba.add(btnNewButton_3_9);
		
		JButton btnNewButton_4_9 = new JButton("벌교");
		btnNewButton_4_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_9.setBounds(884, 10, 206, 120);
		btnNewButton_4_9.addMouseListener(this);
		panel_ba.add(btnNewButton_4_9);
		
		JButton btnNewButton_5_9 = new JButton("별어곡");
		btnNewButton_5_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_9.setBounds(1102, 10, 206, 120);
		btnNewButton_5_9.addMouseListener(this);
		panel_ba.add(btnNewButton_5_9);
		
		JButton btnNewButton_6_9 = new JButton("보성");
		btnNewButton_6_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_9.setBounds(12, 140, 206, 120);
		btnNewButton_6_9.addMouseListener(this);
		panel_ba.add(btnNewButton_6_9);
		
		JButton btnNewButton_7_9 = new JButton("봉양");
		btnNewButton_7_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_9.setBounds(230, 140, 206, 120);
		btnNewButton_7_9.addMouseListener(this);
		panel_ba.add(btnNewButton_7_9);
		
		JButton btnNewButton_8_5 = new JButton("봉화");
		btnNewButton_8_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_5.setBounds(448, 140, 206, 120);
		btnNewButton_8_5.addMouseListener(this);
		panel_ba.add(btnNewButton_8_5);
		
		JButton btnNewButton_1_1_5 = new JButton("부강");
		btnNewButton_1_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_5.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_1_1_5);
		
		JButton btnNewButton_2_1_5 = new JButton("부발");
		btnNewButton_2_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_5.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_2_1_5);
		
		JButton btnNewButton_3_1_5 = new JButton("부산");
		btnNewButton_3_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_5.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_3_1_5);
		
		JButton btnNewButton_4_1_5 = new JButton("부전");
		btnNewButton_4_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_5.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_4_1_5);
		
		JButton btnNewButton_5_1_5 = new JButton("북영천");
		btnNewButton_5_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_5.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_5_1_5);
		
		JButton btnNewButton_6_1_5 = new JButton("북울산");
		btnNewButton_6_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_5.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_6_1_5);
		
		JButton btnNewButton_7_1_5 = new JButton("북천");
		btnNewButton_7_1_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_5.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_5.addMouseListener(this);
		panel_ba.add(btnNewButton_7_1_5);
		
		JButton btnNewButton_9_5 = new JButton("불국사");
		btnNewButton_9_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_5.setBounds(884, 270, 206, 120);
		btnNewButton_9_5.addMouseListener(this);
		panel_ba.add(btnNewButton_9_5);
		
		JButton btnNewButton_1_2_5 = new JButton("비동");
		btnNewButton_1_2_5.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_5.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_5.addMouseListener(this);
		panel_ba.add(btnNewButton_1_2_5);
		
		JScrollPane panel_sa = new JScrollPane((Component) null);
		panel_sa.getVerticalScrollBar().setUnitIncrement(30);
		panel_sa.setPreferredSize(new Dimension(1340, 800));
		panel_card.add(panel_sa, "panel_sa");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(900, 1000));
		panel_1.setAutoscrolls(true);
		panel_sa.setViewportView(panel_1);
		
		JPanel panel_sa_1 = new JPanel();
		panel_sa_1.setLayout(null);
		panel_sa_1.setBounds(0, 0, 1319, 1068);
		panel_1.add(panel_sa_1);
		
		JButton btnNewButton_17_1 = new JButton("사릉");
		btnNewButton_17_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_17_1.setBounds(12, 10, 206, 120);
		btnNewButton_17_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_17_1);
		
		JButton btnNewButton_1_10_1 = new JButton("사북");
		btnNewButton_1_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_10_1.setBounds(230, 10, 206, 120);
		btnNewButton_1_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_1_10_1);
		
		JButton btnNewButton_2_10_1 = new JButton("사상");
		btnNewButton_2_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_10_1.setBounds(448, 10, 206, 120);
		btnNewButton_2_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_2_10_1);
		
		JButton btnNewButton_3_10_1 = new JButton("삼랑진");
		btnNewButton_3_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_10_1.setBounds(666, 10, 206, 120);
		btnNewButton_3_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_3_10_1);
		
		JButton btnNewButton_4_10_1 = new JButton("삼례");
		btnNewButton_4_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_10_1.setBounds(884, 10, 206, 120);
		btnNewButton_4_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_4_10_1);
		
		JButton btnNewButton_5_10_1 = new JButton("삼산");
		btnNewButton_5_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_10_1.setBounds(1102, 10, 206, 120);
		btnNewButton_5_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_5_10_1);
		
		JButton btnNewButton_6_10_1 = new JButton("삼탄");
		btnNewButton_6_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_10_1.setBounds(12, 140, 206, 120);
		btnNewButton_6_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_6_10_1);
		
		JButton btnNewButton_7_10_1 = new JButton("삽교");
		btnNewButton_7_10_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_10_1.setBounds(230, 140, 206, 120);
		btnNewButton_7_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_7_10_1);
		
		JButton btnNewButton_8_6_1 = new JButton("상동");
		btnNewButton_8_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_6_1.setBounds(448, 140, 206, 120);
		btnNewButton_8_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_8_6_1);
		
		JButton btnNewButton_1_1_6_1 = new JButton("상봉");
		btnNewButton_1_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_6_1.setBounds(666, 140, 206, 120);
		btnNewButton_1_10_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_1_1_6_1);
		
		JButton btnNewButton_2_1_6_1 = new JButton("상주");
		btnNewButton_2_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_6_1.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_2_1_6_1);
		
		JButton btnNewButton_3_1_6_1 = new JButton("서경주");
		btnNewButton_3_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_6_1.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_3_1_6_1);
		
		JButton btnNewButton_4_1_6_1 = new JButton("서광주");
		btnNewButton_4_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_6_1.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_4_1_6_1);
		
		JButton btnNewButton_5_1_6_1 = new JButton("서대구");
		btnNewButton_5_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_6_1.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_5_1_6_1);
		
		JButton btnNewButton_6_1_6_1 = new JButton("서대전");
		btnNewButton_6_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_6_1.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_6_1_6_1);
		
		JButton btnNewButton_7_1_6_1 = new JButton("서울");
		btnNewButton_7_1_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_6_1.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_7_1_6_1);
		
		JButton btnNewButton_9_6_1 = new JButton("서원주");
		btnNewButton_9_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_6_1.setBounds(884, 270, 206, 120);
		btnNewButton_9_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_9_6_1);
		
		JButton btnNewButton_1_2_6_1 = new JButton("서정리");
		btnNewButton_1_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_6_1.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_1_2_6_1);
		
		JButton btnNewButton_2_2_6_1 = new JButton("서천");
		btnNewButton_2_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_6_1.setBounds(12, 400, 206, 120);
		btnNewButton_2_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_2_2_6_1);
		
		JButton btnNewButton_3_2_6_1 = new JButton("석불");
		btnNewButton_3_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_6_1.setBounds(230, 400, 206, 120);
		btnNewButton_3_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_3_2_6_1);
		
		JButton btnNewButton_4_2_6_1 = new JButton("석포");
		btnNewButton_4_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_6_1.setBounds(448, 400, 206, 120);
		btnNewButton_4_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_4_2_6_1);
		
		JButton btnNewButton_5_2_6_1 = new JButton("선평");
		btnNewButton_5_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_6_1.setBounds(666, 400, 206, 120);
		btnNewButton_5_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_5_2_6_1);
		
		JButton btnNewButton_6_2_6_1 = new JButton("성환");
		btnNewButton_6_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_6_1.setBounds(884, 400, 206, 120);
		btnNewButton_6_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_6_2_6_1);
		
		JButton btnNewButton_7_2_6_1 = new JButton("센텀");
		btnNewButton_7_2_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2_6_1.setBounds(1102, 400, 206, 120);
		btnNewButton_7_2_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_7_2_6_1);
		
		JButton btnNewButton_10_6_1 = new JButton("수서");
		btnNewButton_10_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10_6_1.setBounds(12, 530, 206, 120);
		btnNewButton_10_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_10_6_1);
		
		JButton btnNewButton_1_3_6_1 = new JButton("수원");
		btnNewButton_1_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3_6_1.setBounds(230, 530, 206, 120);
		btnNewButton_1_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_1_3_6_1);
		
		JButton btnNewButton_2_3_6_1 = new JButton("순천");
		btnNewButton_2_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3_6_1.setBounds(448, 530, 206, 120);
		btnNewButton_2_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_2_3_6_1);
		
		JButton btnNewButton_3_3_6_1 = new JButton("승부");
		btnNewButton_3_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3_6_1.setBounds(666, 530, 206, 120);
		btnNewButton_3_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_3_3_6_1);
		
		JButton btnNewButton_4_3_6_1 = new JButton("신경주");
		btnNewButton_4_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3_6_1.setBounds(884, 530, 206, 120);
		btnNewButton_4_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_4_3_6_1);
		
		JButton btnNewButton_5_3_6_1 = new JButton("신기");
		btnNewButton_5_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_6_1.setBounds(1102, 530, 206, 120);
		btnNewButton_5_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_5_3_6_1);
		
		JButton btnNewButton_6_3_6_1 = new JButton("신녕");
		btnNewButton_6_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_3_6_1.setBounds(12, 657, 206, 120);
		btnNewButton_6_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_6_3_6_1);
		
		JButton btnNewButton_7_3_6_1 = new JButton("신동");
		btnNewButton_7_3_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_3_6_1.setBounds(230, 657, 206, 120);
		btnNewButton_7_3_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_7_3_6_1);
		
		JButton btnNewButton_2_4_6_1 = new JButton("신탄진");
		btnNewButton_2_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_6_1.setBounds(884, 660, 206, 120);
		btnNewButton_2_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_2_4_6_1);
		
		JButton btnNewButton_3_4_6_1 = new JButton("신태인");
		btnNewButton_3_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_6_1.setBounds(1102, 660, 206, 120);
		btnNewButton_3_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_3_4_6_1);
		
		JButton btnNewButton_4_4_6_1 = new JButton("신해운대");
		btnNewButton_4_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_6_1.setBounds(12, 787, 206, 120);
		btnNewButton_4_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_4_4_6_1);
		
		JButton btnNewButton_5_4_6_1 = new JButton("심천");
		btnNewButton_5_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_6_1.setBounds(230, 787, 206, 120);
		btnNewButton_5_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_5_4_6_1);
		
		JButton btnNewButton_6_4_6_1 = new JButton("쌍룡");
		btnNewButton_6_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_6_1.setBounds(448, 787, 206, 120);
		btnNewButton_6_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_6_4_6_1);
		
		JButton btnNewButton_11_6_1 = new JButton("신례원");
		btnNewButton_11_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_6_1.setBounds(448, 660, 206, 120);
		btnNewButton_11_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_11_6_1);
		
		JButton btnNewButton_1_4_6_1 = new JButton("신림");
		btnNewButton_1_4_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_6_1.setBounds(666, 660, 206, 120);
		btnNewButton_1_4_6_1.addMouseListener(this);
		panel_sa_1.add(btnNewButton_1_4_6_1);
		
		JPanel panel_za = new JPanel();
		panel_za.setLayout(null);
		panel_card.add(panel_za, "panel_za");
		
		JButton btnNewButton_19 = new JButton("장사");
		btnNewButton_19.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_19.setBounds(12, 10, 206, 120);
		btnNewButton_19.addMouseListener(this);
		panel_za.add(btnNewButton_19);
		
		JButton btnNewButton_1_12 = new JButton("장성");
		btnNewButton_1_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_12.setBounds(230, 10, 206, 120);
		btnNewButton_1_12.addMouseListener(this);
		panel_za.add(btnNewButton_1_12);
		
		JButton btnNewButton_2_12 = new JButton("장항");
		btnNewButton_2_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_12.setBounds(448, 10, 206, 120);
		btnNewButton_2_12.addMouseListener(this);
		panel_za.add(btnNewButton_2_12);
		
		JButton btnNewButton_3_12 = new JButton("전의");
		btnNewButton_3_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_12.setBounds(666, 10, 206, 120);
		btnNewButton_3_12.addMouseListener(this);
		panel_za.add(btnNewButton_3_12);
		
		JButton btnNewButton_4_12 = new JButton("전주");
		btnNewButton_4_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_12.setBounds(884, 10, 206, 120);
		btnNewButton_4_12.addMouseListener(this);
		panel_za.add(btnNewButton_4_12);
		
		JButton btnNewButton_5_12 = new JButton("점촌");
		btnNewButton_5_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_12.setBounds(1102, 10, 206, 120);
		btnNewButton_5_12.addMouseListener(this);
		panel_za.add(btnNewButton_5_12);
		
		JButton btnNewButton_6_12 = new JButton("정동진");
		btnNewButton_6_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_12.setBounds(12, 140, 206, 120);
		btnNewButton_6_12.addMouseListener(this);
		panel_za.add(btnNewButton_6_12);
		
		JButton btnNewButton_7_12 = new JButton("정선");
		btnNewButton_7_12.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_12.setBounds(230, 140, 206, 120);
		btnNewButton_7_12.addMouseListener(this);
		panel_za.add(btnNewButton_7_12);
		
		JButton btnNewButton_8_8 = new JButton("정읍");
		btnNewButton_8_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_8.setBounds(448, 140, 206, 120);
		btnNewButton_8_8.addMouseListener(this);
		panel_za.add(btnNewButton_8_8);
		
		JButton btnNewButton_1_1_8 = new JButton("제천");
		btnNewButton_1_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_8.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_1_1_8);
		
		JButton btnNewButton_2_1_8 = new JButton("조성");
		btnNewButton_2_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_8.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_2_1_8);
		
		JButton btnNewButton_3_1_8 = new JButton("조치원");
		btnNewButton_3_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_8.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_3_1_8);
		
		JButton btnNewButton_4_1_8 = new JButton("좌천");
		btnNewButton_4_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_8.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_4_1_8);
		
		JButton btnNewButton_5_1_8 = new JButton("주덕");
		btnNewButton_5_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_8.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_5_1_8);
		
		JButton btnNewButton_6_1_8 = new JButton("중리");
		btnNewButton_6_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_8.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_6_1_8);
		
		JButton btnNewButton_7_1_8 = new JButton("증평");
		btnNewButton_7_1_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_8.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_8.addMouseListener(this);
		panel_za.add(btnNewButton_7_1_8);
		
		JButton btnNewButton_9_8 = new JButton("지탄");
		btnNewButton_9_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_8.setBounds(884, 270, 206, 120);
		btnNewButton_9_8.addMouseListener(this);
		panel_za.add(btnNewButton_9_8);
		
		JButton btnNewButton_1_2_8 = new JButton("지평");
		btnNewButton_1_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_8.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_1_2_8);
		
		JButton btnNewButton_2_2_8 = new JButton("진례");
		btnNewButton_2_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_8.setBounds(12, 397, 206, 120);
		btnNewButton_2_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_2_2_8);
		
		JButton btnNewButton_3_2_8 = new JButton("진부(오대산)");
		btnNewButton_3_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_8.setBounds(230, 397, 206, 120);
		btnNewButton_3_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_3_2_8);
		
		JButton btnNewButton_4_2_8 = new JButton("진상");
		btnNewButton_4_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_8.setBounds(448, 397, 206, 120);
		btnNewButton_4_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_4_2_8);
		
		JButton btnNewButton_5_2_8 = new JButton("진영");
		btnNewButton_5_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_8.setBounds(666, 397, 206, 120);
		btnNewButton_5_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_5_2_8);
		
		JButton btnNewButton_6_2_8 = new JButton("진주");
		btnNewButton_6_2_8.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_8.setBounds(884, 397, 206, 120);
		btnNewButton_6_2_8.addMouseListener(this);
		panel_za.add(btnNewButton_6_2_8);
		
		JPanel panel_cha = new JPanel();
		panel_cha.setLayout(null);
		panel_card.add(panel_cha, "panel_cha");
		
		JButton btnNewButton_20 = new JButton("창원");
		btnNewButton_20.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_20.setBounds(12, 10, 206, 120);
		btnNewButton_20.addMouseListener(this);
		panel_cha.add(btnNewButton_20);
		
		JButton btnNewButton_1_13 = new JButton("창원중앙");
		btnNewButton_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_13.setBounds(230, 10, 206, 120);
		btnNewButton_1_13.addMouseListener(this);
		panel_cha.add(btnNewButton_1_13);
		
		JButton btnNewButton_2_13 = new JButton("천안");
		btnNewButton_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_13.setBounds(448, 10, 206, 120);
		btnNewButton_2_13.addMouseListener(this);
		panel_cha.add(btnNewButton_2_13);
		
		JButton btnNewButton_3_13 = new JButton("천안아산");
		btnNewButton_3_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_13.setBounds(666, 10, 206, 120);
		btnNewButton_3_13.addMouseListener(this);
		panel_cha.add(btnNewButton_3_13);
		
		JButton btnNewButton_4_13 = new JButton("철암");
		btnNewButton_4_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_13.setBounds(884, 10, 206, 120);
		btnNewButton_4_13.addMouseListener(this);
		panel_cha.add(btnNewButton_4_13);
		
		JButton btnNewButton_5_13 = new JButton("청도");
		btnNewButton_5_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_13.setBounds(1102, 10, 206, 120);
		btnNewButton_5_13.addMouseListener(this);
		panel_cha.add(btnNewButton_5_13);
		
		JButton btnNewButton_6_13 = new JButton("청량리");
		btnNewButton_6_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_13.setBounds(12, 136, 206, 120);
		btnNewButton_6_13.addMouseListener(this);
		panel_cha.add(btnNewButton_6_13);
		
		JButton btnNewButton_7_13 = new JButton("청리");
		btnNewButton_7_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_13.setBounds(230, 136, 206, 120);
		btnNewButton_7_13.addMouseListener(this);
		panel_cha.add(btnNewButton_7_13);
		
		JButton btnNewButton_8_9 = new JButton("청소");
		btnNewButton_8_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_9.setBounds(448, 136, 206, 120);
		btnNewButton_8_9.addMouseListener(this);
		panel_cha.add(btnNewButton_8_9);
		
		JButton btnNewButton_1_1_9 = new JButton("청주");
		btnNewButton_1_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_9.setBounds(666, 136, 206, 120);
		btnNewButton_1_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_1_1_9);
		
		JButton btnNewButton_2_1_9 = new JButton("청주공항");
		btnNewButton_2_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_9.setBounds(884, 136, 206, 120);
		btnNewButton_2_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_2_1_9);
		
		JButton btnNewButton_3_1_9 = new JButton("청평");
		btnNewButton_3_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_9.setBounds(1102, 136, 206, 120);
		btnNewButton_3_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_3_1_9);
		
		JButton btnNewButton_4_1_9 = new JButton("추풍령");
		btnNewButton_4_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_9.setBounds(12, 266, 206, 120);
		btnNewButton_4_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_4_1_9);
		
		JButton btnNewButton_5_1_9 = new JButton("춘양");
		btnNewButton_5_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_9.setBounds(230, 266, 206, 120);
		btnNewButton_5_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_5_1_9);
		
		JButton btnNewButton_6_1_9 = new JButton("춘천");
		btnNewButton_6_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_9.setBounds(448, 266, 206, 120);
		btnNewButton_6_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_6_1_9);
		
		JButton btnNewButton_7_1_9 = new JButton("충주");
		btnNewButton_7_1_9.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_9.setBounds(666, 266, 206, 120);
		btnNewButton_7_1_9.addMouseListener(this);
		panel_cha.add(btnNewButton_7_1_9);
		
		JPanel panel_ka = new JPanel();
		panel_ka.setLayout(null);
		panel_card.add(panel_ka, "panel_ka");
		
		JLabel lblNewLabel_1 = new JLabel("역정보 없음");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("HY헤드라인M", Font.BOLD, 80));
		lblNewLabel_1.setBounds(12, 0, 1326, 700);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ka.add(lblNewLabel_1);
		
		JPanel panel_ta = new JPanel();
		panel_ta.setLayout(null);
		panel_card.add(panel_ta, "panel_ta");
		
		JButton btnNewButton_22 = new JButton("탑리");
		btnNewButton_22.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_22.setBounds(12, 10, 206, 120);
		btnNewButton_22.addMouseListener(this);
		panel_ta.add(btnNewButton_22);
		
		JButton btnNewButton_1_15 = new JButton("태백");
		btnNewButton_1_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_15.setBounds(230, 10, 206, 120);
		btnNewButton_1_15.addMouseListener(this);
		panel_ta.add(btnNewButton_1_15);
		
		JButton btnNewButton_2_15 = new JButton("태화강");
		btnNewButton_2_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_15.setBounds(448, 10, 206, 120);
		btnNewButton_2_15.addMouseListener(this);
		panel_ta.add(btnNewButton_2_15);
		
		JButton btnNewButton_3_15 = new JButton("퇴계원");
		btnNewButton_3_15.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_15.setBounds(666, 10, 206, 120);
		btnNewButton_3_15.addMouseListener(this);
		panel_ta.add(btnNewButton_3_15);
		
		JPanel panel_pa = new JPanel();
		panel_pa.setLayout(null);
		panel_card.add(panel_pa, "panel_pa");
		
		JButton btnNewButton_23 = new JButton("판교");
		btnNewButton_23.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_23.setBounds(12, 10, 206, 120);
		btnNewButton_23.addMouseListener(this);
		panel_pa.add(btnNewButton_23);
		
		JButton btnNewButton_1_16 = new JButton("평내호평");
		btnNewButton_1_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_16.setBounds(230, 10, 206, 120);
		btnNewButton_1_16.addMouseListener(this);
		panel_pa.add(btnNewButton_1_16);
		
		JButton btnNewButton_2_16 = new JButton("평창");
		btnNewButton_2_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_16.setBounds(448, 10, 206, 120);
		btnNewButton_2_16.addMouseListener(this);
		panel_pa.add(btnNewButton_2_16);
		
		JButton btnNewButton_3_16 = new JButton("평택");
		btnNewButton_3_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_16.setBounds(666, 10, 206, 120);
		btnNewButton_3_16.addMouseListener(this);
		panel_pa.add(btnNewButton_3_16);
		
		JButton btnNewButton_4_16 = new JButton("평택지제");
		btnNewButton_4_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_16.setBounds(884, 10, 206, 120);
		btnNewButton_4_16.addMouseListener(this);
		panel_pa.add(btnNewButton_4_16);
		
		JButton btnNewButton_5_16 = new JButton("포항");
		btnNewButton_5_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_16.setBounds(1102, 10, 206, 120);
		btnNewButton_5_16.addMouseListener(this);
		panel_pa.add(btnNewButton_5_16);
		
		JButton btnNewButton_6_16 = new JButton("풍기");
		btnNewButton_6_16.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_16.setBounds(12, 140, 206, 120);
		btnNewButton_6_16.addMouseListener(this);
		panel_pa.add(btnNewButton_6_16);
		
		JPanel panel_ha = new JPanel();
		panel_ha.setLayout(null);
		panel_card.add(panel_ha, "panel_ha");
		
		JButton btnNewButton_24 = new JButton("하동");
		btnNewButton_24.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_24.setBounds(12, 10, 206, 120);
		btnNewButton_24.addMouseListener(this);
		panel_ha.add(btnNewButton_24);
		
		JButton btnNewButton_1_17 = new JButton("하양");
		btnNewButton_1_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_17.setBounds(230, 10, 206, 120);
		btnNewButton_1_17.addMouseListener(this);
		panel_ha.add(btnNewButton_1_17);
		
		JButton btnNewButton_2_17 = new JButton("한림정");
		btnNewButton_2_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_17.setBounds(448, 10, 206, 120);
		btnNewButton_2_17.addMouseListener(this);
		panel_ha.add(btnNewButton_2_17);
		
		JButton btnNewButton_3_17 = new JButton("함안");
		btnNewButton_3_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_17.setBounds(666, 10, 206, 120);
		btnNewButton_3_17.addMouseListener(this);
		panel_ha.add(btnNewButton_3_17);
		
		JButton btnNewButton_4_17 = new JButton("함열");
		btnNewButton_4_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_17.setBounds(884, 10, 206, 120);
		btnNewButton_4_17.addMouseListener(this);
		panel_ha.add(btnNewButton_4_17);
		
		JButton btnNewButton_5_17 = new JButton("함창");
		btnNewButton_5_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_17.setBounds(1102, 10, 206, 120);
		btnNewButton_5_17.addMouseListener(this);
		panel_ha.add(btnNewButton_5_17);
		
		JButton btnNewButton_6_17 = new JButton("함평");
		btnNewButton_6_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_17.setBounds(12, 140, 206, 120);
		btnNewButton_6_17.addMouseListener(this);
		panel_ha.add(btnNewButton_6_17);
		
		JButton btnNewButton_7_17 = new JButton("행신");
		btnNewButton_7_17.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_17.setBounds(230, 140, 206, 120);
		btnNewButton_7_17.addMouseListener(this);
		panel_ha.add(btnNewButton_7_17);
		
		JButton btnNewButton_8_13 = new JButton("현동");
		btnNewButton_8_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_13.setBounds(448, 140, 206, 120);
		btnNewButton_8_13.addMouseListener(this);
		panel_ha.add(btnNewButton_8_13);
		
		JButton btnNewButton_1_1_13 = new JButton("호계");
		btnNewButton_1_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_13.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_1_1_13);
		
		JButton btnNewButton_2_1_13 = new JButton("홍성");
		btnNewButton_2_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_13.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_2_1_13);
		
		JButton btnNewButton_3_1_13 = new JButton("화명");
		btnNewButton_3_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_13.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_3_1_13);
		
		JButton btnNewButton_4_1_13 = new JButton("화본");
		btnNewButton_4_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_13.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_4_1_13);
		
		JButton btnNewButton_5_1_13 = new JButton("화순");
		btnNewButton_5_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_13.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_5_1_13);
		
		JButton btnNewButton_6_1_13 = new JButton("황간");
		btnNewButton_6_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_13.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_6_1_13);
		
		JButton btnNewButton_7_1_13 = new JButton("횡성");
		btnNewButton_7_1_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_13.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_13.addMouseListener(this);
		panel_ha.add(btnNewButton_7_1_13);
		
		JButton btnNewButton_9_13 = new JButton("횡천");
		btnNewButton_9_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_13.setBounds(884, 270, 206, 120);
		btnNewButton_9_13.addMouseListener(this);
		panel_ha.add(btnNewButton_9_13);
		
		JButton btnNewButton_1_2_13 = new JButton("효천");
		btnNewButton_1_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_13.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_13.addMouseListener(this);
		panel_ha.add(btnNewButton_1_2_13);
		
		JButton btnNewButton_2_2_13 = new JButton("희방사");
		btnNewButton_2_2_13.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_13.setBounds(12, 400, 206, 120);
		btnNewButton_2_2_13.addMouseListener(this);
		panel_ha.add(btnNewButton_2_2_13);
		
		JScrollPane panel_ah = new JScrollPane((Component) null);
		panel_ah.getVerticalScrollBar().setUnitIncrement(30);
		panel_ah.setPreferredSize(new Dimension(1344, 500));
		panel_card.add(panel_ah, "panel_ah");
		
		JPanel test = new JPanel();
		test.setLayout(null);
		test.setPreferredSize(new Dimension(900, 1500));
		test.setAutoscrolls(true);
		panel_ah.setViewportView(test);
		
		JPanel panel_ah_1 = new JPanel();
		panel_ah_1.setLayout(null);
		panel_ah_1.setBounds(0, 0, 1340, 1390);
		test.add(panel_ah_1);
		
		JButton btnNewButton_18_1 = new JButton("아산");
		btnNewButton_18_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_18_1.setBounds(12, 10, 206, 120);
		btnNewButton_18_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_18_1);
		
		JButton btnNewButton_1_11_1 = new JButton("아우라지");
		btnNewButton_1_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_11_1.setBounds(230, 10, 206, 120);
		btnNewButton_1_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_11_1);
		
		JButton btnNewButton_2_11_1 = new JButton("아화");
		btnNewButton_2_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_11_1.setBounds(448, 10, 206, 120);
		btnNewButton_2_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_11_1);
		
		JButton btnNewButton_3_11_1 = new JButton("안강");
		btnNewButton_3_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_11_1.setBounds(666, 10, 206, 120);
		btnNewButton_3_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_11_1);
		
		JButton btnNewButton_4_11_1 = new JButton("안동");
		btnNewButton_4_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_11_1.setBounds(884, 10, 206, 120);
		btnNewButton_4_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_11_1);
		
		JButton btnNewButton_5_11_1 = new JButton("안양");
		btnNewButton_5_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_11_1.setBounds(1102, 10, 206, 120);
		btnNewButton_5_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_11_1);
		
		JButton btnNewButton_6_11_1 = new JButton("앙성온천");
		btnNewButton_6_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_11_1.setBounds(12, 140, 206, 120);
		btnNewButton_6_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_11_1);
		
		JButton btnNewButton_7_11_1 = new JButton("약목");
		btnNewButton_7_11_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_11_1.setBounds(230, 140, 206, 120);
		btnNewButton_7_11_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_11_1);
		
		JButton btnNewButton_8_7_1 = new JButton("양동");
		btnNewButton_8_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_8_7_1.setBounds(448, 140, 206, 120);
		btnNewButton_8_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_8_7_1);
		
		JButton btnNewButton_1_1_7_1 = new JButton("양원");
		btnNewButton_1_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_1_7_1.setBounds(666, 140, 206, 120);
		btnNewButton_1_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_1_7_1);
		
		JButton btnNewButton_2_1_7_1 = new JButton("양평");
		btnNewButton_2_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_1_7_1.setBounds(884, 140, 206, 120);
		btnNewButton_2_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_1_7_1);
		
		JButton btnNewButton_3_1_7_1 = new JButton("여수EXPO");
		btnNewButton_3_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_1_7_1.setBounds(1102, 140, 206, 120);
		btnNewButton_3_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_1_7_1);
		
		JButton btnNewButton_4_1_7_1 = new JButton("여천");
		btnNewButton_4_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_1_7_1.setBounds(12, 270, 206, 120);
		btnNewButton_4_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_1_7_1);
		
		JButton btnNewButton_5_1_7_1 = new JButton("연산");
		btnNewButton_5_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_1_7_1.setBounds(230, 270, 206, 120);
		btnNewButton_5_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_1_7_1);
		
		JButton btnNewButton_6_1_7_1 = new JButton("영덕");
		btnNewButton_6_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_1_7_1.setBounds(448, 270, 206, 120);
		btnNewButton_6_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_1_7_1);
		
		JButton btnNewButton_7_1_7_1 = new JButton("영동");
		btnNewButton_7_1_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_1_7_1.setBounds(666, 270, 206, 120);
		btnNewButton_7_1_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_1_7_1);
		
		JButton btnNewButton_9_7_1 = new JButton("영등포");
		btnNewButton_9_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_9_7_1.setBounds(884, 270, 206, 120);
		btnNewButton_9_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_9_7_1);
		
		JButton btnNewButton_1_2_7_1 = new JButton("영월");
		btnNewButton_1_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_2_7_1.setBounds(1102, 270, 206, 120);
		btnNewButton_1_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_2_7_1);
		
		JButton btnNewButton_2_2_7_1 = new JButton("영주");
		btnNewButton_2_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_2_7_1.setBounds(12, 400, 206, 120);
		btnNewButton_2_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_2_7_1);
		
		JButton btnNewButton_3_2_7_1 = new JButton("영천");
		btnNewButton_3_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_2_7_1.setBounds(230, 400, 206, 120);
		btnNewButton_3_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_2_7_1);
		
		JButton btnNewButton_4_2_7_1 = new JButton("예당");
		btnNewButton_4_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_2_7_1.setBounds(448, 400, 206, 120);
		btnNewButton_4_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_2_7_1);
		
		JButton btnNewButton_5_2_7_1 = new JButton("예미");
		btnNewButton_5_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_2_7_1.setBounds(666, 400, 206, 120);
		btnNewButton_5_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_2_7_1);
		
		JButton btnNewButton_6_2_7_1 = new JButton("예산");
		btnNewButton_6_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_2_7_1.setBounds(884, 400, 206, 120);
		btnNewButton_6_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_2_7_1);
		
		JButton btnNewButton_7_2_7_1 = new JButton("예천");
		btnNewButton_7_2_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_2_7_1.setBounds(1102, 400, 206, 120);
		btnNewButton_7_2_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_2_7_1);
		
		JButton btnNewButton_10_7_1 = new JButton("오근장");
		btnNewButton_10_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_10_7_1.setBounds(12, 530, 206, 120);
		btnNewButton_10_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_10_7_1);
		
		JButton btnNewButton_1_3_7_1 = new JButton("오산");
		btnNewButton_1_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_3_7_1.setBounds(230, 530, 206, 120);
		btnNewButton_1_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_3_7_1);
		
		JButton btnNewButton_2_3_7_1 = new JButton("오송");
		btnNewButton_2_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_3_7_1.setBounds(448, 530, 206, 120);
		btnNewButton_2_2_13.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_3_7_1);
		
		JButton btnNewButton_3_3_7_1 = new JButton("오수");
		btnNewButton_3_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_3_7_1.setBounds(666, 530, 206, 120);
		btnNewButton_3_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_3_7_1);
		
		JButton btnNewButton_4_3_7_1 = new JButton("옥산");
		btnNewButton_4_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_3_7_1.setBounds(884, 530, 206, 120);
		btnNewButton_4_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_3_7_1);
		
		JButton btnNewButton_5_3_7_1 = new JButton("옥수");
		btnNewButton_5_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_3_7_1.setBounds(1102, 530, 206, 120);
		btnNewButton_5_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_3_7_1);
		
		JButton btnNewButton_6_3_7_1 = new JButton("옥천");
		btnNewButton_6_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_3_7_1.setBounds(12, 660, 206, 120);
		btnNewButton_6_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_3_7_1);
		
		JButton btnNewButton_7_3_7_1 = new JButton("온양온천");
		btnNewButton_7_3_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_3_7_1.setBounds(230, 660, 206, 120);
		btnNewButton_7_3_7_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_3_7_1);
		
		JButton btnNewButton_11_7_3 = new JButton("완사");
		btnNewButton_11_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_3.setBounds(448, 660, 206, 120);
		btnNewButton_11_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_11_7_3);
		
		JButton btnNewButton_1_4_7_3 = new JButton("왕십리");
		btnNewButton_1_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_3.setBounds(666, 660, 206, 120);
		btnNewButton_1_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_4_7_3);
		
		JButton btnNewButton_2_4_7_3 = new JButton("왜관");
		btnNewButton_2_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_3.setBounds(884, 660, 206, 120);
		btnNewButton_2_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_4_7_3);
		
		JButton btnNewButton_3_4_7_3 = new JButton("용궁");
		btnNewButton_3_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_3.setBounds(1102, 660, 206, 120);
		btnNewButton_3_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_4_7_3);
		
		JButton btnNewButton_4_4_7_3 = new JButton("용문");
		btnNewButton_4_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_3.setBounds(12, 790, 206, 120);
		btnNewButton_4_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_4_7_3);
		
		JButton btnNewButton_5_4_7_3 = new JButton("용산");
		btnNewButton_5_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_3.setBounds(230, 790, 206, 120);
		btnNewButton_5_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_4_7_3);
		
		JButton btnNewButton_6_4_7_3 = new JButton("운천");
		btnNewButton_6_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_3.setBounds(448, 790, 206, 120);
		btnNewButton_6_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_4_7_3);
		
		JButton btnNewButton_7_4_7_3 = new JButton("울산(통도사)");
		btnNewButton_7_4_7_3.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_3.setBounds(666, 790, 206, 120);
		btnNewButton_7_4_7_3.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_4_7_3);
		
		JButton btnNewButton_11_7_1_1 = new JButton("웅천");
		btnNewButton_11_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_1_1.setBounds(884, 790, 206, 120);
		btnNewButton_11_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_11_7_1_1);
		
		JButton btnNewButton_1_4_7_1_1 = new JButton("원동");
		btnNewButton_1_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_1_1.setBounds(1102, 790, 206, 120);
		btnNewButton_1_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_4_7_1_1);
		
		JButton btnNewButton_2_4_7_1_1 = new JButton("원주");
		btnNewButton_2_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_1_1.setBounds(12, 920, 206, 120);
		btnNewButton_2_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_4_7_1_1);
		
		JButton btnNewButton_3_4_7_1_1 = new JButton("월포");
		btnNewButton_3_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_1_1.setBounds(230, 920, 206, 120);
		btnNewButton_3_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_4_7_1_1);
		
		JButton btnNewButton_4_4_7_1_1 = new JButton("음성");
		btnNewButton_4_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_1_1.setBounds(448, 920, 206, 120);
		btnNewButton_4_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_4_7_1_1);
		
		JButton btnNewButton_5_4_7_1_1 = new JButton("의성");
		btnNewButton_5_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_1_1.setBounds(666, 920, 206, 120);
		btnNewButton_5_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_4_7_1_1);
		
		JButton btnNewButton_6_4_7_1_1 = new JButton("이양");
		btnNewButton_6_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_1_1.setBounds(884, 920, 206, 120);
		btnNewButton_6_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_4_7_1_1);
		
		JButton btnNewButton_7_4_7_1_1 = new JButton("이원");
		btnNewButton_7_4_7_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_1_1.setBounds(1102, 920, 206, 120);
		btnNewButton_7_4_7_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_4_7_1_1);
		
		JButton btnNewButton_11_7_2_2 = new JButton("익산");
		btnNewButton_11_7_2_2.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_2_2.setBounds(12, 1050, 206, 120);
		btnNewButton_11_7_2_2.addMouseListener(this);
		panel_ah_1.add(btnNewButton_11_7_2_2);
		
		JButton btnNewButton_1_4_7_2_1 = new JButton("인천공항T1");
		btnNewButton_1_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_1_4_7_2_1.setBounds(230, 1050, 206, 120);
		btnNewButton_1_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_1_4_7_2_1);
		
		JButton btnNewButton_2_4_7_2_1 = new JButton("인천공항T2");
		btnNewButton_2_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_2_4_7_2_1.setBounds(448, 1050, 206, 120);
		btnNewButton_2_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_2_4_7_2_1);
		
		JButton btnNewButton_3_4_7_2_1 = new JButton("일로");
		btnNewButton_3_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_3_4_7_2_1.setBounds(666, 1050, 206, 120);
		btnNewButton_3_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_3_4_7_2_1);
		
		JButton btnNewButton_4_4_7_2_1 = new JButton("일신");
		btnNewButton_4_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_4_4_7_2_1.setBounds(884, 1050, 206, 120);
		btnNewButton_4_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_4_4_7_2_1);
		
		JButton btnNewButton_5_4_7_2_1 = new JButton("임기");
		btnNewButton_5_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_5_4_7_2_1.setBounds(1102, 1050, 206, 120);
		btnNewButton_5_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_5_4_7_2_1);
		
		JButton btnNewButton_6_4_7_2_1 = new JButton("임성리");
		btnNewButton_6_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_6_4_7_2_1.setBounds(12, 1180, 206, 120);
		btnNewButton_6_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_6_4_7_2_1);
		
		JButton btnNewButton_7_4_7_2_1 = new JButton("임실");
		btnNewButton_7_4_7_2_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_7_4_7_2_1.setBounds(230, 1180, 206, 120);
		btnNewButton_7_4_7_2_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_7_4_7_2_1);
		
		JButton btnNewButton_11_7_2_1_1 = new JButton("임진강");
		btnNewButton_11_7_2_1_1.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		btnNewButton_11_7_2_1_1.setBounds(448, 1180, 206, 120);
		btnNewButton_11_7_2_1_1.addMouseListener(this);
		panel_ah_1.add(btnNewButton_11_7_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("역명 조회");
		lblNewLabel_2.setFont(new Font("HY헤드라인M", Font.BOLD, 40));
		lblNewLabel_2.setBounds(12, 10, 1255, 151);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_main.add(lblNewLabel_2);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel_main, GroupLayout.PREFERRED_SIZE, 1535, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton nextBtn = new JButton();
		nextBtn.setBorderPainted(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);	
		try {
			nextBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_next.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 다음 버튼 선택시 달력 이동 이벤트
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "calender");
				TrainReserv_Main.count_panel = 1;
				Train_Main.frame.dispose();
			}
		});
		nextBtn.setBounds(1301, 34, 120, 100);
		panel_main.add(nextBtn);
		setLayout(groupLayout);
		
	}
	// 마우스 클릭 이벤트
	// 출발지가 선택되면 출발지 변경
	// 도착지가 선택되면 도착지 변경 
	@Override
	public void mouseClicked(MouseEvent e) {
		train_name = ((JButton)e.getSource()).getText();
		if(TrainReserv_Main.sub_select) {
			TrainReserv_Main.st_sub_btn.setText(train_name);
		}else {
			TrainReserv_Main.en_sub_btn.setText(train_name);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
