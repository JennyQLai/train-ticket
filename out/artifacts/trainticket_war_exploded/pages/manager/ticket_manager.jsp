<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ticket.service.OrderService" %>
<%@ page import="com.ticket.service.impl.OrderServiceImpl" %>
<%@ page import="com.ticket.pojo.User" %>
<%@ page import="com.ticket.pojo.Order" %>
<%@ page import="com.ticket.service.TrainService" %>
<%@ page import="com.ticket.pojo.Train" %>
<%@ page import="com.ticket.service.impl.TrainServiceImpl" %>
<%@ page import="com.ticket.service.UserService" %>
<%@ page import="com.ticket.service.impl.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>车票管理</title>
    <%@ include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: #ff0000;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
            <%
                String str= (String) request.getAttribute("id");
                int train_id=Integer.parseInt(str);
                TrainService trainService = new TrainServiceImpl();
                Train train = trainService.queryTrainById(train_id);
            %>
<div id="header">

    <img class="logo_img" alt="" src="../../static/img/logo.gif" >
    <span class="wel_word"><%=train.getNumber()%>车次车票管理</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <div id="book">
        <table>
            <tr>
                <td>车次</td>
                <td>购票人</td>
                <td>身份证号</td>
                <td>电话号</td>
                <td>票价</td>
                <td>下单时间</td>
            </tr>
            <%

                OrderService orderService = new OrderServiceImpl();
                List<Order> orders = orderService.queryOrdersBytrainId(train_id);
                for(int i=0;i<orders.size();i++){
                    Order order=orders.get(i);
                    UserService userService = new UserServiceImpl();
                    User user = userService.queryUserById(order.getUser_id());
            %>

            <tr>
                <td><%=train.getNumber()%></td>
                <td><%=user.getRealname()%></td>
                <td><%=user.getIDnumber()%></td>
                <td><%=user.getPhonenumber()%></td>
                <td><%=order.getPrice()%></td>
                <td><%=order.getCreate_time()%></td>
                <td><a class="deleteClass" href="manager/orderServlet?action=delete2&id=<%=order.getOrder_id()%>&train_id=<%=order.getTrain_id().toString()%>">取消订单</a></td>
            </tr>

            <%
                }
            %>

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
