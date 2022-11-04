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

<link rel="stylesheet" href="/resources/css/mycss/jquery.treeview.css" />
<link rel="stylesheet" href="/resources/css/mycss/screen.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<style type="text/css">
#treetable {
	width: 250px;
	display:inline;
	font-size: 17px;
}

#d-table {
	display:inline;
	border: 1px;
	position: relative;
	left: 350px;
	bottom: 350px;
	 
}

.stats-List{
	font-size: 17px;
	text-align: center;
	border-collapse: collapse;
}

.stats-List td {
		border: 2px solid #B2B2B2;
		width: 262px;
		height: 50px;
	}
	
.stats-List .td-left {
		background: #161E67;
	}

.td-left{
	color: #FFF2CA;
	font-weight: bold;
}

	
a {
	 text-decoration: none;
	 color: black;
}

.stats-List img {
		width: 262px;
		height: 262px;
		image-rendering: -webkit-optimize-contrast;
		object-fit: cover;
		display: block;
	}
	
#d-table{
	display:none;
}
</style>

<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script src="/resources/js/myjs/jquery.cookie.js" type="text/javascript"></script>
<script src="/resources/js/myjs/jquery.treeview.js"
	type="text/javascript"></script>
</head>
<body>
	<table id="treetable">
		<tr>
			<td style="font-size: 40px;">조직도</td>

		</tr>
		<tr>
			<td rowspan="11">
				<div id="sidetree">
					<div class="treeheader">&nbsp;</div>
					
					<c:forEach items="${dept}" var="dept">
						<ul id="tree">
							<li class="collapsable">
								<div class="hitarea collapsable-hitarea"><i class="bi bi-caret-down-fill"></i></div>
								<strong>${dept.d_name}</strong>
								<ul>
									<c:forEach items="${memberList}" var="member">
										<c:if test="${member.d_num eq dept.d_num}">
											<li><a href='javascript:void(0);' onclick="showEmplInfo('${member.e_id}')">[${member.e_position}]${member.e_name}</a></li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
					</c:forEach>
				</div>

			</td>
			
		</tr>

	</table>
	
	<div class="d-table" id="d-table">
					<form action="/organization/read" method="post" id="memInfo">
						<table class="stats-List">
							<tr>
								<td class="td-left">사원번호</td>
								<td id="e_id" class="td-right"></td>
								<td rowspan="4"><img id="e_picfile" alt="사원 사진"></td>
							</tr>
							<tr>
								<td class="td-left">이름</td>
								<td id="e_name" class="td-right"></td>
							</tr>
							<tr>
								<td class="td-left">부서</td>
								<td id="d_name" class="td-right"></td>
							</tr>
							<tr>
								<td class="td-left">직급</td>
								<td id="e_position" class="td-right"></td>
							</tr>
							<tr>
								<td class="td-left">생일</td>
								<td colspan="2" id="e_birth" class="td-right"></td>
								<tr>
								<td class="td-left">전화번호</td>
								<td colspan="2" id="e_pnum" class="td-right"></td>
							</tr>
						</table>
						<br>
					</form>
				</div>
	
	
	<script type="text/javascript">
		$("#tree").treeview({
			collapsed : false,
			animated : "medium",
			
			persist : "location"
		});
		
		function showEmplInfo(e_id){
		    var objDiv = document.getElementById('d-table');
		    if(objDiv.style.display!="block"){ objDiv.style.display = "block"; }
		    
		    // ajax 이용하여 memNum으로 검색해온 데이터를 테이블에 출력
		    $.ajax({
		    	url : "/organization/read",
		    	type : "get",
		    	contentType : "application/json",
				dataType : "json",
		    	data : { "e_id" : e_id },
		    	success : function(data) {
		    		$("#e_id").text(data.e_id);
		    		$("#e_name").text(data.e_name);
		    		$("#d_name").text(data.d_name);
		    		$("#e_position").text(data.e_position);
		    		$("#e_birth").text(data.e_birth);
		    		$("#e_pnum").text(data.e_pnum);
		    		$("#e_picfile").attr("src", "/resources/img/" + data.e_picfile);
		    	},
		    	error : function() {
		    		alert("ajax 실행 오류!!");
		    	}
		    });
		}
	</script>
</body>
</html>