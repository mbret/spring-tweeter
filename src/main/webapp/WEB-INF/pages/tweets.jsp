<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/16/2015
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>SID - CAE</title>
</head>
<body>
    <div>
        <h2>Tweets</h2>
    </div>

    <c:forEach var="tweet" items="${tweets}">
        <tr>
            <td> <c:out value="${tweet.message}"/> </td>
            <td> <c:out value="${tweet.date}"/> </td>
        </tr>
    </c:forEach>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>
