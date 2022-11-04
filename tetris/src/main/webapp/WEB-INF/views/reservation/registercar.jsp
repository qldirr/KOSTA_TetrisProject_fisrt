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
	//차량등록
	$("#enroll").click(function() {
		if(confirm("등록하시겠습니까?")){
			chkReq();										
		}
		return false;
	})

});
	//등록 필수 값 체크
	function chkReq(){
		if($("#ca_num").val() == null || $("#ca_num").val() == "" ){
			alert("차량번호를 입력해주세요.");
			$("#ca_num").focus();
			return false;
		}
				
		if($("#ca_type").val() == null || $("#ca_type").val() == "" ){
			alert("차량모델명을 입력해주세요.");
			$("#ca_type").focus();
			return false;
		}
		
		
		if($("#ca_model").val() == null || $("#ca_model").val() == "" ){
			alert("차종을 입력해주세요.");
			$("#ca_model").focus();
			return false;
		}
				
		if($("#ca_age").val() == null || $("#ca_age").val() == "" ){
			alert("연식을 입력해주세요.");
			$("#ca_age").focus();
			return false;
		}
		
		var mode = $("#mode").val();
		if("write" == mode){
			$('#registercareform').attr("action", "/reservation/registercar")
			$("#registercareform").submit()
		
		}
		
		
	}

	
</script>
</head>
<body>
<h1>(관리자)차량 등록</h1>
	<div class="contents_wrap">
		<form action="/reservation/registercar" method="post"
			id="registercareform">
			<input type="hidden" name="mode" id="mode" value="write" />

			<div class="contents">
				<table>
					<tbody id="contentsTbBody">
						<tr>
							<th scope="col">차량 번호</th>
							<td class="left"><input type="text" name="ca_num"
								id="ca_num"></td>
						</tr>
						<tr>
							<th scope="col">차량 모델 명</th>
							<td class="left"><input type="text" name="ca_model"
								id="ca_model"></td>
						</tr>
						<tr>
							<th scope="col">차종</th>
							<td class="left"><input type="text" name="ca_type"
								id="ca_type"></td>
						</tr>
						<tr>
							<th scope="col">연식</th>
							<td class="left"><input type="text" name="ca_age"
								id="ca_age"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="btn">
			<input type="button" class="list_btn" id="listBtn" value="목록"
				onclick="location.href = '/reservation/listcar'" /> 
			<input type="button" class="write_btn" value="등록" id="enroll" /> 
			

		</div>

	</div>




</body>
</html>