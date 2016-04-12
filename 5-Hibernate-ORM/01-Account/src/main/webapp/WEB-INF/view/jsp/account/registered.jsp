<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Spring ORM User</h2>

<table>

   <tr><th>Username</th><td>${u2.username}</td></tr>
   <tr><th>Password</th><td>${u2.password}</td></tr>
   <tr><th>Email</th><td>${u2.email}</td></tr>
   <tr><th>ROLE</th><td>${u2.getRole()}</td></tr>

</table>

<a href="/home">Etusivu</a>
</body>
</html>
