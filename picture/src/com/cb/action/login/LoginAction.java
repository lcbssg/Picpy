package com.cb.action.login;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.cb.action.BaseAction;
import com.cb.common.Constant;
import com.cb.common.util.ImageUtil;
import com.cb.model.login.SysLogin;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysAdmin;
import com.cb.model.user.SysUser;
import com.cb.service.login.LoginService;
import com.cb.service.product.ProductSortService;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = -6028916784395748967L;
	private String loginName;
	private String password;
	private String validateCode;
	private InputStream imageInputStream;
	
	private LoginService loginService; 
	private ProductSortService productSortService;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InputStream getImageInputStream() {
		return imageInputStream;
	}
	public void setImageInputStream(InputStream imageInputStream) {
		this.imageInputStream = imageInputStream;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public ProductSortService getProductSortService() {
		return productSortService;
	}
	public void setProductSortService(ProductSortService productSortService) {
		this.productSortService = productSortService;
	}
	//---------------------------------------------------------
	/**
	 * 获取验证码
	 * @return
	 * getValidateCode
	 * BUS_EXCEPTION
	 */
	public String findValidateCode() {
		//创建了一组验证码字符，以及验证码图片流
		Map<String, BufferedImage> images = ImageUtil.createImage();
		//获取第一个验证码字符
		String code = images.keySet().iterator().next();
		//根据验证码字符，获取验证码图片流
		BufferedImage image = images.get(code);
		//将图片流转换为inputStream类型，并赋值给值栈栈顶的imageInputStream
		this.imageInputStream = ImageUtil.getInputStream(image);
		//将验证码写入session中
		getSession().put(Constant.SESSION_VALIDATE, code);
		//返回成功标志
		return "getValidateCode";
	}
	/**
	 * 系统登录，
	 * 普通用户登录成功
	 * 	返回success
	 * 系统管理员登录成功
	 *  返回 adminSuccess
	 * 输入错误，返回input
	 * 	用户名错误request.put("state","0")
	 * 	密码错误   request.put("state","1");
	 *  验证码错误   request.put("state","2");
	 *  用户被锁   request.put("state","3");
	 * @return
	 * userSuccess
	 * adminSuccess
	 * input
	 * BUS_EXCEPTION
	 */
	public String login() {
		if (!getSession().get(Constant.SESSION_VALIDATE).toString()
				.equalsIgnoreCase(validateCode)) {
			getRequest().put("state", "2");
			return INPUT;
		}
		SysUser user = loginService.findUserByLoginName(loginName);
		if (user != null) {// 根据用户名可以检索到用户信息
			return judgeUser(user);
		} else {// 用户表中没有输入的帐号
			return judgeAdmin();
		}
	}
	
	private String judgeAdmin() {
		//在系统管理员表中获取当前帐号对应的管理员信息。
		SysAdmin admin = loginService.findAdminByLoginName(loginName);
		if (admin != null) {//系统管理员帐号存在
			if (admin.getPassword().equals(password)) {//验证密码是否正确
				getSession().put(Constant.SESSION_USER, admin);//将管理员信息写入到session中
				//获取全部作品分类，用于菜单显示，经常使用，且不会改变，写入到session中
				List<ProductSort> productSorts = productSortService.findAll();
				getSession().put("productSorts", productSorts);
				return "adminSuccess";//管理员登录成功。
			} else {
				getRequest().put("state", "1");//存在帐号，但密码不存在，将该状态写入到request中
				return INPUT;//返回输入错误状态
			}
		} else {
			getRequest().put("state", "0");
			return INPUT;
		}
	}
	
	private String judgeUser(SysUser user) {
		if (user.getPassword().equals(password)) {//该用户的密码与输入密码相同
			if (user.getIsLock()) {//用户被锁定
				getRequest().put("state", "3");//用户被锁定，无法登录
				return INPUT;//返回输入错误状态
			} else {
				getSession().put(Constant.SESSION_USER, user);//将登录用户写入到session中
				SysLogin sl = new SysLogin();
				sl.setLoginTime(getCurTime());
				loginService.save(sl, user);//普通用户登录保存用户登录信息
				//获取全部作品分类，用于菜单显示，经常使用，且不会改变，写入到session中
				List<ProductSort> productSorts = productSortService.findAll();
				getSession().put("productSorts", productSorts);
				return "userSuccess";//返回登录成功状态
			}
			
		} else {
			getRequest().put("state", "1");//存在帐号，但密码不存在，将该状态写入到request中
			return INPUT;//返回输入错误状态
		}
	}
	/**
	 * 退出登录
	 * 在session中移除登录信息
	 * @return
	 * logout
	 */
	public String logout() {
		getSession().remove(Constant.SESSION_USER);//在session中移除登录信息
		getSession().remove("productSorts");
		return "logout";
	}
}
