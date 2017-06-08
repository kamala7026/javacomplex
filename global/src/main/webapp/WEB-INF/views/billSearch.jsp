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
        <script src="<c:url value="/resources/theme/functionality/bill.js"/>"></script>
        
        
         <!-- Plugins css -->
        <link href="<c:url value="/resources/theme/assets/modal-effect/css/component.css"/>" rel="stylesheet">


        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.1.2/css/buttons.dataTables.min.css">

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
#bill_table tr:hover {
    cursor: pointer;
    
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
                	<li class="active"><a href="<c:url value="/dashboard.htm"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
<%--                 	<li ><a href="<c:url value="/new_bill.htm"/>"><i class="ion-ios7-people"></i> <span class="nav-label">New Bill</span></a></li>
 --%>                    <li ><a href="<c:url value="/add_customer_page_view.htm"/>"><i class="ion-ios7-people"></i> <span class="nav-label">Add Customer</span></a></li>
                    <li ><a href="<c:url value="/view_customer.htm"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">View Customer</span></a></li>
                    <li ><a href="<c:url value="/view_stock.htm"/>"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">View Stock Details</span></a></li>
                    <li ><a href="<c:url value="/add_stock_page_view.htm"/>"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Add New Item</span></a></li>
                    <%-- <li class="active"><a href="<c:url value="/dashboard"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
                    <li ><a href="<c:url value="/employee/all" />"><i class="ion-ios7-people"></i> <span class="nav-label">Employee Management</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">Leave Management</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Holiday List</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">Notice</span></a></li> --%>
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
                <div class="page-title"> 
                    <h3 class="title"></h3> 
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Bill Details</h3>
                            </div>
                            <div class="panel-body">
                              <form class="form-horizontal" style="margin-bottom: 6px;" method="post" role="form" action="bill_regenerate.htm" id="viewBill" target=_blank modelAttribute="billDetails">
                                    
                                    <div class="form-group">
                                        <label class="col-md-2 control-label" for="example-input1-group2"></label>
                                        <div class="col-md-3">
                                            <div class="input-group">
                                               
                                                <input type="text" class="form-control" placeholder="Bill ID"  name="searchString" onkeypress="return alpha(event)">
                                            
                                             <span class="input-group-btn">
                                                <button onclick="formSubmit()" type="button" class="btn btn-effect-ripple btn-primary"><i class="fa fa-print"></i></button>
                                                </span></div>
                                        </div>
                                        
                                    </div> <!-- form-group -->

                                    
                                  
                               
                             </form>
							 
                           
                            
                            <div id="subViewDiv"></div>
                         
                        </div>
                    </div>
                </div> <!-- End row -->
</div>
</div>
             
          
        </section>



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
         <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>

		<!-- Modal-Effect -->
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/classie.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/modalEffects.js"/>"></script>
		
        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>

       <%--  <script src="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/datatables/dataTables.bootstrap.js"/>"></script> --%>

		 <!-- responsive-table--> 
        <script src="<c:url value="/resources/theme/assets/responsive-table/rwd-table.min.js"/>" type="text/javascript"></script>
		
		 <!-- multi select2 -->
		 <script src="<c:url value="/resources/theme/assets/select2/select2.min.js"/>" type="text/javascript"></script>
		
		<script type="text/javascript" src="https://cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/tabletools/2.2.2/swf/copy_csv_xls_pdf.swf"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.flash.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.print.min.js"></script>
		<script type="text/javascript">
		
		function formSubmit(){
			$('#viewBill').submit();
		}
		function addRowHandlers() {
		    var rows = document.getElementById("bill_table").rows;
		  
		    for (i = 0; i < rows.length; i++) {
		        rows[i].onclick = function(){ return function(){
		               var billNumber = this.cells[0].innerHTML;
		               if(billNumber != 'Bill Number'){
		            	   Bill.searchBillDetails(billNumber);
		               }
		               
		        };}(rows[i]);
		    }
		}
		window.onload = addRowHandlers();
		/* $('#manager').select2(); */
		
	
			function numeric(e) {
			var k;
			document.all ? k = e.keyCode : k = e.which;
			return ((k >= 48 && k <= 57) || k == 46);
		}
		</script>
        
		
    </body>

</html>
