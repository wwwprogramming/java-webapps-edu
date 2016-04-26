<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<h2>Test Form</h2>

<s:hasBindErrors name="form">
	<c:forEach var="error" items="${errors.allErrors}">
		<b><s:message message="${error}" /></b>
		<br />
	</c:forEach>
    </s:hasBindErrors>

<table>
    <tr>
    <th><s:message code="form.th.age" text="Age..." /></th>
    <td></td>
    </tr>
    <tr>
    <th><s:message code="form.th.color" text="Color..." /></th>
    <td></td>
    </tr>
</table>


<ul>
 <li><a href="<c:url value='/' />">home</a></li>
</ul>