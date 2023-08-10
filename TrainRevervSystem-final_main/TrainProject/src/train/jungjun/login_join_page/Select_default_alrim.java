package train.jungjun.login_join_page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.Train_Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select_default_alrim extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Select_default_alrim dialog = new Select_default_alrim();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Select_default_alrim() {
		setBounds(650, 250, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("기본이 선택되었습니다");
			lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
			lblNewLabel.setBounds(35, 125, 520, 100);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Train_Main.default_radio_btn.setIcon(Train_Main.img13);
				Train_Main.disabled_radio_btn.setIcon(Train_Main.img12);
				Train_Main.national_merit_radio_btn.setIcon(Train_Main.img12);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(175, 400, 250, 100);
		contentPanel.add(btnNewButton);
	}
}
