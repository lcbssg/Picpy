package com.cb.model.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductSort implements Serializable{
	private static final long serialVersionUID = 3303874522930343851L;
	private int sortId;
	private String sortName;
	private String sortDesc;
	Set<Product> products = new HashSet<Product>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortDesc() {
		return sortDesc;
	}
	public void setSortDesc(String sortDesc) {
		this.sortDesc = sortDesc;
	}
}