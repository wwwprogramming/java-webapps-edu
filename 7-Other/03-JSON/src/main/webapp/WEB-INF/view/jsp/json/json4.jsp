<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<form action="<c:url value='/json4' />" method="POST">

<table>
    <tr></th>Age</th><td><input type="text" name="age" value="66" /></td></tr>
    <tr></th>Name</th><td><input type="text" name="name" value="Rose" /></td></tr>

</table>

<button type="submit">Do JSON</button>
</form>

<pre>
${data}
</pre>
