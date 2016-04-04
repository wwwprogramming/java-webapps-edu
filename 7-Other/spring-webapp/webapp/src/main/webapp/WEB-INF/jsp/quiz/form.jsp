<%@ include file="../../init.jspf" %>


<h1>Make a calculation</h1>
<p>
How much is ${rand1} * ${rand2}?
</p>
<spring:url value="/quiz/quiz" htmlEscape="true" var="postUrL"/>
<form method="post" action="${postUrL}">
<table>
<tr><th><spring:message code="quiz.answer.th" text="Answer" /></th><td><input type="text" value="" name="answer" /></td></tr>
</table>

<input type="submit" name="smit" value="MyQuess" />
</form>