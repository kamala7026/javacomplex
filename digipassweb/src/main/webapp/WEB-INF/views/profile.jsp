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
<meta charset="utf-8">

<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Account</title>
<meta name="description" content="">
<meta name="author" content="Adeptpros">
<meta name="viewport" content="width=device-width; initial-scale=1.0">

		<!-- Cascading Style Sheets -->
		<link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/dashboard.css" />" rel="stylesheet"/>
		<link href="http://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/animate.css" />" rel="stylesheet"/>
		
		<!-- Javascript files -->
		<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
		<script type="text/javascript" src="http://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
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
							<li><a class="greyTxtColor nav-padding"
								href="<c:url value="/dashboard" />">Dashboard</a></li>
							<li><a class="greyTxtColor nav-padding " href="<c:url value="/user" />">Hosts</a></li>
							<li><a class="greyTxtColor nav-padding" href="<c:url value="/visitors" />">Visitors</a></li>
							<li><a class="greyTxtColor nav-padding"
								href="<c:url value="/history" />">Passes</a></li>
							<li><a class="whiteTxtColor actvbgk nav-padding" href="<c:url value="/profile" />">Account</a></li>
						</ul>
					</nav>
					<div class="heading-text pull-left">
						<h3 style="margin: 0">Account</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="m-b m-t wfx">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="society-image">
						<img class="img-responsive" src="<c:url value="/resources/theme/img/prestige_img.png" />" style="width: 100%"/>
						
					</div>
				</div>
			</div>
		</div>
		<section id="profile-details" class="wfx">
			<div class="profile-map">
				<div class="col-lg-12 col-md-12">
					<div class="row">
						<div class="col-lg-6 col-md--6" style="padding: 0">
							<div class="titlename" >
										<span class="titleText"><strong>Title</strong> <span></span></span>
										<p>${estate.estateTitle}</p>
										<!-- <p>The Prestige shantiniketan - Residential Community</p> -->
									</div>
									<div class="address" >
										<span class="titleText"><strong>Address</strong> <span></span></span>
										<p>${estate.estateAddress},${estate.estateCity},${estate.estateDistrict},${estate.estateState},${estate.estateCountry},${estate.estatePincode}</p>
									</div>
									<div class="accountManager" >
										<span class="titleText"><strong>Account Manager</strong> <span></span></span>
										<p>Residents welfare community</p>
									</div>
									<div class="accountAdmin" >
										<span class="titleText"><strong>Account Admin</strong> <span></span></span>
										<p>${estate.accountManager}</p>
									</div>
									<!-- <div class="UnitDetail" >
										<span class="titleText"><strong>Account Admin</strong> <span></span></span>
										<table class="table" style="width:50%;margin-bottom:0">
											<tbody class="margin-0">
												<tr>
													<td>3bhk</td>
													<td>2Bhk</td>
													<td>Villa</td>
												</tr>
												<tr>
													<td>80</td>
													<td>100</td>
													<td>2</td>
												</tr>
											</tbody>
										</table>
									</div> -->
									<div class="points" >
										<table class="table" style="width:50%">
											<thead class="margin-0">
												<tr>
													<th>Entry Points</th>
													<th>Exit Points</th>
												</tr>
											</thead>
											<tbody class="margin-0">
												<tr>
													<td>${estate.entryPoints}</td>
													<td>${estate.existPoints}</td>
												</tr>
											</tbody>
										</table>
									</div>

						</div>
						<div class="col-md--6 col-lg-6">
							<img class="img-responsive" src="<c:url value="/resources/theme/img/map.png" />" />
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

</body>
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
