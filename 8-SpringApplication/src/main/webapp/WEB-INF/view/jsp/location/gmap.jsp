<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calendar - List</title>
    <!-- js, css -->

    <link rel="stylesheet" href="<c:url value='/resources/jquery-ui/jquery-ui.css' />"  type="text/css" >
    <!--
    Jquery ui theme or bootstrapp theme but not both. And there is also semantic-ui available too
    <link rel="stylesheet" href="<c:url value='/resources/jquery-ui/jquery-ui.theme.css' />"  type="text/css" >
    -->
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css' />"  type="text/css" >
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-theme.css' />"  type="text/css" >
    <link rel="stylesheet" href="<c:url value='/resources/css/datetimepicker.css' />"  type="text/css" >
    <link rel="stylesheet" href="<c:url value='/resources/css/fullcalendar.css' />"  type="text/css" >
    <link rel="stylesheet" href="<c:url value='/resources/css/main.css' />"  type="text/css" >


<style type="text/css">


</style>

    <script type="text/javascript" src="<c:url value='/resources/js/jquery-2.1.4.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/jquery-ui/jquery-ui.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/datetimepicker.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/lodash.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/moment.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/fullcalendar.js' />" ></script>


    </head>

    <body>


<script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
  var map;
    function initializegmap() {
//http://maps.google.com/maps?q=Tampere,+Finland&hl=en&ll=61.500874,23.761024&spn=0.020313,0.104628&sll=37.0625,-95.677068&sspn=34.534108,107.138672&hnear=Tampere,+Finland&t=m&z=14
	    var myLatlng = new google.maps.LatLng(61.500874,23.761024);
    var myOptions = {
      zoom: 4,
      center: myLatlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

    var marker = new google.maps.Marker({
        position: myLatlng,
        map: map,
        title:"Tampere!"
    });

    map.addListener('click', function(e) {
        var infowindow = new google.maps.InfoWindow({
            content: "TADAA DAA DAA"
        });

        var marker = new google.maps.Marker({
            position: e.latLng,
            map: map
        });
        marker.addListener('click', function() {
            infowindow.open(map, marker);
        });

        map.panTo(e.latLng   );

      });


  }
  jQuery(function() { initializegmap() });
</script>
<style type="text/css">
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}
</style>

<div id="map_canvas" style="height:400px;width:550px"></div>

<hr />

<script>

    function mygeocode() {
        var address = jQuery("#myaddress").val();
        var markers = {};
        var size = 0;
        var url = "https://maps.googleapis.com/maps/api/geocode/json?address="+encodeURIComponent(address);
        jQuery.get(url, function(data) {
            console.log(data.results[0].geometry);
            var lat = data.results[0].geometry.location.lat;
            var lng = data.results[0].geometry.location.lng;
            jQuery("#mycoordinates").html("lat: "+ lat +" ; lng:" + lng);

            markers[size++] = new google.maps.Marker({
        position: new google.maps.LatLng(lat,lng),
        map: map,
        title:address
    });

        });

    }

</script>

<table>
    <tr><th>Address:</th><td><input id="myaddress" type="text" name="address" /></td></tr>
    <tr><th>Lat/Long:</th><td><div id='mycoordinates'>-</div></td></tr>
</table>
<button onclick="javascript:mygeocode()">Geo Code</button>


<pre>
How to click map and get latlong...

https://developers.google.com/maps/documentation/javascript/examples/event-arguments
</pre>

 </body>

 </html>