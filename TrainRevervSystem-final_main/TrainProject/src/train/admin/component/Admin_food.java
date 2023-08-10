package train.admin.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.dao.FoodDAO;
import train.dto.FoodDTO;

/**
 * @author KSJ
 *
 */


// 차내식 관리 패널
public class Admin_food extends JPanel {
	
	FoodDAO fooddao = new FoodDAO();
	List<FoodDTO> allFoodList = fooddao.getFoodAll(); // DB에서 차내식 메뉴 전체 조회
	
	File imagefile;
	String originalFile;
	boolean addsuccess, revisesuccess;
	
	String[] orderTableColumnName = {"음식No.", "대분류", "이름", "가격", "삭제"};
	String[] categoryMenuName = {"식사류", "면류", "간식류", "음료"};
	
	JPanel mainPanel, addMenuPanel;
	JButton searchBtn, addImageBtn, addMenuBtn, resetBtn, reverseBtn;
	JTextField foodnametext, pricetext, imageFileNameLab, foodNoTextField;
	JTable order_table;
	JScrollPane user_sp;
	DefaultTableModel order_dtm;
	JLabel foodNolbl;
	JComboBox<String> categorycomboBox = new JComboBox<>(categoryMenuName);
	
	public Admin_food() {
		// 기본 양식
		setBounds(441, 80, 1600, 800);		
		setBackground(Color.white);
		setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(50, 100, 1600, 480);
		add(mainPanel);
		mainPanel.setLayout(new GridLayout());
		
		order_dtm = new DefaultTableModel(orderTableColumnName, 0);		
		order_table = new JTable(order_dtm);
			// 테이블 양식
			order_table.setFont(new Font("HY헤드라인M", Font.PLAIN, 17));	
			order_table.getTableHeader().setFont(new Font("HY헤드라인M", Font.BOLD, 20));
			order_table.setRowHeight(50);
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			order_table.getColumn("음식No.").setCellRenderer(celAlignCenter);
			order_table.getColumn("대분류").setCellRenderer(celAlignCenter);
			order_table.getColumn("이름").setCellRenderer(celAlignCenter);
			order_table.getColumn("가격").setCellRenderer(celAlignCenter);
			order_table.getColumn("삭제").setCellRenderer(celAlignCenter);
			order_table.getColumn("음식No.").setPreferredWidth(100);		
			order_table.getColumn("대분류").setPreferredWidth(100);	
			order_table.getColumn("이름").setPreferredWidth(150);
			order_table.getColumn("가격").setPreferredWidth(50);
			order_table.getColumn("삭제").setPreferredWidth(10);
			
			order_table.getColumn("삭제").setCellRenderer(new DeleteFoodBtn("삭제", order_table));
			order_table.getColumn("삭제").setCellEditor(new DeleteFoodBtn("삭제", order_table));
			
			// 테이블 값 클릭 시, 텍스트 라벨들에 값 출력
			order_table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = order_table.getSelectedRow();
						if (row != -1) {						
							categorycomboBox.setSelectedItem(order_table.getValueAt(row, 1));
							foodNoTextField.setText((String) order_table.getValueAt(row, 0));
							foodnametext.setText((String) order_table.getValueAt(row, 2));
							pricetext.setText(String.valueOf(order_table.getValueAt(row, 3)));
							imageFileNameLab.setText((String) order_table.getValueAt(row, 4));
						}						
					}
				});
		
		user_sp = new JScrollPane(order_table);
		user_sp.setBounds(60, 50, 1600, 800);
		mainPanel.add(user_sp);
		
		searchBtn = new JButton("조회");
		searchBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				getMenuValue(order_dtm); // 조회 버튼 클릭 시, 테이블에 전체 메뉴 출력			
			}
		});
		searchBtn.setBackground(new Color(0, 128, 192));
		searchBtn.setForeground(Color.white);
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		searchBtn.setBounds(50, 20, 220, 60);
		add(searchBtn);
		
		// 하단 메뉴 추가, 수정 패널
		addMenuPanel = new JPanel();
		addMenuPanel.setBackground(new Color(255, 255, 255));
		addMenuPanel.setBounds(50, 600, 1600, 156);
		add(addMenuPanel);
		addMenuPanel.setLayout(null);
		
		JLabel categoryLabel = new JLabel("대분류");
		categoryLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		categoryLabel.setBounds(12, 45, 72, 40);
		addMenuPanel.add(categoryLabel);
		
		JLabel foodNameLab = new JLabel("음식명");
		foodNameLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		foodNameLab.setBounds(521, 45, 72, 40);
		addMenuPanel.add(foodNameLab);
		
		JLabel priceLab = new JLabel("가격");
		priceLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		priceLab.setBounds(854, 45, 45, 40);
		addMenuPanel.add(priceLab);
		
		categorycomboBox.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		categorycomboBox.setBounds(83, 45, 180, 40);
		addMenuPanel.add(categorycomboBox);
		
		foodnametext = new JTextField();
		foodnametext.setColumns(10);
		foodnametext.setBounds(594, 45, 248, 40);
		addMenuPanel.add(foodnametext);
		
		pricetext = new JTextField();
		pricetext.setColumns(10);
		pricetext.setBounds(911, 45, 187, 40);
		addMenuPanel.add(pricetext);
		
		JLabel NotionLab = new JLabel("※ 메뉴 추가 시, 음식 No는 자동으로 부여됩니다");
		NotionLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		NotionLab.setForeground(new Color(0, 128, 255));
		NotionLab.setBounds(12, 10, 332, 25);
		addMenuPanel.add(NotionLab);
		
		imageFileNameLab = new JTextField();
		imageFileNameLab.setColumns(10);
		imageFileNameLab.setBounds(1236, 45, 248, 40);
		addMenuPanel.add(imageFileNameLab);
		
		addImageBtn = new JButton("이미지 추가");
		addImageBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 13));
		addImageBtn.setBounds(1118, 45, 106, 40);
		addImageBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (imageFileNameLab.getText() != null) {
					originalFile = imageFileNameLab.getText();
				}
				imagefile = uploadImage(); // 이미지 추가 클릭 시, 폴더에 이미지 업로드
				imageFileNameLab.setText(imagefile.getName()); // 이미지 파일 라벨에 이미지 파일 텍스트 값 출력
			}
		});
		addMenuPanel.add(addImageBtn);
		
		addMenuBtn = new JButton("메뉴 추가");
		addMenuBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		addMenuBtn.setBounds(1410, 95, 127, 43);
		
		// 메뉴 추가 눌렀을 때, 유효성 검사 -> 안맞는거 다이얼로그 오픈 및 텍스트 값 NULL 세팅
		addMenuBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodNo = foodNoTextField.getText();
				String foodName = foodnametext.getText();
				String price = pricetext.getText();
				String image = imageFileNameLab.getText();
				
				if (foodName.isBlank()) {
					JOptionPane.showMessageDialog(null, "음식명을 입력해주세요"
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				if (price.isBlank()) {
					JOptionPane.showMessageDialog(null, "가격을 입력해주세요"
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				for (int i = 0; i < price.length(); ++i) {
					if (!(price.charAt(i) >= '0' && price.charAt(i) <= '9')) {
						JOptionPane.showMessageDialog(null, "가격은 숫자만 입력해주세요"
								,"Warning", JOptionPane.DEFAULT_OPTION);
						pricetext.setText(null);
						return;
					}
				}
				
				if (image.isBlank()) {
					JOptionPane.showMessageDialog(null, "메뉴의 이미지 파일을 추가해주세요."
							,"Warning", JOptionPane.DEFAULT_OPTION);
					return;
				}
				// DB에 차내식 메뉴 추가
				addsuccess = fooddao.addFood(new FoodDTO(foodNo, categorycomboBox.getSelectedItem().toString(), foodName, Integer.valueOf(price), image));
				if (addsuccess) {
					saveFile(imagefile); // 차내식 메뉴 추가가 성공하면, 폴더에 이미지 파일 추가
					getMenuValue(order_dtm); // 테이블 값 재설정
					initialization(); // 라벨 값 초기화
				} else {
					initialization(); // 라벨 값 초기화
				}	
			}
		});
		addMenuPanel.add(addMenuBtn);
		
		reverseBtn = new JButton("메뉴 수정");
		reverseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴 수정 시, DB 업데이트
				String foodNo = foodNoTextField.getText();
				String foodName = foodnametext.getText();
				String price = pricetext.getText();
				String image = imageFileNameLab.getText();	
				
				revisesuccess = fooddao.updateFood(new FoodDTO(foodNo, categorycomboBox.getSelectedItem().toString(), foodName, Integer.valueOf(price), image));
				if (revisesuccess) { // 다른 이미지 파일을 올렸을 때만, 폴더에 이미지 파일 저장
					if (!image.equals(originalFile)) {
						deleteFile(originalFile);
						saveFile(imagefile);						
					}
					getMenuValue(order_dtm);
					initialization();
				}
			}
		});
		reverseBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		reverseBtn.setBounds(1267, 95, 127, 43);
		addMenuPanel.add(reverseBtn);
		
		resetBtn = new JButton("새로고침");
		resetBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));
		resetBtn.setBounds(1128, 95, 117, 43);
		resetBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				initialization();			
			}
		});
		addMenuPanel.add(resetBtn);
		
		foodNolbl = new JLabel("음식No.");
		foodNolbl.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		foodNolbl.setBounds(287, 45, 72, 40);
		addMenuPanel.add(foodNolbl);
		
		foodNoTextField = new JTextField();
		foodNoTextField.setEditable(false);
		foodNoTextField.setEnabled(false);
		foodNoTextField.setColumns(10);
		foodNoTextField.setBounds(371, 45, 136, 40);
		addMenuPanel.add(foodNoTextField);
	} // 생성자 end	
	
	/** 컴퓨터에서 이미지 파일을 불러오는 메서드 */
	@SuppressWarnings("static-access")
	private File uploadImage() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("이미지 파일 불러오기");
		chooser.setMultiSelectionEnabled(false); // 다중 선택 불가
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() { // jpg png만 보이게
            
            @Override
            public String getDescription() {
                return null;
            }
           
            @Override
            public boolean accept(File f) {
                String fileName = f.getName();

                if(fileName.indexOf(".png") != -1)
                {
                    return true;
                }
                else if(fileName.indexOf(".jpg") != -1)
                {
                    return true;
                }
                else if(f.isDirectory())
                {
                    return true;
                }               
                return false;
            }
        });
		   
	  	int returnVal = chooser.showSaveDialog(null);	  	
	  	if (returnVal == chooser.APPROVE_OPTION) {
	  		File selectedFile = chooser.getSelectedFile();	  		
	  		if (selectedFile == null) {
	  			return null;
	  		} else {
	  			return chooser.getSelectedFile();
	  		}	  		
	  	}
		return null;	  	
	}

	/** resource 폴더에 새로운 파일을 저장하는 메서드 */
	private void saveFile(File file) {
		File selectedFile = file;
		String destinationFolder = "resource/";
		
		try {
            Path sourcePath = selectedFile.toPath();
            Path destinationPath = new File(destinationFolder, selectedFile.getName()).toPath();
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(null, "파일 저장 완료", "성공", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "파일 저장 중 오류 발생", "오류", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
	}
	
	/** resource 폴더에 있는 기존 이미지 파일을 삭제하는 메서드 */
	private void deleteFile(String imageFileName) {		
		String destinationFolder = "resource/";
		Path filePath = Paths.get(destinationFolder + imageFileName);
		
		try {
			Files.delete(filePath);
		} catch (NoSuchFileException err1) {
			System.err.println("삭제하려는 파일 / 디렉토리가 없습니다");
		} catch (IOException err2) {
			err2.printStackTrace();
		}
	}
	
	/** DB에서 차내식을 조회하여 테이블에 출력하는 메서드 */
	private void getMenuValue(DefaultTableModel order_dtm) {
		order_dtm.setNumRows(0); // 테이블 초기화
		
		allFoodList = fooddao.getFoodAll();
		
		for (FoodDTO food : allFoodList) {
			Vector<Object> list = new Vector<>();
			list.add(food.getFood_number());
			list.add(food.getfood_type());
			list.add(food.getFood_name());
			list.add(food.getFood_price());
			list.add(food.getImage_location());
			order_dtm.addRow(list);
		}
	}
	
	/** 하단 차내식 수정, 추가 패널의 텍스트 라벨 값을 초기화하는 메서드 */
	private void initialization() {
		categorycomboBox.setSelectedIndex(0);
		foodNoTextField.setText(null);
		foodnametext.setText(null);
		pricetext.setText(null);
		imageFileNameLab.setText(null);	
	}
	
	/** 패널의 모든 값을 초기화하는 메서드 (AdminFrame에서 패널 넘어갈 때 마다 초기화) */
	public void reset() {
		order_dtm.setRowCount(0);
		categorycomboBox.setSelectedIndex(0);
		foodNoTextField.setText(null);
		foodnametext.setText(null);
		pricetext.setText(null);
		imageFileNameLab.setText(null);			
	}
}