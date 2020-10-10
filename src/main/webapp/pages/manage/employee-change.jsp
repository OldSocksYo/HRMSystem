<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/22
  Time: 11:29
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>employee-change</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script src="pages/static/js/myPagination.js" type="text/javascript"></script>
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
                $.ajax({
                    url: "changeEmployee",
                    data: $("form").serialize(),
                    type: "post",
                    dataType: "json",
                    success: function (data){
                        if(data.changeFlag == "true"){
                            alert("修改成功");
                            window.location.href = "getEmployeesFromCurrentPage";
                        }else {
                            alert("修改失败！");
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
            <span>员工信息编辑</span>
            <table>
                <tr>
                    <td>员工id</td>
                    <td>所属部门id</td>
                    <td>员工姓名</td>
                    <td>员工性别</td>
                    <td>电话号码</td>
                    <td>邮箱</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td>
                        <label><input class="text-input" type="text" name="id" value="${changeEmployee.id}" readonly="readonly"></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="departmentId" value="${changeEmployee.departmentId}"/></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="name" value="${changeEmployee.name}"/></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="sex" value="${changeEmployee.sex}"/></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="phoneNumber" value="${changeEmployee.phoneNumber}"/></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="email" value="${changeEmployee.email}"/></label>
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
