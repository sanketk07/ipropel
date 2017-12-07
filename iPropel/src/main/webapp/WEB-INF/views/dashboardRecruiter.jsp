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

   <title>Welcome to iPropel</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="resources/font-awesome/css/font-awesome.css" />" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet"/>
    <link href="<c:url value="resources/css/style-responsive.css" />" rel="stylesheet">
    <%-- <link rel="stylesheet" type="text/css" href="<c:url value="resources/js/gritter/css/jquery.gritter.css" />" /> --%>
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/lineicons/style.css" />">    
    
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="resources/css/style-responsive.css" />" rel="stylesheet">

    <script src="<c:url value="resources/js/chart-master/Chart.js" />"></script>   

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
                                <a href="viewReceivedMessagesRecruiter.htm">
                                    <%-- <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-zac.jpg" />"></span>--%>
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
                            
                           <%--  <c:forEach var="i" begin="${sessionScope.messageList.size()}" end="${sessionScope.messageList.size()-5}" step="1" items="${sessionScope.messageList}">
							   <c:var var="message" value="${sessionScope.messageList.size()-i}">
							   <li>
                                <a href="viewReceivedMessages.htm">
                                    <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-zac.jpg" />"></span>
                                    <span class="subject">
                                    <span class="from">${message.messageSender}</span>
                                    <span class="time">${message.messageReceivedTime}</span>
                                    </span>
                                    <span class="message">
                                        ${message.receivedMessage}
                                    </span>
                                </a>
                            </li>
                            </c:var>
							    
							</c:forEach> --%>
                            
                            <li>
                                <a href="viewReceivedMessagesRecruiter.htm">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="logout.htm">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="<c:url value="resources/img/ui-sam.jpg" />" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">${sessionScope.User.firstName} ${sessionScope.User.lastName}</h5>
              	  	
                  <li class="mt">
                      <a href="viewRecDashboard.htm"  class="active">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;">
                          <i class="fa fa-desktop"></i>
                          <span>My Profile</span>
                      </a>
                      <ul class="sub">         
                         <li><a href="viewRecDashboard.htm">View Profile</a></li>                    
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Jobs</span>
                      </a>
                      <ul class="sub">    
						  <li><a  href="viewMyCreatedJobs.htm">My Created Jobs</a></li>                      	                        
                          <li><a  href="redirectToCreateJobPage.htm">Create New Job</a></li>
                      </ul>
                  </li>
                   <li class="sub-menu">
                      <a href="javascript:;">
                          <i class="fa fa-book"></i>
                          <span>View Applicants</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="viewJobSeekersByJobsRecruiter.htm">View Applicants by Jobs</a></li>
                          <li><a  href="redirectToChooseSkill.htm">View Applicants by Skills</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu"><a href="javascript:;">
							<i class="fa fa-tasks"></i> <span>My Messages</span>
					</a>
						<ul class="sub">
							<li><a href="viewMessagesRecruiter.htm">View Messages</a></li>
							<li><a href="sendMessageFromRecruiter.htm">Send Message</a></li>
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
     <c:set var="contextPath" value="${pageContext.request.contextPath}" />
      <!--main content start--> 
      <section id="main-content">
          <section class="wrapper">

              <div class="row">
                  <div class="col-lg-9 main-chart">
                  
                  	<div class="row mtbox">
                  		<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                  			<div class="box1">
					  			<span class="li_heart"></span>
					  			<h3>80</h3>
                  			</div>
					  			<p>80 Java Job Opportunities posted in the last 24hs.</p>
                  		</div>
                  		<div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_cloud"></span>
					  			<h3>60</h3>
                  			</div>
					  			<p>60 Cloud Job Opportunities posted in the last 24hs.</p>
                  		</div>
                  		<div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_stack"></span>
					  			<h3>92</h3>
                  			</div>
					  			<p>92 Business Analyst Job Opportunities posted in the last 24hs.</p>
                  		</div>
                  		<div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_news"></span>
					  			<h3>67</h3>
                  			</div>
					  			<p>67 Data Scientist Job Opportunities posted in the last 24hs.</p>
                  		</div>
                  		<div class="col-md-2 col-sm-2 box0">
                  			<div class="box1">
					  			<span class="li_data"></span>
					  			<h3>48</h3>
                  			</div>
					  			<p>48 Database Job Opportunities posted in the last 24hs.</p>
                  		</div>
                  	
                  	</div><!-- /row mt -->	
                  
                      
                      <div class="row mt">
                      <div><h1 style="margin-left: 10px;margin-bottom: 20px;">RECRUITER DASHBOARD</h1></div>
                      <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb">
                      		<div class="white-panel donut-chart">
                      		  	<div class="row">
									<div class="goleft" style="padding: 10px;">
										<p><i class="fa fa-calendar"></i> 04/09/2017 </p>
										<p><i class="fa fa-briefcase"></i>Software Developer</p>
										<p><i class="fa fa-users"></i>Internship</p>
										<p><i class="fa fa-institution"></i>Google Inc.</p>
										<p><i class="fa fa-map-marker"></i>Cambridge, MA</p>
									</div>
	                      		</div>
							</div>
                      	</div>

                        <div class="col-md-4 col-sm-4 mb">
                          <div class="white-panel donut-chart">
                      		  	<div class="row">
									<div class="goleft" style="padding: 10px;">
										<p><i class="fa fa-calendar"></i> 04/09/2017 </p>
										<p><i class="fa fa-briefcase"></i>Software Developer</p>
										<p><i class="fa fa-users"></i>Internship</p>
										<p><i class="fa fa-institution"></i>Google Inc.</p>
										<p><i class="fa fa-map-marker"></i>Cambridge, MA</p>
									</div>
	                      		</div>
							</div>
                        </div>

                        <div class="col-md-4 col-sm-4 mb">
                          <div class="white-panel donut-chart">
                      		  	<div class="row">
									<div class="goleft" style="padding: 10px;">
										<p><i class="fa fa-calendar"></i> 04/09/2017 </p>
										<p><i class="fa fa-briefcase"></i>Software Developer</p>
										<p><i class="fa fa-users"></i>Internship</p>
										<p><i class="fa fa-institution"></i>Google Inc.</p>
										<p><i class="fa fa-map-marker"></i>Cambridge, MA</p>
									</div>
	                      		</div>
							</div>
                        </div>

                        <div class="col-md-4 col-sm-4 mb">
                          <div class="white-panel pn donut-chart">
                            <div class="row">
                             <div class="col-sm-6 col-xs-6 goleft">
                                <p><i class="fa fa-briefcase"></i> 04/06/2017</p>
                             </div>
                            </div>
                          </div>
                        </div>

                        <div class="col-md-4 col-sm-4 mb">
                          <div class="white-panel pn donut-chart">
                            <div class="row">
                             <div class="col-sm-6 col-xs-6 goleft">
                                <p><i class="fa fa-briefcase"></i> 04/05/2017</p>
                             </div>
                            </div>
                          </div>
                        </div>

                        <div class="col-md-4 col-sm-4 mb">
                          <div class="white-panel pn donut-chart">
                            <div class="row">
                             <div class="col-sm-6 col-xs-6 goleft">
                                <p><i class="fa fa-briefcase"></i> 04/04/2017</p>
                             </div>
                            </div>
                          </div>
                        </div>
						
					</div><!-- /row -->
					
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->
                  
                  
      <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->                  
                  
                  <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
						<h3>SUGGESTED JOBS</h3>
                                        
                      <!-- First Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>2 Minutes Ago</muted><br/>
                      		   <a href="#">James Brown</a> subscribed to your newsletter.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Second Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>3 Hours Ago</muted><br/>
                      		   <a href="#">Diana Kennedy</a> purchased a year subscription.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Third Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>7 Hours Ago</muted><br/>
                      		   <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fourth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>11 Hours Ago</muted><br/>
                      		   <a href="#">Mark Twain</a> commented your post.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fifth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18 Hours Ago</muted><br/>
                      		   <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                      		</p>
                      	</div>
                      </div>                             
                  </div><!-- /col-lg-3 -->
              </div><!--/row -->
          </section>
      </section>

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
    <script src="<c:url value="resources/js/jquery-1.8.3.min.js" />"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js" />" ></script>
    <script class="include" type="text/javascript" src="<c:url value="resources/js/jquery.dcjqaccordion.2.7.js" />"></script>
    <script src="<c:url value="resources/js/jquery.scrollTo.min.js" />"></script>
    <script src="<c:url value="resources/js/jquery.nicescroll.js" />" type="text/javascript"></script>	    
    <script src="<c:url value="resources/js/jquery.sparkline.js" />"></script>    

    <!--common script for all pages-->
    <script src="<c:url value="resources/js/common-scripts.js" />"></script>
    
    <script type="text/javascript" src="<c:url value="resources/js/gritter/js/jquery.gritter.js" />"></script>
    <script type="text/javascript" src="<c:url value="resources/js/gritter-conf.js" />"></script>

    <!--script for this page-->
    <script src="<c:url value="resources/js/sparkline-chart.js" />"></script>    
	<script src="<c:url value="resources/js/zabuto_calendar.js" />"></script>	
	
	<script type="application/javascript">
              
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>  

  </body>
</html>
