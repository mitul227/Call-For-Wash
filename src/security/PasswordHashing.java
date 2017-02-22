package security;

import java.security.MessageDigest;

public class PasswordHashing {
	public static String hash(String password) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<byteData.length;i++){
			sb.append(Integer.toString((byteData[i] & 0xff)+ 0x100,16).substring(1));
		}
		return sb.toString();
		//System.out.println(sb.toString());
	}
}
