package com.ticket.web;

import com.ticket.pojo.Train;
import com.ticket.pojo.Page;
import com.ticket.service.TrainService;
import com.ticket.service.impl.TrainServiceImpl;
import com.ticket.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TrainServlet extends BaseServlet{

    private TrainService trainService=new TrainServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Train train= WebUtils.copyParamToBean(req.getParameterMap(),new Train());
        trainService.addTrain(train);
        resp.sendRedirect(req.getContextPath()+"/manager/trainServlet?action=list");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        trainService.deleteTrainById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/trainServlet?action=list");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Train train=WebUtils.copyParamToBean(req.getParameterMap(),new Train());
        trainService.updateTrain(train);
        resp.sendRedirect(req.getContextPath()+"/manager/trainServlet?action=list");
    }

    protected void getTrain(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        Train train=trainService.queryTrainById(id);
        req.setAttribute("train",train);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void getTrain2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        Train train=trainService.queryTrainById(id);
        req.getSession().setAttribute("train",train);
        req.getRequestDispatcher("orderServlet?action=createOrder").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Train> trains = trainService.queryTrains();
        req.setAttribute("trains",trains);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Train> page = trainService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

        /*TrainService trainservice=new TrainServiceImpl();*/
        /*int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用TrainService.page(pageNo，pageSize)：Page对象
        Page<Train> trains = trainService.page(pageNo,pageSize);
        *//*trains.setUrl("web/trainServlet?action=page");*//*
        //3 保存Page对象到Request域中
        req.setAttribute("trains",trains);
        req.getRequestDispatcher("index.jsp").forward(req,resp);*/
    }
}
