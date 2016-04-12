<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Spring ORM User</h2>


<form action="/account/register" method="POST" enctype="application/x-www-form-urlencoded" >
<table>

   <tr><td>Username</td><td><input type="text" name="username" /></td></tr>
   <tr><td>Password</td><td><input type="text" name="password" /></td></tr>
   <tr><td>Email</td><td><input type="text" name="email" /></td></tr>
   <tr><td>ROLE</td><td><input type="text" name="role" value="ROLE_USER" /></td></tr>

</table>
<button type="submit">I Want To Play Too!</button>
</form>
</body>
</html>
