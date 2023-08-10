package train.search;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableCellEditor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import train.search.component.ReservBtn;
import train.food.table_button.TableActionEvent;
//import train.table_button.TableCellEditor;
import train.food.table_button.TableCellReader;
import train.food.table_button.Table_button;

import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import train.subway.*;
import train.TrainReserv_Main;
import train.search.*;
/**
 * @author LJH
 */
public class Search_Train_Panel extends JPanel {
	/*
	 	예매 패널에 넣는 기차API 패널
	 */
	public static JTable table;
	public static DefaultTableModel model;
	private JSONArray array;
	public String header[]= {"구분","열차번호","출발시간","도착시간","소요시간","특실가격","특실","일반가격","일반"};
	private SubwayCode subc;
	private SubwayCategory sub_cg;
	/**
	 * Create the panel.
	 */
	public static JScrollPane scrollPane;
	public Search_Train_Panel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1480, 930);
		add(panel);
		
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1470, 920);
		panel.add(scrollPane);
		model = new DefaultTableModel(header,0);
		// 기차 정보 테이블
		table = new JTable(model);
		table.setFont(new Font("HY헤드라인M", Font.PLAIN, 30));
		table.setRowHeight(100);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		table.getColumnModel().getColumn(6).setCellRenderer(new ReservBtn("특실예매", table)); 
		table.getColumnModel().getColumn(6).setCellEditor(new ReservBtn("특실예매",table));
		table.getColumnModel().getColumn(8).setCellRenderer(new ReservBtn("일반예매",table));
		table.getColumnModel().getColumn(8).setCellEditor(new ReservBtn("일반예매",table));
		table.setAutoCreateRowSorter(true);
		
		subc = new SubwayCode();
		sub_cg = new SubwayCategory();
		String st = subc.sub_map.get(TrainReserv_Main.st_sub_btn.getText());
		String en = subc.sub_map.get(TrainReserv_Main.en_sub_btn.getText());
		String da = TrainReserv_Main.date_text.getText();
		String tanm = TrainReserv_Main.selectsubBtn.getText();
		System.out.println(tanm);
		if(tanm.equals("전체")) {
			for(String key : sub_cg.sub_category.keySet()) {
				System.out.println(key);
				try {
					String train_nm = sub_cg.sub_category.get(key);
					System.out.println(train_nm);
					train_api_table(st, en, da, train_nm);
				}catch(Exception e) {
					System.out.println("열차 없음.");
				}
			}
		}else {
			String train_nm = sub_cg.sub_category.get(tanm);
			System.out.println(train_nm);
			train_api_table(st, en, da, train_nm);
		}
		
		scrollPane.setViewportView(table);
	}
	
	
	public void train_api_table(String st, String en, String da, String tanm) {
		Train_API tapi = new Train_API(st, en, da, tanm);
		try {
			array = tapi.train_api();
		    int count_table = 0;
			for(int i =0; i< array.size(); ++i) {
				JSONObject object = (JSONObject) array.get(i);
				// 가져온 날짜값 데이터 format
				LocalDateTime st_date = LocalDateTime.parse(String.valueOf(object.get("depplandtime")), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				LocalDateTime en_date = LocalDateTime.parse(String.valueOf(object.get("arrplandtime")), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
				
				String st_time = st_date.getHour()+":"+st_date.getMinute();
				String en_time = en_date.getHour()+":"+en_date.getMinute();
				Duration diff = Duration.between(st_date.toLocalTime(), en_date.toLocalTime());
				long el_hour;
				long el_min;
				// 가져온 열차 시간 계산
				if (diff.toHours() < 0 && diff.toMinutes() < 0) {
					el_hour = diff.toHours() + 24;
					el_min = Math.abs(diff.toMinutes()%60);
				}else {
					el_hour = diff.toHours();
					el_min = Math.abs(diff.toMinutes()%60-60);
				}
				String eltime = el_hour + "시간" + el_min+ "분";
				// 특실 예매시 20% 가격 추가
				int quality_up = (int) (Integer.parseInt(String.valueOf(object.get("adultcharge")))*1.2) ;
				// 현재시간과 비교해서 이전 시간열차는 출력 x
				LocalDateTime datetime = LocalDateTime.now();
				if(!datetime.isAfter(st_date)) {
				    model.insertRow(count_table, new Object[]{object.get("traingradename"),object.get("trainno"),
				    		st_time,en_time,
				    		eltime,""+quality_up,"",
				    		object.get("adultcharge"),""
				    });
				    count_table ++;
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
