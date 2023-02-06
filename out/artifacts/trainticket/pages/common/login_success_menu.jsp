<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021-03-25
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ include file="/pages/common/head.jsp"%>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.realname}</span> 光临铁路售票系统</span>
    <a style="color: #666666" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a style="color: #666666" href="index.jsp">返回</a>
</div>
</body>
</html>
