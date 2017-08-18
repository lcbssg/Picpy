package com.cb.lee.domain.repository.item;

import java.util.List;
import java.util.Map;

import com.cb.lee.domain.model.Item;
/**更新或获取库存，获取一个单件或所有单件*/
public interface ItemRepository {
	//通过ItemID-INCREMETN键值对更新inventory表
    void updateInventoryQuantity(Map<String, Object> param);
    //通过商品ID从inventory表获取商品库存
    int getInventoryQuantity(String itemId);
    //通过productID从product表和item表获取item多行元组
    List<Item> getItemListByProduct(String productId);
    //通过ItemID从inventory表和item表和product表获取item一行元组
    Item getItem(String itemId);

}
