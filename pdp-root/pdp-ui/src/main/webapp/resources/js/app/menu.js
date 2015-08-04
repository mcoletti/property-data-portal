/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/22/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
var name = "#floatMenu";
var menuYloc = null;
$(document).ready(function () {
    var menuLocation = $("#floatMenu").position();
    var winWidth = $(window).width();
    var pagePostion = $(".page").position();
    $("#test").val("Window:" + winWidth + " Document Scroll Left:" + $(document).scrollLeft() + " left:" + pagePostion.left);
    $("#test2").val("Menu Left:" + menuLocation.left);
    menuYloc = parseInt($(name).css("top").substring(0, $(name).css("top").indexOf("px")))
    $(window).resize(function(){





        var menuLocation = $("#floatMenu").position();
        var winWidth = $(window).width();
        var pagePostion = $(".page").position();
        $("#test").val("Window:" + winWidth + " Document Scroll Left:" + $(document).scrollLeft() + " left:" + pagePostion.left);
        $("#test2").val("Menu Left:" + menuLocation.left);


        var left =  parseInt(winWidth) * parseFloat(0.7);

//        if(winWidth < 1185){
////            alert("GOt Here");
//            $("#floatMenu").css({
//                "left":left,
//                "margin-left":"200px"
//            });
//            $("#test2").val("Set Left to:" + left);
//        }else if(winWidth > 1185 && winWidth < 1495){
//
//            $("#floatMenu").css({
//                "left":left,
//                "margin-left":"200px"
//            });
//            $("#test2").val("2nd Set Left:" + left);
//
//
//        }else if(winWidth >= 1495){
//
//            left = parseInt(left) - 20;
//
//            $("#floatMenu").css({
//                "left":left,
//                "margin-left":"200px"
//            });
//            $("#test2").val("3nd Set Left:" + left);
//
//
//        }






    });
    $(window).scroll(function() {

        offset = menuYloc + $(document).scrollTop() + "px";

        $(name).animate({ top: offset }, { duration: 0, queue: false });
    });
    $("#floatMenu").appendTo(".page");
    loadNavigationLinks();


});

function loadNavigationLinks(){


    var url =   encodeURI("loadMenu");
    $.getJSON(url, function (data) {

//        alert(data);

        $.each(data, function (k,v) {

               var listItem = "<li><a id='lnk_" + k +"' href='" + v + "' class='ancBtn orange sml'><span>" + k + "</span></a></li>"

                $("#mainMenu").append(listItem);

        });

    });


//    // Load Navigation buttons
//    $("button:first").button({
//        // Property Vault Link
//        icons: {
//            primary: "ui-icon-link"
//        },
//        text: true
//    }).next().button({
//            // All Properties
//            icons: {
//                primary: "ui-icon-link"
//            }
//        }).next().button({
//            icons: {
//                primary: "ui-icon-link"
//            }
//        }).next().button({
//            icons: {
//                primary: "ui-icon-link"
//            },
//            text: false
//        });


}