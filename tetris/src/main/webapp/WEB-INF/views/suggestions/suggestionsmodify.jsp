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
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
</head>
<body>
	<h1>Suggestions Modify Page</h1>

	 <form role="form" action="/suggestions/modify" method="post">	 
		 
		<div class="form-group">
			<label>Num</label> 
			<input class="form-control" name='s_num'
				value='<c:out value="${suggestions.s_num}"/>' readonly="readonly">
		</div>

		<div class="form-group">
			<label>Id</label> 
			<input class="form-control" name='e_id'
				value='<c:out value="${suggestions.e_id}"/>' readonly="readonly">
		</div>

		<div class="form-group">
			<label>Title</label> 			
			<input class="form-control" name='s_title'
				value='<c:out value="${suggestions.s_title}"/>' >
		</div>

		<div class="form-group">
			<label>Contents</label> 			
			<textarea class="form-control" row="3" name='s_contents' ><c:out
			value="${suggestions.s_contents}"/></textarea>
		</div>

		<div class="form-group">
			<label>RegDate</label> 
			<input class="form-control" name='s_regdate'
				value='<fmt:formatDate pattern="yyyy-MM-dd" value="${suggestions.s_regdate}" />' readonly="readonly">
		</div>

		<div class="form-group">
			<label>ModDate</label> 
			<input class="form-control" name='s_moddate'
				value='<fmt:formatDate pattern="yyyy-MM-dd" value="${suggestions.s_moddate}" />' readonly="readonly">
		</div>
		

		  <button type="submit" data-oper='modify' class="btn btn-info">Modify</button>
		  <button type="submit" data-oper='remove' class="btn btn-info">Remove</button>			  
		  <button type="submit" data-oper='list' class="btn btn-info">List</button>

	</form>

 
		<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form");
			
			$('button').on("click", function(e){
				e.preventDefault();
				
				var operation = $(this).data("oper");
				
				console.log(operation);
				
				if(operation === 'remove'){
					formObj.attr("action", "/suggestions/remove");
				}else if(operation === 'list'){
					
					self.location="/suggestions/suggestionslist";
					return;
				}
				formObj.submit();
			});
		}); 
		</script>	


      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="../includes/footer.jsp"%>

   
</body>
</html>
