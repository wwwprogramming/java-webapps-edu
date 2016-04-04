<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:if test="${! empty newFileName}">
<p>Uploaded ${newFileName}</p>
</c:if>
<table>

    <c:forEach items="${fileList}" var="entry">
  <tr>      <td>${entry.key}</td><td>${entry.value}</td></tr>
    </c:forEach>

</table>

<hr />