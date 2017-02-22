package classes;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLogin {
	
	@NotEmpty(message="Enter a Mobile Number")
	String phoneNo;
	
	@NotEmpty(message="Enter Password")
	String password;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
