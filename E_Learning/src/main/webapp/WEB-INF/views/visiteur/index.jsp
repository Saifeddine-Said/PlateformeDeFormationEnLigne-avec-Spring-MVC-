<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>

<html class="frontend">
<!-- START Head -->
<head>
<!-- START META SECTION -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Learning PFE 2015</title>
<meta name="author" content="pampersdry.info">
<meta name="description" content="Adminre is a clean and flat backend and frontend theme build with twitter bootstrap">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/image/touch/apple-touch-icon-144x144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/image/touch/apple-touch-icon-114x114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/image/touch/apple-touch-icon-72x72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/image/touch/apple-touch-icon-57x57-precomposed.png">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/image/favicon.ico">
<!--/ END META SECTION -->

<!-- START STYLESHEETS -->
<!-- Plugins stylesheet : optional -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/owl/css/owl-carousel.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugins/layerslider/css/layerslider.css">
<!--/ Plugins stylesheet : optional -->

<!-- Application stylesheet : mandatory -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/stylesheet/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/stylesheet/layout.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/stylesheet/uielement.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/stylesheet/themes/layouts/fixed-header.css">
<!--/ Application stylesheet -->

<!-- modernizr script -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/modernizr/js/modernizr.js"></script>
<!--/ modernizr script -->
<!-- END STYLESHEETS -->
</head>
<!--/ END Head -->

