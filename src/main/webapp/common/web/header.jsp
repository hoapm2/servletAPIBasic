<!-- Navigation -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/tablib.jsp"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${ not empty usermodel }">
					<li class="nav-item active"><a class="nav-link" href='#'>
							Hello, ${usermodel.fullName} </a></li> 
				
					
					<li class="nav-item active"><a class="nav-link"
						href='<c:url value="/logout?action=logout"/>'>Logout </a></li>
				</c:if>
				<c:if test="${ empty usermodel }">
					<li class="nav-item active"><a class="nav-link"
						href='<c:url value="/login?action=login"/>'>Login </a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>
