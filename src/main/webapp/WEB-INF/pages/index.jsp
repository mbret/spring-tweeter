<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/16/2015
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common/head.jsp" />
<body>
<h1>Index</h1>

<ul>
    <li><a href="${contextPath}/example.html">Example page</a></li>
    <li><a href="${contextPath}/users.html">See users</a></li>
    <li><a href="${contextPath}/${route.postTweet}">Post a tweet</a></li>
</ul>

<jsp:include page="../common/footer.jsp" />
</body>
</html>
