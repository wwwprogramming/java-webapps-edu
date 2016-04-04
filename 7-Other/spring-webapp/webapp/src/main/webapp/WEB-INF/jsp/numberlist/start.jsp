<%@ include file="../../init.jspf" %>



<h1>A number, please</h1>

<spring:url value="/numberlist/get" htmlEscape="true" var="postUrL"/>


<form method="post" action="${postUrL}">
Number: <input type="text" name="number" /> <br />
<input type="submit" name="send" value="send"  />

</form>

<hr />

<c:forEach items="${sessionScope.arrayListOfNumbers}" var="item1" >
    Number: ${item1}<br />
</c:forEach>

<c:forEach items="${arrayListOfNumbers}" var="item2" >
    Number: ${item2}<br />
</c:forEach>