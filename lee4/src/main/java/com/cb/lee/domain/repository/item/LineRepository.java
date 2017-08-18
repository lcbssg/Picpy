package com.cb.lee.domain.repository.item;

import java.util.List;

import com.cb.lee.domain.model.Line;
/**订单会买很多不同的单件，插入或获取单件行*/
public interface LineRepository {
	//通过订单编号从LineItem获取多行LineItem元组
    List<Line> getLinesByOrderId(int orderId);
    //插入LineItem
    void insertLine(Line line);
}
