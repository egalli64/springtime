<!-- http://thisthread.blogspot.com/2017/06/spitter-registration.html -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Spitter</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Your Profile</h1>
	<c:out value="${spitter.username}" /><br />
	<c:out value="${spitter.firstName}" />
	<c:out value="${spitter.lastName}" /><br />
	<c:out value="${spitter.email}" />
</body>
</html>
