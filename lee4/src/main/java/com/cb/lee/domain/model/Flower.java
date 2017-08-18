package com.cb.lee.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Flower implements Serializable{
	private static final long serialVersionUID = -2159121688888854631L;
	
	private int flowerId;
	private String flowerName;
	private String color;
	private String flowerLang;
	private BigDecimal listPrice;
	private BigDecimal unitCost;
	private int quantity;
	private String img;
	private String profile;
	
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFlowerLang() {
		return flowerLang;
	}
	public void setFlowerLang(String flowerLang) {
		this.flowerLang = flowerLang;
	}
	public BigDecimal getListPrice() {
		return listPrice;
	}
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}
	public BigDecimal getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
