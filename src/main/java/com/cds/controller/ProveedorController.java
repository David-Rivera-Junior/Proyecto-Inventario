package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.model.Proveedores;
import com.cds.daoImp.ProveedorDaoImpl;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class ProveedorController
 */
@WebServlet("/ProveedorController")
public class ProveedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProveedorDaoImpl proveedorDaoImpl = new ProveedorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorController() {
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
			request.getRequestDispatcher("./views/Proveedor/addProveedor.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Proveedor/listProveedor.jsp").forward(request, response);
		default:
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Proveedor/addProveedor.jsp").forward(request, response);
			break;
		}
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proveedor_name = ValidateNullPointer.validateToString(request.getParameter("proveedor"));
		String direccion = ValidateNullPointer.validateToString(request.getParameter("direccion"));
		String telefono = ValidateNullPointer.validateToString(request.getParameter("telefono"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		long id_proveedor = ValidateNullPointer.validateToLong(request.getParameter("id_proveedor"));
		System.out.println(option);
		switch (option) {
		case "add":
			
			if (proveedor_name.equals("") || direccion.equals("") || telefono.equals("")) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				Proveedores proveedor = new Proveedores(0l, proveedor_name, direccion, telefono, null);
				
				proveedorDaoImpl.saveProveedor(proveedor);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Proveedor/listProveedor.jsp").forward(request, response);	
			break;
		
		case "delete_redirect":
			List<Proveedores> listaProveedorDelete = new ArrayList<Proveedores>();
			Proveedores proveedorDelete = new Proveedores();
			proveedorDelete.setIdProveedor(id_proveedor);
			proveedorDelete.setNombreProveedor(proveedor_name);
			listaProveedorDelete.add(proveedorDelete);
			request.setAttribute("datos", listaProveedorDelete);
			request.getRequestDispatcher("./views/Proveedor/deleteProveedor.jsp").forward(request, response);
			break;
		case "delete":
			proveedorDaoImpl.deleteProveedor(id_proveedor);
			request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Proveedor/listProveedor.jsp").forward(request, response);
      	  	break;
		case "update_redirect":
			List<Proveedores> listaProveedor = new ArrayList<Proveedores>();
			Proveedores proveedor = new Proveedores(id_proveedor, proveedor_name, direccion, telefono, null);
			listaProveedor.add(proveedor);
			request.setAttribute("datos", listaProveedor);
      	  request.getRequestDispatcher("./views/Proveedor/updateProveedor.jsp").forward(request, response);
      	  break;
		case "update_data":
			Proveedores proveedorUpdate = new Proveedores(id_proveedor, proveedor_name, direccion, telefono, null);
			proveedorDaoImpl.updateProveedor(proveedorUpdate);
			request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
			request.setAttribute("proveedorList", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Proveedor/listProveedor.jsp").forward(request, response);
      	  	break;
		default: System.out.println(option);
			break;
		}
		
	}


}
