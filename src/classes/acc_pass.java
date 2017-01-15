package classes;

import javax.validation.constraints.Size;

public class acc_pass {
	
	@Size(min=6,max=20,message="Password should be between 6-20 characters")
	String curr_pass;
	
	@Size(min=6,max=20,message="New Password should be between 6-20 characters")
	String new_pass;
	
	@Size(min=6,max=20,message="New Password should be between 6-20 characters")
	String new_pass_confirm;
	
	public String getCurr_pass() {
		return curr_pass;
	}

	public void setCurr_pass(String curr_pass) {
		this.curr_pass = curr_pass;
	}

	public String getNew_pass() {
		return new_pass;
	}

	public void setNew_pass(String new_pass) {
		this.new_pass = new_pass;
	}

	public String getNew_pass_confirm() {
		return new_pass_confirm;
	}

	public void setNew_pass_confirm(String new_pass_confirm) {
		this.new_pass_confirm = new_pass_confirm;
	}
}
