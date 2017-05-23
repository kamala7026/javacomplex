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
        <script src="<c:url value="/resources/theme/functionality/stock.js"/>"></script>

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
                                <h3 class="panel-title" style="display: inline;">Product Quantity And Its Details</h3>  
                            </div>
                            <div class="panel-body">
                                <div class="hidden-print">
                                    <div class="pull-right">
                                       
                                    </div>
                                </div>
                             <c:if test="${productDetails ==null && searchHappen=='true'}">
				                    <p class="text-danger">No Stock Available </p>
				             </c:if>  
                          <c:choose>
				             <c:when test="${productDetails!=null}">
                            <c:forEach items="${productDetails}" var="productDetail">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                        <form:form class="cmxform form-horizontal tasi-form" id="editStock" method="POST"  modelAttribute="stockDetails" action="add_stock.htm" novalidate="novalidate">
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button class="btn btn-success" type="submit">Update Product</button>
                                                <button class="btn btn-default" type="button">Cancel</button>
                                            </div>
                                        </div>
                                        <input class=" form-control" id="productId" name="productId" path="productId" type="hidden" value="${productDetail.productId}">
                                        <div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Product Name</label>
                                            <div class="col-lg-10">
                                                <input class=" form-control" id="productName" name="productName" path="productName" type="text" value="${productDetail.productName}">
                                            </div>
                                        </div>
										 <div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Available Qty</label>
                                            <div class="col-lg-10">
                                                <input class=" form-control" id="quantity" name="quantity" path="quantity" type="text" value="${productDetail.productQuantity}">
                                            </div>
                                        </div>
										 <div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Product Desc  </label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="productDescription" name="productDescription" path="productDescription" type="text" value="${productDetail.product_desc}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Batch #</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="batch" name="batch" path="batch" type="text" value="${productDetail.productBatchNo}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Mfg Date</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="mfgdate" name="mfgdate" path="mfgdate" type="text" value="${productDetail.productMfgDt}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Expiry Date</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="expdate" name="expdate" path="expdate" type="text" value="${productDetail.productExpiryDt}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Purchase Price</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="purchasePrice" name="purchasePrice" path="purchasePrice" type="text" value="${productDetail.productPurchasePrice}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Purchase Vat</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="purchaseVat" name="purchaseVat" path="purchaseVat" type="text" value="${productDetail.productPurchaseVat}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Sell Price</label>
                                            <div class="col-lg-10">
											 <input class=" form-control" id="sellingPrice" name="sellingPrice" path="sellingPrice" type="text" value="${productDetail.productSellingPrice}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Sell Vat</label>
                                            <div class="col-lg-10">
											  <input class=" form-control" id="sellingVat" name="sellingVat" path="sellingVat" type="text" value="${productDetail.productSellVat}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Location</label>
                                            <div class="col-lg-10">
											  <input class=" form-control" id="productLocation" name="productLocation" path="productLocation" type="text" value="${productDetail.productLocation}">
                                                </div>
                                        </div>
										<div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">Extra Info</label>
                                            <div class="col-lg-10">
											  <input class=" form-control" id="productExtraInfo" name="productExtraInfo" path="productExtraInfo" type="text" value="${productDetail.productExtraInfo}">
                                                </div>
                                        </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                            </c:when>
                            </c:choose>
                            </div>
                            </div>
                            </div>
                            </div>
		
                            </body>
                            </html>