<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World ....!</h2>

<pre>
TODO - fix this build so that $ {} syntax, Expression Language works.
</pre>

<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach>
</body>
</html>
