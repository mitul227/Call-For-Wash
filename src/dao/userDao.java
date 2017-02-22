package dao;

import classes.ChangeAccountDetails;
import classes.UserLogin;
import classes.UserSignup;

public interface UserDao {
	public void insert(UserSignup user);
	//public List<user> show();
	public int check(UserLogin user);
	public String getAddress(String phoneNo);
	public int checkUserExists(String phoneNo);
	public void createTableUsers();
	public String getUserName(String phoneNo);
	public void changeDetails(ChangeAccountDetails acc,String phoneNo);
	public String getUserId(String phoneNo);
	public String getPassword(String phoneNo);
	public void changePassword(String password,String phoneNo);
}
