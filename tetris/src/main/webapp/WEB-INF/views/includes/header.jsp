<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
<link href="/resources/css/main.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" 교차 출처>
<link href="https: //fonts.googleapis.com/css2? family= 노토+산스+KR:wght@300;700;900 & display=swap" rel="stylesheet">


<title>TETRIS Groupware</title>
</head>

<body>

	<div class="wapper">

		<!-- main sidebar 시작-->
		<div class="sidebar">
			<div class="pb-3 bottom-border" style="text-align: center"  >
			<a id ="brand" href="/main">
					<img id="brandlogo" src="/resources/img/TETRIS.jpg" width="180px"></a>
	
			</div>
		
			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-clock"></i> 근태관리</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-table"></i> 일정관리</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/meetingroom/resroomcal?mr_num=RS001"><i class="bi bi-tags"></i> 예약</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-clipboard-data"></i> 프로젝트</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-file-text"></i> 전자결재</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/reservation/listcar"><i class="bi bi-easel"></i> 게시판</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-diagram-3-fill"></i> 조직도</a>
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
						<img src="../resources/img/res/hi.png"alt="사진">
					<span class="user">고북이님</span>

				</button>
			</div>

		</div>
	
		<!-- navbar 끝 -->
		
	</div>
	<!-- wrapper 끝 -->
</body>

</html>

