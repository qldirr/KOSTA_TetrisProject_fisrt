<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="/resources/css/mycss/bootstrap-datepicker3.css" />
<link rel="stylesheet" href="/resources/css/mycss/jquery.timepicker.min.css" />
<style type="text/css">
	#list{
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
	}
	
	#modify{
		border-style: none;
		background-color: #FFF2CA;
		color: #161E67;
		border-radius: 10px;
		padding-bottom: 7px;
		padding-top: 7px;
		padding-left: 10px;
		padding-right: 10px;
		font-weight: bold;
		font-family: sans-serif;
		margin-left: 10px;
	}
	
	#remove{
		border-style: none;
		background-color: #D2D2D2;
		color: black;
		border-radius: 10px;
		padding-bottom: 7px;
		padding-top: 7px;
		padding-left: 10px;
		padding-right: 10px;
		font-weight: bold;
		font-family: sans-serif;
		margin-left: 10px;
	}
	
	.col-sm-2 col-form-label{
		font-family: sans-serif;
	}
	
	h1{
		font-family: sans-serif;
	}
</style>


<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/js/myjs/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/resources/js/myjs/jquery.timepicker.min.js" type="text/javascript"></script>
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
				
				
				var moveTo = (function(){     //일정등록 버튼 눌렀을때 등록 폼으로 이동
					function listCal(){
						self.location = "/calendar/list";
					}
					
					return {
						
						listCal : listCal
						}
					})();
				
				$(function() {
					
					$('#list').on('click', moveTo.listCal);
				})     //등록 폼으로 이동 끝
				
				var form = $("#form");
				
				$("#remove").on("click", function(e){
					form.attr("action", "/calendar/remove").submit();
				});
				$("#modify").on("click", function(e){
					form.attr("action", "/calendar/modify").submit();
				});
				
				
		});
	
</script>
</head>
<body>

<h1>일정 상세</h1>

	<!--<form action="/calendar/modify" method="post" role="form" accept-charset="UTF-8" id="form">
		<input type="hidden" name="e_id" value='<c:out value="${calendar.e_id }"/>'>
		<input type="hidden" name="cl_num" value='<c:out value="${calendar.cl_num }"/>'>
		일정명: <input type="text" name="cl_name" value='<c:out value="${calendar.cl_name }"/>'><br> 
		일정 시작일: <input id="datePickerstart" type="text" name="cl_startdate" value='<c:out value="${calendar.cl_startdate }"/>'><br> 
		일정 시작시간: <input type="text" name="cl_starttime" class="timepicker" value='<c:out value="${calendar.cl_starttime }"/>'><br>
		일정 마감일: <input id="datePickerend" type="text" name="cl_enddate" value='<c:out value="${calendar.cl_enddate }"/>'><br>
		일정 마감시간: <input type="text" name="cl_endtime" class="timepicker" value='<c:out value="${calendar.cl_endtime }"/>'><br>
		색깔: <input type="color" name="cl_color" value='<c:out value="${calendar.cl_color }"/>'><br>
		일정 내용: <textarea rows="8" cols="70" id="cl_contents" name="cl_contents" value='<c:out value="${calendar.cl_contents }"/>'></textarea><br>
		<input type="button" id="list" value="일정 목록">
		<input type="submit" id="modify" value="일정 수정">
		<input type="submit" id="remove" value="일정 삭제">
		
		
	</form>-->
	
	<form method="post" accept-charset="UTF-8" id="form">
		<input type="hidden" name="e_id" value='<c:out value="${calendar.e_id }"/>'>
		<input type="hidden" name="cl_num" value='<c:out value="${calendar.cl_num }"/>'> 
		<div class="form-group row">
			<label for="input_cl_name" class="col-sm-2 col-form-label">일정명</label>
			<div class="col-sm-10">
				<input type="text" name="cl_name" value='<c:out value="${calendar.cl_name }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_startdate" class="col-sm-2 col-form-label">일정 시작일</label>
			<div class="col-sm-10">
				<input id="datePickerstart" type="text" name="cl_startdate" value='<c:out value="${calendar.cl_startdate }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_starttime" class="col-sm-2 col-form-label">일정 시작시간</label>
			<div class="col-sm-10">
				<input type="text" name="cl_starttime" class="timepicker" value='<c:out value="${calendar.cl_starttime }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_enddate" class="col-sm-2 col-form-label">일정 마감일</label>
			<div class="col-sm-10">
				<input id="datePickerend" type="text" name="cl_enddate" value='<c:out value="${calendar.cl_enddate }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_endtime" class="col-sm-2 col-form-label">일정 마감시간</label>
			<div class="col-sm-10">
				<input type="text" name="cl_endtime" class="timepicker" value='<c:out value="${calendar.cl_endtime }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_color" class="col-sm-2 col-form-label">색깔</label>
			<div class="col-sm-10">
				<input type="color" name="cl_color" value='<c:out value="${calendar.cl_color }"/>'>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="input_cl_contents" class="col-sm-2 col-form-label">일정 내용</label>
			<div class="col-sm-10">
				<textarea rows="8" cols="50" id="cl_contents" name="cl_contents" value='<c:out value="${calendar.cl_contents }"/>'></textarea>
			</div>
		</div>
		
		
		<div class="form-group row">
			<div class="col-sm-10">
				<input type="button" id="list" value="일정 목록">
				<input type="submit" id="modify" value="일정 수정">
				<input type="submit" id="remove" value="일정 삭제">
	
			</div>
		</div>
	</form>
	
		
	
</body>
</html>