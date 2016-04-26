<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Error has happened</h2>

${error}

<a href="<c:url value='/' />">Please go to home page</a>
</body>
</html>
