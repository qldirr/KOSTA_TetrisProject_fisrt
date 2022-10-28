<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/vender/jquery/jquery-3.6.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">

var cloneObj = $(".upload").clone();


function showUploadFile(uploadResultArr){
	
	if(!uploadResultArr || uploadResultArr.length == 0){return;}
	
	var uploadUL = $(".uploadResult ul");
	
	var str = "";
	
	$(uploadResultArr).each(function(i, obj){
		
		alert(obj.pf_path);
		
		if(obj.image){
			var fileCallPath = encodeURIComponent(obj.pf_path + "/s_" + obj.pf_uuid + "_" + obj.pf_name);
			str += "<li data-path='"+obj.pf_path+"'";
			str += " data-uuid='" + obj.pf_uuid+ "' data-filename ='" + obj.pf_name +"'";
			str += "><div>";
			str += "<span>" + obj.pf_name + "</span>";
			str += "<input type='button' value='삭제'></button><br>";
			str += "<a><img src = '/display?fileName="+fileCallPath+"'>";
			str += "</div>";
			str += "</li>";
		} else {
			var fileCallPath = encodeURIComponent(obj.pf_path + "/" + obj.pf_uuid + "_" + obj.pf_name);
			var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
			
			str += "<li data-path='" + obj.pf_path +"'";
			str += " data-uuid= '" + obj.pf_uuid+ "' data-filename ='" + obj.pf_name +"'";
			str += "><div>";
			str += "<span>" + obj.pf_name + "</span>";
			str += "<input type='button' value='삭제'></button><br>";
			str += "<img src = '/resources/img/attach.png'></a>";
			str += "</div>";
			str += "</li>";
		}
	});
	
	uploadUL.append(str);
}

$(function() {
	

	$("input[type='file']").on('change', function(e){
	//<input type='file'>의 내용이 변경 되었을 때 파일 업로드 시작
		
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		
		console.log(files);
		
		//파일을 formData에 저장하기
		for(var i=0; i<files.length; i++){
			
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			
			url: "/projectdetail/uploadfile",
			processData: false,
			contentType: false,
			data: formData, 
			type: 'POST',
			dataType: 'json',
			success: function(result){
				alert("uploaded");
				showUploadFile(result);
				$(".upload").html(cloneObj.html());
			}
		});
	});
	

	
	var formObj = $("form[role='form']");
	
	$("#registProjectBoard").on("click", function(e){
		
		e.preventDefault();
		
		console.log("submit clicked");
		
		var str = "";
	
		
		$('.uploadResult ul').find('li').each(function(i, obj){
			var jobj = $(obj);
			
			console.log(jobj);
			
			str += "<input type='hidden' name='attachList["+i+"].pf_name' value='"+jobj.data("filename")+"'>";
			str += "<input type='hidden' name='attachList["+i+"].pf_uuid' value='"+jobj.data("uuid")+"'>";
			str += "<input type='hidden' name='attachList["+i+"].pf_path' value='"+jobj.data("path")+"'>"; 
		});
		
	
		formObj.append(str).submit(); 
	
	});
})


</script>
</head>

<body>
	<h1>새 글 등록</h1>
	<form role="form" action="/projectdetail/register" method="post">
		<input type="hidden" id="pj_num" name="pj_num" value="${pj_num}">
		<input type="hidden" id="pb_writer" name="pb_writer" value="gdong123">
		<textarea name="pb_contents" rows="5" cols="75"></textarea>
		<br> <input type="checkbox" id="notice" name="pb_status" value="Y"> 공지글지정 <br>
		<div class='upload'>
			<input type="file" name='uploadFile' multiple>
		</div>
	<div class="uploadResult">
		<ul>
	
		</ul>
	</div>
		<input type="submit" id="registProjectBoard" value="글 등록하기"><br>
		<br>
	</form>
</body>
</html>