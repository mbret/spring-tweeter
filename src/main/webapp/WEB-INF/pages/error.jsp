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
   		<c:if test="${not empty message}">
   			<p class="warning">${message}</p>
   		</c:if>       		
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>