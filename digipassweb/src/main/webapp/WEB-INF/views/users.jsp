<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ page session="false" %> --%>
<%String name=(String)session.getAttribute("name");%>
<html>
<head>
<meta charset="utf-8">

<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Host Users</title>
<meta name="description" content="">
<meta name="author" content="Adeptpros">
<meta name="viewport" content="width=device-width; initial-scale=1.0">

<!-- Cascading Style Sheets -->
<link href="<c:url value="/resources/theme/css/master.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/dashboard.css" />"
	rel="stylesheet" />
<link
	href="http://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	type="text/css" rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/style.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/timepicki.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/bootstrap-datepicker.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/theme/css/animate.css" />" rel="stylesheet"/>

<!-- Javascript files -->
<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script src="<c:url value="/resources/theme/js/timepicki.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap-datepicker.js" />"></script>
<script src="<c:url value="/resources/theme/js/json2.js"/>"></script>
<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
<script src="<c:url value="/resources/theme/js/bootstrap-filestyle.js" />"></script>

</head>

<body>

	<header>
	<div class="container">
		<div class="logo-div pull-left">
			<img src="<c:url value="/resources/theme/img/digipass_logo.png" />"
				alt="DigipassLOGO" />
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
                 <li class="divider divider-custom"></li>                                    
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
						<li><a class="whiteTxtColor nav-padding actvbgk"
							href="<c:url value="/user" />">Hosts</a></li>
						<li><a class="greyTxtColor nav-padding"
							href="<c:url value="/visitors" />">Visitors</a></li>
						<li><a class="greyTxtColor nav-padding"
							href="<c:url value="/history" />">Passes</a></li>
						<li><a class="greyTxtColor nav-padding"
							href="<c:url value="/profile" />">Account</a></li>
					</ul>
					</nav>
					<div class="heading-text pull-left">
						<h3 style="margin: 0">Host Management</h3>
					</div>
				</div>
			</div>
		</div>
		<section id="usrPassMng"> 
		<c:url value="/access" var="access" /> 
		<form:form action="${access}" method="POST"
			commandName="hostUser" id="form_access">
			<form:hidden path="action" id="action_type" />
			<div class="m-b m-t wfx">
				<div class="pull-left">
					<div class="add-user pull-left">
						<button id="adduser_btn" class="btn cmn-btn digipass_btn"
							onclick="return false">
							<i class="fa fa-user-plus"></i> Add New Host
						</button>
					</div>
					<div class="add-user pull-left">
								<button id="uploadUsers" class="btn cmn-btn digipass_btn" onclick="return false"><i class="fa fa-upload"></i> Upload CSV</button>
					</div>
					<div class="add-user checkshow">
						<div class="pull-left">
							 <div class="dropdown">
                                   <button class="btn cmn-btn digipass_btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog"></i> Action <span class="caret"></span></button>
                                      <ul class="dropdown-menu animated fadeInRight " id="activation_link">
                                      
                                       
                                           <li><a href="#"  id="invite_access" onclick="return false;"><i class="fa fa-share" ></i> Invite</a></li>
	                                       <li class="divider divider-custom"></li>
	                                       <li ><a href="#" id="grant_access" onclick="return false;"><i class="fa fa-check"></i> Activate</a></li>
	                                       <li class="divider divider-custom"></li>
	                                       <li><a href="#" id="cancel_access" onclick="return false;"><i class="fa fa-times"></i> Deactivate</a></li>
	                                       <li class="divider divider-custom"></li> 
	                                       <li><a href="#" id="delete_access" onclick="return false;"><i class="fa fa-trash-o"></i> Disable</a></li>    
									      	
									    
                                                                                                               
                                     </ul>
                                     
                                 </div>
						</div>
					
					</div>
				</div>
			</div>
			
			<div class="upmTable">
				<div class="table-responsive">
					<table id="userList"
						class="table table-striped-custom-bg table-striped">
						<thead class="thead-bg whiteTxtColor">
							<tr role="row">
								<th style="width:3%" c><input type="checkbox" class="check-all check "
									id="checkboxall" name="checkboxall" /></th>
								<th style="width: 10%"></th>
								<th style="width: 10%">Host Name</th>
								<th style="width: 5%">Department</th>
								<th style="width: 5%">Designation</th>								
								<th style="width: 5%">Mobile</th>
								<th style="width: 7%">Email</th>
								<th style="width: 15%">Address</th>
								<th style="width: 5%">Created</th>
								<th style="width: 5%">Expires</th>								
								<th style="width: 5%">Status</th>
								<th style="width: 5%">Edit</th>

							</tr>
						</thead>
						<tbody>
							<%int i=0; %>
							<c:forEach items="${hostUsersList}" var="hostUsers">
								<% i++;%>
								<c:choose>
								    <c:when test="${hostUsers.activeStatus=='Activated'}">
								    	<tr class="odd" role="row" class="item" title="<p style='color:green;'>STATUS: <b>${hostUsers.activeStatus}</b></p>">
								    </c:when>
							      <c:otherwise>
							      	<tr class="odd" role="row" class="item" title="<p style='color:red;'>STATUS: <b>${hostUsers.activeStatus}</b></p>">
							      </c:otherwise>
								</c:choose>
								
									<td><form:checkbox cssClass="check"
											value="${hostUsers.hostUserId}" path="hostUserIdList" />
									<form:hidden path="activeStatus" id="${hostUsers.hostUserId}" value="${hostUsers.activeStatus}"/>		
									</td>
									<td><span class="user_img"><img alt="Photo" src="<c:url value="/resources/theme/img/User.png" />"> </span></td>
									<td><span>${hostUsers.firstName} </span>
									<span>${hostUsers.lastName}</span></td>
									<td><span>${hostUsers.department} </span></td>
									<td><span>${hostUsers.userType} </span></td>
									<td><span><!-- <i class="fa fa-phone"> </i>-->${hostUsers.phoneNo1}</span><br />
									<c:if test="${!empty  hostUsers.phoneNo2}">
											<span><!-- <i class="fa fa-phone"></i> -->
												${hostUsers.phoneNo2}</span></td>
									</c:if>
									<td><span>${hostUsers.email1}</span><br /> <c:if
											test="${!empty  hostUsers.email2}">
											<span>${hostUsers.email2}</span>
										</c:if></td>
									<td>
										<span>
										    ${hostUsers.addressLine1}
											<c:if test="${!empty  hostUsers.addressLine2}">
												, ${hostUsers.addressLine2}
											</c:if>										
											<c:if test="${!empty  hostUsers.city}">
											  , ${hostUsers.city}										
											</c:if>
											<c:if test="${!empty  hostUsers.state}">
													, ${hostUsers.state}
											</c:if>
											<c:if test="${!empty  hostUsers.pincode}">
												 	, ${hostUsers.pincode}
											</c:if>
										</span>
										
									</td>
									<td><span>${hostUsers.createdDate}</span></td>
									<td><span>${hostUsers.expiredDate}</span></td>
									<td>${hostUsers.activeStatus}</td>
									<td>
									<a class="btn btn-warning btn-xs whiteTxtColor" onclick="return editHostAjax('${hostUsers.hostUserId}')"><i class="glyphicon glyphicon-pencil"
										style="cursor: pointer;" ></i></a>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form:form> </section>
	</div>

	<!-- add user popup modal (21/1/16) -->

	<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog custom-modal-dialog">
			<c:url value="/user" var="newHost" />
			<form:form cssClass="form-horizontal" action="${newHost}"
				commandName="hostUser" method="POST" id="newHostForm">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">New Resident / Host
						</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body wfx">
						<div class="content-outer">

							<div class="form-fields">
							<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="firstName">First
											Name</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="firstName"
											cssClass="form-control cust-form-control" id="firstName"
											placeholder="First Name" />
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="lastname">Last Name</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="lastName"
											cssClass="form-control cust-form-control" id="lastName"
											placeholder="Last Name" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div
											class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
											<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label class="control-label" for="email1">Department</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="department"
													cssClass="form-control cust-form-control" id="department"
													placeholder="Department"/>
											</div>
										</div>
										</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="type">Designation</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="userType"
											cssClass="form-control cust-form-control" id="type"
											placeholder="Designation" />
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="uniqueid">Building Name/Number</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="buidingNo"
											cssClass="form-control cust-form-control" id="buidingNo"
											placeholder="Building Name/Number" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="email1">E-mail 1</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="email1"
											cssClass="form-control cust-form-control" id="email1"
											placeholder="Email"/>
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="email2">E-mail 2</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="email2"
											cssClass="form-control cust-form-control" id="email2"
											placeholder="Optional" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="phone">Phone
											(mobile):</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="phoneNo1"
											cssClass="form-control cust-form-control" id="phoneNo1"
											placeholder="Mobile Number" maxlength="10"/>
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="alternatenumber">Alternate
											Number (home):</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="phoneNo2"
											cssClass="form-control cust-form-control" id="phoneNo2"
											placeholder="Optional" maxlength="10" />
									</div>
								</div>
								</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="address1">Address</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="addressLine1"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="addressLine1"
											placeholder="Flat/house No, Floor, Building" />
										<form:input path="addressLine2"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="addressLine2"
											placeholder="Colony/Society, Street, Locality/Area" />
										<form:input path="city"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="city" placeholder="Town/City" />
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
												<form:input path="state"
													cssClass="form-control marg-btm-ten cust-form-control"
													id="address1state" placeholder="State" />
											</div>
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
												<form:input path="pincode"
													cssClass="form-control marg-btm-ten cust-form-control"
													id="pincode" placeholder="Pin Code" maxlength="6" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div
										class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="row">
											<div
												class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label cssClass="control-label" for="expirydate">Account Expiry Date</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="expiredDate"
													cssClass="form-control cust-form-control" id="expirydate" readonly="true" placeholder="Account Expiry Date"/>
											</div>
										</div>
									</div>
									<div
										class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="row">
											<div
												class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label class="control-label" for="expirytime">Expire
													Time</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="expiredTime"
													cssClass="form-control cust-form-control" id="expirytime" readonly="true" placeholder="Expire Time"/>
											</div>
										</div>
									</div>

								</div>
							</div>

						</div>
					</div>



					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default cancel" data-dismiss="modal">
							Cancel</button>
						<button type="submit" class="btn btn-warning btn-popup">Add</button>
					</div>
				</div>
			</form:form>
			</form>
		</div>
	</div>
	<!-- file upload popup -->
	
	<div class="modal fade" id="excelupload" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
								<div class="modal-dialog">					    
									<div class="modal-content pop-outer"> <!-- Modal content-->
										
					    					<div class="modal-header model-header-modification">
					        					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        					<h4 class="modal-title">Upload CSV</h4>
					        					<div class="clearfix"></div>  
					        				</div> <!-- end of modal header -->	      					
											<div class="modal-body" style=" padding-bottom: 0;">                                     <!--do changes here inside  -->
						        				<form id="manage-host-modal-upload-form"  method="POST" enctype="multipart/form-data"	action="<c:url value="/uploadHostUser"/>">
				          	  						<div class="form-group col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<label>Hosts CSV File</label><br>
																<input type="file" class="selectpicker filestyle" data-buttonName="btn-primary" id="hostFile" value="" accept=".csv" name="hostFile" style="position: absolute; clip: rect(0px, 0px, 0px, 0px);" tabindex="-1">
																<!-- <div class="bootstrap-filestyle input-group">
																	<span class="group-span-filestyle input-group-btn" tabindex="0">
																	<label class="btn btn-default " for="hostFile"><i class="fa fa-folder-open"></i> Choose file</label></span>
																	<input type="text" class="form-control "> 
																</div> -->
																<div style="font-size: 12px; color: #808080;" id="csvhint">
																	<p>File must be a csv format.<br><a href="<c:url value="/download_host_csv"/>" style=" color: #DD6767;">Click here</a> to downlod the format of csv file.</p>
																</div>
																										
															</div>		                					       
				       							</form> 
				       							<%-- <form id="manage-host-modal-upload-form">
				          	  						<div class="form-group col-lg-8 col-md-8 col-sm-12 col-xs-12">
																<label>Host Users File</label><br>
																<input type="file" class="selectpicker" id="hostFile" value="" accept=".csv" name="hostFile" style="position: absolute; clip: rect(0px, 0px, 0px, 0px);" tabindex="-1">
																<div class="bootstrap-filestyle input-group">
																	<span class="group-span-filestyle input-group-btn" tabindex="0">
																	<label class="btn btn-default " for="hostFile"><i class="fa fa-folder-open"></i> Choose file</label></span>
																	<input type="text" disabled="" class="form-control "> 
																</div>
																<div style="font-size: 12px; color: #808080;" id="csvhint">
																	<p>File must be a csv format.<br><a href="<c:url value="/download_host_csv"/>" style=" color: #DD6767;">Click here</a> to downlod the format of csv file.</p>
																</div>
																										
															</div>		                					       
				       							</form>  --%>
				       							
				       							<div class="clearfix"></div>  
											</div> <!-- end of model body -->
											
											<!-- Modal Footer -->
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">
													Close</button>
												<button type="submit" class="btn btn-primary" id="uploadcsvbotton">Upload
													</button>
											</div>  
											
					    			</div>
								</div>						
				 			</div> <!-- end of modal popup for download scripts-->
				 			
	
	<!-- delete confirm box -->
