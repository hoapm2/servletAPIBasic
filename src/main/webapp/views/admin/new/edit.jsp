<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/tablib.jsp"%>
<c:url var="APIurl" value="api-adminhomepage-news" />


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Chỉnh sửa bài viết</title>
</head>
<body>

	<c:if test="${not empty usermodel }">


</c:if>
<form id="formSubmit">

<!--  khong can action va method nhu formLogin nua vi bay gio call API de lay data -> dung jquery. Cai form login la submit -> controller nen can action, method. -->
<div class="container-fluid">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">Title</span>
		</div>
		<input type="text" class="form-control" id="title" name="title" value="${model.title}" >
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">Category</span>
		</div>
		<select name="categoryCode" class="custom-select" id="categoryCode">
		<c:if test="${empty model.categoryCode}">
		<option value="">Choose Category </option>
			<c:forEach var="item" items="${categories}">
					<option value="${item.code}">${item.name}</option>
			</c:forEach>
		</c:if>
		<c:if test="${not empty model.categoryCode}">
	
			<c:forEach var="item" items="${categories}">
				<c:if test="${item.code == model.categoryCode}">
						<option value="${item.code}" selected="selected">${item.name}</option>
				</c:if>
				<c:if test="${item.code != model.categoryCode}">
						<option value="${item.code}">${item.name}</option>
				</c:if>
			</c:forEach>
			<option value="">Choose Category </option> 
		</c:if>
			
		</select>
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">Thumbnail</span>
		</div>
		<input type="text" class="form-control" id="thumbnail" name="thumbnail" value="" >
	</div>
	<!-- value la gia tri cua input khi submit  -->
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">Short Description</span>
		</div>
		<input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}" >
	</div>
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text">Content</span>
		</div>
		<input type="text" class="form-control" id="content" name="content" value="${model.content}" >
	</div>
	<div class="input-group mb-3">
		<c:if test="${not empty model.title }">
		
			<input type="button" class="btn btn-warning btn-bold" value="Update" id="btnAddOrUpdateNew">
		</c:if>
		<c:if test="${empty model.title }">
			<input type="button" class="btn btn-warning btn-bold" value="Add new" id="btnAddOrUpdateNew">
		</c:if>
	</div>
</div>
<input type="hidden" name="id" id="id" value="${model.id}">
</form>
<script type="text/javascript">
	$('#btnAddOrUpdateNew').click(function(event) {
		console.log('tests');
		event.preventDefault(); /*rat quan trong, preventDefault() dung de dam bao form submit ko vao URL hien tai (admin-new) trong khi URL can submit la api-admin-new*/

		/*var title= $('#title').val();
		var shortDescription=$('#shortDescription').val();
		var categoryCode=$('#categoryCode').val();
		var content=$('#content').val();
		var thumbnail=$('#thumbnail').val();*/


		// lay data theo cach truyen thong, nhung neu co nhieu field thi se gap van de :) 

		//cach giai quyet van de get name cua field: (phai dat name cho tung field trc)
		var data= {};
		var formData=$('#formSubmit').serializeArray();
		// lay data tu form convert thanh 1 array, array do chua nhieu cap gia tri: name and value

		$.each(formData, function(i, v) { //index, value
			//for in jquery
			data[""+v.name+""]=v.value; // cai nay de bien cai mang thanh giong dang json -> day len api:) 
		});
		console.log(data);
		var id= $('#id').val();
		if (id=="0"){
			addNew(data);
		} else {
			updateNew(data);
		}
	});
	function addNew(data){
		$.ajax({
			url: '${APIurl}', //ko nen goi truc tiep, nen goi thong qua c: url
			type: 'POST',   //'default GET (Other values: POST)',
			contentType: 'application/json', // trung voi type content cua postman de tu Client gui len Server
			dataType: 'json', //type data cua sever tra ve cho client (ham response.contentType() cua API )
			data: JSON.stringify(data), // can co bo chuyen doi data tu javaScriptObject (client) -> json (server)
			success: function (result){
				console.log(result);
			},
			error: function(error){
				console.log(error);
			}
		});
		
	}

	//video 6
	function updateNew(data){
		$.ajax({
			url: '${APIurl}', //ko nen goi truc tiep, nen goi thong qua c: url
			type: 'PUT',   //'default GET (Other values: POST)',
			contentType: 'application/json', // trung voi type content cua postman de gui len server
			dataType: 'json', //type data cua sever tra ve cho client
			data: JSON.stringify(data),// can co bo chuyen doi data tu javaScriptObject (client) -> json (server). Su dung JSON.Stringfy() de chuyen
		success: function (result){
				console.log(result);
			},
			error: function(error){
				console.log(error);
			}
		});

		
	}
</script>

</body>
</html>