package com.cb.lee.app.order;

/**对应确认收货地址表单*/
public class OrderForm {
	private String consignee;
    private String area;
    private String location;
    private String phone;
    private String email;
    private String addrnick;
    private String courier;
    
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
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
}
