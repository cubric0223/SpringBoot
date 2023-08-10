package train.food.component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author KSJ
 *
 */


// 메뉴 라벨 (FoodBtn이 갖고 있는 값 출력을 위한 라벨)
public class FoodLab extends JLabel {

	public FoodLab(String text) {
		setText(text);
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		setSize(176, 24);
	}
}
