package com.cb.action.main;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cb.action.BaseAction;
import com.cb.model.comment.ProductComment;
import com.cb.model.main.SysMain;
import com.cb.model.product.Product;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;
import com.cb.service.main.MainService;
import com.cb.service.product.ProductSortService;

public class MainAction extends BaseAction implements ServletContextAware{
	private static final long serialVersionUID = -5156946566897769614L;
	/*---------------------------------------数据封装开始-------------------------------------*/
	private SysMain sysMain;
	private File image;
	private String imageContentType;
	private String imageFileName;
	private ServletContext servletContext;
	/*--------------------------------------业务层接口定义-------------------------------------*/
	private MainService mainService;
	private ProductSortService productSortService;
	/*----------------------------set get函数-----------------------------------*/
	
	public SysMain getSysMain() {
		return sysMain;
	}
	public void setSysMain(SysMain sysMain) {
		this.sysMain = sysMain;
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
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}
	public ServletContext getServletContext() {
		return servletContext;
	}
	public MainService getMainService() {
		return mainService;
	}
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	public ProductSortService getProductSortService() {
		return productSortService;
	}
	public void setProductSortService(ProductSortService productSortService) {
		this.productSortService = productSortService;
	}
	/*-----------------------------------核心代码----------------------*/
	/**
	 * 保存主页图片信息
	 * @return
	 */
	public String save() {
		SysMain sa = new SysMain();
		sa.setImageName(imageFileName);
		String path = servletContext.getRealPath("/upload/main/");
		String extension = imageFileName.substring(imageFileName.lastIndexOf("."));
		//修改图片名，防止管理员两次提交同名文件
		String imagName = getCurDate().getTime() + extension;
		//保存到数据库中的路径
		String savePath = "upload/main/" + imagName;
		sa.setImageUrl(savePath);
		mainService.save(sa,this.image, path+"/" + imagName);
		return "save";
	}
	/**
	 * 删除主页图片信息
	 * @return
	 */
	public String delete() {
		String path = servletContext.getRealPath("/");
		mainService.delete(sysMain, path);
		return "delete";
	}
	/**
	 * 查询主页全部图片
	 * @return
	 */
	public String findAll() {
		List<SysMain> images = mainService.findAll();
		getRequest().put("sysMains", images);
		return "findAll";
	}
	
	public String findMainContent() {
		//首页图片
		List<SysMain> images = mainService.findAll();
		//首页分类以及分类下的作品信息
		Map<ProductSort, List<Product>> sorts = mainService.findThreeProductBySort();
		//首页右侧的最热门设计师
		List<SysUser> users = mainService.findTopFireUser();
		//最新评论
		List<ProductComment> comments = mainService.findLastFiveComment();
		int count = mainService.findCountByDate(getCurDate());
		getRequest().put("sysMains", images);
		getRequest().put("productSorts", sorts);
		getRequest().put("sysUsers", users);
		getRequest().put("loginCount", count);
		getRequest().put("comments", comments);
		return "findMainContent";
	}
	/**
	 * 查询主页全部图片
	 */
	public String toMain() {
		List<ProductSort> productSorts = productSortService.findAll();
		getRequest().put("productSorts", productSorts);
		return "toMain";
	}
}
