package train.search.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class SearchBtn extends JButton {

	private String name;
	private int price;
	private int qty = 1;
	
	/** 버튼 생성시, 타입, 이름, 가격, 모델, 전체 가격 라벨명 입력*/
	public SearchBtn(String name, int price, DefaultTableModel model, JLabel totalPrice) {
		this.name = name;
		this.price = price;
		
		setSize(180, 150);
		
		// 버튼 테두리 없애기
		setBorderPainted(false);
	    setContentAreaFilled(false);
	    setFocusPainted(false);	
	    
	    addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addTableColumn(model, totalPrice);	
			}
		});
	}
	
	/** 버튼에 넣을 이미지를 입력하는 메소드 */
	public void getImage(String location) {
		try {
			this.setIcon(new ImageIcon(ImageIO.read(new File(location)).getScaledInstance(180, 150, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 버튼 클릭하면 JTable에 행을 추가하는 메소드 */ 
	void addTableColumn(DefaultTableModel model, JLabel totalPrice) {
		
		boolean value = false;
		int sum = 0;
		
		for(int i=0; i < model.getRowCount(); i++){
			// 음식이름 0, 가격 1, - 2, 수량 3, + 4, 취소 5
			if(getName().equals(model.getValueAt(i, 0))) {
				// 음식이름을 조회하여, 같은 이름이 있으면 수량만 추가
				int qty = (int) model.getValueAt(i, 3) + 1;
				model.setValueAt(qty, i, 3);
				value = true;
				break;
			} 			
		}
		
		if (!value) {
			// 같은 이름이 없으면 리스트에 추가
			Vector<Object> list = new Vector<>();
			list.add(getName());
			list.add(getPrice());
			list.add(" "); // - 버튼 자리임
			list.add(getQty());
			model.addRow(list);
		}
		
		// 총 가격 라벨에 총 계 가격 추가
		for (int i = 0; i < model.getRowCount(); ++i) {
			int qty = (int) model.getValueAt(i, 3);
			
			sum += (int) model.getValueAt(i, 1) * qty;
		}
		totalPrice.setText(String.valueOf(sum) + "원");
	}
	
	// Getter	
	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public int getPrice() {
		return price;
	}

}
