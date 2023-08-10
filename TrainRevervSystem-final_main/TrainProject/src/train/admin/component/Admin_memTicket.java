package train.admin.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import train.dao.MemberDAO;
import train.dao.TicketDAO;
import train.dto.MemberDTO;
import train.dto.TicketDTO;

/**
 * @author KSJ
 *
 */


// 회원 티켓 관리 패널
public class Admin_memTicket extends JPanel {
	
	MemberDAO memberDao = new MemberDAO();
	TicketDAO ticketDao = new TicketDAO();
	
	String phoneNum = null;
	
	String memCol [] = {"회원 번호", "아이디", "이름", "전화번호", "생년월일", "이메일", "우대 사항", "탈퇴"};
	String[] ticketCol = {"티켓번호", "열차이름", "열차번호", "출발일", "출발지", "도착지", "좌석번호", "가격", "출력", "반환"};
	
	private JLabel phoneNumLab, notionLab;
	private JTextField phoneNumTextField;
	private JTable memberTable, ticketTable;
	private JScrollPane membersp, ticketsp;
	private JButton searchBtn, refreshBtn;	
	
	DefaultTableModel memModel = new DefaultTableModel(memCol, 0);
	DefaultTableModel ticketModel = new DefaultTableModel(ticketCol, 0);

