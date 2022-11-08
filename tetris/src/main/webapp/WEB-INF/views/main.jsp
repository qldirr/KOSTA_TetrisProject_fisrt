<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인입니다.</title>
<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/3c50ab6b24.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- jsp 인클루드 사용-->
	<jsp:include page="includes/header.jsp"></jsp:include>
	<!-- 메인내용 container시작 -->
	<div class="wrap">
		<div class="container">

			<!-- main-left 시작 -->
			<div class="main-left">
				<!-- 사원정보 -->
				<div class="myProfile Box">
					<span class="m-title">MyProfile </span> <a href=""> <img
						alt="사진" src="../resources/img/res/hi.png"></a>
					<div style="font-size: 18px;">고북이</div>
				</div>

				<!-- 근태관리 -->

				<div class="hr Box">
					<span class="m-title">근태관리</span>
					<div class="time">
						<!-- 시계모양 -->
						<div class="att-time">
							<div>
								출근 시간<span id="att-str"></span>
							</div>
							<div>
								퇴근 시간<span id="att-fin"></span>
							</div>
						</div>
						<div class="att-btn">
							<a href="#" ><i class="fa-solid fa-circle-play"></i></a>
						<a href="#" ><i class="fa-solid fa-circle-stop"></i></a>
						<a href="#" ><i class="fa-solid fa-circle-pause"></i></a>
						</div>
					</div>
				</div>
				<!-- 채팅링크박스 -->
				<div class="chat Box">
					<span class="m-title">채팅바로가기</span>
				</div>
			</div>
			<!--main-left 끝  -->


			<!-- main center 시작 -->
			<div class="main-center">
				<div class="project Box">
					<span class="m-title">프로젝트</span> 
				</div>
				<div class="elecAuth Box">
					<span class="m-title">전자결재</span>
				</div>
			</div>
			<!-- main center 끝 -->

			<!-- main-right 시작 -->
			<div class="main-right">
				<div class="suggest Box">
					<span class="m-title">공지사항</span>
				</div>
				<div class="free Box">
					<span class="m-title">포켓몬도감....</span>
				</div>

			</div>
			<!-- main-rignt 끝 -->

			<jsp:include page="includes/footer.jsp"></jsp:include>
		</div>
		<!-- container 끝 -->


	</div>
</body>

</html>
