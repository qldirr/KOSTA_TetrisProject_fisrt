<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="../includes/header.jsp"%>

<!-- main.jsp+list.jsp 최종화면에 출력할거-->

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link href="/resources/fullcalendar/main.css" rel="stylesheet" />
<script src="/resources/fullcalendar/main.js" type="text/javascript"></script>

<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						var calendarEl = document.getElementById('calendar');
						var calendar = new FullCalendar.Calendar(
								calendarEl,
								{
									// Tool Bar 목록 document : https://fullcalendar.io/docs/toolbar
									headerToolbar : {
										left : 'prev,today,next',
										center : 'title',
										right : 'dayGridMonth,dayGridWeek,dayGridDay'
									},

									selectable : true,
									selectMirror : true,

									navLinks : true, // can click day/week names to navigate views
									editable : true,
									// Create new event
									select : function(arg) {
										Swal
												.fire(
														{
															html : "<div class='mb-7'>Create new event?</div><div class='fw-bold mb-5'>Event Name:</div><input type='text' class='form-control' name='event_name' />",
															icon : "info",
															showCancelButton : true,
															buttonsStyling : false,
															confirmButtonText : "Yes, create it!",
															cancelButtonText : "No, return",
															customClass : {
																confirmButton : "btn btn-primary",
																cancelButton : "btn btn-active-light"
															}
														})
												.then(
														function(result) {
															if (result.value) {
																var title = document
																		.querySelector("input[name=;event_name']").value;
																if (title) {
																	calendar
																			.addEvent({
																				title : title,
																				start : arg.start,
																				end : arg.end,
																				allDay : arg.allDay
																			})
																}
																calendar
																		.unselect()
															} else if (result.dismiss === "cancel") {
																Swal
																		.fire({
																			text : "Event creation was declined!.",
																			icon : "error",
																			buttonsStyling : false,
																			confirmButtonText : "Ok, got it!",
																			customClass : {
																				confirmButton : "btn btn-primary",
																			}
																		});
															}
														});
									},

									// Delete event
									eventClick : function(arg) {
										Swal
												.fire(
														{
															text : "Are you sure you want to delete this event?",
															icon : "warning",
															showCancelButton : true,
															buttonsStyling : false,
															confirmButtonText : "Yes, delete it!",
															cancelButtonText : "No, return",
															customClass : {
																confirmButton : "btn btn-primary",
																cancelButton : "btn btn-active-light"
															}
														})
												.then(
														function(result) {
															if (result.value) {
																arg.event
																		.remove()
															} else if (result.dismiss === "cancel") {
																Swal
																		.fire({
																			text : "Event was not deleted!.",
																			icon : "error",
																			buttonsStyling : false,
																			confirmButtonText : "Ok, got it!",
																			customClass : {
																				confirmButton : "btn btn-primary",
																			}
																		});
															}
														});
									},
									dayMaxEvents : true, // allow "more" link when too many events
									// 이벤트 객체 필드 document : https://fullcalendar.io/docs/event-object
									events : [ {
										title : 'All Day Event',
										start : '2022-10-01'
									}, {
										title : 'Long Event',
										start : '2022-10-07',
										end : '2022-10-10'
									}, {
										groupId : 999,
										title : 'Repeating Event',
										start : '2022-10-09T16:00:00'
									}, {
										groupId : 999,
										title : 'Repeating Event',
										start : '2022-10-16T16:00:00'
									}, {
										title : 'Conference',
										start : '2022-10-11',
										end : '2022-10-13'
									}, {
										title : 'Meeting',
										start : '2022-10-12T10:30:00',
										end : '2022-10-12T12:30:00'
									}, {
										title : 'Lunch',
										start : '2022-10-12T12:00:00'
									}, {
										title : 'Meeting',
										start : '2022-10-12T14:30:00'
									}, {
										title : 'Happy Hour',
										start : '2022-10-12T17:30:00'
									}, {
										title : 'Dinner',
										start : '2022-10-12T20:00:00'
									}, {
										title : 'Birthday Party',
										start : '2022-10-13T07:00:00'
									}, {
										title : 'Click for Google',
										url : 'http://google.com/',
										start : '2022-10-28'
									} ]
								});

						calendar.render();
					});
</script>
<title>TETRIS Groupware</title>
</head>

<body>
	<div style="width: 100%; height: 1000; background: red;">
		<!-- content -->
		<div class="container-fluid">
			<div class="col-xl-10 col-lg-9 ">
			
					<!-- content -->
					<div id='calendar'></div>
			
			</div>
		</div>
	</div>





	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/js/index.js"></script>

	<%@ include file="../includes/footer.jsp"%>
</body>

</html>