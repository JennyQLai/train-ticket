package com.ticket.web;

import com.ticket.pojo.User;
import com.ticket.service.UserService;
import com.ticket.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String realname = req.getParameter("realname");
        String IDnumber = req.getParameter("IDnumber");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsPhonenumber(phonenumber)) {
                System.out.println("手机号[" + phonenumber + "]已存在");
                req.setAttribute("msg","手机号已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(new User(null, phonenumber, password, realname, IDnumber));
                PrintWriter out=resp.getWriter();
                out.print("<script> alert('register successfully!login here'); window.location.href='pages/user/login.jsp'; </script>");
            }
        } else {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("phonenumber",phonenumber);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
