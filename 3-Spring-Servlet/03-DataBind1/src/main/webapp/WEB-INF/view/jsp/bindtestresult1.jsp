<%@ include file="../init.jspf" %>
<html>
<head>
	<title>Binddemo results</title>
</head>
<body>

<h2>Result</h2>
 <spring:hasBindErrors name="bindValidateForm">
	<c:forEach var="error" items="${errors.allErrors}">
		<b><spring:message message="${error}" /></b>
		<br />
	</c:forEach>
    </spring:hasBindErrors>

<table>
<tr><th>Numbers sold</th><td>${bindValidateForm.numSold}</td></tr>
<tr><th>Car</th><td>${bindValidateForm.car}</td></tr>
<tr><th>ExpensiveCar (ferrari or bugatti)</th><td>${bindValidateForm.expensiveCar}</td></tr>
<%--
<tr><th>CheapCar</th><td><c:if test="${not empty bindValidateForm.cheapCar}">${bindValidateForm.cheapCar.code}</c:if>
--%>
</td></tr>
</table>
</form>

<hr />

<a href="/binddemo/form">/binddemo/form</a>

</body>
</html>