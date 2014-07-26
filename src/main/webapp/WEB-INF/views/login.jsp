<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Login</title>
		<script src="${contextPath}/resources/jquery-1.11.1.min.js"></script>
		<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="${contextPath}/resources/userscript.js"></script>
		<link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
		<link href="${contextPath}/resources/userstyle.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class ="container"/>
			<h1  class="text-center airport">Международный аэропорт Днепропетровск</h1>
			<h2  class="text-center">Управление мониторами</h2>

			<p>Для начала работы войдите в систему:</p>
			<c:if test="${not empty param.error}">
				<p class="text-error"> Ошибка входа. Неверное имя пользователя или пароль.</p>
			</c:if>
			<form method="POST" action="<c:url value="/j_spring_security_check" />">
				<table>
					<tr>
						<td><input type="text" class="input-medium" placeholder="Имя пользователя" name="j_username" /></td>
					</tr>
					<tr>
						<td><input type="password" class="input-medium" placeholder="Пароль" name="j_password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit"  class="btn" value="Войти" />
						</td>
					</tr>
				</table>
				user<br>
				erdqX3Es
			</form>
		</div>			
	</body>
</html>
