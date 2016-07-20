<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%String name=(String)session.getAttribute("name");%>
<html>
<head>

<!-- Meta Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Dashboard</title>
		
		<!-- Cascading Style Sheets -->
		<link href="<c:url value="/resources/theme/css/bootstrap.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/dashboard.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/animate.css" />" rel="stylesheet"/>
		
		<!-- Javascript files -->
		<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
		<style type="text/css">
		[data-notify="progressbar"] {
	margin-bottom: 0px;
	position: absolute;
	bottom: 0px;
	left: 0px;
	width: 100%;
	height: 5px;
}
		</style>
</head>
<body>
<%String status=null; %>
<%String msg=null; %>
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
							<li><a class="whiteTxtColor actvbgk nav-padding" href="<c:url value="/dashboard"/>" tabindex="1" >Dashboard</a></li>
							<li><a class="greyTxtColor nav-padding " href="<c:url value="/user" />" tabindex="2">Hosts</a></li>
							<li><a class="greyTxtColor nav-padding" href="<c:url value="/visitors" />" tabindex="3">Visitors</a></li>
							<li><a class="greyTxtColor nav-padding" href="<c:url value="/history" />" tabindex="4">Passes</a></li>
							<li><a class="greyTxtColor nav-padding" href="<c:url value="/profile" />" tabindex="5">Account</a></li>
						</ul>
					</nav>
					<div class="heading-text pull-left">
						<h1 style="margin: 0">Dashboard</h1>
					</div>
				</div>
			</div>
		</div>

		<section id="payments" class="wfx">
			<div class="form-group">
                	<c:if test="${!empty success}">
                		<div class="col-xs-12">
                		<%status="SUCESS"; %>
                		<%msg=(String)request.getAttribute("msg"); %>
							<%-- <div 
							class="alert alert-success">${msg}</div> --%>
						</div>
                	</c:if>
                	<c:if test="${!empty error}">
					   <div class="col-xs-12">
					   <%status="ERROR"; %>
					   <%msg=(String)request.getAttribute("msg"); %>
							<%-- <div class="alert alert-danger">${msg}</p> --%>
						</div>
                	</c:if>
                </div>
			<div class="m-b m-t wfx">
				<div class="col-lg-12 col-md-12">
					<ul class="prising-list col-lg-12">
						<li class="col-lg-4 col-md-4">
							<div class="pricing-item text-center clearfix">
								<span
									class="pricing-item_title text-center  col-lg-12 col-md-12 col-sm-12 col-xs-12 blackTxtColor">Hosts
								</span> <span
									class="pricing-amount text-center orangeTxtColor col-lg-12 col-md-12 col-sm-12 col-xs-12 ">${dashboard.totalHost}</span>
							</div>
						</li>
						<li class="col-lg-4 col-md-4">
							<div class="pricing-item text-center clearfix"
								style="margin: 0 auto">
								<span
									class="pricing-item_title text-center  col-lg-12 col-md-12 col-sm-12 col-xs-12 blackTxtColor">Passes
								</span> <span
									class="pricing-amount text-center greenTxtColor col-lg-12 col-md-12 col-sm-12 col-xs-12 ">${dashboard.totalPass}</span>
							</div>
						</li>
						<li class="col-lg-4 col-md-4">
							<div class="pricing-item text-center clearfix pull-right">
								<span
									class="pricing-item_title text-center  col-lg-12 col-md-12 col-sm-12 col-xs-12 blackTxtColor">Visits
								</span> <span
									class="pricing-amount text-center blueTxtColor col-lg-12 col-md-12 col-sm-12 col-xs-12 ">${dashboard.totalVisited}</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</section>

		<!-- <section class="greeting wfx text-center">
			<span class="greeting-text text-center">Thank you for using <b>Digipass&#8482;</b></span>
		</section>
		<section class="wfx">
			<span class="">Invoice: #7760</span> <span class="pull-right">Date: 21/05/2016</span>
		</section>
		<div class="row">
			<div class="col-lg-12">
				<table class="table">
					<thead>
						<tr>
							<th>Total Charges</th>
							<th>825</th>
							<th>X</th>
							<th>3</th>
							<th><i class="fa fa-inr"></i> 2460.00</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Discounted</td>
							<td>525</td>
							<td>X</td>
							<td>3</td>
							<td><i class="fa fa-inr"></i> 2460.00</td>
						</tr>
						<tr>
							<td colspan="4" class="" style="text-align: right; font-weight: bold;">Order
								total</td>
							<td><i class="fa fa-inr"></i> 2460.00</td>
						</tr>
					</tbody>
				</table>
				<div class="paymrntMethod">
					<p>Payment method : Credit card payment</p>
				</div>
				<div class="summary">
					<div class="customerDetails pull-left">
						<h3>Customer details</h3>
						<span>Email: jamesCamern@gmail.com</span><br /> <span>Tel:
							9876543210</span>
					</div>
					<div class="BillingAdsress pull-right">
						<h3>Billing Address</h3>
						<span>Mr James Cameron</span><br /> <span>Apple</span><br /> <span>United
							States</span>
					</div>
				</div>
			</div>
		</div> -->
		<section class="wfx">
			<span class="greeting-text">Recent Hosts</span>
		</section>
		<div class="upmTable" style=" margin-top: 15px;">
				<div class="table-responsive">
					<table id="userList"
						class="table table-striped-custom-bg table-striped">
						<thead class="thead-bg whiteTxtColor">
							<tr role="row">								
								<th style="width: 5%">#</th>
								<th style="width: 15%">Host Name</th>
								<th style="width: 10%">Department</th>
								<th style="width: 10%">Designation</th>								
								<th style="width: 10%">Mobile</th>
								<th style="width: 20%">Email</th>							</tr>
						</thead>
						<tbody>
							<%int i=0; %>
							<c:forEach items="${hostUsersList}" var="hostUsers">
								<% i++;
								if(i==6){
									return;
								}
								%>
								
									<td><%=i%></td>
									<td><span>${hostUsers.firstName} </span>
									<span>${hostUsers.lastName}</span></td>
									<td><span>${hostUsers.department} </span></td>
									<td><span>${hostUsers.userType} </span></td>
									<td><span><!-- <i class="fa fa-phone"> </i>-->${hostUsers.phoneNo1}</span><br />
									<c:if test="${!empty  hostUsers.phoneNo2}">
											<span><!-- <i class="fa fa-phone"></i> -->
												${hostUsers.phoneNo2}</span></td>
									</c:if>
									<td><span>${hostUsers.email1}</span><br /> 
									     <c:if
											test="${!empty  hostUsers.email2}">
											<span>${hostUsers.email2}</span>
										</c:if>
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		
	</div>
	<!--Container ends-->


</body>
<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
<script type="text/javascript">
<%if(status!=null){%>
$.notify({
	// options
	message:'<%=msg%>',
	target: '_blank'
},{
	// settings
	type: 'success'
});
<%}%>
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