<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<head>
<title></title>
</head>
<body>
<section id="content">
 <form role="form" method="post" action="/hr/modify" autocomplete="off"	accept-charset="UTF-8">
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
   <p>${u.e_name}님의 정보</p>
      <div class="input_area">
   <label for="userId">아이디</label>
   <input type="text" id="e_id" name="e_id" value = "${u.e_id}" required="required" />      
  </div>
   <div class="input_area">
   <label for="userName">이름</label>
   <input type="text" id="e_name" name="e_name" value = "${u.e_name}" required="required" />      
  </div>
  
  
  <div class="input_area">
   <label for="userPass">패스워드</label>
   <input type="password" id="e_pw" name="e_pw" value = "${u.e_pw}"  required="required" />      
  </div>
  
 
  
  <div class="input_area">
   <label for="userPhon">연락처</label>
   <input type="text" id="e_pnum" name="e_pnum" value = "${u.e_pnum }" required="required" />      
  </div>
  
  
  
  <!--  <div class="input_area">
   <label for="userResign">퇴사일</label>
   <input type="text" id="userResign" name="userResigndate" placeholder="퇴사일을 입력해주세요."  />      
  </div> -->
  

   <div class="input_area">
   <label for="userBirth">생년월일</label>
   <input type="text" id="e_birth" name="e_birth" value = "${u.e_birth}"  required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userPosition">직급</label>
   <input type="text" id="e_position" name="e_position" value = "${u.e_position}" required="required" />      
  </div>
  <div class="input_area">
   <label for="departmentNumber">부서번호</label>
   <input type="text" id="d_num" name="d_num" value = "${u.d_num}" />      
  </div>
 <!--  <a href="/hr/list">수정하기</a> -->
  <button type="submit" id="updateUser_btn" name="updateUser_btn">수정하기</button>

 </form>   
</section>
</body>
</html>