package dao;
import java.util.List;

import classes.order_details;

public interface order_detailsDao {
	public void take_order(order_details order,String user_id);
	public int check_first_order(String user_id);
	public void create_table_orders();
	public List<order_details> show_orders(String user_id);
}
