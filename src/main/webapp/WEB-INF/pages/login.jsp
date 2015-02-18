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
       <form:form method="POST" action="${contextPath}/${route.login}">
       		<c:if test="${not empty message}">
       			<p class="warning">${message}</p>
       		</c:if>
		    <table>
			    <tr>
			        <td><label for="mail">Email :</label></td>
			        <td><form:input path="mail" /></td>
			        <td><form:errors path="mail" /></td>
			    </tr>		    
			    <tr>
			        <td><label for="password">Mot de passe :</label></td>
			        <td><form:input path="password" /></td>
			        <td><form:errors path="password" /></td>
			    </tr>
			</table>
			<input type="submit" value="Se connecter" />
		</form:form>
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>