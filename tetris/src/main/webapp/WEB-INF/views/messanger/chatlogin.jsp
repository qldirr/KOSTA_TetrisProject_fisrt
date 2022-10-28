<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="/messanger/chatlogin" method="post">
		<input type="text" name="user" id="user" class="form-control" placeholder="유저명">
		<button type="submit" class="btn btn-default" id="btnConnect">연결</button>
	</form>
</body>
</html>