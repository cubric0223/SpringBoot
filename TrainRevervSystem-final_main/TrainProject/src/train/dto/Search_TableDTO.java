package train.dto;

public class Search_TableDTO {
	String train_name;
	String train_num;
	String train_StName;
	String train_StTime;
	String train_EnName;
	String train_EnTime;
	String train_Price;
	String train_TimeTaken;
	public Search_TableDTO(String train_name,String train_num,String train_StName, String train_StTime,String train_EnName, String train_EnTime,String train_Price,String train_TimeTaken) {
		this.train_name =  train_name;
		this.train_num = train_num;
		this.train_StName = train_StName;
		this.train_StTime = train_StTime;
		this.train_EnName = train_EnName;
		this.train_EnTime = train_EnTime;
		this.train_Price = train_Price;
		this.train_TimeTaken = train_TimeTaken;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getTrain_num() {
		return train_num;
	}
	public void setTrain_num(String train_num) {
		this.train_num = train_num;
	}
	public String getTrain_StName() {
		return train_StName;
	}
	public void setTrain_StName(String train_StName) {
		this.train_StName = train_StName;
	}
	public String getTrain_StTime() {
		return train_StTime;
	}
	public void setTrain_StTime(String train_StTime) {
		this.train_StTime = train_StTime;
	}
	public String getTrain_EnName() {
		return train_EnName;
	}
	public void setTrain_EnName(String train_EnName) {
		this.train_EnName = train_EnName;
	}
	public String getTrain_EnTime() {
		return train_EnTime;
	}
	public void setTrain_EnTime(String train_EnTime) {
		this.train_EnTime = train_EnTime;
	}
	public String getTrain_Price() {
		return train_Price;
	}
	public void setTrain_Price(String train_Price) {
		this.train_Price = train_Price;
	}
	public String getTrain_TimeTaken() {
		return train_TimeTaken;
	}
	public void setTrain_TimeTaken(String train_TimeTaken) {
		this.train_TimeTaken = train_TimeTaken;
	}
	
	
	
}