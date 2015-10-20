<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<%@page import="com.pfe.elearning.entities.Utilisateur"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>

<%
  Utilisateur user = (Utilisateur) session.getAttribute("user");
%>

<!DOCTYPE>
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/plugins/fileupload/css/fileupload.css">
<!--/ Application stylesheet -->

<!-- Theme stylesheet : optional -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/themes/theme4.css">
<!--/ Theme stylesheet : optional -->

<!-- modernizr script -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/modernizr/js/modernizr.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/jquery-1.4.2.min.js"></script>
<!--/ modernizr script -->
<!-- END STYLESHEETS -->


<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/personalJS/espaceUtilisateur.js"></script>
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
				<li class="dropdown profile"><a href="javascript:void(0);" class="dropdown-toggle dropdown-hover" data-toggle="dropdown"> <span class="meta"> <span class="avatar"> <img src="<c:url value="/photos/photoUser?idUser=${user.getIdUtilisateur() }" />" class="img-circle" alt="" />
						</span> <span class="text hidden-xs hidden-sm pl5">${user.getNom() } ${user.getPrenom() }</span> <span class="caret"></span>
					</span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="pa15">
							<h5 class="semibold hidden-xs hidden-sm">
								<p class="nm">60%</p>
								<small class="text-muted">Profile complet</small>
							</h5>
							<h5 class="semibold hidden-md hidden-lg">
								<p class="nm">${user.getNom() }${user.getPrenom() }</p>
								<small class="text-muted">60% Profile complet</small>
							</h5>
							<div class="progress progress-xs nm mt10">
								<div class="progress-bar progress-bar-warning" style="width: 60%">
									<span class="sr-only">60% Complete</span>
								</div>
							</div>
						</li>
						<li class="divider"></li>
						<c:url value="/coordinateur/profile/" var="profileLink" />
						<li><a href="${profileLink }"><span class="icon"><i class="ico-user-plus2"></i></span> Mon Compte</a></li>
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
			<h5 class="heading">Menu Principal</h5>
			<!-- START Template Navigation/Menu -->
			<ul class="topmenu topmenu-responsive" data-toggle="menu">
				<c:url value="/coordinateur/" var="indexLink" />
				<li><a href="${indexLink }" data-target="#dashboard" data-toggle="submenu" data-parent=".topmenu"> <span class="figure"><i class="ico-dashboard2"></i></span> <span class="text">Acceuil</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/formations/" var="formationLink" />
				<li><a href="${formationLink }" data-target="#components" data-toggle="submenu" data-parent=".topmenu"> <span class="figure"> <i class="ico-screwdriver"></i>
					</span> <span class="text">Formations</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/modules/" var="moduleLink" />
				<li><a href="${moduleLink }" data-toggle="submenu" data-target="#form" data-parent=".topmenu"> <span class="figure"><i class="ico-quill2"></i></span> <span class="text">Modules</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/chapitres/" var="chapitreLink" />
				<li><a href="${chapitreLink }" data-toggle="submenu" data-target="#table" data-parent=".topmenu"> <span class="figure"><i class="ico-numbered-list"></i></span> <span class="text">Chapitres</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/contenus/" var="contenusLink" />
				<li><a href="${contenusLink }" data-toggle="submenu" data-target="#table" data-parent=".topmenu"> <span class="figure"><i class="ico-stack"></i></span> <span class="text">Contenu Chapitre</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/examens/" var="examenLink" />
				<li><a href="${examenLink }" data-toggle="submenu" data-target="#page" data-parent=".topmenu"> <span class="figure"><i class="ico-file6"></i></span> <span class="text">Examens</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/email/" var="emailLink" />
				<li><a href="${emailLink }" data-toggle="submenu" data-target="#chart" data-parent=".topmenu"> <span class="figure"><i class="ico-mail2"></i></span> <span class="text">EMail</span> <c:if test="${nbrMails > 0 }">
							<span class="number"><span class="label label-primary">${nbrMails }</span></span>
						</c:if> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/espace/" var="espaceLink" />
				<li class="active open"><a href="${espaceLink }" data-toggle="submenu" data-target="#maps" data-parent=".topmenu"> <span class="figure"> <i class="ico-folder-open"></i>
					</span> <span class="text">Mon Espace</span> <span class="arrow"></span>
				</a></li>
				<c:url value="/coordinateur/forum/" var="forumLink" />
				<li><a href="${forumLink }" data-toggle="submenu" data-target="#layout" data-parent=".topmenu"> <span class="figure"><i class="ico-question"></i></span> <span class="text">Forum</span> <span class="arrow"></span>
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
							<img class="img-circle mb5" src="<%=request.getContextPath()%>/resources/image/avatar/avatar7.jpg" alt="" width="75">
							<h5 class="bold mt0 mb5">Erich Reyes</h5>
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
			<!-- Page Header -->
			<div class="page-header page-header-block">
				<div class="page-header-section">
					<h4 class="title semibold">Mon espace</h4>

				</div>
				<div class="page-header-section">
					<!-- Toolbar -->
					<div class="toolbar clearfix">
						<div class="col-sm-2"></div>
						<div class="col-sm-5"></div>
						<div class="col-sm-5">
							<button class="btn btn-primary" data-toggle="collapse" data-target="#basic-uploader">
								<span class="ico-plus-circle2"></span> Nouveau fichier
							</button>
							<button class="btn btn-primary" data-toggle="collapse" data-target="#form-task">
								<span class="ico-plus-circle2"></span> Nouveau dossier
							</button>
						</div>
					</div>
					<!--/ Toolbar -->
				</div>
			</div>
			<div class="container-fluid">
				<!-- START Row -->
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<!--/ END Row -->

				<!-- START Row -->
				<div class="row">
					<div class="col-md-12">
						<!-- START Panel -->
						<div class="panel panel-default collapse" data-expanded="false" id="basic-uploader">
							<!-- panel header/heading -->
							<div class="panel-heading">
								<h3 class="panel-title">File Uploader</h3>
							</div>
							<!--/ panel header/heading -->
							<!-- panel body -->
							<div class="panel-body">
								<!-- error message -->
								<div class="alert alert-info">This uploader will return an error since there is no upload logic. You need to code your own upload logic.</div>

								<!-- The global progress bar -->
								<div class="progress progress-sm">
									<div class="progress-bar progress-bar-success"></div>
								</div>

								<!-- The fileinput-button span is used to style the file input field as button -->
								<div class="mb15">
									<span class="btn btn-primary fileinput-button"> <i class="glyphicon glyphicon-plus"></i> <span>Add files...</span> <!-- The file input field used as target for the file upload widget --> <input type="file" name="files[]" multiple>
									</span>
								</div>

								<!-- dropzone -->
								<div class="dropzone table-layout well mb0" style="box-shadow: none; border-style: dashed; height: 200px;">
									<div class="col-xs-11 text-center">
										<h4 class="text-muted">
											<i class="ico-file-plus2 mr5"></i> Drag and drop your file here!
										</h4>
									</div>
								</div>
							</div>
							<!--/ panel body -->

							<!-- file list -->
							<table class="table table-striped table-hovered upload-lists">
								<tbody></tbody>
							</table>
						</div>
						<!--/ END Panel -->
					</div>
				</div>
				<!-- Page Header -->
				<div class="row shuffle" id="shuffle-grid" style="position: relative; overflow: hidden; height: 476px; transition: height 250ms ease-out; -webkit-transition: height 250ms ease-out;">
					<c:forEach items="${espacesUtilisateur }" var="espace">
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 task shuffle-item filtered" data-date-due="2015-11-28" data-priority="3" style="visibility: visible; transition: transform 250ms ease-out, opacity 250ms ease-out; -webkit-transition: transform 250ms ease-out, opacity 250ms ease-out;">
							<div class="panel panel-default">
								<div class="panel-heading">
									<!-- panel toolbar -->
									<div class="panel-toolbar text-left">
										<span class="checkbox custom-checkbox custom-checkbox-inverse"> <input type="checkbox" name="customcheckbox1" id="customcheckbox1"> <label for="customcheckbox1">&nbsp;&nbsp;&nbsp;</label>
										</span>
									</div>
									<!--/ panel toolbar -->
									<h3 class="panel-title ellipsis" style="width: 100%;">
										<a href="#" class="monEspace" id="${espace.getIdEspace() }">${espace.getNomEspace() }</a>
									</h3>
								</div>
								<!-- panel body -->
								<div class="panel-body">
									<div class="row mb15">
										<div class="col-xs-12">
											<span class="text-muted">Nom : </span>&nbsp;&nbsp;&nbsp;<strong>${espace.getNomEspace() }</strong>
										</div>
									</div>
									<div class="row mb15">
										<div class="col-xs-12">
											<span class="text-muted">Description : </span>&nbsp;&nbsp;&nbsp;<strong>${espace.getDescriptionEspace() }</strong>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<span class="text-muted">Partage : </span>&nbsp;&nbsp;&nbsp;
											<c:if test="${espace.isPartage() }">
												<span class="badge badge-success">Partage</span>
											</c:if>
											<c:if test="${!espace.isPartage() }">
												<span class="badge badge-warning">Non partage</span>
											</c:if>
										</div>
										<div class="col-xs-6">
											<span class="ico-calendar3"></span>&nbsp;&nbsp;<span class="text-muted"></span>&nbsp;&nbsp;&nbsp;<strong>${espace.getDateCreation() }</strong>
										</div>
									</div>
								</div>
								<!--/ panel body -->
								<!-- panel footer -->
								<div class="panel-footer">
									<ul class="list-table">
										<li>
											<div class="img-group img-group-stack">
												<img src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" class="img-circle" alt="" title="Ori Duke"> <span class="more img-circle">5</span>
											</div>
										</li>
										<li class="text-right">
											<div class="img-group img-group-stack">
												<img src="<%=request.getContextPath()%>/resources/image/avatar/avatar2.jpg" class="img-circle" alt="" title="Ori Duke"> <span class="more img-circle">5</span>
											</div>
										</li>
									</ul>
								</div>
								<!--/ panel footer -->
							</div>
						</div>
					</c:forEach>
					<!-- Liste des fichiers -->
					<c:forEach items="${fichierEspace }" var="fichier">
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 task shuffle-item filtered" data-date-due="2015-11-28" data-priority="3" style="visibility: visible; transition: transform 250ms ease-out, opacity 250ms ease-out; -webkit-transition: transform 250ms ease-out, opacity 250ms ease-out;">
							<div class="panel panel-info">
								<div class="panel-heading">
									<!-- panel toolbar -->
									<div class="panel-toolbar text-left">
										<span class="checkbox custom-checkbox custom-checkbox-inverse"> <input type="checkbox" name="customcheckbox1" id="customcheckbox1"> <label for="customcheckbox1">&nbsp;&nbsp;&nbsp;</label>
										</span>
									</div>
									<!--/ panel toolbar -->
									<h3 class="panel-title ellipsis" style="width: 100%;">
										<a href="#" class="monEspace" id="${fichier.getIdFichier() }">${fichier.getTitreFichier() }</a>
									</h3>
								</div>
								<!-- panel body -->
								<div class="panel-body">
									<div class="row mb15">
										<div class="col-xs-12">
											<span class="text-muted">Nom : </span>&nbsp;&nbsp;&nbsp;<strong>${fichier.getTitreFichier() }</strong>
										</div>
									</div>
									<div class="row mb15">
										<div class="col-xs-12">
											<span class="text-muted">Description : </span>&nbsp;&nbsp;&nbsp;<strong>${fichier.getDescriptionFichier() }</strong>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<span class="ico-calendar3"></span>&nbsp;&nbsp;<span class="text-muted"></span>&nbsp;&nbsp;&nbsp;<strong>${fichier.getDateDepot() }</strong>
										</div>
										<div class="col-xs-6"></div>
									</div>
								</div>
								<!--/ panel body -->
								<!-- panel footer -->
								<div class="panel-footer">
									<ul class="list-table">
										<li class="text-right">
											<div class="img-group img-group-stack">
												<span class="more img-circle">1024</span>
											</div>
										</li>
									</ul>
								</div>
								<!--/ panel footer -->
							</div>
						</div>
					</c:forEach>
				</div>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/selectize/js/selectize.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.categories.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.time.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.tooltip.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/flot/js/jquery.flot.spline.js"></script>
	<!--/ Plugins and page level script : optional -->

	<!-- Plugins and page level script : optional -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/load-image.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/load-image-meta.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/load-image-exif.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/load-image-ios.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/canvas-to-blob.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/vendor/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-process.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-image.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-audio.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-video.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/fileupload/js/jquery.fileupload-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/forms/fileupload.js"></script>
	<!--/ Plugins and page level script : optional -->

	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>