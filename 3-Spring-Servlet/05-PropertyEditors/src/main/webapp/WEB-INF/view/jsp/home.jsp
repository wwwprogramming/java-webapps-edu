<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Init Binder Example with Custom Property Editors!</h2>

<form action="<c:url value='/' />" method="POST">

<table>

<tr><th>Age</th><td><input type="text" name="age" value="ten years" /></td></tr>
<tr><th>Color (1=red, 2=blue)</th><td><input type="text" name="color" value="1" /></td></tr>
<tr><th>Id not bound</th><td><input type="text" name="id" value="1" /></td></tr>

</table>
<button type="submit">TEST</button>
</form>
</body>
</html>
