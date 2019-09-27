<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>updateUsuario</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="public/css/estilo.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
	<jsp:include page="../componentes/navbar.jsp" />
      <h1 class="text-center mt-fixed-nav">MODIFICAR USUARIO</h1>
      
       <section>
	           <form action="/ProyectoInventario/UsuarioController" method="POST" class="col-8 offset-2" id="frmMain">
			  		<c:forEach items="${datos}" var="usuario">
		                <section class="form-group row">
						    <label  class="col-2"><h3>Nombre:</h3></label>
						    <input type="hidden" class="form-control col-10" value="${usuario.idUsuario}" name="id_usuario">
						    <input type="hidden" value="update_data" name="option">
						    <input type="text" class="form-control col-10" value="${usuario.nombre}" name="nombre" autocomplete="off">
						</section >
						<section class="form-group row">
						    <label  class="col-2"><h3>Apellido:</h3></label>
						    <input type="text" class="form-control col-10" value="${usuario.apellido}" name="apellido" autocomplete="off">
						</section >    
						<section class="form-group row">
						    <label  class="col-2"><h3>DUI:</h3></label>
						    <input type="text" class="form-control col-10" value="${usuario.dui}" name="dui" autocomplete="off">
						</section >
						<section class="form-group row">
						    <label  class="col-3"><h3>Direccion:</h3></label>
						    <input type="text" class="form-control col-9" value="${usuario.direccion}" name="direccion" autocomplete="off">
						</section > 
						<section class="form-group row">
						    <label  class="col-2"><h3>Telefono:</h3></label>
						    <input type="text" class="form-control col-10" value="${usuario.telefono}" name="telefono" autocomplete="off">
						</section > 
						<section class="form-group row">
						    <label  class="col-2"><h3>Usuario:</h3></label>
						    <input type="text" class="form-control col-10" value="${usuario.usuario}" name="usuario" autocomplete="off">
						</section >
						<section class="form-group row">
						    <label  class="col-3"><h3>Contraseña:</h3></label>
						    <input type="text" class="form-control col-9" value="${usuario.pass}" name="contraseña" autocomplete="off">
						</section >
						<section class="form-group row">
							<label  class="col-3"><h3>Rol:</h3></label>
						    <select class="form-control col-8" name="rol">
						    <c:forEach items="${listRol}" var="rol">
						    <option class='form-control' value='${rol.idRol}'> ${rol.rol}</option>   
						    </c:forEach>
						</select>
				</section>  	
	                </c:forEach>
					<input type="submit" class="btn btn-outline-success col-2 offset-4" value="Guardar">
					<input type="reset" class="btn btn-outline-danger col-2" value="Limpiar">
		     </form>
	      </section>
		</section> 
	      <c:if test="${success != null}">
        	<section class="alert alert-danger col-4 offset-4 text-center" role="alert" id="alerta"> ${success} </section>
        	<a  class="btn btn-outline-success text-center col-4 offset-4" href="http://localhost:8080/ProyectoInventario/UsuarioController?action=list">Retornar a la lista principal</a>
      </c:if>  
</body>
</html>