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
</head>
<body>


<jsp:include page="../includes/header.jsp"></jsp:include>
			<!-- 보조메뉴바 시작 -->
			
			<div class="s-menu">
				<div class="s-menu-title">
					<p>프로젝트<i class="bi bi-tags"></i>
				</div>
				<div class="s-list-item ">
				    <input id="newbtn" type="button" value="새 프로젝트 만들기" onclick="self.location = '/project/register';">
				</div>

			</div>
			
			
	<div class="s-container">
		<div class="container">
			<c:forEach items="${list }" var="myProject">
					
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
					
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>

