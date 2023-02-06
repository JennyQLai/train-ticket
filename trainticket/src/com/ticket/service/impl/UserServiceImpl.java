package com.ticket.service.impl;

import com.ticket.dao.UserDao;
import com.ticket.dao.impl.UserDaoImpl;
import com.ticket.pojo.User;
import com.ticket.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByPhonenumberAndPassword(user.getPhonenumber(),user.getPassword());
    }

    @Override
    public boolean existsPhonenumber(String phonenumber) {
        if(userDao.queryUserByPhonenumber(phonenumber)==null){
            return false;
        }
        return true;
    }

    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }
}
