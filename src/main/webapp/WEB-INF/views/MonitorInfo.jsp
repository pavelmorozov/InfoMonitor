<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>MonitorInfo</title>
		
				
		<script src="${contextPath}/resources/jquery-1.11.1.min.js"></script>		
		
		<script src="${contextPath}/resources/script.js"></script>
		
		<link href="${contextPath}/resources/style.css" type="text/css" rel="stylesheet">
	</head>
<body>
	${contextPath}
	<div id="monitor">${monitor}</div>
	<a id="test" href="">--- === TEST AJAX === ---</a>
	<div id="monitorInfo"></div>
</body>
</html>