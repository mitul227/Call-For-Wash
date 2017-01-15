package classes;

import org.hibernate.validator.constraints.NotEmpty;

public class user_login {
	
	@NotEmpty(message="Enter a Mobile Number")
	String phone_no;
	
	@NotEmpty(message="Enter Password")
	String password;
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
