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

$(function(){	
	
	var cb_num = "";
	var resApp_btn= $('.resApp_Btn');


$(resApp_btn).click(function() {
			
		cb_num = $(this).parent().parent().find('.num').text();
		
		console.info(cb_num);
		
		$.ajax({
			url : "/reservation/setCarApp",
			data : {cb_num:cb_num},
			type : "post",
			}).
			done(function(){		
				
				self.location = "/reservation/listrescar";
			
			});		 
	})

});


</script>

</head>
<body>

	<h1>차량 예약목록입니다.</h1>
	<div class="contents_wrap">

		<div class="contents">
			<table>
				<thead>
					<tr>
						<th scope="col">예약번호</th>
						<th scope="col">차량번호</th>
						<th scope="col">사원아이디</th>
						<th scope="col">예약일자</th>
						<th scope="col">예약시간</th>
						<th scope="col">종료일자</th>
						<th scope="col">종료시간</th>
					</tr>
				</thead>
				<tbody id="contentsTbBody">
					<c:forEach var="carreslist" items="${list}">

						<tr>
							<td class ="num"><a href="/reservation/readrescar?cb_num=${carreslist.cb_num}">${carreslist.cb_num }</a></td>					
							<td>${carreslist.ca_num}</td>
							<td>${carreslist.e_id}</td>

							<td><fmt:parseDate var="datefmt"
									value="${carreslist.cb_startday}" pattern="yyyy-MM-dd" /> 
							    <fmt:formatDate
									value="${datefmt}" pattern="yyyy-MM-dd" /></td>
							<td>${carreslist.cb_starttime}</td>
							<td><fmt:parseDate var="datefmt" 
							        value="${carreslist.cb_endday}" pattern="yyyy-MM-dd" /> 
								<fmt:formatDate value="${datefmt}"
									pattern="yyyy-MM-dd" /></td>
							<td>${carreslist.cb_endtime}</td>
							
							<td><input type="button" class="resApp_Btn" id="resApp_Btn" value="승인"/> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
		

</body>
</html>