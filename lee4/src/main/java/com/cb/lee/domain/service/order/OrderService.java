package com.cb.lee.domain.service.order;

import java.util.List;

import com.cb.lee.domain.model.Order;

public interface OrderService {
	/**插入订单*/
    void insertOrder(Order order);
    /**通过订单ID获取订单对象*/
    Order getOrder(int orderId);
    /**通过用户名获取该用户所有订单对象*/
    List<Order> getOrdersByUsername(String username);


}
