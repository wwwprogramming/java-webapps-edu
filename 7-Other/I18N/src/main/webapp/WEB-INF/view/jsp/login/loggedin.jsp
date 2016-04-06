<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2><s:message code="login.loggedin.h2" text="LoggedIn" /></h2>

<p><sec:authentication property="principal.username" /></p>

<ul>
 <li><a href="<c:url value='/form' />">form</a></li>
</ul>
</body>
</html>
