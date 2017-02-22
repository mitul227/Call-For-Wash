package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import classes.ChangeAccountDetails;
import classes.UserLogin;
import classes.UserSignup;
import security.PasswordHashing;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	DataSource dataSource;
	
	public void createTableUsers(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from user_tables where table_name = 'USERS'";
		if(jdbcTemplate.queryForObject(sql, Integer.class) == 0){
			sql = "create table users(user_id varchar2(20) unique not null,phone_no varchar2(10) primary key check(length(phone_no)=10),name varchar2(50) "
					+ "not null,password varchar2(70),"
					+ "address varchar2(50) not null,no_of_orders number(5) not null)";	
			jdbcTemplate.execute(sql);
			sql = "create sequence user_id_seq start with 1 increment by 1 nocycle";
			jdbcTemplate.execute(sql);
			sql = "create table info(users number(8),total_orders number(8),"
					+ "succ_orders number(8),pending_orders number(8),"
					+ "cancelled_orders number(8),total_earnings number(8))";
			jdbcTemplate.execute(sql);
			sql = "insert into info values(0,0,0,0,0,0)";
			jdbcTemplate.update(sql);
		}
	}
	
	public void insert(UserSignup user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select user_id_seq.nextval from dual";
		int id = jdbcTemplate.queryForObject(sql, Integer.class);
		String user_id = "u" + id;
		sql = "insert into users values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,user_id,user.getPhoneNo(),user.getName().toLowerCase(),user.getPassword(),user.getAddress(),0);
		sql = "update info set users=users+1";
		jdbcTemplate.update(sql);
	}
	
	public int check(UserLogin user){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from users where phone_no='"+user.getPhoneNo()+"' and password='"+user.getPassword()+"'";
		int x = jdbcTemplate.queryForObject(sql,Integer.class);
		return x;
	}
	
	public String getAddress(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select address from users where phone_no = '"+phoneNo+"'";
		String address = jdbcTemplate.queryForObject(sql,String.class);
		return address;
	}
	
	public int checkUserExists(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from users where phone_no = '"+phoneNo+"'";
		int x = jdbcTemplate.queryForObject(sql, Integer.class);
		return x;
	}
	
	public String getUserName(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select name from users where phone_no = '"+phoneNo+"'";
		String name = jdbcTemplate.queryForObject(sql,String.class);
		return name;
	}
	
	public String getUserId(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select user_id from users where phone_no = '"+phoneNo+"'";
		String userId = jdbcTemplate.queryForObject(sql,String.class);
		return userId;
	}
	
	public String getPassword(String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select password from users where phone_no = '"+phoneNo+"'";
		String password = jdbcTemplate.queryForObject(sql,String.class);
		return password;
	}
	
	public void changeDetails(ChangeAccountDetails acc,String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update users set name=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getName(),phoneNo);
		sql = "update users set address=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getAddress(),phoneNo);
		sql = "update users set phone_no=? where phone_no = ?";
		jdbcTemplate.update(sql,acc.getPhoneNo(),phoneNo);
	}
	
	public void changePassword(String password,String phoneNo){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update users set password=? where phone_no = ?";
		jdbcTemplate.update(sql,password,phoneNo);
	}

}
