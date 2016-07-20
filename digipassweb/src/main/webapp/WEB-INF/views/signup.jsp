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
		<script src="<c:url value="/resources/theme/js/location.js" />"></script>
		
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
				max-width: 1075px;
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
        <style>
			.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control {
			    background-color: #DDDDDD;
			    opacity: 0;
			}
			.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control {
			    background-color: #DDDDDD;
			    opacity: 1;
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
		      			
		      			<div class="sign-up-section col-left-margin clearfix">
		      				<div class="col-left-margin col-left-margin clearfix">
                       			<c:url var="signupAction" value="/signup" ></c:url>
								
								<form:form autocomplete="off"  id="sign-in" method="post" action="${signupAction}" commandName="adminUser">
				  					 <div class="col-md-6 col-sm-6 col-xs-6 form-group parent-div">
				  					 	<label for="firstname" class="mylabel">First Name</label>
			    						<input type="text" value="" id="firstname" name="firstName" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-6 col-sm-6 col-xs-6 form-group parent-div">
				  					 	<label for="lastname" class="mylabel">Last Name</label>
			    						<input type="text" value="" id="lastname" name="lastName" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="email" class="mylabel">Email ID</label>
			    						<input type="email" value="" id="email" name="emailId" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="mobile" class="mylabel">Mobile Number</label>
			    						<input type="text" value="" id="mobile" name="mobile" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="password" class="mylabel">Password</label>
			    						<input type="password" value="" id="password" name="password" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="confirm_password" class="mylabel">Confirm Password</label>
			    						<input type="password" value="" id="confirm_password" name="confirmPassword" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="company_name" class="mylabel">Company Name</label>
			    						<input type="text" value="" id="company_name" name="companyName" class="form-control cust-inp-box">
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div">
				  					 	<label for="address" class="mylabel">Address</label>
				  					 	<input type="text" id="address" name="address" class="form-control cust-inp-box" rows="1" onfocus="this.removeAttribute('readonly');" readonly/>
				  					 	<input type="text" id="address" name="addressLine2" class="form-control cust-inp-box" rows="1" onfocus="this.removeAttribute('readonly');" readonly/>
			  						</div>
			  						<div class="col-md-12 col-sm-12 col-xs-12 form-group parent-div" >
				  					 	<label for="state" class="mylabel">State</label>
				  					 	<select name="state1" class="states form-control cust-inp-box" id="stateId" onfocus="this.removeAttribute('readonly');" readonly>
										     <option value=""></option>
										</select>
			    						<input type="hidden" value="" id="state" name="state">
			  						</div>
			  						<div class="col-md-6 col-sm-6 col-xs-6 form-group parent-div">
				  					 	<label for="city" class="mylabel">City</label>
				  					 	<select name="city1" class="form-control cust-inp-box cities" id="cityId" onfocus="this.removeAttribute('readonly');" readonly>
										   <option value=""></option>
										</select>
			    						<input type="hidden" value="" id="city" name="city">
			  						</div>
			  						<div class="col-md-6 col-sm-6 col-xs-6 form-group parent-div">
				  					 	<label for="pincode" class="mylabel">Pin Code</label>
			    						<input type="text" value="" id="pincode" name="pincode" class="form-control cust-inp-box" onfocus="this.removeAttribute('readonly');" readonly>
			  						</div>
			  						<div class="col-md-6 col-sm-6 col-xs-6 form-group" style="text-align: right;">
			  							<a href="<c:url value="/"/>"><button style="" class="btn btn-submit" name="signinbutton" type="button">Cancel</button></a>
			  						</div>
			  						<div class="col-md-6 col-sm-6 col-xs-6 form-group" style="text-align: le">
			  							<button style="" class="btn btn-submit" name="signinbutton" type="submit">Sign up</button>
			  						</div>
				 				 	
				 				 	
								</form:form>
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
		state1:{
				required:true,
		},
		city1:{
				required:true,
		}
	},
	messages: {
		firstName:{
			required:"This field is required.",
		},
		lastName:{
				required:"This field is required.",
		},
		emailId:{
				required:"This field is required.",
				email:"Please enter valid Email ID."
		},
		mobile:{
				required:"This field is required.",
				number:"Please enter valid mobile number.",
				maxlength: "Please enter valid mobile number.",
				minlength:"Please enter valid mobile number."
		},
		password:{
				required:"This field is required.",
		},
		confirmPassword:{
				required:"This field is required.",
				equalTo: "Password mismatch."
		},
		companyName:{
				required:"This field is required.",
		},
		address:{
				required:"This field is required.",
		},
		state1:{
				required:"This field is required.",
		},
		city1:{
				required:"This field is required.",
		}
	}
});
$(document).ready(function(){
	<%if(status!=null){
		if(status.equals("SUCCESS")){
			%>
			$.notify({
				// options
				message:'<%=msg%>'
			},{
				// settings
				type: 'success'
			});
		<%
		}else{
		%>
		$.notify({
			// options
			message:'<%=msg%>'
		},{
			// settings
			type: 'danger'
		});
		<%
	}}%>
});
    </script>
</html>
