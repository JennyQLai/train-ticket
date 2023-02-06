package com.ticket.test;

import com.ticket.pojo.User;
import com.ticket.service.UserService;
import com.ticket.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService=new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"13861818115","123qwe","王五","433101199808021118"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"15358086404","123qwe",null,null)));
    }

    @Test
    public void existsPhonenumber() {
        if(userService.existsPhonenumber("15358086404")){
            System.out.println("手机号已存在");
        }else{
            System.out.println("手机号可用");
        }
    }

    @Test
    public void queryUserById() {
        System.out.println(userService.queryUserById(3) );
    }
}