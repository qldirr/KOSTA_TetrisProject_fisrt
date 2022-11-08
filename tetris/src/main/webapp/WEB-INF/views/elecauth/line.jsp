<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listTable {
	width: 150px;
}

.members {
	height: 30px;
}

</style>
<link rel="stylesheet" href="/resources/css/jquery.treeview.css" />
<link rel="stylesheet" href="/resources/css/screen.css" />

<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="/resources/lib/jquery.treeview.js" type="text/javascript"></script>

<script type="text/javascript">


	var memberListId = [];
	var memberList = [];
	var tmp = "";

	/* 프로젝트 멤버 등록 페이지 버튼 이벤트 함수 */
	var button = (function(){
		
		function deptCheck(){
			$(this).nextAll().find('input[type=checkbox]').prop('checked', true);
		}
		
		function add(){
			
			/* 결재자 배열 비우기 */
			memberListId.splice(0);
			memberList.splice(0);
			
			var checkedMember = $('input:checkbox[name=ename]:checked').length;
			
			$('input:checkbox[name=ename]:checked').each(function() {
				memberListId.push(this.value);
				memberList.push($(this).next('label').text());
			});

			for (var i = 0; i <= checkedMember; i++) {
				$('#member' + (i + 1)).text(memberList[i]);
			}
			
		}
		
		function del(){
			
			/* 결재자 배열 비우기 */
			memberListId.splice(0);
			memberList.splice(0);
			
			$('input:checkbox').each(function() {
				$(this).prop('checked', false);
				$('.members').empty();
			})
			
		}
		
		function insertMember(){
			

			/* 추가된 사원의 아이디와 임시 결재라인 값을 전달 */
			$.ajax({
				url: '/elecauth/line',
				type: 'post',
				data: JSON.stringify({"l_num": tmp, "lines" : memberListId}),
		        contentType: "application/json",
				success: function(){
					
					$(".first", opener.document).val(memberList[0]);
					$(".second", opener.document).val(memberList[1]);
					$(".third", opener.document).val(memberList[2]);
					$(".fourth", opener.document).val(memberList[3]);
					
					window.close();
				}, error: function(er){
					alert("참여자 등록 실패");
				}
			}); /* end ajax */
			
		}
		
		
		return {
			deptCheck : deptCheck,
			add : add,
			del : del,
			insertMember : insertMember
		}
		
	})();


	$(function() {
		
		tmp = '${userId}';
		
		$("#tree").treeview({
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});

		$('input:checkbox[name=dname]').on('click', button.deptCheck);

		$("#memberRegBtn").on('click', button.add);

		$("#cancelBtn").on('click', button.del);
		
		$("#lineInsertBtn").on('click', button.insertMember);

	})
	
</script>
</head>
<body>
	<table border=1px>
		<tr>
			<td>사원목록</td>
			<td rowspan="12"><input type="button" id="memberRegBtn" value="＞"></td>
			<td>결재순번</td>
			<td id="listTable">결재자명</td>
		</tr>
		<tr>
			<td rowspan="11">
			
				<div id="sidetree">
					<div class="treeheader">&nbsp;</div>
					<div id="sidetreecontrol">
						<a href="?#">목록접기</a> | <a href="?#">목록펼치기</a>
					</div>
					<ul id="tree">
					<c:forEach items="${dept}" var="dept">
							<li>
							<input type="checkbox" name="dname" value="${dept.d_name}">
							<strong>${dept.d_name}</strong>
							<ul>
								<c:forEach items="${employees}" var="employees">
									<c:if test="${employees.d_num eq dept.d_num}">
										<li><input type="checkbox" name="ename"
												value="${employees.e_id}"><label>[${employees.e_position}]${employees.e_name}</label></li>
									</c:if>
								</c:forEach>
							</ul>
							</li>
					</c:forEach>
					</ul>
				</div>

			</td>
			</tr>
		<tr>
			<td>1</td>
			<td class="members" id="member1"></td>
		</tr>
		<tr>
			<td>2</td>
			<td class="members" id="member2"></td>
		</tr>
		<tr>
			<td>3</td>
			<td class="members" id="member3"></td>
		</tr>
		<tr>
			<td>4</td>
			<td class="members" id="member4"></td>
		</tr>
	</table>
	<input type="button" id="cancelBtn" value="초기화">
	<input type="button" id="lineInsertBtn" value="등록">
</body>
</html>