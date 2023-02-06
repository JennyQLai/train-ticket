<%@ page import="com.ticket.service.OrderService" %>
<%@ page import="com.ticket.service.impl.OrderServiceImpl" %>
<%@ page import="com.ticket.pojo.User" %>
<%@ page import="com.ticket.pojo.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ticket.service.TrainService" %>
<%@ page import="com.ticket.pojo.Train" %>
<%@ page import="com.ticket.service.impl.TrainServiceImpl" %>
<%@ page import="com.ticket.web.UserServlet" %>
<%@ page import="com.ticket.service.UserService" %>
<%@ page import="com.ticket.service.impl.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%@ include file="/pages/common/head.jsp"%>
	<SCRIPT LANGUAGE=javascript>
		function cancel() {
			var msg = "您真的确定要购买吗？\n\n请确认！";
			return confirm(msg) == true;
		}
	</SCRIPT>
</head>
<body bgcolor="#ccffff">
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<div id="book">
			<table>
				<tr>
					<td>订单号</td>
					<td>购票人</td>
					<td>身份证号</td>
					<td>车次</td>
					<td>始发站/终点站</td>
					<td>车次时间</td>
					<td>价格</td>
					<td>下单时间</td>
					<td>操作</td>
				</tr>
				<%

					OrderService orderService = new OrderServiceImpl();
					List<Order> orders = orderService.queryOrders();

					for(int i=0;i<orders.size();i++){
						Order order=orders.get(i);
						TrainService trainService = new TrainServiceImpl();
						Train train = trainService.queryTrainById(order.getTrain_id());
						UserService userService = new UserServiceImpl();
						User user = userService.queryUserById(order.getUser_id());
				%>

				<tr>
					<td><%=order.getOrder_id()%></td>
					<td><%=user.getRealname()%></td>
					<td><%=user.getIDnumber()%></td>
					<td><%=train.getNumber()%></td>
					<td><%=train.getTerminal()%></td>
					<td><%=train.getTime()%></td>
					<td><%=order.getPrice()%></td>
					<td><%=order.getCreate_time()%></td>
					<td><a style="color: #666666 "class="deleteClass" href="manager/orderServlet?action=delete1&id=<%=order.getOrder_id()%>" onclick="javascript:return cancel()">取消订单</a></td>
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