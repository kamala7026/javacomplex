<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%String name=(String)session.getAttribute("name");%>
<html lang="en">
<head>
<meta charset="utf-8">

<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Profile</title>
<meta name="description" content="">
<meta name="author" content="Adeptpros">
<meta name="viewport" content="width=device-width; initial-scale=1.0">

<!-- Cascading Style Sheets -->
<link href="<c:url value="/resources/theme/css/master.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/dashboard.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/style.css" />"
	rel="stylesheet" />

<!-- Javascript files -->
<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
<script src="<c:url value="/resources/theme/js/location.js" />"></script>


</head>
<style>
.form-control-custom {
	color: #555;
	display: block;
	font-size: 14px;
	height: 34px;
	line-height: 1.42857;
	padding: 6px 12px;
	transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s
		ease-in-out 0s;
	width: 100%;
}

</style>
<body>
	<%String status=null; %>
	<%String msg=null; %>
	<c:if test="${!empty status}">
		<%status=(String)request.getAttribute("status");%>
		<%msg=(String)request.getAttribute("msg");%>
	</c:if>
	<header>
	<div class="container">
		<div class="logo-div pull-left">
			<img src="<c:url value="/resources/theme/img/digipass_logo.png" />"
				alt="DigipassLOGO" />
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right m-n hidden-xs nav-user user">
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">
						<div class="avtarImg pull-right">
							<div class="user-name pull-left">

								<span class="name"><%=name %></span><br /> <span
									class="company-name">${company}</span>
							</div>
							<div class="avtar-img pull-right">
								<img
									src="<c:url value="/resources/theme/img/profile_img.png" />"
									alt="avatarImg" />
							</div>
						</div>
				</a>
					<ul class="dropdown-menu animated fadeInRight">
						<li><a href="<c:url value="/admin_profile" />"><i
								class="fa fa-user"></i> Profile</a></li>
						<li><a href="<c:url value="/change_password" />"><i
								class="fa fa-key"></i> Change Password</a></li>
						<li><a href="<c:url value='/logout'/>"><i
								class="fa fa-sign-out"></i> Logout</a></li>
					</ul></li>
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
								<li><a class="greyTxtColor nav-padding"
									href="<c:url value="/dashboard" />">Dashboard</a></li>
								<li><a class="greyTxtColor nav-padding "
									href="<c:url value="/user" />">Hosts</a></li>
								<li><a class="greyTxtColor nav-padding"
									href="<c:url value="/visitors" />">Visitors</a></li>
								<li><a class="greyTxtColor nav-padding"
									href="<c:url value="/history" />">Passes</a></li>
								<li><a class="greyTxtColor nav-padding"
									href="<c:url value="/profile" />">Account</a></li>

							</c:otherwise>
						</c:choose>
					</ul>
					</nav>
					<div class="heading-text pull-left">
						<h3 style="margin: 0">Profile</h3>
					</div>
				</div>
			</div>
		</div>
		<c:url value="/admin_profile" var="adminprofile" />
		<form:form id="adminProfileform" action="${adminprofile }"
			autocomplete="off" commandName="adminUser" method="post" role="form"
			novalidate="novalidate">

			<div class="row" style="margin-top:40px; margin-left:40px;">
				<div class="col-md-3">
					<section class="panel">
					<div class="panel-body" align="center">

						<img class="form-group"
							src="<c:url value="/resources/theme/img/usericon.png" /> "
							alt="avatarImg" style="width: 67%;" />

						<div class="form-group text-center">
							<label>${adminUser.firstName}
								${adminUser.lastName}</label>

						</div>
					</div>
					</section>
				</div>
				<div class="col-md-6" >
					<div>
						<section class="panel">
						<div class="panel-body">
							
							<div class="col-md-12">
								<div class="wfx form-group label1">							
									<div class="col-md-6">
										<label>Email ID</label>
									</div>
									<div class="col-md-6">
										<span> ${adminUser.emailId}</span>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>Mobile</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.mobile}</span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>Company</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.companyName} </span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>Address</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.address}</span></br>
										<span>${adminUser.addressLine2}</span>
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>State</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.state}</span>
									</div>
								</div>

							</div>
							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>City</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.city}</span>
									</div>
								</div>
							</div>


						
							<div class="col-md-12">
								<div class="wfx form-group label1">
									<div class="col-md-6">
										<label>Pin Code</label>
									</div>
									<div class="col-md-6">
										<span>${adminUser.pincode}</span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="wfx form-group label1" style="margin-top:40px;">
									<div class="col-md-6">
									<button style="" class="btn btn-md btn-warning pull-right"
										name="signinbutton" type="submit" onClick="return editAdmin()">
										Edit Profile</button>
									</div>
								</div>
							</div>
						<%-- edit code --%>
						
						
						 <input type="hidden" name="adminUserId"
							value="${adminUser.adminUserId}">
						<div class="form-group input">
							<div class="col-md-6">
									<label>First Name</label>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" class="form-control" name="firstName"
										placeholder="First Name" id="firstName"
										value="${adminUser.firstName}">
								</div>
							</div>						 
						</div>
						<div class="form-group input">
							<div class="col-md-6">
									<label>Last Name</label>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text"
									value="${adminUser.lastName}" id="lastname" name="lastName"
									placeholder="Last Name" class="form-control ">
								</div>
							</div>	
						</div>
						<div class="form-group input">
							<div class="col-md-6">
									<label>Email ID</label>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" value="${adminUser.emailId}" id="email"
										name="emailId" class="form-control input"
										placeholder="Email ID">
								</div>
							</div>
							
						</div>
						<div class="form-group input">
							<div class="col-md-6">
									<label>Mobile Number</label>
							</div>
							<div class="col-md-6">
							  <div class="form-group">
									<input type="text" value="${adminUser.mobile}" id="mobile"
										name="mobile" class="form-control input"
										placeholder="Mobile Number">
							 </div>
							</div>
						</div>

						<div class="form-group input">
							<div class="col-md-6">
									<label>Company Name</label>
							</div>
							<div class="col-md-6">
							  <div class="form-group">
									<input type="text" value="${adminUser.companyName}"
									id="companyName" name="companyName" class="form-control input"
									placeholder="Company Name">
							  </div>
							</div>
						</div>
					

						<div class="form-group input">
							<div class="col-md-6">
									<label>Address</label>
							</div>
							<div class="col-md-6">
							      <div class="form-group">
									<input type="text" value="${adminUser.address}" id="address"
										name="address" class="form-control input form-group"
										placeholder="Address Line-1">
								    </div>
								    <div class="form-group">
										<input style="margin-top: 2px;" type="text" value="${adminUser.addressLine2}"
											id="addressLine2" name="addressLine2"
											class="form-control input" placeholder="Address Line-2">
									</div>
								</div>
						</div>
						<div class="form-group input">
						 	<div class="col-md-6">
									<label>State</label>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" value="${adminUser.state}" id="state"
									name="state" class="form-control input" placeholder="State">
								</div>
							</div>
						</div>
						<div class="form-group input">
						    <div class="col-md-6">
									<label>City</label>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<input type="text" value="${adminUser.city}" id="city"
									name="city" class="form-control input" placeholder="City">
								</div>
							</div>
						</div>
						<div class="form-group input">
							 <div class="col-md-6">
									<label>Pin Code</label>
							</div>
							<div class="col-md-6">
							    <div class="form-group">
									<input type="text" value="${adminUser.pincode}" id="pincode"
										name="pincode" class="form-control input"
										placeholder="Pin Code">
							    </div>
							</div>
						</div>

					</div>
					</section>
				</div>
				<div class="col-md-12 input">
					<div class="col-md-12">
						<div class="btns pull-right">							
							<button style="" class="btn btn-md btn-default"
							name="signinbutton" type="button" onclick="return cancelAdmin()">Cancel</button>
							<button style="" class="btn btn-md btn-warning"
							name="signinbutton" type="submit">Update</button>
						</div>
					</div>
				</div>
				 <!--<div class="col-md-12 input">
					<div class="col-md-12">
					<div class="col-md-6 form-group pull-right">
						<button style="" class="btn btn-md btn-warning"
							name="signinbutton" type="submit">Update</button>
					</div>
					<div class="col-md-6 form-group pull-right">
						<button style="" class="btn btn-md btn-default"
							name="signinbutton" type="button" onclick="return cancelAdmin()">Cancel</button>
					</div>
					</div>
				</div>-->





			</div>
	</div>
	<!-- <div class="row input" style="margin: 0px;">
				<div class="col-md-6">
					
				</div>
				<div class="col-md-4">
				
				<div class="col-md-8" style="float: right;">						
							<div class="col-md-6 col-sm-6 col-xs-6 form-group"
								style="text-align: right;">
								<button style=""
										class="btn btn-lg btn-default" name="signinbutton"
										type="button" onclick="return cancelAdmin()">Cancel</button>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6 form-group"
								style="text-align: le">
								<button style="" class="btn btn-lg btn-warning"
									name="signinbutton" type="submit">Update</button>
							</div>
						
					</div>
				</div>

			</div> -->
	</form:form>
	</div>

</body>
<script src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
<script type="text/javascript">
		$(document).ready(function() {

			// validate signup form on keyup and submit
			var adminProfileform = $("#adminProfileform").validate({
				rules : {
					firstName : {
						required : true
					},
					lastName : {
						required : true
					},
					emailId : {
						required : true,
						email:true
					},
					mobile : {
						required : true,
						number:true,
						maxlength: 10,
						minlength:10
					},
					companyName : {
						required : true
					},
					address : {
						required : true
					},
					state : {
						required : true
					},
					city : {
						required : true
					}
				},
				messages : {
					emailId : {
						
						email:"Please enter valid email Id."
					},
					mobile : {
						
						number:"Please enter valid mobile number.",
						maxlength: "Please enter valid mobile number.",
						minlength:"Please enter valid mobile number."
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
function editAdmin(){
	$(".input").show();
	$(".label1").hide();
	return false;
}
function cancelAdmin(){
	$("form")[0].reset();
	$(".input").hide();
	$(".label1").show();
}
$(document).ready(function(){
	$(".input").hide();	
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
		$(".input").show();
		$(".label1").hide();
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
</script>
</html>
