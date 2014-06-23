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
							<a href="show?monitorName=${listElement.monitorName}">
								${listElement.monitorName}
							</a>
						</td>							
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>