<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html >
    <head>
    	
    	<meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
 		<!--Cascading style sheets-->
        <link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
        
        <!--Javascript files-->        
        <script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
        <title>Digipass | Sign up</title>
        
        <style>
        	.cust-inp-box{
        		border:none;
        		box-shadow:none;
        		border-bottom:1px solid #f1f1f1;
        		background-color:#ddd;
        		font-size: 16px;
        	}
        	.parent-div {
			    margin: 15px 0 15px;
			    position: relative;
			}
        	.mylabel {
			    position: absolute;
			    font-weight: normal;
			    top: 10px;
			    font-size:14px;
			    transition: 0.5s ease;
			    -webkit-transition: 0.25s ease;
			}
			.added-placeholder > label.mylabel{
				top:-10px;
				font-weight:bold;
				font-size:12px;
			}
			.form-control:focus{
				border-color:#FFB41C;
				border-width:2px;
				box-shadow:none;
				
			}
			.error{
				color:red;
				font-weight:normal; 
			}
			.sign-up-section {
			    background: #ddd none repeat scroll 0 0;
			}
			.sign_up-middle{
				max-width:860px;
				width:100%;
				margin:18px auto;
			}
			.col-left-margin {
			    margin: 20px 0;
			}
			button.btn.btn-submit {
			    background-color: #ffb41c;
			    color: #fff;
			    margin: 28px 0 0;
			    padding: 4px 12px;
			    max-width: 120px;
			    width:100%;
			}
			.row-bg{
				background:#f1f1f1;
			}
        </style>
    </head>
    <body>
    <%String status=null; %>
    <%String msg=null; %>
    <c:if test="${!empty status}">
		<%status=(String)request.getAttribute("status");%>
		<%msg=(String)request.getAttribute("msg");%>
	</c:if>
      <p class="top-strap"></p>
      
      <div class="container">
	      <div class="sign_up-middle">
	      	<!--<div class="digi-logo" align="center">
  				<img class="img-responsive" src="img/logo.png" />
  			</div>-->
	      	<div class="row">
	      		<div class="row-bg clearfix">
	      		<div class="col-lg-6 col-md-6 col-sm-6">
	      			<div class="digi-logo" align="center">
		  				<img class="img-responsive" src="<c:url value="/resources/theme/img/logo.png" />" />
		  			</div>
	      			<h3 class="text-center">Create your Digipass Account</h3>
	      			<div style="">
	      			<div class="login-right-section" style="float:none">
	      			<div class="row">
		      				<div class="col-md-4">
		      					<div class="img-div">
		      						<img alt="icon1" src="<c:url value="/resources/theme/img/ICON 1 - long form.png" />">
		      					</div>
		      				</div>
		      				<div class="col-md-8">
		      					<div class="text_div">
		      						<p>No more long registration forms to fill out for users</p>
		      					</div>
		      				</div>
		      			</div>
		      			<div class="row">
		      				<div class="col-md-8">
		      					<div class="text_div">
		      						<p>No miscommunication regarding Id proofs required to enter the premises</p>
		      					</div>
		      				</div>
		      				<div class="col-md-4">
		      					<div class="img-div">
		      						<img alt="icon1" src="<c:url value="/resources/theme/img/ICON 2 - id proof.png" />">	      						
		      					</div>
		      				</div>
		      			</div>
		      			<div class="row">
		      				<div class="col-md-4">
		      					<div class="img-div">
		      						<img alt="icon1" src="<c:url value="/resources/theme/img/ICON 3 - time saving.png" />">
		      					</div>
		      				</div>
		      				<div class="col-md-8">
		      					<div class="text_div">
		      						<p>Reduce waiting time for your visitors significantly.</p>
		      					</div>
		      				</div>
		      			</div>
	      			</div>
	      			</div>
	      		</div>
	      		<div class="col-lg-6 col-md-6 col-sm-6">
	      			<div>
		      			
		      			<div class=" col-left-margin clearfix" style=" margin-top: 100px;">
		      				<div class="col-left-margin col-left-margin clearfix">							
								<c:if test="${!empty status}">
									<p style="font-size:15px;font-weight:bold; color: green;">${msg}</p>
								</c:if>
							</div>
							<div class="col-left-margin col-left-margin clearfix">
	                   			 <a href="<c:url value="/"/>"> <input type="button" class="btn btn-warning btn-sm" value="Back to Home"> </a>								
							</div>
			      		</div>
	      			</div>
	      		</div>
	      		</div>
	      	</div>
	      </div>
      </div>
    </body>
    <script type="text/javascript" src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
    <script>
    	$( ".cust-inp-box" ).focus(function() {
  $(this).parent().addClass('added-placeholder');
});
$( ".cust-inp-box" ).blur(function() {
	if($(this).val()==""){
		$(this).parent().removeClass('added-placeholder');
	} 
});
$("#sign-in").validate({
	rules:{
		firstName:{
			required:true,
		},
		lastName:{
				required:true,
		},
		emailId:{
				required:true,
				email:true
		},
		mobile:{
				required:true,
				number:true,
				maxlength: 10,
				minlength:10
		},
		password:{
				required:true,
		},
		confirmPassword:{
				required:true,
				equalTo: "#password"
		},
		companyName:{
				required:true,
		},
		address:{
				required:true,
		},
		state:{
				required:true,
		},
		city:{
				required:true,
		},
		pincode:{
				required:true,
				number:true,
				maxlength: 6,
				minlength:6
		},
	}
});

    </script>
</html>
