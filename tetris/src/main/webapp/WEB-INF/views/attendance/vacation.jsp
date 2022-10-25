<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>연차조회페이지</title>
<script>
function printClock() {
    
    var clock = document.getElementById("clock");            // 출력할 장소 선택
    var currentDate = new Date();                                     // 현재시간
    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    var currentHours = addZeros(currentDate.getHours(),2); 
    var currentMinute = addZeros(currentDate.getMinutes() ,2);
    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
    
    clock.innerHTML = currentHours+":"+currentMinute+":"+currentSeconds ; //날짜를 출력해 줌
    
    //날짜 출력
    var date = document.getElementById("date");
    date.innerHTML = calendar + "(" + ")";
    
    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
}

function addZeros(num, digit) { // 자릿수 맞춰주기
	  var zero = '';
	  num = num.toString();
	  if (num.length < digit) {
	    for (i = 0; i < digit - num.length; i++) {
	      zero += '0';
	    }
	  }
	  return zero + num;
}

//출퇴근버튼 활성화
function startDate(){
	if(confirm('출근하시겠습니까?')){
		alert('출근하셨습니다');
	}
}
function endDate(){
	if(confirm('퇴근하시겠습니까?')){
		alert('퇴근하셨습니다');
	}
} 
function outDate(){
	if(confirm('외근하시겠습니까?')){
		alert('안녕히다녀오세요');
	}
}


</script>
</head>
<body onload="printClock()">
<!-- 헤더페이지 -->
<div></div>

<!-- 사이드 -->
<div></div>

<!-- 좌측사이드 = -->
<div>
	<div id="date"></div>
	<!-- 시계 -->
	<div style="border:1px solid #dedede; width:200px; height: 80px; line-height:80px; color:#666;font-size:40px; text-align:center;" id="clock"></div>
		<!-- 출근시간 -->
	<dl>
		<dt>출근시간</dt>
		<dd id=""></dd>
	</dl>
	<!-- 퇴근시간 -->
	<dl>
		<dt>퇴근시간</dt>
		<dd id=""></dd>
	</dl>
	<!-- 누적근무시간 -->
	<dl>
		<dt>누적근무시간</dt>
		<dd id=""></dd>
	</dl>
	
	<!-- 출퇴근버튼 -->
	<div>
		<button onclick="startDate()" data-per="">출근하기</button>
		<button onclick="endDate()">퇴근하기</button>
		<button onclick="outDate()">외근</button>
	</div>
	
	<!-- 좌측 navi -->
	<div>
		<ul>근태현황
			<li>근태입력</li>
			<li>일별 부서 근태기록조회</li>
			<li>월별 개인 근태기록조회</li>
		</ul>
		<div>휴가현황</div>
	</div>
	
</div>

<!-- 중앙페이지 -->
<div>
	<h3>근태현황</h3>
	<form action="/tetris/test" method="post">
		<input type="text" name="id">
		<input type="text" name="pw">
		<input type="submit" value="">
	</form>
</div>



</body>
</html>