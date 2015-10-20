<%@page import="com.pfe.elearning.entities.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<%
	Utilisateur user = (Utilisateur) session.getAttribute("user");
%>
<!DOCTYPE html>
<html class="backend">
<!-- START Head -->
<head>
<!-- START META SECTION -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Learning PFE 2015</title>
<meta name="author" content="pampersdry.info">
<meta name="description" content="Adminre is a clean and flat backend and frontend theme build with twitter bootstrap">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath() %>/resources/image/touch/apple-touch-icon-144x144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/resources/image/touch/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath() %>/resources/image/touch/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/resources/image/touch/apple-touch-icon-57x57-precomposed.png">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/resources/image/favicon.ico">
<!--/ END META SECTION -->

<!-- START STYLESHEETS -->
<!-- Plugins stylesheet : optional -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/selectize/css/selectize.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/flot/css/flot.css">
<!--/ Plugins stylesheet : optional -->

<!-- Application stylesheet : mandatory -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/layout.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/uielement.css">
<!--/ Application stylesheet -->

<!-- Theme stylesheet : optional -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/themes/theme4.css">
<!--/ Theme stylesheet : optional -->

<!-- modernizr script -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/modernizr/js/modernizr.js"></script>
<!--/ modernizr script -->
<!-- END STYLESHEETS -->
</head>
<!--/ END Head -->

