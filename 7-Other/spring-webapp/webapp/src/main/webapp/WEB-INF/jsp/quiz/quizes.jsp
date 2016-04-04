<%@ include file="../../init.jspf" %>

<h1>List of oll database quizes</h1>

<table>
<c:forEach items="${quizList}" var="quiz" >


<tr><th>Id</th><td>${quiz.id}</td></tr>
<tr><th>gamesPlayed</th><td>${quiz.gamesPlayed}</td></tr>
<tr><th>gamesWon</th>
    <td>
        ${quiz.gamesWon}
    </td>
</tr>
<tr><th>Player</th><td>
<c:if test="${quiz.user != null}">
    ${quiz.user.userName}
</c:if>
</td></tr>

</c:forEach>
</table>