package com.ticket.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
public class Order {
    private String order_id;
    private Date create_time;
    private BigDecimal price;
    private Integer train_id;
    private Integer user_id;

    public Order(String orderId, Date createTime, BigDecimal price, Integer trainId, Integer userId) {
        this.order_id = orderId;
        this.create_time = createTime;
        this.price = price;
        this.train_id =trainId;
        this.user_id = userId;
    }

    public Order() {

    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String orderId) {
        this.order_id = orderId;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date createTime) {
        this.create_time = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer trainId) {
        this.train_id = trainId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer userId) {
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + order_id + '\'' +
                ", createTime=" + create_time +
                ", price=" + price +
                ", trainId=" + train_id +
                ", userId=" + user_id +
                '}';
    }
}
