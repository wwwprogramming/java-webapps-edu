<%@ include file="../../init.jspf" %>


<c:if test="${correctAnswer}">
<p>You did have correct answer: Games played: ${gamesPlayed}. Correct Answers: ${gamesWon}.</p>
</c:if>

<c:if test="${! correctAnswer}">
<p>You did NOT have correct answer: Games played: ${gamesPlayed}. Correct Answers: ${gamesWon}.</p>
</c:if>

<hr />

<h1>Make a calculation</h1>
<p>
How much is ${rand1} * ${rand2}?
</p>
<spring:url value="/quiz/quiz" htmlEscape="true" var="postUrL"/>
<form method="post" action="${postUrL}">
<table>
<tr><th>Answer</th><td><input type="text" value="" name="answer" /></td></tr>
</table>

<input type="submit" name="smit" value="MyQuess" />
</form>

<hr />
<p>
Quit: <a href='<spring:url value="/quiz/complete" htmlEscape="true" />'>I do not want to quiz anymore.</a>
</p>