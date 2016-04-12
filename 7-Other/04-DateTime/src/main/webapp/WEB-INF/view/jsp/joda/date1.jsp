<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<a href="<c:url value='/home' />">/home</a><br />
<a href="<c:url value='/date1/2016-01-01' />">/date1</a><br />

<pre>
[${date1}]
</pre>
</body>
</html>