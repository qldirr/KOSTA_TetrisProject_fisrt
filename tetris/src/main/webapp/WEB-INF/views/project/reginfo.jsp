<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/project/registerend" method="post" accept-charset="UTF-8">
		프로젝트명: <input type="hidden" name="pj_name" value="${project.pj_name }">${project.pj_name }<br> 
		프로젝트유형: <input type="hidden" name="pj_type" value="${project.pj_type }">${project.pj_type }<br> 
		프로젝트시작일: <input type="hidden" name="pj_startdate" value="${project.pj_startdate }">${project.pj_startdate }<br> 
		프로젝트마감일: <input type="hidden" name="pj_enddate" value="${project.pj_enddate }">${project.pj_enddate }<br>
		프로젝트매니저: <input type="hidden" name="pj_manager" value="${project.pj_manager }">${project.pj_manager }<br> 
		프로젝트참여자: ${project.e_id }
		프로젝트내용: <input type="hidden" name="pj_contents" value="${project.pj_contents }">${project.pj_contents }<br>
		<input type="submit" value="새 프로젝트 생성">
	</form>
</body>
</html>