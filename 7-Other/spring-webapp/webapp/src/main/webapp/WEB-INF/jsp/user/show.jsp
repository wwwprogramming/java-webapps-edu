<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>

<h2 class="columnHeading">Tili</h2>

<div class="item">
    <h3>${currentUser.firstName} ${currentUser.lastName} (${currentUser.userName})</h3>

    <table class="userDataTable">
        <tr><td colspan="2" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
        <tr><td>Nimi</td><td>${currentUser.firstName} ${currentUser.lastName}</td></tr>
        <tr><td>Kotiosoite</td><td>${fn:replace(currentUser.address, '\\n', '<br />')}</td></tr>
        <tr><td>S-posti</td><td>${currentUser.email}</td></tr>
        <tr><td>Puhelin</td><td>${currentUser.mobile}</td></tr>
        <tr><td>Synt.aika</td><td><joda:format pattern="dd.MM.yyyy" value="${currentUser.dateOfBirth}" /></td></tr>

        <tr><td colspan="2" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
        <tr><td>Luotu </td><td><joda:format pattern="dd.MM.yyyy" value="${currentUser.createdOn}" />.</td></tr>

        <tr><td>Muokattu </td><td><joda:format pattern="dd.MM.yyyy" value="${currentUser.modifiedOn}" />.</td></tr>


    </table>

</div>