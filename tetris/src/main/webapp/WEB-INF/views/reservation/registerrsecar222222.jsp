<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/vender/res/bootstrap-datepicker3.css"
	rel="stylesheet">
<link href="/resources/vender/res/jquery.timepicker.min.css"
	rel="stylesheet">

<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/vender/res/bootstrap-datepicker.js"></script>
<script src="/resources/vender/res/jquery.timepicker.min.js"></script>

<script type="text/javascript">	
$(document).ready(
		function() {		
			$('#datepickerstartday').datepicker({
			    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
			    startDate: 'd',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
			    endDate: '+30d',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
			    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
			    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
			    clearBtn : false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
			    //datesDisabled : ['2019-06-24','2019-06-26'],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
			    daysOfWeekDisabled : [0,6],	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
			    //daysOfWeekHighlighted : [3], //강조 되어야 하는 요일 설정
			    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
			    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
			    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
			    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
			    templates : {
			        leftArrow: '&laquo;',
			        rightArrow: '&raquo;'
			    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
			    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
			    title: "예약시작날짜",	//캘린더 상단에 보여주는 타이틀
			    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
			    toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
			    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
			    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
				
				
			});
			
	
			$('#datepickerendday').datepicker({
				 format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
				    startDate: 'd',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
				    endDate: '+30d',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
				    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
				    calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
				    clearBtn : false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
				    //datesDisabled : ['2019-06-24','2019-06-26'],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
				    daysOfWeekDisabled : [0,6],	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
				    //daysOfWeekHighlighted : [3], //강조 되어야 하는 요일 설정
				    disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
				    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
				    multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
				    multidateSeparator :",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
				    templates : {
				        leftArrow: '&laquo;',
				        rightArrow: '&raquo;'
				    }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
				    showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
				    title: "예약종료날짜",	//캘린더 상단에 보여주는 타이틀
				    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
				    toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
				    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
				    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
					
				
				
			});
			
			$('#click-btn').on('click',function(){
				var data =$('#dataRangePicker').val();
				alert(date);
			});
			
			$('input.timepicker').timepicker({
			
				
	            timeFormat: 'HH:mm',
	            interval: 60,
	            minTime: '60',
	            maxTime: '9:00pm',
	            startTime: '09:00',
	            dynamic: false,
	            dropdown: true,
	            scrollbar: true,

	        });
			
	
			$("#rescar").click(function() {
		chkrescar();
		
		
	})
			
	});

function chkrescar(){
	
	 // 입력받은 값들 유효성 검사: 시작
    var startday = $("input[name=cb_startday]").val() + " " + $("input[name=cb_starttime]").val() + ":00";
    var endday = "";
    
    // 종일 체크 시 시작 날짜를 기준으로 변경
    if ($("input#allday:checked").val()) {
       startday = $("input[name=cb_startday]").val() + " 00:00:00";
       endday = $("input[name=cb_startday]").val() + " 23:59:59";
    }else{
       endday = $("input[name=cb_endday]").val() + " " + $("input[name=cb_endtime]").val() + ":00";
    }
    
    // true: 통과   false: 불통
    if (!(startday < endday && startday != endday)) {
       alert("올바른 일시를 선택해주세요.");
       return false;
    }
    
    var mode = $("#mode").val();
	if("write" == mode){	
		alert('예약신청이 완료되었습니다. ')
		$('#registerrsecar').attr("action", "/reservation/registerrsecar")
		$("#registerrsecar").submit()
	
	}

}
	
</script>

</head>
<body>
	<h1>내 차량예약</h1>

	<form action="/reservation/registerrsecar" method="post"
		id="registerrsecar">
		<input type="hidden" name="mode" id="mode" value="write" />

		<table>

			<tbody>
			<tr>
				<th scope="col">예약자</th>
				 <td class="left"><input type="text" name="e_id" id="e_id">
				</td>
				<th scope="col">예약 차량</th>
					<td class="left"><input type="text" name="ca_num" id="ca_num" value="${registerrsecar.ca_num}" readonly=readonly>
					</td>
				</tr>
				<tr>
					<th scope="col">예약시작 일자</th>
					<td class="left"><input id="datepickerstartday" type="text" name="cb_startday">
					<th scope="col">예약시작 시간</th>
					<td class="left">
					<input type="text" name="cb_starttime" class="timepicker" id="cb_starttime" readonly=readonly>
					</td>
				</tr>
				<tr>
					<th scope="col">예약종료 일자</th>
					<td class="left"><input id="datepickerendday" type="text" name="cb_endday">
					<th scope="col">예약종료 시간</th>
					<td class="left"><input type="text" name="cb_endtime" class="timepicker" id="cb_endtime">
					</td>
				</tr>

			</tbody>
		</table>
	
	</form>
  <input type="button" class="write_btn" value="예약신청" id = "rescar" >

</body>
</html>