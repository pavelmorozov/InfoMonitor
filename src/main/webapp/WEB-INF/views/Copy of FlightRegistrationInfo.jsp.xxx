<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		${monitorInfo.flight.flightCompany.imagePath}
		<br>
		${monitorInfo.flight.flightDestination.airPort}
		<br>
		<br>

		<c:if test="${!empty monitorInfo.flight.flightDestination.destinationMultiLanguage}">
			<table>
				<c:forEach items="${monitorInfo.flight.flightDestination.destinationMultiLanguage}" 
					var="listElement">
					<tr>
						<td>
								${listElement.airPortMultiLanguage} (${monitorInfo.flight.flightDestination.airPort}) <br>
						</td>							
					</tr>
				</c:forEach>
			</table>	
		</c:if>
		
		<br>
		<br>

<!--  	<c:if test="${!empty monitorInfo.flight.codeShare}">
			<c:forEach items="${monitorInfo.flight.codeShare}" 
				var="listElement">
					${listElement.flightCompany.imagePath} 
					${listElement.flightNumber} <br>
			</c:forEach>
		</c:if> -->	
		
		<br>
		
		${monitorInfo.flight.flightNumber}
		<br>		
		${monitorInfo.flightClass.className}
		<br>
	
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>FlightRegistrationInfo</title>
	</head>
	<body>

		${monitorInfo.flight.flightCompany.imagePath}
		<br>
		${monitorInfo.flight.flightDestination.airPort}
		<br>
		<br>

		<c:if test="${!empty monitorInfo.flight.flightDestination.destinationMultiLanguage}">
			<c:forEach items="${monitorInfo.flight.flightDestination.destinationMultiLanguage}" 
				var="listElement">
				<tr>
					<td>
							${listElement.airPortMultiLanguage} (${monitorInfo.flight.flightDestination.airPort}) <br>
					</td>							
				</tr>
			</c:forEach>
		</c:if>
		<br>
		<br>

		<c:if test="${!empty monitorInfo.flight.codeShare}">
			<c:forEach items="${monitorInfo.flight.codeShare}" 
				var="listElement">
					${listElement.flightCompany.imagePath} 
					${listElement.flightNumber} <br>
			</c:forEach>
		</c:if>
		
		<br>
		
		${monitorInfo.flight.flightNumber}
		<br>		
		${monitorInfo.flightClass.className}
		<br>
		
		
		
	</body>
</html>-->