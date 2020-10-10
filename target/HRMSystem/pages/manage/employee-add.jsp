<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/22
  Time: 16:25
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>employee-add</title>
    <%@ include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="pages/static/css/manage.css">
    <style type="text/css">
        .text-input{
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        $(function (){

            $("input[name=departmentId]").blur(function () {
                $.ajax({
                    url: "isExistDepartment",
                    data: "id=" + $("input[name=departmentId]").val(),
                    dataType: 'json',
                    success: function (data) {
                        if(data.isExist == "false"){
                            $("#errorMsg").text("该部门不存在");
                            $(":submit").attr("disabled","disabled");
                        }else {
                            $("#errorMsg").text(" ");
                            $(":submit").removeAttr("disabled");
                        }
                    }
                });
            });

            $(":submit").click(function (){
                // let arrObj = {};
                // //转js对象
                // $.each($("form").serializeArray(), function (i, val){
                //     arrObj[val.name] = val.value;
                // });
                $.ajax({
                    url: "addEmployee",
                    //发送给服务器的数据，JSON.stringify()将字符串转换成json格式的数据JSON.stringify(arrObj)
                    data: $("form").serialize(),
                    // //将发送给服务器的内容的编码类型
                    // contentType : 'application/json;charset=utf-8',
                    type: 'post',
                    //服务器返回的数据的类型
                    dataType: 'json',
                    success: function (data) {
                        if(data.addFlag == "true"){
                            $("#right").html(
                                "<span style='font-size: 20px;color:red;'>添加成功！</span>");
                        }else {
                            alert("添加失败");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<%@ include file="/pages/common/title-nav.jsp"%>
<div id="main">
    <%@ include file="/pages/common/left-nav.jsp"%>
    <div id="right">
        <form onsubmit="return false" class="information-operate">
            <span>添加员工</span>
            <table>
                <tr>
                    <td>所属部门id</td>
                    <td>员工姓名</td>
                    <td>员工性别</td>
                    <td>电话号码</td>
                    <td>邮箱</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td>
                        <label><input class="text-input" type="text" name="departmentId" /></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="name" /></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="sex" /></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="phoneNumber" /></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="email" /></label>
                    </td>
                    <td>
                        <label><input type="submit" value="提交"/></label>
                    </td>
                </tr>
            </table>
        </form>
        <span id="errorMsg" style="color: red; font-size: 20px;"> </span>
    </div>
</div>
</body>
</html>
