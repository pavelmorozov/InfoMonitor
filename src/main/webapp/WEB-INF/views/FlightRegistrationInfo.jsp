<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>	

<div id="logo_top" style="background:url(${contextPath}/resources/img/${monitorInfo.flight.flightCompany.imagePath}) no-repeat center center #fffefb;">
</div>
<div id="flight_number">
	${monitorInfo.flight.flightNumber}
</div>
<div id="destination"  class="carousel slide">
	<c:if test="${!empty monitorInfo.flight.flightDestination.destinationMultiLanguage}">
		<div class="carousel-inner">
			<c:forEach items="${monitorInfo.flight.flightDestination.destinationMultiLanguage}" 
				var="listElement"  varStatus="status">
					<div class="item destination_string
					<c:if test="${status.index==0}"> active</c:if>">
						${listElement.airPortMultiLanguage} (${monitorInfo.flight.flightDestination.airPort})
					</div>
			</c:forEach>
	    </div>
	</c:if>		
</div>
<div id="class"  style="color:#${monitorInfo.flightClass.classColor};">
	${monitorInfo.flightClass.className}
</div>
<c:if test="${!empty monitorInfo.flight.codeShare}">
	<c:forEach items="${monitorInfo.flight.codeShare}" 
		var="listElement" varStatus="status">
			<div class="cs">
				<div class="cs_number">
					${listElement.flightNumber}
					
				</div>
				<div class="cs_logo" style="background: url(${contextPath}/resources/img/${listElement.flightCompany.imagePath}) no-repeat center center / contain;">
				</div>
			</div>
	</c:forEach>
</c:if>