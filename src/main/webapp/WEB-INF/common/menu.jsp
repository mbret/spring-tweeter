<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:choose>
      <c:when test="${not empty currentUser}">
		<div class="menu">
			<div class="button-group">
				<ul>
					<li><a href="${pageContext.request.contextPath}/" class="button">Votre fil</a></li>
					<li><a href="${pageContext.request.contextPath}/${routes.tweets}?user=${currentUser.id}" class="button">Mes tweets</a></li>
					<li><a href="#" class="button">Hashtags</a></li>
					<li><a href="${pageContext.request.contextPath}/${routes.profile}" class="button">Profil</a></li>
				</ul> 	
		   	</div>
		   	<div class="button-indiv">
		   		<div><a href="${pageContext.request.contextPath}/${routes.logout}"><p>[Se déconnecter]</p></a></div>
		   		<div><a href="${pageContext.request.contextPath}/tweets/post"><img src="${pageContext.request.contextPath}/media/images/compose.png"/></a></div>
		   		<div><form method="get" action="${pageContext.request.contextPath}/users/searchUser"><input type="text" placeholder="Rechercher un utilisateur" id="search" name="userName" /></form></div>
		   	</div>          
		</div>
      </c:when>	
      <c:otherwise>
		<div class="menu">
			<div class="button-group">
				<ul>
					<li><a href="${pageContext.request.contextPath}/" class="button">Accueil</a></li>
				</ul> 	
		   	</div>
		   	<div class="button-indiv">
		   		<div><a href="${pageContext.request.contextPath}/${routes.login}"><p>[Se Connecter]</p></a></div>
		   		<div><a href="${pageContext.request.contextPath}/${routes.register}"><p>[S'incrire]</p></a></div>
		   	</div>          
		</div>      
      </c:otherwise>
</c:choose>



