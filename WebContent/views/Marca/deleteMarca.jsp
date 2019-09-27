<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>deleteMarca</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="public/css/estilo.css" />
<link rel="stylesheet" type="text/css" href="./public/css/estilos.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
         <jsp:include page="../componentes/navbar.jsp" /> 
         
		 <h1 class="text-center mt-fixed-nav">ELIMINAR MARCA</h1>
		 
         <c:url value="/MarcaController" var="registerUrl" /> 
         <c:if test="${success == null}">
	         <form method="POST" action="${registerUrl}" class="col-6 offset-3">
	                <c:forEach items="${datos}" var="marca">
	                    <input type="hidden" name="option" value="delete">
	                    <input type="hidden" name="id_marca" value="${marca.idMarca}">
	                    <section class='alert alert-danger col-8 offset-2 text-center ' role='alert' id='alerta'>
	                        ¿Esta seguro de eliminar la marca ${marca.nombreMarca}?
	                    </section>               
	                </c:forEach>
	                <input type="submit" class="col-4 offset-4 btn btn-outline-danger" value="Eliminar" >
	        </form>
        </c:if>
		<c:if test="${success != null}">
        	<section class="alert alert-danger col-4 offset-4 text-center" role="alert" id="alerta"> ${success} </section>
        	<a  class="btn btn-outline-success text-center col-4 offset-4" href="http://localhost:8080/ProyectoInventario/MarcaController?action=list">Retornar a la lista principal</a>
      </c:if>
</body>
</html>