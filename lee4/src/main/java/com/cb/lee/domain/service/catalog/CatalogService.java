package com.cb.lee.domain.service.catalog;

import java.util.List;

import com.cb.lee.domain.model.Category;
import com.cb.lee.domain.model.Flower;
import com.cb.lee.domain.model.Item;
import com.cb.lee.domain.model.Product;

public interface CatalogService {
	/**获取所有物种*/
    List<Category> getCategoryList();
    /**通过物种ID获取物种*/
    Category getCategory(String categoryId);
    /**通过产品ID获得产品*/
    Product getProduct(String productId);
    /**通过物种ID获得该物种所有产品*/
    List<Product> getProductListByCategory(String categoryId);
    /**通过关键词查找所有相关产品
                     用于搜索功能*/
    List<Product> searchProductList(String keyword);
    /**通过产品ID获得Item该产品所有Item*/
    List<Item> getItemListByProduct(String productId);
    /**通过ItemID获得Item*/
    Item getItem(String itemId);
  //---------------------------------------改变
    /** 判断Flower的库存是否大于0*/
    boolean isFlowerInStock(int flowerId);
    /**通过花的ID获取花*/
    Flower getFlowerByFlowerId(int flowerId);
    /**根据花色获取花的花名、花色、花语、单价*/
	List<Flower> getFlowerListByName(String flowerName);
	/**根据花名和花色获取花的花名、花色、花语、单价、图片、简介*/
	Flower getFlowerDetails(String flowerName, String color);
	/**通过关键词查找所有与花名或颜色匹配的花
	    用于搜索功能*/
	List<Flower> searchFlowerList(String keyword);
	
}
