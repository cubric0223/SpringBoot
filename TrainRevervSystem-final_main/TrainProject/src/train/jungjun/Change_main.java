package train.jungjun;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import train.Train_Main;
import train.jungjun.change.Mem_change;
import train.jungjun.change.No_mem_change;
import java.awt.Color;

public class Change_main extends JFrame {

	private JPanel contentPane;
	
	static Change_main frame = new Change_main();
	
	public void runApplication() {
        // 애플리케이션 실행에 필요한 로직 작성
    	if(GoMain.close) {
			frame.dispose();
		}
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Change_main frame = new Change_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Change_main() {
		
		ImageIcon img1 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/goMemCheck.png");
		ImageIcon img2 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/goNoMemCheck.png");
		ImageIcon img3 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/E-RAIL.png");
		ImageIcon img4 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/home.png");
		ImageIcon img5 = new ImageIcon
				("C:/javafullstack/git-repositories/TrainRevervSystem/TrainProject/resource/back.png");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton mem_check_btn = new JButton(img1);
		mem_check_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.change.Mem_change mem = new Mem_change();
				mem.main(null);
				dispose();
			}
		});
		mem_check_btn.setBorderPainted(false);
		mem_check_btn.setContentAreaFilled(false);
		mem_check_btn.setFocusPainted(false);
		mem_check_btn.setBounds(400, 500, 510, 337);
		contentPane.add(mem_check_btn);
		
		JButton no_mem_check_btn = new JButton(img2);
		no_mem_check_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train.jungjun.change.No_mem_change Nomem = new No_mem_change();
				Nomem.main(null);
				dispose();;
			}
		});
		no_mem_check_btn.setBorderPainted(false);
		no_mem_check_btn.setContentAreaFilled(false);
		no_mem_check_btn.setFocusPainted(false);
		no_mem_check_btn.setBounds(1000, 500, 510, 337);
		contentPane.add(no_mem_check_btn);
		
		JLabel logo = new JLabel(img3);
		logo.setBounds(675, 15, 573, 473);
		contentPane.add(logo);
		
		JButton home_btn = new JButton(img4);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoMain Gomain = new GoMain();
				Gomain.setVisible(true);
			}
		});
		home_btn.setBorderPainted(false);
		home_btn.setContentAreaFilled(false);
		home_btn.setFocusPainted(false);
		home_btn.setBounds(1783, 10, 109, 109);
		contentPane.add(home_btn);
		
		JButton back_btn = new JButton(img5);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Train_Main main = new Train_Main();
				main.main(null);
				dispose();
			}
		});
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		contentPane.add(back_btn);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
