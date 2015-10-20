
<%@page import="com.pfe.elearning.entities.Coordinateur"%>
<%@page import="com.pfe.elearning.entities.Module"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="true"%>
<%@page import="com.pfe.elearning.entities.Utilisateur"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>

<%
  Utilisateur user = (Utilisateur) session.getAttribute("user");
  boolean isCreateur=false;
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
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/jquery-1.4.2.min.js"></script>
<script type="text/javascript">

	var nbrContenu=0;
	var idChapitre=0;
	var idModule=0;
	var idFormation=0;
	var indexFormation;
	var nomFormation;
	
	$("document").ready(function() {
		$("#labelModule").hide();
		$("#moduleSelect").hide();
		
		$("#chapitreSelect").hide();
		$("#labelChapitre").hide();
		
		$("#editorForm").hide();
		
		$("#contenuSelect").hide();
		$("#labelContenu").hide();
		
		$("#btnNew").hide();
	});
	
		function loadListOfModule(){
			//selectFormationADD 
			//$("#formationSelect").val('1').attr('selected',true);
			//$("#selectFormationADD").selectedIndex=indexFormation;
			var index = $("#formationSelect")[0].selectedIndex;
			idFormation=index;
			$("#selectFormationADD").val(index).attr('selected',true); //disabled="disabled">
			$("#selectFormationADD").val(index).attr('disabled','disabled');
			$("#moduleSelect").animate( { "opacity": "show"} , 500 ); 
			$("#labelModule").animate( { "opacity": "show"} , 500 );
			if (index > 0) {
				nomFormation=$("#formationSelect").find(":selected").text();
				$.getJSON("listModuleParFormation", {
					idFormation : $("#formationSelect").val(),
					ajax : "true"
				}, function(data) {
					if (data.length > 0) {
						$("#moduleSelect option").remove();
						$("#moduleSelectAdd option").remove();
					}
					else
					{	
						var img="<img class='img-rounded img-bordered-primary' src='<%=request.getContextPath()%>/coordinateur/formations/photoFormation?idFormation="+$("#formationSelect").val()+"' alt='' width='80px' height='80px' />";
						$("#blocImgModule").html(img);
						$("#nomFor").html($("#formationSelect").find(":selected").text());
						$("#bs-modal-sm-module").modal('show');  
					}
					var html = "<option value=''>Selectionner un module</option>";
					for (var i = 0; i < data.length; i++) {
						html += "<option value='"+data[i].idModule+"'>"
								+ data[i].nomModule + "</option>";
					}
					$("#moduleSelect").html(html);
					$("#moduleSelectAdd").html(html);
				//	$("#moduleSelectAdd").val(index).attr('selected',true);
				//	$("#moduleSelectAdd").val(index).attr('disabled','disabled');
 				});
			}
			else
				{
					$("#moduleSelect").animate( { "opacity": "hide"} , 500 ); 
					$("#labelModule").animate( { "opacity": "hide"} , 500 );
					
					$("#chapitreSelect").hide();
					$("#labelChapitre").hide();
					
					$("#editorForm").hide();
					
					$("#contenuSelect").hide();
					$("#labelContenu").hide();
				}
		}
	function loadListOfChapitre(){
				
				var index = $("#moduleSelect")[0].selectedIndex; 
				var valueSelected=$("#moduleSelect").val();
				$("#moduleSelectAdd").val(valueSelected).attr('selected',true);
				$("#moduleSelectAdd").val(valueSelected).attr('disabled','disabled');
				$("#chapitreSelect").animate( { "opacity": "show"} , 500 );
				$("#labelChapitre").animate( { "opacity": "show"} , 500 );
				if (index > 0) {
					idModule=$("#moduleSelect").val();
					$.getJSON("listChapitreParModule", {
						idModule : $("#moduleSelect").val(),
						ajax : "true"
					}, function(data) {
						if (data.length > 0) {
							$("#chapitreSelect option").remove();
						}
						else
							{
								var img="<img class='img-rounded img-bordered-primary' src='<%=request.getContextPath()%>/photos/photoModule?idModule="+$("#moduleSelect").val()+"' alt='' width='80px' height='80px' />";
								$("#blocImgChapitre").html(img);
								$("#nomMod").html($("#moduleSelect").find(":selected").text());
	 							$("#bs-modal-sm-chapitre").modal('show'); 
								
							}
						var html = "<option value=''>Selectionner un Chapitre</option>";
						for (var i = 0; i < data.length; i++) {
							html += "<option value='"+data[i].idChapitre+"'>"
									+ data[i].titreChapitre + "</option>";
						}
						$("#chapitreSelect").html(html);
						nbrContenu=0;
						getNbrContenu();
						$("#numContenuChap").val(++nbrContenu);
						
					});
				}
				else
					{
						$("#chapitreSelect").animate( { "opacity": "hide"} , 500 ); 
						$("#labelChapitre").animate( { "opacity": "hide"} , 500 );
					}
			}
	function loadListOfContenu(){
		
		var index = $("#chapitreSelect")[0].selectedIndex;
		$("#contenuSelect").animate( { "opacity": "show"} , 500 );
		$("#labelContenu").animate( { "opacity": "show"} , 500 );
		$("#btnNew").animate( { "opacity": "show"} , 500 );
		if (index > 0) {
			
			$.getJSON("listContenuParChapitre", {
				idChapitre : $("#chapitreSelect").val(),
				ajax : "true"
			}, function(data) {
				if (data.length > 0) {
					$("#contenuSelect option").remove();
					nbrContenu=data.length;
				}
				var html = "<option value=''>Selectionner un Contenu</option>";
				for (var i = 0; i < data.length; i++) {
					html += "<option value='"+data[i].idContenu+"'>"
							+"("+data[i].numContenu+") "+ data[i].titreContenu + "</option>";
				}
				$("#contenuSelect").html(html);
			});
			idChapitre=$("#chapitreSelect").val();
		}
		else
			{
			$("#contenuSelect").animate( { "opacity": "hide"} , 500 );
			$("#labelContenu").animate( { "opacity": "hide"} , 500 );
			$("#btnNew").animate( { "opacity": "hide"} , 500 );
			}
	}
	function loadContenu(){
		
		var index = $("#contenuSelect")[0].selectedIndex;
		$("#editorForm").animate( { "opacity": "show"} , 500 );
		//$("#btnAddNew").attr('class', 'btn btn-lg btn-primary active');
		//clear ckeditor
		CKEDITOR.instances['editor1'].setData("");
		if (index > 0) {
			$.getJSON("loadContenuChpitre", {
				idContenu : $("#contenuSelect").val(),
				ajax : "true"
			}, function(data) {
				
				 CKEDITOR.instances['editor1'].insertHtml(data.contenu);
				 $("#titreContenu").val(data.titreContenu);
				 $("#numContenu").val(data.numContenu);
				 $("#idContenu").val(data.idContenu);
		});
		}
		else
			{
			$("#editorForm").hide();
			}
	}
	function addContenu(){
		//initialisation des champs
		CKEDITOR.instances['editor1'].setData("");
		$("#titreContenu").val("");
		nbrContenu=0;
		getNbrContenu();
		$("#numContenu").val(++nbrContenu);
		
		//desactivation de button nouveau contenu
		//$("#btnAddNew").attr('class', 'btn btn-lg btn-primary disabled');
		//affichage de ckeditor
		$("#editorForm").show();
	}
	function save(){
		
		$.ajax({
		    data:$("#editorForm").serialize() + "&idChapitre="+idChapitre+"&contenu="+CKEDITOR.instances['editor1'].document.getBody().getHtml(),
		    url : "ajouterContenu",
		    type : "POST",
		    success : function(response) {
		    	
		    	CKEDITOR.instances['editor1'].setData("");
				$("#numContenu").val("");
				$("#titreContenu").val("");
				//load
				loadListOfContenu();
				
		    }
		});
		return false;
		
	}
	function getNbrContenu()
	{
		$.getJSON("listContenuChapitreParModule", {
			idModule : idModule
		}, function(data) {
			if (data.length > 0) {
				nbrContenu=data.length;
			}
		});
	}
		
	function saveNewModule(){
		
		$.ajax({
		    data:$("#moduleForm").serialize()+"&idFormation="+idFormation,
		    url : "enregistrerModule",
		    type : "POST",
		    success : function(response) {
		    	
		    	$("#bs-modal-sm-module").modal('hide');
		    	$("#bs-modal-lg").modal('hide');
		    	loadListOfModule();
		    }
		});
		return false;
		
	}
	
	
	function saveNewChapitre(){
		
		$.ajax({
		    data:$("#chapitreForm").serialize() + "&idModule="+idModule,
		    url : "enregistrerChapitre",
		    type : "POST",
		    success : function(response) {
		    	
		    	$("#bs-modal-sm-chapitre").modal('hide');
		    	$("#bs-modal-lg-chapitre").modal('hide');
		    	loadListOfChapitre();
		    }
		});
		return false;
		
	}
	
		</script>
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
				<li ><a href="${indexLink }" data-target="#dashboard" data-toggle="submenu" data-parent=".topmenu"> <span class="figure"><i class="ico-dashboard2"></i></span> <span class="text">Acceuil</span> <span class="arrow"></span>
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
				<li class="active open"><a href="${contenusLink }" data-toggle="submenu" data-target="#table" data-parent=".topmenu"> <span class="figure"><i class="ico-stack"></i></span> <span class="text">Contenu Chapitre</span> <span class="arrow"></span>
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
				<li><a href="${espaceLink }" data-toggle="submenu" data-target="#maps" data-parent=".topmenu"> <span class="figure"> <i class="ico-folder-open"></i>
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
					<h4 class="title semibold">Dashboards</h4>
				</div>

			</div>
			<!-- Page Header -->
			<!-- --- -->
			<div id="conf"></div>
			<div class="row panel mt10">
				<div class="col-md-16">
					<!-- div layout -->

					<div class="panel-body">
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6">
									<f:form modelAttribute="formation" method="post">
										<label class="control-label">Formation : </label>
										<f:select class="form-control selectized" path="idFormation" id="formationSelect" onchange="loadListOfModule()">
											<f:option value="">Selectionner une Formation</f:option>
											<c:forEach items="${listFormations}" var="item">
												<f:option value="${item.idFormation }">${item.nomFormation }</f:option>
											</c:forEach>
										</f:select>
									</f:form>
								</div>
								<div class="col-sm-6">
									<f:form modelAttribute="module" method="post">
										<label id="labelModule" class="control-label">Modules : </label>
										<f:select path="idModule" class="form-control selectized" id="moduleSelect" onchange="loadListOfChapitre()">
											<f:option value="">Selectionner un module</f:option>
										</f:select>
									</f:form>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6">
									<f:form modelAttribute="chapitre" method="post">
										<label class="control-label" id="labelChapitre"> Chapitre : </label>
										<f:select class="form-control selectized" path="idChapitre" id="chapitreSelect" onchange="loadListOfContenu()">
											<f:option value="">Selectionner un chapitre</f:option>
										</f:select>
									</f:form>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<div class="col-sm-6 mb14">
											<f:form modelAttribute="contenuChapitre" method="post" onchange="loadContenu()">
												<label class="control-label" id="labelContenu"> Contenu Chapitre : </label>
												<f:select class="form-control selectized" path="idContenu" id="contenuSelect">
													<f:option value="">Selectionner un Contenu</f:option>
												</f:select>
											</f:form>
										</div>
									</div>
									<div class="col-sm-6 mb10" id="btnNew">
										<button id="btnAddNew" class="btn btn-lg btn-teal " type="button" onclick="addContenu()">Nouveau Contenu</button>
										<!-- 		<c:forEach items="${listContenuCoordinteur }" var="contenu"> 
											<c:if test="${contenu.idContenu.equals(idContenu)}"> 
												<button id="btnAddNew" class="btn btn-lg btn-teal " type="button" onclick="addContenu()">Nouveau Contenu</button>
									 		</c:if>
										</c:forEach> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--/ div -->
			</div>
			<!-- --- -->
			<div class="row panel mt10">
				<f:form id="editorForm" modelAttribute="contenuChapitre" method="post">
					<div class="panel-body">
						<div class="form-group">
							<div class="row">
								<f:hidden path="idContenu" />
								<div class="col-sm-6">
									<label class="control-label">Titre:</label>
									<f:input class="form-control" path="titreContenu" id="titreContenu" />
									<br>
								</div>
								<div class="col-sm-6">
									<label class="control-label">Numéro de Contenu dans le chapitre:</label>
									<f:input class="form-control disabled" path="numContenu" id="numContenu" />
									<br>
								</div>
							</div>
						</div>
						<p>
							<f:textarea path="contenu" id="editor1" name="editor1"></f:textarea>
							<!-- 			<ckfinder:setupCKEditor basePath="../../resources/CKFinderJava/ckfinder/" editor="editor1" />  -->
							<ckeditor:replace replace="editor1" basePath="../../resources/ckeditor/" />
						</p>
						<p>
						<!-- 
							<c:forEach items="${listContenuCoordinteur }" var="contenu">
								<c:if test="${contenu.idContenu==idContenu}">
									<button id="btnAdd" class="btn btn-lg btn-teal " type="button" onclick="save()">Enregistrer</button>
								</c:if>
							</c:forEach>
						-->
						<button id="btnAdd" class="btn btn-lg btn-teal " type="button" onclick="save()">Enregistrer</button>
						</p>
					</div>
				</f:form>
			</div>
		</div>
		<!--/ END Template Container -->

		<!-- START To Top Scroller -->
		<a href="#" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
		<!--/ END To Top Scroller -->

		<!-- START modal-sm Module-->
		<div id="bs-modal-sm-module" class="modal fade">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header text-center" id="blocImgModule">
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>
					<div class="modal-body" id="bodyModal">
						<h4 class="semibold mt0 text-center" id="nomFor"></h4>
						<p>
							Cette formation ne contient aucun module<br>voulez vous créer un nouveau ?
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Non</button>
						<button type="button" class="btn btn-success" data-toggle="modal" data-target="#bs-modal-lg">Oui</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!--/ END modal-sm -->

		<!-- START modal-sm Chapitre -->
		<div id="bs-modal-sm-chapitre" class="modal fade">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header text-center" id="blocImgChapitre">
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>
					<div class="modal-body" id="bodyModal">
						<h4 class="semibold mt0 text-center" id="nomMod"></h4>
						<p>
							Ce module ne contient aucun chapitre<br>voulez vous créer un nouveau ?
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Non</button>
						<button type="button" class="btn btn-success" data-toggle="modal" data-target="#bs-modal-lg-chapitre" onclick="getNbrContenu()">Oui</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!--/ END modal-sm chapitre-->


		<!-- START modal-lg -->
		<div id="bs-modal-lg" class="modal fade">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<f:form modelAttribute="module" method="post" class="form-horizontal" enctype="multipart/form-data" id="moduleForm">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<div class="ico-rocket mb15 mt15" style="font-size: 36px;"></div>
							<h3 class="semibold modal-title text-primary">Ajouter Module</h3>
						</div>
						<div class="modal-body">
							<div class="panel-body">
								<div class="form-group">
									<div class="col-sm-8">
										<f:hidden path="idModule" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Nom</label>
									<div class="col-sm-8">
										<f:input path="nomModule" class="form-control" />
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Desciprtion</label>
									<div class="col-sm-8">
										<f:textarea path="descriptionModule" class="form-control"></f:textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Formation</label>
									<div class="col-sm-8">
										<f:select path="formation.idFormation" items="${listFormations }" itemLabel="nomFormation" itemValue="idFormation" class="form-control" id="selectFormationADD" />

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">Photo</label>
									<div class="col-sm-8">
										<div class="input-group">
											<input type="text" class="form-control" disabled="disabled"> <span class="input-group-btn">
												<div class="btn btn-primary btn-file">
													<span class="icon iconmoon-file-3"></span> Parcourir <input type="file" name="file">
												</div>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
							<button type="button" class="btn btn-primary" onclick="saveNewModule()">Enregistrer</button>
						</div>
					</f:form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!--/ END modal-lg -->

		<!-- START modal-lg -->
		<div id="bs-modal-lg-chapitre" class="modal fade-chapitre">
			<div class="modal-dialog modal-lg">
				<f:form modelAttribute="chapitre" method="post" class="form-horizontal" id="chapitreForm">
					<div class="modal-content">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<div class="ico-rocket mb15 mt15" style="font-size: 36px;"></div>
							<h3 class="semibold modal-title text-primary">Ajouter Chapitre</h3>
						</div>
						<div class="modal-body">
							<div class="panel-body">
								<div class="form-group">
									<div class="col-sm-8">
										<f:hidden path="idChapitre" class="form-control" />
										<f:errors path="idChapitre" />
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">N°</label>
									<div class="col-sm-8">
										<f:input path="numChapitre" class="form-control" id="numContenuChap" />
										<f:errors path="numChapitre" cssClass="errors" />
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Titre</label>
									<div class="col-sm-8">
										<f:input path="titreChapitre" class="form-control" />
										<f:errors path="titreChapitre" cssClass="errors" />
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Desciprtion</label>
									<div class="col-sm-8">
										<f:textarea path="discriptionChapitre" class="form-control"></f:textarea>
										<f:errors path="discriptionChapitre" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4">Module</label>
									<div class="col-sm-8">
										<!--<f:select path="module.idModule" itemLabel="nomModule" itemValue="idModule" class="form-control" id="moduleSelectAdd" /> -->
										<f:select path="module.idModule" class="form-control selectized" id="moduleSelectAdd" />
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
							<button type="button" class="btn btn-primary" onclick="saveNewChapitre()">Enregistrer</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</f:form>
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!--/ END modal-lg -->

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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/javascript/backend/pages/dashboard-v1.js"></script>
	<!--/ Plugins and page level script : optional -->
	<!--/ END JAVASCRIPT SECTION -->
</body>
<!--/ END Body -->
</html>
