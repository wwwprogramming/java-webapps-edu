<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<pre>
[${justatest}]
[${moretest}]
[${yetanothertest}]
----------
[${id}]
[${name}]

</pre>

<fieldset class="myblock">
<label>GET 1 simple mapping</label>
<a href="/get1">get 1</a>
<a href='<c:url value="/get1"/>'>get 1</a>
</fieldset>

<fieldset class="myblock">
<label>GET 2 URL parameters</label>
<a href="/get2?id=123">get 2</a>
<a href='<c:url value="/get2?id=123"/>'>get 2</a>
</fieldset>


<fieldset class="myblock">
<label>GET 3 path as variable</label>
<a href="/get3/123?name=John">get 3</a>
<a href='<c:url value="/get3/123?name=John"/>'>get 3</a>
</fieldset>

<fieldset class="myblock">
<label>GET 4 ModelAttribute with path and RequestParam</label>
<a href="/testannotations/123?name=John">get 4</a>
<a href='<c:url value="/testannotations/123?name=John"/>'>get 4</a>
</fieldset>

<ul>
<li><a href='<c:url value="/output1"/>'>Output 1</a></li>
<li><a href='<c:url value="/output2"/>'>Output 2</a></li>
<li><a href='<c:url value="/output3"/>'>Output 3</a></li>
<li><a href='<c:url value="/testget?a=1&id=1&id=2&name=John"/>'>/testget</a></li>

</ul>