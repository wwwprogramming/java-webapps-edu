<%@ include file="../../init.jspf" %>



<h1>A number, please</h1>

<p>

<spring:url value="/numberlist/get" htmlEscape="true" var="postUrL"/>


<form method="post" action="${postUrL}">
Number: <input type="text" name="number" /> <br />
<input type="submit" name="send" value="send"  />

</form>
</p>

<p>Print all the values from arraylist here.</p>

<c:forEach items="${arrayListOfNumbers}" var="item" >
    Number: ${item}<br />
</c:forEach>

<hr />

<spring:url value="/numberlist/complete" htmlEscape="true" var="completeUrL"/>

<a href="${completeUrL}">Quit</a>

<hr />

<c:forEach items="${sessionScope.arrayListOfNumbers}" var="item1" >
    Number: ${item1}<br />
</c:forEach>

