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
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css" >
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
<div class="container">
			<div class="card border-light mb-3" style="max-width: 18rem;">
  				<div class="card-header">${myProject.pj_type }</div>
 					 <div class="card-body">
    					<h5 class="card-title">${myProject.pj_name }</h5>
    					<p class="card-text">
    						<%-- 프로젝트 매니저: ${myProject.pj_manager }<br>
    						프로젝트 시작일: ${myProject.pj_startdate }<br>
    						프로젝트 마감일: ${myProject.pj_enddate }<br> --%>
    						${myProject.pj_contents }
    					</p>
    					<a href="/projectdetail/home/${myProject.pj_num}" class="card-link"> 입장하기</a>
  				</div>
			</div>
</div>

</c:forEach>

</body>
</html>

