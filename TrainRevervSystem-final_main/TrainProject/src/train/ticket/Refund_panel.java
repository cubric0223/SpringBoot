package train.ticket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import train.dao.TicketDAO;

import javax.swing.JCheckBox;
// 티켓 반환 유의사항 출력 다이얼로그
public class Refund_panel extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Refund_panel dialog = new Refund_panel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Refund_panel() {
		UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
	      UIManager.put("OptionPane.messageFont",
	            new Font("HY헤드라인M", Font.BOLD, 50));
		setBounds(100, 100, 900, 733);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel refund_Remind = new JLabel("환불을 요청하시겠습니까?");
		refund_Remind.setFont(new Font("HY헤드라인M", Font.BOLD, 50));
		refund_Remind.setVerticalAlignment(SwingConstants.CENTER);
		refund_Remind.setHorizontalAlignment(SwingConstants.CENTER);
		refund_Remind.setBounds(12, 10, 860, 85);
		contentPanel.add(refund_Remind);
		
		JButton refund_Yes_Btn = new JButton("환불요청");
		refund_Yes_Btn.setForeground(new Color(255, 255, 255));
		refund_Yes_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i =0; i < Ticket_Info.tnum_li.size(); ++i) {
					TicketDAO ticket = new TicketDAO();
					if(Rev_detail.chk_login) {
						System.out.println("환불 : "+Ticket_Info.tnum_li.get(i));
						ticket.refundMemTicket_search(Ticket_Info.tnum_li.get(i));
					}else {
						System.out.println("환불 : "+Ticket_Info.tnum_li.get(i));
						ticket.refundNoMemTicket_search(Ticket_Info.tnum_li.get(i));
					}
					
				}
				Refund_Success_Panel rsp = new Refund_Success_Panel();
				rsp.main(null);
			}
		});
	
		refund_Yes_Btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		refund_Yes_Btn.setBackground(new Color(64, 0, 64));
		refund_Yes_Btn.setBounds(12, 534, 350, 150);
		refund_Yes_Btn.setEnabled(false);//초기에는 비활성화 상태
		contentPanel.add(refund_Yes_Btn);
		
		
			JButton refund_No_Btn = new JButton("취소");
			refund_No_Btn.setForeground(new Color(255, 255, 255));
			refund_No_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			refund_No_Btn.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
			refund_No_Btn.setBackground(new Color(64, 0, 64));
			refund_No_Btn.setBounds(522, 534, 350, 150);
			contentPanel.add(refund_No_Btn);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 104, 860, 333);
			contentPanel.add(scrollPane);
			scrollPane.setPreferredSize(new Dimension(677,500));
			scrollPane.setAutoscrolls(true);
			
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(650,400));
			panel.setAutoscrolls(true);
			//--------------
			panel.setLayout(new BorderLayout()); // 레이아웃 매니저를 BorderLayout으로 설정합니다.

			// 이미지 파일 경로를 설정합니다.
			String imagePath = "resource/return_ticket.png";

			// JLabel을 생성하고, 이미지 아이콘을 설정합니다.
			JLabel imageLabel = new JLabel();
			ImageIcon imageIcon = new ImageIcon(imagePath);
			imageLabel.setIcon(imageIcon);

			// JLabel의 크기를 패널의 크기에 맞게 조정합니다.
//			imageLabel.setPreferredSize(new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height));
			// 원하는 이미지 크기로 JLabel의 크기를 설정합니다.
			int desiredWidth = 839; // 내가 원하는 가로 크기
			int desiredHeight = 520; // 내가 원하는 세로 크기
			Image scaledImage = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(scaledImage);
			imageLabel.setIcon(imageIcon);
			
			
			// 패널의 중앙에 이미지를 배치하기 위해 BorderLayout의 중앙에 JLabel을 추가합니다.
			panel.add(imageLabel, BorderLayout.CENTER);

			scrollPane.setViewportView(panel);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("위 내용을 모두 인지하였습니다.");
			chckbxNewCheckBox.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			chckbxNewCheckBox.setBounds(12, 444, 860, 84);
			chckbxNewCheckBox.setHorizontalAlignment(JLabel.CENTER);
			chckbxNewCheckBox.setVerticalAlignment(JLabel.CENTER);
			
			chckbxNewCheckBox.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	                if (chckbxNewCheckBox.isSelected()) {
	                    refund_Yes_Btn.setEnabled(true);
	                } else {
	                    refund_Yes_Btn.setEnabled(false);
	                }
	            }
	        });
			contentPanel.add(chckbxNewCheckBox);
			
		}
	}

