<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:59 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Welcome To Jasper</title>

        


    </head>


    <body>
    <a href="<c:url value="/employeereportPDF"/>" target="_blank"><b>Generate PDF Report</b></a></br>
    <a href="<c:url value="/employeereportHTML"/>" target="_blank"><b>Generate HTML Report</b></a>

    </body>

</html>
