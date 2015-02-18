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
   		<div>
	        <h2>Tweets</h2>
	    </div>
		<!-- 
	    <div>
	        <a href="${contextPath}/subscriptions/subscribe?user=${user.id}" title="Subscribe to this user">Subscribe</a>
	        <br/>
	        <a href="${contextPath}/subscriptions/unsubscribe?user=${user.id}" title="Subscribe to this user">Unsubscribe</a>
	    </div>
	     -->
	    <table>
	        <c:forEach var="tweet" items="${tweets}">
	            <tr>
	                <td> user = <c:out value="${tweet.userID}"/> </td>
	                <td> content = <c:out value="${tweet.content}"/> </td>
	                <td> date = <c:out value="${tweet.date}"/> </td>
	            </tr>
	        </c:forEach>
	    </table>       		
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>
