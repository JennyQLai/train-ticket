package com.ticket.service;


import com.ticket.pojo.Order;
import com.ticket.pojo.Train;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {


    public String createOrder(BigDecimal price, Integer trainId , Integer userId);
    public void deleteOrderById(String order_id);
    public List<Order> queryOrdersByuserId(Integer user_id);
    public List<Order> queryOrdersBytrainId(Integer train_id);
    public List<Order> queryOrders();
}
