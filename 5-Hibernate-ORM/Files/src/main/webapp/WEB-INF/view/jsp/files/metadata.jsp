<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:if test="${! empty newFileName}">
<p>Uploaded ${newFileName}</p>
</c:if>
<table>

    <c:forEach items="${metaData}" var="entry">
  <tr>
    <td>${entry.id}</td>
    <td>${entry.originalName}</td>
    <td>${entry.newName}</td>
    <td>${entry.size}</td>
    <td>${entry.user.username}</td>

  </tr>
    </c:forEach>

</table>

<hr />