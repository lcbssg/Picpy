package com.cb.action.user;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cb.action.BaseAction;
import com.cb.common.Constant;
import com.cb.common.exception.BusinessException;
import com.cb.model.job.SysJob;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;
import com.cb.service.job.JobService;
import com.cb.service.login.LoginService;
import com.cb.service.product.ProductSortService;
import com.cb.service.user.UserService;

public class UserAction extends BaseAction implements ServletContextAware{
	private static final long serialVersionUID = -1541678427206369339L;
	//数据封装
	private SysUser sysUser;
	private String oldPassword;
	private String findByIdResult = "update";
	private File image;
	private String imageContentType;
	private String imageFileName;
	private ServletContext servletContext;
	private int page = 1;
	//业务层调用
	private UserService userService;
	private JobService jobService;
	private LoginService loginService;
	private ProductSortService productSortService;
	//geter settr方法
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getFindByIdResult() {
		return findByIdResult;
	}
	public void setFindByIdResult(String findByIdResult) {
		this.findByIdResult = findByIdResult;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public ServletContext getServletContext() {
		return servletContext;
	}
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public JobService getJobService() {
		return jobService;
	}
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
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
	/*----------------------------------------核心代码开始--------------------------------------------*/
	/**
	 * 用户注册
	 * @return
	 */
	public String register() {
		sysUser.setRegisterTime(getCurTime());
		try {
			SysUser user = userService.register(sysUser);
			getSession().put(Constant.SESSION_USER, user);//将登录用户写入到session中，直接登录
			List<ProductSort> productSorts = productSortService.findAll();
			getSession().put("productSorts", productSorts);
		} catch (BusinessException e) {
			getRequest().put("message", e.getMessage());
			return "registerInput";
		}
		return "register";
	}

	public String updatePassword() {
		if (!getCurUser().getPassword().equals(oldPassword)) {
			getRequest().put("message", "密码输入错误");
			return "updatePasswordInput";
		}
		SysUser su = getCurUser();
		su.setPassword(sysUser.getPassword());
		userService.updatePassword(su);
		getRequest().put("message", "用户密码修改成功");
		return "updatePassword";
	}
	public String updateInfor() {
		userService.updateInfor(sysUser);
		if(image != null) {
			String path = servletContext.getRealPath("/");
			//修改图片名，防止管理员两次提交同名文件
			String extension = imageFileName.substring(imageFileName.lastIndexOf("."));
			String imagName = getCurDate().getTime() + extension;
			//保存到数据库中的路径
			String savePath = "upload/userImage/" + imagName;
			sysUser.setImageUrl(savePath);
			userService.updateImage(sysUser, image, path);
		}
		getRequest().put("message", "用户信息修改成功");
		SysUser su = userService.findById(sysUser.getUserId());
		getSession().put(Constant.SESSION_USER, su);
		return "updateInfor";
	}
	
	public String findByPage() {
		List<SysUser> sysUsers = userService.findByPage(page);
		int count = userService.findCount();
		int pageCount = count%Constant.USER_NUMBER_PAGE==0?count/Constant.USER_NUMBER_PAGE:count/Constant.USER_NUMBER_PAGE + 1;
		getRequest().put("sysUsers", sysUsers);
		getRequest().put("pageCount", pageCount);
		return "findByPage";
	}

	public String lockUser() {
		userService.lockUser(sysUser);
		return "lockUser";
	}
	public String unLockUser() {
		userService.unLockUser(sysUser);
		return "unLockUser";
	}
	/**
	 * 根据用户id获取用户信息，并将职业信息获取出来 ，写入到request中
	 * @return
	 */
	public String findById() {
		List<SysJob> jobs = jobService.findAll();
		getRequest().put("sysJobs", jobs);
		this.sysUser = userService.findById(sysUser.getUserId());
		return findByIdResult;
	}
}
