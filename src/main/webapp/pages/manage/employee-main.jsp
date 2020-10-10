<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/23
  Time: 21:49
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>employee-manage</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript" src="pages/static/js/myPagination.js"></script>
    <script type="text/javascript" src="pages/static/js/jquery.pagination.js" ></script>
    <link rel="stylesheet" href="pages/static/css/manage.css">
    <link rel="stylesheet" type="text/css" href="pages/static/css/pagination.css">
    <script type="text/javascript">
        $(function (){
            /**
             * 分页设置
             * pageNum 当前页
             * total 数据总数量
             * pageSize 每页的数据的大小
             */
            let pageNum = ${requestScope.employeePageInfo.pageNum};
            let total = ${requestScope.employeePageInfo.total};
            let pageSize = 9;
            myPagination(pageNum, total, pageSize, "getEmployees");


            $("a[title=change]").click(function (){
                const id = $(this).parent().parent().find("td:first").text();
                window.location.href = "getEmployee?id=" + id;
            });
            $("a[title=delete]").click(function (){
                const id = $(this).parent().parent().find("td:first").text();
                const name = $(this).parent().parent().find("td:eq(2)").text();
                if(confirm("确认删除" + name + "吗？")){
                    $.ajax({
                       url: "deleteEmployee",
                       data: "id=" + id,
                       type: "post",
                       dataType: "json",
                       success: function (data) {
                           if(data.deleteFlag == "true"){
                               alert("删除成功！");
                               window.location.href =  "getEmployeesFromCurrentPage"
                           }else {
                               alert("删除失败！");
                           }
                       }
                    });

                }else {
                    alert("已取消");
                    return false;
                }
            });
        })
    </script>
</head>
<body>
<%@ include file="/pages/common/title-nav.jsp"%>
<div id="main">
    <%@ include file="/pages/common/left-nav.jsp"%>
    <div id="right">
        <table class="information">
            <tr>
                <td>员工id</td>
                <td>所属部门id</td>
                <td>员工姓名</td>
                <td>员工性别</td>
                <td>电话号码</td>
                <td>邮箱</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.employeePageInfo.list}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.departmentId}</td>
                    <td>${employee.name}</td>
                    <td>${employee.sex}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.email}</td>
                    <td><a title="change" href="javascript:void(0)">修改</a></td>
                    <td><a title="delete" href="javascript:void(0)">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <div class="pagination-box"></div>
    </div>
</div>
</body>
</html>
