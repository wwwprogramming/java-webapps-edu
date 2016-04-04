<%@ include file="../../init.jspf" %>

<h1>Statistics</h1>

<table>
<tr><th>Games</th><td>${gamesPlayed}</td></tr>
<tr><th>Correct</th><td>${gamesWon}</td></tr>
<tr><th>Score</th>
    <td>
        <fmt:formatNumber type="percent" maxIntegerDigits="2" value="${score}" />
    </td>
</tr>
<tr><th>Game id</th><td>${quiz.id}</td></tr>

</table>