<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ" value="${now}" var="urlParam" />

<% pageContext.setAttribute("urlParamEnc" , java.net.URLEncoder.encode( (String)pageContext.getAttribute("urlParam").toString() , "UTF-8") ); %>

<html>
<body>
<a href="<c:url value='/home' />">/home</a><br />
<a href="<c:url value='/date2/${urlParamEnc}' />">/date2</a><br />
<a href="<c:url value='/date2b?date=${urlParamEnc}' />">/date2b</a><br />
<a href="<c:url value='/date2c/${urlParamEnc}/' />">/date2c</a><br />


<pre>
[${date2}]
[${now}]
[${now2}]

[${urlParamEnc}]
[<fmt:formatDate  pattern="dd.MM.yyyy HH:mm" value="${now}" />]
[<joda:format value="${now2}" pattern="dd.MM.yyyy HH:mm" />]

Try this too...
[http://localhost:8080/app-datetime/date2/2016-04-09T19%3A08%3A45%2e773%2B0300/]
</pre>
</body>
</html>