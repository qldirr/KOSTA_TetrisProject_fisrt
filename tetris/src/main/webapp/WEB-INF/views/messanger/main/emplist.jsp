<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/tree/css/jquery.treeview.css" />
<link rel="stylesheet" href="/resources/tree/css/screen.css" />

<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script src="/resources/tree/lib/jquery.treeview.js" type="text/javascript"></script>
<script src="/resources/tree/lib/jquery.cookie.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#tree").treeview({
			collapsed: true,
			animated: "medium",
			control:"#sidetreecontrol",
			persist: "location"
		});
		
		$("#empname li").on('dblclick', function(){
			var empid = $(this).attr('class');
			/* alert(empid); */
			$.ajax({
				url: '/messanger/register',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({"e_id" : empid}),
				success : function() {
					window.location.href="/messanger/chatting";
				}
			});
		})
	})
</script>
</head>
<body>
	<form action="/messanger/main/emplist" method='get'>
		<input type="submit" value="조직도">
	</form><br>
	<form action="/messanger/main/chatroomlist" method='get'>
		<input type="submit" value="채팅방">
	</form><br>

	<div id="sidetree">
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
	</div>
	
</body>
</html>