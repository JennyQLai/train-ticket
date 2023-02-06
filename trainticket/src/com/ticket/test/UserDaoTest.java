package com.ticket.test;

import com.ticket.dao.UserDao;
import com.ticket.dao.impl.UserDaoImpl;
import com.ticket.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByPhonenumber() {
        if(userDao.queryUserByPhonenumber("15358086404")==null){
            System.out.println("手机号可用！");
        }else{
            System.out.println("手机号已存在！");
        }
        //System.out.println(userDao.queryUserByPhonenumber("15358086404"));
    }

    @Test
    public void queryUserByPhonenumberAndPassword() {
        if(userDao.queryUserByPhonenumberAndPassword("15358086404","123qwe")==null){
            System.out.println("手机号或密码错误");
        }else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"13861800985","123qwe","李四","370602200006162111")));
    }

    @Test
    public void queryUserById() {
        System.out.println(userDao.queryUserById(1));
    }
}