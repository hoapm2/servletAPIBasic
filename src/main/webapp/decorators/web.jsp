<!-- master layout của user, chứa những component chung của phần user site -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><dec:title default="homepage" /></title>
<link
	href="<c:url value="/template/web/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/template/web/css/style.css"/>"
	rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v4.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<div class="container">
		<dec:body />
	</div>


	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script type="text/javascript"
		src="<c:url value="/template/web/jquery/jquery.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/template/web/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
</body>

</html>