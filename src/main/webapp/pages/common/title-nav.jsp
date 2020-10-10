<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/23
  Time: 21:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="nav">
    <span class="title-show">人力资源管理</span>
    <span class="user-show">
        <label>
            <%--window.location.href=this.value 当点击option时，跳转到option对应的value的地址 --%>
            <select onchange="window.location.href=this.value">
                <option value="javascript:void(0);" selected>${loginUser != null ?loginUser.username : ""}<img src="pages/static/images/箭头.png" alt="" /></option>
                <option value="logout">退出登录</option>
            </select>
        </label>
    </span>
</div>
