package classes;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserSignup {
	
	@NotEmpty(message="Enter your name")
	private String name;

	 //@NotEmpty(message="Password field cannot be empty")
	@Size(min=6,max=20,message="Password should be between 6-20 characters")
	private String password;
	
	@Pattern(regexp="[0-9]{10}",message="Enter a Valid Mobile Number")
	private String phoneNo;
	
	@NotEmpty(message="Enter your address")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
