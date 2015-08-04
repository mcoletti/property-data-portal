<!doctype html>
<html>
	<head>
		<title><?php echo $title ?></title>
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="css/style.css" />
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="js/functions.js"></script>
		<!-- jcarousel -->
		
        <link rel="stylesheet" type="text/css" href="jcarousel/_shared/css/style.css">

        <!-- Example assets -->
        <link rel="stylesheet" type="text/css" href="jcarousel/examples/connected-carousels/jcarousel.connected-carousels.css">
        <script type="text/javascript" src="jcarousel/libs/jquery/jquery.js"></script>		
        <script type="text/javascript" src="jcarousel/dist/jquery.jcarousel.min.js"></script>
        <script type="text/javascript" src="jcarousel/examples/connected-carousels/jcarousel.connected-carousels.js"></script>
		<!-- end jcarousel -->
	</head>
	<body class="<?php echo $category ?>">
		<section id="header">
			<header>
				<a href="index.php" id="logo" style="height:80px;">
					<?php if ($category == "home") { ?>
						<h1 style="margin-top:0;">
					<?php } else { ?>
						<strong>
					<?php } ?>
					<img src="img/logo-nationwide-property-portal.jpg" alt="Nationwide Property Portal" /></h1>
					<?php if ($category == "home") { ?>
						</h1>
					<?php } else { ?>
						</strong>
					<?php } ?>
				</a>
				<div id="header-right-col">
					<ul id="menu-top">
						<li><a href="about.php">About</a></li>
						<li><a href="contact.php">Contact</a></li>
						<li><a href="login.php">Login to My Portal</a></li>
					</ul>
					<a class="button" href="#">Register for Free</a>
				</div>
				<div class="clear"></div>
			</header>
		</section><!-- header -->
		<div id="menu-main">
			<div class="container">
				<ul>
					<li><a href="how-it-works.php">How it Works</a></li>
					<li><a href="buyers.php">Buyers</a></li>
					<li><a href="sellers.php">Sellers</a></li>
					<li><a href="agents-brokers.php">Agents-Brokers</a></li>
					<li><a href="news.php">News</a></li>
					<li>More
						<ul>
							<li><a href="financing.php">Financing</a></li>
							<li><a href="property-managers.php">Property Managers</a></li>
							<li><a href="insurance.php">Insurance</a></li>
							<li><a href="ira.php">IRA's</a></li>
							<li><a href="contractors.php">Contractors</a></li>
						</ul>
					</li>
				</ul>
				<div id="menu-main-search">
					<form action="search.php" method="get">
						<input class="search" type="text" placeholder="Search for Properties ...">
						<input type="image" src="img/magnifier.jpg" class="magnifier" />
					</form>
				</div>
			</div><!-- container -->
		</div><!-- menu-main -->
		<section id="content" class="clearfix">
			<content class="clearfix">