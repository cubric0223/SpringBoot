package train.calender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import train.calender.PanelSlide;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Color;
/*
	달력의 현재 시간, 현재 달의 날짜 출력
*/
public class CalendarCustom extends javax.swing.JPanel {

    private int month;
    private int year;
    private javax.swing.JButton cmdBack;
    private javax.swing.JButton cmdNext;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static JLabel lbDate;
    private javax.swing.JLabel lbMonthYear;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbType;
    private train.calender.PanelSlide slide;
    
    public CalendarCustom() {
        initComponents();
        thisMonth();
        Calendar now = Calendar.getInstance(); //현재 달력 가져오기
        // 달력의 슬라이드 이벤트 쇼
        slide.show(new PanelDate(now.get(Calendar.MONTH)+1, now.get(Calendar.YEAR)), PanelSlide.AnimateType.TO_RIGHT); 
        showMonthYear();
        new Thread(new Runnable() { // 쓰레드로 현재 달력의 실시간 시간 변경
            @Override
            public void run() {
                while (true) {
                	Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, yyyy-MM-dd");
                    String time = tf.format(date);
                    lbTime.setText(time.split(" ")[0]);
                    lbType.setText(time.split(" ")[1]);
                    lbDate.setText(df.format(date));
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slide = new train.calender.PanelSlide();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        cmdBack = new javax.swing.JButton("이전달");
        lbMonthYear = new javax.swing.JLabel();
        cmdNext = new javax.swing.JButton("다음달");

        setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jPanel1.setBackground(SystemColor.text);

        jPanel2.setBackground(new Color(0, 128, 192));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        lbTime.setFont(new Font("SansSerif", Font.BOLD, 35)); // NOI18N
        lbTime.setForeground(SystemColor.desktop);
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("9:32:00");

        lbType.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        lbType.setForeground(SystemColor.desktop);
        lbType.setText("PM");

        lbDate.setFont(new Font("SansSerif", Font.PLAIN, 25)); // NOI18N
        lbDate.setForeground(SystemColor.desktop);
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbTime, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbType, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbDate, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(474, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lbType)
        						.addComponent(lbTime, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        						.addComponent(lbDate, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
        					.addGap(4)))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        cmdBack.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        cmdBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdBack.setContentAreaFilled(false);
        cmdBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackActionPerformed(evt);
            }
        });
        
        lbMonthYear.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        lbMonthYear.setForeground(new Color(0, 128, 192));
        lbMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMonthYear.setText("Month - Year");

        cmdNext.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
        cmdNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdNext.setContentAreaFilled(false);
        cmdNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(cmdBack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbMonthYear, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmdNext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMonthYear, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMonthYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(slide, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
        				.addComponent(jLayeredPane1, GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(19)
        			.addComponent(slide, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents
    // 다음달 버튼 액션
    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_LEFT);
        showMonthYear();
    }//GEN-LAST:event_cmdNextActionPerformed
    // 이전달 버튼 액션
    private void cmdBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackActionPerformed
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
    }//GEN-LAST:event_cmdBackActionPerformed
    // 현재 달 가져오기
    public void thisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());   //  today
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
    }
    // 날짜 출력
    private void showMonthYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM-yyyy");
        lbMonthYear.setText(df.format(calendar.getTime()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    // End of variables declaration//GEN-END:variables
}
