package admin;

public class Info {
	long totalOrders;
	long earnings;
	long succOrders;
	long pendingOrders;
	long cancelledOrders;
	long users;
	
	
	public long getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(long totalOrders) {
		this.totalOrders = totalOrders;
	}
	public long getSuccOrders() {
		return succOrders;
	}
	public void setSuccOrders(long succOrders) {
		this.succOrders = succOrders;
	}
	public long getPendingOrders() {
		return pendingOrders;
	}
	public void setPendingOrders(long pendingOrders) {
		this.pendingOrders = pendingOrders;
	}
	public long getCancelledOrders() {
		return cancelledOrders;
	}
	public void setCancelledOrders(long cancelledOrders) {
		this.cancelledOrders = cancelledOrders;
	}
	public long getUsers() {
		return users;
	}
	public void setUsers(long users) {
		this.users = users;
	}
	public long getEarnings() {
		return earnings;
	}
	public void setEarnings(long earnings) {
		this.earnings = earnings;
	}
	
	
}
