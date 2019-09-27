<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list Producto</title>
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
	 <h1 class="text-center mt-fixed-nav" id="">LISTADO DE PRODUCTOS</h1>
	 <container class="col-10 offset-1">
	     <table class="table table-striped text-center" id="tableProducto">
			<thead>
			<tr>
				<th>Correlativo</th>
				<th>Producto</th>
				<th>Presentacion</th>
				<th>Cantidad</th>
				<th>Marca</th>
				<th>Categoria</th>
				<th>Editar</th>
				<th>Eliminar</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${productoList}" var="producto">
			<tr>
				<td>${producto.idProducto}</td>
				<td>${producto.nombreProducto}</td>
				<td>${producto.presentacion}</td>
				<td>${producto.cantidad}</td>
				<td>${producto.marcas.nombreMarca}</td>
				<td>${producto.categorias.nombreCategoria}</td>
				
				<td>
					<form action="<c:url value="/ProductoController"/>" method="POST">
	                           <input type="hidden" name="option" value="update_redirect">
	                           <input type="hidden" name="id_producto" value="${producto.idProducto}">
	                           <input type="hidden" name="nombre_producto" value="${producto.nombreProducto}">
	                           <input type="hidden" name="presentacion" value="${producto.presentacion}">
	                           <input type="hidden" name="cantidad" value="${producto.cantidad}}">
	                           <input type="hidden" name="id_marca" value="${producto.marcas.idMarca}">
	                           <input type="hidden" name="id_categoria" value="${producto.categorias.idCategoria}">
	                           <input type="submit" value="Editar" class="btn btn-outline-success col-10">
					</form>
				</td>
				<td>
					<form action="<c:url value="/ProductoController"/>" method="POST">
	                           <input type="hidden" name="option" value="delete_redirect">
	                           <input type="hidden" name="id_producto" value="${producto.idProducto}">
	                           <input type="hidden" name="nombre_producto" value="${producto.nombreProducto}">
	                           <input type="submit" value="Eliminar" class="btn btn-outline-danger col-10">
					</form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
  </container>
  <script>
            $(document).ready(function() {
            $('#tableProducto').DataTable( {
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