package train.seat_special;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import train.TrainReserv_Main;
import train.dao.SeatDAO;
import train.search.component.ReservBtn;

public class SpecialSeatSelect extends JDialog {

	private JFrame frame;
	private String fisrtH = "<html>";
	private String middleH = "<br> /";
	public static JLabel selectedSeatInfoLabel = new JLabel();

	public static void setLabel(String str) {
		selectedSeatInfoLabel.setText(str);
	}

	public static List<String> list;
	public static boolean chkAll = true;
	private String mainFont = "HY헤드라인M";

	public static JPanel specialwheel1;
	public static JPanel special2;
	public static JPanel special3;

	public static JComboBox trainInfoComboBox;
	public static JToggleButton[] leftBtns1;
	public static JToggleButton[] rightBtns1;
	
	public static JToggleButton[] leftBtns2;
	public static JToggleButton[] rightBtns2;
	
	public static JToggleButton[] leftBtns3;
	public static JToggleButton[] rightBtns3;
	
	
//	SeatDAO seat = new SeatDAO();

    JButton selectResetButton;
    
    JPanel seatSelectPanel;
	public static JLabel trainInfoLabel;

	//List<String> booked;

    public static String getSelectedCar;
    private ActionListener resetActionListener;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecialSeatSelect window = new SpecialSeatSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SpecialSeatSelect() {
		getContentPane().setBackground(Color.WHITE);

		// [topPanel / middilPanel / lowPanel을 모두 포함하는 가장 큰 패널]
		JPanel totalMainPanel = new JPanel();
		totalMainPanel.setBackground(Color.WHITE);
		getContentPane().add(totalMainPanel, BorderLayout.NORTH);
		totalMainPanel.setLayout(new BorderLayout(0, 0));

		// [화면 가운데에서 좌석선택 패널을 포함하는 패널]
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(Color.WHITE);
		totalMainPanel.add(middlePanel, BorderLayout.CENTER);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));

		seatSelectPanel = new JPanel();
		CardLayout card = new CardLayout(10, 10);
		seatSelectPanel.setLayout(card);
		seatSelectPanel.setBackground(new Color(255, 255, 255));
		middlePanel.add(seatSelectPanel);

		// 특실예매를 눌렀을 때 > [1~3호차]
		// 1호차는 특실 + 휠체어석
		// 2,3호차는 특실 + 일반좌석
		
		specialwheel1 = new SpecialWheelSeatPanel();
		leftBtns1 = ((SpecialWheelSeatPanel) specialwheel1).getLeftSeatButtons();
	    rightBtns1 = ((SpecialWheelSeatPanel) specialwheel1).getRightSeatButtons();
	    
	    
		special2 = new SpecialSeatPanel();
		leftBtns2 = ((SpecialSeatPanel) special2).getLeftSeatButtons();
	    rightBtns2 = ((SpecialSeatPanel) special2).getRightSeatButtons();
		
		special3 = new SpecialSeatPanel();
		leftBtns3 = ((SpecialSeatPanel) special3).getLeftSeatButtons();
	    rightBtns3 = ((SpecialSeatPanel) special3).getRightSeatButtons();
	    
		seatSelectPanel.add("special1", specialwheel1);
		seatSelectPanel.add("special2", special2);
		seatSelectPanel.add("special3", special3);

		// specialwheel1 (1호차)의 좌석
		
		
		// [화면 하단에서 좌석선택확인 라벨과 선택완료 버튼을 포함하는 패널]
		JPanel lowPanel = new JPanel();
		lowPanel.setBackground(Color.WHITE);
		totalMainPanel.add(lowPanel, BorderLayout.SOUTH);

		selectedSeatInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 20));
		lowPanel.add(selectedSeatInfoLabel);

		
		
		// [화면 상단에서 호차선택콤보박스, 앞/뒤호차 이동 버튼, 현재 기차정보라벨을 포함하는 패널]
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		totalMainPanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JSplitPane splitPane = new JSplitPane(); // 상단패널을 상1- 콤보박스, 상2 - 라벨및버튼으로 나눔
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		topPanel.add(splitPane);

		JPanel top2panel = new JPanel();
		splitPane.setRightComponent(top2panel);
		top2panel.setLayout(new BorderLayout(0, 0));

		// 앞에서 기차정보를 받아와서 넣어야함(잔여좌석도)

		trainInfoLabel = new JLabel();
		trainInfoLabel.setBackground(new Color(255, 102, 153));
		trainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 30));

		
		trainInfoComboBox = new JComboBox();
		trainInfoComboBox.addActionListener(new ActionListener() {
			// 예약된 좌석 목록 받아오기
			SeatDAO seat = new SeatDAO();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String getSelectedCar = (String) trainInfoComboBox.getSelectedItem();
				List<String> booked;
				
				String[] seatnum;
//				System.out.println("콤보박스 1호차 선택 " + Arrays.toString(seatnum));
				
				
				if (getSelectedCar.contains("1호차")) {
					seatnum = seat.getTrainName();
					//trainInfoLabel에 잔여좌석을 보여준다
	            	if(seatnum[0] == null) {
	        	    	  trainInfoLabel.setText("잔여 30석 총 30석");
	        	    	  
	        	      }else { 
	        	    	  trainInfoLabel.setText("잔여 "+ seatnum[0] +"석 총 30석");
	        	      }
	            	
	            	
	            	// 예약이 완료된 좌석은 선택 불가능하도록 함
	        		 booked = SeatDAO.bookedSeatList1;
					for (JToggleButton button : leftBtns1) {
						for (String seatname : booked) {
							if (button.getText().contains(fisrtH)) {
								String[] seatarr = button.getText().split("<|>");

								if (seatarr[2].equals(seatname.trim())) {
									button.setEnabled(false);
								}

							} else {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
					}
					for (JToggleButton button : rightBtns1) {
						for (String seatname : booked) {

							if (button.getText().contains(fisrtH)) {
								String[] seatarr = button.getText().split("<|>");

								if (seatarr[2].equals(seatname.trim())) {
									button.setEnabled(false);
								}

							} else {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
					}
					card.show(seatSelectPanel, "special1");

				} 
				
				
				else if (getSelectedCar.contains("2호차")) {
					seatnum = seat.getTrainName();
	        		 if(seatnum[1] == null) {
	        	    	  trainInfoLabel.setText("잔여 30석 총 30석");
	        	    	  
	        	      }else { 
	        	    	  trainInfoLabel.setText("잔여 " + seatnum[1] +"석 총 30석");
	        	      }

	        		 
	        		 booked = SeatDAO.bookedSeatList2;
					for (JToggleButton button : leftBtns2) {
						for (String seatname : SeatDAO.bookedSeatList2) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns2) {
						for (String seatname : SeatDAO.bookedSeatList2) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					card.show(seatSelectPanel, "special2");


					
				} else if (getSelectedCar.contains("3호차")) {

					seatnum = seat.getTrainName();
					if(seatnum[2] == null) {
	        	    	  trainInfoLabel.setText("잔여 30석 총 30석");
	        	    	  
	        	      }else { 
	        	    	  trainInfoLabel.setText("잔여 " + seatnum[2] +"석 총 30석");
	        	      }
	        		 booked = SeatDAO.bookedSeatList3;
					for (JToggleButton button : leftBtns3) {
						for (String seatname : SeatDAO.bookedSeatList3) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns3) {
						for (String seatname : SeatDAO.bookedSeatList3) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					card.show(seatSelectPanel, "special3");

				}

			}
		});

		trainInfoComboBox.setPreferredSize(new Dimension(900, 50));
		trainInfoComboBox.setBackground(Color.WHITE);
		trainInfoComboBox.setFont(new Font(mainFont, Font.PLAIN, 20));
		trainInfoComboBox.setMaximumRowCount(20);
		trainInfoComboBox.setModel(getSpecialCarInfo());
		splitPane.setLeftComponent(trainInfoComboBox);

		JButton selectCompleteButton = new JButton("다음");
		selectCompleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.TrainReserv_Main.seatSelectString = list;
				
				if(list.isEmpty()) {
					try {
	      			UIManager.put("OptionPane.messageFont", new Font("HY헤드라인M", Font.BOLD, 30));
	      		    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("HY헤드라인M",Font.PLAIN, 40)));
	      			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요", "좌석선택", JOptionPane.WARNING_MESSAGE);
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
	      		}else {
	      			train.TrainReserv_Main.card.show(train.TrainReserv_Main.card_panel, "food");
					String num = (String) trainInfoComboBox.getSelectedItem();
					if (num.contains("1호차")) {
						train.TrainReserv_Main.carNum = 1;
						if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>1호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>1호차<br> "+list.toString());
		      			}
					} else if (num.contains("2호차")) {
						train.TrainReserv_Main.carNum = 2;
						if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>2호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>2호차<br> "+list.toString());
		      			}
					} else if (num.contains("3호차")) {
						train.TrainReserv_Main.carNum = 3;
						if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>3호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>3호차<br> "+list.toString());
		      			}
					}
					TrainReserv_Main.count_panel = 5;
					dispose();
	      		}
				
			}
		});
		
		
		selectCompleteButton.setForeground(Color.WHITE);

		selectCompleteButton.setBackground(new Color(0, 128, 192));
		selectCompleteButton.setBorderPainted(false);
		selectCompleteButton.setFocusPainted(false);
		selectCompleteButton.setFont(new Font(mainFont, Font.BOLD, 20));
		lowPanel.add(selectCompleteButton);

		JButton selectResetButton = new JButton("초기화");
		addResetActionListener(seatSelectPanel,trainInfoComboBox, selectResetButton);
		selectResetButton.setForeground(Color.WHITE);
		selectResetButton.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		selectResetButton.setFocusPainted(false);
		selectResetButton.setBorderPainted(false);
		selectResetButton.setBackground(new Color(0, 128, 192));
		lowPanel.add(selectResetButton);

		JButton previousCarButton = new JButton("<");
		previousCarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = trainInfoComboBox.getSelectedIndex();
				if (index == 0) {
					System.out.println("카드 레이아웃의 끝임");
				} else {
					card.previous(seatSelectPanel);
					trainInfoComboBox.setSelectedIndex(index - 1);
				}
			}
		});
		previousCarButton.setForeground(Color.WHITE);
		previousCarButton.setBackground(new Color(0, 128, 192));
		previousCarButton.setBorderPainted(false);
		previousCarButton.setFocusPainted(false);
		previousCarButton.setFont(new Font(mainFont, Font.BOLD, 20));

		top2panel.add(previousCarButton, BorderLayout.WEST);

		JButton nextCarButton = new JButton(">");
		nextCarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = trainInfoComboBox.getSelectedIndex();
				if (index == 2) {
					System.out.println("카드 레이아웃의 마지막 번호임");
				} else {
					card.next(seatSelectPanel);
					trainInfoComboBox.setSelectedIndex(index + 1);
				}
			}
		});
		nextCarButton.setForeground(Color.WHITE);
		nextCarButton.setBackground(new Color(0, 128, 192));
		nextCarButton.setBorderPainted(false);
		nextCarButton.setFocusPainted(false);
		nextCarButton.setFont(new Font(mainFont, Font.BOLD, 20));


		top2panel.add(nextCarButton, BorderLayout.EAST);
		
		
		//기차의 각 호차별 남은 좌석 수를 알려주는 라벨!!!!!!!!콤보박스 위에서 생성됨
		top2panel.add(trainInfoLabel);

		//좌석선택 다이얼로그를 닫으면 모든 값을 초기화한다
	    addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			    initialize(seatSelectPanel,trainInfoComboBox);
			    SeatDAO.bookedSeatList1.clear();
			    SeatDAO.bookedSeatList2.clear();
			    SeatDAO.bookedSeatList3.clear();
			}
		});
		
		setTitle("좌석 선택");
		setSize(1000, 650);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);

	}

	/** 특실예매를 눌렀을 떄 콤보박스에 전달해줘야하는 모델을 리턴하는 메서드 */
	DefaultComboBoxModel getSpecialCarInfo() {
		int special = 3;
		String[] trainInfo = new String[special];

		for (int i = 0; i <= trainInfo.length; i++) {
			if (i + 1 == 1) { // 특실 + 휠체어석 1호차
				trainInfo[i] = i + 1 + "호차   (휠체어석) / 특실";
			} else if (i + 1 == 2 || i + 1 == 3) { // 일반실 +일반좌석 5~ 10호차
				trainInfo[i] = i + 1 + "호차 / 특실";
			}
		}

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(trainInfo);
		return model;
	}
	
	
	/** 좌석 선택 패널 초기화 메서드 */
	 private void initialize(JPanel panel, JComboBox combo) {
		   // 초기화버튼을 눌렀을 때 초기화 되어야 할 것
		   // - 선택한 좌석 리스트
		   // - 선택한 좌석의 상태
		   // - 라벨에 출력된 선택 좌석의 값
		   // - 이미 예약된 좌석의 목록을 받아 해당 좌석선택 버튼은 비활성화를 유지한다
		 	list = new ArrayList();
		    train.TrainReserv_Main.seatSelectString = list;
		    chkAll = true;
		    selectedSeatInfoLabel.setText("");

		    
		    panel.removeAll();
		    
			specialwheel1 = new SpecialWheelSeatPanel();
			leftBtns1 = ((SpecialWheelSeatPanel) specialwheel1).getLeftSeatButtons();
		    rightBtns1 = ((SpecialWheelSeatPanel) specialwheel1).getRightSeatButtons();
		    
			special2 = new SpecialSeatPanel();
			leftBtns2 = ((SpecialSeatPanel) special2).getLeftSeatButtons();
		    rightBtns2 = ((SpecialSeatPanel) special2).getRightSeatButtons();
		    
			special3 = new SpecialSeatPanel();
			leftBtns3 = ((SpecialSeatPanel) special3).getLeftSeatButtons();
		    rightBtns3 = ((SpecialSeatPanel) special3).getRightSeatButtons();

		    
			panel.add("special1", specialwheel1);
			panel.add("special2", special2);
			panel.add("special3", special3);

			
			//콤보박스의 현재 선택된 값이 초기화 후에 초기화면으로 나와야함
		    getSelectedCar = (String)combo.getSelectedItem();
		    List<String> booked;
            if(getSelectedCar.contains("1호차")) {
            	booked = SeatDAO.bookedSeatList1;
				for (JToggleButton button : leftBtns1) {
					for (String seatname : booked) {
						if (button.getText().contains(fisrtH)) {
							String[] seatarr = button.getText().split("<|>");

							if (seatarr[2].equals(seatname.trim())) {
								button.setEnabled(false);
							}

						} else {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
				}
				for (JToggleButton button : rightBtns1) {
					for (String seatname : booked) {

						if (button.getText().contains(fisrtH)) {
							String[] seatarr = button.getText().split("<|>");

							if (seatarr[2].equals(seatname.trim())) {
								button.setEnabled(false);
							}

						} else {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
				}
          	  ((CardLayout) panel.getLayout()).show(seatSelectPanel,"specialwheel1");
          	  
            }
            
            else if(getSelectedCar.contains("2호차")) {
            	booked = SeatDAO.bookedSeatList2;
				for (JToggleButton button : leftBtns2) {
					
					for (String seatname : booked) {
						if (button.getText().equals(seatname.trim())) {
							button.setEnabled(false);
							break;
						}
					}
				}
				for (JToggleButton button : rightBtns2) {
					for (String seatname : booked) {
						if (button.getText().equals(seatname.trim())) {
							button.setEnabled(false);
							break;
						}
					}
				}

            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"special2");
            	
            	
            }else if(getSelectedCar.contains("3호차")) {
            	booked = SeatDAO.bookedSeatList2;
				for (JToggleButton button : leftBtns3) {
					for (String seatname : booked) {
						if (button.getText().equals(seatname.trim())) {
							button.setEnabled(false);
						}
					}
				}
				for (JToggleButton button : rightBtns3) {
					for (String seatname : booked) {
						if (button.getText().equals(seatname.trim())) {
							button.setEnabled(false);
						}
					}
				}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"special3");

            }
            

		}
	 
	   private void addResetActionListener(JPanel panel, JComboBox combo, JButton button) {
		    resetActionListener = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            initialize(panel,combo);
		        }
		    };
		    button.addActionListener(resetActionListener);
		}
}