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

<title>TETRIS Groupware</title>
</head>

<body>
	<div style="width: 100%; height: 1000;">
		<!-- content -->
		<div class="container-fluid">

			<h1>건의사항</h1>
			<div class="panel-heading">
				<button id='regBnt' type="button" class="btn btn-secondary"">건의사항
					등록</button>
				<!-- href="/suggesions/suggesionsregister  -->
			</div>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="10%">번호</th>
						<th width="10%">아이디</th>
						<th width="20%">제목</th>
						<th width="40%">내용</th>
						<th width="10%">작성일</th>
						<th width="10%">수정일</th>
					</tr>
				</thead>

				<c:forEach items="${list}" var="suggestions">
					<tr>
						<td><c:out value="${suggestions.s_num}" /></td>
						<td><c:out value="${suggestions.e_id}" /></td>
						<td><c:out value="${suggestions.s_title}" /></td>
						<td><c:out value="${suggestions.s_contents}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${suggestions.s_regdate}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${suggestions.s_moddate}" /></td>
					</tr>
				</c:forEach>

			</table>


		</div>
	</div>







	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!--    <script src="/resources/js/index.js"></script>	 -->



	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/js/index.js"></script>

	<%@ include file="../includes/footer.jsp"%>
</body>

</html>
