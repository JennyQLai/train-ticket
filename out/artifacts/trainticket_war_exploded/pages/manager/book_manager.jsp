<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车次管理</title>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function () {
			//给删除的a标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】?");
			});
		});

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">车次管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>车次</td>
				<td>价格</td>
				<td>始发站/终点站</td>
				<td>时间</td>
				<td colspan="3">操作</td>
			</tr>
			<c:forEach items="${requestScope.trains}" var="train">
				<tr>
					<td>${train.number}</td>
					<td>${train.price}</td>
					<td>${train.terminal}</td>
					<td>${train.time}</td>
					<td><a href="manager/orderServlet?action=list2&train_id=${train.id}">车票管理</a></td>
					<td><a href="manager/trainServlet?action=getTrain&id=${train.id}">修改</a></td>
					<td><a class="deleteClass" href="manager/trainServlet?action=delete&id=${train.id}">删除</a></td>
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
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>