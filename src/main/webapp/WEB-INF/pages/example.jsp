<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/16/2015
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

    <h1>Example view</h1>
    
    User with id = <c:out value="${user.id}"/>

    <h2>Tweets</h2>
    <table>
        <c:forEach var="tweet" items="${tweets}">
            <tr>
                <td> user = <c:out value="${tweet.userID}"/> </td>
                <td> content = <c:out value="${tweet.content}"/> </td>
                <td> date = <c:out value="${tweet.date}"/> </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
