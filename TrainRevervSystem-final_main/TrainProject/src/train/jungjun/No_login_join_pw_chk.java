package train.jungjun;

import train.Train_Main;

public class No_login_join_pw_chk {
	public boolean pw_chk() {
		String chk = Train_Main.pw6;
		boolean result = chk.matches("^[0-9]{4}$");
		if(result) {
			return true;
		}
		return false;
	}
}
