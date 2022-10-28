<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>일정 등록</h2>
	<form action="/calendar/register" method="post">
		<label>일정제목</label><input name="cl_name">
		<label>시작날짜</label><input name="cl_startdate">
		<label>종료날짜</label><input name="cl_enddate">
		<label>시작시간</label><input name="cl_starttime">
		<label>종료시간</label><input name="cl_endtime">
		<label>일정종류</label><input name="cl_type">
		<label>일정내용</label><input name="cl_contents">
		<label>일정색깔</label><input name="cl_color">
		<label>아이디</label><input name="e_id">
		
		<button type="submit">등록</button>
		<button type="reset">취소</button>
	
	</form>
</body>
</html>
<!-- db에 등록 -->