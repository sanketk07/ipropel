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
            <a href="index.html" class="logo"><b>iPropel</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-zac.jpg" />"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-divya.jpg" />"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-danro.jpg" />"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="<c:url value="resources/img/ui-sherman.jpg" />"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
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
              	  <h5 class="centered">${user.firstName} ${user.lastName}</h5>
              	  	
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
                         <li><a href="viewProfile.htm">View Profile</a></li>                    
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Jobs</span>
                      </a>
                      <ul class="sub">    
						  <li><a  href="viewMyJobs.htm">My Created Jobs</a></li>                      	                        
                          <li><a  href="redirectToCreateJobPage.htm">Create New Job</a></li>
                      </ul>
                  </li>
                   <li class="sub-menu">
                      <a href="javascript:;">
                          <i class="fa fa-book"></i>
                          <span>View Applicants</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="uploadResumePage.htm">View Applicants by Jobs</a></li>
                          <li><a  href="generateResumePage.htm">View Applicants by Skills</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-tasks"></i>
                          <span>My Messages</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="form_component.html">Form Components</a></li>
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
