
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">

<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:59 GMT -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="shortcut icon"
	href="<c:url value="/resources/theme/img/favicon_1.ico" />">

<title>Welcome To BGS</title>




<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/theme/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>"
	rel="stylesheet">

<!--Animation css-->
<link href="<c:url value="/resources/theme/css/animate.css"/>"
	rel="stylesheet">

<!--Icon-fonts css-->
<link
	href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>"
	rel="stylesheet" />

<!--Morris Chart CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/theme/assets/morris/morris.css"/>">
<script src="<c:url value="/resources/theme/functionality/stock.js"/>"></script>

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/theme/css/style.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/theme/css/helper.css"/>"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/1.1.2/css/buttons.dataTables.min.css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/1.1.2/css/buttons.dataTables.min.css">
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
					<h3 class="panel-title" style="display: inline;">Bill Details</h3>
					<!-- <a href="#" class="btn btn-inverse" style="float :right"><i class="fa fa-print"></i></a> -->
				</div>
				<div class="panel-body">

					<%-- <c:if test="${billDetailsList ==null && searchHappen=='true'}">
				                    <p class="text-danger">No matching Bill found</p>
				             </c:if>  --%>
					<c:choose>
						<c:when test="${billDetailsList.billItems!=null}">

							<div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="">
										<table class="table table-striped table-responsive"
											id="bill_subview_table">
											<thead>
												<tr>
													<th>Product Name</th>
													<th>Product desc</th>
													<th>Price</th>
													<th>Quantity</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${billDetailsList.billItems}" var="billItems"
													varStatus="status">

													<tr>
														<td>${billItems.productName}</td>
														<td>${billItems.pdesc}</td>
														<td>${billItems.price}</td>
														<td>${billItems.quantity}</td>
													</tr>
												</c:forEach>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>
					<!--                              <div id="customerDueDetails"></div> 
 -->
				</div>
			</div>
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->

	<!-- <script type="text/javascript" src="https://cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/tabletools/2.2.2/swf/copy_csv_xls_pdf.swf"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.flash.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.1.2/js/buttons.print.min.js"></script> -->
	<script type="text/javascript">
         $(document).ready(function() {
             $('#bill_subview_table').dataTable({
                 dom: 'Bfrtip',
                 buttons: ['copy','csv','excel','pdf','print']
                 //"scrollX": true
             });
         });
		/* function addDataHandlers() {
			var rows = document.getElementById("product_subview_table").rows;
			  
		    for (i = 0; i < rows.length; i++) {
		        rows[i].onclick = function(){ return function(){
		               var customerId = this.cells[0].innerHTML;
		               if(customerId != 'CustomerId'){
		            	   Customer.customerDueDetails(customerId);
		               }
		               
		        };}(rows[i]);
		    } 
			
			
		} */
		//window.onload = addDataHandlers();
		/* $('#manager').select2(); */
		</script>
</body>
</html>