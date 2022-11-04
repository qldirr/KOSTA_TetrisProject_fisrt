<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#listChatRoom li").on('dblclick', function(){
			var cr_id = $(this).attr('class');
			$.ajax({
				url: '/messanger/chatting',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({"cr_id" : cr_id}),
				success : function() {
					window.location.href = "/messanger/chatting";
				}
			});
		})
	})
</script>
</head>
<body>
	<div>
		<ul id="listChatRoom">
			<c:forEach items="${listChatRoom }" var="list">
				<li class="${list.cr_id }">${list.cr_id }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>