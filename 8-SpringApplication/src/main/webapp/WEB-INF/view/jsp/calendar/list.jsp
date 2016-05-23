<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calendar - List</title>
    <!-- js, css -->

    <link ref="stylesheet" href="<c:url value='/resources/css/bootstrap.css' />" >
    <link ref="stylesheet" href="<c:url value='/resources/css/bootstrap-theme.css' />" >
    <link ref="stylesheet" href="<c:url value='/resources/css/datetimepicker.css' />" >
    <link ref="stylesheet" href="<c:url value='/resources/css/fullcalendar.css' />" >
    <link ref="stylesheet" href="<c:url value='/resources/css/main.css' />" >

    <script type="text/javascript" src="<c:url value='/resources/js/jquery-2.1.4.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/datetimepicker.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/lodash.js' />" ></script>
    <script type="text/javascript" src="<c:url value='/resources/js/moment.js' />" ></script>


</head>
<body>
<h2>Events List</h2>


<table id="listing">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Start</th>
        <th>End</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${events}" var="event">

    <tr>
        <td>${event.id}</td>
        <td>${event.title}</td>
        <td><fmt:formatDate  pattern="dd.MM.yyyy HH:mm" value="${event.start}" /></td>
        <td><fmt:formatDate  pattern="dd.MM.yyyy HH:mm" value="${event.end}" /></td>
        <td>
            <a href='<c:url value="/event/update/${event.id}" />'><span>Update</span></a>

            <a href='<c:url value="/event/remove/${event.id}" />'><span>Delete</span></a>
            <a href='<c:url value="/event/read/${event.id}" />'><span>Read</span></a>

        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>