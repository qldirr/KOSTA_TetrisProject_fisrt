<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/jquery-ui.css" />
<script src="/resources/vender/jquery/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="/resources/lib/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/vender/bootstrap/css/bootstrap.min.css">


<script type="text/javascript">


	var order = [];
	var today = new Date();
	var enddate;
	var remain;

	var moveTo = (function() {

		function main() {
			self.location = "/project/main";
		}

		function registerTask() {
			self.location = "/projectdetail/registerTask";
		}

		function calendar() {
			self.location = "/projectdetail/calendar";
		}

		function task() {
			self.location = "/projectdetail/taskboard";
		}

		function home() {

			var pj_num = ${pj_num};
			self.location = "/projectdetail/home/" + pj_num;
		}
		
		function tasklist(){
			self.location = "/projectdetail/tasklist";
		}

		return {
			main : main,
			registerTask : registerTask,
			calendar : calendar,
			task : task,
			home : home,
			tasklist : tasklist

		}

	})();
	
	var taskService = (function(){
		
		var todo = "";
		var doing = "";
		var done = "";

		
		
		/* 등록된 업무 보드 정보 */
		function getTask(){
			
			$.ajax({
				url : '/projectdetail/taskList',
				type : 'get',
				dataType : 'json',
				contentType : "application/json"
			}).done(function(data, textStatus, xhr) {
				
				$.each(data, function(index, value){
					
					enddate = new Date(value.ts_enddate);
					
					remain = (today.getTime() - enddate.getTime())/(1000*60*60*24);

					if(value.ts_status == "예정"){
						
						$('.todo').empty();
						
						todo += '<div id='+ value.ts_num +' class="card bg-light mb-3" style="max-width: 18rem;">';
						todo += '<div class="card-header">' + value.ts_name +'<label class=\"delete\">'+ "[x]" +'</label></div>';
						todo += '<div class="card-body">';
						todo += '<h5 class="card-title">' + value.ts_contents + '</h5>';
						todo += '<p class="card-text">' + value.ts_manager + '</p>';
						
						if(remain > -4 & remain <= 0){
							todo += '<p><마감 '+ Math.abs(Math.floor(remain)) + '일 전></p></div></div>';
						} else {
							todo += '</div></div>';
						}
						
						$('.todo').append(todo);
						
					} else if(value.ts_status == "진행"){
						
						$('.doing').empty();
						
						
						doing += '<div id='+ value.ts_num +' class="card bg-light mb-3" style="max-width: 18rem;">';
						doing += '<div class="card-header">' + value.ts_name +'<label class=\"delete\">'+ "[x]" +'</label></div>';
						doing += '<div class="card-body">';
						doing += '<h5 class="card-title">' + value.ts_contents + '</h5>';
						doing += '<p class="card-text">' + value.ts_manager + '</p>';
						
						if(remain > -4 & remain <= 0){
							doing += '<p><마감 '+ Math.abs(Math.floor(remain)) + '일 전></p></div></div>';
						} else {
							doing += '</div></div>';
						}
						
						
						$('.doing').append(doing);
						
					} else {
						
						$('.done').empty();
						
						done += '<div id='+ value.ts_num +' class="card bg-light mb-3" style="max-width: 18rem;">';
						done += '<div class="card-header">' + value.ts_name +'<label class=\"delete\">'+ "[x]" +'</label></div>';
						done += '<div class="card-body">';
						done += '<h5 class="card-title">' + value.ts_contents + '</h5>';
						done += '<p class="card-text">' + value.ts_manager + '</p></div></div>';
						
						$('.done').append(done);
					}


				})
							
		}); /* end ajax */
			
	}/* end function getTask */
		
		
		/* 업무보드 수정 */
		function update(task){
			
			$.ajax({
   				url : '/projectdetail/modifyTask',
   				type : 'post',
   				data : JSON.stringify(task),
   				contentType : "application/json"
   				}).done(function() {
   					
   					console.log("수정 완료")
   				
   			}); /* end ajax */
		}/* end function update */
		
		
		function del(del_ts_num){
			$.ajax({
				url : '/projectdetail/removeTask',
   				type : 'post',
   				data : {"ts_num" : del_ts_num}
			}).done(function(){
				
				self.location = "/projectdetail/taskboard";
			}); /* end ajax */
		}/* end function del */
		
		return {
			getTask : getTask,
			update : update,
			del : del
		}
		
	})();

	$(function() {
		
		taskService.getTask();
		
		var ts_num = "";
		var ts_status = "";
	
		
		$('td').sortable({
			 connectWith: 'td',
			 item : '> .card',
			 start : function(event, ui){
				 
	               $(this).css('background-color', '#F5F5F5');
	               ts_num = ui.item.attr('id');
	               console.log(ui.item.attr('id'))
	               
	            },
	            remove : function(event, ui){
	            	
	            	$(this).siblings().children().each(function(){
	            		order.push($(this).attr('id'));
	            	})
	            	
	            	/* 카드가 이동한 후 이전 보드에 저장되어야할 순서 */
	            	console.log($(this).attr('class'));
	            	console.log(order);
	            	
	            },
	            receive: function(event, ui){
	            	
	            	/* 카드가 도착한 후 저장되어야할 순서 */
	            	var status = $(this).attr('class');
	            	
	            	if(status.startsWith("todo")){
	            		ts_status = "예정";
	            	} else if(status.startsWith("doing")){
	            		ts_status = "진행";
	            	} else {
	            		ts_status = "완료";
	            	}
	            	
	            	console.log(ts_status);
	            	console.log(order);
	            	
	            },
	            stop : function(event, ui){
	            	
	               $(this).css('background-color', 'transparent');
	               
	               var task = {
	            		   "ts_num" : ts_num,
	            		   "ts_status" : ts_status
	               }
	               
	               /* 카드 이동이 멈춘 후 update 함수 호출 */
	               taskService.update(task);
	          	}
	            
		}).disableSelection();

		$('#regTask').on('click', moveTo.registerTask);

		$('#backBtn').on('click', moveTo.main);

		$('#showTaskBoard').on('click', moveTo.task);

		$('#showMain').on('click', moveTo.home);
		
		$('#showTaskList').on('click', moveTo.tasklist);
		
		/* 삭제버튼을 누르면 del 함수 호출 */
		$(document).on('click', '.delete', function(){
			var del_ts_num = $(this).parent().parent().attr('id');
			
			taskService.del(del_ts_num);
			
		})

	})
	
</script>
</head>
<body>

	<h1>프로젝트 ${pj_num } 스크럼 보드</h1>

	<div id="projectMenu">
		<input type="button" id="regTask" value="업무 등록하기"> 
		<input type="button" id="backBtn" value="이 프로젝트 나가기"> 
		<input type="button" id="showMain" value="프로젝트 홈으로 가기"> 
		<input type="button" id="showTaskBoard" value="업무보드 보기">
		<input type="button" id="showTaskList" value="업무리스트 보기">
	</div>

	<br>
	<br>

	<table class="table" style="width: 50%">
		<thead class="table table-bordered">
			<tr>
				<th scope="col" style="width: 33.3%">TO DO</th>
				<th scope="col" style="width: 33.3%">DOING</th>
				<th scope="col" style="width: 33.3%">DONE</th>
			</tr>
		</thead>
		<tbody>
			<tr class="column">
				<td class="todo">
				</td>
				<td class="doing">
				</td>
				<td class="done">
				</td>
			</tr>
		</tbody>
	</table>



</body>

</html>

