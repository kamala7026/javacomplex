 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<style type="text/css">
#customer_due_table tr:hover {
    cursor: pointer;
    
}

</style>

<body>
 <div class="row">
                                   
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3 class="panel-title">Filter Customer Due</h3></div>
                            <div class="panel-body">
                                <div class=" form">
					
							
							 <form:form class="cmxform form-horizontal tasi-form" id="printCustomerDetails" method="POST"  modelAttribute="customerDueSearch" action="customer_due_details.htm" novalidate="novalidate">
                                 <div class="form-group ">
                                            <label for="mfgdate" class="control-label col-lg-2">Start Date</label>
                                            <div class="col-lg-3">
                                                <input class="form-control " id="startDate" name="startDate"  path="startDate">
                                            </div>
                                               <label for="expdate" class="control-label col-lg-2">End Date </label>
                                            
                                             <div class="col-lg-3">
                                                <input class="form-control " id="endDate" name="endDate" type="text" path="endDate">
                                            </div>
                                        </div>
                                         <input type="hidden" class="form-control " id="customerId" name="customerId" type="text" value="${customerDueSearch.customerId}" path="customerId">
                                        
                                         <div class="col-lg-offset-2 col-lg-10">
                                                <button class="btn btn-success"  type="submit">Search</button>
                                            </div>
                                        </form:form>
                                </div> <!-- .form -->

                            </div> <!-- panel-body -->
                        </div> <!-- panel -->
                    </div> <!-- col -->

                </div>
        <!-- Main Content Ends -->
     

                            </body>
                            </html>