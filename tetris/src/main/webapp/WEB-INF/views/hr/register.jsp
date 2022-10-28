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
 <form role="form" method="post" autocomplete="off"	accept-charset="UTF-8">
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
  <div class="input_area">
   <label for="userId">아이디</label>
   <input type="text" id="userId" name="userId" placeholder="example123" required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userName">이름</label>
   <input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" required="required" />      
  </div>
  
  
  <div class="input_area">
   <label for="userPass">패스워드</label>
   <input type="password" id="userPass" name="userPass" required="required"	 />      
  </div>
  
 
  
  <div class="input_area">
   <label for="userPhon">연락처</label>
   <input type="text" id="userPhon" name="userPhoneNumber" placeholder="연락처를 입력해주세요" required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userHire">입사일</label>
   <input type="text" id="userHire" name="userHireddate" placeholder="입사일을 입력해주세요.." required="required" />      
  </div>
  
  <!--  <div class="input_area">
   <label for="userResign">퇴사일</label>
   <input type="text" id="userResign" name="userResigndate" placeholder="퇴사일을 입력해주세요."  />      
  </div> -->
  
   <div class="input_area">
   <label for="userTotalvac">총연차일수</label>
   <input type="text" id="userTotalvac" name="userTotalvaction" placeholder="총연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userUsevac">사용연차수</label>
   <input type="text" id="userUsevac" name="userUsevacation" placeholder="사용연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userBirth">생년월일</label>
   <input type="text" id="userBirth" name="userBirth" placeholder="생년월일을 입력해주세요." required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userNumber">사원번호</label>
   <input type="text" id="userNumber" name="userNumber" placeholder="사원번호를 입력해주세요.	" required="required" />      
  </div>
 
  <div class="input_area">
   <label for="userPosition">직급</label>
   <input type="text" id="userPosition" name="userPosition" placeholder="직급을 입력해주세요." required="required" />      
  </div>
  
  <div class="input_area">
   <label for="departmentNumber">부서번호</label>
   <input type="text" id="departmentNumber" name="departmentNumber" placeholder="부서번호를 입력해주세요..."  />      
  </div>
  <div class="input_area">
  <label for="authmapping">권한</label>
  <input type="text" id="auth" name ="auth" placeholder="권한을 입력해주세요..."/>
  </div>
  
  <button type="submit" id="insertUser_btn" name="insertUser_btn">회원가입</button>
  
 </form>   
</section>
</body>
</html>