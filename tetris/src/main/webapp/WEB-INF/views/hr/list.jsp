<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title></title>
<link href="/resources/css/cusList.css" rel="stylesheet">
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<div class="listBody">
	<table class="listtable" border ="1" width = "700px" style= "text-align:center">
		<thread>
			<tr>
				<th>사원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>입사일</th>
			</tr>
		</thread>
		
		<tbody>
	<c:forEach items="${list}" var="u" >

		<tr>
			<%-- <td><a href="/hr/detail?userNumber=${u.userNumber}">${u.userNumber}</a></td> --%>
			<td style="text-align: center">${u.e_num}</td>
			<td style="text-align: center"><a href="/hr/detail?e_id=${u.e_id}">${u.e_id}</a></td>	
			<td style="text-align: center">${u.e_name}</td>
			<td style="text-align: center">${u.e_hireddate}</td>
			<!-- <td style="text-align: center"><a href="/hr/delete">삭제하기</a></td>	 -->	
			<!-- <input type="submit" > -->		
		</tr>
		
	</c:forEach>
		</tbody>
	</table>


</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>