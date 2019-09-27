<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listUsuario</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <script src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="public/css/estilo.css" />
	<link rel="stylesheet" type="text/css" href="./public/css/estilos.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">

	<jsp:include page="../componentes/navbar.jsp" />
	 <h1 class="text-center mt-fixed-nav" id="">LISTADO DE USUARIOS</h1>
	 <container class="col-10 offset-1">
	     <table class="table table-striped text-center" id="tableUsuario">
			<thead>
			<tr>
				<th>Correlativo</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>DUI</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Usuario</th>
				<th>Contraseña</th>
				<th>Rol</th>
				<th>Editar</th>
				<th>Eliminar</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${usuarioList}" var="usuario">
			<tr>
				<td>${usuario.idUsuario}</td>
				<td>${usuario.nombre}</td>
				<td>${usuario.apellido}</td>
				<td>${usuario.dui}</td>
				<td>${usuario.direccion}</td>
				<td>${usuario.telefono}</td>
				<td>${usuario.usuario}</td>
				<td>${usuario.pass}</td>
				<td>${usuario.roles.rol}</td>
				
				<td>
					<form action="<c:url value="/UsuarioController"/>" method="POST">
	                           <input type="hidden" name="option" value="update_redirect">
	                           <input type="hidden" name="id_usuario" value="${usuario.idUsuario}">
	                           <input type="hidden" name="nombre" value="${usuario.nombre}">
	                           <input type="hidden" name="apellido" value="${usuario.apellido}">
	                           <input type="hidden" name="dui" value="${usuario.dui}">
	                           <input type="hidden" name="direccion" value="${usuario.direccion}">
	                           <input type="hidden" name="telefono" value="${usuario.telefono}">
	                           <input type="hidden" name="usuario" value="${usuario.usuario}">
	                           <input type="hidden" name="contraseña" value="${usuario.pass}">
	                           <input type="hidden" name="rol" value="${usuario.roles.idRol}">
	                           <input type="submit" value="Editar" class="btn btn-outline-success col-12">
					</form>
				</td>
				<td>
					<form action="<c:url value="/UsuarioController"/>" method="POST">
	                           <input type="hidden" name="option" value="delete_redirect">
	                           <input type="hidden" name="id_usuario" value="${usuario.idUsuario}">
	                           <input type="hidden" name="nombre" value="${usuario.nombre}">
	                           <input type="hidden" name="apellido" value="${usuario.apellido}">
	                           <input type="submit" value="Eliminar" class="btn btn-outline-danger col-12">
					</form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
  </container>
  <script>
            $(document).ready(function() {
            $('#tableUsuario').DataTable( {
                "language": {
                    "lengthMenu": "Mostrar _MENU_ ",
                    "zeroRecords": "Registro no encontrado",
                    "info": "Mostar páginas _PAGE_ de _PAGES_",
                    "infoEmpty": "Datos no encontrados",
                    "infoFiltered": "(Filtrados por _MAX_ total registros)",
                    "search":         "Buscar:",
                    "paginate": {
                            "first":      "First",
                            "last":       "Anterior",
                            "next":       "Siguiente",
                            "previous":   "Anterior"
                    },
                    
                }
            } );
            } );
           
        </script>
</body>
</html>