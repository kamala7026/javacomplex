 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:59 GMT -->
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
        <script src="<c:url value="/resources/theme/functionality/customer.js"/>"></script>

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/js/html5shiv.js"/>"></script>
  <script src="<c:url value="/resources/theme/js/respond.min.js"/>"></script>
<![endif]-->
<style type="text/css">
#customer_due_table tr:hover {
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
 <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title" style="display: inline;">Customer Total Dues</h3>  
                            </div>
                            <div class="panel-body">
                                <div class="hidden-print">
                                    <div class="pull-right">
                                       
                                    </div>
                                </div>
                             <c:if test="${customerDue ==null && searchHappen=='true'}">
				                    <p class="text-danger">No transaction found for this customer </p>
				             </c:if>  
                          <c:choose>
				             <c:when test="${customerDue!=null}">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table" id="customer_due_table">
                                                <thead>
											<tr>
												<th>CustomerId</th>
												<th>Godown #</th>
												<th>Name  </th>
												<th>Total Dues</th>
												<th>   </th>
											</tr>
										</thead>
                                                <tbody>
											<c:forEach items="${customerDue}" var="customerDue">
												<tr>
														<c:set var="titleURL">
															<c:url value="printViewCustomerDetails.htm">
																<c:param name="customerId"
																	value="${customerDue.customerId}" />
															</c:url>
														</c:set>
													<td>${customerDue.customerId}</td>
													<td>${customerDue.godownno}</td>
													<td>${customerDue.name}</td>
													<td>${customerDue.totalBalance}</td>
													<td>click here to view  Details</td>
													<td><a href="${titleURL}" class="btn btn-inverse" style="float :right"><i class="fa fa-print"></i></a>													</td>
												</tr>
											</c:forEach>
										</tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            </c:choose>
                              
                            </div>
                            </div>
                            </div>
                            </div>
         <script type="text/javascript">
		function addDataHandlers() {
			var rows = document.getElementById("customer_due_table").rows;
			  
		    for (i = 0; i < rows.length; i++) {
		        rows[i].onclick = function(){ return function(){
		               var customerId = this.cells[0].innerHTML;
		               if(customerId != 'CustomerId'){
		            	   Customer.customerDueDetails(customerId);
		               }
		               
		        };}(rows[i]);
		    } 
			
		   
		}
		
		window.onload = addDataHandlers();
		/* $('#manager').select2(); */
		</script>
                            </body>
                            </html>