	/**
	 * Create the panel.
	 */
	public Admin_memTicket() {
		
		setBounds(100, 200, 1700, 750);
		setBackground(Color.white);
		setLayout(null);
		
		// 회원 테이블
		memberTable = new JTable(memModel);
		memberTable.setBounds(50, 142, 1600, 140);
		memberTable.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));	
		memberTable.getTableHeader().setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		memberTable.setRowHeight(50);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		memberTable.getColumn("회원 번호").setCellRenderer(celAlignCenter);
		memberTable.getColumn("이름").setCellRenderer(celAlignCenter);
		memberTable.getColumn("아이디").setCellRenderer(celAlignCenter);
		memberTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		memberTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		memberTable.getColumn("이메일").setCellRenderer(celAlignCenter);
		memberTable.getColumn("우대 사항").setCellRenderer(celAlignCenter);
		memberTable.getColumn("탈퇴").setCellRenderer(celAlignCenter);
		memberTable.getColumn("회원 번호").setPreferredWidth(100);
		memberTable.getColumn("아이디").setPreferredWidth(50);
		memberTable.getColumn("이름").setPreferredWidth(50);
		memberTable.getColumn("전화번호").setPreferredWidth(100);
		memberTable.getColumn("생년월일").setPreferredWidth(50);
		memberTable.getColumn("이메일").setPreferredWidth(100);
		memberTable.getColumn("우대 사항").setPreferredWidth(70);
		memberTable.getColumn("탈퇴").setPreferredWidth(30);
		
		memberTable.getColumn("탈퇴").setCellRenderer(new MemQuitBtn("탈퇴", memberTable));
		memberTable.getColumn("탈퇴").setCellEditor(new MemQuitBtn("탈퇴", memberTable));
		
		membersp = new JScrollPane(memberTable);
		membersp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		membersp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		membersp.setBounds(50, 150, 1600, 77);
		add(membersp);
		
		// 티켓 테이블
		ticketTable = new JTable(ticketModel);
		ticketTable.setFont(new Font("HY헤드라인M", Font.PLAIN, 15));	
		ticketTable.getTableHeader().setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		ticketTable.setRowHeight(40);
		ticketTable.getColumn("티켓번호").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("열차이름").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("열차번호").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("출발일").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("출발지").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("도착지").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("좌석번호").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("가격").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("출력").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("반환").setCellRenderer(celAlignCenter);
		ticketTable.getColumn("티켓번호").setPreferredWidth(150);
		ticketTable.getColumn("열차이름").setPreferredWidth(70);
		ticketTable.getColumn("열차번호").setPreferredWidth(70);
		ticketTable.getColumn("출발지").setPreferredWidth(70);
		ticketTable.getColumn("도착지").setPreferredWidth(70);
		ticketTable.getColumn("좌석번호").setPreferredWidth(70);
		ticketTable.getColumn("출력").setPreferredWidth(30);
		ticketTable.getColumn("반환").setPreferredWidth(30);
		
		ticketTable.getColumn("출력").setCellRenderer(new MemSearchBtn("출력", ticketTable));
		ticketTable.getColumn("출력").setCellEditor(new MemSearchBtn("출력", ticketTable));
		
		ticketTable.getColumn("반환").setCellRenderer(new MemRefundBtn("반환", ticketTable));
		ticketTable.getColumn("반환").setCellEditor(new MemRefundBtn("반환", ticketTable));
		
		ticketsp = new JScrollPane(ticketTable);
		ticketsp.setBounds(50, 248, 1600, 471);
		add(ticketsp);
		
		phoneNumLab = new JLabel("회원 전화번호");
		phoneNumLab.setFont(new Font("HY헤드라인M", Font.PLAIN, 35));
		phoneNumLab.setBounds(50, 32, 222, 60);
		add(phoneNumLab);
		
		notionLab = new JLabel("전화번호는 010-0000-0000 형식으로 입력해주세요");
		notionLab.setForeground(Color.red);
		notionLab.setFont(new Font("굴림", Font.PLAIN, 15));
		notionLab.setBounds(302, 95, 353, 30);
		add(notionLab);
		
		// 핸드폰 값 입력 시, 유효성 검사 -> 안맞으면 라벨로 안내
		phoneNumTextField = new JTextField();
		phoneNumTextField.setFont(new Font("굴림", Font.PLAIN, 20));
		phoneNumTextField.setBounds(302, 32, 353, 60);
		add(phoneNumTextField);
		phoneNumTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String Num = phoneNumTextField.getText();
				
				if (Num == null) {
					return;
				}
				
				if (chkPhoneNum(Num)) {
					notionLab.setText("올바른 전화번호입니다.");
					notionLab.setForeground(Color.GREEN);
					phoneNum = Num;
				} else {
					notionLab.setText("전화번호는 010-0000-0000 형식으로 입력해주세요");
					notionLab.setForeground(Color.red);
				}				
			}			
		});
		
		searchBtn = new JButton("조회");
		searchBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 25));
		searchBtn.setBounds(676, 32, 115, 60);
		searchBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 조회 버튼 누르면 테이블에 회원, 티켓 데이터 표시
				if (phoneNum != null) { // 핸드폰 번호가 없으면 다이얼로그 오픈
					if (memberDao.getMember(phoneNum) == null) {
						memModel.setRowCount(0);
					} else {
						setMemValue(memberDao.getMember(phoneNum), memModel);
					}
					setTicketValue(ticketDao.searchMemTicket(phoneNum), ticketModel);
				} else {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요");
				}				
			}
		});
		add(searchBtn);
		
		refreshBtn = new JButton("새로고침");
		refreshBtn.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		refreshBtn.setBounds(803, 32, 115, 60);
		refreshBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();			
			}
		});
		add(refreshBtn);

	}
	
	/** DB에서 티켓 정보를 가져오는 메서드 */
	private void setTicketValue(List<TicketDTO> tickets, DefaultTableModel model) {
		// "티켓번호", "열차이름", "열차번호", "출발지", "도착지", "좌석번호", "가격", "반환"
		if (tickets != null) {
			model.setRowCount(0);
			for (TicketDTO ticket : tickets) {
				Vector<Object> list = new Vector<>();
				list.add(ticket.getTicketNum());
				list.add(ticket.getTrainName());
				list.add(ticket.getTrainNum());
				list.add(ticket.getDate());
				list.add(ticket.getStartingSunway());
				list.add(ticket.getEndingSunway());
				list.add(ticket.getSeatName());
				list.add(ticket.getPrice());
				model.addRow(list);			
			}		
		}
	}
	
	/** DB에서 멤버 정보를 가져오는 메서드 */
	private void setMemValue(MemberDTO member, DefaultTableModel model) {
		// "회원 번호", "아이디", "이름", "전화번호", "생년월일", "이메일", "우대 사항", "탈퇴"
		if (member != null) {
			Vector<Object> list = new Vector<>();
			list.add(member.getUserNum());
			list.add(member.getId());
			list.add(member.getName());
			list.add(member.getPhone());
			list.add(member.getBirth());
			list.add(member.getEmail());
			list.add(member.getPreferential());			
			model.addRow(list);	
		}
	}
	
	/** 핸드폰 번호 유효성을 검사하는 메서드 */
	private boolean chkPhoneNum(String phoneNum) {
		String regex = "^01(?:0|1|[6-9])-\\d{3,4}-\\d{4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNum);
		if(m.matches()) {
			return true; 
		}
		return false;
	}
	
	/** 패널의 모든 값을 초기화 하는 메서드 */
	public void reset() {
		notionLab.setText("전화번호는 010-0000-0000 형식으로 입력해주세요");
		notionLab.setForeground(Color.red);
		phoneNumTextField.setText(null);
		memModel.setRowCount(0);
		ticketModel.setRowCount(0);
	}
}
