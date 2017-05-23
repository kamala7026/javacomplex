<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="img/favicon_1.ico">

        <title>Welcome To BGS</title>

        


      
        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

         <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />


        <!-- DataTables -->
        <link href="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css" />


          <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
<![endif]-->
<style type="text/css">

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

      
      <section>


                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Customer Due Details</h3>
                            </div>
                              <div class="panel-body">
                             <c:if test="${customerDueDetails ==null && customerPaymentDetails == null && searchHappen=='true'}">
				                    <p class="text-danger">No transaction found for this customer </p>
				             </c:if>  
                          <c:choose>
				             <c:when test="${customerDueDetails!=null}">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table id="datatable" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
												<th>Bill No.</th>
												<th>Bill Date</th>
												<th>Bill Amount</th>
												<th>Paid Amount</th>
												<th>Due Amount</th>
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                         <c:forEach items="${customerDueDetails}" var="customerDue">
												<tr>
													<td>${customerDue.billNo}</td>
													<td>${customerDue.billDate}</td>
													<td>${customerDue.billAmount}</td>
													<td>${customerDue.paidAmount}</td>
													<td>${customerDue.dueAmount}</td>
												</tr>
											</c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                                </c:when>
                            </c:choose>
                            </div>
                        </div>
                    </div>
                    
                </div> <!-- End Row -->

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Customer Payment Details</h3>
                            </div>
                              <div class="panel-body">
                          <c:choose>
				             <c:when test="${customerPaymentDetails!=null}">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table id="datatable1" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
												<th>Cash Record Id</th>
												<th>Paid Date</th>
												<th>Payment Type</th>
												<th>Paid Amount</th>
                                                </tr>
                                            </thead>

                                     
                                            <tbody>
                                         <c:forEach items="${customerPaymentDetails}" var="customerPayment">
												<tr>
													<td>${customerPayment.cashRecordId}</td>
													<td>${customerPayment.cashRecordDate}</td>
													<td>${customerPayment.paymentType}</td>
													<td>${customerPayment.amount}</td>
												</tr>
											</c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                                </c:when>
                            </c:choose>
                            </div>
                        </div>
                    </div>
                    
                </div> <!-- End Row -->
                

            

            <!-- Page Content Ends -->
            <!-- ================== -->

        


        </section>
        <!-- Main Content Ends -->
        



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>


        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>

        <script src="${context}/resources/theme/assets/datatables/jquery.dataTables.min.js"></script>
        <script src="${context}/resources/theme/assets/datatables/dataTables.bootstrap.js"></script>


        <script type="text/javascript">
            $(document).ready(function() {
                $('#datatable').dataTable();
            } );
        </script>

    </body>

