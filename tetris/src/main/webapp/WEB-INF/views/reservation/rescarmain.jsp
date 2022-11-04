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

	<h1>차량 예약페이지</h1>

	<div class="contents_wrap">

		<div class="contents">
			<table>
				<thead>
					<tr>
						<th scope="col">차량번호</th>
						<th scope="col">차량모델명</th>
						<th scope="col">차종</th>
						<th scope="col">연식</th>
					</tr>
				</thead>
				<tbody id="contentsTbBody">
					<c:forEach var="carlist" items="${list}">
						<tr>
							<td class ="canum">${carlist.ca_num }</td>
							<td>${carlist.ca_model}</td>
							<td>${carlist.ca_type}</td>
							<td>${carlist.ca_age}</td>
								<td>
								<a href="/reservation/registerrsecar?ca_num=${carlist.ca_num}">
								<input type="button" class="auto_wth_btn_b" value="대여하기" id=rescarBtn /></a></td>	
						</tr>
					</c:forEach>
				</tbody>
			</table>			
		</div>
			
	</div>

</body>
</html>