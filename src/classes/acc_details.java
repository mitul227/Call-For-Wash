package classes;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class acc_details {
	@NotEmpty(message="Enter your name")
	String name;
	
	@Pattern(regexp="[0-9]{10}",message="Enter a Valid Mobile Number")
	String phone_no;
	
	@NotEmpty(message="Enter your address")
	String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
