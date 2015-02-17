<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../common/head.jsp" />
<body>
<div class="main">
	<jsp:include page="../common/menuNotConnected.jsp" />
	<form:form method="post" modelAttribute="userRegister" action="addUser">
	
		<spring:message code="userRegister.name.libelle.name" />
		<form:input path="name"/>
		<b><i><form:errors path="name" cssclass="error"/></i></b><br />
		
		
		<spring:message code="userRegister.name.libelle.lastName" />
		<form:input path="lastName"/>
		<b><i><form:errors path="lastName" cssclass="error"/></i></b><br />
		
		
		<spring:message code="userRegister.name.libelle.email" />
		<form:input path="email"/>
		<b><i><form:errors path="email" cssclass="error"/></i></b><br />
		
		
		<spring:message code="userRegister.name.libelle.password" />
		<form:input path="password"/>
		<b><i><form:errors path="password" cssclass="error"/></i></b><br />
		
		<input type="submit"/>
	</form:form>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>