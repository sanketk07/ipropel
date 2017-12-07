<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Welcome to iPropel</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="resources/css/bootstrap.css" />"
	rel="stylesheet">
<!--external css-->
<link
	href="<c:url value="resources/font-awesome/css/font-awesome.css" />"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="<c:url value="resources/css/style.css" />" rel="stylesheet" />
<link href="<c:url value="resources/css/style-responsive.css" />"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>iPropel</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
				<!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="viewMessagesAdmin.htm">
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
                                <a href="viewMessagesAdmin.htm">See all messages</a>
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
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">
						<a href="profile.html"><img src="<c:url value="resources/img/ui-sam.jpg" />" class="img-circle" width="60"></a>
					</p>
					<h5 class="centered">${sessionScope.User.firstName} ${sessionScope.User.lastName}</h5>

					<li class="mt"><a href="viewDashboardAdmin.htm"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>

					<li class="sub-menu"><a href="addCompany.htm"> <i
							class="fa fa-desktop"></i> <span>Add Company</span>
					</a></li>

					<li class="sub-menu"><a href="viewJobSeekers.htm"> <i
							class="fa fa-cogs"></i> <span>View Job Seekers</span>
					</a></li>
					<li class="sub-menu"><a href="viewRecruiters.htm"> <i
							class="fa fa-book"></i> <span>View Recruiters</span>
					</a></li>
					
					<li class="sub-menu"><a href="viewCompanies.htm"> <i
							class="fa fa-book"></i> <span>View Companies</span>
					</a>
					</li>
					
					<li class="sub-menu"><a href="javascript:;" class="active">
							<i class="fa fa-tasks"></i> <span>My Messages</span>
					</a>
						<ul class="sub">
							<li><a href="viewMessagesAdmin.htm">View Messages</a></li>
							<li class="active"><a href="sendMessageAdmin.htm">Send Message</a></li>
						</ul>
					</li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-bar-chart-o"></i> <span>My Statistics</span>
					</a>
						<ul class="sub">
							<li><a href="morris.html">Morris</a></li>
							<li><a href="chartjs.html">Chartjs</a></li>
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
			<section class="wrapper">

				<div class="row mt">
					<div class="text-center">
						<h1>SEND MESSAGE</h1>
					</div>
					
					<form class="form-horizontal style-form" method="post" action="sendMessageToUser.htm">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">User Email</label>
                              <div class="col-sm-10">
                                  <input class="form-control" type="email" name="userEmail" data-ng-model="userEmail" value="${param.recipientEmail}">
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Message</label>
                              <div class="col-sm-10">
                                  <textarea class="form-control" placeholder="Message" name="userMessageFromAdmin" data-ng-model="userMessageFromAdmin"></textarea>
                              </div>
                          </div> 
                          
                          <input type="submit" class="btn btn-theme" value="Send Message">
                      </form>

				</div>
				<!-- /row -->

			</section>
		</section>

		<!--main content end-->


		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				2017 - Sanket Kumar - INFO6250 <a href="blank.html#" class="go-top">
					<i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value="resources/js/jquery.js" />"></script>
	<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="resources/js/jquery-ui-1.9.2.custom.min.js" />"></script>
	<script
		src="<c:url value="resources/js/jquery.ui.touch-punch.min.js" />"></script>
	<script class="include" type="text/javascript"
		src="<c:url value="resources/js/jquery.dcjqaccordion.2.7.js" />"></script>
	<script src="<c:url value="resources/js/jquery.scrollTo.min.js" />"></script>
	<script src="<c:url value="resources/js/jquery.nicescroll.js" />"
		type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="<c:url value="resources/js/common-scripts.js" /> "></script>

	<!--script for this page-->

	<!-- <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script> -->

</body>
</html>
