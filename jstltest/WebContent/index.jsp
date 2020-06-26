<%@page import="org.w3c.dom.html.HTMLElement"%>
<%@page import="org.w3c.dom.html.HTMLObjectElement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="css/estilos.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<%
				String errorLogin = (String) request.getAttribute("loginStatus");
			if (errorLogin !="0" && errorLogin != null) 
			{
				String mensajeError = "<div class='alert alert-danger' role='alert'>" + "Error en inicio de sesión: " + errorLogin
				+ "</div>";
				out.println(mensajeError);
			}
			%>
			<div class="fadeIn first">
				<img src="https://image.flaticon.com/icons/svg/1548/1548286.svg"
					id="icon" alt="User Icon" />
			</div>
			<form action="procesaLogin" method="POST">
				<input type="text" id="login" class="fadeIn second" name="login"
					placeholder="login"> <input type="text" id="password"
					class="fadeIn third" name="pass" placeholder="password"> <input
					type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<div id="formFooter">
				<a class="underlineHover" href="#">Olvido la clave?</a>
			</div>

		</div>
	</div>
</body>
</html>