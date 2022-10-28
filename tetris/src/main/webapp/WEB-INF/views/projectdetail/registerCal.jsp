<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="/resources/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" href="/resources/css/jquery.timepicker.min.css" />
<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/lib/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/resources/lib/jquery.timepicker.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				
				$('#datePickerstart').datepicker({
					format: "yyyy-mm-dd",
					autoclose: true
				});
				
				$('#datePickerend').datepicker({
					format: "yyyy-mm-dd",
					autoclose: true
				});
				
				$('input.timepicker').timepicker({
		            timeFormat: 'HH:mm',
		            interval: 30,
		            startTime: '06:00',
		            dynamic: false,
		            dropdown: true,
		            scrollbar: true
		        });
				
				
				$('#test').on("click", function(){
					console.log($('input[name=pj_num]').val());
					console.log($('input[name=pc_name]').val());
					console.log($('input[name=pc_startdate]').val());
					console.log($('input[name=pc_starttime]').val());
					console.log($('input[name=pc_enddate]').val());
					console.log($('input[name=pc_endtime]').val());
				})
				
		});
	
</script>
</head>
<body>

<h1>새 일정 생성</h1>

	<form action="/projectdetail/registerCal" method="post" accept-charset="UTF-8">
		<input type="hidden" name="pj_num" value="${pj_num }">
		일정명: <input type="text" name="pc_name"><br> 
		일정시작일: <input id="datePickerstart" type="text" name="pc_startdate"><br> 
		일정시작시간: <input type="text" name="pc_starttime" class="timepicker"><br>
		일정마감일: <input id="datePickerend" type="text" name="pc_enddate"><br>
		일정마감시간: <input type="text" name="pc_endtime" class="timepicker"><br>
		<input type="button" id="test" value="테스트 버튼">
		<input type="submit" value="새 일정 생성">
		
	</form>

</body>
</html>