<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ include file="../includes/header.jsp"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
					<script src="/resources/js/index.js"></script>



</head>
<body>
	<h1>Menu List</h1>
	<!-- <meta http-equiv="Context-Type" context="text/html; charset=UTF-8"> -->


	<div class="container-fluid ">
		<div class="row">
			<!-- sidebar -->
			<div class="col-xl-2 col-lg-3"></div>
			<div class="col-xl-10 col-lg-9">
				<div style="width: 100%; height: 1000;">

					<h1>Menu List</h1>

					<!--  <button id='regBnt' type="button" class="btn btn-secondary"
						onclick="location.href='http://localhost:8081/tmenu/register'">Menu List</button>-->
						


					<table class="table table-striped table-bordered table-hover"
						id="list">
						<thead>
							<tr>
								<th width="10%">번호</th>
								<th width="10%">작성자</th>
								<th width="20%">제목</th>
								<th width="40%">내용</th>
								<th width="10%">작성일</th>
								<th width="10%">수정일</th>
							</tr>
						</thead>

						<c:forEach items="${list}" var="tmenu">
							<tr>
								<td><c:out value="${tmenu.t_num}" /></td>
								<td><c:out value="${tmenu.e_id}" /></td>
								<td>
								<a class='move' href='/tmenu/get?t_num=<c:out value="${tmenu.t_num}"/>'>
									<c:out value="${tmenu.t_title}" /></a>
								</td>
								<td><c:out value="${tmenu.t_contents}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${tmenu.t_regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${tmenu.t_moddate}" /></td>
							</tr>
						</c:forEach>
					</table>



				</div>
			</div>
		</div>
	</div>













	<!--<script type="text/javascript">
	function move(){
		$("regBnt").on("click",function(){
			self.location = "suggesions/suggesionslist";		
		};	
</script>
					-->

					<!-- Optional JavaScript; choose one of the two! -->

					<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
					<!-- <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script> -->
					

					<%@ include file="../includes/footer.jsp"%>
</body>
</html>