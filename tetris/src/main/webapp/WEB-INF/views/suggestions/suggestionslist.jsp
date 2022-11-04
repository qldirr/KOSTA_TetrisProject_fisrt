<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ include file="../includes/header.jsp"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<head>
<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
					<script src="/resources/js/index.js"></script>



</head>
<body>
	<h1>Tables</h1>
	<!-- <meta http-equiv="Context-Type" context="text/html; charset=UTF-8"> -->


	<div class="container-fluid ">
		<div class="row">
			<!-- sidebar -->
			<div class="col-xl-2 col-lg-3"></div>
			<div class="col-xl-10 col-lg-9">
				<div style="width: 100%; height: 1000;">

					<h1>Suggestions List</h1>

					<button id='regBnt' type="button" class="btn btn-secondary"
						onclick="location.href='/suggestions/suggestionsregister'">Register
						New Suggestions</button>


					<table class="table table-striped table-bordered table-hover"
						id="list">
						<thead>
							<tr>
								<th width="10%">번호</th>
								<th width="10%">아이디</th>
								<th width="20%">제목</th>
								<th width="40%">내용</th>
								<th width="10%">작성일</th>
								<th width="10%">수정일</th>
							</tr>
						</thead>

						<c:forEach items="${list}" var="suggestions">
							<tr>
								<td><c:out value="${suggestions.s_num}" /></td>
								<td><c:out value="${suggestions.e_id}" /></td>
								<td>
								<a class='move' href='<c:out value="${suggestions.s_num}"/>'>
									<c:out value="${suggestions.s_title}" /></a>
								</td>
								<td><c:out value="${suggestions.s_contents}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${suggestions.s_regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${suggestions.s_moddate}" /></td>
							</tr>
						</c:forEach>
					</table>

					
					<!-- Modal  추가 -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<!--<h4 class="modal-title" id="myModalLabel">Modal title</h4> -->
								</div>
								<div class="modal-body">처리가 완료되었습니다.</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<!--<button type="button" class="btn btn-primary">Save
										changes</button>-->
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->					
					
					
					<div class='pull-right'>
						<ul class="pagination justify-content-center">

							<li><c:if test="${pageMaker.prev}">
									<li class="paginate_button previous"><a
										href="${pageMaker.startPage -1}">Previous</a></li>
								</c:if> <c:forEach var="num" begin="${pageMaker.startPage}"
									end="${pageMaker.endPage}">
									<li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
										<a href="${num}">${num}</a>
									</li>
								</c:forEach> <c:if test="${pageMaker.next}">
									<li class="paginate_button next"><a
										href="${pageMaker.endPage +1 }">Next</a></li>
								</c:if></li>

						</ul>
					</div>
					<!--  end Pagination -->

					<form id='actionForm' action="/suggestions/suggestionslist"
						method='get'>
						<input type='hidden' name='pageNum'
							value='${pageMaker.cri.pageNum}'/> <input type='hidden'
							name='amount' value='${pageMaker.cri.amount}'/>
					</form>


					<script type="text/javascript">
					$(document).ready(function() {
					
						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							}

							if (parseInt(result) > 0) {
								$(".modal-body").html(
										"게시글 " + parseInt(result)
												+ " 번이 등록되었습니다.");
							}

							$("#myModal").modal("show");
						}
						
						var actionForm = $("#actionForm");
						$(".paginate_button a").on("click", function(e) {
					
							e.preventDefault();
							
							console.log('click');
					
							actionForm.find("input[name='pageNum']").val($(this).attr("href"));
							actionForm.submit();
						});
						
						//실행x 315
						$(".move").on("click", function(e) {
							
							e.preventDefault();
							actionForm.append("<input type='hidden' name='s_num' value='"+
							$(this).attr("href")+ "'>");
							actionForm.attr("action", "/suggestions/suggestionsget");
							actionForm.submit();
							});	
			
							});
					
				
</script>









				</div>
			</div>
		</div>
	</div>













					<!-- Optional JavaScript; choose one of the two! -->

					<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
					<!-- <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script> -->
					

					<%@ include file="../includes/footer.jsp"%>
</body>
</html>