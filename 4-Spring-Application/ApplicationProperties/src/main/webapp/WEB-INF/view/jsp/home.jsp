<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Hello The A World!</h2>
<p>${hello}</p>
<a href="<c:url value='/example1' />">Example Value annotation and Property Placeholder</a>
</body>
</html>
