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

		<title>Visitors</title>
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
									<li><a class="whiteTxtColor actvbgk  nav-padding" href="<c:url value="/visitors" />">Visitors</a></li>
									<li><a class="greyTxtColor nav-padding"
										href="<c:url value="/history" />">Passes</a></li>
									<li><a class=" greyTxtColor nav-padding" href="<c:url value="/profile" />">Account</a></li>			
								</ul>
							</nav>
							<div class="heading-text pull-left">
								<h3 style="margin:0">Visitors Management</h3>
							</div>
						</div>
					</div>
				</div>
				<section id="usrPassMng" class="m-b m-t">
					
					<div class="upmTable">
						<div class="table-responsive">
							<table id="userPass" class="table table-striped-custom-bg table-striped">
								<thead class="thead-bg whiteTxtColor">
           							<tr role="row">
           							    <th style="width: 10%;"></th>
               							<th style="width: 10%;">Visitor Name</th>
               							<!-- <th style="width: 10%;">Company</th> -->
               							<th style="width: 15%;">Host Name</th>               							
               							<th style="width: 5%;">Mobile</th>
               							<th style="width: 10%;">Email</th>
               							<th style="width: 5%;">Entry</th>
               							<th style="width: 5%;">Exit</th>
               							<th style="width: 10%;">Vehicle</th>               							
               							<th style="width: 10%;">Equipment</th>
               							<th style="width: 10%;">#</th>
           							</tr>
         						</thead>
         						<tbody>
         							<c:forEach items="${passList}" var="pass">
         							<tr class="odd" role="row">
         								<td><span class="user_img"><img alt="Photo" src="<c:url value="/resources/theme/img/User.png" />"> </span></td>
                                        <td><span>${pass.visitorFirstName} </span><span>${pass.visitorLastName}</span></br><span>${pass.companyName}</span></td>
                                       <%--  <td><span>${pass.companyName}</span></td> --%>
                                        <td><span>${pass.hostFirstName} </span><span>${pass.hostLastName} </span></br>
                                        	<span>${pass.hostEmail} </span></br>
                                        	<span>${pass.hostMobile} </span>
                                        </td>
                                        <td><span>${pass.visitorMobileNo}</span></td>
                                        <td><span>${pass.visitorEmailId}</span></td>
                                        <td><span>${pass.visitorEntryTime}</span></td>
                                        <td><span>${pass.visitorExitTime}</span></td>
                                        <td>${pass.visitorVechilesDetails}</td>
                                        <td>${pass.visitorEquipmentDetails}</td>
                                        <td><%-- <a href="./history/${pass.passId}">Details</a> --%>
                                       <a href="./history/${pass.passId}" ><button class="btn btn-warning btn-xs whiteTxtColor">Details</button></a>
                                        </td>                                                                               	                                                                     
     								</tr>
     							 </c:forEach>     								
         						</tbody>
							</table>
						</div>
					</div>
				</section>
			</div>

			

        
			<script type="text/javascript">
        	$(document).ready(function() {
			    $('#userPass').DataTable( {
			    	"bSort": false
			    });
			    $('#adduser_btn').click(function(){
			    $('#addUser').modal('show');
			    });
     
		} );
        	 var texts = $("td").map(function() {
                 if($(this).text()=="Active"){
                         var green = $(this).addClass( "user-active" );                                         
                         return $(this).text();
                 }else{
                         var green = $(this).removeClass( "user-active" );
                 }
                 if($(this).text()=="In Active"){
                         var red = $(this).addClass( "user-inactive" );                                         
                         return $(this).text();
                 }else{
                         $(this).removeClass("user-inactive");
                 }
           // return $(this).text();
        });
        </script>
		
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
