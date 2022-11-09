<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

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
<link href="/resources/css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">



<title>TETRIS Groupware</title>
</head>

<body>

	<div class="wapper">

		<!-- main sidebar 시작-->
		<div class="sidebar">
			<div class="pb-3 bottom-border" style="text-align: center">
				<a id="brand" href="/main"> <img id="brandlogo"
					src="/resources/img/TETRIS.jpg" width="180px"></a>

			</div>

			<div class="sidebar-item">
				<a class="a" href="#"><i class="bi bi-clock"></i> 근태관리</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/calendar/list"><i class="bi bi-table"></i> 일정관리</a>
			</div>
			<div class="sidebar-item">
				<sec:authorize access="hasRole('ROLE_USER')">
					<a class="a" href="/meetingroom/resroomcal?mr_num=RS001"><i
						class="bi bi-tags"></i> 예약</a>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="a" href="/meetingroom/listroom"><i class="bi bi-tags"></i>
						예약</a>
				</sec:authorize>

			</div>
			<div class="sidebar-item">
				<a class="a" href="/project/main"><i class="bi bi-clipboard-data"></i> 프로젝트</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/elecauth/main"><i class="bi bi-file-text"></i> 전자결재</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/suggestions/suggestionslist"><i class="bi bi-easel"></i>
					게시판</a>
			</div>
			<div class="sidebar-item">
				<a class="a" href="/organization/list"><i class="bi bi-diagram-3-fill"></i> 조직도</a>
			</div>

		</div>

		<!--  main sidebar 끝-->
		<!-- navbar 시작 -->

		<div class="nav-bar">
			
		
		
				<div class="nav-bar-right">
					<sec:authorize access="isAuthenticated()">
					<button id="btn-alarm">
						<span style="font-size: 30px;"><i class="bi bi-bell-fill"></i></span>
						<div id="alarm-count"></div>
					</button>
					<button id="btn-info">
						<img src="../resources/img/res/hi.png" alt="사진"> 
						<span class="user"><sec:authentication property="principal.user.e_name" /></span>						
					</button>
	
					<a id="out_Btn" href="/member/customLogout">로그아웃</a>
		
						</sec:authorize>							
					<sec:authorize access="isAnonymous()">
					
				      <a id="log_Btn" href="/member/customLogin">로그인</a>
				
			</sec:authorize>
				</div>
				
		
			

		</div>

		<!-- navbar 끝 -->

	</div>
	<!-- wrapper 끝 -->
</body>

</html>
