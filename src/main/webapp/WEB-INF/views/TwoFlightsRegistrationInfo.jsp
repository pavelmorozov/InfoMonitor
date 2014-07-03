<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div id="logo_top_1" style="background:url(${contextPath}/resources/img/${monitorInfo.flight1.flightCompany.imagePath}) no-repeat center center #fffefb;">
</div>

<div id="flight_number_1" >
	${monitorInfo.flight1.flightNumber}
</div>

<div id="destination_1"  class="carousel slide">
	<c:if test="${!empty monitorInfo.flight1.flightDestination.destinationMultiLanguage}">
		<div class="carousel-inner">
			<c:forEach items="${monitorInfo.flight1.flightDestination.destinationMultiLanguage}" 
				var="listElement"  varStatus="status">
					<div class="item
					<c:if test="${status.index==0}"> active</c:if>">
						${listElement.airPortMultiLanguage} (${monitorInfo.flight1.flightDestination.airPort})
					</div>
			</c:forEach>
	    </div>
	</c:if>		
</div>

<div id="two_fkights_break"></div>

<div id="logo_top_2"  style="background:url(${contextPath}/resources/img/${monitorInfo.flight2.flightCompany.imagePath}) no-repeat center center #fffefb;">
</div>

<div id="flight_number_2" >
	${monitorInfo.flight2.flightNumber}
</div>

<div id="destination_2"  class="carousel slide">
	<c:if test="${!empty monitorInfo.flight2.flightDestination.destinationMultiLanguage}">
		<div class="carousel-inner">
			<c:forEach items="${monitorInfo.flight2.flightDestination.destinationMultiLanguage}" 
				var="listElement"  varStatus="status">
					<div class="item
					<c:if test="${status.index==0}"> active</c:if>">
						${listElement.airPortMultiLanguage} (${monitorInfo.flight2.flightDestination.airPort})
					</div>
			</c:forEach>
	    </div>
	</c:if>		
</div>