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
<h1>${u.e_name}의 상세정보</h1>
<div class="detailBody">
	<table class="detailTable" border ="1" width = "1000px">
		<thread>
			<tr>
				<th>사원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>총연차일수</th>
				<th>연차사용일수</th>
				<th>생일</th>
				<th>직급</th>
				<th>부서번호</th>
				<th>권한</th>
				
			</tr>
		</thread>
	
		<tr>
			<td style="text-align: center">${u.e_num}</td>
			<td style="text-align: center">${u.e_id}</td>
			<td style="text-align: center">${u.e_name}</td>
			<td style="text-align: center">${u.e_pnum}</td>
			<td style="text-align: center"> ${u.e_totalvac}</td>
			<td style="text-align: center">${u.e_usevac}</td>
			<td style="text-align: center">${u.e_birth}</td>
			<td style="text-align: center">${u.e_position}</td>
			<td style="text-align: center">${u.d_num}</td>
			<td style="text-align: center">${a.a_auth}</td>	
			<%-- <td>${auth.auth}</td>	
 --%>			<%-- <td>${a.auth}</td>	 --%>
			
		</tr>
	
	</table>
	<a href="/hr/modifyView?e_id=${u.e_id}">수정하기</a>

</div>

</body>
</html>