<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<c:if test="${not empty param.direct}" >
<c:remove scope="session" var="SPRING_SECURITY_REQUEST_KEY"/>
</c:if>

<c:if test="${not empty param.error}">
<div class="error-message">
<s_message code="" text="Virihe" />
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
</div>
</c:if>


<h1>Kirjaudu</h1>


<form method="post" action="${pageContext.request.contextPath}/login" id="loginForm">
    <div id="passwordLoginOption" class="form">
        <div class="row">
            <div class="label left">
                <label for="username">Tunnus:</label>
            </div>
            <div class="right">
                <div class="textWrapper">
                    <input type="text" id="username" name="username"/>
                </div>
            </div>
            <div class="cl"></div>
        </div>
        <div class="row">
            <div class="label left">
                <label for="password">Salasana:</label>
            </div>
            <div class="right">
                <div class="textWrapper">
                    <input type="password" id="password" name="password"/>
                </div>
            </div>
            <div class="cl"></div>
        </div>

        <div class="buttons">
            <input type="submit" value="Kirjaudu" id="loginFormSubmit"/>
        </div>
    </div>
</form>
</body>
</html>
