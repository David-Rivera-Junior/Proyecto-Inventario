<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="public/css/estilo.css" />
    <link rel="stylesheet" type="text/css" href="./public/css/estilos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
    a{text-align: center}
    </style>
</head>
<body class="container-fluid">
            <jsp:include page="../componentes/navbar.jsp" />
			<div class="jumbotron text-center">
		  
			<img src="./public/images/utiles.png" width="100px" height="100px">
			  <h1 id="titulo">BIENVENIDO A STOCKRAGE</h1>
			  <h4>Orden y eficiencia, la mejor conveniencia</h4> 
			</div>
			
			<div class="row">
			
			    <div class="col-4 text-center">
			      <h3>Usuarios</h3>
			     <a href="http://localhost:8080/ProyectoInventario/UsuarioController?action=list"><img src="./public/images/users.png" class="rounded-circle" alt="Cinque Terre" width="150px" height="150px"></a>
			   </div>
			    
			    <div class="col-4 text-center">
			     <h3>Productos</h3>
			     <a href="http://localhost:8080/ProyectoInventario/ProductoController?action=list"><img src="./public/images/products.png" class="rounded-circle" alt="Cinque Terre" width="150px" height="150px"></a>
		    </div>
			    
			    <div class="col-4 text-center">
			      <h3>Proveedores</h3> 
			      <a href="http://localhost:8080/ProyectoInventario/ProveedorController?action=list"><img src="./public/images/proveedor.png" class="rounded-circle" alt="Cinque Terre" width="150px" height="150px"></a>
			    </div>
			</div>
			</body>
</html>