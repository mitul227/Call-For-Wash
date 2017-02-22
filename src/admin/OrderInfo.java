package admin;

public class OrderInfo {
	private int bill;
	private String orderId;
	private String name;
	private String phoneNo;
	private String userId;
	private String serviceType;
	private String address;
	private String pickUpDate;
	private String pickUpTime;
	private String orderedOn;
	private String status;
	
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public String getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public String getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(String orderedOn) {
		this.orderedOn = orderedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
