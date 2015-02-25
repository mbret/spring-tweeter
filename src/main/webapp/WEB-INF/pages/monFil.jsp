<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../common/head.jsp" />
<body>
	<div class="main">
		<jsp:include page="../common/menu.jsp" />
		<div class="tweets">		
			<div class="tweets" role="content">     
				<c:forEach items="${tweets}" var="tweet">
			         <c:forEach var="t" items="${tweet.value}">
			            <hr />
			            <div class="unTweet">
			                <p><span class="tweetUser"><c:out value="${tweet.key}"/></span><span class="tweetDate"> Le : <c:out value="${t.date}"/> </span></p>
			                <p><c:out value="${t.content}"/> </p>
			            </div>
			        </c:forEach>
			    </c:forEach>
			</div>
		</div>
	<jsp:include page="../common/footer.jsp" />  
</body>
</html>