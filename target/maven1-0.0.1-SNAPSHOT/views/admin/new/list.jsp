<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/tablib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="APIurl" value="api-adminhomepage-news" />
<c:url var="NewURL" value="/admin-new" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Danh sách bài viết</title>
</head>
<body>
	
	<a href='<c:url value="/admin-new?type=edit"/>'><button type="button" class="btn btn-success">ADD</button></a>
	<button type="button" data-toggle="tooltip" id="btnDelete" 
				title="Delete" data-toggle="tooltip" class="btn btn-danger" >
				<i class="fas fa-trash-alt"></i>
			</button>
	<form action="<c:url value='/admin-new'/>" id="formSubmit" method="GET">
	<!-- De ma submit xong, nhay vao doGet -> khai bai method la GET -->
	<!-- Begin Page Content -->
	<div class="container-fluid">
		<!-- Page Heading -->

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Check All 
					<br><input type="checkbox" name="" id="checkAll"></th>
					<th>Title</th>
					<th>Short Description</th>
					<th>Content</th>
					<th>Option</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${model.listResult}">
				<tr>
					<td><input type="checkbox" name="" id="checkbox_${item.id}" value="${item.id}"> </td>
					<td>${item.title}</td>
					<td>${item.shortDescription}</td>
					<td>${item.content}</td>
					<td>
						<c:url var="editURL"  value="/admin-new">
						<c:param name="type" value="edit" />
						<c:param name="id" value="${item.id}" />
					</c:url>
					<button type="button" data-toggle="tooltip"
					class="btn btn-info"  title="Update"><a href='${editURL}' ><i class="fas fa-pencil-alt"></i></a>	
				</button>
				</td>
		</tr>
	</c:forEach>


</tbody>
</table>
<ul class="pagination" id="pagination"></ul>
<input type="hidden" name="page" value="" id="page" />
 <input
type="hidden" name="maxItemOnPage" value="" id="maxItemOnPage" />
<input
type="hidden" name="sortName" value="" id="sortName" /> 
<input
type="hidden" name="sortBy" value="" id="sortBy" />
 
<input
type="hidden" name="type" value="" id="type" />
</div>
</form>
<script type="text/javascript">
	var currentPage = ${model.page};
	var totalPage = ${model.totalPage};
	var limit = 4;
	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages : totalPage,
			visiblePages : 5,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#maxItemOnPage').val(limit);
					$('#page').val(page);
					$('#sortName').val('title');
					$('#sortBy').val('asc');
					$('#type').val('list');
					$('#formSubmit').submit();
				}

			}
		});
	});
	$("#btnDelete").click(function() {
		var data= {};
		var ids= $('tbody input[type=checkbox]:checked').map(function() {
			return $(this).val();
		}).get();
		console.log(ids);
		data['ids']=ids;
		deleteNew(data);
		});
	function deleteNew(data){
		$.ajax({
			url: '${APIurl}', //ko nen goi truc tiep, nen goi thong qua c: url
			type: 'DELETE',   //'default GET (Other values: POST)',
			contentType: 'application/json', // trung voi type content cua postman de tu Client gui len Server
			data: JSON.stringify(data), // can co bo chuyen doi data tu javaScriptObject (client) -> json (server)
			success: function (result){
				console.log(result);
				window.location.href="${NewURL}?type=list&maxItemOnPage=4&page=1";
			},
			error: function(error){
				console.log(error);// nen xử lý theo kiểu điều hướng -> nên load về trang chủ, hiện thị thông báo
			}
		});
		
	}
	
</script>

</body>
</html>