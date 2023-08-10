package train.jungjun.login_join_page;

public class CheckDiscountRegex {
	public boolean regex1() {
		String chkDiscount = CheckDiscount.CardNum;
		boolean result1 = chkDiscount.matches("^(33){1}-(01|02){1}-[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1])$");
		if(result1) {
			return true;
		}
		return false;
	}
	public boolean regex2() {
		String chkDiscount = CheckDiscount.CardNum;
		boolean result2 = chkDiscount.matches("^(66){1}-(01|02){1}-[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1])$");
		if(result2) {
			return true;
		}
		return false;
	}
}
