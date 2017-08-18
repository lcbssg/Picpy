
package com.cb.action.reply;

import com.cb.action.BaseAction;
import com.cb.model.comment.ProductComment;
import com.cb.model.reply.CommentReply;
import com.cb.service.comment.CommentService;
import com.cb.service.reply.ReplyService;

public class ReplyAction extends BaseAction {
	private static final long serialVersionUID = 1773555940115189583L;
	/*--------------------数据封装开始-------------------*/
	private CommentReply commentReply;
	/*-----------------业务层接口定义开始-----------------*/
	private CommentService commentService;
	private ReplyService replyService;
	/*----------------get set函数开始-------------------*/
	public CommentReply getCommentReply() {
		return commentReply;
	}
	public void setCommentReply(CommentReply commentReply) {
		this.commentReply = commentReply;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public ReplyService getReplyService() {
		return replyService;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	/*----------------------核心代码开始--------------------*/
	/**
	 * 保存回复信息
	 * @return
	 */
	public String save(){
		ProductComment pc = commentService.findById(commentReply.getProductComment().getCommentId());
		commentReply.setReplyTime(getCurTime());
		commentReply.setSysUser(getCurUser());
		commentReply.setProductComment(pc);
		replyService.save(commentReply);
		getRequest().put("message", "回复发布成功");
		getRequest().put("productId", pc.getProduct().getProductId());
		return "save";
	}
	/**
	 * 修改回复信息
	 * @return
	 */
	public String update(){
		CommentReply reply = replyService.update(commentReply);
		getRequest().put("message", "回复修改成功");
		getRequest().put("productId", reply.getProductComment().getProduct().getProductId());
		return "update";
	}
	/**
	 * 删除回复信息
	 */
	public String delete(){
		CommentReply reply = replyService.findById(commentReply.getReplyId());
		replyService.delete(reply);
		getRequest().put("message", "回复删除成功");
		getRequest().put("productId", reply.getProductComment().getProduct().getProductId());
		return "delete";
	}
	/**
	 * 根据id获取回复，写入栈顶
	 * @return
	 */
	public String findById(){
		this.commentReply = replyService.findById(commentReply.getReplyId());
		return "findById";
	}
}
