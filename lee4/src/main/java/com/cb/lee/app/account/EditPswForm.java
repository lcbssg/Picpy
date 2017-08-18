package com.cb.lee.app.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditPswForm {
    @NotNull
    private String oldPassword;
    
	@NotNull
    @Size(min = 6, max = 18)
    private String password;

    @NotNull
    @Size(min = 6, max = 18)
    private String repeatedPassword;


    public String getOldPassword() {
		return oldPassword;
	}
	public void setOldpassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }
    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
