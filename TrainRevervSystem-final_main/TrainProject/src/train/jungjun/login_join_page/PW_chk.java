package train.jungjun.login_join_page;

import java.util.Arrays;
// 사용
public class PW_chk {
	final private static String SPECIAL_CHARS = "!@#$%^&*()_+\\|,.<>?/'\";`~";
	final private static String VALID_PASSWORD_CHARS = 
			"abcdefghijklmnopqrstuvwxyABCDEFGHIJKMNOPQRSTUVWXYZ" +
			"0123456789" + SPECIAL_CHARS;
	private static char[] password_1 = new char[100];
	private char ch;
	boolean hasNumber = false;
	boolean hasLower = false;
	boolean hasUpper = false;
	boolean hasSpecal = false;
	//private String pw;
//	public static void main(String[] args) {
//		System.out.println(Arrays.toString(password_1));
//	}
	
	public boolean pw_chk(String pw) {
		for(int i = 0; i < pw.length(); ++i) {
			password_1[i] = pw.charAt(i);
			ch = password_1[i];
			
			if(ch >= '0' && ch <= '9') {
				hasNumber = true;
			}else if(ch >= 'a' && ch <= 'z') {
				hasLower = true;
			}else if(ch >= 'A' && ch <= 'Z') {
				hasUpper = true;
			}else if(SPECIAL_CHARS.indexOf(ch) != -1) {
				hasSpecal = true;
			}
			if(pw.length() >= 6 && hasNumber && hasLower && hasUpper && hasSpecal){
				return true;
			}
		}
		return false;
		
	}
}