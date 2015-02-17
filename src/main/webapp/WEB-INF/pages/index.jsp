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
	<div class="main">
		<jsp:include page="../common/menuNotConnected.jsp" />
		<div class="tweets" role="content">     
			<article>     
				<p>Tweet 2</p>
			</article>
			<hr/>
			<article>
				<p>Tweet 2</p>
			</article>
			<li><a href="${contextPath}/example.html">Example page</a></li>
    		<li><a href="${contextPath}/users.html">See users</a></li>
		</div>
		<jsp:include page="../common/footer.jsp" />  
	</div>  
</body>
</html>
