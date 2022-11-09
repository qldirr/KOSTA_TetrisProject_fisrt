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
<h1>회원목록</h1>
<div class="listBody">
	<table class="listTable" border ="1" width = "700px">
		<thread>
			<tr>
				<th>사원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>입사일</th>
			</tr>
		</thread>
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
	
	</table>


</div>
</body>
</html>