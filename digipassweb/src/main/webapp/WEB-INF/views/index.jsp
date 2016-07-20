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
        <link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet"> <!-- all stylesheets -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
        
        <!--Javascript files-->        
        <script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
		
        <title>Digipass</title>
       
    </head>
    <body>
    
    	
      <p class="top-strap"></p>
      
      <div class="container">
	      <div class="middle-section">
	      	<div class="row">
	      		<div class="col-md-6 col-lg-6 col-sm-6">
	      			<div class="login-right-section">
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
	      		<div class="col-md-1 col-lg-1 col-sm-1">
	      			<div class="border-img" align="center">
	      				<img src="<c:url value="/resources/theme/img/line.png" />" />
	      			</div>
	      		</div>
	      		<div class="col-md-4 col-lg-4 col-sm-4" >
	      			<div>
		      			<div class="digi-logo" align="center">
		      				<img class="img-responsive" src="<c:url value="/resources/theme/img/logo.png" />" />
		      			</div>
		      			<div class="sign-in-section" id="loginblock">
		      				<div class="col-left-margin">
                       			<c:url var="loginAction" value="/userAunth" ></c:url>
								<form:form autocomplete="off" action="${loginAction}" commandName="login" id="sign-in" novalidate="novalidate">
				  					 <div class="form-group">
				  					 	<form:input path="userName"  placeholder="Email ID" id="emailid" cssClass="form-control bgk-img"/>
			    						<!-- <input type="email" value="" id="name" name="name" class="form-control bgk-img" placeholder="Email"> -->
			  						</div>
				  					<div class="form-group">
				  						<form:password path="password" placeholder="Password" id="password" cssClass="form-control bgk-img"/>
			    						<!-- <input type="password" value="" id="word" name="word" class="form-control bgk-img" placeholder="password"> -->
			  						</div>
			  						<div class="checkbox">
									    <label>
									      <input type="checkbox" value="1" name="remember_me" id="remember_me"><span class="form-color robotoLight color-gray">Remember Me</span>
									    </label>
									    <a class="form-color robotoLight color-orange" style="float: right" href="#" id="movetoforget">Forgot Password</a>
									</div>
									 	<c:if test="${!empty status}">
											<%String s=(String)request.getAttribute("status");
											if(s.equals("INVALID")){
												%>
												<div class="form-group ">
													<div class="col-xs-12">
													<p class="text-danger">Invalid user name/password</p>
													</div>
												</div>
												<%
											}else{
												%>
												<div class="form-group ">
													<div class="col-xs-12">
													<p class="text-danger">${status}</p>
													</div>
												</div>
												<%
											}
											%>
										</c:if>
									<div class="terms color-gray">
										<span>By creating an account, You are agreeing to our
											<a href="#" class="color-orange">Terms of Service</a> and <a href="#" class="color-orange">Privacy Policy</a>
										</span>
									</div>
				 				 	<button style="width:100%;" class="btn btn-gray" id="loginbtn" name="signin" type="submit">Login</button>
				 				 	<p style="padding-top:10px;">Don't have an account? <a href="<c:url value="/signup"/>" class="color-orange">Create account</a></p>
								</form:form>
							</div>
		      			</div>
	      
		      			
		      			<div class="sign-in-section" id="forgetblock" style="display: none;">
		      				<div class="col-left-margin">
                       			
								<c:url var="forgetpassword" value="/forgetpassword" ></c:url>
								<form:form autocomplete="off" action="${forgetpassword}" commandName="login" id="forgetpasswordForm" novalidate="novalidate">
				  					 <div class="form-group">
				  					 	<input type="text" value="" placeholder="Email ID" class="form-control bgk-img" name="userName" id="emailid1">
			    						<!-- <input type="email" value="" id="name" name="name" class="form-control bgk-img" placeholder="Email"> -->
			  						</div>
				  					
			  						<div class="checkbox">									    
									    <span>Already have an account ?</span> <a href="#" class="form-color robotoLight color-orange" id="movetologin">    Login</a>
									</div>
									  <div class="form-group">
				                      	<c:if test="${!empty success}">
				                      		<div class="col-xs-12">
												<p class="text-success">${msg}</p>
											</div>
				                      	</c:if>
				                      	<c:if test="${!empty error}">
				                      		<div class="col-xs-12">
												<p class="text-danger">${msg}</p>
											</div>
				                      	</c:if>
				                      </div>
				 				 	<button type="submit" name="signin" class="btn btn-gray" style="width:100%;">Change Password</button>
				 				 	
								</form:form>
							</div>
		      			</div>
	      			</div>
	      		</div>
	      	</div>
	      </div>
      </div>
    </body>
    <script src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
    <script type="text/javascript">
    var	forgetpasswordForm;
    var	signForm;
	$(document).ready(function() {
		forgetpasswordForm=$("#forgetpasswordForm").validate({
			rules: {
				userName: {
					required: true,
					email: true
				}				
			},
			messages: {
				userName:{
					required:"This field is required.",
					email:"Enter valid Email Address"
				}
			}
			
			
		});
		
		signForm=$("#sign-in").validate({
			rules: {
				userName: {
					required: true,
					email: true
				},
				password: {
					required: true,					
				}	
			},
			messages: {
				userName:{
					required:"This field is required.",
					email:"Enter valid Email Address"
				},
				userName:{
					required:"This field is required.",
				}
			}
			
			
		});
	});
    $(document).ready(function(){

    	$("#movetologin").click(function(){
    		$("#forgetblock").slideUp("slow");
    		$("#loginblock").slideDown("slow");
    		signForm.resetForm();
    		
    	});
    	$("#movetoforget").click(function(){
    		$("#loginblock").slideUp("slow");
    		$("#forgetblock").slideDown("slow");
    		forgetpasswordForm.resetForm();
    	});
    	
    	var form='${form}';
    	if(form=="forget"){
    		$("#loginblock").css("display","none");
    		$("#forgetblock").css("display","block");
    	}
    	
    });
    
   
    $(function() {

        if (localStorage.chkbx && localStorage.chkbx != '') {
            $('#remember_me').attr('checked', 'checked');
            $('#emailid').val(localStorage.usrname);
            $('#password').val(localStorage.pass);
        } else {
            $('#remember_me').removeAttr('checked');
            $('#emailid').val('');
            $('#password').val('');
        }

        $('#loginbtn').click(function() {

            if ($('#remember_me').is(':checked')) {
                // save username and password
                
                localStorage.usrname = $('#emailid').val();
                localStorage.pass = $('#password').val();
                localStorage.chkbx = $('#remember_me').val();
            } else {
                localStorage.usrname = '';
                localStorage.pass = '';
                localStorage.chkbx = '';
            }
        });
    });
    
</script>
    </script>
</html>
