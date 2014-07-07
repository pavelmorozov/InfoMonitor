<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id='FlightRegistrationInfoForm' class='updateForm' >
    <fieldset>
	    <legend>Регистрация рейса</legend>
	    <label>Выберите рейс</label>
	    <select id="flight" name="flight">
			<c:if test="${!empty regularFlightList}">
				<c:forEach items="${regularFlightList}" 
					var="listElement"  varStatus="status">
						<option value="${listElement.id}">
							${listElement.flightNumber} ${listElement.flightDestination.airPort}
						</option>				
				</c:forEach>
			</c:if>
		</select>
		<label>Выберите класс</label>
	    <select id="flightClass" name="flightClass">
			<c:if test="${!empty classList}">
				<c:forEach items="${classList}" 
					var="listElement"  varStatus="status">
						<option value="${listElement.id}">
							${listElement.className}
						</option>				
				</c:forEach>
			</c:if>
		</select>
		<label>Для отображения информации нажмите "Обновить"</label>
	    <button type="submit" class="btn"  id="FlightRegistrationInfoFormBtn">Обновить</button>
    </fieldset>
</form>