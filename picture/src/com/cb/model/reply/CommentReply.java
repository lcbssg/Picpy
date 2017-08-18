package com.cb.model.reply;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.cb.model.comment.ProductComment;
import com.cb.model.user.SysUser;

public class CommentReply implements java.io.Serializable {
	private static final long serialVersionUID = 6736048844089326193L;
	
	private int replyId;
	private SysUser sysUser;
	private ProductComment productComment;
	private String replyContent;
	private Timestamp replyTime;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public ProductComment getProductComment() {
		return productComment;
	}
	public void setProductComment(ProductComment productComment) {
		this.productComment = productComment;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyContentString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(this.replyTime);
	}
}