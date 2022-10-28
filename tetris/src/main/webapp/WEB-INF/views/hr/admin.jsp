<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>admin page</h1>

<p>principal :<sec:authentication property="principal"/></p>
<p>UserVO :<sec:authentication property="principal.user"/></p>
<p>사용자이름 :<sec:authentication property="principal.user.userName"/></p>
<p>사용자아이디 :<sec:authentication property="principal.username"/></p>
<p>사용자 권한 리스트:<sec:authentication property="principal.user.authList"/></p>


admin page
<a href="/member/customLogout">Logout</a><br>
<a href="/hr/register">회원가입</a>
</body>
</html>