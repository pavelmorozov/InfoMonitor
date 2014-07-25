<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id='ImageInfoForm' class='updateForm' >
    <fieldset>
	    <legend>Изображение</legend>
	    <label>Выберите изображение</label>
	    <select id="image" name="image">
			<c:if test="${!empty imageList}">
				<c:forEach items="${imageList}" 
					var="listElement"  varStatus="status">
						<option value="${listElement.id}">
							${listElement.imageName}
						</option>				
				</c:forEach>
			</c:if>
		</select>
		<label>Для отображения информации нажмите "Обновить"</label>
	    <button type="submit" class="btn"  id="ImageInfoFormBtn">Обновить</button>
    </fieldset>
</form>