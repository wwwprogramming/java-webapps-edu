<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Hello The A World!</h2>
<p>${hello}</p>
<hr />
<a href="<c:url value='/home' />">/home</a>
<a href="<c:url value='/home2' />">/home2</a>
</body>
</html>
