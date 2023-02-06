package com.ticket.web;

import com.ticket.pojo.User;
import com.ticket.service.UserService;
import com.ticket.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, phonenumber, password, null, null));
        if(loginUser==null){
            req.setAttribute("msg","手机号或密码错误！");
            req.setAttribute("phonenumber",phonenumber);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
