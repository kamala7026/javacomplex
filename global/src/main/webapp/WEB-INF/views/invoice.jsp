<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/invoice.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:57 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <link rel="shortcut icon" href="img/favicon_1.ico">

        <title>Welcome to BGS</title>

             <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

         <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />


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
            <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid">
                <div class="page-title"> 
                    <h3 class="title">Invoice</h3> 
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <!-- <div class="panel-heading">
                                <h4>Invoice</h4>
                            </div> -->
                            <div class="panel-body">
                                <div class="clearfix">
                                    <div class="pull-left">
                                        <h4 class="text-right"><i class="ion-social-buffer"></i>      BGS</h4>
                                        
                                    </div>
                                    <div class="pull-right">
                                        <h4>Bill # <br>
                                            <strong>${invoice.billNumber}</strong>
                                        </h4>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-12">
                                        
                                        <div class="pull-left m-t-30">
                                            <address>
                                            <h4>Shop Name <br>
                                            </h4>
                                              <strong>${invoice.customerName}</strong><br>
                                             <!--  795 Folsom Ave, Suite 600<br>
                                              San Francisco, CA 94107<br>
                                              <abbr title="Phone">P:</abbr> (123) 456-7890 -->
                                              </address>
                                        </div>
                                        <div class="pull-right m-t-30">
                                            <p><strong>Bill Date: </strong> ${invoice.billDate} </p>
                                            <p class="m-t-10"><strong>Order Status: </strong> <span class="label label-success">success</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-h-50"></div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="table-responsive">
                                            <table class="table m-t-30">
                                                <thead>
                                                    <tr><th>#</th>
                                                    <th>Item</th>
                                                    <th>Description</th>
                                                    <th>Quantity</th>
                                                    <th>Unit Cost</th>
                                                    <th>Total</th>
                                                </tr></thead>
                                                <tbody>
                                                <c:forEach items="${invoice.billItems}" var="billItems" varStatus="status">
                                                    <tr>
                                                        <td>${status.count}</td>
                                                        <td>${billItems.productName}</td>
                                                        <td>${billItems.pdesc}</td>
                                                        <td>${billItems.quantity}</td>
                                                        <td>${billItems.price}</td>
                                                        <td>${billItems.totalPrice}</td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="border-radius: 0px;">
                                    <div class="col-md-3 col-md-offset-9">
                                        <p class="text-right"><b>Sub-total:</b> ${invoice.basicAmount}</p>
                                        <p class="text-right">VAT: ${invoice.vatAmount}</p>
                                        <p class="text-right">Paid: ${invoice.paidAmount}</p>
                                        <hr>
                                        <h3 class="text-right">${invoice.dueAmount}</h3>
                                        
                                    </div>
                                </div>
                                <hr>
                                <div class="hidden-print">
                                    <div class="pull-right">
                                        <a href="new_bill.htm" class="btn btn-primary">Continue</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

            <!-- Page Content Ends -->
            <!-- ================== -->



        </section>
        <!-- Main Content Ends -->


        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>


        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>


    </body>

