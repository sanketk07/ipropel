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
     <!--main content start-->
       <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> APPLICANTS BY SKILL</h3>
          	
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
											 
											<%-- <%System.out.println("in JSP: "+session.getAttribute("messageListForPagination")); %> --%>
												<tr data-status="pagado">
													
													<td style="width: 15%;text-align: center;">
														<form action="sendMessageRecruiter.htm" method="post">
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
															
															<!-- <div class="media-body">
																<span class="media-meta pull-right"></span>
																<h4 class="title">
																	
																</h4>
																<p class="summary"></p>
															</div> -->
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

				<nav aria-label="..." style="margin-left: 80px;">
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
      </section><!-- /MAIN CONTENT -->

      
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
    
    <script>
    
    
    function fetchMessages(i) {
    	
  	  var dataPageNo = i;
    	console.log('Number from UI: '+dataPageNo);        
        
  	  
     $.ajax(
            {
                type: "GET",
                header: "application/json",
                contentType: "application/json; charset=utf-8",
                url: "getMessagesPagination.htm?pageNo="+dataPageNo,
                success: function (result) { 
                	//console.log("result--"+ JSON.stringify(result));
                	
                	//var messageReceivedTime, receivedMessage, messageRecipient, messageSender;
                	//var e = $('div.media-body');
                	/* for(var i = 0; i < result.length; i++)
                    {
                		messageReceivedTime = result[i].messageReceivedTime;
                		receivedMessage = result[i].receivedMessage;
                		messageSender = result[i].messageSender;
                		
                		console.log("messageReceivedTime"+messageReceivedTime);
                		console.log("receivedMessage"+receivedMessage);
                		console.log("messageSender"+messageSender);

                		 
                		
                        // Do something with the returned data
                        //console.log($('div.media-body'));
                        
                        
                       // $(".media-body").clone().insertAfter("div.media-body:last");
                        //$('div.media-body').last().append(new_result);
                        
                    } */
                	/* var new_result = $('div.media-body').clone();
                    new_result.children('span.media-meta').html(messageReceivedTime);
                    new_result.children('h4.title').html(messageSender);
                    new_result.children('p.summary').html(receivedMessage);
                    new_result.appendTo('div.media'); */
                }
            })
            
            /* $.each(results, function(ix, val){
			  var new_result = $('div.search_result').first().clone();
			  $(new_result).find('span.col1').html(val.col1);
			  $(new_result).find('span.col2').html(val.col2);
			  $(new_result).find('span.col3').html(val.col3);
			  $('div.search_result').last().append(new_result);
			}; */
			
			/* [{"messageReceivedTime":1492999263000,"receivedMessage":"Today is Sunday. Just over a day for the submission!","messageRecipient":"sk@gmail.com","messageId":49,"messageSender":"gs@gmail.com"},
				{"messageReceivedTime":1492705690000,"receivedMessage":"Hi!!!!!!!!!!!!","messageRecipient":"sk@gmail.com","messageId":33,"messageSender":"ap@gmail.com"},
				{"messageReceivedTime":1492670232000,"receivedMessage":"Hello Job Seeker!","messageRecipient":"sk@gmail.com","messageId":25,"messageSender":"ap@gmail.com"},
				{"messageReceivedTime":1492665776000,"receivedMessage":"The server is up!","messageRecipient":"sk@gmail.com","messageId":20,"messageSender":"gs@gmail.com"},
				{"messageReceivedTime":1492665222000,"receivedMessage":"Yo!","messageRecipient":"sk@gmail.com","messageId":18,"messageSender":"gs@gmail.com"}] */
    } 
    
    
    

   /*  function stateChange()
    {
       if ( asyncRequest.readyState == 4 && asyncRequest.status == 200 )
       {
          console.log('asyncRequest.responseText---'+asyncRequest.responseText);
       } 
    } 
   */
  
  
  </script>

    <!--script for this page-->
    
  <!-- <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script> -->

  </body>
</html>