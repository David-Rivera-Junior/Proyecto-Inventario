<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Iniciar sesión</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- ==========================NUEVO========================================== -->
	<link rel="stylesheet" type="text/css" href="./public/css/estilos.css">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="./public/images/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="./public/css/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="./public/css/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="./public/css/util.css">
	<link rel="stylesheet" type="text/css" href="./public/css/main.css">
<!--===============================================================================================-->

</head >
<body class="container" >
			<c:if test="${error != null}">
			   <c:out value="<section class='alert alert-danger col-6 offset-8 text-center abs-center' role='alert' id='alerta'> ${error} </section>" escapeXml="false"></c:out>				      
			<!-- Validacion de mensaje de dato agregado -->
		    </c:if>
		    
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form action="/ProyectoInventario/LoginController" method="POST" class="login100-form validate-form" id="frmMain">
					<span class="login100-form-title p-b-70">
						Bienvenido
					</span>
					<span class="login100-form-avatar">
						<img src="./public/images/avatar.png" alt="AVATAR">
					</span>

					<div class="wrap-input100 validate-input m-t-85 m-b-35" data-validate = "Enter username">
						<input class="input100" type="text" name="username" autocomplete="off">
						<span class="focus-input100" data-placeholder="Usuario"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-50" data-validate="Enter password">
						<input class="input100" type="password" name="pass" >
						<span class="focus-input100" data-placeholder="Contraseña" ></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" >
							Iniciar sesión
						</button>
					</div>

					<ul class="login-more p-t-190">
						
					</ul>
				</form>
			</div>
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>
	<script type="text/javascript" src="public/js/hideAlert.js" ></script>
<!--===============================================================================================-->
	<script src="./public/js/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/popper.js"></script>
	<script src="./public/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/moment.min.js"></script>
	<script src="./public/js/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="./public/js/main.js"></script>

</body>
</html>