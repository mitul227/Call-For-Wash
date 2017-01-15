package classes;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class user_signup {
	
	@NotEmpty(message="Enter your name")
	private String name;

	 //@NotEmpty(message="Password field cannot be empty")
	@Size(min=6,max=20,message="Password should be between 6-20 characters")
	private String password;
	
	@Pattern(regexp="[0-9]{10}",message="Enter a Valid Mobile Number")
	private String phone_no;
	
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}
