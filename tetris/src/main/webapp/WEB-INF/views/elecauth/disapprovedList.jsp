<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="/resources/vender/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">

	$(function(){
		
		$('a').on('click', function(e){
			e.preventDefault();
			var el_num = $(this).attr('href');
			
			self.location = '/elecauth/document/' + el_num;

			
	})
	
	})

</script>
</head>
<body>

	<h1>반려문서함</h1>

	<table class="table table-bordered table-sm" style="width: 70%">
		<thead>
			<tr>
				<th scope="col" style="width: 18%">문서번호</th>
				<th scope="col" style="width: 12%">문서유형</th>
				<th scope="col" style="width: 20%">문서제목</th>
				<th scope="col" style="width: 10%">기안자</th>
				<th scope="col" style="width: 20%">기안일</th>
				<th scope="col" style="width: 20%">결재상태</th>
			</tr>
		</thead>
		<tbody class="elecauthlist">
			<c:forEach items="${authlist}" var="auth">
				<tr>
					<td><c:if test="${auth.dm_num == 1}">
							<c:out value="일반기안-${auth.el_num }" />
						</c:if> <c:if test="${auth.dm_num == 2}">
							<c:out value="연차신청-${auth.el_num }" />
						</c:if></td>
					<td><c:if test="${auth.dm_num == 1}">
							<c:out value="일반기안" />
						</c:if> <c:if test="${auth.dm_num == 2}">
							<c:out value="연차신청" />
						</c:if></td>
					<td><a href="${auth.el_num }">${auth.el_name}</a></td>
					<td>${auth.e_id}</td>
					<td><fmt:parseDate value="${auth.el_regdate}" var="regdate"
							pattern="yyyy-MM-dd" /> <fmt:formatDate value="${regdate}"
							var="date" pattern="yyyy-MM-dd" /> <c:out value="${date}" /></td>
					<td>${auth.el_status}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>