package dao;
import java.util.List;

import classes.OrderDetails;

public interface OrderDetailsDao {
	public void takeOrder(OrderDetails order,String userId);
	public int checkFirstOrder(String userId);
	public void createTableOrders();
	public List<OrderDetails> showOrders(String userId);
}
