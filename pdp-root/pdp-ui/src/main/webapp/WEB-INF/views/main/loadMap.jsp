<!DOCTYPE html>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>

<html>
<script type="text/javascript">
    function initialize() {

        var lat = $.url().param('lat');
        var lng = $.url().param('lng');

        var mapOptions = {
            zoom: 12,
            center: new google.maps.LatLng(lat, lng),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };

        var map = new google.maps.Map(document.getElementById('map-canvas'),
                mapOptions);
    }

    function loadScript() {
        var script = document.createElement('script');
        script.type = 'text/javascript';
        script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyBLU5vU3ooUhJXOFBoofxRT_-_MmGxmnKs&sensor=false&callback=initialize";
        document.body.appendChild(script);
    }

    window.onload = loadScript;
</script>
<body>
<div id="map-canvas" style="width: 700px; height: 700px;overflow: auto"></div>
</body>
</html>

