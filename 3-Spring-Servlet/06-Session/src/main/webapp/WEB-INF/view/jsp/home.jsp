<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello The A World!</h2>

<a href="<c:url value='/sess1' />">sess1</a>

<pre>
[${sessionScope.myTestValue}]
</pre>
</body>
</html>
