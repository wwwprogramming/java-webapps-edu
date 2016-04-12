<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<joda:format value="${now}" pattern="dd.MM.yyyy"  var="urlParam"/>

<html>
<body>
<a href="<c:url value='/home' />">/home</a><br />
<a href="<c:url value='/date3?date=${urlParam}' />">/date3</a><br />

<pre>
[${date3}]
[${now}]
[${urlParam}]

</pre>
</body>
</html>