<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/23
  Time: 23:13
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>department-main</title>
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
            let pageNum = ${requestScope.departmentPageInfo.pageNum};
            let total = ${requestScope.departmentPageInfo.total};
            let pageSize = 9;
            myPagination(pageNum, total, pageSize, "getDepartments");


            $("a[title=change]").click(function (){
                const id = $(this).parent().parent().find("td:first").text();
                window.location.href = "getDepartment?id=" + id;
            });
            $("a[title=delete]").click(function (){
                const id = $(this).parent().parent().find("td:first").text();
                const name = $(this).parent().parent().find("td:eq(1)").text();
                if(confirm("确认删除" + name + "部门吗？")){
                    $.ajax({
                        url: "deleteDepartment",
                        data: "id=" + id,
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            if(data.deleteFlag == "true"){
                                alert("删除成功！");
                                window.location.href =  "getDepartmentsFromCurrentPage"
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
                <td>部门id</td>
                <td>部门名称</td>
                <td>部门地址</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach items="${requestScope.departmentPageInfo.list}" var="department">
                <tr>
                    <td>${department.id}</td>
                    <td>${department.name}</td>
                    <td>${department.address}</td>
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
