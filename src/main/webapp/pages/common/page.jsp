<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/9/22
  Time: 19:27
--%>
<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2020/7/8
  Time: 9:19
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<%--分页导航栏开始部分--%>
<div id="page_nav">
    <%--当前不是出于第一页，才显示--%>
    <c:if test="${requestScope.employeePageInfo.pageNum > 1}">
        <a href="${requestScope.employeePageInfo.url}&pageNo=1">首页</a>
        <a href="${requestScope.employeePageInfo.url}&pageNo=${requestScope.employeePageInfo.pageNo - 1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
        <c:when test="${requestScope.employeePageInfo.pages <= 5}">
            <c:set var="begin" value="1" />
            <c:set var="end" value="${requestScope.employeePageInfo.navigateLastPage}" />
        </c:when>
        <%--情况2：总页码大于5的情况下--%>
        <c:when test="${requestScope.employeePageInfo.pages > 5}" >
            <c:choose>
                <%--小情况1：当前页码为前面3个：1,2,3的情况，页码范围是：1-5--%>
                <c:when test="${requestScope.employeePageInfo.pageNum <= 3}">
                    <c:set var="begin" value="1" />
                    <c:set var="end" value="5" />
                </c:when>
                <%--小情况2：当前页码为最后3个：8,9,10的情况，页码范围是：:总页码减4 - 总页码--%>
                <c:when test="${requestScope.employeePageInfo.pageNum > requestScope.employeePageInfo.navigateLastPage - 3}">
                    <c:set var="begin" value="${requestScope.employeePageInfo.navigateLastPage - 4}" />
                    <c:set var="end" value="${requestScope.employeePageInfo.navigateLastPage}" />
                </c:when>
                <%--小情况3：4,5,6,7，页码范围是当前页面减2 - 当前页面加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.employeePageInfo.pageNum - 2}" />
                    <c:set var="end" value="${requestScope.employeePageInfo.pageNum + 2}" />
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.employeePageInfo.pageNum}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.employeePageInfo.pageNum}">
            <a href="${requestScope.employeePageInfo.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出的结束--%>

    <%--如果已经是最后一页，不再显示下一页，末页--%>
    <c:if test="${requestScope.employeePageInfo.pageNum < requestScope.employeePageInfo.navigateLastPage}">
        <a href="${requestScope.employeePageInfo.url}&pageNo=${requestScope.employeePageInfo.pageNo + 1}">下一页</a>
        <a href="${requestScope.employeePageInfo.url}&employeePageInfoNo=${requestScope.employeePageInfo.pageTotal}">末页</a>
    </c:if>
    共${requestScope.employeePageInfo.navigateLastPage}页，${requestScope.employeePageInfo.total}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            //跳到指定的页码
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                //防止提交非法的页码
                if(pageNo < 1){
                    pageNo = 1;
                }
                if(pageNo > ${requestScope.employeePageInfo.navigateLastPage}){
                    pageNo = ${requestScope.employeePageInfo.navigateLastPage}
                }
                //javaScript语言中提供了一个location地址栏对象
                //href属性可读可写
                location.href ="${pageScope.basePath}${requestScope.employeePageInfo.url}&pageNo=" + pageNo;
            });
        });
    </script>
</div>
<%--分页导航栏结束部分--%>

