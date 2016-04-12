<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello The HTTP</h2>


<pre>
[${justatest}]
[${moretest}]
[${yetanothertest}]
----------
[${id}]
[${name}]

</pre>

<fieldset class="myblock">
<label>GET 1 simple mapping</label>
<a href="/get1">get 1</a>
<a href='<c:url value="/get1"/>'>get 1</a>
</fieldset>

<fieldset class="myblock">
<label>GET 2 URL parameters</label>
<a href="/get2?id=123">get 1</a>
<a href='<c:url value="/get2?id=123"/>'>get 1</a>
</fieldset>


<fieldset class="myblock">
<label>GET 3 path as variable</label>
<a href="/get3/123?name=John">get 1</a>
<a href='<c:url value="/get3/123?name=John"/>'>get 1</a>
</fieldset>

<fieldset class="myblock">
<label>GET 5 ModelAttribute with path and RequestParam</label>
<a href="/testannotations/123?name=John">get 5</a>
<a href='<c:url value="/get3/123?name=John"/>'>get 1</a>
</fieldset>

<hr />

<h1>Test form</h1>

<ul>
<li>${value1}</li>
<li>${value2}</li>
<li>${value3}</li>
<c:if test="${! empty exampleForm2}">
    <li>${exampleForm2.atext}</li>
    <li>${exampleForm2.bselect}</li>
    <li>${exampleForm2.chidden}</li>
    <li>${exampleForm2.justPojo.extra}</li>
</c:if>
</ul>


<fieldset class="myblock">
<label>Post 1</label>

<form action='<c:url value="post1"/>' method="POST">
<table>
<tr><th>Text</th><td><input type="text" name="atext" value="John" ></td></tr>
<tr><th>Select</th><td>
<select name="bselect">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
</select>
</td></tr>
<tr><th>Hidden</th><td><input type="hidden" name="chidden" value="Jane" ></td></tr>
</table>
<button type="submit">Post 1</button>
</form>
</fieldset>



<fieldset class="myblock">
<label>Post 2</label>

<form action='<c:url value="post2"/>' method="POST">
<table>
<tr><th>Text</th><td><input type="text" name="atext" value="John" ></td></tr>
<tr><th>Select</th><td>
<select name="bselect">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
</select>
</td></tr>
<tr><th>Hidden</th><td><input type="hidden" name="chidden" value="Jane" ></td></tr>
</table>
<button type="submit">Post 2</button>
</form>
</fieldset>


<fieldset class="myblock">
<label>Post 3</label>

<form action='<c:url value="post3"/>' method="POST">
<table>
<tr><th>Text</th><td><input type="text" name="atext" value="John" ></td></tr>
<tr><th>Select</th><td>
<select name="bselect">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="C">C</option>
</select>
</td></tr>
<tr><th>Hidden</th><td><input type="hidden" name="chidden" value="Jane" ></td></tr>
<tr><th>Hidden justpojo</th><td><input type="hidden" name="justPojo.extra" value="MyExtra" ></td></tr>
</table>
<button type="submit">Post 3</button>
</form>
</fieldset>


<fieldset class="myblock">
<label>Post 4</label>
<form method="post" action="${pageContext.request.contextPath}/formexample/dilledong" id="exampleForm">
    <table>
    <tr><th>Name:</th><td><input type="text" name="name" value="dorisday" /></td></tr>
    </table>

        <div class="buttons">
            <input type="submit" value="Submit" id="loginFormSubmit"/>
        </div>

</form>
</fieldset>


</body>
</html>
