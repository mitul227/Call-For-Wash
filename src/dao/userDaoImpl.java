package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import classes.acc_details;
import classes.user_login;
import classes.user_signup;

@Component
public class userDaoImpl implements userDao{
	
	@Autowired
	DataSource dataSource;
	
	public void create_table_users(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from user_tables where table_name = 'USERS'";
		if(jdbcTemplate.queryForObject(sql, Integer.class) == 0){
			sql = "create table users(user_id varchar2(20) unique not null,phone_no varchar2(10) primary key check(length(phone_no)=10),name varchar2(50) "
					+ "not null,password varchar2(20) check(length(password) between 6 and 20),"
					+ "address varchar2(50) not null,coupon_used varchar2(2) not null)";	
			jdbcTemplate.execute(sql);
			sql = "create sequence user_id_seq start with 1 increment by 1 nocycle";
			jdbcTemplate.execute(sql);
		}
	}
	
	public void insert(user_signup user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select user_id_seq.nextval from dual";
		int id = jdbcTemplate.queryForObject(sql, Integer.class);
		String user_id = "u" + id;
		sql = "insert into users values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,user_id,user.getPhone_no(),user.getName().toLowerCase(),user.getPassword(),user.getAddress(),"n");
	}
	
	public int check(user_login user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from users where phone_no='"+user.getPhone_no()+"' and password='"+user.getPassword()+"'";
		int x = jdbcTemplate.queryForObject(sql,Integer.class);
		return x;
	}
	
	public String get_address(String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select address from users where phone_no = '"+phone_no+"'";
		String address = jdbcTemplate.queryForObject(sql,String.class);
		return address;
	}
	
	public int check_user_exists(String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from users where phone_no = '"+phone_no+"'";
		int x = jdbcTemplate.queryForObject(sql, Integer.class);
		return x;
	}
	
	public String getUserName(String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select name from users where phone_no = '"+phone_no+"'";
		String name = jdbcTemplate.queryForObject(sql,String.class);
		return name;
	}
	
	public String get_user_id(String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select user_id from users where phone_no = '"+phone_no+"'";
		String user_id = jdbcTemplate.queryForObject(sql,String.class);
		return user_id;
	}
	
	public String get_password(String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select password from users where phone_no = '"+phone_no+"'";
		String password = jdbcTemplate.queryForObject(sql,String.class);
		return password;
	}
	
	public void change_details(acc_details acc,String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update users set name=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getName(),phone_no);
		sql = "update users set address=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getAddress(),phone_no);
		sql = "update users set phone_no=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getPhone_no(),phone_no);
	}
	
	public void change_password(String password,String phone_no){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update users set password=? where phone_no = ?";
		jdbcTemplate.update(sql,password,phone_no);
	}
	/*public List<user> show(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from users";
		List<user> list= jdbcTemplate.query(sql, new RowMapper<user>(){
			public user mapRow(ResultSet rs,int rowNum) throws SQLException{
				user user = new user();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setE_mail(rs.getString("e_mail"));
				
				return user;
			}
		});
		return list;
	}*/
}
