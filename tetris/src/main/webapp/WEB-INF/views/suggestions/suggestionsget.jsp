<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ include file="../includes/header.jsp"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="/resources/vender/bootstrap/css/bootstrap.min.css"
   rel="stylesheet">
<link href="/resources/css/index.css" rel="stylesheet">
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
	<script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
					<script src="/resources/js/index.js"></script>
	<script src="/resources/vender/bootstrap/js/bootstrap.min.js"></script>
					

<head>



</head>
<body>
<h1>.</h1>
 <div class="container-fluid ">
      <div class="row">
         <!-- sidebar -->
         <div class="col-xl-2 col-lg-3"></div>
         <div class="col-xl-10 col-lg-9">        
<div style="width: 100%; height: 1000;">

<h1>Suggestions Read Page</h1>




        <form role="form" method="post">   

          <div class="form-group">
            <label>Id</label> <input class="form-control" name='e_id'
            value='<c:out value="${suggestions.e_id}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>title</label> <input class="form-control" name='s_title'
            value='<c:out value="${suggestions.s_title}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>Contents</label> <input class="form-control" name='s_contents'
            value='<c:out value="${suggestions.s_contents}"/>' readonly="readonly">
          </div>


		<button type="button" class="btn btn-info" id="button"
		onclick="location.href='/suggestions/suggestionsmodify?s_num=<c:out value="${suggestions.s_num}"/>'">
		Modify</button>

		<button type="button" class="btn btn-info" id="button" 
		onclick="location.href='/suggestions/suggestionslist'">
		List</button>

    <style>
        #button{
            margin-left:5px;
        }
    </style>
	
<form id='operForm' action="/suggesiotns/suggesiotnsmodify" method="get">
	<input type='hidden' id='s_num' name='s_num' value='<c:out value="${suggesiotns.s_num}"/>'>
	<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
	<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
</form>




<div class='row'>

	<div class ="col-lg-12">
		<div class="panel panel-default">
	<div class="panel-heading">	
 		<i class="fa fa-comments fa-fw"></i><br>
 			<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right' >New Reply</button>
	</div>
			
			<div class="panel-body">
			
		<ul class="chat">
		<li class="left clearfix" data-row='12'>
			<div>
		<div class="header">
			<strong class="primary-font">Reply</strong>
			<small class="pull-right text=muted">Reply</small>
		</div>
		<p>Reply</p>
	</div>
					</li>
				</ul>
			</div>	
		</div>
	</div>
</div>

    <style>
        #addReplyBtn{
            margin-left:20px;
        }
    </style>
    

                         
                           
                           
 <!-- Modal -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
 aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content">
         
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" 
                 aria-hidden="true">&times;</button>
                 <h4 class="modal-title" id="myModalLabel"/>
             </div>
             
             <div class="modal-body">        
                  
             <div class="form-group">
             <!-- <label>Replyer</label>
             <input class="form-control" name="r_replyer" value='New Replyer'> 
             </div> -->
             
             <div class="form-group">
             <label>Reply</label>                                        
             <input class="form-control" name="r_reply" value='reply'>
             </div>
             
             <div class="form-group">
             <label>Reply Date</label>                                        
             <input class="form-control" name="replyDate" value=''>
             </div>                                                                                
             </div>   
                        
             <div class="modal-footer">
<button id='modalModBtn' type="button" class="btn btn-info">Modify</button>
<button id='modalRemoveBtn' type="button" class="btn btn-info">Remove</button>
<button id='modalRegisterBtn' type="button" class="btn btn-info">Register</button>
<button id='modalCloseBtn' type="button" class="btn btn-info">Close</button>                                        
                        </div>
                   
                    </div>
                </div>
            </div>
    
    


</form>

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	var operForm = $("#operForm");
	
	$("button[data-oper='modify']").on("click", function(e){
		operForm.attr("action","suggestions/suggestionsmodify").submit();
		})
	
		
	var s_numValue = '<c:out value="${suggestions.s_num}"/>';
	var replyUL = $(".chat");
	
	showList(1);
	
	function showList(page){
		
		replyService.getList({s_num:s_numValue,page: page|| 1}, function(list) {
			
			var str="";
			if(list == null || list.length == 0){
				replyUL.html("");
				
				return;
			}			
			
			for(var i =0, len = list.length || 0; i < len; i++){
				str +="<li class='left clearfix' data-r_num='"+list[i].r_num+"'>";
				str +="<div><div class='header'><strong class='primary-font'>"+list[i].r_replyer+"</strong>";
				str +="<small class='pull-right text-muted'>"+replyService.displayTime(list[i].r_regdate)+"</small></div>";
				str +="<p>"+list[i].r_reply+"</p></div></li>";
			}
			replyUL.html(str);
		});
		
	}//end showlist
	
	

		var modal = $(".modal");
		var modalInputReply = modal.find("input[name='r_reply']");
		var modalInputReplyer = modal.find("input[name='r_replyer']");
		var modalInputReplyDate = modal.find("input[name='replyDate']");
		
		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn = $("#modalRemoveBtn");
		var modalRegisterBtn = $("#modalRegisterBtn");
		
		$("#modalCloseBtn").on("click", function(e){
			modal.modal('hide');
		});
		
	$("#addReplyBtn").on("click", function(e){
		
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id !='modalCloseBtn']").hide();
		
		modalRegisterBtn.show();

		$(".modal").modal("show");
		
		
		});
	
	
	modalRegisterBtn.on("click", function(e){
		
		var reply = {
			r_reply: modalInputReply.val(),
			r_replyer:modalInputReplyer.val(),
			s_num:s_numValue 
		};
		
	replyService.add(reply, function(result){
	   
		   alert(result);
	   
		   modal.find("input").val("");
		   modal.modal("hide");
	   
		   showList(1);  
		});
	});    	

	
	
	
	
	
	
});
	
</script>
    



</div>
</div>
</div>
</div>
	
      <!-- Optional JavaScript; choose one of the two! -->

      <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
      <script src="/resources/vender/jquery/jquery-3.6.1.min.js"></script>
      <script src="/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="/resources/js/index.js"></script>

      <%@ include file="../includes/footer.jsp"%>
</body>
</html>