<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Spring Security User</h2>

<ul>
<li><a href='<c:url value="/login" />'>login</a></li>
<li><a href='<c:url value="/logout" />'>logout</a></li>
<li><a href='<c:url value="/afterlogin" />'>/afterlogin</a></li>
<li><a href='<c:url value="/justatest" />'>justatest</a></li>

</ul>
<h3>Using sec tags...</h3>

<ul>
<sec:authorize access="isAnonymous()">
    <li><a href='<c:url value="/login" />'>login</a></li>
</sec:authorize>

<sec:authorize access="isFullyAuthenticated()">
    <li><a href='<c:url value="/logout" />'>logout</a></li>
    <li><a href='<c:url value="/afterlogin" />'>/afterlogin</a></li>
    <li><a href='<c:url value="/justatest" />'>justatest</a></li>
</sec:authorize>
</ul>

</body>
</html>
