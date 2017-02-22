package classes;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderDetails {
	int bill;
	String orderId;
	String phoneNo;
	
	@NotEmpty(message = "Please provide an Address")
	String address;
	
	String pickupDate;
	
	@NotEmpty(message = "Please select a Service")
	String serviceType;
	@NotEmpty(message = "Please select Pickup Time")
	String pickupTime;
	String orderedOn;
	String status;
	
	
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public String getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(String orderedOn) {
		this.orderedOn = orderedOn;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
