<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%String name=(String)session.getAttribute("name");%>
<html lang="en">
	<head>
		<meta charset="utf-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>userDetails</title>
		<meta name="description" content="">
		<meta name="author" content="Adeptpros">
		<meta name="viewport" content="width=device-width; initial-scale=1.0">
		
		<!-- Cascading Style Sheets -->
		<link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/dashboard.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet"/>
		
		<!-- Javascript files -->
		<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
		

	</head>

	<body>
		
			<header>
				<div class="container">
					<div class="logo-div pull-left">
						<img src="<c:url value="/resources/theme/img/digipass_logo.png" />" alt="DigipassLOGO"/>
					</div>
					 <div>    
		                 <ul class="nav navbar-nav navbar-right m-n hidden-xs nav-user user">
				            <li class="dropdown">
				               <a data-toggle="dropdown" class="dropdown-toggle" href="#">
				                       <div class="avtarImg pull-right">
				                             <div class="user-name pull-left">
				                                     
				                                     <span class="name"><%=name %></span><br />
				                                     <span class="company-name">${company}</span>
				                             </div>
				                             <div class="avtar-img pull-right">
				                                     <img src="<c:url value="/resources/theme/img/profile_img.png" />" alt="avatarImg" />
				                             </div>
				                     </div>
				               </a>
				               <ul class="dropdown-menu animated fadeInRight">
				               	 <li><a href="<c:url value="/admin_profile" />"><i class="fa fa-user"></i> Profile</a></li>
				                 <li><a href="<c:url value="/change_password" />"><i class="fa fa-key"></i> Change Password</a></li>                                     
				                 <li><a href="<c:url value='/logout'/>"><i class="fa fa-sign-out"></i> Logout</a></li>
				               </ul>
				             </li>
				           </ul>     
				     </div>
				</div>
			</header>
			
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="top-header">
							<nav class="nav-container">
								<ul class="menu">
							     <c:choose>
								    <c:when test="${roleid==1}">
								    </c:when>
								    <c:otherwise>								    
										<li><a class="greyTxtColor nav-padding" href="<c:url value="/dashboard" />">Dashboard</a></li>
										<li><a class="greyTxtColor nav-padding " href="<c:url value="/user" />">Hosts</a></li>
										<li><a class="greyTxtColor nav-padding" href="<c:url value="/visitors" />">Visitors</a></li>
										<li><a class="greyTxtColor nav-padding" href="<c:url value="/history" />">Passes</a></li>
										<li><a class="greyTxtColor nav-padding" href="<c:url value="/profile" />">Account</a></li>				
									
								    </c:otherwise>
								 </c:choose>
								</ul>
							</nav>
							<div class="heading-text pull-left">
								<h3 style="margin:0">Change password</h3>
							</div>
						</div>
					</div>
				</div>
				
					<div class="row" style=" margin-left: 35%;">
						<div class="aside-xl">
							<div class="inner-width">
								<span><i class="fa fa-lock"></i></span>
								<div class="row">
									<div class="col-md-12">
										<section class="panel">
											<div class="panel-body">
												<c:url value="/changePassword" var="changePasswordform"/>
												<form:form id="changePassword" action="${changePasswordform }" autocomplete="off" commandName="changePassword" method="post"  role="form" novalidate="novalidate">
													 <div class="form-group">
								                          <label style="font-family: Open Sans,Helvetica Neue,Helvetica,Arial,sans-serif;">New password</label>
								                          <input type="password" class="form-control" name="newPassword" placeholder="New password" id="newPassword">
								                     </div>
								                      <div class="form-group">
								                          <label style="font-family: Open Sans,Helvetica Neue,Helvetica,Arial,sans-serif;">Confirm new password</label>
								                          <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm new password" id="confirmPassword">
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
								                      <div class="col-md-6 col-sm-6 col-xs-6 form-group" style="text-align: right;">
								  							<a href="<c:url value="/dashboard"/>"><button style="" class="btn btn-lg btn-default" name="signinbutton" type="button">Cancel</button></a>
								  						</div>
								  						<div class="col-md-6 col-sm-6 col-xs-6 form-group" style="text-align: le">
								  							<button style="" class="btn btn-lg btn-warning" name="signinbutton" type="submit">Submit</button>
								  						</div>
								                     <!--  <button name="submitbtn" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
								                      <button name="submitbtn" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button> -->
												</form:form>
											</div>
										</section>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				
			</div>
		
	</body>
	<script src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
	<script type="text/javascript">
	$(document).ready(function() {

		// validate signup form on keyup and submit
	var	editHostFormReset=$("#changePassword").validate({
			rules: {
				newPassword: {
					required: true,
					minlength: 6
				},
				confirmPassword: {
					required: true,
					minlength: 6,
					equalTo: "#newPassword"
				}
			},
			messages: {
				newPassword:{
					required:"Enter new password",
					minlength:"Minmum length must be 6 character"
				},
				confirmPassword:{				
					required:"Enter confirm password",
					equalTo:"Password mismatch"
				}
			}
			
			
		});
	});
	</script>
	<script type="text/javascript">
$( ".menu li" ).delegate( "*", "focus", function() {
	$(".nav-padding").each(function() {
	    $(this).removeClass("whiteTxtColor actvbgk");
	    $(this).addClass("greyTxtColor nav-padding");
	});
  var elem = $( this );
  //$( ".menu li a" ).addClass( "greyTxtColor nav-padding");
  $(elem).addClass("whiteTxtColor actvbgk nav-padding");
 /*  setTimeout(function() {
    elem.toggleClass( "focused", elem.is( ":focus" ) );
  }, 0 ); */
});
</script>
</html>
