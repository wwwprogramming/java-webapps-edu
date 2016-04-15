<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>INDEX JSP</h2>

<pre>
TODO - why is $ {} syntax, Expression Language working here...
</pre>

<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach>
</body>
</html>