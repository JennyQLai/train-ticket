<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑车次</title>
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
<body bgcolor="#ccffff">
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑车次</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/trainServlet" method="get">
				<input type="hidden" name="action" value="${empty param.id ? "add":"update"}"/>
				<input type="hidden" name="id" value="${requestScope.train.id}"/>

				<table>
					<tr>
						<td>车次</td>
						<td>价格</td>
						<td>始发站/终点站</td>
						<td>时间</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="number" type="text" value="${requestScope.train.number}"/></td>
						<td><input name="price" type="text" value="${requestScope.train.price}"/></td>
						<td><input name="terminal" type="text" value="${requestScope.train.terminal}"/></td>
						<td><input name="time" type="text" value="${requestScope.train.time}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>