<%@ page import="com.ticket.service.OrderService" %>
<%@ page import="com.ticket.service.impl.OrderServiceImpl" %>
<%@ page import="com.ticket.pojo.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ticket.pojo.User" %>
<%@ page import="com.ticket.pojo.Train" %>
<%@ page import="com.ticket.service.TrainService" %>
<%@ page import="com.ticket.service.impl.TrainServiceImpl" %>
<%@ page import="com.ticket.web.TrainServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@ include file="/pages/common/head.jsp"%>
	<SCRIPT LANGUAGE=javascript>
		function cancel() {
			var msg = "您真的确定要购买吗？\n\n请确认！";
			return confirm(msg) == true;
		}
	</SCRIPT>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	body{
		background-image: url(../../static/img/img.png);
		background-size: 100%,100%;
		background-repeat:no-repeat;
	}
	td{
		color: #272727;
		font-size: 19px;
	}
	a{
		color: #272727;
		font-size: 19px;
	}
</style>

</head>
<body bgcolor="#ccffff">
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>

	<div id="main">
		<div id="book">
			<table>
				<tr>
					<td>车次</td>
					<td>车次时间</td>
					<td>始发站/终点站</td>
					<td>价格</td>
					<td>下单时间</td>
					<td>操作</td>
				</tr>
				<%

					OrderService orderService = new OrderServiceImpl();
					User user = (User) request.getSession().getAttribute("user");
					List<Order> orders = orderService.queryOrdersByuserId(user.getId());

					for(int i=0;i<orders.size();i++){
						Order order=orders.get(i);
						TrainService trainService = new TrainServiceImpl();
						Train train = trainService.queryTrainById(order.getTrain_id());
				%>

				<tr>
						<td><%=train.getNumber()%></td>
						<td><%=train.getTime()%></td>
						<td><%=train.getTerminal()%></td>
						<td><%=order.getPrice()%></td>
						<td><%=order.getCreate_time()%></td>
						<td><a style="color: #666666" class="deleteClass" href="manager/orderServlet?action=delete&id=<%=order.getOrder_id()%>" onclick="javascript:return cancel()">取消订单</a></td>
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