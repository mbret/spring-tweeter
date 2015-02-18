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
	    
	    <c:if test="${currentUser.id != user.id}">   			
		    <div class="userDetails">
		    	<h1><c:out value="${user.name}"/></h1>
		    	<table>
		    		<tr>
		    			<td>Nombre de tweets : ${fn:length(tweets)}</td>
		    			<td>Nombre d'abonnés</td>
		    			<td>Nombre d'abonnement</td>
		    			<td><a href="${contextPath}/subscriptions/subscribe?user=${user.id}" title="Subscribe to this user">S'abonner</a></td>
		    			<!-- <td><a href="${contextPath}/subscriptions/unsubscribe?user=${user.id}" title="Subscribe to this user">Unsubscribe</a></td>  -->
		    		</tr>
		    	</table>
		    </div>
   		</c:if>
   		<c:if test="${fn:length(tweets) == 0}">
   			<div class="noTweets">
	   			<c:if test="${currentUser.id != user.id}"> 
			   		<p>Cet utilisateur n'a pas publié de tweets.</p>
			   	</c:if>		   	
	   			<c:if test="${currentUser.id == user.id}"> 
			   		<p>Vous n'avez pas publié de tweets.</p>
		   	</c:if>
		   	</div>
		</c:if>  	    
        <c:forEach var="tweet" items="${tweets}">
            <hr />
            <div class="unTweet">
                <p><span class="tweetUser"><c:out value="${user.name}"/></span><span class="tweetDate"> Le : <c:out value="${tweet.date}"/> </span></p>
                <p><c:out value="${tweet.content}"/> </p>
            </div>
        </c:forEach>
	</div>
	<jsp:include page="../common/footer.jsp" />  
</div>
</body>
</html>
