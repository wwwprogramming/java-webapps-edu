<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<head>
<%@include file="head.jsp" %>
</head>
<body>
<h2>Quote</h2>

<%@include file="navi.jsp" %>

<table>
    <tr><th>ID</th><td>${quote.id}</td></tr>
    <tr><th>Quote</th><td>${quote.quote}</td></tr>
    <tr><th>Who</th><td>${quote.who}</td></tr>
    <tr><th>Year</th><td>${quote.year}</td></tr>

</table>

</body>
</html>