package train.jungjun;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.Train_Main;
import train.jungjun.change.Mem_change;
import train.jungjun.change.No_mem_change;
import train.jungjun.login_join_page.Login_and_join;

public class GoMain extends JDialog {
	
	public static boolean close = false;
	
	private final JPanel contentPanel = new JPanel();
//	public static boolean Goclose = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GoMain dialog = new GoMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GoMain() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(650, 250, 600, 600);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 584, 350);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel label1 = new JLabel("처음으로 돌아가시겠습니까?");
			label1.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			label1.setBounds(90, 90, 400, 75);
			contentPanel.add(label1);
		}
		{
			JLabel label2 = new JLabel("진행 내역이 초기화됩니다");
			label2.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
			label2.setBounds(90, 160, 400, 75);
			contentPanel.add(label2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 360, 584, 201);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("확인");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Train_Main gomain = new Train_Main();
						close = true;
						//System.out.println(close);
						gomain.main(null);
						Login_and_join close = new Login_and_join();
						close.runApplication();
						Change_main close2 = new Change_main();
						close2.runApplication();
						No_login_join close3 = new No_login_join();
						close3.runApplication();
						No_mem_change close4 = new No_mem_change();
						close4.runApplication();
						Mem_change close5 = new Mem_change();
						close5.runApplication();
						dispose();
					}
				});
				okButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 128, 192));
				okButton.setBounds(30, 50, 250, 100);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(0, 128, 192));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
				cancelButton.setBounds(310, 50, 250, 100);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
