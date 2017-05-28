<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:52 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

            <link rel="shortcut icon" href="<c:url value="/resources/theme/img/favicon_1.ico" />">

        <title>Welcome To BGS</title>

         <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

         <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <!--Morris Chart CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/theme/assets/morris/morris.css"/>">

        <!-- sweet alerts -->
        <link href="<c:url value="/resources/theme/assets/sweet-alert/sweet-alert.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
<![endif]-->

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
                <a href="index.html" class="logo-expanded">
                    <i class="ion-social-buffer"></i>
                    <span class="nav-label">ADEPTPROS INC. EMS</span>
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
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="<c:url value=""/>" class="img-circle profile-img thumb-sm">
                            <span class="username">${logInUser.userName} </span> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu extended pro-menu fadeInUp animated" tabindex="5003" style="overflow: hidden; outline: none;">
                            <li><a href="profile.html"><i class="fa fa-briefcase"></i>Profile</a></li>
                             <!-- <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>-->
                            <!-- <li><a href="#"><i class="fa fa-bell"></i> Friends <span class="label label-info pull-right mail-info">5</span></a></li> -->
                            <li><a href="location.href='logout.htm'"><i class="fa fa-sign-out"></i> Log Out</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->       
                </ul>
                <!-- End right navbar -->

            </header>
            <!-- Header Ends -->


            <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="bg-picture" style="background-image:url('<c:url value="/resources/theme/img/bg_6.jpg"/>')">
                          <span class="bg-picture-overlay"></span><!-- overlay -->
                          <!-- meta -->
                          <div class="box-layout meta bottom">
                            <div class="col-sm-6 clearfix">
                              <span class="img-wrapper pull-left m-r-15"><img src="<c:url value=""/>" alt="" style="width: 150px;" class="br-radius"></span>
                              <div class="media-body">
                                <h3 class="text-white mb-2 m-t-10 ellipsis">${employeeDetails.employeeFirstName } ${employeeDetails.employeeLastName }</h3>
                                <h5 class="text-white">${employeeDetails.employeeId}</h5>
                              </div>
                            </div>
                            <!-- <div class="col-sm-6">

                              <div class="pull-right">
                                <div class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle btn btn-primary" href="#"> Following <span class="caret"></span></a>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#">Poke</a></li>
                                        <li><a href="#">Private message</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Unfollow</a></li>
                                    </ul>
                                </div>
                              </div>
                            </div> -->
                          </div>
                          <!--/ meta -->
                        </div>
                    </div>
                </div>

                <div class="row m-t-30">
                    <div class="col-sm-12">
                        <div class="panel panel-default p-0">
                            <div class="panel-body p-0"> 
                                <ul class="nav nav-tabs profile-tabs">
                                    <li class="active"><a data-toggle="tab" href="#aboutme">About Me</a></li>
                                   <!--  <li class=""><a data-toggle="tab" href="#user-activities">Activities</a></li> -->
                                 <!--   <li class=""><a data-toggle="tab" href="#projects">Projects</a></li> -->
                                    <li class=""><a data-toggle="tab" href="#edit-profile">Settings</a></li>
                                    
                                </ul>

                                <div class="tab-content m-0"> 

                                    <div id="aboutme" class="tab-pane active">
                                    <div class="profile-desk">
                                        <h1 style="color:#31708f;">${employeeDetails.employeeFirstName } ${employeeDetails.employeeLastName }</h1>
                                        <span class="designation">${employeeDetails.employeeDesignation }</span>
                                        <p>
                                            I have 3 years of experience designing for the web, and specialize in the areas of user interface design, interaction design, visual design and prototyping.I have worked with notable startups including Pearl Street Software.
                                        </p>
                                       <!--  <a class="btn btn-primary m-t-20" href="#"> <i class="fa fa-check"></i> Following</a>-->
                                            <table class="table table-condensed">
                                            <thead>
                                                <tr>
                                                    <th colspan="3" style="color: #9E9E9E;"><h3>Contact Information</h3></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><b>Company URL</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        www.adeptpros.com
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Email</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeeEmail}
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Phone</b></td>
                                                    <td class="ng-binding">
                                                    ${employeeDetails.employeePhone} </td>
                                                </tr>
                                                <tr>
                                                    <td><b>Linkedin</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeeEmail} 
                                                    </a></td>
                                                </tr>
                                                <tr></tr>
                                            </tbody>
                                        </table>
                                        <table class="table table-condensed">
                                           <thead>
                                                <tr>
                                                    <th colspan="3" style="color: #9E9E9E;"><h3>Permanent Address</h3></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><b>Address line</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                       ${employeeDetails.employeePermanentAddress }
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>City</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePermanentCity}
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>District</b></td>
                                                    <td class="ng-binding">
                                                    ${employeeDetails.employeePermanentDistrict} </td>
                                                </tr>
                                                <tr>
                                                    <td><b>State</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePermanentState} 
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Country</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePresentCountry} 
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Pincode</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.emplyeePermanentPincode} 
                                                    </a></td>
                                                </tr>
                                                <tr></tr>
                                            </tbody>
                                        </table>
                                         <table class="table table-condensed">
                                           <thead>
                                                <tr>
                                                    <th colspan="3" style="color: #9E9E9E;"><h3>Present Address</h3></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><b>Address line</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                       ${employeeDetails.employeePresentAddress }
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>City</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePresentCity}
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>District</b></td>
                                                    <td class="ng-binding">
                                                    ${employeeDetails.employeePresentDistrict} </td>
                                                </tr>
                                                <tr>
                                                    <td><b>State</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePresentState} 
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Country</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePresentCountry} 
                                                    </a></td>
                                                </tr>
                                                <tr>
                                                    <td><b>Pincode</b></td>
                                                    <td>
                                                    <a href="#" class="ng-binding">
                                                        ${employeeDetails.employeePresentPincode} 
                                                    </a></td>
                                                </tr>
                                                <tr></tr>
                                            </tbody>
                                        </table>
                                       
                                    </div> <!-- end profile-desk -->
                                </div> <!-- about-me -->


                                <!-- Activities
                                <div id="user-activities" class="tab-pane">
                                    <div class="timeline-2">
                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">5 minutes ago</div>
                                                <p><strong><a href="#" class="text-info">John Doe</a></strong> Uploaded a photo <strong>"DSC000586.jpg"</strong></p>
                                            </div>
                                        </div>

                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">30 minutes ago</div>
                                                <p><a href="#" class="text-info">Lorem</a> commented your post.</p>
                                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                            </div>
                                        </div>

                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">59 minutes ago</div>
                                                <p><a href="#" class="text-info">Jessi</a> attended a meeting with<a href="#" class="text-success">John Doe</a>.</p>
                                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                            </div>
                                        </div>

                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">5 minutes ago</div>
                                                <p><strong><a href="#" class="text-info">John Doe</a></strong>Uploaded 2 new photos</p>
                                            </div>
                                        </div>

                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">30 minutes ago</div>
                                                <p><a href="#" class="text-info">Lorem</a> commented your post.</p>
                                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                            </div>
                                        </div>

                                        <div class="time-item">
                                            <div class="item-info">
                                                <div class="text-muted">59 minutes ago</div>
                                                <p><a href="#" class="text-info">Jessi</a> attended a meeting with<a href="#" class="text-success">John Doe</a>.</p>
                                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                            </div>
                                        </div>
                                    </div>
                                </div> -->

                                <!-- settings -->
                                <div id="edit-profile" class="tab-pane">
                                    <div class="user-profile-content">
                                        <form role="form">
                                            <!-- <div class="form-group">
                                                <label for="FullName">Full Name</label>
                                                <input type="text" value="John Doe" id="FullName" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Email">Email</label>
                                                <input type="email" value="first.last@example.com" id="Email" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Username">Username</label>
                                                <input type="text" value="john" id="Username" class="form-control">
                                            </div> -->
                                            <div class="form-group">
                                                <label for="Password">Password</label>
                                                <input type="password" placeholder="6 - 15 Characters" id="Password" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="RePassword">Re-Password</label>
                                                <input type="password" placeholder="6 - 15 Characters" id="RePassword" class="form-control">
                                            </div>
                                            <!-- <div class="form-group">
                                                <label for="AboutMe">About Me</label>
                                                <textarea style="height: 125px;" id="AboutMe" class="form-control">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</textarea>
                                            </div> -->
                                            <button class="btn btn-primary" type="submit">Save</button>
                                        </form>
                                    </div>
                                </div>


                                <!-- profile
                                <div id="projects" class="tab-pane">
                                    <div class="row m-t-10">
                                        <div class="col-md-12">
                                            <div class="portlet">
                                                <div id="portlet2" class="panel-collapse collapse in">
                                                    <div class="portlet-body">
                                                        <div class="table-responsive">
                                                            <table class="table">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Project Name</th>
                                                                        <th>Start Date</th>
                                                                        <th>Due Date</th>
                                                                        <th>Status</th>
                                                                        <th>Assign</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>1</td>
                                                                        <td>Velonic Admin</td>
                                                                        <td>01/01/2015</td>
                                                                        <td>07/05/2015</td>
                                                                        <td><span class="label label-info">Work in Progress</span></td>
                                                                        <td>Coderthemes</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>2</td>
                                                                        <td>Velonic Frontend</td>
                                                                        <td>01/01/2015</td>
                                                                        <td>07/05/2015</td>
                                                                        <td><span class="label label-success">Pending</span></td>
                                                                        <td>Coderthemes</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>3</td>
                                                                        <td>Velonic Admin</td>
                                                                        <td>01/01/2015</td>
                                                                        <td>07/05/2015</td>
                                                                        <td><span class="label label-pink">Done</span></td>
                                                                        <td>Coderthemes</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>4</td>
                                                                        <td>Velonic Frontend</td>
                                                                        <td>01/01/2015</td>
                                                                        <td>07/05/2015</td>
                                                                        <td><span class="label label-purple">Work in Progress</span></td>
                                                                        <td>Coderthemes</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>5</td>
                                                                        <td>Velonic Admin</td>
                                                                        <td>01/01/2015</td>
                                                                        <td>07/05/2015</td>
                                                                        <td><span class="label label-warning">Coming soon</span></td>
                                                                        <td>Coderthemes</td>
                                                                    </tr>
                                                                    
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  -->
                                        </div>
                                    </div>
                                </div>
                            </div>
             
                        </div> 
                    </div>
                </div>
            </div>

            

            


        </div>

        <!-- Page Content Ends -->
        <!-- ================== -->

        <!-- Footer Start -->
        <footer class="footer">
                2015 © ADEPTPROS INC.
            </footer>
        <!-- Footer Ends -->



    </section>
    <!-- Main Content Ends -->
        
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.scrollTo.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>
		
  </body>

<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:52 GMT -->
</html>
