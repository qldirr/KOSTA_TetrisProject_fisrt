<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">


$(document).ready(
		function(){
			
			$("#projectRegBtn").on("click", function() {
				self.location = "/project/register";
			});
			
		});
</script>

</head>
<body>

<input type="button" id="projectRegBtn" value="새 프로젝트 만들기"><br>
<c:forEach items="${list }" var="myProject">
<a href="/projectdetail/home/${myProject.pj_num}">${myProject.pj_name }</a><br><br>
</c:forEach>

</body>
</html>

