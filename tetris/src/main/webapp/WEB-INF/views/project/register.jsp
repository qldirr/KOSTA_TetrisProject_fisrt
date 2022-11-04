<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="/resources/css/bootstrap-datepicker3.css" />
<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/lib/bootstrap-datepicker.js" type="text/javascript"></script>
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
				

				$("#projectMemberRegBtn").on(
						"click",
						function() {
							var child;
							child = window.open("/project/member", "_blank",
									"width=800, height=800");
						});

			});
</script>
</head>
<body>

	<h1>새 프로젝트 생성</h1>

	<form action="/project/register" method="post" accept-charset="UTF-8">

		프로젝트명: <input type="text" name="pj_name"><br> 
		프로젝트유형: <select name="pj_type" id="selectType">
			<option value="단일">단일팀프로젝트</option>
			<option value="협업">협업프로젝트</option>
			<option value="전사">전사프로젝트</option>
		</select><br> 
		프로젝트시작일: <input id="datePickerstart" type="text" name="pj_startdate"><br> 
		프로젝트마감일: <input id="datePickerend" type="text" name="pj_enddate"><br>
		프로젝트매니저: <input type="text" name="pj_manager" id="pj_manager" value="gdong123"readonly="readonly"><br> 
		프로젝트참여자: <input type="text" name="e_id" id="pj_members">
		<input type="button" id="projectMemberRegBtn" value="멤버 추가"><br>
		프로젝트내용: <input type="text" name="pj_contents" id="pj_contents">
		<input type="submit" value="새 프로젝트 생성">
	</form>

</body>
</html>