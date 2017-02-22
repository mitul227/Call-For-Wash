package classes;

import javax.validation.constraints.Size;

public class ChangeAccountPassword {
	
	@Size(min=6,max=20,message="Password should be between 6-20 characters")
	String currentPassword;
	
	@Size(min=6,max=20,message="New Password should be between 6-20 characters")
	String newPassword;
	
	@Size(min=6,max=20,message="New Password should be between 6-20 characters")
	String newPasswordConfirm;
	
	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}
}
