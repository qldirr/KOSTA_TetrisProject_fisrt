<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- bbu-chat-room 적용 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="description" content="Kakao Talk Clone Chat Page">
<meta name="robotos" content="noindex, nofollow">
<link rel="stylesheet" href="/resources/css/chat-room.css">
<link rel="stylesheet" href="/resources/css/general.css">
<link rel="stylesheet" href="fontello/css/fontello.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap">
        
        
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script type="text/javascript">
	var roomId = $("#roomId").val();

	$(document).ready(function(){
		$("#file").on("change", function fileUpload(e){
			
		var regex = new RegExp("(.*?)\.(exe|sh)$");
		var maxSize = 41943040; //40MB

		function checkExtension(fileName, fileSize) {

			if (fileSize >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}

			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}
		
		var cloneObj = $(".uploadDiv").clone();
		
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			
			for (var i = 0; i < files.length; i++) {
				if (!checkExtension(files[i].name, files[i].size)) {
					return false;
				}
				formData.append("uploadFile", files[i]);
				formData.append("cr_id", roomId);
			}
		 
			$.ajax({
				url: '/messanger/uploadAjaxAction',
				processData: false,
				contentType: false,
				data: formData,
				type: 'post',
				dataType: 'json',
				success: function(result){
					alert("uploaded");
					
					showUploadedFile(result);
			 		$(".uploadDiv").html(cloneObj.html());
				}
			}); //$.ajax
			
		});
		
		var uploadResult = $("#messageArea");
		 
		function showUploadedFile(uploadResultArr){
			var str = "";
		    
			$(uploadResultArr).each(function(i, obj){
			if(!obj.cc_image){
				var fileCallPath =  encodeURIComponent( obj.cc_path + "/" + obj.cc_uuid + "_" + obj.cc_contents);
				str += "<li><a href='download?fileName=" + fileCallPath + "'>" 
		        		+ "<img src='/resources/img/attach.png'>" + obj.cc_contents + "</a></li>"
				}else{
				var thumbCallPath =  encodeURIComponent( obj.cc_path + "/s_" + obj.cc_uuid + "_" + obj.cc_contents);
				var fileCallPath =  encodeURIComponent( obj.cc_path + "/" + obj.cc_uuid + "_" + obj.cc_contents);
					str += "<li><a href='download?fileName=" + fileCallPath + "'>" 
						+ "<img src='display?fileName=" + thumbCallPath + "'></a></li>"
				}
		});
			uploadResult.append(str);
		}
		 
	});
</script>

