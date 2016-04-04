<%@ include file="../../init.jspf" %>
<div class="header">I am the header<br />

<spring:url value="/?language=en" htmlEscape="true" var="enUrL"/>
<spring:url value="/?language=fi" htmlEscape="true" var="fiUrL"/>


Language : <a href="${enUrL}">English</a>|<a href="${fiUrL}">Finnish</a>
</div>