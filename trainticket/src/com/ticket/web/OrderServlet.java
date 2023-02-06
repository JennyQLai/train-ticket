package com.ticket.web;


import com.ticket.pojo.Order;
import com.ticket.pojo.Train;
import com.ticket.pojo.User;
import com.ticket.service.OrderService;
import com.ticket.service.impl.OrderServiceImpl;
import com.ticket.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();
    Integer train_id;
    int flag=0;
    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取price,trainid
        Train traindetial = (Train) req.getSession().getAttribute("train");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        BigDecimal price = traindetial.getPrice();
        Integer trainId = traindetial.getId();
        Integer userId = loginUser.getId();
//        调用orderService.createOrder;生成订单
        String orderId = orderService.createOrder(price,trainId, userId);

//        req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String order_id= String.valueOf(WebUtils.parseInt(req.getParameter("order_id"),0));
        String order_id = req.getParameter("id");
        orderService.deleteOrderById(order_id);
        resp.sendRedirect(req.getContextPath()+"/manager/orderServlet?action=list");
    }

    protected void delete1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String order_id= String.valueOf(WebUtils.parseInt(req.getParameter("order_id"),0));
        String order_id = req.getParameter("id");
        orderService.deleteOrderById(order_id);
        resp.sendRedirect(req.getContextPath()+"/manager/orderServlet?action=list1");
    }

    protected void delete2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String order_id= String.valueOf(WebUtils.parseInt(req.getParameter("order_id"),0));
        String order_id = req.getParameter("id");
        orderService.deleteOrderById(order_id);
        train_id = WebUtils.parseInt(req.getParameter("train_id"),0);
        flag=1;
        resp.sendRedirect(req.getContextPath()+"/manager/orderServlet?action=list2");
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = WebUtils.parseInt(req.getParameter("user_id"),0);
        List<Order> orders = orderService.queryOrdersByuserId(user_id);
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    protected void list1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.queryOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    protected void list2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (flag==0)
        train_id = WebUtils.parseInt(req.getParameter("train_id"),0);
        flag=0;
        req.setAttribute("id",train_id.toString());
        req.getRequestDispatcher("/pages/manager/ticket_manager.jsp").forward(req,resp);
    }
}
