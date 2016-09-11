<%--/**--%>
 <%--* Created by Serhiy on 10.05.2016.--%>
 <%--*/--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        html, body { height: 100%; margin: 0; padding: 0; }
        #map { height: 100%; }
    </style>
</head>
<body>
<div id="map"></div>
<script type="text/javascript">

    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 50.565794, lng: 30.100075},
            zoom: 14
        });
        var geocoder = new google.maps.Geocoder();
        geocodeAddress(geocoder, map,resultArray);
    }
    function initMap() {
        var myLatLng = {lat: 50.565794, lng: 30.100075};
        var myLatLng1 = {lat: 50.567748,  lng: 30.099926};
        var myLatLng2 = {lat: 50.568475, lng: 30.092191};
        var myLatLng3 = {lat: 50.568475, lng: 30.092191};
        var myLatLng4 = {lat: 50.550181,  lng: 30.084175};

        // Create a map object and specify the DOM element for display.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: myLatLng1,
            scrollwheel: false,
            zoom: 14
        });
        // Create a marker and set its position.
        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng,
            title: 'Будинок - Горького 1\n' + 'Показники - 459262'
        });
        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng1,
            title: 'Будинок - Затишна 47А\n' + 'Показники - 603617'
        });
        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng2,
        });
        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng3,
        });
        var marker = new google.maps.Marker({
            map: map,
            position: myLatLng4,
        });
    }

    function geocodeAddress(geocoder, resultsMap,resultArray) {
        console.log(addressArray);
        $.each(resultArray, function (key, val) {
            geocoder.geocode({'address': val.address}, function(results, status) {
                if (status === google.maps.GeocoderStatus.OK) {
                    resultsMap.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: resultsMap,
                        title:val.firstName +' ' + val.lastName,
                        position: results[0].geometry.location
                    });
                    var infowindow = new google.maps.InfoWindow();
                    google.maps.event.addListener(marker, 'click', function() {
                        console.log(marker);
                        infowindow.setContent(val.firstName);
                        infowindow.open(map, this);
                    });
                } else {
                    alert('Geocode was not successful for the following reason: ' + status);
                }
            });
        })}
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBa5NfXoWXn-uvd0lCKLVQBuWgiuCVrnYA&callback=initMap">
</script>
</body>
</html>