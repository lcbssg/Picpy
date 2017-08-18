package com.cb.action.product;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.cb.action.BaseAction;
import com.cb.common.Constant;
import com.cb.model.product.Product;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;
import com.cb.service.product.ProductService;

public class ProductAction extends BaseAction implements ServletContextAware{
	private static final long serialVersionUID = 1428779075837284447L;
	/*----------------------数据封装开始----------------------*/
	private Product product;
	private File image;
	private String imageContentType;
	private String imageFileName;
	private ServletContext servletContext;
	private int page = 1;
	private ProductSort productSort;
	private SysUser sysUser;
	/*---------------------业务接口定义开始----------------------*/
	private ProductService productService;
	/*--------------------set get方法 开始----------------------*/
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	public void setServletContext(ServletContext pServletContext) {
		this.servletContext = pServletContext;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
	
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/*-------------------------核心代码开始------------------------------------*/
	/**
	 * 保存作品
	 * @return
	 */
	public String saveProduct() {
		String path = servletContext.getRealPath("/");
		String extension = imageFileName.substring(imageFileName.lastIndexOf("."));
		//修改图片名，防止管理员两次提交同名文件
		String imagName = getCurDate().getTime() + extension;
		//保存到数据库中的路径
		String savePath = "upload/productImage/" + imagName;
		product.setImageUrl(savePath);
		product.setLastModify(getCurTime());
		product.setUploadDate(getCurTime());
		product.setSysUser(getCurUser());
		productService.save(product, image, path);
		this.sysUser = getCurUser();
		return "saveProduct";
	}
	/**
	 * 修改作品
	 * @return
	 */
	public String updateProduct() {
		String path = servletContext.getRealPath("/");
		if (image != null) {
			String extension = imageFileName.substring(imageFileName.lastIndexOf("."));
			//修改图片名，防止两次提交同名文件
			String imagName = getCurDate().getTime() + extension;
			//保存到数据库中的路径
			String savePath = "upload/productImage/" + imagName;
			product.setImageUrl(savePath);
		}
		product.setLastModify(getCurTime());
		Product pro = productService.update(product, image, path);
		this.sysUser = pro.getSysUser();
		return "updateProduct";
	}
	/**
	 * 删除作品
	 * @return
	 */
	public String deleteProduct() {
		productService.delete(product);
		return "deleteProduct";
	}
	/**
	 * 根据id获取作品，写入栈顶
	 * @return
	 */
	public String findProductById() {
		product = productService.findById(product.getProductId());
		return "findProductById";
	}
	/**
	 * 根据作品id获取作品、作品作者信息
	 * 写入到request
	 * @return
	 */
	public String findProductDetailById() {
		int userId = 0;
		if (!isAdmin()) {
			userId = getCurUser().getUserId();
		}
		product = productService.findProductDetailById(product.getProductId(), userId);
		getRequest().put("product", product);
		return "findProductDetailById";
	}
	/**
	 * 根据作品类别以及页数获取作品信息
	 * @return
	 */
	public String findProductBySortAndPage() {
		List<Product> products = productService.findProductBySortAndPage(productSort.getSortId(), page);
		int count = productService.findProductCountBySort(productSort.getSortId());
		int pageCount = count%Constant.PRODUCT_NUMBER_PAGE==0?count/Constant.PRODUCT_NUMBER_PAGE:count/Constant.PRODUCT_NUMBER_PAGE + 1;
		getRequest().put("pageCount", pageCount);
		getRequest().put("products", products);
		return "findProductBySortAndPage";
	}
	/**
	 * 获取某用户全部作品（分页）
	 * @return
	 */
	public String findProductByUserAndPage() {
		List<Product> products = productService.findProductByUserAndPage(sysUser.getUserId(), page);
		int count = productService.findProductCountByUser(sysUser.getUserId());
		int pageCount = count%Constant.PRODUCT_NUMBER_PAGE==0?count/Constant.PRODUCT_NUMBER_PAGE:count/Constant.PRODUCT_NUMBER_PAGE + 1;
		getRequest().put("products", products);
		getRequest().put("pageCount", pageCount);
		return "findProductByUserAndPage";
	}
}
