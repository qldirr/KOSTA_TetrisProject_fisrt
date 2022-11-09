<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<<<<<<< HEAD
<%@ include file="../includes/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

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
<h1>admin page</h1>

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
</html>
=======
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
			<!-- 보조메뉴바 시작 -->
			
			<div class="s-menu">
				<div class="s-menu-title">
					<p>프로젝트 <i class="bi bi-tags"></i>
				</div>
				<div class="s-list-item ">
				    <input id="newbtn" type="button" value="새 업무 등록하기" onclick="self.location = '/projectdetail/registerTask';">
				</div><br>
				<div class="s-list-item ">
					<a href="/projectdetail/home/${pj_num}">프로젝트 홈</a>
				</div>
				<div class="s-list-item ">
					<a href="/projectdetail/calendar">캘린더</a>
				</div>
				<div class="s-list-item ">
					<a href="/projectdetail/taskboard">업무보드</a>
				</div>
				<div class="s-list-item ">
					<a href="/projectdetail/tasklist">업무리스트</a>
				</div>
				<br><br>
				<div class="s-list-item ">
					<a href="/project/main" style="color:gray"><i class="fa fa-thin fa-door-open"></i> 나가기</a>
				</div>

			</div>
			
			
		<div class="s-container">
			<br><br>
			<h2 id="c-title">admin</h2>

<div class="contents_wrap">
	
</div>
</div>

</body>
<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>
>>>>>>> branch 'main' of https://github.com/joon411/TetrisFinal.git
