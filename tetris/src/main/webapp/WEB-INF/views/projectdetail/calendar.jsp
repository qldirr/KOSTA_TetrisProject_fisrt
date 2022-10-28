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
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth',
			contentHeight : 600,//캘린더 크기 설정
			editable : true,//수정 여부
		});

		calendar.render();
	});
	
	
	$(function(){
		
		$('#regCalBtn').on('click', function(){
			self.location = "/projectdetail/registerCal";
		})
		
	})
	
	
</script>

</head>
<body>

<h1>프로젝트 ${pj_num } 캘린더 </h1>
<input type="button" id="regCalBtn" value="새 일정 등록하기">
	<div id='calendar'></div>
</body>
</html>