package train.seat_standard;
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
import java.sql.SQLException;
import java.util.ArrayList;
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
import train.search.Train_API;
import train.seat_special.SpecialSeatPanel;
import train.seat_special.SpecialWheelSeatPanel;

public class StandardSeatSelect extends JDialog {


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
	
	
	public static JPanel standardwheel4;
	public static JPanel standard5;
	public static JPanel standard6;
	public static JPanel standard7;
	public static JPanel standard8;
	public static JPanel standard9;
	public static JPanel standard10;
    
	public static JComboBox trainInfoComboBox;
	
	
	public static JToggleButton[] leftBtns4;
	public static JToggleButton[] rightBtns4;
	
	public static JToggleButton[] leftBtns5;
	public static JToggleButton[] rightBtns5;
	
	public static JToggleButton[] leftBtns6;
	public static JToggleButton[] rightBtns6;
	
	public static JToggleButton[] leftBtns7;
	public static JToggleButton[] rightBtns7;
	
	public static JToggleButton[] leftBtns8;
	public static JToggleButton[] rightBtns8;
	
	public static JToggleButton[] leftBtns9;
	public static JToggleButton[] rightBtns9;
	
	public static JToggleButton[] leftBtns10;
	public static JToggleButton[] rightBtns10;
	
    JButton selectResetButton;
    
