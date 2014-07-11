<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>Добро пожаловать!</h1>
		<p>Для начала работы войдите в систему под своим логином:</p>
		<c:if test="${not empty param.error}">
			<p class="text-error"> Ошибка входа. Неверное имя пользователя или пароль.</p>
		</c:if>
		<form method="POST" action="<c:url value="/j_spring_security_check" />">
			<table>
				<tr>
					<td align="right">Логин</td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td align="right">Пароль</td>
					<td><input type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<a href="<c:url value="/register" />">Зарегистрироваться</a>
					<input type="submit" value="Войти" />
					</td>
				</tr>
			</table>
			user<br>
			erdqX3Es
		</form>
	</body>
</html>
