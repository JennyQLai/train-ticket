<%@ page import="com.ticket.pojo.Train" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ticket.pojo.Train,com.ticket.service.TrainService"%>
<%@ page import="com.ticket.service.impl.TrainServiceImpl" %>
<%@ page import="com.ticket.utils.WebUtils" %>
<%@ page import="com.ticket.pojo.Page" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="pages/common/head.jsp"%>
	<meta charset="UTF-8">
	<title>火车购票系统首页</title>


	<SCRIPT LANGUAGE=javascript>
		function buy() {
			var msg = "您真的确定要购买吗？\n\n请确认！";
			return confirm(msg) == true;
		}
	</SCRIPT>

</head>
<style type="text/css">
	body{
		background-image: url(static/img/img.png);
		background-size:contain;
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
<body>

<div id="header">
	<%--<img class="logo_img" alt="" src="static/img/.jpg" >--%>
	<span class="wel_word">火车售票系统</span>
	<div>
		<%--如果用户还没有登录，显示     【登录 和注册的菜单】 --%>
		<c:if test="${empty sessionScope.user}">
			<a style="color: #666666" href="pages/user/login.jsp">登录</a>
			<a style="color: #666666" href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
		</c:if>
		<%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
		<c:if test="${not empty sessionScope.user}">
			<span>欢迎<span class="um_span">${sessionScope.user.realname}</span>登录火车售票系统</span>
			<a style="color: #666666" href="pages/order/order.jsp">我的订单</a>
			<a style="color: #666666" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
		</c:if>
			<c:if test="${ sessionScope.user.password eq 'admin' }">
				<a  style="color: #666666" href="pages/manager/manager.jsp">后台管理</a>
			</c:if>
	</div>
</div>
<div id="main">
	<div id="book">
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
				/*List<Train> trains = trainservice.queryTrains();
				request.setAttribute("trains",trains);*/
				int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
				int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
				//2 调用TrainService.page(pageNo，pageSize)：Page对象
				Page<Train> trains = trainservice.page(pageNo,pageSize);
				/*page.setUrl("manager/bookServlet?action=page");*/
				//3 保存Page对象到Request域中
				request.setAttribute("trains",trains);
			%>
			<c:forEach items="${requestScope.trains.items}" var="train">
				<tr>
					<td>${train.number}</td>
					<td>${train.price}</td>
					<td>${train.terminal}</td>
					<td>${train.time}</td>

						<%--如果用户还没有登录，跳转 【登录】--%>
					<c:if test="${empty sessionScope.user}">
						<td colspan="2"><a style="color: #666666" href="pages/user/login.jsp">购买</a></td>
					</c:if>
						<%--如果已经登录，则直接提交订单。--%>
					<c:if test="${not empty sessionScope.user}">
						<%--<span>欢迎<span class="um_span">${sessionScope.user.realname}</span>登录火车售票系统</span>
                        <a href="pages/order/order.jsp">我的订单</a>
                        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;--%>
						<td colspan="2"><a style="color: #666666" href="manager/trainServlet?action=getTrain2&id=${train.id}" onclick="javascript:return buy()">购买</a></td>
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
				<td>&nbsp</td>
			</tr>
		</table>

		<div id="page_nav" style="">
			<a href="#">首页</a>
			<a href="#">上一页</a>
			<a href="#">&nbsp</a>
			【${trains.pageNo}】
			<a href="#">2</a>
			<a href="#">下一页</a>
			<a href="#">末页</a>
			共${ trains.pageTotal }页 ，${ trains.pageTotalCount }条记录&nbsp
			到第<input value="1" name="pn" id="pn_input"/>页
			<input type="button" value="确定">
		</div>

	</div>
	</div>

	<%@include file="pages/common/footer.jsp"%>
</body>
</html>