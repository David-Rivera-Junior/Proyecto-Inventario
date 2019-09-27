  <nav class="navbar navbar-expand-sm bg-dark navbar-dark container-fluid" style="border-radius: 5px;">
  <!-- Brand -->
  <a class="navbar-brand" href="http://localhost:8080/ProyectoInventario/HomeController">STOCKRAGE</a>

  <!-- Links -->
  <ul class="navbar-nav ml-auto">
      <li class="nav-item">
         <a class="nav-link " style="color:white" href="http://localhost:8080/ProyectoInventario/HomeController">Home</a>
      </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Productos
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ProyectoInventario/ProductoController?action=add">Agregar Producto</a>
		<a class="dropdown-item" href="/ProyectoInventario/ProductoController?action=list">Listar Producto</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Marcas
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ProyectoInventario/MarcaController?action=add">Agregar Marca</a>
		<a class="dropdown-item" href="/ProyectoInventario/MarcaController">Listar Marca</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Categorías
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ProyectoInventario/CategoriaController?action=add">Agregar Categoría</a>
		<a class="dropdown-item" href="/ProyectoInventario/CategoriaController?action=list">Listar Categoría</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Roles
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item"class="dropdown-item" href="/ProyectoInventario/RolController?action=add">Agregar Rol</a>
		<a class="dropdown-item"  href="/ProyectoInventario/RolController?action=list">Listar Rol</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Proveedores
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ProyectoInventario/ProveedorController?action=add">Agregar Proveedor</a>
		<a class="dropdown-item" href="/ProyectoInventario/ProveedorController?action=list">Listar Proveedor</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Entradas
      </a>
      <div class="dropdown-menu">
       <a class="dropdown-item" href="/ProyectoInventario/EntradaController?action=add">Agregar Entrada</a>
	   <a class="dropdown-item" href="/ProyectoInventario/EntradaController?action=list">Listar Entrada</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Salidas
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="/ProyectoInventario/SalidaController?action=add">Agregar Salida</a>
	    <a class="dropdown-item" href="/ProyectoInventario/SalidaController?action=list">Listar Salida</a>
      </div>
    </li>
    
     <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Usuarios
      </a>
      <div class="dropdown-menu">
       <a class="dropdown-item" href="/ProyectoInventario/UsuarioController?action=add">Agregar Usuario</a>
        <a class="dropdown-item" href="/ProyectoInventario/UsuarioController?action=list">Listar Usuario</a>
      </div>
    </li>
    
     <li class="nav-item">
         <a class="nav-link btn btn-outline-danger" style="color:white" href="/ProyectoInventario/LoginController">Cerrar Sesión</a>
    </li>
  </ul>
</nav>
