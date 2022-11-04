<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/fullcalendar/lib/main.css" />
<script src="/resources/fullcalendar/lib/main.js" type="text/javascript"></script>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">

	document.addEventListener('DOMContentLoaded', function() {

		 var resArr = [];

		$.ajax({
			url : '/meetingroom/listresroomcal',
			type : 'get',
			dataType : 'json',
			contentType : "application/json"
		}).done(function(data, textStatus, xhr) {

			$(data).each(function(index, value) {
				resArr.push(value)				
				console.log(value);
				
			}); 
			 
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView : 'timeGridWeek',
				contentHeight : 600,
				editable : true,
				events : resArr
				

			});
			
			calendar.render();
			
		});
		

	});
	
		
</script>
</head>
<body>

	<h1>${mr_num.mr_name} 회의실 예약현황</h1>
	<input type="button" id="resRoomBtn" value="회의실예약하기"/>
	<div id='calendar'></div>

</body>
</html>