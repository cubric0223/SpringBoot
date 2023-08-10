package train.calender;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;

import train.TrainReserv_Main;

import java.awt.Font;
/*
 	달력 선택 패널 클래스
 	달력 선택시 출력 패널로 이전 날짜는 선택 불가
 	선택한 날짜는 메인 예매 프레임에 날짜 텍스트필드 변경
 */
/**
 * @author LJH
 */
public class PanelDate extends javax.swing.JLayeredPane implements ActionListener{
	
    private int month;
    private int year;
    private Component cel;
    public PanelDate(int month, int year) {
        initComponents();
        this.month = month;
        this.year = year;
        init();
    }

    private void init() {
        mon.asTitle();
        tue.asTitle();
        wed.asTitle();
        thu.asTitle();
        fri.asTitle();
        sat.asTitle();
        sun.asTitle();
        setDate();
    }

    private void setDate() { // 현재 날짜와 현재 달의 날짜 세팅
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
        calendar.add(Calendar.DATE, -startDay);
        ToDay toDay = getToDay(); // toDay에서 현재 날짜 가져오기
        for (Component com : getComponents()) {
            Cell cell = (Cell) com; // 현재 달의 날짜를 버튼에 모든 넣기
            if (!cell.isTitle()) {
                cell.setText(calendar.get(Calendar.DATE) + ""); // 현재 날짜 가져오기
                cell.setDate(calendar.getTime()); // 현재 시간 가져오기
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                // 날짜가 오늘과 같다면 버튼의 이미지를 추가
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                    cel = com;
                }
                
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }
    
    // 현재 날짜 가져오기
    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new train.calender.Cell();
        mon = new train.calender.Cell();
        tue = new train.calender.Cell();
        wed = new train.calender.Cell();
        thu = new train.calender.Cell();
        fri = new train.calender.Cell();
        sat = new train.calender.Cell();
        
        cell8 = new train.calender.Cell();
        cell8.setDefaultCapable(false);
        cell8.setFocusPainted(false);
        cell8.setFocusTraversalKeysEnabled(false);
        cell8.setSelected(true);
        cell8.addActionListener(this);
        
        cell9 = new train.calender.Cell();
        cell9.setDefaultCapable(false);
        cell9.setFocusPainted(false);
        cell9.setFocusTraversalKeysEnabled(false);
        cell9.setSelected(true);
        cell9.addActionListener(this);
        
        
        cell10 = new train.calender.Cell();
        cell10.setDefaultCapable(false);
        cell10.setFocusPainted(false);
        cell10.setFocusTraversalKeysEnabled(false);
        cell10.setSelected(true);
        cell10.addActionListener(this);
        
        
        
        cell11 = new train.calender.Cell();
        cell11.setDefaultCapable(false);
        cell11.setFocusPainted(false);
        cell11.setFocusTraversalKeysEnabled(false);
        cell11.setSelected(true);
        cell11.addActionListener(this);
        
       
        cell12 = new train.calender.Cell();
        cell12.setDefaultCapable(false);
        cell12.setFocusPainted(false);
        cell12.setFocusTraversalKeysEnabled(false);
        cell12.setSelected(true);
        cell12.addActionListener(this);
        
        cell13 = new train.calender.Cell();
        cell13.setDefaultCapable(false);
        cell13.setFocusPainted(false);
        cell13.setFocusTraversalKeysEnabled(false);
        cell13.setSelected(true);
        cell13.addActionListener(this);
        
        cell14 = new train.calender.Cell();
        cell14.setDefaultCapable(false);
        cell14.setFocusPainted(false);
        cell14.setFocusTraversalKeysEnabled(false);
        cell14.setSelected(true);
        cell14.addActionListener(this);
        
        cell15 = new train.calender.Cell();
        cell15.setDefaultCapable(false);
        cell15.setFocusPainted(false);
        cell15.setFocusTraversalKeysEnabled(false);
        cell15.setSelected(true);
        cell15.addActionListener(this);
        
        cell16 = new train.calender.Cell();
        cell16.setDefaultCapable(false);
        cell16.setFocusPainted(false);
        cell16.setFocusTraversalKeysEnabled(false);
        cell16.setSelected(true);
        cell16.addActionListener(this);
        
        cell17 = new train.calender.Cell();
        cell17.setDefaultCapable(false);
        cell17.setFocusPainted(false);
        cell17.setFocusTraversalKeysEnabled(false);
        cell17.setSelected(true);
        cell17.addActionListener(this);
        
        cell18 = new train.calender.Cell();
        cell18.setDefaultCapable(false);
        cell18.setFocusPainted(false);
        cell18.setFocusTraversalKeysEnabled(false);
        cell18.setSelected(true);
        cell18.addActionListener(this);
        
        cell19 = new train.calender.Cell();
        cell19.setDefaultCapable(false);
        cell19.setFocusPainted(false);
        cell19.setFocusTraversalKeysEnabled(false);
        cell19.setSelected(true);
        cell19.addActionListener(this);
        
        cell20 = new train.calender.Cell();
        cell20.setDefaultCapable(false);
        cell20.setFocusPainted(false);
        cell20.setFocusTraversalKeysEnabled(false);
        cell20.setSelected(true);
        cell20.addActionListener(this);
        
        cell21 = new train.calender.Cell();
        cell21.setDefaultCapable(false);
        cell21.setFocusPainted(false);
        cell21.setFocusTraversalKeysEnabled(false);
        cell21.setSelected(true);
        cell21.addActionListener(this);
        
        cell22 = new train.calender.Cell();
        cell22.setDefaultCapable(false);
        cell22.setFocusPainted(false);
        cell22.setFocusTraversalKeysEnabled(false);
        cell22.setSelected(true);
        cell22.addActionListener(this);
        
        cell23 = new train.calender.Cell();
        cell23.setDefaultCapable(false);
        cell23.setFocusPainted(false);
        cell23.setFocusTraversalKeysEnabled(false);
        cell23.setSelected(true);
        cell23.addActionListener(this);
        
        cell24 = new train.calender.Cell();
        cell24.setDefaultCapable(false);
        cell24.setFocusPainted(false);
        cell24.setFocusTraversalKeysEnabled(false);
        cell24.setSelected(true);
        cell24.addActionListener(this);
        
        cell25 = new train.calender.Cell();
        cell25.setDefaultCapable(false);
        cell25.setFocusPainted(false);
        cell25.setFocusTraversalKeysEnabled(false);
        cell25.setSelected(true);
        cell25.addActionListener(this);
        
        cell26 = new train.calender.Cell();
        cell26.setDefaultCapable(false);
        cell26.setFocusPainted(false);
        cell26.setFocusTraversalKeysEnabled(false);
        cell26.setSelected(true);
        cell26.addActionListener(this);
        
        cell27 = new train.calender.Cell();
        cell27.setDefaultCapable(false);
        cell27.setFocusPainted(false);
        cell27.setFocusTraversalKeysEnabled(false);
        cell27.setSelected(true);
        cell27.addActionListener(this);
        
        cell28 = new train.calender.Cell();
        cell28.setDefaultCapable(false);
        cell28.setFocusPainted(false);
        cell28.setFocusTraversalKeysEnabled(false);
        cell28.setSelected(true);
        cell28.addActionListener(this);
        
        cell29 = new train.calender.Cell();
        cell29.setDefaultCapable(false);
        cell29.setFocusPainted(false);
        cell29.setFocusTraversalKeysEnabled(false);
        cell29.setSelected(true);
        cell29.addActionListener(this);
        
        cell30 = new train.calender.Cell();
        cell30.setDefaultCapable(false);
        cell30.setFocusPainted(false);
        cell30.setFocusTraversalKeysEnabled(false);
        cell30.setSelected(true);
        cell30.addActionListener(this);
        
        cell31 = new train.calender.Cell();
        cell31.setDefaultCapable(false);
        cell31.setFocusPainted(false);
        cell31.setFocusTraversalKeysEnabled(false);
        cell31.setSelected(true);
        cell31.addActionListener(this);
        
        cell32 = new train.calender.Cell();
        cell32.setDefaultCapable(false);
        cell32.setFocusPainted(false);
        cell32.setFocusTraversalKeysEnabled(false);
        cell32.setSelected(true);
        cell32.addActionListener(this);
        
        cell33 = new train.calender.Cell();
        cell33.setDefaultCapable(false);
        cell33.setFocusPainted(false);
        cell33.setFocusTraversalKeysEnabled(false);
        cell33.setSelected(true);
        cell33.addActionListener(this);
        
        cell34 = new train.calender.Cell();
        cell34.setDefaultCapable(false);
        cell34.setFocusPainted(false);
        cell34.setFocusTraversalKeysEnabled(false);
        cell34.setSelected(true);
        cell34.addActionListener(this);
        
        cell35 = new train.calender.Cell();
        cell35.setDefaultCapable(false);
        cell35.setFocusPainted(false);
        cell35.setFocusTraversalKeysEnabled(false);
        cell35.setSelected(true);
        cell35.addActionListener(this);
        
        cell36 = new train.calender.Cell();
        cell36.setDefaultCapable(false);
        cell36.setFocusPainted(false);
        cell36.setFocusTraversalKeysEnabled(false);
        cell36.setSelected(true);
        cell36.addActionListener(this);
        
        cell37 = new train.calender.Cell();
        cell37.setDefaultCapable(false);
        cell37.setFocusPainted(false);
        cell37.setFocusTraversalKeysEnabled(false);
        cell37.setSelected(true);
        cell37.addActionListener(this);
        
        cell38 = new train.calender.Cell();
        cell38.setDefaultCapable(false);
        cell38.setFocusPainted(false);
        cell38.setFocusTraversalKeysEnabled(false);
        cell38.setSelected(true);
        cell38.addActionListener(this);
        
        cell39 = new train.calender.Cell();
        cell39.setDefaultCapable(false);
        cell39.setFocusPainted(false);
        cell39.setFocusTraversalKeysEnabled(false);
        cell39.setSelected(true);
        cell39.addActionListener(this);
        
        cell40 = new train.calender.Cell();
        cell40.setDefaultCapable(false);
        cell40.setFocusPainted(false);
        cell40.setFocusTraversalKeysEnabled(false);
        cell40.setSelected(true);
        cell40.addActionListener(this);
        
        cell41 = new train.calender.Cell();
        cell41.setDefaultCapable(false);
        cell41.setFocusPainted(false);
        cell41.setFocusTraversalKeysEnabled(false);
        cell41.setSelected(true);
        cell41.addActionListener(this);
        
        cell42 = new train.calender.Cell();
        cell42.setDefaultCapable(false);
        cell42.setFocusPainted(false);
        cell42.setFocusTraversalKeysEnabled(false);
        cell42.setSelected(true);
        cell42.addActionListener(this);
        
        cell43 = new train.calender.Cell();
        cell43.setDefaultCapable(false);
        cell43.setFocusPainted(false);
        cell43.setFocusTraversalKeysEnabled(false);
        cell43.setSelected(true);
        cell43.addActionListener(this);
        
        cell44 = new train.calender.Cell();
        cell44.setDefaultCapable(false);
        cell44.setFocusPainted(false);
        cell44.setFocusTraversalKeysEnabled(false);
        cell44.setSelected(true);
        cell44.addActionListener(this);
        
        cell45 = new train.calender.Cell();
        cell45.setDefaultCapable(false);
        cell45.setFocusPainted(false);
        cell45.setFocusTraversalKeysEnabled(false);
        cell45.setSelected(true);
        cell45.addActionListener(this);
        
        cell46 = new train.calender.Cell();
        cell46.setDefaultCapable(false);
        cell46.setFocusPainted(false);
        cell46.setFocusTraversalKeysEnabled(false);
        cell46.setSelected(true);
        cell46.addActionListener(this);
        
        cell47 = new train.calender.Cell();
        cell47.setDefaultCapable(false);
        cell47.setFocusPainted(false);
        cell47.setFocusTraversalKeysEnabled(false);
        cell47.setSelected(true);
        cell47.addActionListener(this);
        
        cell48 = new train.calender.Cell();
        cell48.setDefaultCapable(false);
        cell48.setFocusPainted(false);
        cell48.setFocusTraversalKeysEnabled(false);
        cell48.setSelected(true);
        cell48.addActionListener(this);
        
        cell49 = new train.calender.Cell();
        cell49.setDefaultCapable(false);
        cell49.setFocusPainted(false);
        cell49.setFocusTraversalKeysEnabled(false);
        cell49.setSelected(true);
        cell49.addActionListener(this);
        
        setLayout(new java.awt.GridLayout(7, 7));

        sun.setForeground(new java.awt.Color(222, 12, 12));
        sun.setText("Sun");
        sun.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(sun);

        mon.setText("Mon");
        mon.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(mon);

        tue.setText("Tue");
        tue.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(tue);

        wed.setText("Wed");
        wed.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(wed);

        thu.setText("Thu");
        thu.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(thu);

        fri.setText("Fri");
        fri.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(fri);

        sat.setText("Sat");
        sat.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(sat);

        cell8.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell8);

