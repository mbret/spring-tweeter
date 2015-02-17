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
<div>
    <h2>Users</h2>
</div>

<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>Name: <c:out value="${user.name}"/> </td>
            <td><a href="${contextPath}/users/tweets.html?user=${user.id}">See user tweets</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../common/footer.jsp" />
</body>
</html>
