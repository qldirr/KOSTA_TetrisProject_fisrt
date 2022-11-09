<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- friend 적용 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="description" content="Kakao Talk Clone Friend List Page">
<meta name="keywords" content="KakaoTalk, Clone, Friend">
<meta name="robotos" content="noindex, nofollow">
<link rel="stylesheet" href="/resources/css/main-layout.css">
<link rel="stylesheet" href="/resources/css/friend.css">
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/fontello/css/fontello.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
        
        
<link rel="stylesheet" href="/resources/tree/css/jquery.treeview.css" />
<link rel="stylesheet" href="/resources/tree/css/screen.css" />

<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script src="/resources/tree/lib/jquery.treeview.js" type="text/javascript"></script>
<script src="/resources/tree/lib/jquery.cookie.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		/* $("#tree").treeview({
			collapsed: true,
			animated: "medium",
			control:"#sidetreecontrol",
			persist: "location"
		}); */
		
		$("#empname li").on('dblclick', function(){
			var empId = $(this).attr('class');
			/* alert(empid); */
			$.ajax({
				url: '/messanger/register',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({"e_id" : empId}),
				success : function(result) {
					/* alert(result); */
					location.href = "/messanger/chatting";
				}
			});
		})
	})
	
	function notify(){
		if(!("Notification" in window)){
			alert("데스크톱 알림을 지원하지 않는 브라우저입니다.");
		}
		Notification.requestPermission(function(result){
			if(result == 'denied'){
				Notification.requestPermission();
				alert("알림을 차단하셨습니다.\n브라우저의 사이트 설정에서 변경하실 수 있습니다.");
				return false;
			}
		});
	}
</script>
</head>
<body>
	<form action="/messanger/main/emplist" method='get'>
		<input type="submit" value="조직도">
	</form><br>
	<form action="/messanger/main/chatroomlist" method='get'>
		<input type="submit" value="채팅방">
	</form><br>
	<button onclick="notify()">Notify</button>
	
	<!-- 조직도(tree) -->
	<%-- <div id="sidetree">
		<div class="treeheader">&nbsp;</div>
		
		<div id="sidetreecontrol"><a href="?#">전체 닫기</a> | <a href="?#">전체 열기</a></div>
		<ul id="tree">
			<c:forEach items="${listDept }" var="dept">
				<li>
					<strong>${dept.d_name }</strong>
					<ul id="empname">
						<c:forEach items="${listEmp}" var="emp">
							<c:if test="${dept.d_num eq emp.d_num }">
								<li class="${emp.e_id }">${emp.e_name }</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div> --%>
	
	
	
	<div id="content">
            <!-- 설정바(최소화, 닫기 버튼 등) -->
            <!-- <div class="setting_bar">
                <i class="icon-window-minimize" alt="최소화버튼" title="최소화"></i>
                <i class="icon-window-maximize" alt="최대화버튼" title="최대화"></i>
                <i class="icon-cancel" alt="닫기버튼" title="닫기"></i>
            </div> -->
            <!-- 헤더: 제목, 친구 찾기 버튼, 친구 추가 버튼 -->
            <header>
                <h1>친구</h1>
                <!-- <span alt="친구추가버튼" title="친구 추가">&#xf234</span> -->
                <span alt="통합검색버튼" title="통합검색">&#xe801</span>
            </header>
            <!-- 친구창, 대화창, 설정창 등 이동 가능한 네비게이터 -->
            <nav>
                <div class="main-menu">
                    <a href="friend.html">
                        <i class="icon-adult" alt="친구메뉴" title="친구"></i>
                    </a>
                    <a href="chatting.html">
                        <i class="icon-chat" alt="채팅메뉴" title="채팅"></i>
                        <span class="alert-balloon" alt="알림수">3</span>
                    </a>
                    <a href="more_menu.html">
                        <i class="icon-ellipsis" alt="더보기버튼" title="더보기"></i>
                        <span class="alert-balloon" alt="알림수">N</span>
                    </a>
                </div>
                <div class="sub-menu">
                    <a href="temp.html" target="_blank">
                        <i class="icon-smile" alt="이모티콘샵바로가기" title="이모티콘샵"></i></a>
                    <i class="icon-bell" alt="알림버튼" title="알림"></i>
                    <i class="icon-cog" alt="설정버튼" title="설정"></i>
                </div>
            </nav>
            <!-- 메인: 친구창 메인 내용 -->
            <main>
                <!-- 나의 프로필 -->
                <div>
                    <ul>
                        <li>
                            <img src="/resources/pic/me.png" alt="나의프로필사진">
                            <div class="profile">
                                <p>김간장</p>
                                <p>상태메시지 영역</p>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- 즐겨찾기 프로필 모음-->
                <div>
                    <div class="profile-title">
                        <h2>즐겨찾기</h2>
                    </div>
                    <ul>
                        <li>
                            <img src="/resources/pic/friend1.png" alt="친구1프로필사진">
                            <div class="profile">
                                <p>친구1</p>
                                <p></p>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- 친구 프로필 모음 -->
                <div>
                	<c:forEach items="${listDept }" var="dept">
                		<div class="profile-title">
                        	<h2>${dept.d_name }</h2>
                        	<p>3</p>
                    	</div>
                    	<ul id="empname">
                    		<c:forEach items="${listEmp}" var="emp">
                    			<c:if test="${dept.d_num eq emp.d_num }">
                        			<li class="${emp.e_id }">
                            			<img src="/resources/pic/default.png" alt="친구3프로필사진">
                            			<div class="profile">
											<p>${emp.e_name }</p>
                                			<p>Tetris 화이팅</p>
                            			</div>
                        			</li>
                        		</c:if>
                        	</c:forEach>
                    	</ul>
					</c:forEach>
					
                    <!-- <div class="profile-title">
                        <h2>친구</h2>
                        <p>3</p>
                    </div>
                    <ul>
                        <li>
                            <img src="/resources/pic/default.png" alt="친구3프로필사진">
                            <div class="profile">
                                <p>친구3</p>
                                <p>준비한 사진이 모두 떨어졌다</p>
                            </div>
                        </li>
                    </ul> -->
                </div>
            </main>
            <!-- aside: 광고 -->
            <!-- <aside>
                <img src="/resources/pic/ad.png" alt="광고이미지">
            </aside> -->
        </div>
	
</body>
</html>