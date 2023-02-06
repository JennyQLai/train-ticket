package com.ticket.dao.impl;

import com.ticket.dao.UserDao;
import com.ticket.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByPhonenumber(String phonenumber) {
        String sql="select `id`,`phonenumber`,`password`,`realname`,`IDnumber` from t_user where phonenumber=?";
        return queryForOne(User.class,sql,phonenumber);
    }

    @Override
    public User queryUserByPhonenumberAndPassword(String phonenumber, String password) {
        String sql="select `id`,`phonenumber`,`password`,`realname`,`IDnumber` from t_user where phonenumber=? and password=?";
        return queryForOne(User.class,sql,phonenumber,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(`phonenumber`,`password`,`realname`,`IDnumber`) VALUES (?,?,?,?)";
        return update(sql,user.getPhonenumber(),user.getPassword(),user.getRealname(),user.getIDnumber());
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select * from t_user where id=?";
        return queryForOne(User.class,sql,id);
    }
}
