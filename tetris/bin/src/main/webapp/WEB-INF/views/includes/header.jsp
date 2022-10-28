<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

	<!-- navbar -->
	<nav class="navbar navbar-expand-md navbar-light">
		<button class="navbar-toggler ml-auto mb-2 bg-light" type="button"
			data-toggle="collapse" data-target="#sidebar">
			<span class="navar-toggle-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="siderbar">
			<div class="container-fluid">
				<div class="row">

					<!-- sidebar -->
					<div class="col-xl-2 col-lg-3 sidebar fixed-top">
						<a href="#" class="navbar-link text-navy p-3 mb-5 sidebar-link">
							<i class="bi bi-list text-navy fa-lg  mr-3"></i>
						</a>
						<div class="pb-3">
							<a href="#"
								class="navbar-brand text-white text-center d-block mx-auto mb-4 bottom-border">
								<img src="/resources/img/TETRIS.jpg">
							</a>
						</div>
						<ul class="navbar-nav flex-column mt-4">
							<!-- 근태관리 -->
							<li class="nav item"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-clock text-navy fa-lg  mr-3"></i>근태관리
							</a></li>
							<!-- 일정관리 -->
							<li class="nav item"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-table text-navy fa-lg  mr-3"></i>일정관리
							</a></li>
							<!-- 프로젝트 -->
							<li class="nav item"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-clipboard-data text-navy fa-lg  mr-3"></i>프로젝트
							</a></li>
							<!-- 전자결재 -->
							<li class="nav item"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-file-text text-navy fa-lg  mr-3"></i>전자결재
							</a></li>
							<!-- 예약 -->
							<li class="nav item"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-tags text-navy fa-lg  mr-3"></i>예약
							</a></li>
							<!--게시판 -->
							<li class="nav item bottom-border"><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-easel text-navy fa-lg  mr-3"></i>게시판
							</a></li>
							<!--조직도 -->
							<li class="nav item "><a href="#"
								class="nav-link text-navy p-3 mb-2 sidebar-link"> <i
									class="bi bi-diagram-3-fill text-navy fa-lg  mr-3"></i>조직도
							</a></li>
							
							

						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- end of sidebar -->

		<!-- top navbar -->
		<div class="col-xl-10 col-lg-9 ml-auto bg-white fixed-top py-2">
			<div class="row align-items-center">
				<div class="col-md-4"></div>
				<div class="col-md-5"></div>
				<div class="col-md-3">
					<ul class="navbar-nav">
						<li class="nav-item icon-parent"><a href="#"
							class="nav-link icon-bullet"><i class="bi bi-bell-fill text-muted fa-lg"></i></a>
						<li class="nav-item icon-parent"><a href="#"
							class="nav-link icon-bullet"><i class=""></i></a>
						<li class="nav-item "><a href="#" class=""><i class=""></i></a>
					</ul>

				</div>

			</div>
		</div>
		<!-- end of top navbar -->
	</nav>

	<!-- end of nav -->








	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/resources/js/index.js"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
</body>
</html>