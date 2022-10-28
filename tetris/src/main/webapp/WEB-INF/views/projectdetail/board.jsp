<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>

<script type="text/javascript">


	var pb_num = '';
	var replyService = (function() {
		
		function add(reply, callback, error){
			$.ajax({
				url : '/projectdetail/registReply',
				type : 'post',
				data : JSON.stringify(reply),
				dataType : 'json',
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {
				
				$("#pr_contents"+ pb_num).val('');
				$("#reply" + pb_num).load(location.href + " #reply" + pb_num);
				
			});
		}

		return {
			add : add
		};
	})();
	
	
	$(document).ready(function(){
		(function(){
			
			
			var pj_num = '<c:out value="${pj_num}"/>';
			
			alert(pj_num);
			$.getJSON("/projectdetail/getAttachList", {pj_num: pj_num}, function(arr){
			//현재 프로젝트 번호에 해당하는 첨부파일 목록 불러오기
			
			var str = "";
			
			$(arr).each(function(i, attach){
				
				str += "<li data-path='"+attach.pf_path+"' data-uuid='" +attach.pf_uuid+"' data-filename='" +attach.pf_name+"'><div>";
				str += "<img src='/resources/img/attach.png'>";
				str += "<span>" + attach.pf_name + "</span><br>";
				str += "</div>";
				str += "</li>";
				
				$("#uploadResult" + attach.pb_num + " ul").html(str);
			
				});
			});
		})();
	});
	

	$(function() {

		$('#backBtn').on('click', function() {
			self.location = "/project/projectmain";
		});
		
		$('#regForm').on('click', function(){
			self.location = "/projectdetail/register";
		});
		
		$('#showCal').on('click', function(){
			self.location = "/projectdetail/calendar";
		})

		$('input[name=replyRegBtn]').on('click', function() {

			pb_num = $(this).closest('div').attr('id');
			var reply = {
					"pr_writer" : 'gdong123',
					"pr_contents" : $('#pr_contents' + pb_num).val(),
					"pb_num" : pb_num
			};

			console.log(replyService.add(reply, function(result) {
				console.log("댓글등록성공");
			}));

		});
		
		$(document).on("click", 'input[name=replyDelBtn]', function() {
			
			var pr_num = $(this).attr('id');
			self.location = "/projectdetail/deleteReply" + pr_num;
		});
		
		
		$(".uploadResult").on("click", "li", function(e){
			var liObj = $(this);
			console.log($(this));
			
			var path = encodeURIComponent(liObj.data("path")+"/"+liObj.data("uuid")+"_"+liObj.data("filename"));
			console.log(path);
			
			self.location="/projectdetail/download?fileName=" + path
		})

	});
</script>

</head>
<body>
	프로젝트 참여자
	<br> ${list}

	<input type="button" id="backBtn" value="이 프로젝트 나가기">
	<input type="button" id="showCal" value="캘린더 보기">
	<input type="hidden" id="pj_num" name="pj_num" value="${pj_num}">
	<h1>글목록</h1>
	<h3>글쓰기</h3>
	
	<textarea id="regForm" name="pb_contents" rows="5" cols="75" readonly="readonly"></textarea>



	<div>
		<div>
			<c:forEach items="${boardlist}" var="boardlist">
			<hr>
				<input type="hidden" id="pb_num${boardlist.pb_num}" name="pb_num" value="${boardlist.pb_num}">
					작성자: ${boardlist.pb_writer}<br>
						${boardlist.pb_contents }<br>
				<div id='uploadResult${boardlist.pb_num}' class='uploadResult'>
					<ul>
					</ul>
				</div>
				<c:if test="${boardlist.pb_writer eq 'gdong123'}">
					<input type="button" value="글수정">
					<input type="button" value="글삭제"><br><br>
				</c:if>
		</div>


		<div id="${boardlist.pb_num}">
			<div id="reply${boardlist.pb_num}">
			<ul>
			<c:forEach items="${replies}" var="replies">
				<c:if test="${boardlist.pb_num eq replies.pb_num }">
					<li>${replies.pr_writer} : ${replies.pr_contents}
					<c:if test="${replies.pr_writer eq 'gdong123'}">
							<input type="button" id="${replies.pr_num}" name="replyDelBtn" value="×">
					</c:if>
					</li>
				</c:if>
			</c:forEach>
			</ul> 
		</div>

			<br> gdong123:
			<textarea id="pr_contents${boardlist.pb_num}" name="pr_contents"
				rows="2" cols="55"></textarea>
			<input type="button" name="replyRegBtn" value="댓글 등록">
		</div>
	</div>
	<br>


	</c:forEach>

<hr>

</body>
</html>


