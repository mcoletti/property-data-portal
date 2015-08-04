<?php
	$title = "Nationionwide Property Portal";
	$category = "full-width";
?>
<?php include "header.php" ?>
<div id="home-banner">
	<div id="home-banner-search">
		<div id="home-banner-search-content">
			<h1><span id="home-banner-h1-row1">Nationwide Wholesale</span><br><span id="home-banner-h1-row2">&amp; Off-market Real Estate</span></h1>
			<h2>Turn-Key cash-flowing & Distressed Property DataBase</h2>
			<h2 style="margin-bottom:1em;">Search Properties</h2>
			<form action="search.php" method="get">
				<input type="text" class="search" placeholder="Enter location such as address / city / state / zip" />
				<input type="image" src="img/magnifier.jpg" class="magnifier" />
			</form>
		</div>
		<div id="home-banner-search-bg"></div>
	</div>
</div>
<h2 style="text-align:center;">Featured Properties</h2>

<div class="connected-carousels" style="position:relative; z-index:5;">
    <div class="stage" style="display:none;">
        <div class="carousel carousel-stage">
            <ul>
				<li><img src="img/properties/thumb-3133-gerrard.jpg">3188 Gerrard</li>
				<li><img src="img/properties/thumb-3516-wellington.jpg">3516 Wellington</li>
				<li><img src="img/properties/thumb-3937-butler.jpg">3937 Butler</li>
				<li><img src="img/properties/thumb-5601-glencoe.jpg">5601 Glencoe</li>
				<li><img src="img/properties/thumb-2708-hawthorne.jpg">2708 Hawthorne</li>
				<li><img src="img/properties/thumb-3218-welch-dr.jpg">3218 Welch Dr</li>
				<li><img src="img/properties/thumb-3133-gerrard.jpg">3188 Gerrard</li>
				<li><img src="img/properties/thumb-3516-wellington.jpg">3516 Wellington</li>
				<li><img src="img/properties/thumb-3937-butler.jpg">3937 Butler</li>
				<li><img src="img/properties/thumb-5601-glencoe.jpg">5601 Glencoe</li>
				<li><img src="img/properties/thumb-2708-hawthorne.jpg">2708 Hawthorne</li>
				<li><img src="img/properties/thumb-3218-welch-dr.jpg">3218 Welch Dr</li>
            </ul>
        </div>
        <a href="#" class="prev prev-stage"><span>&lsaquo;</span></a>
        <a href="#" class="next next-stage"><span>&rsaquo;</span></a>
    </div>

    <div class="navigation">
        <button class="prev prev-navigation">&lsaquo;</button>
        <div class="carousel carousel-navigation">
            <ul class="featured-list">
				<li onclick="location='property.php'"><img src="img/properties/thumb-3133-gerrard.jpg">Indianapolis 46224</li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3516-wellington.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3937-butler.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-5601-glencoe.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-2708-hawthorne.jpg">Indianapolis 46218</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3218-welch-dr.jpg">Indianapolis 46224</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3133-gerrard.jpg">Indianapolis 46224</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3516-wellington.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3937-butler.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-5601-glencoe.jpg">Indianapolis 46226</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-2708-hawthorne.jpg">Indianapolis 46218</a></li>
				<li onclick="location='property.php'"><a href="property.php"><img src="img/properties/thumb-3218-welch-dr.jpg">Indianapolis 46224</a></li>
            </ul>
        </div>
        <button class="next next-navigation">&rsaquo;</button>
    </div>
</div>

<h2 style="text-align:center;">Featured Professionals</h2>

<div class="connected-carousels featured-professionals">
    <div class="stage" style="display:none;">
        <div class="carousel carousel-stage">
            <ul>
				<li><img src="img/professionals/01.jpg"></li>
				<li><img src="img/professionals/02.jpg"></li>
				<li><img src="img/professionals/03.jpg"></li>
				<li><img src="img/professionals/04.jpg"></li>
				<li><img src="img/professionals/05.jpg"></li>
				<li><img src="img/professionals/06.jpg"></li>
            </ul>
        </div>
        <a href="#" class="prev prev-stage"><span>&lsaquo;</span></a>
        <a href="#" class="next next-stage"><span>&rsaquo;</span></a>
    </div>

    <div class="navigation">
        <button class="prev prev-navigation">&lsaquo;</button>
        <div class="carousel carousel-navigation">
            <ul class="featured-list" id="home-featured-professionals">
				<li><img src="img/professionals/01.jpg"></li>
				<li><img src="img/professionals/02.jpg"></li>
				<li><img src="img/professionals/03.jpg"></li>
				<li><img src="img/professionals/04.jpg"></li>
				<li><img src="img/professionals/05.jpg"></li>
				<li><img src="img/professionals/06.jpg"></li>
				<li><img src="img/professionals/01.jpg"></li>
				<li><img src="img/professionals/02.jpg"></li>
				<li><img src="img/professionals/03.jpg"></li>
				<li><img src="img/professionals/04.jpg"></li>
				<li><img src="img/professionals/05.jpg"></li>
				<li><img src="img/professionals/06.jpg"></li>
            </ul>
        </div>
        <button class="next next-navigation">&rsaquo;</button>
    </div>
</div>

<div style="clear:both;"></div>

<?php include "footer.php" ?>