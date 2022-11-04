<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/fullcalendar/main.css" />
<link rel="stylesheet" href="/resources/css/mycss/bootstrap-datepicker3.css" />
<link rel="stylesheet" href="/resources/css/mycss/jquery.timepicker.min.css" />
<style type="text/css">
	#regCalBtn{
		border-style: none;
		background-color: #161E67;
		color: #FFF2CA;
		border-radius: 10px;
		padding-bottom: 7px;
		padding-top: 7px;
		padding-left: 10px;
		padding-right: 10px;
		font-weight: bold;
		font-family: sans-serif;
		width: 100px;
		height: 70px;
	}
</style>

<script src="/resources/fullcalendar/main.js" type="text/javascript"></script>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/fullcalendar/locales-all.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/myjs/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/resources/js/myjs/jquery.timepicker.min.js" type="text/javascript"></script>
<script type="text/javascript">



	document.addEventListener('DOMContentLoaded', function() {
		
			var calArr = [];			

			$.ajax({
				url : '/calendar/listCal',
				type : 'get',
				dataType : 'json',
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {
				
				$(data).each(function(index, value) {
					calArr.push(value)
				});   //controller의 list를 get방식으로 가져옴
				
				
				var calendarEl = document.getElementById('calendar');
				var calendar = new FullCalendar.Calendar(calendarEl, {
					headerToolbar: {
		               	left: '',
		                center: 'title'
		                
		            },
					locale : 'ko',
					initialView : 'dayGridMonth',
					contentHeight : 600,//캘린더 크기 설정
					editable : true,//수정 여부
					events : calArr,    //일정 리스트 출력
					eventClick : function(info){     //일정 클릭 시 일정 상세 페이지로 이동
						getCal(info.event.id);
					}
					
				});
				
				calendar.render();

			});
			
		
	});
	
	
	function getCal(cl_num){     //일정상세 페이지로 이동
		location.href = "/calendar/get?cl_num="+cl_num;
	}
	
	
	var moveTo = (function(){     //일정등록 버튼 눌렀을때 등록 폼으로 이동
		function registerCal(){
			self.location = "/calendar/register";
		}
		
		return {
			
			registerCal : registerCal,
			}
		})();
	
	$(function() {
		
		$('#regCalBtn').on('click', moveTo.registerCal);
		})     //등록 폼으로 이동 끝
	
	
</script>

</head>
<body>

	<h1>일정 관리</h1>
	<div id="calendarMenu">
		<input type="button" id="regCalBtn" value="일정 등록">
	</div>
	<div id='calendar'></div>

	
</body>
</html>