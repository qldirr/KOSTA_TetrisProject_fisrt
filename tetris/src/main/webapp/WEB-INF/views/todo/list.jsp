<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="../includes/header.jsp"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

<!-- my CSS -->
<link rel="stylesheet" href="/resources/css/mycss/reset.css">
<link rel="stylesheet" href="/resources/css/mycss/style.css">

<title>TETRIS Groupware</title>
</head>

<body>
	<div class="container-fluid ">
		<div class="row">
			<div class="col-xl-2 col-lg-3"></div>
			<div class="col-xl-10 col-lg-9">
				<div style="width: 100%; height: 1000;">
					<!-- content -->
					<div class="todo-wrapper">
						<div class="todo-title">Todo List</div>
						<div class="todo-box">

							<div class="todo-input-box">
								<button class="complete-all-btn">✔</button>
								<input type="text" class="todo-input"
									placeholder="해야 할 일을 입력해주세요.">
							</div>

							<ul class="todo-list">

							</ul>
							<div class="todo-bottom">
								<div class="left-items">0 items left</div>
								<div class="button-group">
									<button class="show-all-btn selected" data-type="all">All</button>
									<button class="show-active-btn" data-type="active">Active</button>
									<button class="show-completed-btn" data-type="completed">Completed</button>
								</div>
								<button class="clear-completed-btn">Clear Completed</button>
							</div>
						</div>
						<p class='info'>더블클릭 시 수정 가능</p>

					</div>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="../includes/footer.jsp"%>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/js/index.js"></script>

	<script src="/resources/js/myjs/todo.js"></script>


</body>

</html>