<!-- 	<div id="delete_confirm" title="Dialog Simple Title">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div> -->
		
		 <!-- <div id="delete_confirm" class="modal hide fade">
		  <div class="modal-body">
		    Are you sure to delete?
		  </div>
		  <div class="modal-footer">
		    <button type="button" data-dismiss="modal" class="btn btn-primary" id="delete">Delete</button>
		    <button type="button" data-dismiss="modal" class="btn">Cancel</button>
		  </div>
		</div>  -->
		
		<div class="modal fade" id="invite_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to invite host?</p>                  <!--do changes here inside  -->
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="invite">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
		</div>
		<div class="modal fade" id="delete_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to disable host?</p>                  <!--do changes here inside  -->
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="delete">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
			</div>
			<div class="modal fade" id="grant_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to activate host?</p>                  <!--do changes here inside  -->
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="grant">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
			</div> 
			<div class="modal fade" id="cancel_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to deactivate the host?</p><P>(Host will not be able to create pass)</P>
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="cancel">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
			</div>  
<!-- edit host popup modal (10/02/16) -->

	<div class="modal fade" id="editUser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog custom-modal-dialog">
			<c:url value="/host/update" var="editHost" />
			<form:form cssClass="form-horizontal" action="${editHost}"
				commandName="hostUser" method="POST" id="editHostForm">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Edit Host
						</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body wfx">
						<div class="content-outer">

							<div class="form-fields">
							<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="firstName">First
											Name</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="firstName"
											cssClass="form-control cust-form-control" id="firstName1"
											placeholder="First Name" />
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="lastname">Last Name</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="lastName"
											cssClass="form-control cust-form-control" id="lastName1"
											placeholder="Last Name" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div
											class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
											<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label class="control-label" for="email1">Department</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="department"
													cssClass="form-control cust-form-control" id="department1"
													placeholder="Department"/>
											</div>
										</div>
										</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="Type1">Designation</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="userType"
											cssClass="form-control cust-form-control" id="Type1"
											placeholder="Designation" />
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="uniqueid">Building Name/Number</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="buidingNo"
											cssClass="form-control cust-form-control" id="buidingNo1"
											placeholder="Building name/number" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="email1">E-mail 1</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="email1"
											cssClass="form-control cust-form-control" id="email11"
											placeholder="Email" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="email2">E-mail 2</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="email2"
											cssClass="form-control cust-form-control" id="email21"
											placeholder="Optional" />
									</div>
								</div>
								</div>
								</div>
								<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="phone">Phone
											(mobile):</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="phoneNo1"
											cssClass="form-control cust-form-control" id="phoneNo11"
											placeholder="Mobile Number" maxlength="10"/>
									</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="alternatenumber">Alternate
											Number (home):</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="phoneNo2"
											cssClass="form-control cust-form-control" id="phoneNo21"
											placeholder="Optional" maxlength="10"/>
									</div>
								</div>
								</div>
								</div>
								<div
									class="form-group marg-btm-ten no-margin col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<label class="control-label" for="address1">Address</label>
									</div>
									<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<form:input path="addressLine1"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="addressLine11"
											placeholder="Flat/house No, Floor, Building" />
										<form:input path="addressLine2"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="addressLine21"
											placeholder="Colony/Society, Street, Locality/area" />
										<form:input path="city"
											cssClass="form-control marg-btm-ten cust-form-control"
											id="city1" placeholder="Town/city" />
										<div class="row">
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
												<form:input path="state"
													cssClass="form-control marg-btm-ten cust-form-control"
													id="address1state1" placeholder="State" />
											</div>
											<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
												<form:input path="pincode"
													cssClass="form-control marg-btm-ten cust-form-control"
													id="pincode1" placeholder="Pin Code" maxlength="6"/>
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div
										class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="row">
											<div
												class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label cssClass="control-label" for="expirydate">Account Expiry Date</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="expiredDate"
													cssClass="form-control cust-form-control" id="expirydate1" readonly="true" placeholder="Account Expiry Date"/>
											</div>
										</div>
									</div>
									<div
										class="form-group marg-btm-ten no-margin col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="row">
											<div
												class="label-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<label class="control-label" for="expirytime">Expiry
													Time</label>
											</div>
											<div class="text-div col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form:input path="expiredTime"
													cssClass="form-control cust-form-control" id="expirytime1" readonly="true" placeholder="Expiry Time"/>
											</div>
										</div>
									</div>
									<form:hidden path="hostUserId" id="hostUserId1"/>

								</div>
							</div>

						</div>
					</div>



					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default cancel" data-dismiss="modal">
							Close</button>
						<button type="submit" class="btn btn-warning">Save
							changes</button>
					</div>
				</div>
			</form:form>
			</form>
		</div>
	</div>
