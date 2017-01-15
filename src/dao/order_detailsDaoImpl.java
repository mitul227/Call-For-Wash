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

import classes.order_details;

@Component
public class order_detailsDaoImpl implements order_detailsDao{
	
	@Autowired
	DataSource dataSource;
	
	public void create_table_orders(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from user_tables where table_name = 'ORDERS'";
		if(jdbcTemplate.queryForObject(sql, Integer.class) == 0){
			sql = "create table orders(order_id varchar2(20) primary key,user_id varchar2(20) not null,"
				+ "service_type varchar2(20) not null,address varchar2(50) not null,"
				+ "pickup_date date not null,pickup_time varchar2(20) not null,ordered_on date not null,"
				+ "constraint fk1 foreign key(user_id) references users(user_id))";
			jdbcTemplate.execute(sql);
			sql = "create sequence order_id_seq start with 1 increment by 1 nocycle";
			jdbcTemplate.execute(sql);
		}
	}
	
	public void take_order(order_details order,String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		item_prices price = new item_prices();
		String sql = "select order_id_seq.nextval from dual";
		int id = jdbcTemplate.queryForObject(sql, Integer.class);
		String order_id = "o" + id;
		Date order_date = new Date();
//		if(check_first_order(user_id)==1){
//			sql="update users set coupon_used = 'y' where user_id = ?";
//			jdbcTemplate.update(sql,user_id);
//		}
		sql = "insert into orders values(?,?,?,?,?,?,?)";
		order.setOrder_id(order_id);
		jdbcTemplate.update(sql,order.getOrder_id(),user_id,order.getService_type(),order.getAddress(),order.getPickup_date(),order.getPickup_time(),order_date);
	}
	
	public int check_first_order(String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select coupon_used from users where user_id = '" + user_id + "'";
		String y_n = jdbcTemplate.queryForObject(sql, String.class);
		if(y_n.equals("n")){
			sql="update users set coupon_used = 'y' where user_id = ?";
			jdbcTemplate.update(sql,user_id);
			return 1;
		}
		else
			return 0;
	}
	
	public List<order_details> show_orders(String user_id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "Select order_id,service_type,pickup_date,pickup_time,ordered_on from orders where user_id = '"+user_id+"'";
		List<order_details> orders = jdbcTemplate.query(sql,new RowMapper<order_details>(){
			public order_details mapRow(ResultSet rs,int rowNumber) throws SQLException{
				order_details order = new order_details();
				order.setOrder_id(rs.getString("order_id"));
				order.setService_type(rs.getString("service_type"));
				String date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("pickup_date"));
				order.setPickup_date(date);
				order.setPickup_time(rs.getString("pickup_time"));
				date = new SimpleDateFormat("dd-MMM-yyyy").format(rs.getDate("ordered_on"));
				order.setOrdered_on(date);
				return order;
			}
		});
		return orders;
	}
}
