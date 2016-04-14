<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<a href="<c:url value='/home' />">/home</a><br />
<a href="<c:url value='/rest1' />">/rest1</a><br />
<a href="<c:url value='/rest2/99' />">/rest2/99</a><br />
<a href="<c:url value='/rest3' />">/rest3</a><br />
<a href="<c:url value='/rest4' />">/rest4</a><br />
<a href="<c:url value='/rest5' />">/rest5</a><br />

</body>
</html>