<c:url value="/host/edit" var="editHostAjax"/>
<c:url value="/host/duplicateCheck" var="duplicateCheckAjax"/>
<script type="text/javascript">
$(document).ready(function(){
	$('#uploadcsvbotton').click(function(){
		$('#manage-host-modal-upload-form').submit();
	})
	
});

var editHostAction='${home}${editHostAjax}';
var duplicateCheckAction='${home}${duplicateCheckAjax}';
</script>

	<script src="<c:url value="/resources/theme/js/host.js" />"></script>
	<script src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
	<%String statusUser=null; %>
	<%String accessStatus=null; %>
	<%String accessStatusMsg=null; %>
	<%String uploadStatus=null; %>
	<%String uploadMsg=null; %>
	<c:if test="${!empty actionStatus}">
		<%statusUser=(String)request.getAttribute("actionStatus");%>
	</c:if>
	<c:if test="${!empty accessStatus}">
	<%
	accessStatus=(String)request.getAttribute("accessStatus");
	accessStatusMsg=(String)request.getAttribute("msg");
	%>
	</c:if>
	<c:if test="${!empty uploadStatus}">
	<%
	   uploadStatus=(String)request.getAttribute("uploadStatus");
	   uploadMsg=(String)request.getAttribute("msg");
	%>
	</c:if>
	  
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
<%if(uploadStatus!=null){
	if(uploadStatus.equals("SUCCESS")){
		%>
		$.notify({
			// options
			message:"<%=uploadMsg%>"
		},{
			// settings
			type: 'success'
		});
	<%
	}else{
	%>
	$.notify({
		// options
		message:"<%=uploadMsg%>"
	},{
		// settings
		type: 'danger'
	});
	<%
}}
%>

<%if(statusUser!=null){
	if(statusUser.equals("SUCCESS")){
		%>
		$.notify({
			// options
			message:'Host added successfully'
		},{
			// settings
			type: 'success'
		});
	<%
	}else if(statusUser.equals("EXISTUSER")){
	%>
	$.notify({
		// options
		message:'This Host already exist.'
	},{
		// settings
		type: 'danger'
	});
	<%
	}else{
	%>
	$.notify({
		// options
		message:'Internal server problem. Please try again!!.'
	},{
		// settings
		type: 'danger'
	});
	<%
}}
%>

<%if(accessStatus!=null){
	if(accessStatus.equals("SUCCESS")){
		%>
		$.notify({
			// options
			message:'<%=accessStatusMsg%>'
		},{
			// settings
			type: 'success'
		});
	<%
	}else{
	%>
	$.notify({
		// options
		message:'<%=accessStatusMsg%>'
	},{
		// settings
		type: 'danger'
	});
	<%
}}
%>




</script>
</html>
