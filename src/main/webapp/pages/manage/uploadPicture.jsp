<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/27
  Time: 19:48
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>uploadPicture</title>
    <%@ include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="pages/static/css/manage.css">
    <style type="text/css">
        .text-input{
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        $(function (){

            $.ajax({
                url: "uploadPic/getAllEmployees",
                //将发送给服务器的内容的编码类型
                contentType : 'application/json;charset=utf-8',
                type: 'get',
                //服务器返回的数据的类型
                dataType: 'json',
                success: function (data) {
                    //进入当前页面，便加载img标签的src为后端返回数据的第一个数据
                    $.ajax({
                        url: "uploadPic/getEmployeePic",
                        //发送给服务器的数据，JSON.stringify()将字符串转换成json格式的数据
                        data: "id=" + data[0].id,
                        //将发送给服务器的内容的编码类型
                        //  contentType : 'application/json;charset=utf-8',
                        type: 'post',
                        //服务器返回的数据的类型
                        dataType: 'json',
                        success: function (data) {
                            document.querySelector('#employeePic').src = data.imgUrl;
                            $(":submit").val("替换");
                        },
                        error: function () {
                            $(":submit").val("提交");
                            document.querySelector('#employeePic').src = data.imaUrl;
                        }
                    });
                    //动态生成option标签
                    // for (let value of data) {
                    data.forEach(function (value){
                        $("select[name=id]").append(
                            "<option value='" + value.id + "' >" +
                            value.id + "&nbsp;&nbsp;" + value.name +
                            "</option>"
                        );
                    });

                    // }
                    //当select标签改变之后将会触发的操作
                    $("select").change(function (e) {
                        $.ajax({
                            url: "uploadPic/getEmployeePic",
                            //发送给服务器的数据，JSON.stringify()将字符串转换成json格式的数据
                            data: "id=" + e.target.value,
                            //将发送给服务器的内容的编码类型
                            //  contentType : 'application/json;charset=utf-8',
                            type: 'post',
                            //服务器返回的数据的类型
                            dataType: 'json',
                            success: function (data) {
                                document.querySelector('#employeePic').src = data.imgUrl;
                                $(":submit").val("替换");
                            },
                            error: function () {
                                $(":submit").val("提交");
                                document.querySelector('#employeePic').src = data.imaUrl;
                            }
                        });
                    });
                }
            });
            $(":submit").click(function () {
                if($(":file").val() == ""){
                    alert("您还没有选择将要上传的照片");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<%@ include file="/pages/common/title-nav.jsp"%>
<div id="main">
    <%@ include file="/pages/common/left-nav.jsp"%>
    <div id="right">
        <form action="uploadPic/uploadPicture" method="post" enctype="multipart/form-data" class="information-operate">
            <span>上传员工照片</span>
            <table>
                <tr>
                    <td>id  name</td>
                    <td>选择员工图片</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td>
                        <label>
                            <select name="id">
                            </select>
                        </label>
                    </td>
                    <td>
                        <label><input class="text-input" type="file" name="picture" /></label>
                    </td>
                    <td>
                        <label><input type="submit" value="提交"/></label>
                    </td>
                </tr>
            </table>
        </form>
        <span id="errorMsg"></span>
        <img id="employeePic" style="width:60%;height: auto;margin: 20px 20%
" alt="选择员工，这里将显示已上传员工的图片">
    </div>
</div>
</body>
</html>
