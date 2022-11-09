<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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