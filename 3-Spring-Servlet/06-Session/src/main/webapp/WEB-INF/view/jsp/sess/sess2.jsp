<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>

<body>

<a href="<c:url value='/sess3' />">sess3</a>

<pre>
[${sessionScope.myTestValue}]
</pre>
</body>

</html>
