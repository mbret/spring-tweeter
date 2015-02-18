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
		<h1>Ajouter un tweet</h1>
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
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>