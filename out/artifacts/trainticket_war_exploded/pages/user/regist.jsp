<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>铁路账号注册页面</title>
    <%@ include file="../common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                var phonenumberText = $("#phonenumber").val();
                var phonenumberPatt = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
                if (!phonenumberPatt.test(phonenumberText)) {
                    $("span.errorMsg").text("手机号不合法");
                    return false;
                }
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordText)) {
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }
				var realnameText = $("#realname").val();
				var realnamePatt = /^([a-zA-Z0-9\u4e00-\u9fa5\·]{1,10})$/;
				if (!realnamePatt.test(realnameText)) {
					$("span.errorMsg").text("真实姓名不合法");
					return false;
				}
				var IDnumberText = $("#IDnumber").val();
				var IDnumberPatt = /^([1-6][1-9]|50)\d{4}(18|19|20)\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
				if (!IDnumberPatt.test(IDnumberText)) {
					$("span.errorMsg").text("身份证号不合法");
					return false;
				}
                var codeText = $("#code").val();
                //去掉验证码前后空格
                codeText = $.trim(codeText);
                if (codeText == null || codeText == "") {
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册铁路账号</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>手机号码：</label>
                        <input class="itxt" type="text" placeholder="请输入电话号码" autocomplete="off" tabindex="1"
                               value="<%=request.getAttribute("phonenumber")==null?"":request.getAttribute("phonenumber")%>"
                               name="phonenumber" id="phonenumber"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
						<label>真实姓名：</label>
						<input class="itxt" type="text" placeholder="请输入真实姓名" autocomplete="off" tabindex="1"
							   name="realname" id="realname"/>
						<br/>
						<br/>
                        <label>身份证号：</label>
                        <input class="itxt" type="text" placeholder="请输入身份证号" autocomplete="off" tabindex="1"
                               name="IDnumber" id="IDnumber"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
                        <img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>