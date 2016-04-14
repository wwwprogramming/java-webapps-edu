<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<a href="<c:url value='/home' />">/home</a><br />
<form action="<c:url value='/date5' />" method="POST">
    <table>
    <tr><th>date 1 (string)</th><td><input type="text" value="" name="date1" /></td></tr>
    <tr><th>date 2 (iso)</th><td><input type="text" value="<joda:format value='${now}' style="SS" />" name="date2" /></td></tr>
    <tr><th>date 3 (dd.MM.yyyy)</th><td><input type="text" value="13.12.2017" name="date3" /></td></tr>
    <tr><th>date 4 (dd.MM.yyyy HH:mm)</th><td><input type="text" value="01.01.2016 12:12" name="date4" /></td></tr>

    </table>
<input type="submit" value="Lähetä" name="dosubmit" />
</form>

<pre>
[${date4}]
</pre>
</body>
</html>