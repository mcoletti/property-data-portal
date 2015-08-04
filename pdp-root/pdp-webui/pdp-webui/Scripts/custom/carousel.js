/****************************************
/js/v2/carousel.js
*****************************************/
(function ($) {
    "use strict";
    var Carousel = {},
		version = 1;
    /* Use the newer version if the file is included twice and one version is newer than the other. */
    if ($.carousel && version <= $.carousel.version) {
        return false;
    }
    /* Set Defaults */
    Carousel.defaults = {
        'fullWidth': true, /* Set true to fix slides at full width of carousel container */
        'carouselHeight': false, /* (false | 'varied' | Value | 'css' ) false = set height to tallest slide; Varied = Adjusts to each slide; Value = Enter value (in px, em, %, etc) to manually set height of carousel; CSS = Height is controlled in the CSS (may lose some animations in browsers that do NOT support CSS transitions); */
        'pagination': null, /* Type of pagination (null | 'numbers' | 'dots') */
        'firstSlide': 1, /* Set first slide */
        'slidesPerScroll': 1, /* Number of slides to scroll per next / prev click */
        'continuous': false, /* Set true to make slides continue to first slide at the end */
        'autoscroll': 0, /* Delay time between autoscroll slides (0 = autoscroll off) */
        'scrollTime': 400, /* Animation time to scroll */
        'showPrevNextBtns': true, /* Set false to hide prev / next buttons */
        'showPausePlayBtns': false, /* Set true to show pause / play button (only if autoscroll is set) */
        'customControls': false, /* Set true to add custom controls in the HTML (make sure to use appropriate classes and to appropriately set showPrevNextBtns or showPausePlayBtns) */
        'prevNextOutsideCarouselBg': false, /* Set true to place prev / next buttons outside .carouselBg */
        'pausePlayOutsideCarouselBg': false, /* Set true to place play / pause buttons outside .carouselBg */
        'paginationOutsideCarouselBg': true, /* Set false to place pagination buttons outside .carouselBg */
        'onSlideStart': false, /* function (slideIndex, $slide) { } Callback at start of slide */
        'onSlideEnd': false /* function (slideIndex, $slide) { } Callback at end of slide */
    };
    /* Detect css transition support */
    Carousel.cssTransition = (function () {
        var thisBody = document.body || document.documentElement,
			thisStyle = thisBody.style,
		support = thisStyle.transition !== undefined || thisStyle.WebkitTransition !== undefined || thisStyle.MozTransition !== undefined || thisStyle.MsTransition !== undefined || thisStyle.OTransition !== undefined;
        return support;
    })();
    /* Detect touch device */
    Carousel.isTouchDevice = 'ontouchstart' in window || (window.DocumentTouch && document instanceof DocumentTouch);
    /* Detect iPad */
    Carousel.isIpad = navigator.userAgent.match(/iPad/i) !== null;
    /* Functions */
    function markCarousel($el, newSlideIndex) {
        var settings = $el.data('carousel'),
			$inner = $el.data('$carouselInner'),
			$slides = $el.data('$carouselSlide'),
			slidePositions = $el.data('carousel-slide-positions'),
			maxPosition = -parseInt($inner.css('width'), 10) + parseInt($el.css('width'), 10),
			paginationClass;
        $el.removeClass('carouselAnimating');
        /* Mark current slide */
        $slides
			.removeClass('carouselCurrentSlide')
			.eq(newSlideIndex)
			.addClass('carouselCurrentSlide');
        /* Mark carousel position */
        if (newSlideIndex === 0) {
            $el.addClass('carouselFirstSlide');
            if ($el.outerWidth() >= $inner.outerWidth()) {
                $el.addClass('carouselLastSlide');
            } else {
                $el.removeClass('carouselLastSlide');
            }
        } else if (slidePositions[newSlideIndex] <= maxPosition) {
            $el.addClass('carouselLastSlide');
            if ($el.outerWidth() >= $inner.outerWidth()) {
                $el.addClass('carouselFirstSlide');
            } else {
                $el.removeClass('carouselFirstSlide');
            }
        } else {
            $el.removeClass('carouselFirstSlide carouselLastSlide');
        }
        /* Mark pagination */
        if (settings.pagination) {
            paginationClass = (settings.customControls) ? '' : 'silver';
            $el
				.find('.carouselGoToSlide')
				.removeClass('active')
				.addClass(paginationClass)
				.end()
				.find('.carouselGoToSlide[data-carousel-slide="' + ($el.find('.carouselCurrentSlide').index() + 1) + '"]')
				.addClass('active')
				.removeClass(paginationClass);
        }
    }
    function gotoSlide($el, newSlideIndex, ignoreSlidesPerScroll) {
        var $inner = $el.data('$carouselInner'),
			$slides = $el.data('$carouselSlide'),
			settings = $el.data('carousel'),
			slidePositions = $el.data('carousel-slide-positions'),
			newSlideEq,
			$currentSlide = $el.find('.carouselCurrentSlide'),
			currentSlideIndex = $currentSlide.index(),
			maxPosition = 0,
			leftPosition = 0;
        /* Restrict newSlideIndex to be beween 0 and number of slides - 1 */
        if (newSlideIndex < 0) {
            newSlideIndex = 0;
        } else if (newSlideIndex >= $el.data('$carouselSlide').length) {
            newSlideIndex = $el.find('carouselSlide').length - 1;
        }
        /* Adjust slidesPerScroll based on screen size */
        if (settings.slidesPerScroll > 1 && !ignoreSlidesPerScroll && !settings.fullWidth) {
            if (newSlideIndex > currentSlideIndex) {
                while (newSlideIndex > (currentSlideIndex + 1) && Math.abs(slidePositions[newSlideIndex] - slidePositions[currentSlideIndex]) > $el.outerWidth()) {
                    newSlideIndex -= 1;
                }
            } else if (currentSlideIndex > newSlideIndex) {
                while ((currentSlideIndex + 1) > newSlideIndex && Math.abs(slidePositions[currentSlideIndex] - slidePositions[newSlideIndex]) > $el.outerWidth()) {
                    newSlideIndex += 1;
                }
            }
        }
        /* Set leftPosition */
        if ($el.outerWidth() >= $inner.outerWidth()) {
            leftPosition = 0;
        } else {
            /* leftPosition must be between 0 and right of last slide */
            if (settings.fullWidth) {
                maxPosition = -$inner.outerWidth();
            } else {
                maxPosition = parseInt($el.css('width'), 10) - parseInt($inner.css('width'), 10);
            }
            leftPosition = Math.min(0, Math.max($el.data('carousel-slide-positions')[newSlideIndex], maxPosition));
        }
        /* run callbacks */
        if (settings.onSlideEnd !== false) {
            settings.onSlideEnd(currentSlideIndex, $currentSlide);
        }
        if (settings.onSlideStart !== false) {
            newSlideEq = $el.data('$carouselSlide').eq(newSlideIndex);
            settings.onSlideStart(newSlideEq.index(), newSlideEq);
        }
        /* Animate slide */
        $el.addClass('carouselAnimating');
        if (Carousel.cssTransition) {
            if (settings.carouselHeight === 'varied') {
                $inner.css({
                    'left': leftPosition,
                    'height': $slides.eq(newSlideIndex).outerHeight(true)
                });
            } else {
                $inner.css({
                    'left': leftPosition
                });
            }
        } else {
            if (settings.carouselHeight === 'varied') {
                $inner.animate({
                    'left': leftPosition,
                    'height': $slides.eq(newSlideIndex).outerHeight(true)
                }, settings.scrollTime, 'swing');
            } else {
                $inner.animate({
                    'left': leftPosition
                }, settings.scrollTime, 'swing');
            }
        }
        markCarousel($el, newSlideIndex);
    }
    function gotoNextSlide($el) {
        var settings = $el.data('carousel'),
			numSlides = $el.data('$carouselSlide').length;
        if ($el.hasClass('carouselLastSlide')) {
            if (settings.continuous) {
                gotoSlide($el, 0, true);
            } else {
                gotoSlide($el, numSlides - 1, true);
            }
        } else {
            gotoSlide($el, $el.find('.carouselCurrentSlide').index() + settings.slidesPerScroll);
        }
    }
    function gotoPreviousSlide($el) {
        var settings = $el.data('carousel'),
			numSlides = $el.data('$carouselSlide').length;
        if ($el.hasClass('carouselFirstSlide')) {
            if (settings.continuous) {
                gotoSlide($el, numSlides - 1, true);
            } else {
                gotoSlide($el, 0, true);
            }
        } else {
            gotoSlide($el, $el.find('.carouselCurrentSlide').index() - settings.slidesPerScroll);
        }
    }
    function fixDimensions($el) {
        var settings = $el.data('carousel'),
			$inner = $el.data('$carouselInner'),
			$slides = $el.data('$carouselSlide'),
			numSlides = $slides.length,
			slidePositions = [],
			carouselWidth = 0,
			carouselHeight = 0,
			innerHeight,
			isIe8 = $.browser.msie && parseInt($.browser.version, 10) === 8,
			animateOptions,
			borderLeftWidth,
			borderRightWidth;
        /* Set slide width and positions */
        $slides.each(function () {
            var $slide = $(this);
            if (isIe8) {
                /* Fixes IE8 bug which doesn't respect max-width with box-sizing:border-box */
                borderLeftWidth = ($slide.css('border-left-width').indexOf('px') > -1) ? parseInt($slide.css('border-left-width'), 10) : 0;
                borderRightWidth = ($slide.css('border-right-width').indexOf('px') > -1) ? parseInt($slide.css('border-right-width'), 10) : 0;
                $slide.css('max-width', parseInt($el.css('width'), 10) - parseInt($slide.css('padding-left'), 10) - parseInt($slide.css('padding-right'), 10) - borderLeftWidth - borderRightWidth);
            } else {
                $slide.css('max-width', $el.css('width'));
            }
            slidePositions.push(-carouselWidth);
            carouselWidth += $slide.outerWidth(true);
            carouselHeight = carouselHeight > $slide.outerHeight(true) ? carouselHeight : $slide.outerHeight(true);
        });
        $el.data('carousel-slide-positions', slidePositions);
        /* Set inner */
        if (settings.carouselHeight === 'css') {
            innerHeight = '';
        } else if (settings.carouselHeight === 'varied') {
            innerHeight = $slides.eq(0).outerHeight(true);
        } else if (!settings.carouselHeight || settings.carouselHeight === 'auto') {
            innerHeight = carouselHeight;
        } else {
            innerHeight = settings.carouselHeight;
        }
        if (Carousel.cssTransition) {
            $inner.css({
                'height': innerHeight,
                'width': carouselWidth
            });
        } else {
            /* Don't animate height if set in css */
            animateOptions = {
                'width': carouselWidth
            };
            if (settings.carouselHeight !== 'css') {
                animateOptions.height = innerHeight;
            }
            $inner.animate(animateOptions, settings.scrollTime, 'swing');
        }
        $el.addClass('carouselActive');
    }
    function playAutoscroll($el) {
        var settings = $el.data('carousel');
        $el
			.removeClass('carouselPaused')
			.addClass('carouselPlaying')
			.find('.carouselPausePlay button')
			.removeClass('carouselPlay iconPlay')
			.addClass('carouselPause iconPause');
        $el.data('carousel-timer', setInterval(function () {
            gotoNextSlide($el);
        }, settings.autoscroll + settings.scrollTime));
    }
    function pauseAutoscroll($el, forceStop) {
        $el
			.addClass('carouselPaused')
			.removeClass('carouselPlaying');
        clearInterval($el.data('carousel-timer'));
        if (forceStop) {
            $el
				.data('carousel-timer', null)
				.removeClass('carouselPaused carouselPlaying')
				.find('.carouselPausePlay button')
				.removeClass('carouselPause iconPause')
				.addClass('carouselPlay iconPlay');
        }
    }
    function addPrevNext($el) {
        var settings = $el.data('carousel'),
			$appendToEl;
        (settings.prevNextOutsideCarouselBg) ? $appendToEl = $el : $appendToEl = $el.find('.carouselBg');
        $('<menu class="carouselControlsDefault"><button class="carouselPreviousBtn icon iconArrowLeft" type="button"></button><button class="carouselNextBtn icon iconArrowRight" type="button"></button></menu>').appendTo($appendToEl);
    }
    function addPagination($el) {
        var i = 0,
			$slides = $el.data('$carouselSlide'),
			settings = $el.data('carousel'),
			slidesLength = $slides.length,
			html,
			$appendToEl;
        html = '<menu class="carouselPagination carouselPagination' + settings.pagination.charAt(0).toUpperCase() + settings.pagination.slice(1) + '">';
        for (i; i < slidesLength; i += 1) {
            html += '<button class="carouselGoToSlide ancBtn silver sml" type="button" data-carousel-slide="' + (i + 1) + '">';
            if (settings.pagination === 'numbers') {
                html += (i + 1);
            }
            html += '</button>';
        }
        html += '</menu>';
        (settings.paginationOutsideCarouselBg) ? $appendToEl = $el : $appendToEl = $el.find('.carouselBg');
        $(html).appendTo($appendToEl);
    }
    function addPausePlay($el) {
        var settings = $el.data('carousel'),
			$appendToEl;
        (settings.pausePlayOutsideCarouselBg) ? $appendToEl = $el : $appendToEl = $el.find('.carouselBg');
        $('<menu class="carouselPausePlay"><button class="carouselPausePlayBtn carouselPause ancBtn sml silver icon iconPause" type="button"></button></menu>')
				.appendTo($appendToEl);
    }
    function getClosestSlide($el) {
        var $inner = $el.data('$carouselInner'),
			$slides = $el.data('$carouselSlide'),
			closest = null,
			slidePositions = $el.data('carousel-slide-positions'),
			currentPosition = parseInt($inner.css('left'), 10),
			closestIndex;
        $.each(slidePositions, function (i) {
            if (!closest || Math.abs(this - currentPosition) < Math.abs(closest - currentPosition)) {
                closest = this;
                closestIndex = i;
            }
        });
        return $slides.eq(closestIndex).index();
    }
    function addTouchEvents($el) {
        // Do not change from here down. iOS works like this...
        var settings = $el.data('carousel'),
				$inner = $el.data('$carouselInner'),
				innerLeftPos,
				minDistance = 15, /* "right" number for mobile chrome */
				startX = 0,
				startY = 0,
				change = 0,
				currentX = 0,
				currentY = 0,
				currentXDistance,
				currentYDistance,
				isScrolling,
				newSlideIndex,
				touchStartTime,
				touchEndTime,
				touchSpeed,
				cssTransition = 'left ' + (settings.scrollTime) + 'ms, height ' + (settings.scrollTime) + 'ms';
        $inner
			.on('touchstart.carousel', function (e) {
			    $inner
					.css({
					    '-moz-transition': 'none',
					    '-ms-transition': 'none',
					    '-o-transition': 'none',
					    '-webkit-transition': 'none',
					    'transition': 'none'
					});
			    touchStartTime = new Date().getTime();
			    isScrolling = undefined;
			    currentX = 0;
			    currentY = 0;
			    currentXDistance = 0;
			    currentYDistance = 0;
			    startX = e.originalEvent.touches ? e.originalEvent.touches[0].pageX : e.pageX;
			    startY = e.originalEvent.touches ? e.originalEvent.touches[0].pageY : e.pageY;
			    innerLeftPos = parseInt($inner.css('left'), 10);
			})
			.on('touchmove.carousel', function (e) {
			    currentX = e.originalEvent.touches ? e.originalEvent.touches[0].pageX : e.pageX;
			    currentY = e.originalEvent.touches ? e.originalEvent.touches[0].pageY : e.pageY;
			    change = currentX - startX;
			    currentXDistance = (startX === 0) ? 0 : Math.abs(change);
			    currentYDistance = (startY === 0) ? 0 : Math.abs(currentY - startY);
			    $inner.css({
			        left: innerLeftPos + change
			    });
			    // if (isScrolling === undefined) {
			    // 	isScrolling = !!(isScrolling || currentXDistance < currentYDistance);
			    // }
			    if (isScrolling === undefined && currentXDistance > minDistance) {
			        isScrolling = (currentXDistance < currentYDistance);
			        if (settings.autoscroll) {
			            pauseAutoscroll($el, true);
			        }
			    }
			    if (!isScrolling) {
			        e.preventDefault();
			    }
			})
			.on('touchend.carousel', function () {
			    $inner
					.css({
					    '-moz-transition': cssTransition,
					    '-ms-transition': cssTransition,
					    '-o-transition': cssTransition,
					    '-webkit-transition': cssTransition,
					    'transition': cssTransition
					});
			    if (!isScrolling) {
			        touchEndTime = new Date().getTime();
			        touchSpeed = Math.abs(touchEndTime - touchStartTime);
			        if (touchSpeed < 400 && currentXDistance > minDistance) {
			            if (currentX < startX) {
			                gotoNextSlide($el);
			            } else if (currentX > startX) {
			                gotoPreviousSlide($el);
			            }
			        } else if (currentXDistance > minDistance) {
			            newSlideIndex = getClosestSlide($el);
			            gotoSlide($el, newSlideIndex, true);
			        }
			    }
			    change = 0;
			    currentX = 0;
			    currentY = 0;
			    currentXDistance = 0;
			    currentYDistance = 0;
			    startX = 0;
			    startY = 0;
			});
    }
    function addEvents($el) {
        var settings = $el.data('carousel'),
			$inner = $el.data('$carouselInner'),
			winWidth = $(window).width(),
			winHeight = $(window).height(),
			winNewWidth,
			winNewHeight,
			timer,
			firstResize = true,
			currentSlideIndex;
        /* Adjust dimensions on browser resize */
        $(window).on('resize.carousel', function () {
            winNewWidth = $(window).width();
            winNewHeight = $(window).height();
            if (winWidth !== winNewWidth || winHeight !== winNewHeight) {
                if (settings.autoscroll && $el.hasClass('carouselPlaying') && firstResize === true) {
                    pauseAutoscroll($el);
                    firstResize = false;
                }
                clearTimeout(timer);
                timer = setTimeout(function () {
                    currentSlideIndex = $inner.find('.carouselCurrentSlide').index();
                    fixDimensions($el);
                    gotoSlide($el, currentSlideIndex, true);
                    if (settings.autoscroll && $el.hasClass('carouselPaused')) {
                        playAutoscroll($el);
                    }
                    firstResize = true;
                }, 400);
            }
            winWidth = winNewWidth;
            winHeight = winNewHeight;
        });
        /* Autoscroll hover / blur */
        if (settings.autoscroll) {
            $el
				.on('mouseover.carousel', function () {
				    if ($el.hasClass('carouselPlaying')) {
				        pauseAutoscroll($el);
				    }
				})
				.on('mouseleave.carousel', function () {
				    if ($el.hasClass('carouselPaused')) {
				        playAutoscroll($el);
				    }
				});
        }
        if (Carousel.isTouchDevice) {
            addTouchEvents($el);
        }
        $el
			.on('click.carousel', '.carouselNextBtn', function () {
			    if (!Carousel.cssTransition) {
			        $el.data('$carouselInner').stop();
			    }
			    if (settings.autoscroll) {
			        pauseAutoscroll($el, true);
			    }
			    gotoNextSlide($el);
			})
			.on('click.carousel', '.carouselPreviousBtn', function () {
			    if (!Carousel.cssTransition) {
			        $el.data('$carouselInner').stop();
			    }
			    if (settings.autoscroll) {
			        pauseAutoscroll($el, true);
			    }
			    gotoPreviousSlide($el);
			})
			.on('click.carousel', '.carouselGoToSlide', function () {
			    if (!Carousel.cssTransition) {
			        $el.data('$carouselInner').stop();
			    }
			    if (settings.autoscroll) {
			        pauseAutoscroll($el, true);
			    }
			    gotoSlide($el, $(this).attr('data-carousel-slide') - 1, true);
			})
			.on('click.carousel', '.carouselPausePlayBtn', function () {
			    var $pausePlayBtn = $(this);
			    if ($pausePlayBtn.hasClass('carouselPause')) {
			        $pausePlayBtn
						.removeClass('carouselPause')
						.addClass('carouselPlay');
			        if (!settings.customControls) {
			            $pausePlayBtn
							.removeClass('iconPause')
							.addClass('iconPlay');
			        }
			        pauseAutoscroll($el, true);
			    } else {
			        $pausePlayBtn
						.removeClass('carouselPlay')
						.addClass('carouselPause');
			        if (!settings.customControls) {
			            $pausePlayBtn
							.removeClass('iconPlay')
							.addClass('iconPause');
			        }
			        if ($el.hasClass('carouselLastSlide')) {
			            gotoSlide($el, 0, true);
			        } else {
			            gotoNextSlide($el);
			        }
			        playAutoscroll($el);
			    }
			});
    }
    function destroyCarousel($el) {
        var settings = $el.data('carousel');
        if (settings.autoscroll) {
            pauseAutoscroll($el, true);
        }
        $el
			.removeClass('carouselActive carouselVertical carouselFullWidth carouselContinuous carouselAutoscroll carouselPlaying carouselPaused carouselFirstSlide carouselLastSlide')
			.removeAttr('style')
			.find('.carouselInner')
			.unwrap()
			.end()
			.find('.carouselSlide, .carouselInner')
			.removeAttr('style class')
			.end()
			.find('menu')
			.remove()
			.off('.carousel');
    }
    function init($el, settings) {
        var firstSlide,
			$inner,
			$slides,
			cssTransition;
        /* Store settings */
        settings = $el.data('carousel', $.extend({}, Carousel.defaults, settings)).data('carousel');
        /* Add classes and store common selectors used in various locations */
        firstSlide = settings.firstSlide - 1;
        cssTransition = 'left ' + (settings.scrollTime) + 'ms, height ' + (settings.scrollTime) + 'ms';
        $el
			.addClass('carousel')
			.data('$carouselInner', $el.children('ul').addClass('carouselInner'))
			.data('$carouselSlide', $el.data('$carouselInner').children().addClass('carouselSlide'));
        $inner = $el.data('$carouselInner');
        $slides = $el.data('$carouselSlide');
        if (!$el.children('.carouselBg').length) {
            $inner.wrap('<div class="carouselBg" />');
        }
        if (settings.fullWidth) {
            $el.addClass('carouselFullWidth');
        }
        if (settings.continuous) {
            $el.addClass('carouselContinuous');
        }
        if (settings.autoscroll) {
            $el.addClass('carouselAutoscroll');
        }
        /* Reset margin for 1st and last slide */
        $slides
			.eq(0)
			.css('margin-left', 0)
			.end()
			.eq($slides.length - 1)
			.css('margin-right', 0);
        if (Carousel.cssTransition) {
            $inner.css({
                '-moz-transition': cssTransition,
                '-ms-transition': cssTransition,
                '-o-transition': cssTransition,
                '-webkit-transition': cssTransition,
                'transition': cssTransition
            });
        }
        /* Fix dimensions */
        fixDimensions($el);
        /* Add previous & next buttons */
        if (settings.showPrevNextBtns && !settings.customControls) {
            addPrevNext($el);
        }
        /* Add pagination */
        if (settings.pagination && !settings.customControls) {
            addPagination($el);
        }
        /* Add pause / play */
        if (settings.autoscroll && settings.showPausePlayBtns && !settings.customControls) {
            addPausePlay($el);
        }
        /* Add events */
        addEvents($el);
        $el.removeClass('loading');
        /* Go to first slide */
        setTimeout(function () {
            gotoSlide($el, firstSlide, true);
            if (!$el.data('$carouselSlide').find('carouselCurrentSlide').length) {
                markCarousel($el, firstSlide);
            }
            if (settings.autoscroll) {
                playAutoscroll($el);
            }
        }, 400);
    }
    $.fn.carousel = function (options, params) {
        return this.each(function () {
            var $this = $(this);
            if (options === 'next') {
                gotoNextSlide($this);
            } else if (options === 'prev') {
                gotoPreviousSlide($this);
            } else if (options === 'goToSlide') {
                gotoSlide($this, params - 1, true);
            } else if (options === 'stop') {
                if ($this.data('carousel').autoscroll) {
                    pauseAutoscroll($this, true);
                }
            } else if (options === 'play') {
                if (params) {
                    $this.data('carousel').autoscroll = params;
                    playAutoscroll($this);
                } else if ($this.data('carousel').autoscroll) {
                    playAutoscroll($this);
                }
            } else if (options === 'fixDimensions') {
                fixDimensions($this);
            } else if (options === 'destroy') {
                destroyCarousel($this);
            } else if (!$this.data('carousel')) {
                /* Prevents multiple instantiations */
                init($(this), options);
            }
        });
    };
    /* Detect touch device and add appropriate class */
    $(function () {
        if (Carousel.isTouchDevice) {
            $('html').addClass('touch');
        } else {
            $('html').addClass('noTouch');
        }
    });
    /* Defaults */
    $.carousel = {};
    $.carousel.version = version;
})(jQuery);