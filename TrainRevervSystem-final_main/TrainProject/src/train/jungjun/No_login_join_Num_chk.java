package train.jungjun;

import train.Train_Main;

public class No_login_join_Num_chk {
	public boolean num_chk() {
		String chk = Train_Main.pn5;
		boolean result = chk.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
		if(result) {
			return true;
		}
		return false;
	}
}
