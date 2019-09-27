package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cds.daoImp.RolDaoImpl;
import com.cds.daoImp.UsuarioDaoImpl;
import com.cds.model.Roles;
import com.cds.model.Usuarios;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
	private RolDaoImpl rolDaoImpl = new RolDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/views/Login/Login.jsp").forward(request, response);
		String action = ValidateNullPointer.validateToString(request.getParameter("action"));
		switch (action) {
		case "add":
			request.setAttribute("listRol", rolDaoImpl.findAllRoles());
			request.getRequestDispatcher("./views/Usuario/addUsuario.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("usuarioList", usuarioDaoImpl.findAllUsuarios());
			request.getRequestDispatcher("./views/Usuario/listUsuario.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("usuarioList", usuarioDaoImpl.findAllUsuarios());
			request.getRequestDispatcher("./views/Usuario/listUsuario.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre_usuario = ValidateNullPointer.validateToString(request.getParameter("nombre"));
		String apellido_usuario = ValidateNullPointer.validateToString(request.getParameter("apellido"));
		String dui = ValidateNullPointer.validateToString(request.getParameter("dui"));
		String direccion = ValidateNullPointer.validateToString(request.getParameter("direccion"));
		String telefono = ValidateNullPointer.validateToString(request.getParameter("telefono"));
		String usuario = ValidateNullPointer.validateToString(request.getParameter("usuario"));
		String contraseña = ValidateNullPointer.validateToString(request.getParameter("contraseña"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		Roles rol = rolDaoImpl.findRolById(ValidateNullPointer.validateToLong(request.getParameter("rol")));
		long id_usuario = ValidateNullPointer.validateToLong(request.getParameter("id_usuario"));
		System.out.println(option);
		switch (option) {
		case "add":
			if ( nombre_usuario.equals("")|| apellido_usuario.equals("")|| dui.equals("")|| direccion.equals("")|| telefono.equals("")|| usuario.equals("")|| contraseña.equals("")
					|| rol==null) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				/*System.out.println(cantidad);System.out.println(id_producto);*/
				UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
				Usuarios usuarios = new Usuarios();
				usuarios.setRoles(rol);
				usuarios.setNombre(nombre_usuario);
				usuarios.setApellido(apellido_usuario);
				usuarios.setDui(dui);
				usuarios.setDireccion(direccion);
				usuarios.setTelefono(telefono);
				usuarios.setUsuario(usuario);
				usuarios.setPass(contraseña);
				long resultado = usuarioDaoImpl.saveUsuario(usuarios);
			}
			request.setAttribute("usuarioList", usuarioDaoImpl.findAllUsuarios());
			request.getRequestDispatcher("./views/Usuario/listUsuario.jsp").forward(request, response);
			request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			break;
		case "delete_redirect":
			List<Usuarios> listaUsuarioDelete = new ArrayList<Usuarios>();
			Usuarios usuarioDelete = new Usuarios();
			usuarioDelete.setIdUsuario(id_usuario);
			usuarioDelete.setNombre(nombre_usuario);
			listaUsuarioDelete.add(usuarioDelete);
			request.setAttribute("datos", listaUsuarioDelete);
			request.getRequestDispatcher("./views/Usuario/deleteUsuario.jsp").forward(request, response);
			break;
		case "delete":
			System.out.println(id_usuario);
			usuarioDaoImpl.deleteUsuario(id_usuario);
			request.setAttribute("usuarioList", usuarioDaoImpl.findAllUsuarios());
			request.getRequestDispatcher("./views/Usuario/listUsuario.jsp").forward(request, response);
			request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
      	  	break;
		case "update_redirect":
			request.setAttribute("listRol", rolDaoImpl.findAllRoles());
			List<Usuarios> listaUsuario = new ArrayList<Usuarios>();
			Usuarios usuarios = new Usuarios(id_usuario, nombre_usuario, apellido_usuario, dui, direccion, telefono, usuario, contraseña, rol);
			listaUsuario.add(usuarios);
			request.setAttribute("datos", listaUsuario);
      	  request.getRequestDispatcher("./views/Usuario/updateUsuario.jsp").forward(request, response);
      	  break;
		case "update_data":
			Usuarios usuarioUpdate = new Usuarios(id_usuario, nombre_usuario, apellido_usuario, dui, direccion, telefono, usuario, contraseña, rol);
			usuarioDaoImpl.updateUsuario(usuarioUpdate);
			request.setAttribute("usuarioList", usuarioDaoImpl.findAllUsuarios());
			request.getRequestDispatcher("./views/Usuario/listUsuario.jsp").forward(request, response);
			request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
      	  	break;
		default: System.out.println(option);
			break;
		}
	}

}
