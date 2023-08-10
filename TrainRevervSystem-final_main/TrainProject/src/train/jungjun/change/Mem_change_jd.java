package train.jungjun.change;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Mem_change_jd extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mem_change_jd dialog = new Mem_change_jd();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Mem_change_jd() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(800, 300, 600, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Mem_change.alrim);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 40));
		lblNewLabel.setBounds(25, 25, 550, 100);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(175, 150, 250, 100);
		getContentPane().add(btnNewButton);

	}

}
