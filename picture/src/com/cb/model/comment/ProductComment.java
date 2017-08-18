package com.cb.model.comment;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import com.cb.model.product.Product;
import com.cb.model.reply.CommentReply;
import com.cb.model.user.SysUser;

public class ProductComment implements java.io.Serializable {
	private static final long serialVersionUID = -7882530139291192617L;
	private int commentId;
	private SysUser sysUser;
	private Product product;
	private String commentContent;
	private Timestamp commentTime;
	private Set<CommentReply> commentReplies = new HashSet<CommentReply>();
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public Set<CommentReply> getCommentReplies() {
		return commentReplies;
	}
	public void setCommentReplies(Set<CommentReply> commentReplies) {
		this.commentReplies = commentReplies;
	}
	
	public String getCommentTimeString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(this.commentTime);
	}
}