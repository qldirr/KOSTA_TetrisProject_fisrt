<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script type="text/javascript">
		$(document).ready(function(){
			
			$("#uploadBtn").on("submit", function(e){
				 var formData = new FormData();
				 var inputFile = $("input[name='uploadFile']");
				 var files = inputFile[0].files;
				
				 console.log(files);
				 
				 for(var i=0;i<files.length;i++){
					 formData.append("uploadFile", files[i]);
				 }
				 
				 $.ajax({
					 url: '/messanger/uploadAjaxAction',
					 processData: false,
					 contentType: false,
					 data: formData
					 type: 'POST',
					 success: function(result){
					 	alert("Uploaded");
					 }
				}); //$.ajax
				
				/* $.ajax({
					 url: '/messanger/uploadAjaxAction',
					 processData: false,
					 contentType: 'application/json',
					 data: JSON.stringify({"cr_id" : cr_id})
					 type: 'POST',
					 success: function(result){
					 	alert("Uploaded");
					 }
				}); */
				 
			});//end uploadBtn click
		});//end document read
</script>

</head>
<body>
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/>
	<div id="messageArea"></div>
	<input type="hidden" id="roomId" value="${cr_id}">
	<h1>${cr_id}</h1>
	<div><h4><sec:authentication property="principal" var="principal"/></h4></div>
	<form id="uploadBtn" action="/messanger/uploadAjaxAction" method="post">
	<input type="hidden" id="cr_id" value="${cr_id}">
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>

	<div class='uploadResult'>
		<ul>

		</ul>
	</div>

	<input type="submit" value="Upload">
	<!-- <button id='uploadBtn'>Upload</button> -->
	</form>
	
	<%-- <c:forEach items="${listChatMsg }" var="list">
		<c:out value="${list.cm_contents}" /><br>
	</c:forEach> --%>
	<!-- <form action="/messanger/chatting/{roomId}/fileupload" method='post' enctype='multipart/form-data'>
		<input type="file" name="uploadFile" multiple />
		<button>Submit</button>
	</form><br> -->
</body>
<script type="text/javascript">

	$("#sendBtn").on('click', function() {
		sendMessage();
		$('#message').val('')
	});
	$('#message').on('keydown', function(){
		if(event.keyCode == '13'){
			sendMessage();
			$('#message').val('')
		}
	});
	
	var roomId = $("#roomId").val();
	var webSocket;
	/* webSocket = new WebSocket("ws://localhost:8081/chatting/" + roomId); */
	webSocket = new SockJS("http://localhost:8081/chatting/" + roomId);
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
	
	function onOpen(){
		/* alert("웹소켓 접속"); */
		html = '<c:forEach items="${listChatMsg }" var="list">';
		html += '<c:out value="${list.e_id}" />: ';
		html += '<c:out value="${list.cm_contents}" /><br>';
		html += '</c:forEach>';
		$("#messageArea").append(html);
	}
	
	// 메시지 전송
	function sendMessage() {
		/* var data = {
				"cr_id" : roomId,
				"e_id" : "e_id"<sec:authentication property="principal.username"/>,
				"cm_contents" : $("#message").val()
			}
			var jsonData = JSON.stringify(data);
			webSocket.send(jsonData); */
		var e_id = '${principal.username}';
		$.ajax({
			url: '/messanger/registerMsg',
			type: 'post',
			contentType: 'application/json',
			async: false,
			data: JSON.stringify({
				"cr_id" : roomId,
				"e_id" : e_id,
				"cm_contents" : $("#message").val()
			}),
			success : function(){
				alert("success");
			}
		});
		webSocket.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		/* var receive = msg.data.split(",");
		var data = {
			"cr_id" : receive[0],
			"e_id" : receive[1],
			"cm_contents" : receive[2]
		}; */
		
		var data = msg.data;
		$("#messageArea").append(data/* .cm_contents */ + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");
	}
</script>
</html>