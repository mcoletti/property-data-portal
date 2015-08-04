/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/19/13
 * Time: 5:11 AM
 * To change this template use File | Settings | File Templates.
 */
function loadPageLayout(pageName){

    var url =   encodeURI("../PageLayout/loadPageLayout?=" + pageName);
    $.getJSON(url, function (data) {

        $.each(data, function (i) {

        });

    });

}
