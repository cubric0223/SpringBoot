package train.jungjun.login_join_page;

import train.Train_Main;

public class Number_chk {
	public boolean number_chk() {
		String chk = Train_Main.phone_number;
		boolean result = chk.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
		if(result) {
			return true;
		}
		return false;
	}
}