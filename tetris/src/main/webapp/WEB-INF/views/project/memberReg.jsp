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


	$(function() {
		
		var memberListId = [];
		var memberList = [];
		var tmp = $( "#pj_manager", opener.document ).val();
		
		$("#tree").treeview({
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});

		$('input:checkbox[name=dname]').on('click', function() {
			alert(tmp);
		});

		$("#memberRegBtn").on('click', function() {
			var checkedMember = $('input:checkbox[name=ename]:checked').length;
			$('input:checkbox[name=ename]:checked').each(function() {
				memberListId.push(this.value);
				memberList.push($(this).next('label').text());
			});

			for (var i = 0; i <= checkedMember; i++) {
				$('#member' + (i + 1)).text(memberList[i]);
			}
		});

		$("#cancelBtn").on('click', function() {

			$('input:checkbox[name=ename]:checked').each(function() {
				$(this).prop('checked', false);
				$('.members').empty();
			})
		});
		
		$("#memberInsertBtn").on('click', function(){
			$.ajax({
				url: '/project/memberReg',
				type: 'post',
				data: JSON.stringify({"pl_num": tmp, "pmembers" : memberListId}),
		        contentType: "application/json",
				success: function(){
					$("#pj_members", opener.document).val(memberList);
					window.close();
				}, error: function(er){
					alert("참여자 등록 실패");
				}
			});
		})

	})
</script>
</head>
<body>
	<table border=1px>
		<tr>
			<td>사원목록</td>
			<td rowspan="12"><input type="button" id="memberRegBtn"
				value="추가"></td>
			<td id="listTable">참여자</td>
		</tr>
		<tr>
			<td rowspan="11">
				<div id="sidetree">
					<div class="treeheader">&nbsp;</div>
					<div id="sidetreecontrol">
						<a href="?#">목록접기</a> | <a href="?#">목록펼치기</a>
					</div>
					<c:forEach items="${dept}" var="dept">
						<ul id="tree">
							<li><input type="checkbox" name="dname"
								value="${dept.d_name}"><strong>${dept.d_name}</strong>
								<ul>
									<c:forEach items="${memberList}" var="member">
										<c:if test="${member.d_num eq dept.d_num}">
											<li><input type="checkbox" name="ename"
												value="${member.e_id}"><label>[${member.e_position}]${member.e_name}</label></li>
										</c:if>
									</c:forEach>
								</ul></li>
					</c:forEach>
				</div>

			</td>
		<tr>
			<td class="members" id="member1"></td>
		</tr>
		<tr>
			<td class="members" id="member2"></td>
		</tr>
		<tr>
			<td class="members" id="member3"></td>
		</tr>
		<tr>
			<td class="members" id="member4"></td>
		</tr>
		<tr>
			<td class="members" id="member5"></td>
		</tr>
		<tr>
			<td class="members" id="member6"></td>
		</tr>
		<tr>
			<td class="members" id="member7"></td>
		</tr>
		<tr>
			<td class="members" id="member8"></td>
		</tr>
		<tr>
			<td class="members" id="member9"></td>
		</tr>
		<tr>
			<td class="members" id="member10"></td>
		</tr>
	</table>
	<input type="button" id="cancelBtn" value="초기화">
	<input type="button" id="memberInsertBtn" value="등록">
</body>
</html>