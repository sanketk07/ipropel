<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

   <title>View Your Profile</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="resources/font-awesome/css/font-awesome.css" />" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet"/>
    <link href="<c:url value="resources/css/style-responsive.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
     <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a class="logo"><b>iPropel</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
             <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="viewAllJobs.htm">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">${sessionScope.jobsList.size()}</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have ${sessionScope.jobsList.size()} Job Notifications</p>
                            </li>
                            <li>
                            <c:forEach begin="1" end="5" items="${sessionScope.jobsList}" var="job">
                                <a href="viewAllJobs.htm">
                                    <div class="task-info">
                                        <div class="desc" style="font-size: 15px;">${job.jobTitle}</div>
                                        <div>${job.jobLocation}</div>
                                    </div>              
                                </a>
                                </c:forEach>
                            </li>
                    
                            <li class="external">
                                <a href="viewAllJobs.htm">See All Jobs</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="viewReceivedMessages.htm">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">${sessionScope.messageList.size()}</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have ${sessionScope.messageList.size()} messages</p>
                            </li>
                             <c:forEach begin="1" end="5" items="${sessionScope.messageList}" var="message">
                            <li>
                                <a href="viewReceivedMessages.htm">
                                    <%-- <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-zac.jpg" />"></span> --%>
                                    <span class="subject">
                                    <span class="from">${message.messageSender}</span>
                                    <span class="time">${message.messageReceivedTime}</span>
                                    </span>
                                    <span class="message">
                                        ${message.receivedMessage}
                                    </span>
                                </a>
                            </li>
                            </c:forEach>
                            
                            <li>
                                <a href="viewReceivedMessages.htm">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="login.html">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	   <p class="centered">
              	 	<a>              	  
	              	 <c:choose>
					    <c:when test="${empty sessionScope.jobSeekerPhoto}">
					         <img src="<c:url value="resources/img/ui-sam.jpg" />" class="img-circle" width="60">
					    </c:when>
					    <c:otherwise>
					        <img src="<c:url value="${sessionScope.jobSeekerPhoto}" />" class="img-circle" width="60">
					    </c:otherwise>
					</c:choose>
              	  
              	 	</a>
              	 </p>
              	  <h5 class="centered">${sessionScope.User.firstName} ${sessionScope.User.lastName}</h5>
              	  	
                  <li class="mt">
                      <a href="viewDashboard.htm">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" class="active">
                          <i class="fa fa-desktop"></i>
                          <span>My Profile</span>
                      </a>
                      <ul class="sub">         
                         <li class="active"><a href="viewProfile.htm">View Profile</a></li>
                         <li><a href="editProfile.htm">Edit Profile</a></li>  
                         <li><a href="uploadProfilePicture.htm">Upload Profile Picture</a></li>               
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Jobs</span>
                      </a>
                      <ul class="sub">    
						  <li><a  href="viewAppliedJobs.htm">My Jobs</a></li>                      	                        
                          <li><a  href="viewAllJobs.htm">Available Jobs</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;">
                          <i class="fa fa-book"></i>
                          <span>My Resume</span>
                      </a>
                      <ul class="sub">
                          <li><a href="uploadResumePage.htm">Upload Resume</a></li>
                          <li><a href="generateResumePage.htm">Generate Resume</a></li>
                          <li><a href="viewResume.htm">View Resume</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;">
                          <i class="fa fa-tasks"></i>
                          <span>My Messages</span>
                      </a>
                      <ul class="sub">
                          <li><a href="viewReceivedMessages.htm">Received Messages</a></li>
                          <li><a href="sendMessagePageMenu.htm">Send Message</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=" fa fa-bar-chart-o"></i>
                          <span>My Statistics</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="morris.html">Morris</a></li>
                          <li><a  href="chartjs.html">Chartjs</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> My Profile</h3>
          	<div class="row mt">
          		<div class="col-lg-12">
          		

                  <div class="container">
                    <div class="row">
                    <div class="col-md-9">
                            <div class="well well-sm">
                                <div class="media">
                                    <a class="thumbnail pull-left">
                                        <img class="media-object" style="height: 100px; width: 100px;" src="<c:url value="${sessionScope.jobSeekerPhoto}"/>">
                                    </a>
                                    <div class="media-body" style="padding-left: 15px;">
                                        <h2 class="media-heading">${model.user.firstName} ${model.user.lastName}</h2>
                                        <p> <span class="glyphicon glyphicon-envelope" style="font-family: Ruda, sans-serif;"> ${model.user.email}</span> </p>
                                        <p><span class="glyphicon glyphicon-phone" style="font-family: Ruda, sans-serif;"> ${model.user.phoneNo}</span></p>
                                    <p><span class="label label-info">18 Skills</span> <span class="label label-warning">7 Projects</span></p>
                                        <p>
                                            <a href="#" class="btn btn-xs btn-default"><span class="glyphicon glyphicon-comment"></span> Message</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-9">
                            <div class="well well-sm">
                                <div class="media">
                                   
                                    <div class="media-body" style="padding: 15px;">
                                        <h3 class="media-heading">Education</h3>                                   
                                        <h5><span>Master of Science - Engineering Management, Northeastern University</span></h5>
                                        <h5><span>Bachelor of Engineering - Mechanical Engineering, University of Mumbai</span></h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-9">
                            <div class="well well-sm">
                                <div class="media">
                                   
                                    <div class="media-body" style="padding: 15px;">
                                        <h3 class="media-heading">Work Experience</h3>                                   
                                        <h5><span>Software Developer - Multinational Firm, Boson, United States</span></h5>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>

                        
                        <div class="col-md-9">
                            <div class="well well-sm">
                                <div class="media">
                                   
                                    <div class="media-body" style="padding: 15px;">
                                        <h3 class="media-heading">Jobs Applied</h3>                                   
                                        <h2>
                                            <span class="label label-warning">${model.jobsList.size()}</span>                                             
                                        </h2>
                                    </div>
                                </div>
                            </div>
                        </div>



                  </div>
                </div>







          		</div>
          	</div>
			
		</section><!--/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2017 - Sanket Kumar - INFO6250
              <a href="blank.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<c:url value="resources/js/jquery.js" />"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js" />" ></script>
    <script src="<c:url value="resources/js/jquery-ui-1.9.2.custom.min.js" />"></script>
    <script src="<c:url value="resources/js/jquery.ui.touch-punch.min.js" />"></script>
    <script class="include" type="text/javascript" src="<c:url value="resources/js/jquery.dcjqaccordion.2.7.js" />"></script>
    <script src="<c:url value="resources/js/jquery.scrollTo.min.js" />"></script>
    <script src="<c:url value="resources/js/jquery.nicescroll.js" />" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="<c:url value="resources/js/common-scripts.js" /> "></script>
    
    <!--script for this page-->
    <script src="<c:url value="resources/js/jquery-ui-1.9.2.custom.min.js" />"></script>

	<!--custom switch-->
	<script src="<c:url value="resources/js/bootstrap-switch.js" />"></script>
	
	<!--custom tagsinput-->
	<script src="<c:url value="resources/js/jquery.tagsinput.js" />"></script>
	
	<!--custom checkbox & radio-->
	
	<%-- <script type="text/javascript" src="<c:url value="resources/js/bootstrap-datepicker/js/bootstrap-datepicker.js" />"></script>
	<script type="text/javascript" src="<c:url value="resources/js/bootstrap-daterangepicker/date.js" />"></script>
	<script type="text/javascript" src="<c:url value="resources/js/bootstrap-daterangepicker/daterangepicker.js" />"></script> --%>
	
	<script type="text/javascript" src="<c:url value="resources/js/bootstrap-inputmask/bootstrap-inputmask.min.js" />"></script>
    
   <%--  <script src="<c:url value="resources/js/form-component.js" /> "></script> --%> 
    
  <!-- <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script> -->

  </body>
</html>
