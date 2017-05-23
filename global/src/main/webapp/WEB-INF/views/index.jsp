<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request}" />
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:59 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="/resources/theme/img/favicon_1.ico" />

        <title>Welcome To BGS</title>

        


        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css"/>"  rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

        <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css" />"rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" >
        <link href=""<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" >

        <!--Morris Chart CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/theme/assets/morris/morris.css"/>">


        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="/resources/theme/js/html5shiv.js"></script>
  <script src="/resources/theme/js/respond.min.js"></script>
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

        <div class="wrapper-page animated fadeInDown">
            <div class="panel panel-color panel-primary">
                <div class="panel-heading"> 
                   <h3 class="text-center m-t-10"> Sign In to <strong>BGS</strong> </h3>
                </div> 
                <c:url var="addAction" value="/userAunth.htm" ></c:url>
				<form:form action="${addAction}" commandName="user" cssClass="form-horizontal m-t-40">
                   
					                      
                    <div class="form-group ">
                        <div class="col-xs-12">
                        	
                        	<form:input path="userName" cssClass="form-control" placeholder="Username" />
                        </div>
                    </div>
                    <div class="form-group ">
                        
                        <div class="col-xs-12">
                        	<form:password path="password" cssClass="form-control" placeholder="Password"/>
                            <!-- <input class="form-control" type="password" placeholder="Password"> -->
                        </div>
                    </div>
						
					
						
						
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <label class="cr-styled">
                                <input type="checkbox" checked>
                                <i class="fa"></i> 
                                Remember me
                            </label>
                        </div>
                    </div>
                    
            	<c:if test="${!empty status}">
					<%String status=(String)request.getAttribute("status");
					String message=(String)request.getAttribute("message");
					if(status.equals("INVALID")){
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">Invalid user name/password</p>
							</div>
						</div>
						<%
					}
					else if(status.equals("wrongPassword")){
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">${message}</p>
							</div>
						</div>
						<%
					}
					else if(status.equals("userNotApproved")){
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">${message}</p>
							</div>
						</div>
						<%
					}
					else if(status.equals("userNameBlank")){
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">Enter user Name</p>
							</div>
						</div>
						<%
					}else if(status.equals("passwordBlank")){
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">Enter password</p>
							</div>
						</div>
						<%
					}
					else{
						%>
						<div class="form-group ">
							<div class="col-xs-12">
							<p class="text-danger">${status}</p>
							</div>
						</div>
						<%
					}
					%>
					</c:if>
                    <div class="form-group text-right">
                        <div class="col-xs-12">
                            <button class="btn btn-purple w-md" type="submit">Log In</button>
                        </div>
                    </div>
                    <div class="form-group m-t-30">
                        <div class="col-sm-7">
                            <a href="recoverpw.htm"><i class="fa fa-lock m-r-5"></i> Forgot your password?</a>
                        </div>
                        <div class="col-sm-5 text-right">
                            <a href="register.htm">Create an account</a>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>

    


        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>" ></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>" ></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>" ></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>
            

        <!--common script for all pages-->
        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>" ></script>

    
    </body>

</html>
