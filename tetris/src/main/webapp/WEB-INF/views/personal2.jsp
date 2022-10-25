<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.io.PrintWriter"%>
<%@ include file="includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/js/index.js"></script>
<!-- Bootstrap CSS -->
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<title>개인근태페이지</title>
<script>
	$(function() {
		$("#datePicker").datepicker({});
	});

	function printClock() {
		var clock = document.getElementById("clock"); // 출력할 장소 선택
		var currentDate = new Date(); // 현재시간
		var calendar = currentDate.getFullYear() + "-"
				+ (currentDate.getMonth() + 1) + "-" + currentDate.getDate() // 현재 날짜
		var currentHours = addZeros(currentDate.getHours(), 2);
		var currentMinute = addZeros(currentDate.getMinutes(), 2);
		var currentSeconds = addZeros(currentDate.getSeconds(), 2);
		clock.innerHTML = currentHours + ":" + currentMinute + ":"
				+ currentSeconds; //날짜를 출력해 줌
		//날짜 출력
		var date = document.getElementById("date");
		date.innerHTML = currentDate.getFullYear() + "년 "
				+ (currentDate.getMonth() + 1) + "월 " + currentDate.getDate()
				+ "일";
		setTimeout("printClock()", 1000); // 1초마다 printClock() 함수 호출
	}

	function addZeros(num, digit) { // 자릿수 맞춰주기
		var zero = '';
		num = num.toString();
		if (num.length < digit) {
			for (i = 0; i < digit - num.length; i++) {
				zero += '0';
			}
		}
		return zero + num;
	}

	//출퇴근버튼 활성화
	function startDate() {
		var currentDate = new Date();
		var currentHours = addZeros(currentDate.getHours(), 2);
		var currentMinute = addZeros(currentDate.getMinutes(), 2);
		var currentSeconds = addZeros(currentDate.getSeconds(), 2);

		if (confirm('출근하시겠습니까?')) {
			alert('출근하셨습니다');
			startTime.innerHTML = currentHours + ":" + currentMinute + ":"
					+ currentSeconds;
		}
	}
	function endDate() {
		var currentDate = new Date();
		var currentHours = addZeros(currentDate.getHours(), 2);
		var currentMinute = addZeros(currentDate.getMinutes(), 2);
		var currentSeconds = addZeros(currentDate.getSeconds(), 2);
		if (confirm('퇴근하시겠습니까?')) {
			alert('퇴근하셨습니다');
			endTime.innerHTML = currentHours + ":" + currentMinute + ":"
					+ currentSeconds;
		}
	}

	function outDate() {
		if (confirm('외근하시겠습니까?')) {
			alert('안녕히다녀오세요');
		}
	}
</script>
</head>
<body onload="printClock()">
	<div style="width: 100%; height: 1000; background: none;">

		<!-- 좌측사이드 = -->
		<div class="container-fluid">
			<div class="col-xl-10 col-lg-9 ">
				<div id="date"></div>
				<!-- 시계 -->
				<div
					style="width: 200px; height: 80px; line-height: 80px; color: #666; font-size: 40px; text-align: center;"
					id="clock"></div>
				<!-- 출근시간 -->

				<dl>
					<dt>출근시간</dt>
					<dd id="startTime"></dd>
				</dl>
				<!-- 퇴근시간 -->
				<dl>
					<dt>퇴근시간</dt>
					<dd id="endTime"></dd>
				</dl>
				<!-- 누적근무시간 -->
				<dl>
					<dt>누적근무시간</dt>
					<dd id=""></dd>
				</dl>

				<!-- 출퇴근버튼 -->
				<div>
					<button onclick="startDate()" data-per="">출근하기</button>
					<button onclick="endDate()">퇴근하기</button>
					<button onclick="outDate()">외근</button>
				</div>

				<!-- 좌측 navi -->
				<div>
					<input type="text" id="datePicker">
					<ul>
						<li>근태입력</li>
						<li>일별 부서 근태기록조회</li>
						<li>월별 개인 근태기록조회</li>
					</ul>
					<div>휴가현황</div>
				</div>

			</div>

			<!-- 중앙페이지 -->
			<div class="container">
				<div class="row">
					<h3>근태현황</h3>
					<form action="/tetris/test" method="post">
						<input type="text" name="id"> <input type="text" name="pw">
						<input type="submit" value="">
					</form>
					<table class="table table-striped"
						style="text-align: center; border: 1px solid #dddddd">
						<thead>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">일자</th>
								<th style="background-color: #eeeeee; text-align: center;">사원번호</th>
								<th style="background-color: #eeeeee; text-align: center;">이름</th>
								<th style="background-color: #eeeeee; text-align: center;">부서</th>
								<th style="background-color: #eeeeee; text-align: center;">출근시간</th>
								<th style="background-color: #eeeeee; text-align: center;">퇴근시간</th>
								<th style="background-color: #eeeeee; text-align: center;">근무상태</th>
								<th style="background-color: #eeeeee; text-align: center;">비고</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${hrVO.hrDate }" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="${hrVO.e_name }" /></td>
								<td><c:out value="" /></td>
								<td><c:out value="${hrVO.hr_date }" /></td>
								<td><c:out value="${hrVO.hr_leave }" /></td>
								<td><c:out value="${hrVO.hr_status }" /></td>
								<td><c:out value="${hrVO.hr_not }" /></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
	
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/js/index.js"></script>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>