    JPanel seatSelectPanel;
	public static JLabel trainInfoLabel;

    
    public static String getSelectedCar;
    private ActionListener resetActionListener;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StandardSeatSelect window = new StandardSeatSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StandardSeatSelect() {
		
	      getContentPane().setBackground(Color.WHITE);
	      
	      //[topPanel / middilPanel / lowPanel을 모두 포함하는 가장 큰 패널]
	      JPanel totalMainPanel = new JPanel();
	      totalMainPanel.setBackground(Color.WHITE);
	      getContentPane().add(totalMainPanel, BorderLayout.NORTH);
	      totalMainPanel.setLayout(new BorderLayout(0,0));
	      
	      // [화면 가운데에서 좌석선택 패널을 포함하는 패널]
	      JPanel middlePanel = new JPanel();
	      middlePanel.setBackground(Color.WHITE);
	      totalMainPanel.add(middlePanel, BorderLayout.CENTER);
	      middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
	      
		  seatSelectPanel = new JPanel();
	      CardLayout card = new CardLayout(10,10);
		  seatSelectPanel.setLayout(card);
		  seatSelectPanel.setBackground(new Color(255, 255, 255));
		  middlePanel.add(seatSelectPanel);
		  
	      //일반 예매를 눌렀을 때 > [4~10호차]
	      //4호차는 일반실 + 휠체어석
	      //5 ~ 10호차는 일반실 + 일반좌석
		  standardwheel4 = new StandardWheelSeatPanel();
		  leftBtns4 = ((StandardWheelSeatPanel) standardwheel4).getLeftSeatButtons();
		  rightBtns4 = ((StandardWheelSeatPanel) standardwheel4).getRightSeatButtons();
		  
		  standard5 = new StandardSeatPanel();
		  leftBtns5 = ((StandardSeatPanel) standard5).getLeftSeatButtons();
		  rightBtns5 = ((StandardSeatPanel) standard5).getRightSeatButtons();
		  
		  standard6 = new StandardSeatPanel();
		  leftBtns6 = ((StandardSeatPanel) standard6).getLeftSeatButtons();
		  rightBtns6 = ((StandardSeatPanel) standard6).getRightSeatButtons();
		  
		  standard7 = new StandardSeatPanel();
		  leftBtns7 = ((StandardSeatPanel) standard7).getLeftSeatButtons();
		  rightBtns7 = ((StandardSeatPanel) standard7).getRightSeatButtons();
		  
		  standard8 = new StandardSeatPanel();
		  leftBtns8 = ((StandardSeatPanel) standard8).getLeftSeatButtons();
		  rightBtns8 = ((StandardSeatPanel) standard8).getRightSeatButtons();
		  
		  standard9 = new StandardSeatPanel();
		  leftBtns9 = ((StandardSeatPanel) standard9).getLeftSeatButtons();
		  rightBtns9 = ((StandardSeatPanel) standard9).getRightSeatButtons();
		  
		  standard10 = new StandardSeatPanel();
		  leftBtns10 = ((StandardSeatPanel) standard10).getLeftSeatButtons();
		  rightBtns10 = ((StandardSeatPanel) standard10).getRightSeatButtons();
	      
	      seatSelectPanel.add("standard4",standardwheel4);
	      seatSelectPanel.add("standard5",standard5);
	      seatSelectPanel.add("standard6",standard6);
	      seatSelectPanel.add("standard7",standard7);
	      seatSelectPanel.add("standard8",standard8);
	      seatSelectPanel.add("standard9",standard9);
	      seatSelectPanel.add("standard10",standard10);
	      
	      
	      
	      // [화면 하단에서 좌석선택확인 라벨과 선택완료 버튼을 포함하는 패널]
	      JPanel lowPanel = new JPanel();
	      lowPanel.setBackground(Color.WHITE);
	      totalMainPanel.add(lowPanel, BorderLayout.SOUTH);

	      
	      selectedSeatInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 20));
		  lowPanel.add(selectedSeatInfoLabel);

		  
		  
	      //[화면 상단에서 호차선택콤보박스, 앞/뒤호차 이동 버튼, 현재 기차정보라벨을 포함하는 패널]
	      JPanel topPanel = new JPanel();
	      topPanel.setBackground(Color.WHITE);
	      totalMainPanel.add(topPanel, BorderLayout.NORTH);
	      topPanel.setLayout(new GridLayout(0, 1, 0, 0));
	      //상단패널을 상1- 콤보박스, 상2 - 라벨및버튼으로 나눔
	      JSplitPane splitPane = new JSplitPane(); 
	      splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	      topPanel.add(splitPane);
	      
	      JPanel top2panel = new JPanel();
	      splitPane.setRightComponent(top2panel);
	      top2panel.setLayout(new BorderLayout(0, 0));
	      //상1
	      
	      
	      
	      trainInfoLabel = new JLabel(); //들어가야하는 정보 : 현재 선택한 기차의 이름 + 객차의 타입 
	      trainInfoLabel.setBackground(new Color(255, 102, 153));
	      trainInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      trainInfoLabel.setFont(new Font(mainFont, Font.PLAIN, 30));
	      
	      
	      trainInfoComboBox = new JComboBox();
	      trainInfoComboBox.addActionListener(new ActionListener() {
	    	  
	    	  SeatDAO seat = new SeatDAO();
	          @Override
	          public void actionPerformed(ActionEvent e) {
	              getSelectedCar = (String)trainInfoComboBox.getSelectedItem();
					List<String> booked;
					String[] seatnum;
	              if(getSelectedCar.contains("4호차")) {
	            	  
	            	  seatnum = seat.getTrainName();
	        	      if(seatnum[3] == null) {
	        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
	        	      }else { 
	        	    	  trainInfoLabel.setText("잔여 " + seatnum[3] +"석 총 40석");
	        	      }
	        	      
	        	      booked = SeatDAO.bookedSeatList4;
	            	  for (JToggleButton button : leftBtns4) {
							for (String seatname : booked ) {
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
						for (JToggleButton button : rightBtns4) {
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
	            	  card.show(seatSelectPanel,"standard4");
	            	  
	              }else if(getSelectedCar.contains("5호차")) {
	            	  
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[4] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[4] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList5;
						for (JToggleButton button : leftBtns5) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns5) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard5");
					  
	              }else if(getSelectedCar.contains("6호차")) {
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[5] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[5] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList6;
						for (JToggleButton button : leftBtns6) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns6) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard6");
					  
					  
	              }else if(getSelectedCar.contains("7호차")) {
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[6] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[6] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList7;
						for (JToggleButton button : leftBtns7) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns7) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard7");
					  
					  
	              }else if(getSelectedCar.contains("8호차")) {
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[7] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[7] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList8;
						for (JToggleButton button : leftBtns8) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns8) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard8");
					  
					  
	            	  
	              }else if(getSelectedCar.contains("9호차")) {
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[8] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[8] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList9;
						for (JToggleButton button : leftBtns9) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns9) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard9");
	            	  
	              }else if(getSelectedCar.contains("10호차")) {
	            	  seatnum = seat.getTrainName();
		        		 if(seatnum[9] == null) {
		        	    	  trainInfoLabel.setText("잔여 40석 총 40석");
		        	    	  
		        	      }else { 
		        	    	  trainInfoLabel.setText("잔여 " + seatnum[9] +"석 총 40석");
		        	      }

	            	  booked = SeatDAO.bookedSeatList10;
						for (JToggleButton button : leftBtns10) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
						for (JToggleButton button : rightBtns10) {
							for (String seatname : booked) {
								if (button.getText().equals(seatname.trim())) {
									button.setEnabled(false);
								}
							}
						}
	            	  
	            	  card.show(seatSelectPanel,"standard10");
	              }
	          }
	      });
	      trainInfoComboBox.setPreferredSize(new Dimension(900, 50));
	      trainInfoComboBox.setBackground(Color.WHITE);
	      trainInfoComboBox.setFont(new Font(mainFont, Font.PLAIN, 20));
	      trainInfoComboBox.setMaximumRowCount(20);
	      trainInfoComboBox.setModel(getStandardCarInfo());
	      splitPane.setLeftComponent(trainInfoComboBox);
	      
	      JButton selectCompleteButton = new JButton("다음");
	      
	      selectCompleteButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		train.TrainReserv_Main.seatSelectString = list;
	      		if(list.isEmpty()) {
	      			UIManager.put("OptionPane.messageFont", new Font("HY헤드라인M", Font.BOLD, 30));
	      		    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("HY헤드라인M",Font.PLAIN, 40)));
	      			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요", "좌석선택", JOptionPane.WARNING_MESSAGE);
	      			return;
	      		}else {
	      			train.TrainReserv_Main.card.show(train.TrainReserv_Main.card_panel, "food");
		      		String num = (String)trainInfoComboBox.getSelectedItem();
		      		if(num.contains("4호차")) {
		      			train.TrainReserv_Main.carNum = 4;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>4호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>4호차<br> "+list.toString());
		      			}
		      			
		      		}else if(num.contains("5호차")) {
		      			train.TrainReserv_Main.carNum = 5;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>5호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>5호차<br> "+list.toString());
		      			}
		      		}else  if(num.contains("6호차")){
		      			train.TrainReserv_Main.carNum = 6;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>6호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>6호차<br> "+list.toString());
		      			}
		      		}else  if(num.contains("7호차")){
		      			train.TrainReserv_Main.carNum = 7;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>7호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>7호차<br> "+list.toString());
		      			}
		      		}else  if(num.contains("8호차")){
		      			train.TrainReserv_Main.carNum = 8;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>8호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>8호차<br> "+list.toString());
		      			}
		      		}else  if(num.contains("9호차")){
		      			train.TrainReserv_Main.carNum = 9;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>9호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>9호차<br> "+list.toString());
		      			}
		      		}else  if(num.contains("10호차")){
		      			train.TrainReserv_Main.carNum = 10;
		      			if(list.size() > 1) {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>10호차<br> "+list.get(0) + " 외 " +(list.size() - 1)+"개</html>");
		      			}else {
		      				train.TrainReserv_Main.seatSelectLabel.setText("<html>10호차<br> "+list.toString());
		      			}
		      		}
		      		TrainReserv_Main.count_panel =5;
		      		setVisible(false);
	      		}
	      	}
	      });
	      selectCompleteButton.setForeground(Color.WHITE);
	      
	      selectCompleteButton.setBackground(new Color(0, 128, 192));
	      selectCompleteButton.setBorderPainted(false);
	      selectCompleteButton.setFocusPainted(false);
	      selectCompleteButton.setFont(new Font(mainFont, Font.BOLD, 20));
	      lowPanel.add(selectCompleteButton);
	      
	      // 초기화버튼 
	      selectResetButton = new JButton("초기화");
	      addResetActionListener(seatSelectPanel, trainInfoComboBox,selectResetButton);

					
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
	    		  if (index == 6) {
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
	      
	      
	      
	      // 콤보박스 위에서 생성
	      top2panel.add(trainInfoLabel);
	      
	      
	      //좌석선택 다이얼로그를 닫으면 모든 값을 초기화한다
	      addWindowListener(new WindowAdapter() {
			    @Override
			    public void windowClosing(WindowEvent e) {
			    	initialize(seatSelectPanel, trainInfoComboBox);
			    	SeatDAO.bookedSeatList4.clear();
			    	SeatDAO.bookedSeatList5.clear();
			    	SeatDAO.bookedSeatList6.clear();
			    	SeatDAO.bookedSeatList7.clear();
			    	SeatDAO.bookedSeatList8.clear();
			    	SeatDAO.bookedSeatList9.clear();
			    	SeatDAO.bookedSeatList10.clear();
			    }
			});

	      setTitle("좌석 선택");
	      setSize(1000,650);
	      
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	      setVisible(true);
	      setResizable(false);
	      
	}

	 /**일반예매를 눌렀을 떄 콤보박스에 전달해줘야하는 모델을 리턴하는 메서드
	    *  trainType은 기차의 종류 trainTypeLen은 객차타입별 객차의 개수*/
	   DefaultComboBoxModel getStandardCarInfo() {
	      int standard = 7;
	      String[] trainInfo = new String[standard];

	      for (int i = 0; i <= trainInfo.length; i++) {
	         if (i == 0) { // 일반실 + 휠체어석 4호차
	            trainInfo[i] = i + 4 + "호차   (휠체어석) / 일반실";
	         } else if (i >= 1 && i <= 6) { // 일반실 +일반좌석 5~ 10호차
	            trainInfo[i] = i + 4+ "호차 / 일반실";
	         }
	      }

	      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(trainInfo);
	      return model;
	   }
	   
	   // 
	   private void initialize(JPanel panel, JComboBox combo) {
		   // 초기화버튼을 눌렀을 때 초기화 되어야 할 것
		   // - 선택한 좌석 리스트
		   // - 선택한 좌석의 상태
		   // - 라벨에 출력된 선택 좌석의 값
		   
		 	list = new ArrayList();
		    train.TrainReserv_Main.seatSelectString = list;
		    
		    chkAll = true;
		    selectedSeatInfoLabel.setText("");
		    
		    panel.removeAll();

		    standardwheel4 = new StandardWheelSeatPanel();
		    leftBtns4 = ((StandardWheelSeatPanel) standardwheel4).getLeftSeatButtons();
			rightBtns4 = ((StandardWheelSeatPanel) standardwheel4).getRightSeatButtons();
			  
		    standard5 = new StandardSeatPanel();
		    leftBtns5 = ((StandardSeatPanel) standard5).getLeftSeatButtons();
			rightBtns5 = ((StandardSeatPanel) standard5).getRightSeatButtons();
			  
		    standard6 = new StandardSeatPanel();
		    leftBtns6 = ((StandardSeatPanel) standard6).getLeftSeatButtons();
			rightBtns6 = ((StandardSeatPanel) standard6).getRightSeatButtons();
			
		    standard7 = new StandardSeatPanel();
		    leftBtns7 = ((StandardSeatPanel) standard7).getLeftSeatButtons();
			rightBtns7 = ((StandardSeatPanel) standard7).getRightSeatButtons();
			
		    standard8 = new StandardSeatPanel();
		    leftBtns8 = ((StandardSeatPanel) standard8).getLeftSeatButtons();
			rightBtns8 = ((StandardSeatPanel) standard8).getRightSeatButtons();
			
		    standard9 = new StandardSeatPanel();
		    leftBtns9 = ((StandardSeatPanel) standard9).getLeftSeatButtons();
			rightBtns9 = ((StandardSeatPanel) standard9).getRightSeatButtons();
			
		    standard10 = new StandardSeatPanel();
		    leftBtns10 = ((StandardSeatPanel) standard10).getLeftSeatButtons();
			rightBtns10 = ((StandardSeatPanel) standard10).getRightSeatButtons();

		    panel.add("standard4", standardwheel4);
		    panel.add("standard5", standard5);
		    panel.add("standard6", standard6);
		    panel.add("standard7", standard7);
		    panel.add("standard8", standard8);
		    panel.add("standard9", standard9);
		    panel.add("standard10", standard10);
		    
		    
		    //콤보박스의 현재 선택된 값이 초기화 후에 초기화면으로 나와야함
		    getSelectedCar = (String)combo.getSelectedItem();
		    List<String> booked;
            if(getSelectedCar.contains("4호차")) {
            	booked = SeatDAO.bookedSeatList4;
          	  for (JToggleButton button : leftBtns4) {
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
					for (JToggleButton button : rightBtns4) {
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
          	  ((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard4");
				System.out.println("초기화 " + SeatDAO.bookedSeatList4.toString());
				
            }else if(getSelectedCar.contains("5호차")) {
            	booked = SeatDAO.bookedSeatList5;
					for (JToggleButton button : leftBtns5) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns5) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard5");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList5.toString());
            }else if(getSelectedCar.contains("6호차")) {
            	booked = SeatDAO.bookedSeatList6;
					for (JToggleButton button : leftBtns6) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns6) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard6");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList6.toString());
            	
            }else if(getSelectedCar.contains("7호차")) {
            	booked = SeatDAO.bookedSeatList7;
					for (JToggleButton button : leftBtns7) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns7) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard7");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList7.toString());
            	
            	
            }else if(getSelectedCar.contains("8호차")) {
            	booked = SeatDAO.bookedSeatList8;
					for (JToggleButton button : leftBtns8) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns8) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard8");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList8.toString());
            }else if(getSelectedCar.contains("9호차")) {
            	booked = SeatDAO.bookedSeatList9;
					for (JToggleButton button : leftBtns9) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns9) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard9");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList9.toString());
            	
            }else if(getSelectedCar.contains("10호차")) {
            	booked = SeatDAO.bookedSeatList10;
					for (JToggleButton button : leftBtns10) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
					for (JToggleButton button : rightBtns10) {
						for (String seatname : booked) {
							if (button.getText().equals(seatname.trim())) {
								button.setEnabled(false);
							}
						}
					}
            	((CardLayout) panel.getLayout()).show(seatSelectPanel,"standard10");
            	System.out.println("초기화 " + SeatDAO.bookedSeatList10.toString());
            }
		    
		    
		}
	   
	   private void addResetActionListener(JPanel panel,JComboBox combo, JButton button) {
		    resetActionListener = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            initialize(panel,combo);
		        }
		    };
		    button.addActionListener(resetActionListener);
		}
	  
}