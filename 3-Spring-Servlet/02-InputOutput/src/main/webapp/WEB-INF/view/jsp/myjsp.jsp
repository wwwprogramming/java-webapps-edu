<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<c:url value="/munlomake" />

<form action="<c:url value='/munlomake' />" method="POST">

<input type="text" nimi="Hannu" />
<button type="submit">LÄHTEÄ</button>

</form>