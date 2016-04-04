<%@ include file="../../init.jspf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<title></title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="<c:url value='/resources/css/quiz.css' />" type="text/css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

	<header class="header">

	<tiles:insertAttribute name="header" />
	</header><!-- .header-->

	<div class="middle">

		<div class="container">
			<main class="content">
				<tiles:insertAttribute name="bodyTemplate" />
		</div><!-- .container-->

		<aside class="left-sidebar">
<tiles:insertAttribute name="menu" />

	</div><!-- .middle-->

	<footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer><!-- .footer -->

</div><!-- .wrapper -->

</body>
</html>