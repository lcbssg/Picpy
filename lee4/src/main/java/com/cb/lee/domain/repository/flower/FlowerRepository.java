package com.cb.lee.domain.repository.flower;

import java.util.List;
import java.util.Map;

import com.cb.lee.domain.model.Flower;

public interface FlowerRepository {
	/**根据花色获取花的花名、花色、花语、单价*/
	List<Flower> getFlowerListByName(String flowerName);
	/**根据花名和花色获取花的花名、花色、花语、单价、图片、简介*/
	Flower getFlowerDetails(String flowerName, String color);
    /** 用于搜索功能
     	通过关键词从flower表获得多个元组*/
    List<Flower> searchFlowerList(String keywords);
    /**通过花的ID获取库存*/
    int getInventoryQuantity(int flowerId);
    /**通过花的ID更新库存*/
    void updateInventoryQuantity(Map<String, Object> param);
    /**通过花的ID获取花*/
    Flower getFlowerByFlowerId(int flowerId);
}
