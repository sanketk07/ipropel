<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en" data-ng-app="ipropelApp">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Login to iPropel</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="resources/font-awesome/css/font-awesome.css" />" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet"/>
    <link href="<c:url value="resources/css/style-responsive.css" />" rel="stylesheet">
    
    <script type="text/javascript" src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular.min.js" />"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    
    	.form-section {
    font-size:14px;
    margin:10px 0;
}
.form-section p {
    margin:5px 0;
}
/* .form-section input:not([type='submit']) {
    height:18px;
    outline:0;
    padding:2px 4px;
    width:220px;
} */
.form-section .custom-error {
    color:#FF0000;
    font-size: 11px;
}
/* AngularJS CSS class 
     I wish use style only the input field in the 'AngularJS CSS' paragraph */
 #css span.ok, #css span.ko {
    display:none;
    margin-top: -25px;
    margin-left: 270px;
    position: absolute;
}
#css .ng-pristine {
    border:1px solid #48bcb4;
}
#css .ng-dirty.ng-valid {
    border:1px solid Green;
}
#css .ng-dirty.ng-invalid {
    border:1px solid Red;
}
#css .ng-dirty.ng-valid ~ span.ok {
    color:green;
    display:inline;
}
#css .ng-dirty.ng-invalid ~ span.ko {
    color:red;
    display:inline;
}
    
    </style>
  </head>

  <body data-ng-controller="paginationController">

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="login.htm" method="post" name="loginForm">
		        <h2 class="form-login-heading">sign in now</h2>
		        <div style="padding: 10px;">
                            <c:if test="${ not empty requestScope.loginError}">
                                <p style="color: red;margin-bottom: 0px;">
                                    <c:out value="${requestScope.loginError}" />
                                </p>
                            </c:if>
                        </div>
		        <div class="login-wrap form-section" id="css" style="margin-top: -10px;">
		            
		            	<input type="text" class="form-control" name="username" data-ng-model="username" placeholder="User ID" required autofocus>
		            	<span class="ok">
		            		<span class="glyphicon glyphicon-ok"></span>
		            	</span>
		            	<span class="ko">
		            		<span class="glyphicon glyphicon-remove"></span>
		            	</span>
		           
		            <div class="custom-error" data-ng-show="loginForm.username.$dirty && loginForm.username.$invalid" style="margin-top: 10px;">Invalid: 
		            	<span data-ng-show="loginForm.username.$error.required">Username is required.</span>
                	</div>
		            <br>
		            <div style="display: flex;">
		            <input type="password" class="form-control" name="password" data-ng-model="password" required placeholder="Password">
		            <span class="ok">
		            		<span class="glyphicon glyphicon-ok"></span>
		            	</span>
		            	<span class="ko">
		            		<span class="glyphicon glyphicon-remove"></span>
		            	</span>
		            </div>
		            <label class="checkbox">
		            
                	<div class="custom-error" data-ng-show="loginForm.password.$dirty && loginForm.password.$invalid">Invalid: 
		            	<span data-ng-show="loginForm.password.$error.required">Password is required.</span>
                	</div>
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		
		                </span>
		            </label>
		            <button data-ng-disabled="loginForm.$invalid" class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i>  SIGN IN</button>
		            <hr> 
		            
		            <!-- <div class="login-social-link centered">
		            <p>or you can sign in via your social network</p>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		                <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
		            </div> -->
		            <div class="registration">
		                <p style="margin-bottom: 0px; font-size: 12px;">Don't have an account yet?</p>
		                <a class="" href="register">
		                    Create an account
		                </a>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="btn btn-theme" type="button">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    
    <script src="<c:url value="resources/js/jquery.js" />"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js" />" ></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="<c:url value="resources/js/jquery.backstretch.min.js" />"></script>
    <script>
        $.backstretch("<c:url value="resources/img/northeastern.JPG" />", {speed: 500});
    </script>
    
    <script>
  var app = angular.module('ipropelApp', []);

  app.controller('paginationController', function($scope, $http){
  	
  	console.log('Inside paginationController');
  	
  	
  	
  	
  });
  
  </script>


  </body>
</html>