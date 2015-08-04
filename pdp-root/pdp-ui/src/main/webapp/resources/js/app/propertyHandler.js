/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */



function loadProperties() {


    var url = encodeURI("loadProperties");
    $.getJSON(url, function (data) {

        $.each(data, function (i) {

            alert(data[i]);

            for (var j = 0; j < data[i].length; j++) {


                alert(data[i][j].propName);
            }
        });

    });
}

function loadPopUpImage(imageId) {
    $("#divImg_" + imageId).fadeIn();
    $("#divImg_" + imageId).css("display", "block");
}
function closeImagePopUp(imageId) {
    $("#divImg_" + imageId).fadeOut();
    $("#divImg_" + imageId).css("display", "none");
}

function loadGoogleMap(street, city, state, propDataId) {


    var newUrl = encodeURI("http://maps.googleapis.com/maps/api/geocode/json?address=" + street + "," + city + "," + state + "&sensor=false");
    $.ajax({
        type: 'GET',
        url: newUrl,
        dataType: 'json',
        success: function (data) {

            $.each(data.results, function (i, item) {
//             alert(item.formatted_address);
                var lat = item.geometry.location.lat;
                var lng = item.geometry.location.lng;

//                $("#divMapContent_" + propDataId).load("loadMap?lat=" + lat + "&lng=" + lng);
                $("#ifMap_" + propDataId).attr("src","loadMap?lat=" + lat + "&lng=" + lng);
                $("#divMap_" + propDataId).fadeIn();
                $("#divMap_" + propDataId).css("display", "block");
            });

        },
        error: function (xhr, status, error) {
            alert("Error executing POST for setting up load test: " + status + " " + xhr);
        }
    });

//    var googleApiUrl = "http://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false"
//    var googleApiUrl = "http://maps.googleapis.com/maps/api/geocode/json?address=" + street + "," + cityName + "," + stateName + "&sensor=false";
//    alert(googleApiUrl);
//    $.getJSON(googleApiUrl, function (data) {
//
////        alert(data.results);
//        $.each(data.results, function (i, item) {
////             alert(item.formatted_address);
//            var lat = item.geometry.location.lat;
//            var lng = item.geometry.location.lng;
//        });
//    });


}
//function initialize(lng, lat, propDataId) {
//    var mapOptions = {
//        center: new google.maps.LatLng(lat, lng),
//        zoom: 18,
//        mapTypeId: google.maps.MapTypeId.ROADMAP
//    };
//    var map = new google.maps.Map(document.getElementById("map-canvas_" + propDataId),
//        mapOptions);
//    $("#divMap_" + propDataId).fadeIn();
//    $("#divMap_" + propDataId).css("display", "block");
//
//}
function closeGoogleMap(propDataId) {
    $("#divMap_" + propDataId).fadeOut();
    $("#divMap_" + propDataId).css("display", "none");
}
function loadNextPage(offSet, currentPage) {

    window.location = "listings?offSet=" + offSet + "&currentPage=" + currentPage;

}
