<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var actionForm = $("#actionForm");

$(function(){	
$(".move") .on(
			"click",
			function(e) {
				console.log("carDetail");
				e.preventDefault();
				actionForm
						.append("<input type='hidden' name='ca_num' value='"
								+ $(this).attr("href") + "'>");
				actionForm.attr("action", "/reservation/readcar");
				actionForm.submit();
			});
			
});

</script>


</head>
<body>

<h1>(관리자)차량목록입니다.</h1>

		<div class="contents_wrap">

			<div class="contents">
				<table>
					<thead>
						<tr>
							<th scope="col">차량번호</th>
							<th scope="col">차량모델명</th>
							<th scope="col">차종</th>
							<th scope="col">연식</th>
							<th scope="col">등록일자</th>
							<th scope="col">수정일자</th>
						</tr>
					</thead>
					<tbody id="contentsTbBody">
						<c:forEach var="carlist" items="${list}">

							<tr>
								<td>${carlist.ca_num }</td>
								<td><a href="/reservation/readcar?ca_num=${carlist.ca_num}">${carlist.ca_model}</a></td>
								<td>${carlist.ca_type}</td>
								<td>${carlist.ca_age}</td>

								<td><fmt:formatDate value="${carlist.ca_regdate}"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${carlist.ca_modifydate}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				 <a href="/reservation/registercar">
					<input type="button" class="auto_wth_btn_b" value="차량등록" id = writeBtn />
				</a>
			</div>
		</div>
	
</body>
</html>