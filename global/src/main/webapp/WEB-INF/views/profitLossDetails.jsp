<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    
        <link rel="shortcut icon" href="img/favicon_1.ico">

        <title>Welcome to BGS</title>
          <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">


        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
    </head>


    <body >

            <div class="wraper container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="clearfix">
                                    <div class="pull-left">
                                        <h4 class="text-right"><i class="ion-social-buffer"></i>      BGS</h4>
                                        
                                    </div>
                                    
                                </div>
                                <hr>
                                <c:if test="${profitLossDetails ==null  && searchHappen=='true'}">
				                    <p class="text-danger">No transaction found  </p>
				             </c:if>
				             <c:if test="${profitLossDetails !=null  && searchHappen=='true'}">
                                       <div class="row" id="due" style="margin-top: 10px; ">
                                    <div class="col-md-12">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
												<th>Date</th>
												<th>Profit Amount</th>
                                                </tr></thead>
                                                <tbody>
                                                <c:forEach items="${profitLossDetails}" var="profitLoss">
                                                    <tr>
                                                    <td>${profitLoss.day}</td>
													<td><fmt:formatNumber value="${profitLoss.amount}"  pattern="#,##,##,##,#,##.00" type="currency"/></td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                </c:if>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>


        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>


    </body>

