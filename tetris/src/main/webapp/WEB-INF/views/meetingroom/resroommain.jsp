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

<h1>(추후 사이드바)회의실 목록입니다.</h1>

		<div class="contents_wrap">

			<div class="contents">
				<table>
					<thead>
						<tr>
							<th scope="col">회의실번호</th>
							<th scope="col">회의실이름</th>
							<th scope="col">인원수 </th>
							<th scope="col">등록일자</th>
							<th scope="col">수정일자</th>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<c:forEach var="roomlist" items="${list}">

							<tr>
								<td><a href="/meetingroom//resroomcal?mr_num=${roomlist.mr_num}">${roomlist.mr_num }</a></td>
								<td><a href="/meetingroom/registerrseroom?mr_num=${roomlist.mr_num}">${roomlist.mr_name}</a></td>
								<td>${roomlist.mr_total}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	
</body>
</html>