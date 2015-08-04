/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/4/13
 * Time: 4:53 AM
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function () {

    $(".fancybox-effects-c").fancybox({
        wrapCSS: 'fancybox-custom',
        closeClick: true,

        openEffect: 'fade',
        openSpeed: 200,
        closeEffect: 'fade',
        closeSpeed: 200,

        helpers: {
            title: {
                type: 'inside'
            },
            overlay: {
                css: {
                    'background': 'rgba(238,238,238,0.85)'
                }
            }
        }
    });
});