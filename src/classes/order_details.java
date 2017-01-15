package classes;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class order_details {
	String order_id;
	String phone_no;
	
	@NotEmpty(message = "Please provide an Address")
	String address;
	
	String pickup_date;
	
	@NotEmpty(message = "Please select a Service")
	String service_type;
	int uppers;
	int lowers;
	int towels;
	@NotEmpty(message = "Please select Pickup Time")
	String pickup_time;
	String description;
	String ordered_on;
	public String getOrdered_on() {
		return ordered_on;
	}
	public void setOrdered_on(String ordered_on) {
		this.ordered_on = ordered_on;
	}
	int bill;
	//Date pickup_date;
	public String getPickup_date() {
		return pickup_date;
	}
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public String getPickup_time() {
		return pickup_time;
	}
	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}
	public int getTowels() {
		return towels;
	}
	public void setTowels(int towels) {
		this.towels = towels;
	}
	public int getUppers() {
		return uppers;
	}
	public void setUppers(int uppers) {
		this.uppers = uppers;
	}
	public int getLowers() {
		return lowers;
	}
	public void setLowers(int lowers) {
		this.lowers = lowers;
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
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

}
