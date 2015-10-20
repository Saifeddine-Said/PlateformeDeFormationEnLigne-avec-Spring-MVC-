<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<!-- START Template Main -->
	<section id="main" role="main">
		<!-- START page header -->

		<div class="clearfix"></div>
		<!--/ END page header -->

		<!-- START Register Content -->
		<section class="section">
			<div class="container">
				<!-- START Section Header -->
				<div class="row">
					<div class="col-md-12">
						<div class="section-header text-center">
							<h1 class="section-title font-alt mb25">ACCEDEZ A VOTRE COMPTE</h1>
						</div>
					</div>
				</div>
				<!--/ END Section Header -->

				<!-- START Row -->
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<!-- Social button -->
						<ul class="list-table mb25">
							<li><button type="button" class="btn btn-block btn-facebook">
									Connectez avec <i class="ico-facebook2 ml5"></i>
								</button></li>
							<li><button type="button" class="btn btn-block btn-twitter">
									Connectez avec <i class="ico-twitter2 ml5"></i>
								</button></li>
						</ul>
						<!-- Social button -->

						<!-- Login form -->
						<form class="panel no-border mb0" name="form-login" action="checkUser" method="POST">
							<div class="panel-body">
								<!-- Alert message -->
								<c:if test="${valid == false }">
									<div class="alert alert-danger">
										<span class="semibold">Attention :</span>&nbsp;&nbsp;Mail et / ou mot de passe est incorrecte.
									</div>
								</c:if>
								<!--/ Alert message -->

								<div class="form-group">
									<div class="form-stack has-icon pull-left">
										<input name="mail" type="text" class="form-control input-lg" placeholder="Username / email" data-parsley-errors-container="#error-container" data-parsley-error-message="Please fill in your username / email" data-parsley-required> <i class="ico-user2 form-control-icon"></i>
									</div>
									<div class="form-stack has-icon pull-left">
										<input name="password" type="password" class="form-control input-lg" placeholder="Password" data-parsley-errors-container="#error-container" data-parsley-error-message="Please fill in your password" data-parsley-required> <i class="ico-lock2 form-control-icon"></i>
									</div>
								</div>

								<!-- Error container -->
								<div id="error-container" class="mb15"></div>
								<!--/ Error container -->

								<div class="form-group">
									<div class="row">
										<div class="col-xs-6">
											<div class="checkbox custom-checkbox">
												<input type="checkbox" name="remember" id="remember" value="1"> <label for="remember">&nbsp;&nbsp;Garder ma session active</label>
											</div>
										</div>
										<div class="col-xs-6 text-right">
											<a href="javascript:void(0);">Mot de passe oubliee?</a>
										</div>
									</div>
								</div>
								<div class="form-group nm">
									<button type="submit" class="btn btn-block btn-primary">
										<span class="semibold">Connecter</span>
									</button>
								</div>
							</div>
						</form>
						<!-- Login form -->
					</div>
				</div>
				<!--/ END Row -->
			</div>
		</section>
		<!--/ END Register Content -->

		<!-- START To Top Scroller -->
		<a href="#" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
		<!--/ END To Top Scroller -->
	</section>
	<!--/ END Template Main -->

	<!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
	<!-- Application and vendor script : mandatory -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/vendor.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/frontend/app.js"></script>
	<!--/ Application and vendor script : mandatory -->

	<!-- Plugins and page level script : optional -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/smoothscroll/js/smoothscroll.js"></script>
	<!--/ Plugins and page level script : optional -->
	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>