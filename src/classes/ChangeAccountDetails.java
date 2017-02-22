package classes;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangeAccountDetails {
	@NotEmpty(message="Enter your name")
	String name;
	
	@Pattern(regexp="[0-9]{10}",message="Enter a Valid Mobile Number")
	String phoneNo;
	
	@NotEmpty(message="Enter your address")
	String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
