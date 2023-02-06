package com.ticket.test;

import com.ticket.pojo.Order;
import com.ticket.service.OrderService;
import com.ticket.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private OrderService orderService=new OrderServiceImpl();
    @Test
    public void createOrder() {
        OrderService orderService =new OrderServiceImpl();
        System.out.println("订单号是：" + orderService.createOrder(BigDecimal.valueOf(88),2,1));
    }

    @Test
    public void deleteOrderById() {
        orderService.deleteOrderById( "16184006507631");
    }

    @Test
    public void queryOrdersByuserId() {

        for (Order queryOrder : orderService.queryOrdersByuserId(1)) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void queryOrdersBytrainId() {

        for (Order queryOrder : orderService.queryOrdersBytrainId(2)) {
            System.out.println(queryOrder);
        }
    }

    @Test
    public void queryOrders() {
        for (Order queryOrder : orderService.queryOrders()) {
            System.out.println(queryOrder);
        }
    }
}