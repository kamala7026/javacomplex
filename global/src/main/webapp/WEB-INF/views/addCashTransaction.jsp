<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/table-datatable.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:05 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="<c:url value="/resources/theme/img/favicon_1.ico" />">

        <title>WelCome To BGS</title>

        


        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

         <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <!-- DataTables 
        <link href="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css" />
       -->
        <!-- Responsive-table -->
        <link href="<c:url value="/resources/theme/assets/responsive-table/rwd-table.min.css"/>" rel="stylesheet" type="text/css" media="screen"/>
        
         <!-- Plugins css -->
        <link href="<c:url value="/resources/theme/assets/modal-effect/css/component.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.min.css"/>" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme/assets/select2/select3.css"/>" />

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/js/html5shiv.js"/>"></script>
  <script src="<c:url value="/resources/theme/js/respond.min.js"/>"></script>
<![endif]-->
<style type="text/css">
.panel-heading {
	border-color: #EFF2F7;
	font-size: 16px;
	padding: 0px 0px 50px;
}


</style>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../www.google-analytics.com/analytics.html','ga');

  ga('create', 'UA-62751496-1', 'auto');
  ga('send', 'pageview');

</script>

    </head>


    <body>

                <!-- Aside Start-->
        <aside class="left-panel">

            <!-- brand -->
            <div class="logo">
                <a href="<c:url value="/dashboard.htm"/>" class="logo-expanded">
                    <i class="ion-social-buffer"></i>
                    <span class="nav-label">WelCome To BGS</span>
                </a>
            </div>
            <!-- / brand -->
        
            <!-- Navbar Start -->
            <nav class="navigation">
                <ul class="list-unstyled">
                    <li ><a href="<c:url value="/dashboard.htm"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
<%--                     <li class="active"><a href="<c:url value="/projects"/>"><i class="ion-ios7-people"></i> <span class="nav-label">Projects</span></a></li>
                   <li ><a href="<c:url value="/leave"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">Leave</span></a></li>
                    <li ><a href="#"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Holiday List</span></a></li>
                    <li ><a href="#"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">Notice</span></a></li>  --%> 
                 </ul>
            </nav>
                
        </aside>
        <!-- Aside Ends-->


        <!--Main Content Start -->
        <section class="content">
            
			            <!-- Header -->
            <header class="top-head container-fluid">
                <button type="button" class="navbar-toggle pull-left">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               

                <!-- user login dropdown start-->
                    <li class="dropdown text-center" style="float: right;">
                            <span class="username">${logInUser.userName} </span> <span class="caret"></span>
                        <a href="./logout.htm"><i class="fa fa-sign-out"></i> Log Out</a>
                      <!--   <ul class="dropdown-menu extended pro-menu fadeInUp animated" tabindex="5003" style="overflow: hidden; outline: none;">
                             <li><a href="<c:url value="/profile" />"><i class="fa fa-briefcase"></i>Profile</a></li>
                             <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                            <li><a href="#"><i class="fa fa-bell"></i> Friends <span class="label label-info pull-right mail-info">5</span></a></li>
                            <li><a href="/global/logout.htm"><i class="fa fa-sign-out"></i> Log Out</a></li>
                        </ul> -->
                    </li>
                    <!-- user login dropdown end -->       
                <!-- End right navbar -->

            </header>
            <!-- Header Ends -->


            <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid">

					
			<div class="row">
                                   
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3 class="panel-title">Add Contact</h3></div>
                            <div class="panel-body">
                                <div class=" form">
							<c:if test="${null != status && searchHappen=='true'}">
								<%
									String status = (String) request.getAttribute("status");
										String message = (String) request.getAttribute("message");
										if (status.equals("error")) {
								%>
								<div class="alert alert-warning alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									
										${message}
									</div>
								
								<%
									} else {
								%>
								<div class="alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									Customer Payment Details updates
											successfully.Reciept Number is - ${message}
								</div>
								<%
									}
								%>
							</c:if>
							<form:form class="cmxform form-horizontal tasi-form" id="addCash" method="POST"  modelAttribute="cashPaidDetails" action="add_cash.htm" novalidate="novalidate">
                
                                        <div class="form-group" >
															<label style="margin-left: 6%;">CustomerName  *</label><div class="col-sm-50" style="display: inline;">
																	<form:select  class="selectCustomer" data-placeholder="Choose a Customer.." id="customerId" name="customerId"  path="customerDetails" >
																		<option value="#">&nbsp;</option>
																		<c:forEach items="${customerList}" var="customerList">
																			<form:option value="${customerList.name}###${customerList.customerId}###${customerList.godownNo}" >
																			${customerList.name}-${customerList.godownNo}</form:option>
																		</c:forEach>
																	</form:select>
																</div>
										</div>
                                         <div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Amount *</label>
                                            <div class="col-lg-10">
                                                <input class=" form-control" id="amount" name="amount" path="amount" type="text" onkeypress="return numeric(event)">
                                            </div>
                                        </div>
                                         <div class="form-group">
                                        <label class="col-sm-2 control-label">PaymentType *</label>
                                        <div class="col-sm-10">
                                            <form:select class="form-control" id="typeOfTransact" name="typeOfTransact" path="typeOfTransact" >
                                                <form:option value="Cash">Cash</form:option>
                                                <form:option value="AccountTransfer">AccountTransfer</form:option>
                                            </form:select>
                                        </div>
                                    </div>
                   
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button class="btn btn-success" type="submit">Paid Cash</button>
                                                <button class="btn btn-default" type="button">Cancel</button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div> <!-- .form -->

                            </div> <!-- panel-body -->
                        </div> <!-- panel -->
                    </div> <!-- col -->

                </div>
					
                </div>
					
					
				                                           
                                                                 
                                                                    
                                                                    
                                                                        
                                                                     
                                                                        
                                          					

						


        </section> 
        <!-- Main Content Ends -->
        



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
         <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>

 
        <script src="<c:url value="/resources/theme/functionality/jquery.validate/jquery.validate.min.js"/>"></script>
 
         <script src="<c:url value="/resources/theme/functionality/jquery.validate/form-validation-init.js"/>"></script>
 


		<!-- Modal-Effect -->
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/classie.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/modalEffects.js"/>"></script>
		
        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>

       <%--  <script src="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/datatables/dataTables.bootstrap.js"/>"></script> --%>

		 <!-- responsive-table--> 
        <script src="<c:url value="/resources/theme/assets/responsive-table/rwd-table.min.js"/>" type="text/javascript"></script>
		
		<!-- datepicker -->
		 <script src="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.js"/>"></script>
		 
		 <!-- multi select2 -->
		<script src="<c:url value="/resources/theme/assets/select2/select3.min.js"/>" type="text/javascript"></script>		
        
		<script type="text/javascript">


		jQuery(".selectCustomer").select3({
			width : '81%'
		});
		
		
		function alpha(e) {
			var k;
			document.all ? k = e.keyCode : k = e.which;
			return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8
					|| k == 13 || k == 32 || (k >= 48 && k <= 57));
		}
		function numeric(e) {
			var k;
			document.all ? k = e.keyCode : k = e.which;
			return (k >= 48 && k <= 57);
		}
		</script>
    </body>

</html>
