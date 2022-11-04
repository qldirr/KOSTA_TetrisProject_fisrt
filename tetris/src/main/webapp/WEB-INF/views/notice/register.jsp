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
<h1>.</h1>
 <div class="container-fluid ">
      <div class="row">
         <!-- sidebar -->
         <div class="col-xl-2 col-lg-3"></div>
         <div class="col-xl-10 col-lg-9">        
<div style=""width: 100%; height: 1000; ;">

	<h1>Notice Register</h1>

	<table class="table table-striped table-bordered table-hover">	
    <form role="form" action="/notice/register" method="post"> 

          <div class="form-group">
            <label>Id</label> <input class="form-control" name='e_id' id="floatingInput" value= '${userId}' readonly="readonly">
          </div>
			
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='n_title' id="floatingInput" placeholder="공지합니다.">
          </div>
	
          <div class="form-group">
            <label>Contents</label> <textarea class="form-control" rows="10" name='n_contents' id="floatingInput" placeholder="공지내용입니다."></textarea>
          </div>	
	
          <button type="submit" class="btn btn-secondary"> Sumbmit Button</button>
          <!-- <button type="reset" class="btn btn-secondary"> Reset Button</button> -->
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

