<%@ include file="../../init.jspf" %>



<h1>Test form</h1>


<form method="post" action="${pageContext.request.contextPath}/formexample/dilledong" id="exampleForm">
    <table>
    <tr><th>Name:</th><td><input type="text" name="name" value="dorisday" /></td></tr>
    </table>

        <div class="buttons">
            <input type="submit" value="Submit" id="loginFormSubmit"/>
        </div>

</form>