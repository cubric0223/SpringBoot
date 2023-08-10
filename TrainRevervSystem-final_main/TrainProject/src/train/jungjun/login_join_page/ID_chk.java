package train.jungjun.login_join_page;

import train.Train_Main;

public class ID_chk {
	public boolean id_chk() {
		String chk = Train_Main.id5;
		boolean result = chk.matches("^[a-zA-Z]+[a-zA-Z0-9]{3,19}$");
		if(result) {
			return true;
		}else{
			return false;
		}		
	}
}