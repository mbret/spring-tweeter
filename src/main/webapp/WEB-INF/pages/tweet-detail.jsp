<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common/head.jsp" />
<body>
<div class="main">	
	<jsp:include page="../common/menu.jsp" /> 
	<div class="corps">
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
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>