<!-- START Body -->
<body>
	<!-- START Template Header -->
	<header id="header" class="navbar">
		<!-- START navbar header -->
		<div class="navbar-header">
			<!-- Brand -->
			<a class="navbar-brand" href="javascript:void(0);"> <span class="logo-figure"></span> <span class="logo-text"></span>
			</a>
			<!--/ Brand -->
		</div>
		<!--/ END navbar header -->

		<!-- START Toolbar -->
		<div class="navbar-toolbar clearfix">
			<!-- START Left nav -->
			<ul class="nav navbar-nav navbar-left">
				<!-- Sidebar shrink -->
				<li class="hidden-xs hidden-sm"><a href="javascript:void(0);" class="sidebar-minimize" data-toggle="minimize" title="Minimize sidebar"> <span class="meta"> <span class="icon"></span>
					</span>
				</a></li>
				<!--/ Sidebar shrink -->

				<!-- Offcanvas left: This menu will take position at the top of template header (mobile only). Make sure that only #header have the `position: relative`, or it may cause unwanted behavior -->
				<li class="navbar-main hidden-lg hidden-md hidden-sm"><a href="javascript:void(0);" data-toggle="sidebar" data-direction="ltr" rel="tooltip" title="Menu sidebar"> <span class="meta"> <span class="icon"><i class="ico-paragraph-justify3"></i></span>
					</span>
				</a></li>
				<!--/ Offcanvas left -->

				<!-- Message dropdown -->
				<li class="dropdown custom" id="header-dd-message"><a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <span class="meta"> <span class="icon"><i class="ico-bubbles3"></i></span>
					</span>
				</a> <!-- mustache template: used for update the `.media-list` requested from server-side --> <script class="mustache-template" type="x-tmpl-mustache">
                        
                            {{#data}}
                            <a href="page-message-rich.html" class="media border-dotted new">
                                <span class="pull-left">
                                    <img src="<%=request.getContextPath() %>/resources/image/avatar/{{picture}}" class="media-object img-circle" alt="">
                                </span>
                                <span class="media-body">
                                    <span class="media-heading">{{name}}</span>
                                    <span class="media-text ellipsis nm">{{text}}</span>

                                    {{#meta.star}}<span class="media-meta"><i class="ico-star3"></i></span>{{/meta.star}}
                                    {{#meta.reply}}<span class="media-meta"><i class="ico-reply"></i></span>{{/meta.reply}}
                                    {{#meta.attachment}}<span class="media-meta"><i class="ico-attachment"></i></span>{{/meta.attachment}}
                                    <span class="media-meta pull-right">{{meta.time}}</span>
                                </span>
                            </a>
                            {{/data}}
                        
                        </script> <!--/ mustache template --> <!-- Dropdown menu -->
					<div class="dropdown-menu" role="menu">
						<div class="dropdown-header">
							<span class="title">Messages <span class="count"></span></span> <span class="option text-right"><a href="javascript:void(0);">New message</a></span>
						</div>
						<div class="dropdown-body slimscroll">
							<!-- Search form -->
							<form class="form-horizontal" action="">
								<div class="has-icon">
									<input type="text" class="form-control" placeholder="Search message..."> <i class="ico-search form-control-icon"></i>
								</div>
							</form>
							<!--/ Search form -->

							<!-- indicator -->
							<div class="indicator inline">
								<span class="spinner spinner16"></span>
							</div>
							<!--/ indicator -->

							<!-- Message list -->
							<div class="media-list">
								<a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar1.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Martina Poole</span> <span class="media-text ellipsis nm">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</span> <!-- meta icon --> <span class="media-meta"><i class="ico-reply"></i></span> <span class="media-meta"><i class="ico-attachment"></i></span> <span class="media-meta pull-right">20m</span> <!--/ meta icon -->
								</span>
								</a> <a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar3.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Walter Foster</span> <span class="media-text ellipsis nm">Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</span> <!-- meta icon --> <span class="media-meta"><i class="ico-attachment"></i></span> <span class="media-meta pull-right">21h</span> <!--/ meta icon -->
								</span>
								</a> <a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar4.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Callum Santosr</span> <span class="media-text ellipsis nm">Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</span> <!-- meta icon --> <span class="media-meta pull-right">1d</span> <!--/ meta icon -->
								</span>
								</a> <a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar5.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Noelani Blevins</span> <span class="media-text ellipsis nm">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis.</span> <!-- meta icon --> <span class="media-meta pull-right">2d</span> <!--/ meta icon -->
								</span>
								</a> <a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar8.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Carl Johnson</span> <span class="media-text ellipsis nm">Curabitur consequat, lectus sit amet luctus vulputate, nisi sem</span> <!-- meta icon --> <span class="media-meta"><i class="ico-attachment"></i></span> <span class="media-meta pull-right">2w</span> <!--/ meta icon -->
								</span>
								</a> <a href="page-message-rich.html" class="media border-dotted read"> <span class="pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" class="media-object img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading">Tamara Moon</span> <span class="media-text ellipsis nm">Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus.</span> <!-- meta icon --> <span class="media-meta"><i class="ico-attachment"></i></span> <span class="media-meta pull-right">2w</span> <!--/ meta icon -->
								</span>
								</a>
							</div>
							<!--/ Message list -->
						</div>
					</div> <!--/ Dropdown menu --></li>
				<!--/ Message dropdown -->

				<!-- Notification dropdown -->
				<li class="dropdown custom" id="header-dd-notification"><a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <span class="meta"> <span class="icon"><i class="ico-bell"></i></span> <span class="hasnotification hasnotification-danger"></span>
					</span>
				</a> <!-- mustache template: used for update the `.media-list` requested from server-side --> <script class="mustache-template" type="x-tmpl-mustache">
                        
                            {{#data}}
                            <a href="javascript:void(0);" class="media border-dotted new">
                                <span class="media-object pull-left">
                                    <i class="{{icon}}"></i>
                                </span>
                                <span class="media-body">
                                    <span class="media-text">{{{text}}}</span>
                                    <span class="media-meta pull-right">{{meta.time}}</span>
                                </span>
                            </a>
                            {{/data}}
                        
                        </script> <!--/ mustache template --> <!-- Dropdown menu -->
					<div class="dropdown-menu" role="menu">
						<div class="dropdown-header">
							<span class="title">Notification <span class="count"></span></span> <span class="option text-right"><a href="javascript:void(0);">Clear all</a></span>
						</div>
						<div class="dropdown-body slimscroll">
							<!-- indicator -->
							<div class="indicator inline">
								<span class="spinner spinner16"></span>
							</div>
							<!--/ indicator -->

							<!-- Message list -->
							<div class="media-list">
								<a href="javascript:void(0);" class="media read border-dotted"> <span class="media-object pull-left"> <i class="ico-basket2 bgcolor-info"></i>
								</span> <span class="media-body"> <span class="media-text">Duis aute irure dolor in <span class="text-primary semibold">reprehenderit</span> in voluptate.
									</span> <!-- meta icon --> <span class="media-meta pull-right">2d</span> <!--/ meta icon -->
								</span>
								</a> <a href="javascript:void(0);" class="media read border-dotted"> <span class="media-object pull-left"> <i class="ico-call-incoming"></i>
								</span> <span class="media-body"> <span class="media-text">Aliquip ex ea commodo consequat.</span> <!-- meta icon --> <span class="media-meta pull-right">1w</span> <!--/ meta icon -->
								</span>
								</a> <a href="javascript:void(0);" class="media read border-dotted"> <span class="media-object pull-left"> <i class="ico-alarm2"></i>
								</span> <span class="media-body"> <span class="media-text">Excepteur sint <span class="text-primary semibold">occaecat</span> cupidatat non.
									</span> <!-- meta icon --> <span class="media-meta pull-right">12w</span> <!--/ meta icon -->
								</span>
								</a> <a href="javascript:void(0);" class="media read border-dotted"> <span class="media-object pull-left"> <i class="ico-checkmark3 bgcolor-success"></i>
								</span> <span class="media-body"> <span class="media-text">Lorem ipsum dolor sit amet, <span class="text-primary semibold">consectetur</span> adipisicing elit.
									</span> <!-- meta icon --> <span class="media-meta pull-right">14w</span> <!--/ meta icon -->
								</span>
								</a>
							</div>
							<!--/ Message list -->
						</div>
					</div> <!--/ Dropdown menu --></li>
				<!--/ Notification dropdown -->

				<!-- Search form toggler  -->
				<li><a href="javascript:void(0);" data-toggle="dropdown" data-target="#dropdown-form"> <span class="meta"> <span class="icon"><i class="ico-search"></i></span>
					</span>
				</a></li>
				<!--/ Search form toggler -->
			</ul>
			<!--/ END Left nav -->

			<!-- START navbar form -->
			<div class="navbar-form navbar-left dropdown" id="dropdown-form">
				<form action="" role="search">
					<div class="has-icon">
						<input type="text" class="form-control" placeholder="Search application..."> <i class="ico-search form-control-icon"></i>
					</div>
				</form>
			</div>
			<!-- START navbar form -->

			<!-- START Right nav -->
			<ul class="nav navbar-nav navbar-right">
				<!-- Profile dropdown -->
				<li class="dropdown profile"><a href="javascript:void(0);" class="dropdown-toggle dropdown-hover" data-toggle="dropdown"> <span class="meta"> <span class="avatar"><img src="<c:url value="/photos/photoUserA?idUser=${user.getIdUtilisateur() }" />" class="img-circle" alt="" /></span> <span class="text hidden-xs hidden-sm pl5"><%=user.getNom() + " " + user.getPrenom()%></span> <span class="caret"></span>
					</span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="pa15">
							<h5 class="semibold hidden-xs hidden-sm">
								<p class="nm">60%</p>
								<small class="text-muted">Profile complete</small>
							</h5>
							<h5 class="semibold hidden-md hidden-lg">
								<p class="nm">Erich Reyes</p>
								<small class="text-muted">60% Profile complete</small>
							</h5>
							<div class="progress progress-xs nm mt10">
								<div class="progress-bar progress-bar-warning" style="width: 60%">
									<span class="sr-only">60% Complete</span>
								</div>
							</div>
						</li>
						<li class="divider"></li>
						<c:url value="/apprenant/profile/" var="profile" />
						<li><a href="${profile }"><span class="icon"><i class="ico-user-plus2"></i></span> Mon Compte</a></li>
						<li><a href="javascript:void(0);"><span class="icon"><i class="ico-cog4"></i></span> Parametres du compte</a></li>
						<li><a href="javascript:void(0);"><span class="icon"><i class="ico-question"></i></span> Aide</a></li>
						<li class="divider"></li>
						<li><a href="javascript:void(0);"><span class="icon"><i class="ico-exit"></i></span> Deconnexion</a></li>
					</ul></li>
				<!-- Profile dropdown -->

				<!-- Offcanvas right This menu will take position at the top of template header (mobile only). Make sure that only #header have the `position: relative`, or it may cause unwanted behavior -->
				<li class="navbar-main"><a href="javascript:void(0);" data-toggle="sidebar" data-direction="rtl" rel="tooltip" title="Feed / contact sidebar"> <span class="meta"> <span class="icon"><i class="ico-users3"></i></span>
					</span>
				</a></li>
				<!--/ Offcanvas right -->
			</ul>
			<!--/ END Right nav -->
		</div>
		<!--/ END Toolbar -->
	</header>
	<!--/ END Template Header -->

	<!-- START Template Sidebar (Left) -->
	<aside class="sidebar sidebar-left sidebar-menu">
		<!-- START Sidebar Content -->
		<section class="content slimscroll">
			<h5 class="heading">Main Menu</h5>
			<!-- START Template Navigation/Menu -->
			<ul class="topmenu topmenu-responsive" data-toggle="menu">
				<li class="active open"><c:url value="/apprenant/" var="accueil" /> <a href="${accueil }" data-target="#Accueil"> <span class="figure"><i class="ico-home"></i></span> <span class="text">Accueil</span> <span class="arrow"></span>
				</a></li>
				<li><a href="javascript:void(0);" data-target="#Mon Espaces" data-parent=".topmenu"> <span class="figure"><i class="ico-folder-open"></i></span> <span class="text">Mon Espaces</span> <span class="arrow"></span>
				</a></li>
				<li><c:url value="/apprenant/formations/MesCours" var="cours" /> <a href="${cours }" data-target="#Mes Cours" data-toggle="submenu" data-parent=".topmenu"> <span class="figure"><i class="ico-book"></i></span> <span class="text">Mes Cours</span> <span class="number"><span class="label label-success">${nbrCours}</span></span> <span class="arrow"></span>
				</a></li>
				<li><c:url value="/apprenant/formations/" var="formations" /> <a href="${formations}" data-toggle="submenu" data-target="#Formations" data-parent=".topmenu"> <span class="figure"><i class="ico-books"></i></span> <span class="text">Formations</span> <span class="arrow"></span>
				</a></li>
				<li><c:url value="/apprenant/email/" var="mail" /> <a href="${mail }" data-toggle="submenu" data-target="#Mails" data-parent=".topmenu"> <span class="figure"><i class="ico-mail2"></i></span> <span class="text">Mails</span> <span class="arrow"></span>
				</a></li>
				<li><a href="javascript:void(0);" data-toggle="submenu" data-target="#Evenements" data-parent=".topmenu"> <span class="figure"><i class="ico-file6"></i></span> <span class="text">Evenements</span> <span class="arrow"></span>
				</a></li>
				<li><a href="javascript:void(0);" data-toggle="submenu" data-target="#Forms" data-parent=".topmenu"> <span class="figure"><i class="ico-comments"></i></span> <span class="text">Forms</span> <span class="arrow"></span>
				</a></li>
				<li><a href="javascript:void(0);" data-toggle="submenu" data-target="#Visio Conferences" data-parent=".topmenu"> <span class="figure"> <i class=" ico-group"></i>
					</span> <span class="text">Visio Conferences</span> <span class="arrow"></span>
				</a></li>
				<li><a href="javascript:void(0);" data-toggle="submenu" data-target="#ChatRoom" data-parent=".topmenu"> <span class="figure"><i class="ico-bubbles10"></i></span> <span class="text">ChatRoom</span> <span class="arrow"></span>
				</a></li>
			</ul>
			<!--/ END Template Navigation/Menu -->

		</section>
		<!--/ END Sidebar Container -->
	</aside>
	<!--/ END Template Sidebar (Left) -->

	<!-- START Template Sidebar (right) -->
	<aside class="sidebar sidebar-right">
		<!-- START Offcanvas -->
		<div class="offcanvas-container" data-toggle="offcanvas" data-options='{"openerClass":"offcanvas-opener", "closerClass":"offcanvas-closer"}'>
			<!-- START Wrapper -->
			<div class="offcanvas-wrapper">
				<!-- Offcanvas Left -->
				<div class="offcanvas-left">
					<!-- Header -->
					<div class="header pl0 pr0">
						<ul class="list-table nm">
							<li style="width: 50px; height: 34px;" class="text-center"><a href="javascript:void(0);" class="text-default offcanvas-closer"><i class="ico-arrow-left6 fsize16"></i></a></li>
							<li class="text-center">
								<h5 class="semibold nm">Settings</h5>
							</li>
							<li style="width: 50px; height: 34px;" class="text-center"><a href="javascript:void(0);" class="text-default"><i class="ico-info22 fsize16"></i></a></li>
						</ul>
					</div>
					<!--/ Header -->

					<!-- Content -->
					<div class="content slimscroll">
						<h5 class="heading">News Feed</h5>
						<ul class="topmenu">
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-plus"></i></span> <span class="text">Add &amp; Manage Source</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-google-plus"></i></span> <span class="text">Google Reader</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-twitter2"></i></span> <span class="text">Twitter Source</span> <span class="arrow"></span>
							</a></li>
						</ul>

						<h5 class="heading">Friends</h5>
						<ul class="topmenu">
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-search22"></i></span> <span class="text">Find Friends</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-user-plus2"></i></span> <span class="text">Add Friends</span> <span class="arrow"></span>
							</a></li>
						</ul>

						<h5 class="heading">Account</h5>
						<ul class="topmenu">
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-user2"></i></span> <span class="text">Edit Account</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-envelop"></i></span> <span class="text">Manage Subscription</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-location6"></i></span> <span class="text">Location Service</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);"> <span class="figure"><i class="ico-switch"></i></span> <span class="text">Logout</span> <span class="arrow"></span>
							</a></li>
							<li><a href="javascript:void(0);" class="text-danger"> <span class="figure"><i class="ico-minus-circle2"></i></span> <span class="text">Deactivate</span> <span class="arrow"></span>
							</a></li>
						</ul>
					</div>
					<!--/ Content -->
				</div>
				<!--/ Offcanvas Left -->

				<!-- Offcanvas Content -->
				<div class="offcanvas-content">
					<!-- Content -->
					<div class="content slimscroll">
						<!-- START profile -->
						<div class="panel nm">
							<!-- thumbnail -->
							<div class="thumbnail">
								<!-- media -->
								<div class="media">
									<!-- indicator -->
									<div class="indicator">
										<span class="spinner"></span>
									</div>
									<!--/ indicator -->
									<img data-toggle="unveil" src="<%=request.getContextPath()%>/resources/image/background/400x250/placeholder.jpg" data-src="<%=request.getContextPath()%>/resources/image/background/400x250/background3.jpg" alt="Cover" width="100%">
								</div>
								<!--/ media -->
							</div>
							<!--/ thumbnail -->
						</div>
						<div class="panel-body text-center" style="margin-top: -55px; z-index: 11">
							<img class="img-circle mb5" src="<c:url value="/photos/photoUserA?idUser=${user.getIdUtilisateur() }" />" alt="" width="75">
							<h5 class="bold mt0 mb5"><%=user.getNom() + " " + user.getPrenom()%></h5>
							<p>Administrator</p>
							<button type="button" class="btn btn-primary offcanvas-opener offcanvas-open-ltr">
								<i class="ico-settings"></i> Settings
							</button>
						</div>
						<!--/ END profile -->

						<!-- START contact -->
						<div class="media-list media-list-contact">
							<h5 class="heading pa15 pb0">Family</h5>
							<a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar1.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Autumn Barker</span> <span class="media-meta ellipsis">Malaysia</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Giselle Horn</span> <span class="media-meta ellipsis">Bolivia</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-danger mr5"></span> Austin Shields</span> <span class="media-meta ellipsis">Timor-Leste</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-danger mr5"></span> Caryn Gibson</span> <span class="media-meta ellipsis">Libya</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar3.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Nash Evans</span> <span class="media-meta ellipsis">Honduras</span>
							</span>
							</a>

							<h5 class="heading pa15 pb0">Friends</h5>
							<a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar4.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-default mr5"></span> Josiah Johnson</span> <span class="media-meta ellipsis">Belgium</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-default mr5"></span> Philip Hewitt</span> <span class="media-meta ellipsis">Bahrain</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar5.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-default mr5"></span> Wilma Hunt</span> <span class="media-meta ellipsis">Dominica</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar6.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Noah Gill</span> <span class="media-meta ellipsis">Guatemala</span>
							</span>
							</a>

							<h5 class="heading pa15 pb0">Others</h5>
							<a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar8.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> David Fisher</span> <span class="media-meta ellipsis">French Guiana</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Samantha Avery</span> <span class="media-meta ellipsis">Jersey</span>
							</span>
							</a> <a href="javascript:void(0);" class="media offcanvas-opener offcanvas-open-rtl"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
							</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Madaline Medina</span> <span class="media-meta ellipsis">Finland</span>
							</span>
							</a>
						</div>
						<!--/ END contact -->
					</div>
					<!--/ Content -->
				</div>
				<!--/ Offcanvas Content -->

				<!-- Offcanvas Right -->
				<div class="offcanvas-right">
					<!-- Header -->
					<div class="header pl0 pr0">
						<ul class="list-table nm">
							<li style="width: 50px; height: 34px;" class="text-center"><a href="javascript:void(0);" class="text-default offcanvas-closer"><i class="ico-arrow-left6 fsize16"></i></a></li>
							<li class="text-center">
								<h5 class="semibold nm">Autumn Barker</h5>
							</li>
							<li style="width: 50px; height: 34px;" class="text-center"><a href="javascript:void(0);" class="text-default"><i class="ico-info22 fsize16"></i></a></li>
						</ul>
					</div>
					<!--/ Header -->

					<!-- Footer -->
					<div class="footer">
						<div class="has-icon">
							<input type="text" class="form-control" placeholder="Type message..."> <i class="ico-paper-plane form-control-icon"></i>
						</div>
					</div>
					<!--/ Footer -->

					<!-- Content -->
					<div class="content slimscroll">
						<!-- START chat -->
						<ul class="media-list media-list-bubble">
							<li class="media media-right"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar7.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">eros non enim commodo hendrerit.</p>
									<span class="clearfix"></span>
									<p class="media-text">Suspendisse dui.</p>
									<span class="clearfix"></span>
									<p class="media-text">eu nulla at</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Sun, Mar 02</p>
								</div></li>
							<li class="media"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar6.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">Etiam laoreet, libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat.</p>
									<span class="clearfix"></span>
									<p class="media-text">faucibus ut, nulla. Cras eu tellus</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Tue, Oct 01</p>
								</div></li>
							<li class="media media-right"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar7.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">Duis a mi fringilla mi lacinia mattis. Integer</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Fri, Sep 27</p>
								</div></li>
							<li class="media"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar6.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">Praesent interdum ligula eu enim. Etiam imperdiet dictum magna.</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Wed, Aug 28</p>
								</div></li>
							<li class="media media-right"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar7.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna.</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Sat, Sep 27</p>
								</div></li>
							<li class="media"><a href="javascript:void(0);" class="media-object"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar6.jpg" class="img-circle" alt="">
							</a>
								<div class="media-body">
									<p class="media-text">Vestibulum accumsan neque et nunc. Quisque ornare tortor at risus. Nunc ac</p>
									<span class="clearfix"></span>
									<p class="media-text">Nam porttitor scelerisque neque</p>
									<!-- meta -->
									<span class="clearfix"></span>
									<!-- important: clearing floated media text -->
									<p class="media-meta">Sun, Feb 22</p>
								</div></li>
						</ul>
						<!--/ END chat -->
					</div>
					<!--/ Content -->
				</div>
				<!--/ Offcanvas Right -->
			</div>
			<!--/ END Wrapper -->
		</div>
		<!--/ END Offcanvas -->
	</aside>
	<!--/ END Template Sidebar (right) -->

	<!-- START Template Main -->
	<section id="main" role="main">
		<!-- START Template Container -->
		<div class="container-fluid">
			<!-- START jumbotron -->
			<section class="jumbotron jumbotron-bg7 jumbotron mt-15 mb15 mr-15 ml-15" data-stellar-background-ratio="0.4" style="min-height: 320px;">
				<!-- pattern overlay -->
				<div class="pattern pattern2 overlay overlay-primary"></div>
				<!--/ pattern overlay -->
				<div class="container" style="padding-top: 8%;">
					<h1 class="thin text-white text-center font-alt">Bienvenu a nouveau ${user.getNom() } ${user.getPrenom() }</h1>
					<h4 class="thin text-white text-center">Vous pouvez reprendre vos activités...</h4>
				</div>
			</section>
			<!--/ END jumbotron -->

			<!-- START Row -->
			<div class="row">
				<!-- Left side / top side -->
				<div class="col-md-9">
					<!-- START Timeline -->
					<ul class="timeline">
						<li class="header year ellipsis">Recement</li>
						<li class="wrapper">
							<!-- START Events -->
							<ul class="events">
									<li class="wrapper">
										<div class="figure bgcolor-success">
											<i class="ico-file-plus"></i>
										</div> <!-- panel -->
										<div class="panel">
											<div class="panel-body">
												<ul class="list-table">
													<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" alt="" width="50px" height="50px"></li>
													<li class="text-left">
														<p class="mb5">
															<span class="semibold"> SAID Saifeddine</span> a cree une nouvelle formation
														</p>
														<h5 class="text-accent semibold nm">Formation ORACLE</h5>
													</li>
												</ul>
											</div>
										</div> <!--/ panel -->
									</li>
								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-user-plus"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Tamara Moon</span> assign 6 people to this project
													</p>
												</li>
											</ul>
										</div>
										<div class="panel-footer">
											<div class="img-group img-group-stack">
												<img src="<%=request.getContextPath()%>/resources/image/avatar/avatar7.jpg" class="img-circle" alt=""> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" class="img-circle" alt=""> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar4.jpg" class="img-circle" alt=""> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar5.jpg" class="img-circle" alt=""> <span class="more img-circle">2+</span>
											</div>
										</div>
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-upload22"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar5.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Emi Steele</span> update project location
													</p>
												</li>
											</ul>
										</div>
										<hr class="nm">
										<!-- horizontal line -->
										<!-- Thumbnail -->
										<div class="thumbnail thumbnail-album">
											<!-- media -->
											<div class="media">
												<!-- indicator -->
												<div class="indicator">
													<span class="spinner"></span>
												</div>
												<!--/ indicator -->
												<img data-toggle="unveil" src="<%=request.getContextPath()%>/resources/image/background/400x250/placeholder.jpg" data-src="http://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=400x200&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&sensor=false" alt="Cover" width="100%">
											</div>
											<!--/ media -->
										</div>
										<!--/ Thumbnail -->
										<!-- Toolbar -->
										<div class="panel-footer">
											<div class="panel-toolbar">
												<a href="javascript:void(0);" class="semibold text-default">Comment</a> <span class="text-muted mr5 ml5">&#8226;</span> <a href="javascript:void(0);" class="semibold text-default">Share</a>
											</div>
										</div>
										<!--/ Toolbar -->
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-bubbles2"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Tamara Moon</span> post a shoutout.
													</p>
												</li>
											</ul>
											<blockquote class="mb0">
												<p>Do your best guys as the launching ceremony is near!</p>
											</blockquote>
										</div>
									</div> <!--/ panel -->
								</li>
							</ul> <!--/ END Events -->
						</li>
						<li class="header year ellipsis">Mar 29, 2014</li>
						<li class="wrapper">
							<!-- START Events -->
							<ul class="events">
								<li class="wrapper">
									<div class="figure bgcolor-danger">
										<i class="ico-ticket"></i>
									</div> <!-- panel -->
									<div class="panel">
										<!-- ribbon -->
										<span class="panel-ribbon panel-ribbon-danger"><i class="ico-bug2"></i></span>
										<!-- ribbon -->
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar6.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Ethan Olsen</span> submit a ticket
													</p>
													<h5 class="semibold text-muted nm">#15479</h5>
												</li>
											</ul>
										</div>
										<div class="panel-footer">
											found a bug on line <strong>3011</strong> inside framework.js file. Could someone fix this?
										</div>
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-star6"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Tamara Moon</span> promoted <a href="javascript:void(0)l" class="semibold">Rudyard Miles</a> &amp; <a href="javascript:void(0)l" class="semibold">Caleb Mercado</a> as the project manager.
													</p>
												</li>
											</ul>
										</div>
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-ticket"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Denise Armstrong</span> assigned to ticket <a href="javascript:void(0);">#15479</a>
													</p>
												</li>
											</ul>
										</div>
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-primary">
										<i class="ico-pencil"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="../image/avatar/avatar2.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Denise Armstrong</span> update ticket <a href="javascript:void(0);">#15479</a> progress
													</p>
												</li>
											</ul>
										</div>
										<div class="panel-footer">
											<p class="semibold clearfix mb5">
												<span class="pull-left">Fixing framework.js</span> <span class="pull-right">70%</span>
											</p>
											<div class="progress progress-xs mb5">
												<div class="progress-bar progress-bar-success" style="width: 70%"></div>
											</div>
										</div>
									</div> <!--/ panel -->
								</li>

								<li class="wrapper">
									<div class="figure bgcolor-success">
										<i class="ico-checkmark3"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="../image/avatar/avatar2.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Denise Armstrong</span> closed ticket <a href="javascript:void(0);">#15479</a>
													</p>
												</li>
											</ul>
										</div>
									</div> <!--/ panel -->
								</li>
							</ul> <!--/ END Events -->
						</li>
						<li class="header year ellipsis">Oct 24, 2014</li>
						<li class="wrapper">
							<!-- START Events -->
							<ul class="events">
								<li class="wrapper featured">
									<div class="figure bgcolor-success">
										<i class="ico-ladder"></i>
									</div> <!-- panel -->
									<div class="panel">
										<div class="panel-body">
											<ul class="list-table">
												<li class="text-left" style="width: 60px;"><img class="img-circle" src="../image/avatar/avatar9.jpg" alt="" width="50px" height="50px"></li>
												<li class="text-left">
													<p class="nm">
														<span class="semibold">Tamara Moon</span> update project <span class="text-accent bold">"Alpha Omega"</span> overall progress
													</p>
												</li>
											</ul>
										</div>
										<div class="panel-footer">
											<p class="semibold clearfix mb5">
												<span class="pull-left">Overall</span> <span class="pull-right">65%</span>
											</p>
											<div class="progress">
												<div class="progress-bar progress-bar-success" style="width: 35%"></div>
												<div class="progress-bar progress-bar-warning" style="width: 20%"></div>
												<div class="progress-bar progress-bar-danger" style="width: 10%"></div>
											</div>
											<ul class="list-table">
												<li><i class="ico-circle text-success"></i> <span class="semibold">35%</span></li>
												<li><i class="ico-circle text-warning"></i> <span class="semibold">20%</span></li>
												<li><i class="ico-circle text-danger"></i> <span class="semibold">10%</span></li>
											</ul>
										</div>
									</div> <!--/ panel -->
								</li>
							</ul> <!--/ END Events -->
						</li>
						<li class="header text-center semibold nm"><a href="javascript:void(0);">Load more</a></li>
					</ul>
					<!--/ END Timeline -->
				</div>
				<!--/ Left side / top side -->

				<!-- Right Side / Bottom side -->
				<div class="col-md-3 hidden-xs hidden-sm">
					<div class="panel panel-minimal nm">
						<!-- START Twitter Widget -->
						<div class="panel-toolbar-wrapper">
							<div class="panel-toolbar">
								<h5 class="semibold nm text-info">
									<i class="ico-twitter mr5"></i>Twitter
								</h5>
							</div>
							<div class="panel-toolbar text-right">
								<button class="btn btn-sm btn-default">Follow</button>
							</div>
						</div>
						<div class="panel-body pt0 pb0">
							<ul class="list-table">
								<li style="width: 55px;"><img class="img-circle" src="<%=request.getContextPath()%>/resources/image/avatar/avatar9.jpg" alt="" width="45px" height="45px"></li>
								<li class="text-left">
									<h5 class="semibold ellipsis">
										Tamara Moon<br> <small class="text-muted">@tmoon</small>
									</h5>
								</li>
							</ul>
						</div>
						<ul class="nav nav-justified mt15">
							<li class="text-center">
								<h4 class="nm">12.5k</h4>
								<p class="nm text-muted">Followers</p>
							</li>
							<li class="text-center">
								<h4 class="nm">1853</h4>
								<p class="nm text-muted">Following</p>
							</li>
							<li class="text-center">
								<h4 class="nm">3451</h4>
								<p class="nm text-muted">Tweets</p>
							</li>
						</ul>
						<!--/ END Twitter Widget -->

						<hr>
						<!--horizontal line -->

						<!-- START Bio -->
						<div class="panel-toolbar-wrapper">
							<div class="panel-toolbar">
								<h5 class="semibold nm text-info">
									<i class="ico-info2 mr5"></i>About
								</h5>
							</div>
							<div class="panel-toolbar text-right">
								<button class="btn btn-sm btn-default">
									<i class="ico-pencil7"></i>
								</button>
							</div>
						</div>
						<div class="panel-body pt0">
							<p class="semibold mb5">Bio</p>
							<ul class="list-unstyled mb10">
								<li><i class="ico-briefcase text-muted mr5"></i> UI/UX Designer</li>
								<li><i class="ico-graduation text-muted mr5"></i> Studied interface design</li>
								<li><i class="ico-location text-muted mr5"></i> Lives in Sierra Leone</li>
								<li><i class="ico-home4 text-muted mr5"></i> From Perth, Australia</li>
							</ul>
							<address class="nm">
								<p class="semibold nm">Address</p>
								795 Folsom Ave, Suite 600<br> San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123) 456-7890
							</address>
						</div>
						<!--/ END Bio -->

						<hr>
						<!--horizontal line -->

						<!-- START Friend lists -->
						<div class="panel-toolbar-wrapper">
							<div class="panel-toolbar">
								<h5 class="semibold nm text-info">
									<i class="ico-users3 mr5"></i>Friend lists
								</h5>
							</div>
							<div class="panel-toolbar text-right">
								<button class="btn btn-sm btn-default">
									<i class="ico-plus"></i>
								</button>
							</div>
						</div>
						<div class="panel-body pt0">
							<div class="media-list media-list-contact">
								<a href="page-message-rich.html" class="media"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar1.jpg" class="img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Autumn Barker</span> <span class="media-meta">Sint Maarten</span>
								</span>
								</a> <a href="page-message-rich.html" class="media"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" class="img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Giselle Horn</span> <span class="media-meta">Saudi Arabia</span>
								</span>
								</a> <a href="page-message-rich.html" class="media"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-danger mr5"></span> Austin Shields</span> <span class="media-meta">Ghana</span>
								</span>
								</a> <a href="page-message-rich.html" class="media"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar.png" class="img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-danger mr5"></span> Caryn Gibson</span> <span class="media-meta">Rwanda</span>
								</span>
								</a> <a href="page-message-rich.html" class="media"> <span class="media-object pull-left"> <img src="<%=request.getContextPath()%>/resources/image/avatar/avatar3.jpg" class="img-circle" alt="">
								</span> <span class="media-body"> <span class="media-heading"><span class="hasnotification hasnotification-success mr5"></span> Nash Evans</span> <span class="media-meta">Somalia</span>
								</span>
								</a>
							</div>
							<p class="nm">
								<a href="javascript:void(0);" class="semibold">View all</a>
							</p>
						</div>
						<!--/ END Friend lists -->
					</div>
				</div>
				<!--/ Right side / bottom side -->
			</div>
			<!-- END Row -->
		</div>
		<!--/ END Template Container -->

		<!-- START To Top Scroller -->
		<a href="#" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
		<!--/ END To Top Scroller -->
	</section>
	<!--/ END Template Main -->

	<!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
	<!-- Application and vendor script : mandatory -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/vendor.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/app.js"></script>
	<!--/ Application and vendor script : mandatory -->

	<!-- Plugins and page level script : optional -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/stellar/js/jquery.stellar.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/pages/timeline-v2.js"></script>
	<!--/ Plugins and page level script : optional -->
	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>