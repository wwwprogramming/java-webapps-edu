<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<head>
<%@include file="head.jsp" %>
</head>
<body>
<h2>Quotes</h2>

<div id="topnav">
    <a href="<c:url value='/quotes/create' />" ><span class="myButton">New</span></a>
</div>

<table id="quotes">
<thead>
<tr>

<th>Id</th><th>Quote</th><th>Who</th><th>When</th><th>Act</th>
</tr>
</thead>
<tbody>
<c:forEach items="${quotes}" var="quote">
<tr>
    <td>${quote.id}</td>
    <td>${quote.quote}</td>
    <td>${quote.who}</td>
    <td>${quote.year}</td>
    <td><a href="<c:url value='/quotes/read/${quote.id}' />">Read</a> | <a href="<c:url value='/quotes/update/${quote.id}' />">Edit</a> | <a onclick="return confirm('Are you sure?')" href="<c:url value='/quotes/remove/${quote.id}' />">Delete</a></td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>