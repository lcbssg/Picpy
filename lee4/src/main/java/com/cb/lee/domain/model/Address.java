package com.cb.lee.domain.model;

import java.io.Serializable;

//包含account数据库表
public class Address implements Serializable {
    private static final long serialVersionUID = 8751477236541259742L;
    
    private String username;
	private String consignee;
    private String area;
    private String location;
    private String phone;
    private String email;
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
