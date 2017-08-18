package com.cb.model.product;

import java.sql.Timestamp;

import com.cb.model.user.SysUser;


public class ProductQuery implements java.io.Serializable {
	private static final long serialVersionUID = -1717830918532675465L;
	private int productQueryId;
	private SysUser sysUser;
	private Timestamp queryTime;
	private Product product;
	public int getProductQueryId() {
		return productQueryId;
	}
	public void setProductQueryId(int productQueryId) {
		this.productQueryId = productQueryId;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Timestamp getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Timestamp queryTime) {
		this.queryTime = queryTime;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}