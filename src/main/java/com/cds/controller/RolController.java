package com.cds.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.daoImp.RolDaoImpl;
import com.cds.model.Roles;
import com.cds.util.ValidateNullPointer;


/**
 * Servlet implementation class RolController
 */
@WebServlet("/RolController")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolDaoImpl rolDaoImpl = new RolDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
    public RolController() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = ValidateNullPointer.validateToString(request.getParameter("action"));
		switch (action) {
		case "add":
			request.getRequestDispatcher("./views/Rol/addRol.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("rolList", rolDaoImpl.findAllRoles());
			request.getRequestDispatcher("./views/Rol/listRol.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("rolList", rolDaoImpl.findAllRoles());
			request.getRequestDispatcher("./views/Rol/addRol.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rol_name = ValidateNullPointer.validateToString(request.getParameter("rol"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		long id_rol = ValidateNullPointer.validateToLong(request.getParameter("id_rol"));
		System.out.println(option);
		switch (option) {
		case "add":
			if (rol_name.equals("")) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				Roles rol = new Roles(0l, rol_name, null);
				rolDaoImpl.saveRol(rol);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.setAttribute("rolList", rolDaoImpl.findAllRoles());
			request.getRequestDispatcher("./views/Rol/listRol.jsp").forward(request, response);	
			break;
		case "delete_redirect":
			List<Roles> listaRolDelete = new ArrayList<Roles>();
			Roles rolDelete = new Roles();
			rolDelete.setIdRol(id_rol);
			rolDelete.setRol(rol_name);
			listaRolDelete.add(rolDelete);
			request.setAttribute("datos", listaRolDelete);
			request.getRequestDispatcher("./views/Rol/deleteRol.jsp").forward(request, response);
			break;
		case "delete":
      	  	rolDaoImpl.deleteRol(id_rol);
      	  	request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
      	  	request.getRequestDispatcher("./views/Rol/deleteRol.jsp").forward(request, response);
			break;	
		case "update_redirect":
			List<Roles> listaRol = new ArrayList<Roles>();
			Roles rol = new Roles(id_rol, rol_name, null);
            listaRol.add(rol);
            request.setAttribute("datos", listaRol);
            request.getRequestDispatcher("./views/Rol/updateRol.jsp").forward(request, response);
			break;
		case "update_data":
  	   		Roles rolUpdate = new Roles(id_rol, rol_name, null);
  	   		rolDaoImpl.updateRol(rolUpdate);
  	   		request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
  	   		request.setAttribute("rolList", rolDaoImpl.findAllRoles());
  	   		request.getRequestDispatcher("./views/Rol/listRol.jsp").forward(request, response);	
  	   		break;	
		default: System.out.println(option);
			break;
		}
		
	}

}
