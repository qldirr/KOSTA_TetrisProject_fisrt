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
<h1>user</h1>
user
<p>어서오세요.<sec:authentication property="principal.user.userName"/>님</p>
<p>아이디: <sec:authentication property="principal.username"/></p>	
<a href="/member/customLogout">Logout</a>
</body>
</html>