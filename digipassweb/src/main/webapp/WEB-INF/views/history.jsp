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

		<title>Pass History</title>
		<meta name="description" content="">
		<meta name="author" content="Adeptpros">
		<meta name="viewport" content="width=device-width; initial-scale=1.0">
		
		<!-- Cascading Style Sheets -->
		<link href="<c:url value="/resources/theme/css/master.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/dashboard.css" />" rel="stylesheet"/>
		<link href="http://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet"/>
		<link href="<c:url value="/resources/theme/css/bootstrap-datepicker.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/bootstrap-datepicker.css" />" rel="stylesheet" />
		<link href="<c:url value="/resources/theme/css/animate.css" />" rel="stylesheet"/>
		<!-- Javascript files -->
		<script src="<c:url value="/resources/theme/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/theme/js/jquery-ui.min.js" />"></script>
		<script type="text/javascript" src="http://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap-datepicker.js" />"></script>
		<script src="<c:url value="/resources/theme/js/bootstrap-notify.js" />"></script>
		 <script src="<c:url value="/resources/theme/js/jquery.validate.js" />"></script>
		<script>
			  $(document).ready(function() {
				  
				  
    			$( "#from-date" ).datepicker({
    				format:"yyyy/mm/dd",
    				autoclose:true    				 
    			}).on('hide', function(ev){
    				var date2 = $('#from-date').datepicker('getDate');		               
		                date2.setDate(date2.getDate() + 1);
		                $('#to-date').datepicker('setDate', date2);
		                $('#to-date').datepicker('setStartDate', date2);
		                console.log("from "+date2);
    			        
    			});
    			$( "#to-date" ).datepicker({
    				format:"yyyy/mm/dd",
    				autoclose:true
    			}) .on('changeDate', function(ev){    			    
    			    var dt1 = $('#from-date').datepicker('getDate');
    			    var dt2 = $('#to-date').datepicker('getDate');
    			    console.log("From "+dt1);
    			    console.log("To "+dt2);    			    
	                if (dt2 <= dt1) { 
	                	dt1.setDate(dt1.getDate() + 1);
	    			    $('#to-date').datepicker('setStartDate', dt1);
	                	$('#to-date').datepicker('setDate',dt1);		                	
	                } else{
	                	$('#to-date').datepicker('setStartDate', dt1);
	                }
	                
    			}); 
  			});
		</script>
		

	</head>
	<%String filter=null; %>
			
	<body onload="setValues()">
		
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
			`	</div>
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
									<li><a class="whiteTxtColor actvbgk nav-padding"
										href="<c:url value="/history" />">Passes</a></li>
									<li><a class="greyTxtColor nav-padding" href="<c:url value="/profile" />">Account</a></li>
								</ul>
							</nav>
							<div class="heading-text pull-left">
								<h3 style="margin:0">Pass History</h3>
							</div>
						</div>
					</div>
				</div>
			
				<section id="usrPassMng">
					<div class="m-b wfx">
					<c:url value="/history" var="searchPassAction"/>
					<form:form action="${searchPassAction}" method="post" commandName="passHistory" id="searchhistoryform">
						<div class="date-picker">
							<div class="from">
		            	 		<form:input path="fromDate" cssClass="cmn-date-file" placeholder="from" readonly="readonly" id="from-date"/>
		            	 	</div>
		            	 	
		            	 	<div class="to">
		            	 		<form:input path="toDate" cssClass="cmn-date-file" placeholder="to" readonly="readonly" id="to-date"/>
		            	 	</div>
		            	 	 <div class="searchbtn">
                                     <input type="submit" class="btn digipass_btn cust-searchBtn" value="Search"/>
                             </div>
                             <c:if test="${!empty filter}">
                             <div class="searchbtn">
                                     <a href="<c:url value="/history" />"> <input type="button" class="btn digipass_btn1" value="Reset"/></a>
                             </div>
								<%filter=(String)request.getAttribute("filter"); %>
							</c:if>
                             
	            	 	</div>
	            	 </form:form>
					</div>
					<div class="upmTable">
						<div class="table-responsive">
							<table id="userPass" class="table table-striped-custom-bg table-striped">
								<thead class="thead-bg whiteTxtColor">
           							<tr role="row">
           								<th style="width:10%;">#ID</th>
               							<th style="width:15%;">Visitor Name</th>
               							<th style="width:15%;">Host Name</th>
               							<th style="width:5%;">Purpose</th>
               							<th style="width:10%;">Venue</th>
               							<th style="width:5%;">Entry</th>
               							<th style="width:5%;">Exit</th>
               							<th style="width:10%;">Vehicle</th>
               							<th style="width:10%;">Equipment</th> 
               							<th style="width:10%;">Created</th> 
               							<th style="width:5%;">Status</th>              							
           							</tr>
         						</thead>
         						<tbody>
									<c:forEach items="${passList}" var="pass">
										<c:choose>
										    <c:when test="${pass.passStatus=='EXPIRED'}">
										       <tr class="item" title="<p style='color:red;'>PASS STATUS: <b>${pass.passStatus}</b></p>">
										    </c:when>    
										    <c:otherwise>
										       <tr class="item" title="<p style='color:green;'>PASS STATUS: <b>${pass.passStatus}</b></p>">
										    </c:otherwise>
										</c:choose>
																			
											<td>${pass.passId}</td>
	                                        <td>${pass.visitorFirstName} ${pass.visitorLastName}<br />${pass.companyName} <br/> ${pass.visitorEmailId} <br/> ${pass.visitorMobileNo}</td>
	                                        <td><span>${pass.hostFirstName} </span><span>${pass.hostLastName} </span></br>
                                        	<span>${pass.hostEmail} </span></br>
                                        	<span>${pass.hostMobile} </span></td>
                                        	<td>${pass.visitorPurpose}</td>
                                        	<td>${pass.visitorVanue}</td>
	                                        <td>${pass.visitorEntryTime}</td>
	                                        <td>${pass.visitorExitTime}</td>	                                        
	                                        <td>${pass.visitorVechilesDetails}</td>
	                                        <td>${pass.visitorEquipmentDetails}</td>
	                                        <td>${pass.createdDate}</td>
	                                        <td style="font-weight: bolder;" class="pass-status">${pass.passStatus}</td>
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
			    $('#userPass').DataTable({
			    	"bSort": false
			    });
			    
			    $.widget("ui.tooltip", $.ui.tooltip, {
			        options: {
			            content: function () {
			                return $(this).prop('title');
			            }
			        }
			    });
			    $(function () {
			        $('.item').attr('title', function(){
			            return $(this).next('.statusRollup').remove().html()
			        })
			        $(document).tooltip();
			    });   
			});
        </script>
			
		
	</body>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('.cust-searchBtn').click(function() {
	        localStorage.fromDate = $('#from-date').val();
	        localStorage.toDate = $('#to-date').val();
	        
		});
		
		
		$("#searchhistoryform").validate({
			rules: {
				fromDate: {
					required: true
				},
				toDate: {
					required: true
				}
			},
			messages: {
				fromDate: {
					required: "This filed is required"
				},
				toDate: {
					required: "This filed is required"
				}
			}
			
			
		});
	});
		
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

function setValues(){
	/* var fromDate=$("#from-date").val();
	var toDate=$("#to-date").val();
    alert(fromDate);
	if(fromDate!=""){
		var d1=fromDate.replace(" 00:00:00 IST","").substring(4,15);;
		var d = new Date(d1);
		$("#from-date").val(d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate());
	}
	if(toDate!=""){
		var d1=toDate.replace(" 00:00:00 IST","").substring(4,15);;
		var d = new Date(d1);
		$("#to-date").val(d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate());
	}
	 */
	 
	 <%if(filter!=null){
		 %>
		 $('#to-date').datepicker('setDate', new Date(localStorage.toDate));
		 $('#from-date').datepicker('setDate', new Date(localStorage.fromDate));
		// var dt1 = new Date(localStorage.fromDate);
		// dt1.setDate(new Date(localStorage.toDate) + 1);
		// $('#to-date').datepicker('setStartDate', dt1);
		 
		 
		 <%
	 }%>
         
     
	
}

var texts = $(".pass-status").map(function() {
    if($(this).text()=="VALID"){
            var green = $(this).addClass( "user-active" );                                         
            return $(this).text();
    }else{
            var green = $(this).removeClass( "user-active" );
    }
    if($(this).text()=="EXPIRED"){
            var red = $(this).addClass( "user-inactive" );                                         
            return $(this).text();
    }else{
            $(this).removeClass("user-inactive");
    }
    
});
</script>
</html>
