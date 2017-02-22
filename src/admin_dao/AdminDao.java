package admin_dao;

import java.util.List;

import admin.AdminLogin;
import admin.Info;
import admin.OrderInfo;
import admin.UserInfo;

public interface AdminDao {
	public int check(AdminLogin admin);
	public List<Info> showInfo();
	public List<UserInfo> showUsers();
	public List<OrderInfo> showOrders();
	public List<UserInfo> searchUser(String phoneNo);
	public List<OrderInfo> searchOrder(String orderId);
	public List<UserInfo> showUser(String phoneNo);
	public List<OrderInfo> showUserOrders(String phoneNo);
	public void changeStatus(String action,String orderId,int bill);
}
