<%@ include file="../../init.jspf" %>


<h1>Single File Upload</h1>
	<form method="post" enctype="multipart/form-data" action='<spring:url value="/file/save" htmlEscape="true" />'>
		Upload File: <input type="file" name="file">
		<br /><br />
		Description: <input type="text" name="desc"/>
		<br/><br/><input type="submit" value="Upload">
	</form>
