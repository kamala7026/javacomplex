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

		<title>Dashboard</title>
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
		<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>

	</head>

	<body>
			<%String status=null;%>		
			<%String msg=null; %>
			<c:if test="${!empty status}">
				<%status=(String)request.getAttribute("status"); %>
				<%msg=(String)request.getAttribute("msg"); %>
			</c:if>
			
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
								<%-- <ul class="menu">
									<li><a class="greyTxtColor nav-padding"
										href="<c:url value="/dashboard" />">Dashboard</a></li>
									<li><a class="greyTxtColor nav-padding " href="<c:url value="/user" />">Hosts</a></li>
									<li><a class="whiteTxtColor actvbgk  nav-padding" href="<c:url value="/visitors" />">Visitors</a></li>
									<li><a class="greyTxtColor nav-padding"
										href="<c:url value="/history" />">Passes</a></li>
									<li><a class=" greyTxtColor nav-padding" href="<c:url value="/profile" />">Account</a></li>			
								</ul> --%>
							</nav>
							<div class="heading-text pull-left">
								<h3 style="margin:0">Admin Users</h3>
							</div>
							<div class="m-b m-t wfx">
									<div class="pull-left">
										<div class="add-user checkshow">
											<div class="pull-left">
												 <div class="dropdown">
					                                   <button class="btn cmn-btn digipass_btn dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog"></i> Action <span class="caret"></span></button>
					                                      <ul class="dropdown-menu animated fadeInRight ">                              
						                                       <li><a href="#" id="approve_button" onclick="return false;"><i class="fa fa-check"></i> Activate</a></li>
						                                       <li><a href="#" id="deactivate_button" onclick="return false;"><i class="fa fa-times"></i> Deactivate</a></li>
					                                     </ul>
					                                     
					                                 </div>
											</div>
										
										</div>
									</div>
								</div>
							
						</div>
					</div>
				</div>
				<section id="usrPassMng" class="m-b m-t">
				
					<div class="upmTable">
						<div class="table-responsive">
						<c:url value="/organisationUsers" var="action"/>
						<form:form action="${action}" method="post" id="form_access" commandName="adminUser">
				        <form:hidden path="action" id="action_type" />
							<table id="userPass" class="table table-striped-custom-bg table-striped">
								<thead class="thead-bg whiteTxtColor">
           							<tr role="row">
           							    <th style="width: 3%;"><input type="checkbox" class="check-all check "
									id="checkboxall" name="checkboxall" /></th>
           							    <th style="width: 3%;">#</th>
               							<th style="width: 10%;">Admin Name</th>
               							<th style="width: 10%;">Company</th>
               							<th style="width: 10%;">Mobile</th>
               							<th style="width: 15%;">Email</th>               							
               							<th style="width: 15%;">Address</th>
               							<th style="width: 10%;">City</th>
               							<th style="width: 10%;">State</th>
               							<th style="width: 5%;">Status</th>
           							</tr>
         						</thead>
         						<tbody>
         						<%int i=0; %>
         							<c:forEach items="${adminUserList}" var="adminUser">
         							<%i++; %>
         							<tr class="odd" role="row">
         								<td><form:checkbox cssClass="check"
											value="${adminUser.adminUserId}" path="adminUserIdList" /></td>
         							    <td><%=i %></td>
         								<td>${adminUser.firstName} ${adminUser.lastName}</td>
         								<td>${adminUser.companyName}</td>
         								<td>${adminUser.mobile}</td>
         								<td>${adminUser.emailId}</td>
         								<td>${adminUser.address}</td>
         								<td>${adminUser.city}</td>
         								<td>${adminUser.state}</td>
         								<td>${adminUser.activeStatus}</td>        								                                                  	                                                                     
     								</tr>
     							 </c:forEach>     								
         						</tbody>
							</table>
							</form:form>
						</div>
					</div>
				</section>
			</div>

			<div class="modal fade" id="approve_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to activate admin?</p>                  <!--do changes here inside  -->
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="delete">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
			</div>
			<div class="modal fade" id="deactivate_confirm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">        			
			<div class="modal-dialog">					    
				<div class="modal-content pop-outer"> <!-- Modal content-->					
						<div class="modal-body" style=" padding-bottom: 0;">     
						     <p>Are you sure you want to deactivate admin?</p>                  <!--do changes here inside  -->
						</div> <!-- end of model body -->					
						<div class="modal-footer" style="text-align: center;  border-top: medium none; padding-top: 0;">							
							<button type="button" data-dismiss="modal" class="btn btn-primary" id="delete">Yes</button>
		    				<button type="button" data-dismiss="modal" class="btn">No</button>
						<div class="clearfix"></div>  
						</div> <!--End of modal footer-->  						
    			</div>
			</div>						
			</div>

        
			<script type="text/javascript">
        	$(document).ready(function() {
			    $('#userPass').DataTable( {
			    	"bSort": false
			    });			    
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
		
		$(document).on("click", "#checkboxall", function() {
			 var checkallstatus = $('#checkboxall').is(":checked");
				 if(checkallstatus){
				 	 $(".check").prop('checked', true);
				 }else{
				 	 $(".check").prop('checked', false);
				 }
			});
			$(document).on("click", ".check", function() {
				 var tablerowlen = $("#userPass").find("tr").length - 1;
				 console.log(tablerowlen);
				
				 var that = $(this);
				 setTimeout(function() {
				 if(that.attr("id") !== "checkboxall") {
				   $("#checkboxall").prop('checked', false);
				 } 
				var valueMem;
			    var totalchecked = $('input[type=checkbox]:checked').size();
			    //alert(totalchecked);
			    if(tablerowlen == totalchecked) {
			  $("#checkboxall").prop('checked', true);	
			} 
			if(totalchecked > 0) {
				$(".checkshow").css("display", "inline");
			}else {
				$(".checkshow").css("display", "none");
			}
				 });
			});
			
			 $('#approve_button').click(function(){
				    $('#approve_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#delete', function (e) {
			        	$("#action_type").val("ACTIVE");
			            $('#form_access').submit();
			        });
				});
			 $('#deactivate_button').click(function(){
				    $('#deactivate_confirm') .modal({ backdrop: 'static', keyboard: false }).one('click', '#delete', function (e) {
			        	$("#action_type").val("DEACTIVE");
			            $('#form_access').submit();
			        });
				});
			 
			 var texts = $("td").map(function() {
				 if($(this).text()=="Activated"){
		             var green = $(this).addClass( "user-active" );                                         
		             return $(this).text();
			     }else{
			             var green = $(this).removeClass( "user-active" );
			     }
				 if($(this).text()=="Pending"){
		             var green = $(this).addClass( "user-added" );                                         
		             return $(this).text();
			     }else{
			             var green = $(this).removeClass( "user-added" );
			     }
				 if($(this).text()=="Deactivated"){
		             var green = $(this).addClass( "user-inactive" );                                         
		             return $(this).text();
			     }else{
			             var green = $(this).removeClass( "user-inactive" );
			     }
				
			 });
			 
			 <%if(status!=null){
					if(status.equals("SUCCESS")){
						%>
						$.notify({
							// options
							message:"<%=msg%>"
						},{
							// settings
							type: 'success'
						});
					<%
					}else{
					%>
					$.notify({
						// options
						message:"<%=msg%>"
					},{
						// settings
						type: 'danger'
					});
					<%
				}}
				%>
  </script>
</html>
