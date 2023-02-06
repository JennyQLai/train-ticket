package com.ticket.test;

import com.ticket.dao.OrderDao;
import com.ticket.dao.impl.OrderDaoImpl;
import com.ticket.pojo.Order;
import com.ticket.pojo.Train;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("12345678910", new Date(), new BigDecimal(100), 2, 1));

    }
    @Test
    public void deleteOrderById() {
        orderDao.deleteOrderById("12345678910");
    }

    @Test
    public void queryOrdersByuserId() {
        for (Order queryOrder : orderDao.queryOrdersByuserId(2)) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void queryOrdersBytrainId() {
        for (Order queryOrder : orderDao.queryOrdersBytrainId(5)) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void queryOrders() {
        for(Order queryOrder : orderDao.queryOrders()){
            System.out.println(queryOrder);
        }
    }
}