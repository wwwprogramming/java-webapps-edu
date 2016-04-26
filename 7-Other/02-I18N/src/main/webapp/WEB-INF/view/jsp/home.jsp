<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false" %>

<html>
<body>
<h2><s:message code="home.h2" text="Welcome" /></h2>

<p><s:message code="${hello}" text="Hello..." /></p>
<ul>
 <li><a href="<c:url value='/form' />">form</a></li>
</ul>
</body>
</html>
