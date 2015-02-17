<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/16/2015
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common/head.jsp" />
<body>
<div>
    <h2>Post a tweet</h2>
</div>

<h1>Form</h1>
<form:form method="POST" action="${contextPath}/${route.postTweet}">
    <table>
        <tr>
            <td><form:label path="content">Content</form:label></td>
            <td><form:textarea path="content" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="../common/footer.jsp" />
</body>
</html>
