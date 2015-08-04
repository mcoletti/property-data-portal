$(function () {
    "use strict";
    function closeExpandedMenu() {
        $(".tabsExpanded").removeClass("tabsExpanded"), $(".tab").css("bottom", ""), $(".tabMenuExpanded").removeClass("tabMenuExpanded")
    }

    var resizeEvent = "ontouchstart"in window || window.DocumentTouch && document instanceof DocumentTouch ? "orientationchange.tab" : "resize.tab";
    $(".tabs, .tabs2").on("click.tab", ".tab", function () {
        var tabName;
        if ($(this).attr("href") && $(this).attr("href").indexOf("#") !== 0)return!0;
        closeExpandedMenu(), tabName = $(this).removeClass("tabLast").siblings().removeClass("tabActive tabLast").end().addClass("tabActive").parent().attr("data-tab"), $('[data-tab-group="' + tabName + '"]').children().removeClass("tabActive").eq([$(this).index()]).addClass("tabActive"), $(this).parent().is(".tabs2") && $(this).siblings(".tabSelect").find("option").removeAttr("selected").end().find('option[value="' + $(this).index() + '"]').attr("selected", "selected")
    });
    $(".tabs.tabs320, .tabs.tabs480").each(function () {
        if ($(this).find(".tab").length > 1)$(this).append('<div class="tabExpand"><\/div>').on("click.tab", ".tabExpand", function () {
            var height, openMe, $tabs, numTabs, $tabbedContentContainer;
            openMe = !$(this).parent().hasClass("tabsExpanded"), closeExpandedMenu(), openMe && (height = $(this).outerHeight(), $tabs = $(this).siblings(".tab:not(.tabActive)"), numTabs = $tabs.length - 1, $('[data-tab-group="' + $(this).parent().attr("data-tab") + '"]').addClass("tabMenuExpanded"), $(this).parent().addClass("tabsExpanded"), $(this).siblings().removeClass("tabLast"), $tabs.each(function (index) {
                $(this).css("bottom", -(index + 1) * (height + (numTabs === 0 ? 1 : 0))), index === numTabs && $(this).addClass("tabLast")
            }))
        })
    }), $(".tabs2.tabs320, .tabs2.tabs480").each(function () {
        var html;
        $(this).find(".tab").length > 1 && (html = '<select class="tabSelect">', $(this).find(".tab").each(function (index) {
            html += '<option value="' + index + '">' + $(this).text() + "<\/option>"
        }), html += "<\/select>", html += '<div class="tab2Arrow"><\/div>', $(html).on("change.tab",function () {
            $(this).parent().find(".tab").eq([$(this).val()]).trigger("click.tab"), $(this).blur()
        }).appendTo($(this)))
    }), window.location.hash && $('.tab[data-label="' + window.location.hash.replace("#", "") + '"], .tab[href="' + window.location.hash + '"]').trigger("click.tab");
    $(window).on(resizeEvent, closeExpandedMenu)
})