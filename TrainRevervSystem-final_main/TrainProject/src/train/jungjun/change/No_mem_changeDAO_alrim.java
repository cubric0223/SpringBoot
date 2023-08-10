package train.jungjun.change;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import train.ticket.Rev_detail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class No_mem_changeDAO_alrim extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No_mem_changeDAO_alrim dialog = new No_mem_changeDAO_alrim();
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
	public No_mem_changeDAO_alrim() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 250, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(No_mem_changeDAO.alrim);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 50));
		lblNewLabel.setBounds(35, 125, 800, 100);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("HY헤드라인M", Font.PLAIN, 60));
		btnNewButton.setBounds(300, 400, 250, 100);
		getContentPane().add(btnNewButton);
		
	}

}
