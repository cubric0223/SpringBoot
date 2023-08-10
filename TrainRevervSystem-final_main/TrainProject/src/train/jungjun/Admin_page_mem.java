package train.jungjun;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_page_mem extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	
	String str [][] = new String[0][7];
	static DefaultTableModel model;
	String str2 [] = {"회원 번호", "아이디", "이름", "전화번호", "생년월일", "이메일", "우대 사항", "탈퇴"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page_mem frame = new Admin_page_mem();
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
	public Admin_page_mem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		model = new DefaultTableModel(str,str2);
								
		table = new JTable(model);
		table.setRowHeight(50);
		table.setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
		table.setBounds(300,300,1600,700);
		contentPane.add(table);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		table.getColumn("탈퇴").setCellRenderer(new AdminBtn("삭제", table));
		table.getColumn("탈퇴").setCellEditor(new AdminBtn("삭제",table));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(300, 300, 1600, 700);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemDAO DAO = new MemDAO();
				DAO.memDAO();
			}
		});
		btnNewButton.setBounds(164, 332, 97, 23);
		contentPane.add(btnNewButton);
	}
}
