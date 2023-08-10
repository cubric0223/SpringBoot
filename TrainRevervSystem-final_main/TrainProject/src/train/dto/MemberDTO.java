package train.dto;

public class MemberDTO {
	
	String userNum;
	String id;
	String name;
	String phone;
	String birth;
	String email;
	String preferential;
	
	public MemberDTO(String userNum, String id, String name, String phone, String birth, String email, String preferential) {
		this.userNum = userNum;
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.preferential = preferential;
	}

	public String getUserNum() {
		return userNum;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getPreferential() {
		return preferential;
	}

}
