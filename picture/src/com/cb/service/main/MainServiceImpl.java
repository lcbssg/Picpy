package com.cb.service.main;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.comment.CommentDao;
import com.cb.dao.main.MainDao;
import com.cb.dao.product.ProductDao;
import com.cb.dao.product.ProductSortDao;
import com.cb.dao.user.UserDao;
import com.cb.model.comment.ProductComment;
import com.cb.model.main.SysMain;
import com.cb.model.product.Product;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;
import com.cb.service.login.LoginService;

public class MainServiceImpl implements MainService{
	private MainDao mainDao;
	private ProductDao productDao;
	private ProductSortDao productSortDao;
	private CommentDao commentDao;
	private UserDao userDao;
	private LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public ProductSortDao getProductSortDao() {
		return productSortDao;
	}
	public void setProductSortDao(ProductSortDao productSortDao) {
		this.productSortDao = productSortDao;
	}
	public MainDao getMainDao() {
		return mainDao;
	}
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	public SysMain save(SysMain pSysMain, File pImage, String url) {
		try {
			pSysMain = mainDao.save(pSysMain);
		} catch (DataAccessException e1) {
			throw new BusinessException("出现数据库保存错误，请与系统管理员联系");
		}
		try {
			FileUtils.copyFile(pImage, new File(url));
		} catch (IOException e) {
			throw new BusinessException("文件上传错误", e);
		}
		return pSysMain;
	}

	public SysMain delete(SysMain pSysMain, String pUrl) {
		try {
			pSysMain = mainDao.findById(pSysMain.getMainId());
			//删除数据
			pSysMain = mainDao.delete(pSysMain);
			File file = new File(pUrl + pSysMain.getImageUrl());
			//删除文件
			file.delete();
			return pSysMain;
		} catch (DataAccessException e) {
			throw new BusinessException("出现数据库保存错误，请与系统管理员联系");
		}
	}

	public List<SysMain> findAll() {
		try {
			return mainDao.findAll();
		} catch (DataAccessException e) {
			throw new BusinessException("出现数据库保存错误，请与系统管理员联系");
		}
	}

	public Map<ProductSort, List<Product>> findThreeProductBySort() {
		try {
			Map<ProductSort, List<Product>> map = new LinkedHashMap<ProductSort, List<Product>>();
			List<ProductSort> sorts = productSortDao.findAll();
			for (ProductSort sort : sorts) {
				List<Product> products = productDao.findThreeProductBySort(sort.getSortId());
				map.put(sort, products);
			}
			return map;
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public List<ProductComment> findLastFiveComment() {
		try {
			return commentDao.findLastFiveComment();
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public List<SysUser> findTopFireUser() {
		try {
			return userDao.findTopFireUser();
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public Integer findCountByDate(Date date) {
		try {
			return loginService.findCountByDate(date);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
}