</head>
<body>
	<input type="hidden" id="roomId" value="${cr_id}">
	<%-- <h1>${cr_id}</h1> --%>
	<div><h4><sec:authentication property="principal" var="principal"/></h4></div>
	
	<!-- <input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/> -->
	<div id="messageArea">
		<%-- <c:forEach items="${listChatContents }" var="listCC">
			<c:choose>
				<c:when test="${listCC.cc_file eq false }">
					<c:choose>
						<c:when test="${listCC.e_id eq principal.username }">
							<div class="me-chat">
                        	    <div class="me-chat-col">
                        	        <span class="balloon"><c:out value="${listCC.cc_contents }"/></span>
                        	    </div>
                            	<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        	</div>
						</c:when>
						<c:otherwise>
							<div class="friend-chat">
                            	<img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                            	<div class="friend-chat-col">
                                	<span class="profile-name"></span>
                                	<span class="balloon"><c:out value="${listCC.cc_contents }"/></span>
                            	</div>
                            	<time datetime="07:30:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        	</div>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${listCC.cc_image eq false }">
							<li><a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
		        				<img src="/resources/img/attach.png"><c:out value="${listCC.cc_contents }"/></a>  <c:out value="${listCC.cc_regdate }"/></li><br>
						</c:when>
						<c:otherwise>
							<li><a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
							<img src="display?fileName=${listCC.cc_path }\\s_${listCC.cc_uuid }_${listCC.cc_contents }"></a>  <c:out value="${listCC.cc_regdate }"/></li><br>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach> --%>
	</div>
	
	<!-- 파일 업로드 버튼 -->
	<!-- <div class='uploadDiv'>
		<input type='file' id="file" name='uploadFile' multiple>
	</div> -->
	
	
	<!-- bbu-chat-room 적용 -->
	<div id="chat-body">
            <!-- 설정바(최소화, 닫기 버튼 등) -->
            <!-- <div class="setting_bar">
                <i class="icon-window-minimize" alt="최소화버튼" title="최소화"></i>
                <i class="icon-window-maximize" alt="최대화버튼" title="최대화"></i>
                <i class="icon-cancel" alt="닫기버튼" title="닫기"></i>
            </div> -->
            <!-- 알림, 메뉴 기능 -->
            <div class="main-menu">
                <i class="icon-bell" title="알림"></i>
                <i class="icon-ellipsis" title="메뉴"></i>
            </div>
            <!-- 프로필 사진, 프로필명 -->
            <header>
                <img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                <div class="profile-col">
                    <span class="profile-name">${cr_id}</span>
                    <div class="sub-menu">
                        <i class="icon-box" title="채팅방 서랍"></i>
                        <i class="icon-search" title="검색"></i>
                    </div>
                </div>
            </header>
            <main>
                <!-- 고정된 공지사항 영역 -->
                <div class="notice-bar">
                    <i class="icon-bullhorn"></i>
                    <span>멘트를 고정해놓는 곳입니다.</span>
                    <i class="icon-down-open-big"></i>
                </div>
                <!-- 채팅 내용 시작 -->
                <div class="chat-content">
                    <!-- 메시지 시작 날짜 -->
                    <div class="date-line">
                        <time datetime="2021-03-29">2021년 3월 29일 월요일</time>
                    </div>
                    <!-- 채팅 내용 -->
                    <div class="main-chat">
                    	<c:forEach items="${listChatContents }" var="listCC">
                    		<c:choose>
                    			<c:when test="${listCC.e_id eq principal.username }">
                    				<c:choose>
                    					<c:when test="${listCC.cc_file eq false }">
                    						<div class="me-chat">
                        	    				<div class="me-chat-col">
                        	        				<span class="balloon"><c:out value="${listCC.cc_contents }"/></span>
                        	    				</div>
                            					<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        					</div>
                    					</c:when>
                    					<c:otherwise>
                    						<c:choose>
                    							<c:when test="${listCC.cc_image eq false }">
                    								<div class="me-chat">
                        	    						<div class="me-chat-col">
                        	        						<span class="balloon">
                        	        							<a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
		        												<img src="/resources/img/attach.png"><c:out value="${listCC.cc_contents }"/></a>
		        											</span>
                        	    						</div>
                            							<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        							</div>
                    							</c:when>
                    							<c:otherwise>
                    								<div class="me-chat">
                        	    						<div class="me-chat-col">
                        	        						<span class="balloon">
                        	        							<a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
																<img src="display?fileName=${listCC.cc_path }\\s_${listCC.cc_uuid }_${listCC.cc_contents }"></a>
		        											</span>
                        	    						</div>
                            							<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        							</div>
                    							</c:otherwise>
                    						</c:choose>
                    					</c:otherwise>
                    				</c:choose>
                    			</c:when>
                    			<c:otherwise>
                    				<c:choose>
                    					<c:when test="${listCC.cc_file eq false }">
                    						<div class="friend-chat">
                            					<img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                            					<div class="friend-chat-col">
                                					<span class="profile-name"></span>
                                					<span class="balloon"><c:out value="${listCC.cc_contents }"/></span>
                            					</div>
                            					<time datetime="07:30:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        					</div>
                    					</c:when>
                    					<c:otherwise>
                    						<c:choose>
                    							<c:when test="${listCC.cc_image eq false }">
                    								<div class="friend-chat">
                    								<img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                        	    						<div class="friend-chat-col">
                        	    							<span class="profile-name"></span>
                        	        						<span class="balloon">
                        	        							<a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
		        												<img src="/resources/img/attach.png"><c:out value="${listCC.cc_contents }"/></a>
		        											</span>
                        	    						</div>
                            							<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        							</div>
                    							</c:when>
                    							<c:otherwise>
                    								<div class="friend-chat">
                    								<img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                        	    						<div class="friend-chat-col">
                        	    							<span class="profile-name"></span>
                        	        						<span class="balloon">
                        	        							<a href='<c:url value="download?fileName=${listCC.cc_path }\\${listCC.cc_uuid }_${listCC.cc_contents }" />'>
																<img src="display?fileName=${listCC.cc_path }\\s_${listCC.cc_uuid }_${listCC.cc_contents }"></a>
		        											</span>
                        	    						</div>
                            							<time datetime="07:32:00+09:00"><c:out value="${listCC.cc_regdate }"/></time>
                        							</div>
                    							</c:otherwise>
                    						</c:choose>
                    					</c:otherwise>
                    				</c:choose>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
                    
                    
                        <!-- <div class="friend-chat">
                            <img class="profile-img" src="/resources/pic/default.png" alt="쀼프로필사진">
                            <div class="friend-chat-col">
                                <span class="profile-name"></span>
                                <span class="balloon"></span>
                            </div>
                            <time datetime="07:30:00+09:00">오전 7:30</time>
                        </div>
                        <div class="me-chat">
                            <div class="me-chat-col">
                                <span class="balloon"></span>
                            </div>
                            <time datetime="07:32:00+09:00">오전 7:32</time>
                        </div> -->
                    </div>
                </div>
                <!-- 채팅 입력창 -->
                <div class="insert-content">
					<input type="text" id="message" />
					<input type="button" id="sendBtn" value="전송"/>
                    <!-- <form name="chatform" action="#" method="post">
                        <textarea name="chat-insert" required></textarea>
                        <input type="submit" class="chat-submit" value="전송">
                    </form> -->
                    <!-- 채팅 입력 관련 기능(파일 첨부, 캡쳐 등) -->
                    <div class="insert-menu">
                        <i class="icon-smile"></i>
                        <i class="icon-attach"></i>
                        <i class="icon-phone"></i>
                        <i class="icon-calendar-empty"></i>
                        <i class="icon-camera"></i>
                    </div>
                </div>
            </main>
        </div>
    
    <div class='uploadDiv'>
		<input type='file' id="file" name='uploadFile' multiple>
	</div>
	
	
	
