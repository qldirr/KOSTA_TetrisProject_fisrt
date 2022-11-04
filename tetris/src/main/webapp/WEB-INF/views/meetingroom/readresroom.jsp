<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/vender/res/bootstrap-datepicker3.css"
	rel="stylesheet">
<link href="/resources/vender/res/jquery.timepicker.min.css"
	rel="stylesheet">	

<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/vender/res/bootstrap-datepicker.js"></script>
<script src="/resources/vender/res/jquery.timepicker.min.js"></script>

<script type="text/javascript">

	
</script>
</head>
<body>
	<div class="contents_wrap">
		<form action="" method="get"
			id="readresroom">
				<%-- <input type = "hidden" name = "mode" id = "mode" value = "${param.mode}" />  --%>
			

			<div class="contents">
				<table>
					<tbody id="contentsTbBody">
						<tr>
							<th scope="col">예약자</th>
							<td class="left"><c:out value="${readresroom.e_id}"></c:out></td>
						</tr>
						<tr>
							<th scope="col">예약회의실</th>
							<td class="left">${readresroom.mr_num}</td>
						</tr>
						<tr>
							<th scope="col">예약시작일자</th>
							<td class="left"><fmt:parseDate var="datefmt" value="${readresroom.rb_startday}" pattern="yyyy-MM-dd" /> 
							    <fmt:formatDate value="${datefmt}" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr>
							<th scope="col">예약시작시간</th>
							<td class="left"><fmt:parseDate var="timefmt" value="${readresroom.rb_starttime}" pattern="hh:mm" /> 
							    <fmt:formatDate value="${timefmt}" pattern="hh:mm" /></td>
						</tr>
						<tr>
							<th scope="col">예약종료일자</th>
						<td class="left"><fmt:parseDate var="datefmt" value="${readresroom.rb_endday}" pattern="yyyy-MM-dd" /> 
							<fmt:formatDate value="${datefmt}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th scope="col">예약종료시간</th>
							<td class="left"><fmt:parseDate var="timefmt" value="${readresroom.rb_endtime}" pattern="hh:mm" /> 
							    <fmt:formatDate value="${timefmt}" pattern="hh:mm" /></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</form>
		
	 <input type="button" class="list_btn" id="listBtn" value="메인페이지 이동"
				onclick="location.href = '/meetingroom/listroom" />	 
		
			

		</div>


</body>
</html>