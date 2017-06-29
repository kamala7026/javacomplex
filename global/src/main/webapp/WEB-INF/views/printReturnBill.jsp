<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    
        <link rel="shortcut icon" href="img/favicon_1.ico">

        <title>Welcome to BGS</title>
          <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">


        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
    </head>


    <body>

            <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="clearfix">
                                    <div class="pull-left">
                                        <h4 class="text-right"><i class="ion-social-buffer"></i>      BGS</h4>
                                        
                                    </div>
                                    <div class="pull-right" style="    margin-right: 179px;">
                                        <h4>Bill # 
                                           &nbsp;&nbsp; <strong>${invoice.billNumber}</strong>
                                        </h4>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-12">
                                        
                                        <div class="pull-left">
                                            <address>
                                            <h4>Shop Name</h4> <br>
                                              <strong>${invoice.customerDetails}</strong><br>
                                             <!--  795 Folsom Ave, Suite 600<br>
                                              San Francisco, CA 94107<br>
                                              <abbr title="Phone">P:</abbr> (123) 456-7890 -->
                                              </address>
                                        </div>
                                        <div class="pull-right m-t-30" style="    margin-right: 30px;">
                                            <p><strong>Bill Date: </strong> ${invoice.billDate} </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 10px;">
                                    <div class="col-md-12">
                                        <div class="table-responsive">
                                            <table class="table">
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
                                <div class="row" style="border-radius: 0px;margin-right: 21px;">
                                    <div class="col-md-3 col-md-offset-9">
                                        <p class="text-right"><b>Sub-total:</b> ${invoice.basicAmount}</p>
                                        <p class="text-right">VAT: ${invoice.vatAmount}</p>
                                        <hr>
                                        <h4 class="text-right">${invoice.billAmount}</h4>
                                        <p class="text-right">Paid: ${invoice.paidAmount}</p>
                                        <hr>
                                        <h2 class="text-right">${invoice.dueAmount}</h2>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>


        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>


    </body>

