<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<!-- 
TEMPLATE NAME : Adminre - backend
VERSION : 1.3.0
AUTHOR : JohnPozy
AUTHOR URL : http://themeforest.net/user/JohnPozy
EMAIL : pampersdry@gmail.com
LAST UPDATE: 2015/01/05

** A license must be purchased in order to legally use this template for your project **
** PLEASE SUPPORT ME. YOUR SUPPORT ENSURE THE CONTINUITY OF THIS PROJECT **
-->
<html class="backend">
    <!-- START Head -->
    <head>
        <!-- START META SECTION -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>404 page introuvable</title>
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
        <!-- START Template Main -->
        <section id="main" role="main">
            <!-- START Template Container -->
            <section class="container animation delay animating fadeInDown">
                <!-- START row -->
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <div class="panel panel-minimal" style="margin-top:10%;">
                            <!-- Upper Text -->
                            <div class="panel-body text-center">
                                <i class="ico-file-remove2 longshadow fsize112 text-default"></i>
                            </div>
                            <div class="panel-body text-center">
                                <h1 class="semibold longshadow text-center text-default fsize32 mb10 mt0">WHOOPS!!</h1>
                                <h4 class="semibold text-primary text-center nm">La page que vous cherchez n'existe pas ou n'est pas disponible...</h4>
                            </div>
                            <!--/ Upper Text -->

                            <!-- Button -->
                            <div class="panel-body text-center">
                                <a href="<c:url value="/" />" class="btn btn-default mb5">Acceuil</a>
                                <span class="semibold text-default hidden-xs">&nbsp;&nbsp;OU&nbsp;&nbsp;</span>
                                <a href="javascript:void(0);" class="btn btn-success mb5">Reporter Cette Probleme</a>
                            </div>
                            <!--/ Button -->
                        </div>
                    </div>
                </div>
                <!--/ END row -->
            </section>
            <!--/ END Template Container -->
        </section>
        <!--/ END Template Main -->

        <!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
        <!-- Application and vendor script : mandatory -->
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javascript/vendor.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javascript/core.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javascript/backend/app.js"></script>
        <!--/ Application and vendor script : mandatory -->

        <!-- Plugins and page level script : optional -->
        <!--/ Plugins and page level script : optional -->
        <!--/ END JAVASCRIPT SECTION -->
    </body>
    <!--/ END Body -->
</html>