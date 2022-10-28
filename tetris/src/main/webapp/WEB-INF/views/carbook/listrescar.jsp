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
			
			$("registerCarBtn").on("click", function() {
				self.location = "/Carbook/registerCar";
			});
			
		});
</script>

</head>
<body>


안녕안녕


<c:forEach items="${list }" var="listResCar">
<a href="${list.cb_num}">${listResCar.ca_num}</a>
<input type="button" id="registerCarBtn" value="대여">
</c:forEach>

</body>
</html>