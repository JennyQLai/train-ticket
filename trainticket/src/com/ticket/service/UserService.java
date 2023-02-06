package com.ticket.service;

import com.ticket.pojo.Train;
import com.ticket.pojo.User;

public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     */
    public User login(User user);

    /**
     * 检查手机号是否可用
     * @param phonenumber
     * @return 返回true表示手机号已存在，返回false表示手机号可用
     */
    public boolean existsPhonenumber(String phonenumber);

    public User queryUserById(Integer id);
}
