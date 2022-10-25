<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="includes/header.jsp"%>


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

<title>TETRIS Groupware</title>
</head>

<body>
   <div style="width: 100%; height: 1000; background: red;">
      <!-- content -->
      <div class="container-fluid">
         <div class="col-xl-10 col-lg-9 ">
            <div class="row">

               <div align="center">
                  회의실 번호:<input> 회의실 명:<input> 총 인원수:<input>
               </div>
               </div>
            </div>
         </div>
     </div>


      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="includes/footer.jsp"%>
</body>

</html>
