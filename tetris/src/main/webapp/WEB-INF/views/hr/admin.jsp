<!--  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  <h1>admin page</h1>

 <p>principal :<sec:authentication property="principal"/></p>
<p>UserVO :<sec:authentication property="principal.user"/></p> --%>
<p>사용자이름 :<sec:authentication property="principal.user.e_name"/></p>
<p>사용자아이디 :<sec:authentication property="principal.username"/></p>
<p>사용자 권한 리스트:<sec:authentication property="principal.user.authList"/></p>


admin page
<a href="/member/customLogout">Logout</a><br>
<a href="/hr/register">회원등록</a>
<a href="/hr/list">회원관리</a>
 <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="../includes/footer.jsp"%>
</body>
</html> -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인입니다.</title>
<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- jsp 인클루드 사용-->
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<!-- 메인내용 container시작 -->
	<div class="container">

		<!-- main-left 시작 -->
		<div class="main-left">
			<!-- 사원정보 -->
			<div class="myProfile Box">
				<span class="m-title">MyProfile </span> <a href="">
				<img alt="사진"src="../resources/img/res/hi.png"></a>
				<div style="font-size:18px;">고북이</div>
			</div>

			<!-- 근태관리 -->

			<div class="hr Box">
				<span class="m-title">근태관리</span>
				<div class="time">
					<!-- 시계모양 -->
					출근시간 퇴근시간 근무상태
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


	</div>
<!-- container 끝 -->

	<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>

</html>



