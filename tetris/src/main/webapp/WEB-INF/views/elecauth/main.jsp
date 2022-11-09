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


</script>
</head>
<body>
<div class="wrap">
			<jsp:include page="../includes/header.jsp"></jsp:include>
			<!-- 보조메뉴바 시작 -->
			
			<div class="s-menu">
				<div class="s-menu-title">
					<p>전자결재 <i class="bi bi-tags"></i>
				</div>
				<div class="s-list-item ">
				    <input id="newbtn" type="button" value="새 문서 작성" onclick="self.location = '/elecauth/register';">
				</div><br>
				<div class="s-list-item ">
					<a href="/elecauth/writtenList">상신문서함</a>
				</div>
				<div class="s-list-item ">
					<a href="/elecauth/uncheckedList">결재대기문서</a>
				</div>
				<div class="s-list-item ">
					<a href="/elecauth/disapprovedList">반려문서함</a>
				</div>
				<div class="s-list-item ">
					<a href="/elecauth/sendList">발신문서함</a>
				</div>
				<div class="s-list-item ">
					<a href="/elecauth/getList">수신문서함</a>
				</div>
			</div>
			
			
<div class="wrap-box">
		<div class="s-container">
			<br><br>
			<h2 id="c-title">전자결재</h2>
			
			<div class="contents_wrap">
				<h5>결재대기문서</h5>
				<h5>결재완료문서</h5>
			</div>
		</div>
</div>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>