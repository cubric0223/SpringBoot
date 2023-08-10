package train.jungjun.login_join_page;

import train.Train_Main;

public class Email_chk {
	public boolean email_chk() {
		String chk_email = Train_Main.email;
		boolean result = chk_email.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?");
		if(result) {
			return true;
		}
		return false;
	}
}