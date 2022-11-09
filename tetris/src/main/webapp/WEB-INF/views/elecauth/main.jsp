<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">

$(function(){

	$('#regElecAuth').on('click', function(){
		self.location = "/elecauth/register";
	})
	
	$('#writtenList').on('click', function(){
		self.location = "/elecauth/writtenList";		
	})
	
	$('#uncheckedList').on('click', function(){
		self.location = "/elecauth/uncheckedList";		
	})
	
	$('#disapprovedList').on('click', function(){
		self.location = "/elecauth/disapprovedList";	
	})
	
	$('#sendList').on('click', function(){
		self.location = "/elecauth/sendList";	
	})	
	
	$('#getList').on('click', function(){
		self.location = "/elecauth/getList";	
	})	

})

</script>
</head>
<body>

<input type="button" id="regElecAuth" value="새 문서 작성하기">
<input type="button" id="writtenList" value="상신완료문서">
<input type="button" id="uncheckedList" value="결재대기문서">
<input type="button" id="disapprovedList" value="반려문서함">
<input type="button" id="sendList" value="발신문서함">
<input type="button" id="getList" value="수신문서함">


</body>
</html>
