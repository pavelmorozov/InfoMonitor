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
		
		<c:if test="${!empty monitorInfo.flight.codeShare}">
			<c:forEach items="${monitorInfo.flight.codeShare}" 
				var="listElement">
					${listElement.flightCompany.imagePath} 
					${listElement.flightNumber} <br>
			</c:forEach>
		</c:if>		
		
		${monitorInfo.flight.flightNumber}
		<br>		
		${monitorInfo.flightClass.className}
		<br>