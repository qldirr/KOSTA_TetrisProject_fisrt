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

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<html>
<head>
</head>
<body>
<h1>Tables</h1>
<meta http-equiv="Context-Type" context="text/html; charset=UTF-8">
<title>Insert title here</title>
<div class="panel-heading">
<button id='regBnt' type="button" class="btn btn-secondary" 
onclick="location.href='http://localhost:8081/suggestions/suggestionsregister'">Register New Suggestions</button>

</div>	

<div style="


 





;">

	<table class="table table-striped table-bordered table-hover" id="list">
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
				<td><c:out value="${suggestions.s_num}"/></td>				
				<td><c:out value="${suggestions.e_id}"/></td>				
				<td><a href='/suggestions/suggestionsget?s_num=<c:out value="${suggestions.s_num}"/>'>
				<c:out value="${suggestions.s_title}"/></a></td>				
				<td><c:out value="${suggestions.s_contents}"/></td>				
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${suggestions.s_regdate}" /></td>					
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${suggestions.s_moddate}" /></td>							
			</tr>				
		</c:forEach>				
	</table>
</div>





<!--<script type="text/javascript">
	function move(){
		$("regBnt").on("click",function(){
			self.location = "suggesions/suggesionslist";		
		};	
</script>-->
	
      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="../includes/footer.jsp"%>
</body>
</html>
