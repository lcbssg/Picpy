package com.cb.model.product;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cb.model.comment.ProductComment;
import com.cb.model.user.SysUser;


public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 1004354400279999612L;
	private int productId;
	private String productName;
	private String productDesc;
	private Date createDate;
	private Timestamp uploadDate;
	private Timestamp lastModify;
	private String imageUrl;
	private ProductSort productSort;
	private SysUser sysUser;
	
	private Set<ProductComment> productComments = new HashSet<ProductComment>(0);
	private Set<ProductQuery> productQuerys = new HashSet<ProductQuery>();
	public Set<ProductQuery> getProductQuerys() {
		return productQuerys;
	}
	public void setProductQuerys(Set<ProductQuery> productQuerys) {
		this.productQuerys = productQuerys;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public ProductSort getProductSort() {
		return productSort;
	}
	public void setProductSort(ProductSort productSort) {
		this.productSort = productSort;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Timestamp getLastModify() {
		return lastModify;
	}
	public void setLastModify(Timestamp lastModify) {
		this.lastModify = lastModify;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Set<ProductComment> getProductComments() {
		return productComments;
	}
	public void setProductComments(Set<ProductComment> productComments) {
		this.productComments = productComments;
	}
	public String getUploadDateString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.uploadDate);
	}
	public String getCreateDateString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.createDate);
	}
}