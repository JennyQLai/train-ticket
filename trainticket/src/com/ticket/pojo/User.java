package com.ticket.pojo;

public class User {
    private Integer id;
    private String phonenumber;
    private String password;
    private String realname;
    private String IDnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", IDnumber='" + IDnumber + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String phonenumber, String password, String realname, String IDnumber) {
        this.id = id;
        this.phonenumber = phonenumber;
        this.password = password;
        this.realname = realname;
        this.IDnumber = IDnumber;
    }
}
