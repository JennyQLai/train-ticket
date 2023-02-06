package com.ticket.service.impl;


import com.ticket.dao.OrderDao;
import com.ticket.dao.impl.OrderDaoImpl;
import com.ticket.pojo.*;
import com.ticket.service.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> queryOrdersByuserId(Integer user_id) {
        return orderDao.queryOrdersByuserId(user_id);
    }

    @Override
    public List<Order> queryOrdersBytrainId(Integer train_id) {
        return orderDao.queryOrdersBytrainId(train_id);
    }

    @Override
    public void deleteOrderById(String order_id) {
        orderDao.deleteOrderById(order_id);
    }

    @Override
    public String createOrder(BigDecimal price, Integer trainId, Integer userId) {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(),price,trainId,userId);
        // 保存订单
        orderDao.saveOrder(order);

        return orderId;
    }

    @Override
    public List<Order> queryOrders() {
        return  orderDao.queryOrders();
    }
}
