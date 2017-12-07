<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-ng-app="ipropel">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Register for iPropel</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="resources/font-awesome/css/font-awesome.css" />" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet"/>
    <link href="<c:url value="resources/css/style-responsive.css" />" rel="stylesheet">
    
    <!-- Angular CDN -->
    <script type="text/javascript" src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.0/angular.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="resources/js/controller.js" />"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body data-ng-controller="ipropelController">

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="${contextPath}/register.htm" method="post" style="max-width: 700px;margin: 50px auto 0;" novalidate>
		        <h2 class="form-login-heading">register now</h2>		        
		        <div class="login-wrap row">
		        
		        			<div class="col-xs-12">
		        				<div class="form-group">
		        					<span>Select Role: </span>
		        					<select class="form-control" name="userRole" data-ng-model="loginRole" data-ng-change="fetchingCompanies();">
						  				<option value="default" selected>Choose role</option>
						  				<option value="jobseeker">Job Seeker</option>
						  				<option value="recruiter">Recruiter</option>						 
									</select>
								</div>
							</div>
		       
		       			<div id="registerJobSeeker" data-ng-show="loginRole=='jobseeker'">
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="firstname">Firstname</label>
				                    <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Firstname" data-ng-model="firstname">
				                </div>
				                <div class="form-group">
				                    <label for="email">Username</label>
				                    <input type="text" class="form-control" id="username" name="username" placeholder="example" data-ng-model="username">
				                </div>
				                <div class="form-group">
				                    <label for="email">Email</label>
				                    <input type="email" class="form-control" id="email" name="email" placeholder="example@domain.com" data-ng-model="email">
				                </div>	                                              
				                
				            </div>
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="lastname">Last Name</label>
				                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Last Name" data-ng-model="lastname">
				                </div>
				                <div class="form-group">
				                    <label for="password">Password</label>
				                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" data-ng-model="password">
				                </div>
				                <div class="form-group">
				                    <label for="email">Phone</label>
				                    <input type="text" class="form-control" id="phone" name="phone" placeholder="1234567890" data-ng-model="phone">
				                </div>
				                			               
				            </div>
				            
				            <div class="col-xs-12" style="margin-bottom: 10px;">
				            	<div class="form-group">
				                    <p style="margin-bottom: 0px;"><label for="email">Top Skills</label></p>
				                   	<select style="width: 32%;margin-right: 10px;" class="form-control col-xs-4" name="skill1" data-ng-model="skill1">
						  				
						  				<option value="frontend">Front-End</option>
						  				<option value="middleware">Middleware</option>
						  				<option value="backend">Back-End</option>						 
									</select>
									<select style="width: 32%;margin-right: 10px;" class="form-control col-xs-4" name="skill2" data-ng-model="skill2">
						  				
						  				<option value="frontend">Front-End</option>
						  				<option value="middleware">Middleware</option>
						  				<option value="backend">Back-End</option>							 
									</select>
									<select style="width: 32%;" class="form-control col-xs-4" name="skill3" data-ng-model="skill3">
						  				
						  				<option value="frontend">Front-End</option>
						  				<option value="middleware">Middleware</option>
						  				<option value="backend">Back-End</option>						 
									</select>
				                </div>
				            </div>
				            
				            <div class="col-xs-12">
				            	<div class="form-group">
				                    <label for="email">About Me</label>
				                   	<textarea class="form-control" name="aboutMe" data-ng-model="aboutMe"></textarea>
				                </div>
				            </div>
				            
				            </div>
				            
				            <div id="registerJobSeeker" data-ng-show="loginRole=='recruiter'">
				            <div class="col-xs-12" style="margin-bottom: 10px;">
				            	<div class="form-group">
				                    <p style="margin-bottom: 0px;"><label for="email">Choose Company</label></p>
				                   <!-- 	<select class="form-control" data-ng-model="companyRecruiterReg" >	
				                   	data-ng-options="company in companyList"					  				
						  				<option value="default">Select Company</option>
						  				<option value="amazon">Amazon</option>
						  				<option value="facebook">Facebook</option>						 
									</select> -->
									<select class="form-control" name="companyName" data-ng-model="companyRecruiterReg" >
										<c:forEach items="${companiesList}" var="company">
                      						<option>${company.companyName}</option>
                      					</c:forEach> 								
									</select>
				                </div>
				            </div>
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="firstname">Firstname</label>
				                    <input type="text" class="form-control" name="firstnameR" id="firstnameR" placeholder="Firstname" data-ng-model="firstnameR">
				                </div>
				                <div class="form-group">
				                    <label for="email">Username</label>
				                    <input type="text" class="form-control" name="usernameR" id="usernameR" placeholder="example" data-ng-model="usernameR">
				                </div>
				                <label for="email">Email</label>
				                <div class="form-group input-group" style="margin-bottom: 0px;">				                    
				                    <input type="email" class="form-control" name="emailR" id="emailR" placeholder="example" data-ng-model="emailR">
				                    <div class="input-group-addon"><span>@{{companyRecruiterReg}}.com</span></div>
				                </div>	                                              
				                
				            </div>
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="lastname">Last Name</label>
				                    <input type="text" class="form-control" name="lastnameR" id="lastnameR" placeholder="Last Name" data-ng-model="lastnameR">
				                </div>
				                <div class="form-group">
				                    <label for="password">Password</label>
				                    <input type="password" class="form-control" name="passwordR" id="passwordR" placeholder="Password" data-ng-model="passwordR">
				                </div>
				                <div class="form-group">
				                    <label for="email">Phone</label>
				                    <input type="text" class="form-control" name="phoneR" id="phoneR" placeholder="1234567890" data-ng-model="phoneR">
				                </div>
				                			               
				            </div>
				            				            
				            </div>
				            
				            <div class="col-xs-12" style="text-align: center;">
				            	<input class="btn btn-theme" type="submit" style="width: 150px;" value="REGISTER"/>
				            </div>
				            
				            <!-- <i style="margin: 0px 5px;" class="fa fa-lock"></i> REGISTER</input> -->
		        
		        </div>		          
		
		      </form>	
		      
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


  </body>
</html>