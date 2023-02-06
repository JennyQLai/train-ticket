package com.ticket.dao;

import com.ticket.pojo.Train;
import com.ticket.pojo.User;

public interface UserDao {


    /**
     * 根据手机号查询用户信息
     * @param phonenumber
     * @return 如果返回null，说明没有这个用户
     */
    public User  queryUserByPhonenumber(String phonenumber);

    /**
     * 根据用户名和密码查询信息
     * @param phonenumber
     * @param password
     * @return 如果返回null，说明手机号或者密码错误
     */
    public User  queryUserByPhonenumberAndPassword(String phonenumber,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

    public User queryUserById(Integer id);

}
