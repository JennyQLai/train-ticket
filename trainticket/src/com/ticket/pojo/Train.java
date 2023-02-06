package com.ticket.pojo;

import java.math.BigDecimal;

public class Train {
    private Integer id;
    private String number;
    private BigDecimal price;
    private String terminal;
    private String time;

    public Train() {
    }

    public Train(Integer id, String number, BigDecimal price, String terminal, String time) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.terminal = terminal;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", terminal='" + terminal + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
