package com.cb.lee.domain.repository.product;

import java.util.List;

import com.cb.lee.domain.model.Product;

/** 获得产品或产品列表*/
public interface ProductRepository {
	//通过种类名从product获取多个元组
    List<Product> getProductListByCategory(String categoryId);
    //通过产品ID从product表获得一个元组
    Product getProduct(String productId);
    //通过关键词从product表获得多个元组
    /** 用于搜索功能*/
    List<Product> searchProductList(String keywords);

}
