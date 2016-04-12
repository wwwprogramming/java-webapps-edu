<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Hello Spring MVC!</h2>

<ul>
    <li>Upload New File <a href="<c:url value='/files/upload' />">&gt;&gt;</a></li>
    <li>List Uploaded Files <a href="<c:url value='/files/list' />">&gt;&gt;</a></li>
</ul>

</body>
</html>
