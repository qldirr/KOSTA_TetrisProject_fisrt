<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/fullcalendar/main.css" />
<script src="/resources/fullcalendar/main.js" type="text/javascript"></script>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">

	document.addEventListener('DOMContentLoaded', function() {
		
			var calArr = [];			

			$.ajax({
				url : '/projectdetail/calendarList',
				type : 'get',
				dataType : 'json',
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {
				
				$(data).each(function(index, value) {
					calArr.push(value)
					console.log(value);
				});
				
				
				var calendarEl = document.getElementById('calendar');
				var calendar = new FullCalendar.Calendar(calendarEl, {

					initialView : 'dayGridMonth',
					contentHeight : 600,//캘린더 크기 설정
					editable : true,//수정 여부
					events : calArr
				});
				
				calendar.render();

			});
			
		
	});
	
	
	var moveTo = (function(){
		
		function main(){
			self.location = "/project/main";
		}
		
		function registerCal(){
			self.location = "/projectdetail/registerCal";
		}
		
		function calendar(){
			self.location = "/projectdetail/calendar";
		}
		
		function task(){
			self.location = "/projectdetail/taskboard";
		}
		
		function home(){
			
			var pj_num = ${pj_num};
			self.location = "/projectdetail/home/" + pj_num;
		}
		
		
		return {
			main : main,
			registerCal : registerCal,
			calendar : calendar,
			task : task,
			home : home
			
		}
		
	})();
	

	$(function() {
		
		$('#regCalBtn').on('click', moveTo.registerCal);
		
		$('#backBtn').on('click', moveTo.main);
		
		$('#showTaskBoard').on('click', moveTo.task);
		
		$('#showMain').on('click', moveTo.home);

	})
	
	
</script>

</head>
<body>

	<h1>프로젝트 ${pj_num } 캘린더</h1>
<div id="projectMenu">
	<input type="button" id="regCalBtn" value="새 일정 등록하기">
	<input type="button" id="backBtn" value="이 프로젝트 나가기">
	<input type="button" id="showMain" value="프로젝트 홈으로 가기">
	<input type="button" id="showTaskBoard" value="업무보드 보기">
</div>
	<div id='calendar'></div>
</body>
</html>