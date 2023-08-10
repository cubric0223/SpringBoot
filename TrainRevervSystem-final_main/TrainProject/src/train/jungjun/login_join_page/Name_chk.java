package train.jungjun.login_join_page;

import train.Train_Main;

public class Name_chk {
	public boolean name_chk() {
		String chk = Train_Main.name3;
		boolean result = chk.matches("^[가-힣]{2,}$");
		if(result) {
			return true;
		}else {
			return false;
		}
	}
}