package com.cb.lee.domain.service.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.lee.domain.model.Flower;
import com.cb.lee.domain.model.Line;
import com.cb.lee.domain.model.Order;
import com.cb.lee.domain.repository.flower.FlowerRepository;
import com.cb.lee.domain.repository.item.LineRepository;
import com.cb.lee.domain.repository.order.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private FlowerRepository flowerRepository;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private LineRepository lineRepository;


    @Override
    @Transactional
    //把购买的商品部分插入到订单序列
    public void insertOrder(Order order) {
    	//更新商品库存
        for (int i = 0; i < order.getLine().size(); i++) {
            Line line = (Line) order.getLine().get(i);
            int flowerId = line.getFlowerId();
            Integer increment = new Integer(line.getQuantity());
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("flowerId", flowerId);
            param.put("increment", increment);
            flowerRepository.updateInventoryQuantity(param);
        }
        orderRepository.insertOrder(order);
        for (int i = 0; i < order.getLine().size(); i++) {
            Line line = (Line) order.getLine().get(i);
            line.setOrderId(order.getOrderId());
            lineRepository.insertLine(line);
        }
    }

    @Override
    @Transactional
    //通过订单ID获取订单
    public Order getOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        order.setLine(lineRepository.getLinesByOrderId(orderId));

        for (int i = 0; i < order.getLine().size(); i++) {
            Line line = (Line) order.getLine().get(i);
            Flower flower = flowerRepository.getFlowerByFlowerId(line.getFlowerId());
            flower.setQuantity(flowerRepository.getInventoryQuantity(line
                    .getFlowerId()));
            line.setFlower(flower);
        }
        return order;
    }
    
    @Override
    //通过用户名获取该用户所有订单
    public List<Order> getOrdersByUsername(String username) {
        return orderRepository.getOrdersByUsername(username);
    }
}
