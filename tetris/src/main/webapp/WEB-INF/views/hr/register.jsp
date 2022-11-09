<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
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
   <input type="text" id="userId" name="e_id" placeholder="example123" required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userName">이름</label>
   <input type="text" id="userName" name="e_name" placeholder="이름을 입력해주세요" required="required" />      
  </div>
  
  
  <div class="input_area">
   <label for="userPass">패스워드</label>
   <input type="password" id="userPass" name="e_pw" required="required"	 />      
  </div>
  
 
  
  <div class="input_area">
   <label for="userPhon">연락처</label>
   <input type="text" id="userPhon" name="e_pnum" placeholder="연락처를 입력해주세요" required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userHire">입사일</label>
   <input type="text" id="userHire" name="e_hireddate" placeholder="입사일을 입력해주세요.." required="required" />      
  </div>
  
  <!--  <div class="input_area">
   <label for="userResign">퇴사일</label>
   <input type="text" id="userResign" name="userResigndate" placeholder="퇴사일을 입력해주세요."  />      
  </div> -->
  
   <div class="input_area">
   <label for="userTotalvac">총연차일수</label>
   <input type="text" id="userTotalvac" name="e_totalvac" placeholder="총연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userUsevac">사용연차수</label>
   <input type="text" id="userUsevac" name="e_usevac" placeholder="사용연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="input_area">
   <label for="userBirth">생년월일</label>
   <input type="text" id="userBirth" name="e_birth" placeholder="생년월일을 입력해주세요." required="required" />      
  </div>
  
  <div class="input_area">
   <label for="userPosition">직급</label>
   <input type="text" id="userPosition" name="e_position" placeholder="직급을 입력해주세요." required="required" />      
  </div>
  
  <div class="input_area">
   <label for="departmentNumber">부서번호</label>
   <input type="text" id="departmentNumber" name="d_num" placeholder="부서번호를 입력해주세요..."  />      
  </div>
  <div class="input_area">
  <label for="authmapping">권한</label>
  <input type="text" id="auth" name ="a_auth" placeholder="권한을 입력해주세요..."/>
  </div>
	
  <button type="submit" id="insertUser_btn" name="insertUser_btn">회원가입</button>
  
 </form>   
</section>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title></title>
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/css/cusRegister.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
	
	$(document).ready(
			
			
			function(){		
		$('#idChk').on('click', function(){
			var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
			console.log($('#userId').val());
			
			$.ajax({
				url : "/hr/idCheck",
				type : "post",
				dataType : "json",
				data : {e_id: $('#userId').val()},
				success : function(data){
					if(idReg.test($('#userId').val())){
						if(data == 1){
							alert("중복된 아이디입니다.");
						}else if(data == 0){
							$("#idChk").attr("value", "Y");
							alert("사용가능한 아이디입니다.");
						}
						
					}
					else if(!idReg.test($('#userId').val())){
						   alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
						


					}
				}
			})
		});
		
		$("#submit").on("click", function(){
			if($("#userId").val()==""){
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			if($("#userPass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
			if($("#userName").val()==""){
				alert("성명을 입력해주세요.");
				$("#userName").focus();
				return false;
			}
			var idChkVal = $("#idChk").val();
			if(idChkVal == "N"){
				alert("중복확인 버튼을 눌러주세요.");
			}else if(idChkVal == "Y"){
				$("#regForm").submit();
			}
		});
		
		
		
			}
		);
	</script>
</head>
<body>
<div class="container">
<section id="content">
 <form role="form" method="post" autocomplete="off"	accept-charset="UTF-8" id="regForm">
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
  <div class="form-group">
   <label for="userId">   아이디:</label>
   <input type="text" id="userId" class="form-control" name="e_id" placeholder="example123" required="required"/>
   <button type="button" id="idChk" value="N">아이디확인</button>   
   
   </div> 
 
   <div class="form-group">
   <label for="userName">  이름:</label>
   <input type="text" id="userName"  class="form-control"  name="e_name" placeholder="이름을 입력해주세요" required="required" />      
  </div>
  <div class="form-group">
   <label for="userPass">패스워드:</label>
   <input type="password" id="userPass"  class="form-control" name="e_pw" required="required" placeholder="비밀번호를 입력해주세요."/>      
  </div>
  
 
  
  <div class="form-group">
   <label for="userPhon"> 연락처:</label>
   <input type="text" id="userPhon"  class="form-control" name="e_pnum" placeholder="연락처를 입력해주세요" required="required" />      
  </div>
  
   <div class="form-group">
   <label for="userHire">입사일:</label>
   <input type="text" id="userHire"  class="form-control" name="e_hireddate" placeholder="입사일을 입력해주세요.." required="required" />      
  </div>
  
  <!--  <div class="input_area">
   <label for="userResign">퇴사일</label>
   <input type="text" id="userResign" name="userResigndate" placeholder="퇴사일을 입력해주세요."  />      
  </div> -->
  
   <div class="form-group">
   <label for="userTotalvac">총연차일수:</label>
   <input type="text" id="userTotalvac"  class="form-control" name="e_totalvac" placeholder="총연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="form-group">
   <label for="userUsevac">사용연차수:</label>
   <input type="text" id="userUsevac"  class="form-control" name="e_usevac" placeholder="사용연차일수를 입력해주세요." required="required" />      
  </div>
  
   <div class="form-group">
   <label for="userBirth">생년월일:</label>
   <input type="text" id="userBirth"  class="form-control" name="e_birth" placeholder="생년월일을 입력해주세요." required="required" />      
  </div>
  
  <div class="form-group">
   <label for="userPosition">직급:</label>
   <input type="text" id="userPosition"  class="form-control" name="e_position" placeholder="직급을 입력해주세요." required="required" />      
  </div>
  
  <div class="form-group">
   <label for="departmentNumber">부서번호:</label>
   <input type="text" id="departmentNumber"  class="form-control" name="d_num" placeholder="부서번호를 입력해주세요..."  />      
  </div>
  <div class="form-group">
  <label for="authmapping">권한:</label>
  <input type="text" id="auth"  class="form-control" name ="a_auth" placeholder="권한을 입력해주세요..."/>
  </div>
	
  <button type="submit" id="submit" class="form-control" name="insertUser_btn">회원가입</button>
  
 </form>   
</section>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.js"></script>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
>>>>>>> branch 'main' of https://github.com/joon411/TetrisFinal.git
</body>
</html>