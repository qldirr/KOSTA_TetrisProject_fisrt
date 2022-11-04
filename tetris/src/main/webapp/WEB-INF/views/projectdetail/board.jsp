<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/resources/vender/bootstrap/css/bootstrap.min.css">
<style type="text/css">
li {
	list-style: none;
	cursor: pointer;
}

#board {
	border: 1px solid;
}
</style>
<script src="https://kit.fontawesome.com/7264476d39.js" crossorigin="anonymous"></script>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	var pb_num = '';
	/* 댓글 서비스를 제공하는 함수 */
	var replyService = (function() {

		/* 댓글 추가 */
		function add(reply, callback, error) {
			$.ajax({
				url : '/projectdetail/registerReply',
				type : 'post',
				data : JSON.stringify(reply),
				dataType : 'json',
				cache : false,
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {

				if (callback) {
					callback(data);
				}
				/* 댓글 추가 성공시 해당 글의 댓글 부분만 load */
				$("#pr_contents" + pb_num).val('');
				
				$("#" + pb_num).load(location.href + " #reply" + pb_num);

				/* id="reply${b.pb_num}" */

			}); /* end ajax */
		} /* end function add */

		/* 댓글 삭제 */
		function del(reply, callback, error) {
			$.ajax({
				url : '/projectdetail/removeReply',
				type : 'post',
				data : JSON.stringify(reply),
				dataType : 'json',
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {

				/* 댓글 삭제 성공시 해당 글의 댓글 부분만 load */
				$("#" + pb_num).load(location.href + " #reply" + pb_num);
			}) /* end ajax */
		} /* end function del */
		return {
			add : add,
			del : del
		};
	})();

	/* 첨부파일 서비스를 제공하는 함수 */
	var attachService = (function() {

		/* 첨부파일 정보 */
		function get(pj_num, callback, error) {

			$
					.ajax({
						url : '/projectdetail/getAttachList',
						type : 'get',
						data : {
							pj_num : pj_num
						},
						contentType : "application/json"
					})
					.done(
							function(arr, textStatus, xhr) {

								if (callback) {
									callback(arr);
								}

								var str = "";
								var boardNum = [];
								var attachInfo = [];
								var attachBoardNum = [];

								$
										.each(
												arr,
												function(i, attach) {

													var attachPb_num = Object
															.keys(attach);
													var attachData = Object
															.values(attach);

													boardNum.push(attachPb_num);
													var finalBoard = boardNum
															.pop();

													for ( var i in attachData) {

														if (finalBoard == attachData[i]["pb_num"]) {
															attachInfo
																	.push(attachData[i]);
															attachBoardNum
																	.push(finalBoard);
														}
													}
												})

								for (var i = 0; i < attachInfo.length; i++) {

									if (attachBoardNum[i] == attachInfo[i].pb_num) {

										str += "<li data-path='"+attachInfo[i]["pf_path"]+"' data-uuid='" +attachInfo[i]["pf_uuid"]+"' data-filename='" +attachInfo[i]["pf_name"]+"'><div>";
										str += "<img src='/resources/img/attachfile.png'>";
										str += "<span>"
												+ attachInfo[i]["pf_name"]
												+ "</span><br>";
										str += "</div>";
										str += "</li>";

										$(
												"#uploadResult"
														+ attachInfo[i].pb_num
														+ " ul").append(str);
										str = "";

									}
								}

							}); /* end ajax */

		}/* end function get */

		/* 첨부파일 다운로드 */
		function download(path) {

			self.location = "/projectdetail/download?fileName=" + path;

		}/* end function download */

		return {
			get : get,
			download : download
		};

	})();

	/* 페이지 이동 서비스를 제공하는 함수 */
	var moveTo = (function() {

		function main() {
			self.location = "/project/main";
		}

		function register() {
			self.location = "/projectdetail/register";
		}

		function calendar() {
			self.location = "/projectdetail/calendar";
		}

		function task() {
			self.location = "/projectdetail/taskboard";
		}

		return {
			main : main,
			register : register,
			calendar : calendar,
			task : task

		}

	})();

	$(document).ready(
			function() {

				var pj_num = '<c:out value="${pj_num}"/>';

				attachService.get(pj_num, function(result) {
					console.log(result);
				});

				$('#backBtn').on('click', moveTo.main);

				$('#regForm').on('click', moveTo.register);

				$('#showCal').on('click', moveTo.calendar);

				$('#showTaskBoard').on('click', moveTo.task);

				
				$(document).on('click', 'input[name=replyRegBtn]', function() {
					
					pb_num = $(this).closest('.replyContents').attr('id');

					var reply = {
						"pr_writer" : 'gdong123',
						"pr_contents" : $('#pr_contents' + pb_num).val(),
						"pb_num" : pb_num
					};
					replyService.add(reply, function(result) {
						console.log(result);
					})

				});

				$(document).on('click', 'input[name=replyDelBtn]', function() {
					var pr_num = $(this).attr('id');
					pb_num = $(this).closest('.replyContents').attr('id');

					var reply = {
						"pr_num" : pr_num,
						"pb_num" : pb_num
					};

					replyService.del(reply)

				});

				$('.uploadResult').on(
						'click',
						'li',
						function(e) {

							var liObj = $(this);
							var path = encodeURIComponent(liObj.data("path")
									+ "/" + liObj.data("uuid") + "_"
									+ liObj.data("filename"));
							attachService.download(path);

						})

			});
</script>

</head>
<body>
	<div id="projectMember">
		프로젝트 참여자<br>
		<c:forEach items="${member }" var="m">
		[${m.d_name }] ${m.e_position } -  ${m.e_name }<br>
		</c:forEach>
	</div>

	<div id="projectMenu">
		<input type="button" id="backBtn" value="이 프로젝트 나가기"> <input
			type="button" id="showCal" value="캘린더 보기"> <input
			type="button" id="showTaskBoard" value="업무보드 보기">
	</div>

	<input type="hidden" id="pj_num" name="pj_num" value="${pj_num}">
	<h1>글목록</h1>
	<input type="text" placeholder="검색 내용 입력">
	<input type="button" id="searchKey" value="검색">

	<div>
		<h3>글쓰기</h3>

		<textarea id="regForm" rows="5" cols="75" readonly="readonly"
			placeholder="글작성 폼이 열립니다."></textarea>

		<hr>

	</div>

	<div class="board">
		<div class="boardContents">
			<c:forEach items="${board}" var="b">
				<div class="media">
					<i id="usericon" class="fa-regular fa-circle-user fa-2x"></i>
					<div class="media-body">
						<h5 class="mt-0">&nbsp;&nbsp;${b.pb_writer}</h5>
						<p>&nbsp;&nbsp;${b.pb_contents }</p>
						<div id='uploadResult${b.pb_num}' class='uploadResult'>
							<ul>
							</ul>
						</div>


					</div>
				</div>

				<div id="${b.pb_num}" class="replyContents">
					<div id="reply${b.pb_num}" class="boardReplies">
						<ul class="replies">
							<c:forEach items="${replies}" var="r">
								<c:if test="${b.pb_num eq r.pb_num }">
									<li><i id="usericon" class="fa-regular fa-circle-user fa-2x"></i>${r.pr_writer}:
										${r.pr_contents} 
										<c:if test="${r.pr_writer eq 'gdong123'}">
											<input type="button" id="${r.pr_num}" name="replyDelBtn" value="×">
										</c:if> ${r.pr_moddate}</li>
								</c:if>
							</c:forEach>
						</ul>
						
							<textarea id="pr_contents${b.pb_num}" name="pr_contents" rows="2"
								cols="55" placeholder="댓글을 입력하세요."></textarea>
							<input type="button" id="replyReg${b.pb_num}" name="replyRegBtn" value="등록" style="background-color: #161E67; color: #FFF2CA; border-radius: 5px; border-style: none;"><br>
							<br>
						
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>