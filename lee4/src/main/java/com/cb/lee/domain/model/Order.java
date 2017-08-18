package com.cb.lee.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**对应orders表，有初始化订单函数，还有添加lineItem函数*/
public class Order implements Serializable {

    private static final long serialVersionUID = 6321792448424424931L;

    private int orderId;
    private String username;

	private String consignee;
    private String area;
    private String location;
    private String phone;
    private String email;
    private String addrnick;
    
    private Date orderDate;
    private String courier;
    private BigDecimal totalPrice;
  
    private String status;
    

    private List<Line> lines = new ArrayList<Line>();
    public void addLine(CartItem cartItem) {
        Line line = new Line(lines.size() + 1, cartItem);
        addLine(line);
    }
    public void addLine(Line line) {
        lines.add(line);
    }
    //初始化订单
    public void initOrder(Account account, Cart cart) {
        username = account.getUsername();
        orderDate = new Date();
        totalPrice = cart.getSubTotal();
        status = "未发货";
        Iterator<CartItem> i = cart.getAllCartItems();
        while (i.hasNext()) {
            CartItem cartItem = (CartItem) i.next();
            addLine(cartItem);
        }
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCourier() {
        return courier;
    }
    public void setCourier(String courier) {
        this.courier = courier;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setLine(List<Line> lines) {
        this.lines = lines;
    }
    public List<Line> getLine() {
        return lines;
    }
}
