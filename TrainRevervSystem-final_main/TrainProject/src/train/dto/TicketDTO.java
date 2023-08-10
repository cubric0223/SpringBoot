package train.dto;

public class TicketDTO {
	
	// "티켓번호", "열차이름", "열차번호", "출발지", "도착지", "좌석번호", "가격", "반환"
	
	// 차내식 보류
	String ticketNum;
	String trainName;
	int trainNum;
	int date;
	String startingSunway;
	String endingSunway;
	String seatName;
	int price;
	
	public TicketDTO(String ticketNum, String trainName, int trainNum, int date,
				String startingSunway, String endingSunway, String seatName, int price) {
		this.ticketNum = ticketNum;
		this.trainName = trainName;
		this.trainNum = trainNum;
		this.date = date;
		this.startingSunway = startingSunway;
		this.endingSunway = endingSunway;
		this.seatName = seatName;
		this.price = price;
	}

	public String getTicketNum() {
		return ticketNum;
	}

	public String getTrainName() {
		return trainName;
	}

	public int getTrainNum() {
		return trainNum;
	}

	public String getStartingSunway() {
		return startingSunway;
	}

	public String getEndingSunway() {
		return endingSunway;
	}

	public String getSeatName() {
		return seatName;
	}

	public int getPrice() {
		return price;
	}
	
	public int getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return String.format("%s / %s / %d / %s / %s / %s / %d", ticketNum, trainName, trainNum, startingSunway, endingSunway, seatName, price);
	}

}
