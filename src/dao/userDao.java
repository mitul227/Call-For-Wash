package dao;

import classes.acc_details;
import classes.user_login;
import classes.user_signup;

public interface userDao {
	public void insert(user_signup user);
	//public List<user> show();
	public int check(user_login user);
	public String get_address(String phone_no);
	public int check_user_exists(String phone_no);
	public void create_table_users();
	public String getUserName(String phone_no);
	public void change_details(acc_details acc,String phone_no);
	public String get_user_id(String phone_no);
	public String get_password(String phone_no);
	public void change_password(String password,String phone_no);
}
