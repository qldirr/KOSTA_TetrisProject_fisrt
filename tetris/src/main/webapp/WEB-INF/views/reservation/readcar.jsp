<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="contents_wrap">
		<!-- view -->
		<form action="" id="readcar" method="get">
		<input type = "hidden" name = "mode" id = "mode" value = "${param.mode}" /> 
		<input type="hidden" name="ca_num" id="ca_num" value="${readcar.ca_num}" />

			<div class="contents">
				<!-- 상세 정보 -->
				<table>
					<tbody>
						<tr>
							<th scope="col">차량 번호</th>
							<td class="left">${readcar.ca_num}</td>
						</tr>
						<tr>
							<th scope="col">차량 모델 명</th>
							<td class="left">${readcar.ca_model}</td>
						</tr>
						<tr>
							<th scope="col">차종</th>
							<td class="left">${readcar.ca_type }</td>
						</tr>
						<tr>
							<th scope="col">연식</th>
							<td class="left">${readcar.ca_age}</td>
						</tr>

					</tbody>
				</table>
			</div>
	
		</form>
		<div class="btn_wrap">
			<input type="button" class="list_btn" id="listBtn" value="목록"
				onclick="location.href = '/reservation/listcar'" /> 
		</div>
	</div>
	


</body>
</html>