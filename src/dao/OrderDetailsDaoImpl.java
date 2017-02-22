package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import classes.OrderDetails;

@Component
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	
	@Autowired
	DataSource dataSource;
	
	public void createTableOrders(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from user_tables where table_name = 'ORDERS'";
		if(jdbcTemplate.queryForObject(sql, Integer.class) == 0){
			sql = "create table orders(order_id varchar2(20) primary key,user_id varchar2(20) not null,"
				+ "service_type varchar2(20) not null,address varchar2(50) not null,"
				+ "pickup_date date not null,pickup_time varchar2(20) not null,ordered_on date not null,"
				+ "status varchar2(30) not null,bill number(5) default null,"
				+ "constraint fk1 foreign key(user_id) references users(user_id))";
			jdbcTemplate.execute(sql);
			sql = "create sequence order_id_seq start with 1 increment by 1 nocycle";
			jdbcTemplate.execute(sql);
			sql = "create view users_and_orders as select o.order_id,u.user_id,u.name,u.phone_no,o.service_type,"
			     +"o.address,o.pickup_date,o.pickup_time,o.ordered_on,o.status,o.bill "
				  + "from users u,orders o where u.user_id=o.user_id";
			jdbcTemplate.execute(sql);
		}
	}
	
	public void takeOrder(OrderDetails order,String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		item_prices price = new item_prices();
		String sql = "select order_id_seq.nextval from dual";
		int id = jdbcTemplate.queryForObject(sql, Integer.class);
		sql = "select no_of_orders from users where user_id = '" + user_id + "'";
		int n = jdbcTemplate.queryForObject(sql, Integer.class);
		if(n>0)
			n=-1;
		String order_id = "o" + id + (n+1);
		Date order_date = new Date();
		sql = "insert into orders(order_id,user_id,service_type,address,pickup_date,pickup_time,ordered_on,status) values(?,?,?,?,?,?,?,?)";
		order.setOrderId(order_id);
		jdbcTemplate.update(sql,order.getOrderId(),user_id,order.getServiceType(),order.getAddress(),order.getPickupDate(),order.getPickupTime(),order_date,"pending");
		sql = "update info set total_orders=total_orders+1";
		jdbcTemplate.update(sql);
		sql = "update info set pending_orders=pending_orders+1";
		jdbcTemplate.execute(sql);
	}
	
	public int checkFirstOrder(String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select no_of_orders from users where user_id = '" + user_id + "'";
		int n = jdbcTemplate.queryForObject(sql, Integer.class);
		sql="update users set no_of_orders = "+(n+1)+" where user_id = '"+user_id+"'";
		jdbcTemplate.execute(sql);
		if(n==0)
			return 1;
		else
			return 0;
	}
	
	public List<OrderDetails> showOrders(String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Select order_id,service_type,pickup_date,pickup_time,ordered_on,status,bill from orders where user_id = '"+user_id+"'";
		List<OrderDetails> orders = jdbcTemplate.query(sql,new RowMapper<OrderDetails>(){
			public OrderDetails mapRow(ResultSet rs,int rowNumber) throws SQLException{
				OrderDetails order = new OrderDetails();
				order.setBill(rs.getInt("bill"));
				order.setOrderId(rs.getString("order_id"));
				order.setServiceType(rs.getString("service_type"));
				String date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("pickup_date"));
				order.setPickupDate(date);
				order.setPickupTime(rs.getString("pickup_time"));
				date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("ordered_on"));
				order.setOrderedOn(date);
				order.setStatus(rs.getString("status"));
				return order;
			}
		});
		return orders;
	}
}
