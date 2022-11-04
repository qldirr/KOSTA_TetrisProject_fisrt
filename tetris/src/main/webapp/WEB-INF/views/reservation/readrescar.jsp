<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<h1>차량 상세보기</h1>
	<div class="contents_wrap">
		<form action="" method="get"
			id="rescar">
				<input type = "hidden" name = "mode" id = "mode" value = "${param.mode}" /> 
				<input type = "hidden" name = "ca_num" id = "ca_num" value = "${rescar.ca_num}" />
				<input type="hidden" id="cb_num" value="${rescar.cb_num}" />

			<div class="contents">
				<table>
					<tbody id="contentsTbBody">
						<tr>
							<th scope="col">예약자</th>
							<td class="left">${rescar.e_id}</td>
						</tr>
						<tr>
							<th scope="col">예약차량</th>
							<td class="left">${rescar.ca_num}</td>
						</tr>
						<tr>
							<th scope="col">예약시작일자</th>
							<td class="left"><fmt:parseDate var="datefmt" value="${rescar.cb_startday}" pattern="yyyy-MM-dd" /> 
							    <fmt:formatDate value="${datefmt}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th scope="col">예약시작시간</th>
							<td class="left"><fmt:parseDate var="timefmt" value="${rescar.cb_starttime}" pattern="hh:mm" /> 
							    <fmt:formatDate value="${timefmt}" pattern="hh:mm" /></td>
						</tr>
						<tr>
							<th scope="col">예약종료일자</th>
						<td class="left"><fmt:parseDate var="datefmt" value="${rescar.cb_endday}" pattern="yyyy-MM-dd" /> 
							<fmt:formatDate value="${datefmt}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th scope="col">예약종료시간</th>
							<td class="left"><fmt:parseDate var="timefmt" value="${rescar.cb_endtime}" pattern="hh:mm" /> 
							    <fmt:formatDate value="${timefmt}" pattern="hh:mm" /></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</form>
		
	 <input type="button" class="list_btn" id="listBtn" value="메인페이지 이동"
				onclick="location.href = '/reservation/rescarmain'" />	 
		
			

		</div>





</body>
</html>