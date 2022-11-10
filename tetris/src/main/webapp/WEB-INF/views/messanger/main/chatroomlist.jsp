<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- chatting 적용 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="description" content="Kakao Talk Clone Chat Main Page">
<meta name="keywords" content="KakaoTalk, Clone, Chat">
<meta name="robotos" content="noindex, nofollow">
<link rel="stylesheet" href="/resources/css/main-layout.css">
<link rel="stylesheet" href="/resources/css/chatting.css">
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="/resources/fontello/css/fontello.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">


<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#listChatRoom li").on('dblclick', function(){
			var cr_id = $(this).attr('class');
			$.ajax({
				url: '/messanger/chatting',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({"cr_id" : cr_id}),
				success : function() {
					/* window.location.href = "/messanger/chatting"; */
					window.open('http://localhost:8081/messanger/chatting', 'Tetris Chatting', 'width=450, height=600, left=2000, top=500, location=no, status=no, scrollbars=yes');
				}
			});
		})
	})
	
	function notify(){if(!("Notification" in window)){
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
	<%-- <div>
		<ul id="listChatRoom">
			<c:forEach items="${listChatRoom }" var="list">
				<li class="${list.cr_id }">${list.cr_id }</li>
			</c:forEach>
		</ul>
	</div> --%>
	
	
	
	
	
	<div id="content">
			<!-- 액션폼 -->
				<form action="/messanger/main/emplist" name="emplist" method='get'>
					<!-- <input type="submit" value="조직도"> -->
				</form><br>
				<form action="/messanger/main/chatroomlist" name="chatroomlist" method='get'>
					<!-- <input type="submit" value="채팅방"> -->
				</form><br>
            <!-- 설정바(최소화, 닫기 버튼 등) -->
            <!-- <div class="setting_bar">
                <i class="icon-window-minimize" alt="최소화버튼" title="최소화"></i>
                <i class="icon-window-maximize" alt="최대화버튼" title="최대화"></i>
                <i class="icon-cancel" alt="닫기버튼" title="닫기"></i>
            </div> -->
            <!-- 헤더: 제목, 친구 찾기 버튼, 친구 추가 버튼 -->
            <header>
                <h1>채팅</h1>
                <i class="icon-down-dir"></i>
                <span alt="새로운채팅버튼" title="새로운 채팅">&#xe80a</span>
                <span alt="통합검색버튼" title="통합검색">&#xe801</span>
            </header>
            <!-- 친구창, 대화창, 설정창 등 이동 가능한 네비게이터 -->
            <nav>
                <div class="main-menu">
                    <a href="javascript:document.emplist.submit();">
                        <i class="icon-adult" alt="친구메뉴" title="친구"></i>
                    </a>
                    <a href="javascript:document.chatroomlist.submit();">
                        <i class="icon-chat" alt="채팅메뉴" title="채팅"></i>
                        <span class="alert-balloon" alt="알림수">3</span>
                    </a>
                    <a href="#" onclick="notify()">
                    	<i class="icon-bell" alt="알림버튼" title="알림"></i>
                    </a>
                    <!-- <a href="more_menu.html">
                        <i class="icon-ellipsis" alt="더보기버튼" title="더보기"></i>
                        <span class="alert-balloon" alt="알림수">N</span>
                    </a> -->
                </div>
                <div class="sub-menu">
                    <!-- <a href="temp.html" target="_blank">
                        <i class="icon-smile" alt="이모티콘샵바로가기" title="이모티콘샵"></i></a>
                    <a href="#" onclick="notify()"><i class="icon-bell" alt="알림버튼" title="알림"></i></a>
                    <i class="icon-cog" alt="설정버튼" title="설정"></i> -->
                </div>
            </nav>
            <!-- 메인: 채팅 리스트 화면 -->
            <main>
            	<%-- <ul id="listChatRoom">
					<c:forEach items="${listChatRoom }" var="list">
						<li class="${list.cr_id }">${list.cr_id }</li>
					</c:forEach>
				</ul> --%>
            	
            	
            	
            	
                <ul id="listChatRoom">
                	<c:forEach items="${listChatRoom }" var="list">
                    	<li class="${list.cr_id }">
                        	<!-- <a href="bbu-chat-room.html" target="_blank"> -->
                            	<img src="/resources/pic/default.png" class="profile-img" alt="쀼프로필사진">
                            	<div class="talk">
                            	    <p class="friend-name">${list.cr_title }</p>
                                	<p class="chat-content">대리님! 회의 끝나시면 연락 부탁드립니다!</p>
                            	</div>
                            	<div class="chat-status">
                            	    <time datetime="10:15:00+09:00">오전 10:15</time>
                            	</div>
                        	<!-- </a> -->
                    	</li>
                    </c:forEach>
                </ul>
            </main>
            <!-- aside: 광고 -->
            <!-- <aside>
                <img src="/resources/pic/ad.png" alt="광고이미지">
            </aside> -->
        </div>
</body>
</html>