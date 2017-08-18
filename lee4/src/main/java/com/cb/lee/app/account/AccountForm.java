package com.cb.lee.app.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForm implements Serializable{
	private static final long serialVersionUID = 8751477236541259742L;
    @NotNull
    @Size(min = 6, max = 25)
    private String username;

    @NotNull
    @Size(min = 6, max = 18)
    private String password;

    @NotNull
    @Size(min = 6, max = 18)
    private String repeatedPassword;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