</body>
<script type="text/javascript">

	$("#sendBtn").on('click', function() {
		sendMessage();
		$('#message').val('')
	});
	$('#message').on('keydown', function(){
		if(event.keyCode == '13'){
			sendMessage();
			$('#message').val('')
		}
	});

	var roomId = $("#roomId").val();
	var webSocket;
	webSocket = new SockJS("http://localhost:8081/chatting/" + roomId);
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
	
	function onOpen(){
		/* alert("접속"); */
	}

	// 메시지 전송
	function sendMessage() {
		var e_id = '${principal.username}';
		$.ajax({
			url: '/messanger/registerMsg',
			type: 'post',
			contentType: 'application/json',
			async: false,
			data: JSON.stringify({
				"cr_id" : roomId,
				"e_id" : e_id,
				"cc_contents" : $("#message").val()
			}),
			success : function(){
				/* alert("success"); */
			}
		});
		webSocket.send($("#message").val());
		
		var html = '<div class="me-chat">' + '<div class="me-chat-col">' + '<span class="balloon">'
        			+ $("#message").val() + '</span>' + '</div>'
        			+ '<time datetime="07:32:00+09:00">오전 7:32</time>' + '</div>';
		
		$(".main-chat").append(html);
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		
		var data = msg.data;
		
		var html = '<div class="friend-chat">' + '<img class="profile-img" src="/resource/pic/default.png" alt="쀼프로필사진">'
        			+ '<div class="friend-chat-col">' + '<span class="profile-name"></span>'
        			+ '<span class="balloon">' + data + '</span>' + '</div>'
        			+ '<time datetime="07:30:00+09:00">오전 7:30</time>' + '</div>';
    	
		$(".main-chat").append(html);
		
		new Notification(roomId, {body: data, icon:"/resources/img/TETRIS.jpg"});
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");
	}
		
</script>
</html>