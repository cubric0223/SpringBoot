package train.calender;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import train.TrainReserv_Main;
import java.awt.Color;
/*
 	예매 프레임에 들어가는 달력 출력 패널

 */
public class Calender_Panel extends JPanel {
	private train.calender.CalendarCustom calendarCustom2;
	/**
	 * Create the panel.
	 */
	public Calender_Panel() {
		setBackground(new Color(255, 255, 255));
		
		CalendarCustom calender = new CalendarCustom();
		calender.setBounds(0,0,1400,900);
		// 예매 프레임에 이전 버튼 선택시 이벤트
		JButton previousBtn = new JButton();
		previousBtn.setBorderPainted(false);
		previousBtn.setContentAreaFilled(false);
		previousBtn.setFocusPainted(false);	
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.st_sub_btn.setText("서울");
				TrainReserv_Main.en_sub_btn.setText("부산");
				Calendar calendar = Calendar.getInstance();
				LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) +1,calendar.get(Calendar.DATE));
				String date = String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
				TrainReserv_Main.date_text.setText(date);
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subway");
				TrainReserv_Main.count_panel = 1;
				
			}
		});
		// 다음 버튼 선택시 이벤트
		JButton nextBtn = new JButton();
		nextBtn.setBorderPainted(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);	
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainReserv_Main.card.show(TrainReserv_Main.card_panel, "subkind");
				TrainReserv_Main.count_panel = 2;
			}
		});
		 GroupLayout groupLayout = new GroupLayout(this);
	        groupLayout.setHorizontalGroup(
	            groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                .addGroup(groupLayout.createSequentialGroup()
	                    .addComponent(previousBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
	                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
	                .addGroup(groupLayout.createSequentialGroup()
	                	.addGap(50) // 왼쪽 여백
	                    .addComponent(calender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        groupLayout.setVerticalGroup(
	            groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
	                .addGroup(groupLayout.createSequentialGroup()
	                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(previousBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(nextBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(calender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        );
	        setLayout(groupLayout);
	        
	        try {
				nextBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_next.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
				previousBtn.setIcon(new ImageIcon(ImageIO.read(new File("resource/panel_back.png")).getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

	}
}
