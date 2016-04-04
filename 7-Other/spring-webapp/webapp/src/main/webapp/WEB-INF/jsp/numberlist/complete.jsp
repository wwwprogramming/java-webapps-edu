<%@ include file="../../init.jspf" %>



<h1>Completed</h1>

Verify that session variable is empty.

<h2>Session</h2>
<c:forEach items="${sessionScope.arrayListOfNumbers}" var="item1" >
    Number: ${item1}<br />
</c:forEach>


<h2>Model</h2>
<c:forEach items="${arrayListOfNumbers}" var="item2" >
    Number: ${item2}<br />
</c:forEach>