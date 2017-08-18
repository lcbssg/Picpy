package com.cb.lee.app.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class AddressForm {
	
	private String username;

	@NotNull
    @Size(min = 1, max = 50)
    private String consignee;

	@NotNull
    @Size(min = 1, max = 50)
    private String area;

    @NotNull
    @Size(min = 1, max = 50)
    private String location;

	@NotNull
    @Size(min = 5, max = 20)
    private String phone;
    
    @Email
    @Size(min = 0, max = 50)
    private String email;
    
    @Size(min = 0, max = 20)
    private String addrnick;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
    public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddrnick() {
		return addrnick;
	}

	public void setAddrnick(String addrnick) {
		this.addrnick = addrnick;
	}

}
