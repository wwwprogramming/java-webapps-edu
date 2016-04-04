<%@ include file="../../init.jspf" %>
<c:if test="${not empty param.direct}" >
<c:remove scope="session" var="SPRING_SECURITY_REQUEST_KEY"/>
</c:if>

<c:if test="${not empty param.error}">
<div class="error-message">
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
</div>
</c:if>


<h1>Kirjaudu</h1>


<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" id="loginForm">
    <div id="passwordLoginOption" class="form">
        <div class="row">
            <div class="label left">
                <label for="j_username">Tunnus:</label>
            </div>
            <div class="right">
                <div class="textWrapper">
                    <input type="text" id="j_username" name="j_username"/>
                </div>
            </div>
            <div class="cl"></div>
        </div>
        <div class="row">
            <div class="label left">
                <label for="j_password">Salasana:</label>
            </div>
            <div class="right">
                <div class="textWrapper">
                    <input type="password" id="j_password" name="j_password"/>
                </div>
            </div>
            <div class="cl"></div>
        </div>
        <div class="row">
            <div class="right">
                <label hidden style="display:none" class="forCheckbox" for='_spring_security_remember_me'>
                    Remember me:
                    <input hidden style="display:none" type='checkbox' id="_spring_security_remember_me" name='_spring_security_remember_me'/>
                </label>
            </div>
            <div class="cl"></div>
        </div>
        <div class="buttons">
            <input type="submit" value="Kirjaudu" id="loginFormSubmit"/>
        </div>
    </div>
</form>