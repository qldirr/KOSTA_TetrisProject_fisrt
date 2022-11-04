<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
<h1>.</h1>
 <div class="container-fluid ">
      <div class="row">
         <!-- sidebar -->
         <div class="col-xl-2 col-lg-3"></div>
         <div class="col-xl-10 col-lg-9">        
<div style=""width: 100%; height: 1000; ;">

<h1>Notice Read Page</h1>


	<table class="table table-striped table-bordered table-hover">	


        <!--  <form role="form" method="post">-->         
          
          <div class="form-group">
            <label>Num</label> <input class="form-control" name='n_num'
            value='<c:out value="${notice.n_num}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>Id</label> <input class="form-control" name='e_id'
            value='<c:out value="${notice.e_id}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>title</label> <input class="form-control" name='n_title'
            value='<c:out value="${notice.n_title}"/>' readonly="readonly">
          </div>

		<div class="form-group">
			<label>Contents</label> 			
			<textarea class="form-control" row="3" name='n_contents' style="height:200;" readonly="readonly"  ><c:out
			value="${notice.n_contents}" /></textarea>
		</div>



		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<button type="button" class="btn btn-info" id="button"
		onclick="location.href='/notice/modify?n_num=<c:out value="${notice.n_num}"/>'">
		Modify</button>
		</sec:authorize>
		<button type="button" class="btn btn-info" id="button" 
		onclick="location.href='/notice/list'">
		List</button>

    <style>
        #button{
            margin-left:5px;
        }
    </style>

<form id='operForm' action="/notice/modify" method="get">
	<input type='hidden' id='n_num' name='n_num' value='<c:out value="${notice.n_num}"/>'>
	<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
	<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
</form>

</table>



</div>
</div>
</div>
</div>
	
      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="../includes/footer.jsp"%>
</body>
</html>