        cell9.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell9);

        cell10.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell10);

        cell11.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell11);

        cell12.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell12);

        cell13.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell13);

        cell14.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell14);

        cell15.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell15);

        cell16.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell16);

        cell17.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell17);

        cell18.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell18);

        cell19.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell19);

        cell20.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell20);

        cell21.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell21);

        cell22.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell22);

        cell23.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell23);

        cell24.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell24);

        cell25.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell25);

        cell26.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell26);

        cell27.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell27);

        cell28.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell28);

        cell29.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell29);

        cell30.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell30);

        cell31.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell31);

        cell32.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell32);

        cell33.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell33);

        cell34.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell34);

        cell35.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell35);

        cell36.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell36);

        cell37.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell37);

        cell38.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell38);

        cell39.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell39);

        cell40.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell40);

        cell41.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell41);

        cell42.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell42);

        cell43.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell43);

        cell44.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell44);

        cell45.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell45);

        cell46.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell46);

        cell47.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell47);

        cell48.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell48);

        cell49.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private train.calender.Cell cell10;
    private train.calender.Cell cell11;
    private train.calender.Cell cell12;
    private train.calender.Cell cell13;
    private train.calender.Cell cell14;
    private train.calender.Cell cell15;
    private train.calender.Cell cell16;
    private train.calender.Cell cell17;
    private train.calender.Cell cell18;
    private train.calender.Cell cell19;
    private train.calender.Cell cell20;
    private train.calender.Cell cell21;
    private train.calender.Cell cell22;
    private train.calender.Cell cell23;
    private train.calender.Cell cell24;
    private train.calender.Cell cell25;
    private train.calender.Cell cell26;
    private train.calender.Cell cell27;
    private train.calender.Cell cell28;
    private train.calender.Cell cell29;
    private train.calender.Cell cell30;
    private train.calender.Cell cell31;
    private train.calender.Cell cell32;
    private train.calender.Cell cell33;
    private train.calender.Cell cell34;
    private train.calender.Cell cell35;
    private train.calender.Cell cell36;
    private train.calender.Cell cell37;
    private train.calender.Cell cell38;
    private train.calender.Cell cell39;
    private train.calender.Cell cell40;
    private train.calender.Cell cell41;
    private train.calender.Cell cell42;
    private train.calender.Cell cell43;
    private train.calender.Cell cell44;
    private train.calender.Cell cell45;
    private train.calender.Cell cell46;
    private train.calender.Cell cell47;
    private train.calender.Cell cell48;
    private train.calender.Cell cell49;
    private train.calender.Cell cell8;
    private train.calender.Cell cell9;
    private train.calender.Cell fri;
    private train.calender.Cell mon;
    private train.calender.Cell sat;
    private train.calender.Cell sun;
    private train.calender.Cell thu;
    private train.calender.Cell tue;
    private train.calender.Cell wed;
    // End of variables declaration//GEN-END:variables

	@Override
	// 버튼의 마우스 이벤트
	public void actionPerformed(ActionEvent e) {
		Calendar calendar = Calendar.getInstance();
		
		Cell cel2 = (Cell)e.getSource(); // 클릭한 버튼의 소스 가져오기
		System.out.println(e.getSource()); 
		// 선택한 날짜가 현재 달이고 현재 날보다 적다면 선택 불가
		if(Integer.parseInt(cel2.getText()) >= calendar.get(Calendar.DATE) || 
				(Integer.parseInt(cel2.getText()) >= 1 && month-1 > calendar.get(Calendar.MONTH))) {
			
			Cell cel1 = (Cell)cel;
			cel1.setAsRemind(); // 이전 날짜의 이미지 재설정
			
			cel = (Cell)e.getSource(); 
			cel2.setAsToDay();// 선택한 날짜의 이미지 추가
			int day = Integer.parseInt(((Cell)e.getSource()).getText());
			LocalDate ld = LocalDate.of(this.year,this.month,day);
			System.out.println(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			// 선택한 날짜를 예매 화면의 메인 텍스트에 넣기
			TrainReserv_Main.date_text.setText(String.valueOf(ld.format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
			
			
		}
	}
}
