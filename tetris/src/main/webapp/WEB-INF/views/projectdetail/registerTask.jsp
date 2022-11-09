<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/resources/vender/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" href="/resources/css/jquery.timepicker.min.css" />
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script src="/resources/lib/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script src="/resources/lib/jquery.timepicker.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#datePickerstart').datepicker({
			format : "yyyy-mm-dd",
			autoclose : true
		});

		$('#datePickerend').datepicker({
			format : "yyyy-mm-dd",
			autoclose : true
		});

	});
</script>
</head>
<body>
	<div class="wrap">
		<jsp:include page="../includes/header.jsp"></jsp:include>
		<!-- 보조메뉴바 시작 -->
		<div class="s-menu">
			<div class="s-menu-title">
				<p>
					프로젝트 <i class="bi bi-clipboard-data"></i>
					<!-- 메인 메뉴바랑 동일한 i테그 넣음 -->
			</div>
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

		</div>
		<div class="wrap-box">
			<div class="s-container">

				<h1>${pj_num }새 업무 생성</h1>

				<form action="/projectdetail/registerTask" method="post"
					accept-charset="UTF-8">
					<input type="hidden" name="pj_num" value="${pj_num }"> 업무명:
					<input type="text" name="ts_name"><br> 업무내용: <input
						type="text" name="ts_contents"><br> 업무시작일: <input
						id="datePickerstart" type="text" name="ts_startdate"><br>
					업무마감일: <input id="datePickerend" type="text" name="ts_enddate"><br>
					업무상태: <select name="ts_status" id="selectStatus">
						<option value="예정">예정</option>
						<option value="진행">진행중</option>
						<option value="완료">완료</option>
					</select><br> 업무중요도: <input type="radio" name="ts_importance" value="상">
					상 <input type="radio" name="ts_importance" value="중"> 중 <input
						type="radio" name="ts_importance" value="하"> 하 <br>
					업무담당자: <select name="ts_manager">
						<c:forEach items="${member }" var="m">
							<option value="${m.e_name}">[${m.d_name }]
								${m.e_position } - ${m.e_name }</option>
						</c:forEach>
					</select> <br> <input type="submit" value="새 업무 생성">

				</form>
</body>
</html>