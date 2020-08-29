<!-- master layout của admin, chứa những component chung của phần admin site -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="adminhomepage" /></title>

 <link href="<c:url value="/template/admin/vendor/css/all.min.css"/>" rel="stylesheet" type="text/css">
<link
	href="<c:url value="/template/admin/fontawesome-free/css/all.min.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="<c:url value="/template/admin/css/sb-admin-2.min.css"/>"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
</head>
<body  class="bg-gradient-primary" id="LoginForm">



	<dec:body />



	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value="/template/admin/vendor/jquery/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="/template/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="/template/admin/js/sb-admin-2.min.js"/>"></script>

	<!-- Page level plugins -->
	<script
		src="<c:url value="/template/admin/vendor/chart.js/Chart.min.js"/>"></script>
	<!-- Paging plugins -->
	<script
		src="<c:url value="/template/paging/jquery.twbsPagination.js"/>"></script>

	<!-- Page level custom scripts -->
	<script
		src="<c:url value="/template/admin/js/demo/chart-area-demo.js"/>"></script>
	<script
		src="<c:url value="/template/admin/js/demo/chart-pie-demo.js"/>"></script>
</body>
</html>