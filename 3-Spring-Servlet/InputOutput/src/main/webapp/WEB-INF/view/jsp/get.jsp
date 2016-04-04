<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<ul>
<li>${theParameter1}</li>
<li>${theParameter2}</li>

</ul>

<p><c:out value="${theParameter1}" /></p>
<p><c:out value="${theParameter2}" /></p>

<fieldset class="myblock">
<label>GET 1 simple mapping</label>
<a href="/get1">get 1</a>
<a href='<c:url value="/get1"/>'>get 1</a>
</fieldset>

<fieldset class="myblock">
<label>GET 2 URL parameters</label>
<a href="/get2?id=123">get 1</a>
<a href='<c:url value="/get2?id=123"/>'>get 1</a>
</fieldset>


<fieldset class="myblock">
<label>GET 3 path as variable</label>
<a href="/get3/123?name=John">get 1</a>
<a href='<c:url value="/get3/123?name=John"/>'>get 1</a>
</fieldset>