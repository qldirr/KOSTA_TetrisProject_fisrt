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
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
					<script src="/resources/js/index.js"></script>



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

<h1>Menu</h1>


	<table class="table table-striped table-bordered table-hover">	


        <!--  <form role="form" method="post">-->         
          
         <!--  <div class="form-group">
            <label>Num</label> <input class="form-control" name='t_num'
            value='<c:out value="${tmenu.t_num}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>title</label> <input class="form-control" name='t_title'
            value='<c:out value="${tmenu.t_title}"/>' readonly="readonly">
          </div>--> 

          <div class="form-group">
            <label></label> <input class="form-control" name='t_contents'
            value='<c:out value="${tmenu.t_contents}"/>' readonly="readonly">
          </div>


    <style>
        #button{
            margin-left:5px;
        }
    </style>
    


		<c:if test="${tmenu.t_num eq 1}">
		<p><img src="/resources/img/menu1.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 2}">
		<p><img src="/resources/img/menu2.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 3}">
		<p><img src="/resources/img/menu3.jpg" width="1200px"></p> 
		</c:if>	  
		<c:if test="${tmenu.t_num eq 4}">
		<p><img src="/resources/img/menu4.jpg" width="1200px"></p> 
		</c:if>	  
		<c:if test="${tmenu.t_num eq 5}">
		<p><img src="/resources/img/menu5.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 6}">
		<p><img src="/resources/img/menu6.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 7}">
		<p><img src="/resources/img/menu7.jpg" width="1200px"></p> 
		</c:if>	  
		<c:if test="${tmenu.t_num eq 8}">
		<p><img src="/resources/img/menu8.jpg" width="1200px"></p> 
		</c:if>	 	  
		<c:if test="${tmenu.t_num eq 9}">
		<p><img src="/resources/img/menu9.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 10}">
		<p><img src="/resources/img/menu10.jpg" width="1200px"></p> 
		</c:if>
		<c:if test="${tmenu.t_num eq 11}">
		<p><img src="/resources/img/menu11.jpg" width="1200px"></p> 
		</c:if>	  
		<c:if test="${tmenu.t_num eq 12}">
		<p><img src="/resources/img/menu12.jpg" width="1200px"></p> 
		</c:if>	 	  
	  








	


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