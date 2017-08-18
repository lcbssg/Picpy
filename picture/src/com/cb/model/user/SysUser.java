package com.cb.model.user;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cb.model.comment.ProductComment;
import com.cb.model.job.SysJob;
import com.cb.model.login.SysLogin;
import com.cb.model.product.Product;
import com.cb.model.product.ProductQuery;
import com.cb.model.reply.CommentReply;
public class SysUser {
	private int userId;
	private String loginName;
	private String userName;
	private String password;
	private String email;
	private String imageUrl;
	private boolean isMale;
	private String phoneNum;
	private Date birthday;
	private Timestamp registerTime;
	private boolean isLock;
	private SysJob sysJob;
	
	private Set<SysLogin> sysLogin = new HashSet<SysLogin>();
	private Set<Product> products = new HashSet<Product>();
	private Set<ProductQuery> productQuerys = new HashSet<ProductQuery>();
	private Set<ProductComment> porductComments = new HashSet<ProductComment>();
	private Set<CommentReply> commentReplys = new HashSet<CommentReply>();
	
	public Set<CommentReply> getCommentReplys() {
		return commentReplys;
	}
	public void setCommentReplys(Set<CommentReply> commentReplys) {
		this.commentReplys = commentReplys;
	}
	public Set<ProductComment> getPorductComments() {
		return porductComments;
	}
	public void setPorductComments(Set<ProductComment> porductComments) {
		this.porductComments = porductComments;
	}
	public Set<ProductQuery> getProductQuerys() {
		return productQuerys;
	}
	public void setProductQuerys(Set<ProductQuery> productQuerys) {
		this.productQuerys = productQuerys;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getBirthdayString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.birthday);
	}
	public boolean getIsLock() {
		return isLock;
	}
	public void setIsLock(boolean isLock) {
		this.isLock = isLock;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public SysJob getSysJob() {
		return sysJob;
	}
	public void setSysJob(SysJob sysJob) {
		this.sysJob = sysJob;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean getIsMale() {
		return isMale;
	}
	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Set<SysLogin> getSysLogin() {
		return sysLogin;
	}
	public void setSysLogin(Set<SysLogin> sysLogin) {
		this.sysLogin = sysLogin;
	}
	public String getRegisterTimeString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.registerTime);
	}
}
