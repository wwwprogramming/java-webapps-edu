<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Spring Security User</h2>

<table>
<c:forEach items="${users}" var="user" varStatus="loop" >
   <tr><td>${user.username}</td><td>${user.email}</td><td>${user.role}</td></tr>
</c:forEach>
</table>

<a href="/home">Etusivu</a>
</body>
</html>
