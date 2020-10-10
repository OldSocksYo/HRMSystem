<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/20
  Time: 21:13
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <%@ include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="pages/static/css/login.css">
    <script type="text/javascript">
        $(function (){
            //给验证码图片绑定点击事件
            $("#codeImg").click(function (){
                //在function中有一个this对象，表示当前正在响应的dom对象
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });
            //给提交按钮设置点击事件
            $("input.sub-input").eq(0).click(function (){
                // alert("提交");
                /*
                * var:定义的变量可以修改，不初始化值为undefined，不会报错
                * let:定义的变量不会对函数外部有影响，是块级作用域
                * const:定义的变量不可修改，并且必须初始化，否则报错
                * */
                //获取去除前后空格后的用户名，密码，验证码
                let username = $("input.main-input:eq(0)").val().trim();
                let password = $("input.main-input:eq(1)").val().trim();
                let code = $("input.code-input:eq(0)").val().trim();

                if(username == null || username == "" || password == null || password == ""){
                    $("#errorDiv").text("用户名或者密码不能为空");
                    return false;
                }
                if(code == null || code == ""){
                    $("#errorDiv").text("验证码不能为空");
                    return false;
                }
                return true;
            });

            //当点击输入框时，清空错误信息
            $("input:lt(3)").click(function (){
                $("#errorDiv").text(" ");
            });

        });
    </script>
</head>
<body>
<div class="login-box">
    <div>
        <h2>人力资源管理系统</h2>
    </div>
    <form action="login" method="POST">
        <div>
            <label>
                <input class="main-input" type="text" placeholder="请输入用户名" name="username" value="${username}" />
            </label>
        </div>
        <div>
            <label>
                <input class="main-input" type="password" placeholder="请输入密码" name="password" />
            </label>
        </div>
        <div>
            <label>
                <input class="code-input" type="text" placeholder="验证码" name="code" />
            </label>
            <a href="javascript:void(0);" title="看不清？点击换一个"><img id="codeImg" src="kaptcha.jpg" style="width: 25%;height: 33px;vertical-align: middle;"  alt=""/></a>
        </div>
        <input class="sub-input" type="submit" value="登录" />
    </form>
    <div id="errorDiv" style="color: red; font-size: 18px;">${errorMsg}</div>
</div>
</body>
</html>
