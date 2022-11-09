<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인입니다.</title>

<link href="/resources/css/home.css" rel="stylesheet" type="text/css">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="https://kit.fontawesome.com/3c50ab6b24.js"></script>


<script type="text/javascript">
	//날씨 api - fontawesome 아이콘
	$(function() {

		var weatherIcon = {
			'01' : 'fas fa-sun',
			'02' : 'fas fa-cloud-sun',
			'03' : 'fas fa-cloud',
			'04' : 'fas fa-cloud-meatball',
			'09' : 'fas fa-cloud-sun-rain',
			'10' : 'fas fa-cloud-showers-heavy',
			'11' : 'fas fa-poo-storm',
			'13' : 'far fa-snowflake',
			'50' : 'fas fa-smog'
		};

		// 날씨 api - 서울
		var apiURI = "http://api.openweathermap.org/data/2.5/weather?q="
				+ 'seoul' + "&appid=" + "56bff2528df80541a31119dee50abe0b";

		$
				.ajax({
					url : apiURI,
					dataType : "json",
					type : "GET",
					async : "false",
					success : function(resp) {
						console.log("ddd");

						var $Icon = (resp.weather[0].icon).substr(0, 2);
						var $weather_description = resp.weather[0].main;
						var $Temp = Math.floor(resp.main.temp - 273.15) + 'º';
						var $humidity = '습도&nbsp;&nbsp;&nbsp;&nbsp;'
								+ resp.main.humidity + ' %';
						var $wind = '바람&nbsp;&nbsp;&nbsp;&nbsp;'
								+ resp.wind.speed + ' m/s';
						var $city = '서울';
						var $cloud = '구름&nbsp;&nbsp;&nbsp;&nbsp;'
								+ resp.clouds.all + "%";
						var $temp_min = '최저 온도&nbsp;&nbsp;&nbsp;&nbsp;'
								+ Math.floor(resp.main.temp_min - 273.15) + 'º';
						var $temp_max = '최고 온도&nbsp;&nbsp;&nbsp;&nbsp;'
								+ Math.floor(resp.main.temp_max - 273.15) + 'º';

						$('.weather_icon')
								.append(
										'<i class="' + weatherIcon[$Icon] +' fa-5x" style="height : 150px; width : 150px;"></i>');
						$('.weather_description').prepend($weather_description);
						$('.current_temp').prepend($Temp);
						$('.humidity').prepend($humidity);
						$('.wind').prepend($wind);
						$('.city').append($city);
						$('.cloud').append($cloud);
						$('.temp_min').append($temp_min);
						$('.temp_max').append($temp_max);
					}
				})

	})
</script>
</head>
<body>
	<!-- jsp 인클루드 사용-->
	<!-- 메인내용 container시작 -->
	<h1></h1>
	<div class="wrap">
		<jsp:include page="includes/header.jsp"></jsp:include>
		<div class="wrap-box">
			<div class="container">

				<!-- main-left 시작 -->
				<div class="main-left">
					<!-- 사원정보 -->
					<div class="myProfile Box">
						<span class="m-title">MyProfile </span> <a href=""> <img
							alt="사진" src="../resources/img/res/hi.png"></a>
						<div style="font-size: 18px;">고북이</div>
					</div>

					<!-- 근태관리 -->

					<div class="hr Box">
						<span class="m-title">근태관리</span>
						<div class="time">
							<!-- 시계모양 -->
							<div class="att-time">
								<div>
									출근 시간<span id="att-str"></span>
								</div>
								<div>
									퇴근 시간<span id="att-fin"></span>
								</div>
							</div>
							<div class="att-btn">
								<a href="#"><i class="fa-solid fa-circle-play"></i></a> <a
									href="#"><i class="fa-solid fa-circle-stop"></i></a> <a
									href="#"><i class="fa-solid fa-circle-pause"></i></a>
							</div>
						</div>
					</div>
					<!-- 채팅링크박스 -->
					<a id="chat-a" href="http://localhost:8081/messanger/main" onclick="window.open(this.href, 'Tetris Messanger', 'width=450, height=600, left=2000, top=500, location=no, status=no, scrollbars=yes'); return false;">
					<div class="chat Box">
						<div class="i-title" style="margin: 20px 0px 0px 0px;">
							<i id="chat-i" class="fa-sharp fa-solid fa-comments fa-lg">
								Messenger</i>
						</div>
					</div>
					</a>
				</div>


				<!-- main center 시작 -->
				<div class="main-center">
					<div class="project Box">
						<span class="m-title">프로젝트</span>
					</div>
					<div class="elecAuth Box">
						<span class="m-title">전자결재</span>
					</div>
				</div>
				<!-- main center 끝 -->

				<!-- main-right 시작 -->
				<div class="main-right">
					<div class="suggest Box">
						<span class="m-title">공지사항</span>
					</div>
					<div class="free Box">
						<div style="float: left; margin: 0px 10px 0px 60px;;">
							<div class="current_temp" style="font-size: 50pt"></div>
							<div class="weather_description" style="font-size: 20pt"></div>
							<div class="city" style="font-size: 13pt"></div>
						</div>
						<div style="float: right; margin: 0px 10px 30px -10px;">
							<div class="temp_min"></div>
							<div class="temp_max"></div>
							<div class="humidity"></div>
							<div class="wind"></div>
							<div class="cloud"></div>
						</div>
						<div style="float: left; height: 50px; width: 50px; margin: 10px 10px 30px 10px;">
							<div class="weather_icon"></div> 
						</div>
						<br>
					</div>

				</div>
				<!-- main-rignt 끝 -->

			</div>
		</div>
		<!-- container 끝 -->
	</div>

	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>

</html>