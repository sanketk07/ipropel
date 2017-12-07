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

   <title>Message Inbox</title>

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
    <style type="text/css">
    
    	/*    --------------------------------------------------
	:: General
	-------------------------------------------------- */
body {
	color: #353535;
}
.content h1 {
	text-align: center;
}
.content .content-footer p {
	color: #6d6d6d;
    font-size: 12px;
    text-align: center;
}
.content .content-footer p a {
	color: inherit;
	font-weight: bold;
}

/*	--------------------------------------------------
	:: Table Filter
	-------------------------------------------------- */
.panel {
	border: 1px solid #ddd;
	background-color: #fcfcfc;
}
.panel .btn-group {
	margin: 15px 0 30px;
}
.panel .btn-group .btn {
	transition: background-color .3s ease;
}
.table-filter {
	background-color: #fff;
	border-bottom: 1px solid #eee;
}
.table-filter tbody tr:hover {
	cursor: pointer;
	background-color: #eee;
}
.table-filter tbody tr td {
	padding: 10px;
	vertical-align: middle;
	border-top-color: #eee;
}
.table-filter tbody tr.selected td {
	background-color: #eee;
}
.table-filter tr td:first-child {
	width: 38px;
}
.table-filter tr td:nth-child(2) {
	width: 35px;
}
.ckbox {
	position: relative;
}
.ckbox input[type="checkbox"] {
	opacity: 0;
}
.ckbox label {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
.ckbox label:before {
	content: '';
	top: 1px;
	left: 0;
	width: 18px;
	height: 18px;
	display: block;
	position: absolute;
	border-radius: 2px;
	border: 1px solid #bbb;
	background-color: #fff;
}
.ckbox input[type="checkbox"]:checked + label:before {
	border-color: #2BBCDE;
	background-color: #2BBCDE;
}
.ckbox input[type="checkbox"]:checked + label:after {
	top: 3px;
	left: 3.5px;
	content: '\e013';
	color: #fff;
	font-size: 11px;
	font-family: 'Glyphicons Halflings';
	position: absolute;
}
.table-filter .star {
	color: #ccc;
	text-align: center;
	display: block;
}
.table-filter .star.star-checked {
	color: #F0AD4E;
}
.table-filter .star:hover {
	color: #ccc;
}
.table-filter .star.star-checked:hover {
	color: #F0AD4E;
}
.table-filter .media-photo {
	width: 35px;
}
.table-filter .media-body {
    display: block;
    /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
}
.table-filter .media-meta {
	font-size: 11px;
	color: #999;
}
.table-filter .media .title {
	color: #2BBCDE;
	font-size: 14px;
	font-weight: bold;
	line-height: normal;
	margin: 0;
}
.table-filter .media .title span {
	font-size: .8em;
	margin-right: 20px;
}
.table-filter .media .title span.pagado {
	color: #5cb85c;
}
.table-filter .media .title span.pendiente {
	color: #f0ad4e;
}
.table-filter .media .title span.cancelado {
	color: #d9534f;
}
.table-filter .media .summary {
	font-size: 14px;
}
    </style>

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
                      <a href="javascript:;">
                          <i class="fa fa-desktop"></i>
                          <span>My Profile</span>
                      </a>
                      <ul class="sub">         
                         <li><a href="viewProfile.htm">View Profile</a></li>
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
                      <a href="javascript:;" class="active">
                          <i class="fa fa-tasks"></i>
                          <span>My Messages</span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a href="viewReceivedMessages.htm">Received Messages</a></li>
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
          	<h3><i class="fa fa-angle-right"></i> Message Inbox</h3>
          	

		<!-- BASIC FORM ELELEMNTS -->
          	<%-- <div class="row mt">
          		<div class="col-lg-12">
                  
                  <c:forEach items="${messageList}" var="message">
                      	<div class="col-md-4 col-sm-4 mb">
                      		<div class="white-panel pn donut-chart">
                      		  	<div class="row">
                      		  	
						           <div class="col-sm-6 col-xs-6 goleft">
										        
										        <p>${message.messageSender}</p>
										        <p>${message.receivedMessage}</p>
										        <p>${message.messageReceivedTime}</p>
										        
						           </div>
						           
						            <form action="sendMessagePage.htm" method="post">
							           	<input type="hidden" name="replyEmail" value="${message.messageSender}"/>
							           	<input type="submit" class="btn btn-theme" value="REPLY"/>
						           </form>
						          
	                      		</div>
							</div>
                      	</div>
                      	 </c:forEach>
                  	  
                      
                  
          		</div><!-- col-lg-12-->      	
          	</div><!-- /row --> --%>

			<div class="container">
				<div class="row">
			
					<section class="content">
						
						<div class="col-md-12" style="margin-top: 20px;">
							<div class="panel panel-default">
								<div class="panel-body">
									
									<div class="table-container">
										<table class="table table-filter">
											<tbody>
											<c:forEach items="${messageList}" var="message">
												<tr data-status="pagado">
													
													<td style="width: 15%;text-align: center;">
														<form action="sendMessagePage.htm" method="post">
												           	<input type="hidden" name="replyEmail" value="${message.messageSender}"/>
												           	<button type="submit" class="btn btn-theme"><i class="fa fa-reply"></i></button>
											           </form>
														
														
													</td>
													<td>
														<div class="media">
															<a href="#" class="pull-left">
																<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
															</a>
															<div class="media-body">
																<span class="media-meta pull-right">${message.messageReceivedTime}</span>
																<h4 class="title">
																	${message.messageSender}
																	<!-- <span class="pull-right pagado">(Pagado)</span> -->
																</h4>
																<p class="summary">${message.receivedMessage}</p>
															</div>
														</div>
													</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							
						</div>
					</section>
					
				</div>
			</div>

				



				<nav aria-label="...">
			  <ul class="pagination">
			    <li class="disabled">
			      <span>
			        <span aria-hidden="true">&laquo;</span>
			      </span>
			    </li>
			    <li onclick="fetchMessages(1);" class="active">
			      <span>1 <span class="sr-only">(current)</span></span>
			    </li>
			     <li onclick="fetchMessages(2);">
			      <span>2 <span class="sr-only">(current)</span></span>
			    </li>
			     <li onclick="fetchMessages(3);">
			      <span>3 <span class="sr-only">(current)</span></span>
			    </li>
			    <li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			    
			  </ul>
			</nav>
			
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
    
  <!-- <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script> -->
  
  <script type="text/javascript">
  $(document).ready(function () {

		$('.star').on('click', function () {
	      $(this).toggleClass('star-checked');
	    });

	   
	    $('.btn-filter').on('click', function () {
	      var $target = $(this).data('target');
	      if ($target != 'all') {
	        $('.table tr').css('display', 'none');
	        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
	      } else {
	        $('.table tr').css('display', 'none').fadeIn('slow');
	      }
	    });

	 });
  </script>
    <script>
  
  function fetchMessages(i) {
	  var dataPageNo = i;
  	console.log('Number from UI: '+dataPageNo);
	  
  $.ajax(
          {
              type: "POST",
              
              contentType: "application/json; charset=utf-8",
              url: "getMessagesPagination.htm",
              data: "{ 'pageNo': dataPageNo }",
              success: function (result) { console.log("successful!"); }
          })
  } 
  
  </script>

  </body>
</html>
