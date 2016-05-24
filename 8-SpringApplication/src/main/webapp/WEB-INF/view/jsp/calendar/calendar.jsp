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

#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery-2.1.4.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/jquery-ui/jquery-ui.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/datetimepicker.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/lodash.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/moment.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/fullcalendar.js' />" ></script>


<script type="text/javascript">

jQuery(document).ready(function() {

    jQuery("#calendar").fullCalendar({
    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    },
    defaultDate: moment(),
    editable: false,
    eventLimit: false, // allow "more" link when too many events
    events: function(start, end, tz, callback) {
        console.log("events!");
        console.log(start.format("YYYY-MM-DD"));
        console.log(end.format("YYYY-MM-DD"));
        jQuery.get("/events/search", {start:start.format("YYYYMMDDHHmm"), end:end.format("YYYYMMDDHHmm"),tz:tz}, function(eventdata) {
            callback(eventdata);
        });

    },
    eventAfterAllRender: function(view) {
        console.log("eventAfterAllRender");
    },
    viewRender: function(view, element) {
        console.log("viewRender");
        console.log(view);
    },
    eventStartEditable: false,
    eventDurationEditable: false,
     eventClick: function( event, jsEvent, view ) {
         console.log(event,jsEvent, view);
         console.log(event.id);
                 window.location.href = "/event/update/" + event.id;

     },
     dayClick: function(event,a) {
        console.log("dayClick");
        console.log(event,a);
        window.location.href = "/event/create";
        },
        selectable: true,
      select: function( start, end, jsEvent, view ) {
        console.log("select");
        console.log(start, end, jsEvent, view);
      }
     });


    jQuery("#demobutton").click(function() {
        jQuery("#calendar").fullCalendar("gotoDate", moment("2016-12-24", 'YYYY-MM-DD'));
    });

});

</script>
</head>
<body>
<h2>Events Calendar</h2>

<button id="demobutton">Example  - Go to 24.12.2016</button>

<div id="calendar"></div>

</body>
</html>