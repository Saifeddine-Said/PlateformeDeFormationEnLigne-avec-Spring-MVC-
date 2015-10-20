<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html class="backend">
<!-- START Head -->
<head>
<!-- START META SECTION -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>S'inscrire</title>
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
<!--/ Application stylesheet -->

<!-- Theme stylesheet : optional -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/stylesheet/themes/theme4.css">
<!--/ Theme stylesheet : optional -->

<!-- modernizr script -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/modernizr/js/modernizr.js"></script>
<!--/ modernizr script -->
<!-- END STYLESHEETS -->

<script type="text/javascript">
	function enregistrerUser() {
		if ($("#registerForm").parsley().isValid()) {
			$.ajax({
				data : $("#registerForm").serialize(),
				url : "saveUser",
				type : "POST",
				success : function(response) {
					window.location.href="/elearning/apprenant/profile/";
				}
			});
		}
	}
</script>

</head>
<!--/ END Head -->

<!-- START Body -->
<body>
	<!-- START Template Main -->
	<section id="main" role="main">
		<!-- START Template Container -->
		<section class="container">
			<!-- START row -->
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<!-- Brand -->
					<div class="text-center" style="margin-bottom: 20px;">
						<span class=""></span> <span class=""></span>
						<h5 class="semibold text-muted mt-5">S'inscrire</h5>
					</div>
					<!--/ Brand -->

					<!-- Register form -->
					<f:form modelAttribute="user" id="registerForm" class="panel" name="form-register">
						<ul class="list-table pa15">
							<li>
								<!-- Alert message -->
								<div class="alert alert-warning nm">
									<span class="semibold">Important :</span>&nbsp;&nbsp;Veuillez remplir tous les champs.
								</div> <!--/ Alert message -->
							</li>
							<li class="text-right" style="width: 20px;"><a href="javascript:void(0);"><i class="ico-question-sign fsize16"></i></a></li>
						</ul>
						<hr class="nm">
						<div class="panel-body">
							<div class="form-group">
								<label class="control-label">Nom</label>
								<div class="has-icon pull-left">
									<f:input placeholder="Nom" class="form-control" path="nom" data-parsley-required="required" />
									<i class="ico-user2 form-control-icon"></i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Prénom</label>
								<div class="has-icon pull-left">
									<f:input placeholder="prénom" class="form-control" path="prenom" data-parsley-required="required" />
									<i class="ico-user2 form-control-icon"></i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Mot de passe</label>
								<div class="has-icon pull-left">
									<f:input path="motDePasse" placeholder="mot de passe" type="password" class="form-control" name="password" data-parsley-required="required" />
									<i class="ico-key2 form-control-icon"></i>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Confirmer mot de passe</label>
								<div class="has-icon pull-left">
									<input type="password" class="form-control" placeholder="confirmer mot de passe" name="retype-password" data-parsley-equalto="input[name=motDePasse]"> <i class="ico-asterisk form-control-icon"></i>
								</div>
							</div>
						</div>
						<hr class="nm">
						<div class="panel-body">
							<p class="semibold text-muted">Pour confirmer et activer votre compte, vous recevez un Email de validation.</p>
							<div class="form-group">
								<label class="control-label">Email</label>
								<div class="has-icon pull-left">
									<f:input path="email" type="email" class="form-control" name="email" placeholder="votre@Email.com" data-parsley-required="required" />
									<i class="ico-envelop form-control-icon"></i>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox custom-checkbox">
									<input type="checkbox" name="agree" id="agree" value="1" data-parsley-required="required"> <label for="agree">&nbsp;&nbsp;J'accepte <a class="semibold" href="javascript:void(0);">les termes d'utilisation</a></label>
								</div>
							</div>
							<div class="form-group">
								<div class="checkbox custom-checkbox">
									<input type="checkbox" name="news" id="news" value="1"> <label for="news">&nbsp;&nbsp;Recevoir des Newsletters.</label>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<button type="submit" onclick="enregistrerUser();" class="btn btn-block btn-success">
								<span class="semibold"></span>Enregistrer
							</button>
						</div>
					</f:form>
					<!-- Register form -->

					<hr>
					<!-- horizontal line -->

					<p class="text-center">
						<span class="text-muted">Vous avez deja un compte? <a class="semibold" href="<c:url value="/userLogin/" />">Connectez vous</a></span>
					</p>
				</div>
			</div>
			<!--/ END row -->
		</section>
		<!--/ END Template Container -->
	</section>
	<!--/ END Template Main -->

	<!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
	<!-- Application and vendor script : mandatory -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/vendor.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/core.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/app.js"></script>
	<!--/ Application and vendor script : mandatory -->

	<!-- Plugins and page level script : optional -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/parsley/js/parsley.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/pages/register.js"></script>
	<!--/ Plugins and page level script : optional -->
	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>