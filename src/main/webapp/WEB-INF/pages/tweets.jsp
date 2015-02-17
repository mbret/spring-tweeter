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
        <h2>Tweets</h2>
    </div>

    <div>
        <a href="${contextPath}/subscriptions/subscribe?user=${user.id}" title="Subscribe to this user">Subscribe</a>
        <br/>
        <a href="${contextPath}/subscriptions/unsubscribe?user=${user.id}" title="Subscribe to this user">Unsubscribe</a>
    </div>
    <table>
        <c:forEach var="tweet" items="${tweets}">
            <tr>
                <td> user = <c:out value="${tweet.userID}"/> </td>
                <td> content = <c:out value="${tweet.content}"/> </td>
                <td> date = <c:out value="${tweet.date}"/> </td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>
