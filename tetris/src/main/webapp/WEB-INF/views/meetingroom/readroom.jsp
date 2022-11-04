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
		<form action="" id="readroom" method="get">
		<input type = "hidden" name = "mode" id = "mode" value = "${param.mode}" /> 
		<input type="hidden" name="mr_num" id="mr_num" value="${readroom.mr_num}" />

			<div class="contents">
				<!-- 상세 정보 -->
				<table>
					<tbody>
						<tr>
							<th scope="col">회의실번호</th>
							<td class="left">${readroom.mr_num}</td>
						</tr>
						<tr>
							<th scope="col">회의실이름</th>
							<td class="left">${readroom.mr_name}</td>
						</tr>
						<tr>
							<th scope="col">수용인원</th>
							<td class="left">${readroom.mr_total}</td>
						</tr>

					</tbody>
				</table>
			</div>
	
		</form>
		<div class="btn_wrap">
			<input type="button" class="list_btn" id="listBtn" value="목록"
				onclick="location.href = '/meetingroom/listroom'" /> 
		</div>
	</div>
	


</body>
</html>