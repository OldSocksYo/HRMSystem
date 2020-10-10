<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/24
  Time: 16:29
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>department-add</title>
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
                    url: "addDepartment",
                    data: $("form").serialize(),
                    type: 'post',
                    //服务器返回的数据的类型
                    dataType: 'json',
                    success: function (data) {
                        if(data.addFlag == "true"){
                            alert("添加成功");
                            $("#right").html(
                                "<span style='font-size: 20px;color:red;'>添加成功！</span>"
                            );
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
            <span>添加部门</span>
            <table>
                <tr>
                    <td>部门名称</td>
                    <td>部门地址</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td>
                        <label><input class="text-input" type="text" name="name" /></label>
                    </td>
                    <td>
                        <label><input class="text-input" type="text" name="address" /></label>
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

