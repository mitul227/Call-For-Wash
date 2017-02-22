package admin_dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import admin.AdminLogin;
import admin.Info;
import admin.OrderInfo;
import admin.UserInfo;

@Component
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public int check(AdminLogin admin) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from admins where username = '"+admin.getUsername()+"' and password = '"
					+ admin.getPassword() + "'";
		int count = jdbcTemplate.queryForObject(sql,Integer.class);
		if(count==1){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public List<Info> showInfo(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from info";
		List<Info> information = jdbcTemplate.query(sql, new RowMapper<Info>(){
			public Info mapRow(ResultSet rs,int rowNumber) throws SQLException{
				Info info = new Info();
				info.setUsers(rs.getLong("users"));
				info.setTotalOrders(rs.getLong("total_orders"));
				info.setCancelledOrders(rs.getLong("cancelled_orders"));
				info.setEarnings(rs.getLong("total_earnings"));
				info.setPendingOrders(rs.getLong("pending_orders"));
				info.setSuccOrders(rs.getLong("succ_orders"));
				return info;
			}
		});
		return information;
	}
	
	public List<UserInfo> showUsers(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select name,phone_no,address from users";
		List<UserInfo> users = jdbcTemplate.query(sql,new RowMapper<UserInfo>(){
			public UserInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				UserInfo user = new UserInfo();
				user.setName(rs.getString("name"));
				user.setPhoneNo(rs.getString("phone_no"));
				user.setAddress(rs.getString("address"));
				return user;
			}
		});
		return users;
	}
	
	public List<OrderInfo> showOrders(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from users_and_orders";
		List<OrderInfo> orders = jdbcTemplate.query(sql,new RowMapper<OrderInfo>(){
			public OrderInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				OrderInfo order = new OrderInfo();
				order.setName(rs.getString("name"));
				order.setPhoneNo(rs.getString("phone_no"));
				order.setOrderId(rs.getString("order_id"));
				order.setServiceType(rs.getString("service_type"));
				order.setPickUpTime(rs.getString("pickup_time"));
				//order.setOrderedOn(rs.getString("));
				order.setAddress(rs.getString("address"));
				order.setStatus(rs.getString("status"));
				return order;
			}
		});
		return orders;
	}
	
	public List<UserInfo> searchUser(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select name,phone_no,address from users where phone_no = '"+phoneNo+"'";
		List<UserInfo> userSearch = jdbcTemplate.query(sql, new RowMapper<UserInfo>(){
			public UserInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				UserInfo user = new UserInfo();
				user.setName(rs.getString("name"));
				user.setPhoneNo(rs.getString("phone_no"));
				user.setAddress(rs.getString("address"));
				return user;
			}
		});
		return userSearch;
	}
	
	public List<OrderInfo> searchOrder(String orderId){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from users_and_orders where order_id = '"+orderId+"'";
		List<OrderInfo> orderSearch = jdbcTemplate.query(sql, new RowMapper<OrderInfo>(){
			public OrderInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				OrderInfo order = new OrderInfo();
				order.setBill(rs.getInt("bill"));
				order.setName(rs.getString("name"));
				order.setPhoneNo(rs.getString("phone_no"));
				order.setOrderId(rs.getString("order_id"));
				order.setAddress(rs.getString("address"));
				order.setServiceType(rs.getString("service_type"));
				order.setPickUpTime(rs.getString("pickup_time"));
				order.setStatus(rs.getString("status"));
				String date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("pickup_date"));
				order.setPickUpDate(date);
				date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("ordered_on"));
				order.setOrderedOn(date);
				return order;
			}
		});
		return orderSearch;
	}
	
	public List<UserInfo> showUser(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from users where phone_no='"+phoneNo+"'";
		//UserInfo user = jdbcTemplate.queryForObject(sql,);
		List<UserInfo> user = jdbcTemplate.query(sql,new RowMapper<UserInfo>(){
			public UserInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				UserInfo user = new UserInfo();
				user.setPhoneNo(rs.getString("phone_no"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setNoOfOrders(rs.getInt("no_of_orders"));
				return user;
			}
		});
		return user;
	}
	
	public List<OrderInfo> showUserOrders(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from users_and_orders where phone_no = '"+phoneNo+"'";
		List<OrderInfo> orderSearch = jdbcTemplate.query(sql, new RowMapper<OrderInfo>(){
			public OrderInfo mapRow(ResultSet rs,int rowNumber) throws SQLException{
				OrderInfo order = new OrderInfo();
				//order.setName(rs.getString("name"));
				order.setPhoneNo(rs.getString("phone_no"));
				order.setOrderId(rs.getString("order_id"));
				order.setAddress(rs.getString("address"));
				order.setServiceType(rs.getString("service_type"));
				order.setPickUpTime(rs.getString("pickup_time"));
				order.setStatus(rs.getString("status"));
				String date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("pickup_date"));
				order.setPickUpDate(date);
				date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("ordered_on"));
				order.setOrderedOn(date);
				return order;
			}
		});
		return orderSearch;
	}
	
	public void changeStatus(String action,String orderId,int bill){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql;
		if(action.equals("complete")){
			sql = "Update orders set status='completed',bill="+bill+" where order_id='"+orderId+"'";
			jdbcTemplate.execute(sql);
			sql = "update info set total_earnings=total_earnings+"+bill+"";
			jdbcTemplate.execute(sql);
			sql = "update info set succ_orders=succ_orders+1";
			jdbcTemplate.execute(sql);
			sql = "update info set pending_orders=pending_orders-1";
			jdbcTemplate.execute(sql);
		}
		else{
			sql = "Update orders set status='cancelled' where order_id='"+orderId+"'";
			jdbcTemplate.execute(sql);
			sql = "update info set pending_orders=pending_orders-1";
			jdbcTemplate.execute(sql);
			sql = "update info set cancelled_orders=cancelled_orders+1";
			jdbcTemplate.execute(sql);
		}
	}

}
