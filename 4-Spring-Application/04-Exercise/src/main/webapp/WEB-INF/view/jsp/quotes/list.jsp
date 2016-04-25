<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Quotes</h2>


<table border=1>
<tr>
<td>Id</td><td>Quote</td><td>Who</td><td>When</td>
</tr>
<c:forEach items="${quotes}" var="quote">
<tr>
    <td>${quote.id}</td>
    <td>${quote.quote}</td>
    <td>${quote.who}</td>
    <td>${quote.year}</td>
</tr>
</c:forEach>

</table>

</body>
</html>