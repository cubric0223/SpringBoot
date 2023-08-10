package train;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import train.jungjun.No_login_join;

public class Second_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second_main frame = new Second_main();
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
	public Second_main() {
//		ImageIcon img1 = new ImageIcon
//				("resource\\E-RAIL.png");
//		ImageIcon img2 = new ImageIcon
//				("resource\\home.png");
//		ImageIcon img3 = new ImageIcon
//				("resource\\goLogin.png");
//		ImageIcon img4 = new ImageIcon
//				("resource\\goNoLogin.png");
//		ImageIcon img5 = new ImageIcon
//				("resource\\back_homebtn.png");
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JLabel logo = new JLabel();
		logo.setBounds(682, 105, 586, 471);
		getContentPane().add(logo);
		
		JButton goMain_btn = new JButton();
		goMain_btn.setBorderPainted(false);
		goMain_btn.setContentAreaFilled(false);
		goMain_btn.setFocusPainted(false);
		goMain_btn.setBounds(1783, 10, 109, 109);
		getContentPane().add(goMain_btn);
		
		goMain_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Train_Main main1 = new Train_Main();
				main1.main(null);
				setVisible(false);
			}
		});
		
		JButton membership_btn = new JButton();
		membership_btn.setBorderPainted(false);
		membership_btn.setContentAreaFilled(false);
		membership_btn.setFocusPainted(false);
		membership_btn.setBounds(485, 613, 420, 270);
		getContentPane().add(membership_btn);
		
		membership_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				train.jungjun.login_join_page.Login_and_join login = new train.jungjun.login_join_page.Login_and_join();
				login.main(null);
				setVisible(false);
			}
		});
		
		JButton no_membership_btn = new JButton();
		no_membership_btn.setBorderPainted(false);
		no_membership_btn.setContentAreaFilled(false);
		no_membership_btn.setFocusPainted(false);
		no_membership_btn.setBounds(1011, 613, 420, 270);
		getContentPane().add(no_membership_btn);
		no_membership_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				No_login_join join = new No_login_join();
				join.main(null);
				dispose();
				
			}
		});
		
		JButton back_btn = new JButton();
		back_btn.setBorderPainted(false);
		back_btn.setContentAreaFilled(false);
		back_btn.setFocusPainted(false);
		back_btn.setBounds(10, 10, 136, 136);
		getContentPane().add(back_btn);
		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Train_Main main1 = new Train_Main();
				main1.main(null);
				setVisible(false);
			}
		});
		
		try {		
			membership_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/회원예매.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
		
			no_membership_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/비회원예매.png")).getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING)));
			
			back_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/back_homebtn.png")).getScaledInstance(136, 136, Image.SCALE_AREA_AVERAGING)));
			
			goMain_btn.setIcon(new ImageIcon(ImageIO.read(new File("resource/home.png")).getScaledInstance(109, 109, Image.SCALE_AREA_AVERAGING)));
			
			logo.setIcon(new ImageIcon(ImageIO.read(new File("resource/logo.jpg")).getScaledInstance(586, 471, Image.SCALE_AREA_AVERAGING)));

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}