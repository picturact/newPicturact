<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  <meta charset="utf-8"> -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
    <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">        
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">

$.ajaxSetup({
	type : "POST",
	async : true,
	dataType : "json",
	error : function(xhr){
		alert("error html = " + xhr.statusText);
	}
});
$(function(){
	$("#joinId").blur(function(){
		$.ajax({
			url:"/joinIdCheck.join",
	// 			data{}에서는 EL을 ""로 감싸야함..그외에는 그냥 사용
			data:{	
				joinId:$("#joinId").val()
			},
			success:function(data){
				idCheck(data);
			}
		});
	});
	function idCheck(data){
		if(data.result=="OK"){
			alert($("#joinId").val()+" can use!!");
			$("#joinPassword").focus();
		} else {
			alert("Already used..");
			$("#joinId").val("");
			$("#joinId").focus();
		}
	}
});
</script>
</head>
<body>
                        	<div class="form-top" >
                        		<div class="form-top-left">
                        			<h3>Join</h3>
                            		<p>Fill in the form below to get instant access:</p>
                        		</div>
                        		<div class="form-top-right">
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form action="/join.join" method="post">
			                    	<div class="form-group">
			                    		<!-- ID -->
			                        	<input type="text" placeholder="Input your ID..." class="form-control" name="userId" id="joinId">
			                        </div>
			                        <div class="form-group">
			                        	<!-- PASSWORD -->
			                        	<input type="password" placeholder="Input your Password..." class="form-control" name="password" id="password">
			                        </div>
			                        
			                        <div class="form-group">
			                        	<!-- User nickName -->
			                        	<input type="text" placeholder="Input your Nickname..." class="form-control" name="nickName" id="nickName">
			                        </div>
			                        
			                        <div class="form-group">
			                        	<!-- USERNAME -->
			                        	<input type="text" placeholder="Input your Name..." class="form-control" name="userName" id="userName">
			                        </div>			                        
			                        
			                        <div class="form-group">
			                        	<!-- E-MAIL -->
			                        	<input type="text" placeholder="E-mail..." class="form-control" name="eMail" id="eMail">
			                        </div>
			                        
			                        <span style="float:right">
<!-- 				                        <input type="button" class="btn btn-default" value="Join" /> -->
				                        <button type="submit" style="" class="btn btn-default" >Join</button>
				                        <input type="button" class="btn btn-link-2 scroll-link" onclick="location.href='#page-top'" value="Cancel">
			                        </span>
			                    </form>
		                    </div>
			                    

        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>