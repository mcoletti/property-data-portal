$(document).ready(function() {
	
	// menu-main dropdown
	
	$("#menu-main .container > ul > li").hover(function() {
		$("ul", this).fadeToggle();
	});
	
	// advanced search
	
	$("#advanced-search-toggle").click(function() {
		$("#advanced-search").slideToggle();
	});
	
	// highlight form when click on register button
	
	$(".register").click(function() {
		$("#form-registration").css("box-shadow", "0 0 50px rgb(100,150,200)");
	});
	
	// toggle definition list items
	
	$("dt").click(function() {
		$(this).next("dd").slideToggle();
	});
	
	// select star rating

	var rated = false;
	var rating;
	$(".stars div").hover(function() {
		if (rated == false) {
			var index = $(this).index();
			for (x = 0; x <= index; x ++) {
				$(".stars div:nth(" + x + ")").css("background-position", "bottom");
			}
			$(this).click(function() {
				var rating = ($(this).index() + 1) / 2;
				$(this).parent().attr("data-rating", rating);
				return rated = true;
			});
		}
	}, function() {
		if (rated == false) { 
			$(".stars div").css("background-position", "top");
		}
	});
	
	// switch tabs
	
	$(".tabs-menu > li").click(function() {
		$(".tabs-menu > li.active").removeClass("active");
		$(this).addClass("active");
		var tab = $(this).attr("data-tab");
		$(".tabs-content > div.active").removeClass("active");
		$(".tabs-content > div[data-tab='" + tab + "']").addClass("active");
	});
	

});