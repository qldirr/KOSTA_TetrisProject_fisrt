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

</head>
<body>
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/>
	<div id="messageArea"></div>
	<input type="hidden" id="roomId" value="${cr_id}">
	<h1>방이름</h1>
	<h1>${cr_id}</h1>
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
	webSocket = new WebSocket("ws://localhost:8081/chatting/" + roomId);
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
	
	function onOpen(msg){
		/* alert("채팅 접속"); */
	}
	
	/* var sock = new SockJS("http://localhost:8081/chatting" + "${user.e_name}");
	sock.onmessage = onMessage;
	sock.onclose = onClose; */
	// 메시지 전송
	function sendMessage() {
		webSocket.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		var data = msg.data;
		$("#messageArea").append(data + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");
	}
</script>
</html>