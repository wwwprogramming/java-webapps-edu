<%@ include file="../init.jspf" %>


<h2>Result</h2>
 <spring:hasBindErrors name="form">
	<c:forEach var="error" items="${errors.allErrors}">
		<b><spring:message message="${error}" /></b>
		<br />
	</c:forEach>
    </spring:hasBindErrors>

<table>
<tr><th>Numbers sold</th><td>${form.numSold}</td></tr>
<tr><th>Car</th><td>${form.car}</td></tr>
<tr><th>ExpensiveCar (ferrari or bugatti)</th><td>${form.expensiveCar}</td></tr>
<%--
<tr><th>CheapCar</th><td><c:if test="${not empty form.cheapCar}">${form.cheapCar.code}</c:if>
--%>
</td></tr>


</table>


</form>