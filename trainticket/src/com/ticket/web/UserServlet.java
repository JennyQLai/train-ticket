package com.ticket.web;

import com.ticket.pojo.User;
import com.ticket.service.UserService;
import com.ticket.service.impl.UserServiceImpl;
import com.ticket.utils.WebUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, phonenumber, password, null, null));
        if (loginUser == null) {
            req.setAttribute("msg", "手机号或密码错误！");
            req.setAttribute("phonenumber", phonenumber);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录 成功
            // 保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String realname = req.getParameter("realname");
        String IDnumber = req.getParameter("IDnumber");
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsPhonenumber(phonenumber)) {
                System.out.println("手机号[" + phonenumber + "]已存在");
                req.setAttribute("msg", "手机号已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(new User(null, phonenumber, password, realname, IDnumber));
                /*req.getSession().setAttribute("user", registU);*/
                /*req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);*/
                PrintWriter out=resp.getWriter();
                out.print("<script> alert('register successfully!login here'); window.location.href='pages/user/login.jsp'; </script>");
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("phonenumber", phonenumber);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