<!-- START Body -->
<body>
	<!-- START Template Header -->
	<header id="header" class="navbar">
		<div class="container">
			<!-- START navbar header -->
			<div class="navbar-header navbar-header-transparent">
				<!-- Brand -->
				<a class="navbar-brand" href="javascript:void(0);"> <span class="logo-figure" style="margin-left: -4px;"></span> <span class="logo-text"></span>
				</a>
				<!--/ Brand -->
			</div>
			<!--/ END navbar header -->

			<!-- START Toolbar -->
			<div class="navbar-toolbar clearfix">
				<!-- START Left nav -->
				<ul class="nav navbar-nav">
					<!-- Navbar collapse: This menu will take position at the top of template header (mobile only). Make sure that only #header have the `position: relative`, or it may cause unwanted behavior -->
					<li class="navbar-main navbar-toggle"><a href="javascript:void(0);" data-toggle="collapse" data-target="#navbar-collapse"> <span class="meta"> <span class="icon"><i class="ico-paragraph-justify3"></i></span>
						</span>
					</a></li>
					<!--/ Navbar collapse -->
				</ul>
				<!--/ END Left nav -->

				<!-- START navbar form -->
				<div class="navbar-form navbar-left dropdown" id="dropdown-form">
					<form action="" role="search">
						<div class="has-icon">
							<input type="text" class="form-control input-lg" placeholder="Chercher dans le site..."> <i class="ico-search form-control-icon"></i>
						</div>
					</form>
				</div>
				<!-- START navbar form -->

				<!-- START Right nav -->
				<ul class="nav navbar-nav navbar-right">
					<!-- Search form toggler -->

					<!--/ Search form toggler -->

					<!-- Shopping cart dropdown -->

					<!--/ Shopping cart dropdown -->
				</ul>
				<!--/ END Right nav -->

				<!-- START nav collapse -->
				<div class="collapse navbar-collapse navbar-collapse-alt" id="navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown active"><a href="#" class="dropdown-toggle dropdown-hover"> <span class="meta"> <span class="text">ACCEUIL</span>
							</span>
						</a></li>
						<li class="dropdown "><a href="#" class="dropdown-toggle dropdown-hover"> <span class="meta"> <span class="text">FORMATION</span>
							</span>
						</a></li>
						<li class="dropdown "><a href="#" class="dropdown-toggle dropdown-hover"> <span class="meta"> <span class="text">COURS</span>
							</span>
						</a></li>
						<li class="dropdown "><a href="#" class="dropdown-toggle dropdown-hover"> <span class="meta"> <span class="text">FORUM</span>
							</span>
						</a></li>
						<li><c:url value="/userLogin/" var="login" /> <a href="${login }" class="dropdown-hover"><span class="meta"> <span class="text">SE CONNECTER</span>
							</span></a></li>
						<li class="dropdown "><c:url value="/register/" var="register" /> <a href=${register } class="dropdown-toggle dropdown-hover"><span class="meta"> <span class="text">S'INSCRIRE</span>
							</span></a></li>
						<li><a href="javascript:void(0);" data-toggle="dropdown" data-target="#dropdown-form"> <span class="meta"> <span class="icon"><i class="ico-search"></i></span>
							</span>
						</a></li>
					</ul>
				</div>
				<!--/ END nav collapse -->
			</div>
			<!--/ END Toolbar -->
		</div>
	</header>
	<!--/ END Template Header -->

	<!-- START Template Main -->
	<section id="main" role="main">
		<!-- START Layerslider -->
		<section id="layerslider" style="width: 100%; height: 553px;">
			<!-- Slide #1 -->
			<div class="ls-slide" data-ls="transition2d:1; slidedelay:8000;">
				<!-- slide background -->
				<img src="<%=request.getContextPath()%>/resources/image/layerslider/bg3.png" class="ls-bg">
				<!--/ slide background -->

				<!-- Layer #1 -->
				<img class="ls-l" style="top: 90px; left: 68%;" src="<%=request.getContextPath()%>/resources/image/layerslider/layer/people2.png" data-ls="delayin:1000; easingin:easeOutElastic;">
				<!--/ Layer #1 -->

				<!-- Layer #2 -->
				<h1 class="ls-l font-alt" style="top: 110px; left: 150px;" data-ls="offsetxin:0;durationin:2000;delayin:1500;easingin:easeOutElastic;rotatexin:-90;transformoriginin:50% top 0;offsetxout:-200;durationout:1000;">
					Bienvenue à notre plateforme <span class="text-primary">E-LEARNING</span>
				</h1>
				<!--/ Layer #2 -->

				<!-- Layer #3 -->
				<h4 class="ls-l" style="top: 170px; left: 150px; width: 550px;" data-ls="offsetxin:0; durationin:2000; delayin:2000; easingin:easeOutElastic; rotatexin:90; transformoriginin:50% top 0; offsetxout:-400;">Notre plateforme vous offre des formations et des préprations aux cetifications...</h4>
				<!--/ Layer #3 -->

				<!-- Layer #4 -->
				<p class="ls-l text-default" style="top: 230px; left: 150px; width: 550px;" data-ls="offsetxin:0; durationin:2000; delayin:2500; easingin:easeOutElastic; rotatexin:90; transformoriginin:50% top 0; offsetxout:-400;">Dans notre plateforme vous pouvez suivre des cours, assister à des visioconférences, participer dans des événements organisés par les tuteurs, discuter en temps réel avec d'autres apprenants avec la présence d'un tueurs qui anime la session du chat, ...</p>
				<!--/ Layer #4 -->

				<!-- Layer #5 -->
				<a href="${register }" class="ls-l btn btn-primary" style="top: 310px; left: 150px;" data-ls="offsetxin:0; durationin:2000; delayin:3000; easingin:easeOutElastic; rotatexin:90; transformoriginin:50% top 0; offsetxout:-400;"> S'inscrire maintenant </a>
				<!--/ Layer #5 -->
			</div>
			<!-- Slide #1 -->

			<!-- Slide #2 -->
			<div class="ls-slide" data-ls="transition2d:1; slidedelay:8000;">
				<!-- slide background -->
				<img src="<%=request.getContextPath()%>/resources/image/layerslider/bg2.png" class="ls-bg" alt="Slide background">
				<!--/ slide background -->

				<!-- Layer #1 -->
				<h4 class="ls-l text-default text-right" style="top: 120px; left: 65%; width: 550px;" data-ls="easingin:easeOutElastic; delayin:0;">Plateforme Responsive &amp; Clean Design</h4>
				<!--/ Layer #1 -->

				<!-- Layer #2 -->
				<h1 class="ls-l font-alt text-right" style="top: 150px; left: 65%; width: 550px;" data-ls="easingin:easeOutElastic; delayin:500;">
					<span class="text-primary">Mobile</span> Devices Optimize
				</h1>
				<!--/ Layer #2 -->

				<!-- Layer #3 -->
				<p class="ls-l text-default text-right" style="top: 210px; left: 65%; width: 550px;" data-ls="easingin:easeOutElastic; delayin:1000;">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
				<!--/ Layer #3 -->

				<!-- Layer #5 -->
				<p class="ls-l text-default text-right" style="top: 290px; left: 65%; width: 550px;" data-ls="easingin:easeOutElastic; delayin:1500;">
					<a href="javascript:void(0);" class="btn btn-primary"> Learn More <i class="ico-angle-right ml5"></i>
					</a>
				</p>
				<!--/ Layer #5 -->

				<!-- Layer #6 -->
				<img class="ls-l" style="top: 80px; left: 250px;" src="<%=request.getContextPath()%>/resources/image/layerslider/layer/iphone-5s.png" data-ls="delayin:2000; easingin:easeOutElastic;">
				<!--/ Layer #6 -->
			</div>
			<!-- Slide #2 -->
		</section>
		<!--/ END Layerslider -->

		<!-- START Call To Action Section -->
		<section class="pt35 pb35 bgcolor-accent">
			<div class="container">
				<div class="col-sm-9">
					<h3 class="font-alt text-white nm mt3">Accedez à votre compte et commncer à apprendre.</h3>
				</div>
				<div class="mb15 visible-xs"></div>
				<div class="col-sm-3 clearfix">
					<a href="javascript:void(0);" class="btn btn-outline btn-default text-white pull-right semibold">SE CONNECTER</a>
				</div>
			</div>
		</section>
		<!-- END Call To Action Section -->

		<!-- START Features Section -->
		<section class="section bgcolor-white">
			<div class="container">
				<!-- START Section Header -->
				<div class="row">
					<div class="col-md-12">
						<div class="section-header text-center">
							<h1 class="section-title font-alt mb25">FORMATIONS</h1>
							<div class="row">
								<div class="col-md-8 col-md-offset-2">
									<h4 class="thin text-muted text-center">Les formations créees récements.</h4>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--/ END Section Header -->
				<!-- START row -->
				<div class="row">
					<c:forEach items="${formations }" var="f">
						<div class="col-md-4">
							<div class="table-layout animation" data-toggle="waypoints" data-showanim="fadeInRight" data-trigger-once="true">
								<div class="col-xs-2 valign-top">
									<img src="<c:url value="/photos/photoFormation?idFormation=${f.getIdFormation() }" />" width="100%" alt="">
								</div>
								<div class="col-xs-19 pl15">
									<h4 class="font-alt">${f.getNomFormation() }</h4>
									<p class="nm">
										<c:set var="desc" value="${f.getDescriptionFormation() }"></c:set>
										${fn:substring(desc, 0, 47) }...
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
					<!--/ END row -->
				</div>
		</section>
		<!--/ END Features Section -->

		<!-- START Recent Blog Section -->
		<section class="section">
			<div class="container">
				<!-- START Section Header -->
				<div class="row">
					<div class="col-md-12">
						<div class="section-header text-center">
							<h1 class="section-title font-alt mb25">Blog Post</h1>
						</div>
					</div>
				</div>
				<!--/ END Section Header -->

				<!-- START row -->
				<div class="row">
					<!-- Blog post #1 -->
					<div class="col-sm-4 post">
						<article class="panel no-border overflow-hidden mb0">
							<!-- Thumbnail -->
							<header class="thumbnail">
								<!-- media -->
								<div class="media">
									<!-- indicator -->
									<div class="indicator">
										<span class="spinner"></span>
									</div>
									<!--/ indicator -->
									<!-- toolbar overlay -->
									<div class="overlay">
										<div class="toolbar">
											<a href="javascript:void(0);" class="btn btn-success"><i class="ico-new-tab"></i></a>
										</div>
									</div>
									<!--/ toolbar overlay -->
									<img data-toggle="unveil" src="<%=request.getContextPath()%>/resources/image/background/blog/placeholder.jpg" data-src="<%=request.getContextPath()%>/resources/image/background/blog/blog1.jpg" alt="Photo" height="200px">
								</div>
								<!--/ media -->
							</header>
							<!--/ Thumbnail -->
							<!-- Content -->
							<section class="pa20">
								<!-- heading -->
								<h4 class="mt0 ellipsis">Lorem ipsum dolor sit amet</h4>
								<!--/ heading -->
								<!-- meta -->
								<p class="meta nm">
									<a href="javascript:void(0);">June, 2014</a>
									<!-- date -->
									<span class="text-muted mr5 ml5">&#8226;</span> <span class="text-muted">By </span><a href="javascript:void(0);">Mark Adams</a>
									<!-- author -->
								</p>
								<!--/ meta -->
							</section>
							<!--/ Content -->
						</article>
						<div class="mb15 visible-xs"></div>
					</div>
					<!--/ Blog post #1 -->

					<!-- Blog post #2 -->
					<div class="col-sm-4 post">
						<article class="panel no-border overflow-hidden mb0">
							<!-- Thumbnail -->
							<header class="thumbnail">
								<!-- media -->
								<div class="media">
									<!-- indicator -->
									<div class="indicator">
										<span class="spinner"></span>
									</div>
									<!--/ indicator -->
									<!-- toolbar overlay -->
									<div class="overlay">
										<div class="toolbar">
											<a href="javascript:void(0);" class="btn btn-success"><i class="ico-new-tab"></i></a>
										</div>
									</div>
									<!--/ toolbar overlay -->
									<img data-toggle="unveil" src="<%=request.getContextPath()%>/resources/image/background/blog/placeholder.jpg" data-src="<%=request.getContextPath()%>/resources/image/background/blog/blog2.jpg" alt="Photo" height="200px">
								</div>
								<!--/ media -->
							</header>
							<!--/ Thumbnail -->
							<!-- Content -->
							<section class="pa20">
								<!-- heading -->
								<h4 class="mt0 ellipsis">Duis aute irure dolor in reprehenderit in voluptate.</h4>
								<!--/ heading -->
								<!-- meta -->
								<p class="meta nm">
									<a href="javascript:void(0);">June, 2014</a>
									<!-- date -->
									<span class="text-muted mr5 ml5">&#8226;</span> <span class="text-muted">By </span><a href="javascript:void(0);">Jenna Howard</a>
									<!-- author -->
								</p>
								<!--/ meta -->
							</section>
							<!--/ Content -->
						</article>
						<div class="mb15 visible-xs"></div>
					</div>
					<!--/ Blog post #2 -->

					<!-- Blog post #3 -->
					<div class="col-sm-4 post">
						<article class="panel no-border overflow-hidden mb0">
							<!-- Thumbnail -->
							<header class="thumbnail">
								<!-- media -->
								<div class="media">
									<!-- indicator -->
									<div class="indicator">
										<span class="spinner"></span>
									</div>
									<!--/ indicator -->
									<!-- toolbar overlay -->
									<div class="overlay">
										<div class="toolbar">
											<a href="javascript:void(0);" class="btn btn-success"><i class="ico-new-tab"></i></a>
										</div>
									</div>
									<!--/ toolbar overlay -->
									<img data-toggle="unveil" src="<%=request.getContextPath()%>/resources/image/background/blog/placeholder.jpg" data-src="<%=request.getContextPath()%>/resources/image/background/blog/blog3.jpg" alt="Photo" height="200px">
								</div>
								<!--/ media -->
							</header>
							<!--/ Thumbnail -->
							<!-- Content -->
							<section class="pa20">
								<!-- heading -->
								<h4 class="mt0 ellipsis">Vivamus nibh dolor, nonummy ac, feugiat non, lobortis quis, pede.</h4>
								<!--/ heading -->
								<!-- meta -->
								<p class="meta nm">
									<a href="javascript:void(0);">Apr, 2014</a>
									<!-- date -->
									<span class="text-muted mr5 ml5">&#8226;</span> <span class="text-muted">By </span><a href="javascript:void(0);">Glenna Espi</a>
									<!-- author -->
								</p>
								<!--/ meta -->
							</section>
							<!--/ Content -->
						</article>
					</div>
					<!--/ Blog post #3 -->
				</div>
				<!--/ END row -->
			</div>
		</section>
		<!--/ END Recent Blog Section -->

		<!-- START Lovely Client -->
		<section class="section bgcolor-white">
			<div class="container">
				<!-- START Section Header -->
				<div class="row">
					<div class="col-md-12">
						<div class="section-header text-center">
							<h1 class="section-title font-alt mb25">Lovely Client</h1>
						</div>
					</div>
				</div>
				<!--/ END Section Header -->

				<!-- carousel -->
				<div class="owl-carousel" id="lovely-client">
					<!-- client #1 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/aztec.png" alt="Aztec Logo"></a>
					</div>
					<!--/ client #1 -->
					<!-- client #2 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/cisco.png" alt="Cisco Logo"></a>
					</div>
					<!--/ client #2 -->
					<!-- client #3 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/cocacola.png" alt="Cocacola Logo"></a>
					</div>
					<!--/ client #3 -->
					<!-- client #4 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/everyday.png" alt="Everyday Logo"></a>
					</div>
					<!--/ client #4 -->
					<!-- client #5 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/hp.png" alt="HP Logo"></a>
					</div>
					<!--/ client #5 -->
					<!-- client #6 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/natural.png" alt="Natural Logo"></a>
					</div>
					<!--/ client #6 -->
					<!-- client #7 -->
					<div class="item text-center">
						<a href="javascript:void(0);"><img src="<%=request.getContextPath()%>/resources/image/client/shell.png" alt="Shell Logo"></a>
					</div>
					<!--/ client #7 -->
				</div>
				<!--/ carousel -->
			</div>
		</section>
		<!--/ END Lovely Client -->

		<!-- START To Top Scroller -->
		<a href="#" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
		<!--/ END To Top Scroller -->
	</section>
	<!--/ END Template Main -->

	<!-- START Template Footer -->
	<footer role="contentinfo" class="bgcolor-dark pt25">
		<!-- container -->
		<div class="container mb25">
			<!-- row -->
			<div class="row">
				<!-- About -->
				<div class="col-md-4">
					<h4 class="font-alt mt0">ABOUT US</h4>
					<p>Adminre is a clean and flat backend and frontend theme build with Twitter bootstrap</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit.</p>
					<a href="javascript:void(0);" class="text-primary">Learn More</a>
				</div>
				<div class="visible-sm visible-xs" style="margin-bottom: 25px;"></div>
				<!--/ About -->

				<!-- Address + Social -->
				<div class="col-md-4" style="background: url('<%=request.getContextPath()%>/resources/image/others/map-vector.png') no-repeat center center;background-size: 100%;">
					<h4 class="font-alt mt0">ADDRESS</h4>
					<address>
						<strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br> San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123) 456-7890
					</address>
					<h4 class="font-alt mt0">STAY CONNECT</h4>
					<a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Facebook"><i class="ico-facebook2"></i></a> <a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Twitter"><i class="ico-twitter2"></i></a> <a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Vimeo"><i class="ico-vimeo"></i></a> <a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Flickr"><i class="ico-flickr2"></i></a> <a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Google+"><i class="ico-google-plus2"></i></a> <a href="javascript:void(0);" class="text-muted mr15" data-toggle="tooltip" title="Instagram"><i class="ico-instagram2"></i></a>
				</div>
				<div class="visible-sm visible-xs" style="margin-bottom: 25px;"></div>
				<!--/ Address + Social -->

				<!-- Newsletter -->
				<div class="col-md-4">
					<h4 class="font-alt mt0">NEWS LETTER</h4>
					<form role="form">
						<div class="form-group">
							<p class="form-control-static">Subscribe to our newsletter and stay up to date with the latest news and deals!</p>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" id="newsletter_email" placeholder="Enter email">
						</div>
						<button type="submit" class="btn btn-primary btn-block">Subscribe Now</button>
					</form>
				</div>
				<!--/ Newsletter -->
			</div>
			<!--/ row -->
		</div>
		<!--/ container -->

		<!-- bottom footer -->
		<div class="footer-bottom pt15 pb15 bgcolor-dark bgcolor-dark-darken10">
			<!-- container -->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<!-- copyright -->
						<p class="nm text-muted">
							&copy; Copyright 2014 by <a href="javascript:void(0);" class="text-white">Adminre</a>. All Rights Reserved.
						</p>
						<!--/ copyright -->
					</div>
					<div class="col-sm-6 text-right hidden-xs">
						<a href="javascript:void(0);" class="text-white">Privacy Policy</a> <span class="ml5 mr5">&#8226;</span> <a href="javascript:void(0);" class="text-white">Terms of Service</a>
					</div>
				</div>
			</div>
			<!--/ container -->
		</div>
		<!--/ bottom footer -->
	</footer>
	<!--/ END Template Footer -->

	<!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
	<!-- Application and vendor script : mandatory -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/vendor.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/frontend/app.js"></script>
	<!--/ Application and vendor script : mandatory -->

	<!-- Plugins and page level script : optional -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/smoothscroll/js/smoothscroll.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/owl/js/owl.carousel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layerslider/js/greensock.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layerslider/js/layerslider.transitions.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layerslider/js/layerslider.kreaturamedia.jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/frontend/home/home-v1.js"></script>
	<!--/ Plugins and page level script : optional -->
	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>