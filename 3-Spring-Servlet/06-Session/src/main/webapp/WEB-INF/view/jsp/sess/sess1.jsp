<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>

<body>

<a href="<c:url value='/sess2' />">sess2</a>


<pre>
[${sessionScope.myTestValue}]
</pre>
</body>

</html>
