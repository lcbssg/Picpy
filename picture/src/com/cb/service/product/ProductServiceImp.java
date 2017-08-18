package com.cb.service.product;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataAccessException;

import com.cb.common.exception.BusinessException;
import com.cb.dao.product.ProductDao;
import com.cb.model.product.Product;
import com.cb.model.product.ProductQuery;
import com.cb.model.product.ProductSort;
import com.cb.model.user.SysUser;
import com.cb.service.user.UserService;

public class ProductServiceImp implements ProductService {
	private ProductDao productDao;
	private ProductSortService productSortService;
	private ProductQueryService productQueryService;
	private UserService	userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ProductQueryService getProductQueryService() {
		return productQueryService;
	}
	public void setProductQueryService(ProductQueryService productQueryService) {
		this.productQueryService = productQueryService;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public ProductSortService getProductSortService() {
		return productSortService;
	}
	public void setProductSortService(ProductSortService productSortService) {
		this.productSortService = productSortService;
	}

	public Product save(Product pProduct, File pImageFile, String pRealPath) {
		try {
			productDao.save(pProduct);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
		try {
			FileUtils.copyFile(pImageFile, new File(pRealPath + pProduct.getImageUrl()));
		} catch (IOException e) {
			throw new BusinessException("文件上传错误", e);
		}
		return null;
	}
	/**
	 * 每次修改作品，采用先删除图片，重新上传的方式
	 */
	public Product update(Product pProduct, File pImageFile, String pRealPath) {
		String oldImageUrl = null;
		Product product = productDao.findById(pProduct.getProductId());
		try {
			//修改前图片路径
			oldImageUrl = product.getImageUrl();
			if (pImageFile != null) {
				product.setImageUrl(pProduct.getImageUrl());
			}
			product.setLastModify(pProduct.getLastModify());
			product.setProductName(pProduct.getProductName());
			product.setProductDesc(pProduct.getProductDesc());
			ProductSort ps = productSortService.findById(pProduct.getProductSort().getSortId());
			product.setProductSort(ps);
			product.setCreateDate(pProduct.getCreateDate());
			productDao.update(product);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
		try {
			if (pImageFile != null) {
				FileUtils.copyFile(pImageFile, new File(pRealPath + pProduct.getImageUrl()));
				File file = new File(pRealPath + oldImageUrl);
				//删除修改前的图片文件
				file.delete();
			}
		} catch (IOException e) {
			throw new BusinessException("文件上传错误", e);
		}
		return product;
	}

	public void delete(Product pProduct) {
		try {
			Product product = findById(pProduct.getProductId());
			productDao.delete(product);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public Product findProductDetailById(int id, int queryUserId) {
		try {
			Product product = productDao.findDetailById(id);
			//查看作品的人不是作者也不是系统管理员，向作品查阅表中插入一条数据
			if (queryUserId != 0 && product.getSysUser().getUserId() != queryUserId) {
				ProductQuery pq = new ProductQuery();
				pq.setProduct(product);
				pq.setQueryTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
				SysUser queryUser = userService.findById(queryUserId);
				pq.setSysUser(queryUser);
				productQueryService.save(pq);
			}
			return product;
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	
	public List<ProductSort> findAllSort() {
		try {
			return productSortService.findAll();
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	
	public Product findById(int id) {
		try {
			return productDao.findById(id);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public List<Product> findProductBySortAndPage(int pSortId, int page) {
		try {
			return productDao.findBySortAndPage(pSortId,page);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	public List<Product> findProductByUserAndPage(int pUserId, int page) {
		try {
			return productDao.findByUserAndPage(pUserId,page);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}

	public int findProductCountBySort(int sortId) {
		try {
			return productDao.findProductCountBySort(sortId);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
	public int findProductCountByUser(int pUserId) {
		try {
			return productDao.findProductCountByUser(pUserId);
		} catch (DataAccessException e) {
			throw new BusinessException();
		}
	}
}
