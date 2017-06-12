<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="img/favicon_1.ico">

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

        <div class="wrapper-page animated fadeInDown">
            <div class="panel panel-color panel-primary">
                <div class="panel-heading"> 
                   <h3 class="text-center m-t-10"> Create a new Account </h3>
                </div> 

                <form:form class="form-horizontal m-t-40" action="new_registration.htm" modelAttribute="signUp" method="POST">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input class="form-control" type="email" required="true" placeholder="Email" name="email"/>
                        </div>
                    </div>
                    
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <input class="form-control " type="text" required="true" placeholder="Username" name="userName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input class="form-control " type="password" required="true" placeholder="Password" name="password"/>
                        </div>
                    </div>

 					<div class="form-group">
                        <div class="col-xs-12">
                            <input class="form-control " type="Password" required="true" placeholder="Confirm Password" name="confirmPassword"/>
                        </div>
                    </div>
                    <div class="form-group">
                     <div class="col-xs-12">
                                            <select class="form-control" id="userRole" name="userRole">
                                                <option value="Admin">Admin</option>
                                                <option value="Biller">Biller</option>
                                            </select>
                        </div>
                     </div>            
		
                    <div class="form-group ">
                        <div class="col-xs-12">
                            <label class="cr-styled">
                                <input type="checkbox" checked>
                                <i class="fa"></i> 
                                 I accept <strong><a href="#">Terms and Conditions</a></strong>
                            </label>
                        </div>
                    </div>
                    
                    <div class="form-group text-right">
                        <div class="col-xs-12">
                            <button class="btn btn-purple w-md" type="submit">Register</button>
                        </div>
                    </div>

                    <div class="form-group m-t-30">
                        <div class="col-sm-12 text-center">
                            <a href="login.htm">Already have account?</a>
                        </div>
                    </div>
				</form:form>                
            </div>
        </div>

        


           <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js" />"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js" />"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js" />"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js" />" type="text/javascript"></script>
            

        <!--common script for all pages-->
        <script src="<c:url value="/resources/theme/js/jquery.app.js" />"></script>

    
    </body>

