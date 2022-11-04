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
	
</script>

</head>
<body>

	<h1>(관리자페이지) 회의실 예약목록입니다.</h1>
	<div class="contents_wrap">

		<div class="contents">
			<table>
				<thead>
					<tr>
						<th scope="col">예약번호</th>
						<th scope="col">회의실번호</th>
						<th scope="col">사원아이디</th>
						<th scope="col">예약일자</th>
						<th scope="col">종료일자</th>
					</tr>
				</thead>
				<tbody id="contentsTbBody">
					<c:forEach var="roomreslist" items="${list}">

						<tr>
							<td><a href="/meetingroom/readresroom?rb_num=${roomreslist.rb_num}">${roomreslist.rb_num }</a></td>					
							<td>${roomreslist.mr_num}</td>
							<td>${roomreslist.e_id}</td>

							<td><fmt:parseDate var="datefmt"
									value="${roomreslist.rb_startday}" pattern="yyyy-MM-dd" /> 
							    <fmt:formatDate
									value="${datefmt}" pattern="yyyy-MM-dd" /></td>				
							<td><fmt:parseDate var="datefmt" value="${roomreslist.rb_startday}"
									pattern="yyyy-MM-dd" /> 
									<fmt:formatDate value="${datefmt}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
		<input type="button" class="list_btn" id="listBtn" value="회의실 관리페이지"
				onclick="location.href = '/meetingroom/listroom'" /> 

</body>
</html>