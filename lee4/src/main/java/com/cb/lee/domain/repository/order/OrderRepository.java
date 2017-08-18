package com.cb.lee.domain.repository.order;

import java.util.List;

import com.cb.lee.domain.model.Order;

public interface OrderRepository {
	//通过用户名获取该用户所有订单
    List<Order> getOrdersByUsername(String username);
    //通过订单ID获取订单
    Order getOrder(int orderId);
    //插入订单
    void insertOrder(Order order);
}
