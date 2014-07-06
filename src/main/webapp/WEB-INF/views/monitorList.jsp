<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />		
		<title>Monitors list</title>
		<script src="${contextPath}/resources/jquery-1.11.1.min.js"></script>
		<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/userscript.js"></script>
		<link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
		<link href="${contextPath}/resources/userstyle.css" type="text/css" rel="stylesheet">		
	</head>
	<body>
		<div class ="container"/>
			<h1  class="text-center">Международный аэропорт Днепропетровск</h1>
			<h2  class="text-center">Управление мониторами</h2>
			<c:if test="${!empty monitorList}">
				<table class="table table-hover">
					<tr>
						<th>Монитор</th>
						<th></th>
						<th>Состояние</th>
					</tr>
					<c:forEach items="${monitorList}" var="listElement">
						<tr>
							<td>
								<a href="showAJAX?monitorName=${listElement.monitorName}">
									${listElement.monitorName} 
								</a>
							</td>
							<td>
								<a href="#changeInfo" role="button" class="btn" data-monitor="${listElement.monitorName}">
									<i class="icon-pencil"></i>  
								</a>
							</td>						
							<td>
								<c:if test="${listElement.monitorInfo.class.simpleName == 'FlightRegistrationInfo'}">
									${listElement.monitorInfo.flight.flightNumber}
									(${listElement.monitorInfo.flight.flightDestination.airPort})
									${listElement.monitorInfo.flight.flightCompany.name} - 
									${listElement.monitorInfo.flightClass.className}
								</c:if>								
								<c:if test="${listElement.monitorInfo.class.simpleName == 'ImageInfo'}">
									${listElement.monitorInfo.imageName}
								</c:if>
								<c:if test="${listElement.monitorInfo.class.simpleName == 'TwoFlightsRegistrationInfo'}">
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


			<!-- Modal -->
			<div id="monitorChangeData" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="monitorChangeName"></h3>
				</div>
				<div class="modal-body">
					<p>Выберите вид информации для монитора</p>
					<select id='monitorInfoClass'>
						<option value='empty'></option>
						<option value='FlightRegistrationInfo'>Регистрация рейса</option>
						<option value='TwoFlightsRegistrationInfo'>Регистрация двух рейсов</option>
						<option value='ImageInfo'>Изображение</option>
					</select>
					<div id="updateInfoForm">
					</div>				    					
<!-- 				    <form id='TwoFlightsRegistrationInfoForm' class='updateForm'>
					    <fieldset>
						    <legend>Два рейса</legend>
					    </fieldset>
				    </form>
					<form id='ImageInfoForm' class='updateForm'>
					    <fieldset>
						    <legend>Изображение</legend>
					    </fieldset>
				    </form>
 -->					
					
					
					
					
					
					
					
					
					
					
				
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
					<button class="btn btn-primary">Save changes</button>
				</div>
			</div>


		</div>
	</body>
</html>