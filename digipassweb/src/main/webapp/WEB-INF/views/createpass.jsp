<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta charset="utf-8">

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<title>Pass</title>
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
<link href="<c:url value="/resources/theme/css/timepicki.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/bootstrap-datepicker.css" />"
	rel="stylesheet" />

<!-- Javascript files -->
<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/theme/js/timepicki.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap-datepicker.js" />"></script>
<script src="<c:url value="/resources/theme/js/json2.js"/>"></script>
<script src="<c:url value="/resources/theme/js/jquery.validate.js"/>"></script>		
 <style>
 label {
   
    font-weight: normal !important;
   
}
 </style>
	</head>

	<body>
		
			<header>
				<div class="container">
					<div class="logo-div pull-left">
						<img src="<c:url value="/resources/theme/img/digipass_logo.png" />" alt="DigipassLOGO"/>
					</div>
					<div>    
				  	  <!-- <ul class="nav navbar-nav navbar-right m-n nav-user user">hidden-xs
				       <li class="dropdown">
				          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
				          	<div class="avtarImg pull-right">
							<div class="user-name pull-left">
								<span>Welcome,</span><br />
								<span class="name">Mr Dendayal</span><br />
								<span class="company-name">Adeptpros Inc.</span>
							</div>
							<div class="avtar-img pull-right">
								<img src="img/profile_img.png" />
							</div>
						</div>
				          </a>
				          <ul class="dropdown-menu animated fadeInRight">
				            <li><a href="changePass.html"><i class="fa fa-key"></i> Change Password</a></li>			             
				            <li><a href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
				          </ul>
				        </li>
				      </ul>      -->
	      			</div>
				</div>
			</header>
			
			<div class="container">
				<div class="container aside-xl col-sm-12" style="width:100%;  padding-top: 20px;border-radius: 20px; border-top: 21px solid rgb(168, 168, 168);">
							<div class="inner-width">
								
								<div class="row">
									<c:choose>
    									<c:when test="${status=='SUCCESS'}">
    										<div class="alert alert-success fade in">
										   		 <a href="#" class="close" data-dismiss="alert">&times;</a>
										   		 Pass updated successfully. You can see your pass details by click on the pass link which has been sent to your Email ID.									    
											</div>
    									</c:when>
    									 <c:when test="${status=='ERROR'}">
									       <div class="alert alert-danger fade in">
										   		 <a href="#" class="close" data-dismiss="alert">&times;</a>	
										   		 Internal server problem. please try again later. 									    
											</div>
									     </c:when>
    								</c:choose>
								   <c:if test="${empty form}">
								   	 <div class="col-md-12">
										<section class="panel">
											<div class="panel-body">
											<c:url value="/passrequest" var="passrequest" />
											<form:form autocomplete="off"  method="post" action="${passrequest}"
												commandName="pass" id="passForm">
												
												   <div class="form-group clearfix row">
														<div class="col-sm-6">
														<h5 class="mar-tpno"> First Name</h5>
														<div>
															<input class="form-control" type="text" value="${passDetails.visitorFirstName}" placeholder="First Name" name="visitorFirstName">
														</div>
														</div>
														<div class="col-sm-6">
															<h5 class="mar-tpno">Last Name</h5>
															<div>
																<input class="form-control" type="text" value="${passDetails.visitorLastName}" placeholder="Last Name" name="visitorLastName">
															</div>
														</div>
													</div>
													 
													  <div class="form-group">
								                          <label >Company Name</label>
								                          <input type="text" class="form-control" name="companyName" placeholder="Company Name" value="${passDetails.companyName}">
								                      </div>
													  <div class="form-group clearfix row">
														<div class="col-sm-6">
														<h5 class="mar-tpno"> Email</h5>
														<div>
														<input class="form-control" type="text" name="visitorEmailId" placeholder="Email" value="${passDetails.visitorEmailId}">
														</div>
														</div>
														<div class="col-sm-6">
														<h5 class="mar-tpno">Mobile Number</h5>
														<div>
														<input class="form-control" type="text" name="visitorMobileNo" placeholder="Mobile number" value="${passDetails.visitorMobileNo}">
														</div>
														</div>
													</div>
													  <div class="form-group">
								                          <label >Address</label>
								                          <textarea  class="form-control"  placeholder="Address" name="visitorAddress">${passDetails.visitorAddress}</textarea>
								                      </div>
														<div class="form-group clearfix row">
															<div class="col-sm-6">
																<h5 class="mar-tpno"> Start Time</h5>
															<div>
																<input type="hidden" name="visitorStartTime" value="${passDetails.visitorStartTime}">
																<label class="form-control">${passDetails.visitorStartTime}</label>
															</div>
														</div>
														<div class="col-sm-6">
														<h5 class="mar-tpno">End Time</h5>
														<div>
														<input type="hidden" name="visitorEndTime" value="${passDetails.visitorEndTime}">
														<label class="form-control">${passDetails.visitorEndTime}</label>
														</div>
														</div>
													</div>
													<div class="form-group clearfix row">
														<div class="col-sm-6">
																<h5 class="mar-tpno">Visiting Purpose</h5>
															<div>
																 <select class="form-control"  name="visitorPurpose" id="visitingpurpose">
										                         	<option value=""> Select Visiting Purpose </option> 
																	<option value="Delivery"> Delivery </option>
																	<option value="Drop Off"> Drop Off </option>
																	<option value="Meeting"> Meeting </option>
																	<option value="Repair"> Repair </option>
																	<option value="Personal"> Personal </option>
																	<option value="Party"> Party </option>
																	<option value="Other"> Other </option>
										                         </select>
															</div>
														</div>
								                          <div class="col-sm-6">
																<h5 class="mar-tpno">Vehicle Information</h5>
															<div>
																 <input class="form-control" type="text" name="visitorVechilesDetails" placeholder="Vehicle Information" value="${passDetails.visitorVechilesDetails}">
															</div>
														</div>
								                        
								                      </div>
													  	
													   <div class="form-group clearfix row">
														<div class="col-sm-6">
															<h5 class="mar-tpno">Equipment Details</h5>
															<div>
																<input class="form-control" type="text" name="visitorEquipmentDetails" placeholder="Equipment Details" value="${passDetails.visitorEquipmentDetails}">
															</div>
														</div>
														<div class="col-sm-6">
															<h5 class="mar-tpno">Venue</h5>
															<div>
																<input class="form-control" type="text" name="visitorVanue" placeholder="Venue" value="${passDetails.visitorVanue}">
															</div>
														</div>
													</div>
													<div class="form-group">
								                          <label >Notes / Instruction</label>
								                          <textarea class="form-control" name="visitorInstruction" placeholder="Notes / Instruction">${passDetails.visitorInstruction}</textarea>
								                      </div>
													  <div class="form-group">
													  <input type="hidden" name="passId" value="${passDetails.passId}">
													  <button name="submitbtn" class="btn btn-primary btn-block pull-left mybtn_new" style="" type="submit">Update Pass</button>
													  <button name="submitbtn" class="btn btn-primary btn-block pull-left mybtn_new myBtn_new1" style="" type="button">Cancel</button>
												</div>
												</form:form>
											</div>
										</section>
									</div>
									</c:if>
								</div>
								
							</div>
						</div>
					
				
			</div>

		
	</body>
	<script type="text/javascript">
	$("#passForm").validate({
		  rules: {
			  visitorFirstName: "required",
			  visitorLastName: "required",
		      visitorMobileNo:{
		    	  	 required: true,
		       		 number: true,
		       		 minlength:10,
		       		 maxlength:10
		      },
		      visitorEmailId: {
		        	 required: true,
		       		 email: true
		    }
		  },
		  messages: {
			  visitorFirstName: "First Name is required",
			  visitorLastName: "Last Name is required",
		      companyName: "Last Name is required",
		      visitorEmailId: {
		     		required: "Email address id required",
		      		email: "Your email address must be in the format of name@domain.com"
		      },
		      visitorMobileNo:{
		    	  	 required: "Mobile number is required",
		       		 number:"Enter valid mobile number",
		       		 
		      }
		  }
		});
	$(document).ready(function(){
		$("#visitingpurpose").val('${passDetails.visitorPurpose}');
	});
	</script>
</html>
