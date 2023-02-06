package com.ticket.dao.impl;

import com.ticket.dao.OrderDao;
import com.ticket.pojo.Order;
import com.ticket.pojo.Train;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`train_id`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getTrain_id(),order.getUser_id());
    }

    @Override
    public int deleteOrderById(String order_id){
        String sql = "delete from t_order where order_id = ?";
        return update(sql, order_id);
    }

    @Override
    public List<Order> queryOrdersByuserId(Integer user_id) {
        String sql = "select * from t_order where user_id=?";
        return queryForList(Order.class,sql,user_id);
    }

    @Override
    public List<Order> queryOrdersBytrainId(Integer train_id) {
        String sql = "select * from t_order where train_id=?";
        return queryForList(Order.class,sql,train_id);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return queryForList(Order.class,sql);
    }



}
