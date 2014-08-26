<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id='TwoFlightsRegistrationInfoForm' class='updateForm' >
    <fieldset>
	    <legend>Регистрация двух рейсов</legend>
	    <label>Выберите первый рейс</label>
	    <select id="flight1" name="flight1">
			<c:if test="${!empty regularFlightList}">
				<c:forEach items="${regularFlightList}" 
					var="listElement"  varStatus="status">
						<option value="${listElement.id}">
							${listElement.flightNumber} ${listElement.flightDestination.airPort}
						</option>				
				</c:forEach>
			</c:if>
		</select>
		<label>Выберите второй рейс</label>
	    <select id="flight2" name="flight2">
			<c:if test="${!empty regularFlightList}">
				<c:forEach items="${regularFlightList}" 
					var="listElement"  varStatus="status">
						<option value="${listElement.id}">
							${listElement.flightNumber} ${listElement.flightDestination.airPort}
						</option>				
				</c:forEach>
			</c:if>
		</select>
		<label>Для отображения информации нажмите "Обновить"</label>
	   	<div class="modal-footer">
	    	<button type="submit" class="btn"  id="TwoFlightRegistrationInfoFormBtn">Обновить</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		</div>
    </fieldset>
</form>