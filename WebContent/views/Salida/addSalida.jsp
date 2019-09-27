<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Salida</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="public/css/estilo.css" />  
<link rel="stylesheet" type="text/css" href="./public/css/estilos.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
	<jsp:include page="../componentes/navbar.jsp" />
	
      <h1 class="text-center mt-fixed-nav">AGREGAR SALIDA</h1>
      
      <c:if test="${error != null}">
        	<c:out value="<section class='alert alert-danger col-4 offset-4 text-center ' role='alert' id='alerta'> ${error} </section>" escapeXml="false"></c:out>
      </c:if>
      
      <c:if test="${success != null}">
        	<c:out value="<section class='alert alert-success col-4 offset-4 text-center ' role='alert' id='alerta'> ${success} </section>" escapeXml="false"></c:out>
      </c:if>
      
      <section class="transparente"> 
           <form action="/ProyectoInventario/SalidaController" method="POST" class="col-8 offset-2" id="frmMain">
		  		<section>
		  		<section class="form-group row">
				    <label  class="col-3"><h3>Cantidad:</h3></label>
				    <input type="hidden" value="add" name="option">
				    <input type="number" class="form-control col-4" name="cantidad" id="usuario" autocomplete="off">
				</section>
			    <section class="form-group row">
					<label  class="col-3"><h3>Producto:</h3></label>
				    <select type="hidden" value="add" class="form-control col-8" id="producto" name="producto">
				    <c:forEach items="${listProduto}" var="producto">
				    <option class='form-control' value='${producto.idProducto}'> ${producto.nombreProducto}</option>   
				    </c:forEach>
					</select>
				</section>
				<input type="submit" class="btn btn-outline-success col-2 offset-4" value="Guardar">
				<input type="reset" class="btn btn-outline-danger col-2" value="Limpiar">
	     </form>
	 </section>  
	<script type="text/javascript" src="resources/js/hideAlert.js" ></script>
</body>
</html>