<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/vender/res/bootstrap-datepicker3.css"
	rel="stylesheet">
<link href="/resources/vender/res/jquery.timepicker.min.css"
	rel="stylesheet">	

<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/vender/res/bootstrap-datepicker.js"></script>
<script src="/resources/vender/res/jquery.timepicker.min.js"></script>

<script type="text/javascript">

$(function(){	
	//회의실등록
	$("#enroll").click(function() {
		if(confirm("등록하시겠습니까?")){
			chkReq();										
		}
		return false;
	})

});
	//등록 필수 값 체크
	function chkReq(){
		if($("#mr_num").val() == null || $("#mr_num").val() == "" ){
			alert("회의실 번호를 입력해주세요.");
			$("#mr_num").focus();
			return false;
		}
				
		if($("#mr_name").val() == null || $("#mr_name").val() == "" ){
			alert("회의실 이름을 입력해주세요.");
			$("#ca_type").focus();
			return false;
		}
		
		
		if($("#mr_total").val() == null || $("#mr_total").val() == "" ){
			alert("수용 인원 수를 입력해주세요.");
			$("#ca_model").focus();
			return false;
		}
				
		
		var mode = $("#mode").val();
		if("write" == mode){
			$('#registerroomeform').attr("action", "/meetingroom/registerroom")
			$("#registerroomeform").submit()
		
		}
		
		
	}

	
</script>
</head>
<body>
<h1>(관리자페이지) 회의실 등록입니다.</h1>


	<div class="contents_wrap">
		<form action="/meetingroom/registerroom" method="post"
			id="registerroomeform">
			<input type="hidden" name="mode" id="mode" value="write" />

			<div class="contents">
				<table>
					<tbody id="contentsTbBody">
						<tr>
							<th scope="col">회의실번호</th>
							<td class="left"><input type="text" name="mr_num"
								id="mr_num""></td>
						</tr>
						<tr>
							<th scope="col">회의실이름</th>
							<td class="left"><input type="text" name="mr_name"
								id="mr_name"></td>
						</tr>
						<tr>
							<th scope="col">수용인원</th>
							<td class="left"><input type="text" name="mr_total"
								id="mr_total"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="btn">
			<input type="button" class="list_btn" id="listBtn" value="목록"
				onclick="location.href = '/meetingroom/listroom'" /> 
			<input type="button" class="write_btn" value="등록" id="enroll" /> 
			

		</div>

	</div>




</body>
</html>