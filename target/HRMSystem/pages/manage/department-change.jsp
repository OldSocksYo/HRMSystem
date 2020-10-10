<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/23
  Time: 23:24
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>department-change</title>
    <%@ include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="pages/static/css/manage.css">
    <style type="text/css">
        .text-input{
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        $(function (){
            $(":submit").click(function (){
                $.ajax({
                    url: "changeDepartment",
                    data: $("form").serialize(),
                    type: "post",
                    dataType: "json",
                    success: function (data){
                        if(data.changeFlag == "true"){
                            alert("修改成功");
                            window.location.href = "getDepartmentsFromCurrentPage";
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
        <br/>
        <form onsubmit="return false" class="information-operate">
            <span>部门信息编辑</span>
            <table class="information">
                <tr>
                    <td>部门id</td>
                    <td>部门名称</td>
                    <td>部门地址</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td>
                        <label><input class="text-input" type="text" name="id" value="${changeDepartment.id}" readonly="readonly"></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="name" value="${changeDepartment.name}"/></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="address" value="${changeDepartment.address}"/></label>
                    </td>
                    <td>
                        <label><input type="submit" value="提交"/></label>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>