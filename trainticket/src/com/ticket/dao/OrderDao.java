package com.ticket.dao;

import com.ticket.pojo.Order;
import com.ticket.pojo.Train;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);
    public int deleteOrderById(String order_id);
    public List<Order> queryOrdersByuserId(Integer user_id);
    public List<Order> queryOrdersBytrainId(Integer train_id);
    public List<Order> queryOrders();

}
