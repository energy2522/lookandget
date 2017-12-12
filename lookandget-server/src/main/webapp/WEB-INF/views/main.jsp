<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/js/modernizr.custom.js"/>"></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/jquery.fancybox.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/flickity.css"/>" rel="stylesheet" >
    <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/queries.css"/>" rel="stylesheet">
    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<!-- open/close -->
<header>
    <section class="hero">
        <div class="texture-overlay">
            <div class="texture-overlay" style="margin-top: 10px; margin-left: 10px">
                <form action="${contextPath}/logout" method="post">
                <button type="submit" style="background-color: transparent; width: 120px; height: 40px">Log out
                    <i class="glyphicon glyphicon-log-out">
                    </i>
                </button>
                </form>

            </div>
        </div>
        <div class="container">
            <div class="row nav-wrapper">
                <div class="col-md-6 col-sm-6 col-xs-6 text-left">
                    <a href="#"><img src="<c:url value="/resources/img/logo.png"/>" alt="Get And Look"></a>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-6 text-right navicon">
                    <p>MENU</p><a id="trigger-overlay" class="nav_slide_button nav-toggle" href="#"><span></span></a>
                </div>
            </div>
            <div class="row hero-content">
                <div class="col-md-12">
                    <h1 class="animated fadeInDown">Sanely applied advertising could remake the world.</h1>

                    <a href="#about" class="learn-btn animated fadeInUp">Learn more <i class="fa fa-arrow-down"></i></a>
                </div>
            </div>
        </div>
    </section>
</header>
<section class="video" id="about">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h1><a href="https://www.youtube.com/embed/RgBNA2dESy4?autoplay=1&wmode=opaque&fs=1" class="youtube-media"><i class="fa fa-play-circle-o"></i> Watch the Video</a></h1>
            </div>
        </div>
    </div>
</section>
<section class="features-intro">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 nopadding features-intro-img">
                <div class="features-bg">
                    <div class="texture-overlay"></div>
                    <div class="features-img wp1">
                        <img src="<c:url value="/resources/img/tech.png"/>" alt="Technologies">
                    </div>
                </div>
            </div>
            <div class="col-md-6 nopadding">
                <div class="features-slider">
                    <ul class="slides" id="featuresSlider">
                        <li>
                            <h1>Spring Framework</h1>
                            <p>The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform. A key element of Spring is infrastructural support at the application level: Spring focuses on the "plumbing" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.</p>

                        </li>
                        <li>
                            <h1>Android</h1>
                            <p>Android is a mobile operating system developed by Google, based on the Linux kernel and designed primarily for touchscreen mobile devices such as smartphones and tablets. Android's user interface is mainly based on direct manipulation, using touch gestures that loosely correspond to real-world actions, such as swiping, tapping and pinching, to manipulate on-screen objects, along with a virtual keyboard for text input.</p>
                        </li>
                        <li>
                            <h1>Azure Emotion API</h1>
                            <p>The Emotion API takes a facial expression in an image as an input, and returns the confidence across a set of emotions for each face in the image, as well as bounding box for the face, using the Face API. If a user has already called the Face API, they can submit the face rectangle as an optional input.</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="features-list" id="features">
    <div class="container">
        <a href="#"><img src="<c:url value="/resources/img/may.png"/>" alt="Get And Look" style="margin-left: 40%"></a>
        <a href="#"><img src="<c:url value="/resources/img/xz.png"/>" alt="Get And Look" style="margin-left: 35%"></a>
    </div>
    </div>
    </div>
    </div>
</section>
<section class="showcase" id="download">
    <div class="showcase-wrap">
        <div class="texture-overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="device wp3">
                        <div class="device-content">
                            <div class="showcase-slider">
                                <ul class="slides" id="showcaseSlider">
                                    <li>
                                        <img src="<c:url value="//resources/img/screen1.jpg"/>" alt="Device Content Image">
                                    </li>
                                    <li>
                                        <img src="<c:url value="//resources/img/screen2.jpg"/>" alt="Device Content Image">
                                    </li>
                                    <li>
                                        <img src="<c:url value="//resources/img/screen3.jpg"/>" alt="Device Content Image">
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <h1>Android Application</h1>
                    <p>Easy solution to the problem of access to the site is the mobile version of the lookandget system. With it you can use all the functionality of the system on your phone.</p>

                    <a href="https://play.google.com/store?hl=ru" class="download-btn">Download! <i class="fa fa-download"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="screenshots-intro">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Packed Full of Powerful Features</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a lorem quis neque interdum consequat ut sed sem. Duis quis tempor nunc. Interdum et malesuada fames ac ante ipsum primis in faucibus.</p>
                <p><a href="#screenshots" class="arrow-btn">See the screenshots! <i class="fa fa-long-arrow-right"></i></a></p>
            </div>
        </div>
    </div>
</section>
<section class="download" style="height: 20px">
    <div class="container">
        <div class="row">
            <div >
                <h1 class="footer-logo" >
                    <img src="<c:url value="/resources/img/mini-logo.png"/>" alt="Footer Logo Blue" style="margin-left: -10%">
                </h1>
                <p style="margin-left: -5%">© Maiboroda 2017</p>
            </div>
        </div>
    </div>
</section>
<div class="overlay overlay-boxify">
    <nav>
        <ul>
            <li><a href="#about"><i class="fa fa-heart"></i>About</a></li>
            <li><a href="#"><i class="fa fa-bar-chart"></i>Graphics</a></li>
        </ul>
        <ul>
            <li><a href="#"><i class="fa fa-desktop"></i>Personal Area</a></li>
            <li><a href="#download"><i class="fa fa-download"></i>Android</a></li>
        </ul>
    </nav>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/resources/js/min/toucheffects-min.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="<c:url value="/resources/js/flickity.pkgd.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.fancybox.pack.js"/>"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value="/resources/js/retina.js"/>"></script>
<script src="<c:url value="/resources/js/waypoints.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/min/scripts-min.js"/>"></script>
<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
<script>
    (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
        function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
        e=o.createElement(i);r=o.getElementsByTagName(i)[0];
        e.src='//www.google-analytics.com/analytics.js';
        r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
    ga('create','UA-XXXXX-X');ga('send','pageview');
</script>
</body>
</html>
