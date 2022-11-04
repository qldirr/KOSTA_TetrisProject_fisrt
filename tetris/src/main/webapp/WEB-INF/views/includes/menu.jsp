<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<!-- <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/vender/res/main.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<title>TETRIS Groupware</title>
</head>

<body>

	<div class="wapper">

		<!-- main sidebar 시작-->
		<div class="sidebar">
			<div class="pb-3">
				<a href="#"
					class="navbar-brand text-white text-center d-block mx-auto mb-3 bottom-border">
					<img src="/resources/img/TETRIS.jpg" width="180px">
				</a>
			</div>

			<div class="nav-item ">
				<a href="#"><i class="bi bi-clock"></i>근태관리</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-table"></i>일정관리</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-clipboard-data"></i>프로젝트</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-file-text"></i>전자결재</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-tags"></i>예약</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-easel"></i>게시판</a>
			</div>
			<div class="nav-item ">
				<a href="#"><i class="bi bi-diagram-3-fill"></i>조직도</a>
			</div>

		</div>

		<!--  main sidebar 끝-->

		<!-- navbar 시작 -->

		<div class="nav-bar">

			<div class="nav-bar-right">
				<button id="btn-alarm">
					<span style ="font-size: 30px;"><i class ="bi bi-bell-fill"></i></span>
					<div id="alarm-count"></div>
				</button>
				<button id="btn-info">
					<c:if test="${loginUser.photo != null }">
						<img src="" alt="사진">
					</c:if>
					<c:if test="${loginUser.photo == null }">
						<span class="material-icons" style="font-size: 45px;">
							 </span>
					</c:if>
					<span class="user">${loginUser.memberName } 님</span>

				</button>
			</div>

		</div>

		<!-- navbar 끝 -->

	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/vender/res/index.js"></script>



	</div>
	<!-- wrapper 끝 -->
</body>

</html>

