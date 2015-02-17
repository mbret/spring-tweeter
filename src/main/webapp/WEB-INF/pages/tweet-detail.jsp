<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/17/2015
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Tweet ${tweet.id}</h2>
<table>
    <tr>
        <td>User</td>
        <td>${tweet.userID}</td>
    </tr>
    <tr>
        <td>Content</td>
        <td>${tweet.content}</td>
    </tr>
    <tr>
        <td>Date</td>
        <td>${tweet.date}</td>
    </tr>
</table>
</body>
</html>
