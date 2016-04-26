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

<spring:hasBindErrors name="quote">
	<c:forEach var="error" items="${errors.allErrors}">
		<!--  error is of type class FieldError -->
		<b>${error.field} <spring:message message="${error}" /></b>
		<br />
	</c:forEach>
    </spring:hasBindErrors>

<%@include file="navi.jsp" %>

<c:choose>
<c:when test="${quote.id != null}">

<h3>Edit</h3>
</c:when>
<c:otherwise>

<h3>Create New</h3>
</c:otherwise>
</c:choose>
<c:if test="${quote.id == null}">
<form method="post" action="<c:url value='/quotes/create' />" >
</c:if>
<c:if test="${quote.id != null}">
<form method="post" action="<c:url value='/quotes/update/${quote.id}' />" >
</c:if>


<table>
    <tr><th>ID</th><td>${quote.id}</td></tr>
    <tr><th>Quote</th><td><input type="text" name="quote" value="${quote.quote}" /></td></tr>
    <tr><th>Who</th><td><input type="text" name="who" value="${quote.who}" /></td></tr>
    <tr><th>Year</th><td><input type="text" name="year" value="${quote.year}" /></td></tr>
    <tr><th>&nbsp;</th><td>
    <c:if test="${quote.id == null}">
    <button type="submit"><span>Create</span></button>
    </c:if>
    <c:if test="${quote.id != null}">
    <button type="submit"><span>Update</span></button>
    </c:if>

    </td></tr>
</table>
</form>

</body>
</html>