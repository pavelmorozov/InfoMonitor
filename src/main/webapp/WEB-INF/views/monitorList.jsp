<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Monitors list</title>
	</head>
	<body>
		<c:if test="${!empty monitorList}">
			<table class="data">
				<tr>
					<th>Мониторы</th>
				</tr>
				<c:forEach items="${monitorList}" var="listElement">
					<tr>
						<td class = "datacell">
							<a href="showAJAX?monitorName=${listElement.monitorName}">
								${listElement.monitorName} 
							</a>
						</td>
						<td>
							<c:if test="${listElement.monitorInfo['class'].simpleName == 'FlightRegistrationInfo'}">
								${listElement.monitorInfo.flight.flightNumber}
								(${listElement.monitorInfo.flight.flightDestination.airPort})
								${listElement.monitorInfo.flight.flightCompany.name} - 
								${listElement.monitorInfo.flightClass.className}
							</c:if>								
							<c:if test="${listElement.monitorInfo['class'].simpleName == 'ImageInfo'}">
								${listElement.monitorInfo.imageName}
							</c:if>
							<c:if test="${listElement.monitorInfo['class'].simpleName == 'TwoFlightsRegistrationInfo'}">
								${listElement.monitorInfo.flight1.flightNumber}
								(${listElement.monitorInfo.flight1.flightDestination.airPort})
								${listElement.monitorInfo.flight1.flightCompany.name}; 

								${listElement.monitorInfo.flight2.flightNumber}
								(${listElement.monitorInfo.flight2.flightDestination.airPort})
								${listElement.monitorInfo.flight2.flightCompany.name}; 
							</c:if>																
						</td>							
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>