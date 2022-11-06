<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인입니다.</title>

</head>
<body>

	<!-- jsp 인클루드 사용-->
	<jsp:include page="includes/header.jsp"></jsp:include>

	
			<!-- 보조사이드바 -->
			<div class="s-menu">
				<div class="s-menu-title">
					<p>보조바 메뉴바명</p>
					<i class="fa-solid fa-pen-to-square fa-lg"></i>
				</div>
				<div class="s-list-item ">
				    <input id="newbtn" type="button" value="새 파일" onclick="">
				</div>
				<div class="s-list-item ">
					<a href="">보조메뉴바 1</a>
				</div>
				<div class="s-list-item ">
					<a href="">보조메뉴바 2</a>
				</div>
			</div>
			<!-- 보조사이드바 끝-->

			<!-- 내용 시작 -->
			<div class="s-container">
				<h2 id="c-title">제목</h2>

			</div>

			<!-- 내용 끝 -->

		<!-- 전체 wrapper 끝 -->
		<jsp:include page="includes/footer.jsp"></jsp:include>
	
</body>

</html>



