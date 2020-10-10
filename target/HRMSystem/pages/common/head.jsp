<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/20
  Time: 21:30
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%
    String basePath = request.getScheme()
    + "://"
    + request.getServerName()
    + ":"
    + request.getServerPort()
    + request.getContextPath()
    + "/";
    pageContext.setAttribute("basePath" ,basePath);
%>
<base href="<%=basePath%>" />
<script type="text/javascript" src="pages/static/js/jquery-3.4.1.js" ></script>
