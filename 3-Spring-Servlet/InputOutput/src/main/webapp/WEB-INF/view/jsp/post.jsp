<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

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
