<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>TwoFlightsRegistrationInfo</title>
	</head>
	<body>

		${monitorInfo.flight1.flightCompany.imagePath}
		<br>
		${monitorInfo.flight2.flightCompany.imagePath}
		<br>		

		<c:if test="${!empty monitorInfo.flight1.flightDestination.destinationMultiLanguage}">
			<c:forEach items="${monitorInfo.flight1.flightDestination.destinationMultiLanguage}" 
				var="listElement">
				<tr>
					<td>
						${listElement.airPortMultiLanguage} (${monitorInfo.flight1.flightDestination.airPort}) <br>
					</td>							
				</tr>
			</c:forEach>
		</c:if>
		<br>
		
		<c:if test="${!empty monitorInfo.flight2.flightDestination.destinationMultiLanguage}">
			<c:forEach items="${monitorInfo.flight2.flightDestination.destinationMultiLanguage}" 
				var="listElement">
				<tr>
					<td>
						${listElement.airPortMultiLanguage} (${monitorInfo.flight2.flightDestination.airPort}) <br>
					</td>							
				</tr>
			</c:forEach>
		</c:if>
		<br>		
<br>

		
		${monitorInfo.flight1.flightNumber}
		<br>
		${monitorInfo.flight2.flightNumber}
		<br>		
	</body>
</html>