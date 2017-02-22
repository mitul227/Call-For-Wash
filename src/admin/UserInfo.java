package admin;

public class UserInfo {
	private String name;
	private String phoneNo;
	private String Address;
	private int noOfOrders;
	
	
	public int getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
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
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
