<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script type="text/javascript">
	var roomId = $("#roomId").val();
	
	/* function fileDragDrop(){
		var dropZone = $("#messageArea");
		
		dropZone.on('dragenter', function(e){
			e.stopPropagation();
			e.preventDefault();
		});
		dropZone.on('dragleave', function(e){
			e.stopPropagation();
			e.preventDefault();
		});
		dropZone.on('dragover', function(e){
			e.stopPropagation();
			e.preventDefault();
		});
		dropZone.on('drop', function(e){
			e.preventDefault();
			
			var files = e.originalEvent.dataTransfer.files;
			if(files != null){
				if(files.length < 1){
	                alert("폴더 업로드 불가");
	                return;
	            }
				fileUpload(files)
	        }else{
	            alert("ERROR");
	        }
		});
	} */

	$(document).ready(function(){
		//$("#uploadBtn").on("click", function(e){
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
		
		//$("#file").on("change", function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
		
			//console.log(files);
		 
			/* for(var i=0;i<files.length;i++){
				formData.append("uploadFile", files[i]);
			} */
			
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
			
		});//end uploadBtn click
		
		
		
		
		
		
		
		var uploadResult = $("#messageArea");
		
		/* function showUploadedFile(uploadResultArr) {
		var str = "";
		$(uploadResultArr).each(function(i, obj) {
			str += "<li>" + obj.fileName + "</li>";
		});
		 
		uploadResult.append(str);
		} */
		 
		function showUploadedFile(uploadResultArr){
			var str = "";
		    
			$(uploadResultArr).each(function(i, obj){
			if(!obj.cf_image){
				/* var fileCallPath =  encodeURIComponent( obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName); */
				var fileCallPath =  encodeURIComponent( obj.cc_path + "/" + obj.cc_uuid + "_" + obj.cc_contents);
				str += "<li><a href='download?fileName=" + fileCallPath + "'>" 
		        		+ "<img src='/resources/img/attach.png'>" + obj.cc_contents + "</a></li>"
				}else{
				/* var fileCallPath =  encodeURIComponent( obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName); */
				var fileCallPath =  encodeURIComponent( obj.cc_path + "/s_" + obj.cc_uuid + "_" + obj.cc_contents);
					/* str += "<li><img src='display?fileName=" + fileCallPath + "'><li>"; */
					str += "<li><a href='download?fileName=" + fileCallPath + "'>" 
						+ "<img src='display?fileName=" + fileCallPath + "'></a></li>"
				}
		});
		    
			uploadResult.append(str);
		}
		 
		 
		 
	});//end document read
</script>

</head>
<body>
	<input type="hidden" id="roomId" value="${cr_id}">
	<h1>${cr_id}</h1>
	<div><h4><sec:authentication property="principal" var="principal"/></h4></div>
	
	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="submit"/>
	<div id="messageArea"></div>
	
	<c:forEach items="${listChatContents }" var="listCC">
		<c:choose>
			<c:when test="${listCC.cc_file eq false }">
				<c:out value="${listCC.e_id }"/>: <c:out value="${listCC.cc_contents }"/><br>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${listCC.cc_image eq false }">
						<li><a href='download?fileName="${listCC.cc_path }"/"${listCC.cc_uuid }"_"${listCC.cc_contents }"'>
		        			<img src='/resources/img/attach.png'>"${listCC.cc_contents }"</a></li><br>
					</c:when>
					<c:otherwise>
						<li><a href='download?fileName="${listCC.cc_path }"/"${listCC.cc_uuid }"_"${listCC.cc_contents }"'>
						<img src='display?fileName="${listCC.cc_path }"/s_"${listCC.cc_uuid }"_"${listCC.cc_contents }"'></a></li><br>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	
	
	<%-- <c:forEach var="listCM" items="${listChatMsg }" varStatus="status">
		<c:choose>
			<c:when test="${listCM.cm_contents eq listChatFile[status.index].cf_name }">
				<c:choose>
					<c:when test="${listChatFile[status.index].cf_image eq true }">
						<li><a href='download?fileName=${listChatFile[status.index].cf_path }/${listChatFile[status.index].cf_uuid }_${listChatFile[status.index].cf_name }'>
						<img src='display?fileName=${listChatFile[status.index].cf_path }/${listChatFile[status.index].cf_uuid }_${listChatFile[status.index].cf_name }'></a></li>"
					</c:when>
					<c:otherwise>
						<li><a href='download?fileName=${listChatFile[status.index].cf_path }/${listChatFile[status.index].cf_uuid }_${listChatFile[status.index].cf_name }'>
		        		<img src='/resources/img/attach.png'>${listChatFile[status.index].cf_name }</a></li>
					</c:otherwise>
				</c:choose>
					<c:out value="${listChatFile[status.index].e_id }"/>: <c:out value="${listChatFile[status.index].cf_path }"/><br>
			</c:when>
			
			<c:otherwise>
				<c:out value="${listCM.e_id }"/>: <c:out value="${listCM.cm_contents }"/><br>
			</c:otherwise>
		</c:choose>
	</c:forEach> --%>
	
	
	
	
	
	
	<!-- 파일 업로드 버튼 -->
	<div class='uploadDiv'>
		<input type='file' id="file" name='uploadFile' multiple>
	</div>

	<div class='uploadResult'>
		<ul>

		</ul>
	</div>


	<!-- <button id='uploadBtn'>Upload</button> -->
	
	<%-- <c:forEach items="${listChatMsg }" var="list">
		<c:out value="${list.cm_contents}" /><br>
	</c:forEach> --%>
	<!-- <form action="/messanger/chatting/{roomId}/fileupload" method='post' enctype='multipart/form-data'>
		<input type="file" name="uploadFile" multiple />
		<button>Submit</button>
	</form><br> -->
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
	/* webSocket = new WebSocket("ws://localhost:8081/chatting/" + roomId); */
	webSocket = new SockJS("http://localhost:8081/chatting/" + roomId);
	webSocket.onopen = onOpen;
	webSocket.onmessage = onMessage;
	webSocket.onclose = onClose;
	
	function onOpen(){
		/* alert("웹소켓 접속"); */
		/* html = '<c:forEach items="${listChatMsg }" var="listCM">';
		html += '<c:out value="${listCM.e_id}" />: ';
		html += '<c:out value="${listCM.cm_contents}" /><br>';
		html += '</c:forEach>';
		$("#messageArea").append(html); */
	}
	
	// 메시지 전송
	function sendMessage() {
		/* var data = {
				"cr_id" : roomId,
				"e_id" : "e_id"<sec:authentication property="principal.username"/>,
				"cm_contents" : $("#message").val()
			}
			var jsonData = JSON.stringify(data);
			webSocket.send(jsonData); */
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
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		/* var receive = msg.data.split(",");
		var data = {
			"cr_id" : receive[0],
			"e_id" : receive[1],
			"cm_contents" : receive[2]
		}; */
		
		var data = msg.data;
		$("#messageArea").append(data/* .cm_contents */ + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");
	}
</script>
</html>