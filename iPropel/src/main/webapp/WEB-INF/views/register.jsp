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
    margin-left: 290px;
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

#validationDiv{
	margin-top: 5px;
	background-color: #68dff0;
	color: #fff;
	padding: 10px;
	font-size: 12px;
	border-radius: 5px;
}

#validationDiv p{
	margin: 0px;
}
    
    </style>
  </head>

  <body data-ng-controller="ipropelController">

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="${contextPath}/register.htm" method="post" style="max-width: 700px;margin: 50px auto 0;" novalidate name="registerForm">
		        <h2 class="form-login-heading">register now</h2>
		        <div style="padding: 10px;">
                            <c:if test="${ not empty requestScope.registrationError}">
                                <p style="color: red;margin-bottom: 0px;">
                                    <c:out value="${requestScope.registrationError}" />
                                </p>
                            </c:if>
                        </div>		        
		        <div class="login-wrap row" id="css">
		        
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
		       
		       <!-- Changed div id -->
		       			<div id="css" data-ng-show="loginRole=='jobseeker'" class="form-section">
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="firstname">Firstname</label>
				                    <input required type="text" class="form-control" name="firstname" id="firstname" placeholder="Firstname" data-ng-model="firstname" 
				                    data-ng-pattern="/^[a-z ,.'-]+$/i">
				                    
							        <span class="ok"><span class="glyphicon glyphicon-ok"></span></span>
					            	<span class="ko"><span class="glyphicon glyphicon-remove"></span></span>
					           
						            <div id="validationDiv"  class="custom-error" data-ng-show="registerForm.firstname.$dirty && registerForm.firstname.$invalid" style="margin-top: 2px;">Invalid: 
						            	<p data-ng-show="registerForm.firstname.$error.required">Firstname is required.</span>
						            	<p data-ng-show="registerForm.firstname.$error.pattern">Firstname cannot contain numbers.</span>
				                	</div>                  
				                    
				                    
				                </div>
				                <div class="form-group">
				                    <label for="email">Username</label>
				                    <input required type="text" class="form-control" id="username" name="username" placeholder="example" data-ng-model="username"
				                    data-ng-pattern="/^[A-Za-z0-9_]{2,10}$/" data-ng-minlength="2" data-ng-maxlength="10"  >
				                    
				                    <span class="ok"><span class="glyphicon glyphicon-ok"></span></span>
					            	<span class="ko"><span class="glyphicon glyphicon-remove"></span></span>
					           
						            <div id="validationDiv" class="custom-error" data-ng-show="registerForm.username.$dirty && registerForm.username.$invalid">
						            	<p data-ng-show="registerForm.username.$error.required">Username is required.</p>
						            	<p data-ng-show="registerForm.username.$error.pattern">Username can only contain letters and/or numbers</p>
						            	<p data-ng-show="(registerForm.username.$error.minlength || registerForm.username.$error.maxlength)">Username length should be 2-10 characters.</p>
				                	</div> 
				                    
				                </div>
				                <div class="form-group">
				                    <label for="email">Email</label>
				                    <input required type="email" class="form-control" id="email" name="email" placeholder="example@domain.com" data-ng-model="email"
				                    data-ng-pattern="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i">
				                    
				                    <span class="ok"><span class="glyphicon glyphicon-ok"></span></span>
					            	<span class="ko"><span class="glyphicon glyphicon-remove"></span></span>
					           
						            <div id="validationDiv" class="custom-error" data-ng-show="registerForm.email.$dirty && registerForm.email.$invalid">
						            	<p data-ng-show="registerForm.email.$error.required">Email is required.</p>
						            	<p data-ng-show="registerForm.email.$error.pattern">Please enter a valid email of the format example@mail.com</p>						            	
				                	</div>
				                </div>	                                              
				                
				            </div>
				            <div class="col-xs-6">
				                <div class="form-group">
				                    <label for="lastname">Last Name</label>
				                    <input required type="text" class="form-control" id="lastname" name="lastname" placeholder="Last Name" data-ng-model="lastname" data-ng-pattern="/^[a-z ,.'-]+$/i">
				                    <span class="ok"><span class="glyphicon glyphicon-ok"></span></span>
					            	<span class="ko"><span class="glyphicon glyphicon-remove"></span></span>
					           
						            <div id="validationDiv"  class="custom-error" data-ng-show="registerForm.lastname.$dirty && registerForm.lastname.$invalid">Invalid: 
						            	<p data-ng-show="registerForm.lastname.$error.required">Email is required.</p>
						            	<p data-ng-show="registerForm.lastname.$error.pattern">Email cannot contain numbers.</p>
				                	</div> 
					            </div>				                
				                
				                <div class="form-group">
				                    <label for="password">Password</label>
				                    <input required type="password" class="form-control" id="password" name="password" placeholder="Password" data-ng-model="password"
				                    data-ng-pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{6,15}" data-ng-minlength="6" data-ng-maxlength="15">
				                    
				                    <span class="ok"><span class="glyphicon glyphicon-ok"></span></span>
					            	<span class="ko"><span class="glyphicon glyphicon-remove"></span></span>
					           
						            <div id="validationDiv" class="custom-error" data-ng-show="registerForm.password.$dirty && registerForm.password.$invalid">Invalid: 
						            	<p data-ng-show="registerForm.password.$error.required">Password is required.</p>
						            	<p data-ng-show="registerForm.password.$error.pattern">Password should contain Minimum 6 and Maximum 15 characters and atleast 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character.</p>
				                	</div> 
				                </div>
				                
				                <div class="form-group">
				                    <label for="email">Phone</label>
				                    <input required type="text" class="form-control" id="phone" name="phone" placeholder="1234567890" 
				                    data-ng-pattern="/^\d{10}$/" data-ng-model="phone" data-ng-minlength="10" data-ng-maxlength="10">
				                    
				                    <div id="validationDiv"  class="custom-error" data-ng-show="registerForm.phone.$dirty && registerForm.phone.$invalid">Invalid: 
						            	<p data-ng-show="(registerForm.phone.$error.minlength || registerForm.phone.$error.maxlength)">Phone number should be 10 digits long.</p>
            							<p data-ng-show="registerForm.phone.$error.pattern">Only numbers are allowed.</p>
				                	</div>
				                </div>
				                
				                			               
				            </div>
				            
				            <div class="col-xs-12" style="margin-bottom: 10px;">
				            	<div class="form-group">
				                    <p style="margin-bottom: 0px;"><label for="email">Top Skills</label></p>
									
									<select required style="width: 32%;margin-right: 10px;" class="form-control col-xs-4" name="skill1" data-ng-model="skill1">
										<option value="default">Please Choose</option>
										<c:forEach items="${model.skillsList}" var="skill">
                      						<option>${skill.skillName}</option>
                      					</c:forEach> 								
									</select>
									<select required style="width: 32%;margin-right: 10px;" class="form-control col-xs-4" name="skill2" data-ng-model="skill2">
										<option value="default">Please Choose</option>
										<c:forEach items="${model.skillsList}" var="skill">
                      						<option>${skill.skillName}</option>
                      					</c:forEach> 								
									</select>
									<select required style="width: 32%;" class="form-control col-xs-4" name="skill3" data-ng-model="skill3">
										<option value="default">Please Choose</option>
										<c:forEach items="${model.skillsList}" var="skill">
                      						<option>${skill.skillName}</option>
                      					</c:forEach> 								
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
				            
				            <div id="css" data-ng-show="loginRole=='recruiter'" class="form-section">
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
										<c:forEach items="${model.companiesList}" var="company">
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
				            	<button data-ng-disabled="registerForm.$invalid" class="btn btn-theme" type="submit" style="width: 150px;">REGISTER</button>
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