package train.seat_special;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import train.seat_standard.StandardSeatSelect;


public class SpecialSeatPanel extends JPanel implements MouseListener{
	String[] specialleft = { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A",
			"8B", "9A", "9B", "10A", "10B" };
	String[] specialright = { "1C", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C" };
	
	String mainFont = "HY헤드라인M";
	
	JToggleButton[] seatBtns;
	JToggleButton[] leftBtns;
	JToggleButton[] rightBtns;
	
	public static JPanel leftSeatPanel;
	public static JPanel rightSeatPanel;
	public static JPanel wholeSeatPanel;
	
//	public static ButtonGroup btnGroup1 = new ButtonGroup(); // 좌측패널의 버튼 그룹
//	public static ButtonGroup btnGroup2 = new ButtonGroup(); // 우측패널의 버튼 그룹
	
	int people = Integer.parseInt(train.TrainReserv_Main.selectPeopleLabel.getText()); 
	List<String> list = new ArrayList<>();
   
	public SpecialSeatPanel() {
		JScrollPane seatSelectScroll = new JScrollPane();
		JPanel seatSelectMainPanel = new JPanel();
		
		seatSelectScroll.setViewportView(seatSelectMainPanel);
		seatSelectScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		seatSelectScroll.setPreferredSize(new Dimension(700, 400));
		add(seatSelectScroll);

		// 좌석 선택 버튼을 포함하는 패널, 세로 스크롤 있음
		seatSelectMainPanel.setPreferredSize(new Dimension(600, 1100));
		seatSelectMainPanel.setLayout(new BorderLayout());
		seatSelectScroll.getVerticalScrollBar().setUnitIncrement(30);

		
		// 좌측좌석패널(A,B)
		leftSeatPanel = new JPanel();
		leftSeatPanel.setBackground(Color.white);
		leftSeatPanel.add(getHalfSeatPanel(true), BorderLayout.WEST);

		// 우측좌석패널(C,D)
		rightSeatPanel = new JPanel();
		rightSeatPanel.setBackground(Color.white);
		rightSeatPanel.add(getHalfSeatPanel(false), BorderLayout.EAST);
		
		
		
		wholeSeatPanel = getseatPanel(seatSelectMainPanel,leftSeatPanel,rightSeatPanel);
	}
   
	public JToggleButton[] getLeftSeatButtons() {
		return leftBtns;
	}

	public JToggleButton[] getRightSeatButtons() {
		return rightBtns;
	}
	
   /** 메인패널(좌석선택패널이 부착될 패널)과 좌우측 패널을 전달받아
    * 모든 패널이 부착된 메인패널을 리턴하는 메서드*/
	JPanel getseatPanel(JPanel seatMainPanel, JPanel left, JPanel right) {
		seatMainPanel.setBackground(Color.white);
		seatMainPanel.add(left, BorderLayout.WEST);
		seatMainPanel.add(right, BorderLayout.EAST);

		return seatMainPanel;
	}
   
   
	/** 좌석의 개수를 전달하면 해당 개수의 버튼이 부착된 패널을 반환해주는 메서드 (좌/ 우 패널 */
	JPanel getHalfSeatPanel(boolean chk) {
		JPanel seatPanel = new JPanel();
		String[] positions;
		
		ActionListener action1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
        	   String buttonText = ((JToggleButton) e.getSource()).getText();
               if (((JToggleButton) e.getSource()).isSelected()) {
            	   // 좌석선택 토글버튼이 선택되었을 때
                  if(people > list.size()) {
                	  // 리스트의 사이즈가 선택 인원보다 크면
                	  list.add(buttonText);             
                      SpecialSeatSelect.setLabel(list.toString());
                  }	  
                  
               } else { //좌석선택 토글버튼이 선택 해제되었을 때
	                  list.remove(list.indexOf(buttonText));
	                  SpecialSeatSelect.setLabel(list.toString());
                  }
               }
         };
         
         ActionListener action2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String buttonText = ((JToggleButton) e.getSource()).getText();
               
               if (((JToggleButton) e.getSource()).isSelected()) {
            	   if(people > list.size()) {
	                  list.add(buttonText);             
	                  SpecialSeatSelect.setLabel(list.toString());
            	   }
                  
               } else {
	            	  list.remove(list.indexOf(buttonText));
	            	  SpecialSeatSelect.setLabel(list.toString());
               }
            }
         };
		
		if (chk) {
			positions = specialleft;
			leftBtns = new JToggleButton[positions.length];
			for (int i = 0; i < leftBtns.length; i++) {
				leftBtns[i] = new JToggleButton();
				
				// 버튼의 속성
				
				if(!SpecialSeatSelect.chkAll) {
					leftBtns[i].setEnabled(false);
                }
				leftBtns[i].setText(positions[i]);
				leftBtns[i].setPreferredSize(new Dimension(120, 100)); // 버튼 텍스트 설정
				leftBtns[i].setForeground(Color.WHITE);
				leftBtns[i].setBorderPainted(false);
				leftBtns[i].setFocusPainted(false);
				leftBtns[i].setBackground(new Color(0, 128, 192));
				leftBtns[i].addMouseListener(this);
				leftBtns[i].addActionListener(action1);
				leftBtns[i].setFont(new Font("HY헤드라인M", Font.BOLD, 20));
//				buttonGroup.add(leftBtns[i]);
				seatPanel.add(leftBtns[i]);
			}
		}else {
			positions = specialright;
			rightBtns = new JToggleButton[positions.length];
			
			for (int i = 0; i < rightBtns.length; i++) {
				rightBtns[i] = new JToggleButton();
				
				// 버튼의 속성
				if(!SpecialSeatSelect.chkAll) {
					rightBtns[i].setEnabled(false);
                }
				rightBtns[i].setText(positions[i]);
				rightBtns[i].setPreferredSize(new Dimension(120, 100)); // 버튼 텍스트 설정
				rightBtns[i].setForeground(Color.WHITE);
				rightBtns[i].setBorderPainted(false);
				rightBtns[i].setFocusPainted(false);
				rightBtns[i].setBackground(new Color(0, 128, 192));
				rightBtns[i].addActionListener(action2);
                rightBtns[i].addMouseListener(this);
				rightBtns[i].setFont(new Font("HY헤드라인M", Font.BOLD, 20));
//				buttonGroup.add(rightBtns[i]);
				seatPanel.add(rightBtns[i]);
			}
		}
		seatPanel.setLayout(new GridLayout(10, 2, 10, 10));
		return seatPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(list.size() == people) {
			for (int i = 0; i < leftBtns.length; i++) {
				leftBtns[i].setEnabled(false);
				SpecialSeatSelect.chkAll = false;
			}
			for (int i = 0; i < rightBtns.length; i++) {
				rightBtns[i].setEnabled(false);
				SpecialSeatSelect.chkAll = false;
			}
			SpecialSeatSelect.list = list;
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