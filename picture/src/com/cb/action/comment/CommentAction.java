package com.cb.action.comment;

import java.util.List;

import com.cb.action.BaseAction;
import com.cb.common.Constant;
import com.cb.model.comment.ProductComment;
import com.cb.model.product.Product;
import com.cb.service.comment.CommentService;
import com.cb.service.product.ProductService;

public class CommentAction extends BaseAction {
	private static final long serialVersionUID = 2006586648088553294L;
	/*-----------------------数据封装开始------------------------*/
	private ProductComment productComment;
	private Product product;
	private int page = 1;
	
	/*-----------------------业务层接口定义开始------------------------*/
	private CommentService commentService;
	private ProductService productService;
	
	/*--------------------get set方法开始----------------------------*/
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public ProductComment getProductComment() {
		return productComment;
	}
	public void setProductComment(ProductComment productComment) {
		this.productComment = productComment;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	/*-------------------核心代码开始----------------------*/
	/**
	 * 保存评论信息
	 * @return
	 */
	public String save() {
		product = productService.findById(product.getProductId());
		productComment.setCommentTime(getCurTime());
		productComment.setSysUser(getCurUser());
		productComment.setProduct(product);
		commentService.save(productComment);
		getRequest().put("message", "保存评论成功");
		getRequest().put("productId", product.getProductId());
		return "save";
	}
	
	/**
	 * 修改评论信息
	 * @return
	 */
	public String update() {
		productComment = commentService.update(productComment);
		getRequest().put("message", "修改评论成功");
		getRequest().put("productId", productComment.getProduct().getProductId());
		return "update";
	}
	/**
	 * 删除评论信息
	 */
	public String delete() {
		productComment = commentService.findById(productComment.getCommentId());
		commentService.delete(productComment);
		getRequest().put("message", "删除评论成功");
		getRequest().put("productId", productComment.getProduct().getProductId());
		return "delete";
	}
	
	/**
	 * 根据id获取评论，写入到栈顶
	 * @return
	 */
	public String findById() {
		this.productComment = commentService.findById(productComment.getCommentId());
		return "findById";
	}
	/**
	 * 获取作品的评论、回复信息并封装到product对象中，按照每页5个评论，分页取出
	 * @return
	 */
	public String findCommentAndReplyByProduct() {
		product = productService.findById(product.getProductId());
		List<ProductComment> productComments = commentService.findCommentAndReplyByProId(product.getProductId(), page);
		int count = commentService.findCommentCountByProduct(product.getProductId());
		getRequest().put("productComments", productComments);
		getRequest().put("product", product);
		getRequest().put("pageCount", count%Constant.COMMENT_NUMBER_PAGE == 0 ? count/5:count/5+1);
		getRequest().put("commentCount", count);
		return "findCommentAndReplyByProduct";
	}
}
