<%@ page import="com.ticket.pojo.Train" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ticket.pojo.Train,com.ticket.service.TrainService"%>
<%@ page import="com.ticket.service.impl.TrainServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>火车购票系统首页</title>
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >

	<%--<script type="text/javascript">

		$(function () {
			//给删除的a标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】?");
			});
		});

	</script>--%>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">火车售票系统</span>
	<div>
		<%--如果用户还没有登录，显示     【登录 和注册的菜单】 --%>
		<c:if test="${empty sessionScope.user}">
			<a href="pages/user/login.jsp">登录</a>
			<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
		</c:if>
		<%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
		<c:if test="${not empty sessionScope.user}">
			<span>欢迎<span class="um_span">${sessionScope.user.realname}</span>登录火车售票系统</span>
			<a href="pages/order/order.jsp">我的订单</a>
			<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
		</c:if>
		<a href="pages/cart/cart.jsp">购物车</a>
		<a href="pages/manager/manager.jsp">后台管理</a>
	</div>
</div>
<div id="main">
	<div id="book">
		<div class="book_cond">
			<form action="" method="get">
				价格：<input id="min" type="text" name="min" value=""> 元 -
				<input id="max" type="text" name="max" value=""> 元
				<input type="submit" value="查询" />
			</form>
		</div>
		<table>
			<tr>
				<td>车次</td>
				<td>价格</td>
				<td>始发站/终点站</td>
				<td>时间</td>
				<td colspan="2">操作</td>
			</tr>
			<%
				TrainService trainservice=new TrainServiceImpl();
				List<Train> trains = trainservice.queryTrains();
				request.setAttribute("trains",trains);
			%>
			<c:forEach items="${requestScope.trains}" var="train">
				<tr>
					<td>${train.number}</td>
					<td>${train.price}</td>
					<td>${train.terminal}</td>
					<td>${train.time}</td>

						<%--如果用户还没有登录，跳转 【登录】--%>
					<c:if test="${empty sessionScope.user}">
						<td colspan="2"><a href="pages/user/login.jsp">购买</a></td>
					</c:if>
						<%--如果已经登录，则直接提交订单。--%>
					<c:if test="${not empty sessionScope.user}">
						<%--<span>欢迎<span class="um_span">${sessionScope.user.realname}</span>登录火车售票系统</span>
                        <a href="pages/order/order.jsp">我的订单</a>
                        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;--%>
						<td><a href="manager/trainServlet?action=getTrain2&id=${train.id}">购买</a></td>
					</c:if>
						<%--<td><a href="manager/trainServlet?action=getTrain&id=${train.id}">修改</a></td>
						<td><a class="deleteClass" href="manager/trainServlet?action=delete&id=${train.id}">删除</a></td>--%>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加车次</a></td>
			</tr>
		</table>

		<div id="page_nav" style="">
			<a href="#">首页</a>
			<a href="#">上一页</a>
			<a href="#">3</a>
			【4】
			<a href="#">5</a>
			<a href="#">下一页</a>
			<a href="#">末页</a>
			共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
			<input type="button" value="确定">
		</div>

	</div>

	<%@include file="pages/common/footer.jsp"%>
</body>
</html>