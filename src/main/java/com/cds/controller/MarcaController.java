package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cds.model.Marcas;
import com.cds.model.Proveedores;
import com.cds.daoImp.MarcaDaoImpl;
import com.cds.daoImp.ProveedorDaoImpl;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class MarcaController
 */
@WebServlet("/MarcaController")
public class MarcaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MarcaDaoImpl marcaDaoImpl = new MarcaDaoImpl();
	private ProveedorDaoImpl proveedorDaoImpl = new ProveedorDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcaController() {
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
			request.setAttribute("listProveedor", proveedorDaoImpl.findAllProveedores());
			request.getRequestDispatcher("./views/Marca/addMarca.jsp").forward(request, response);
			break;
		case "lista":
			request.setAttribute("marcaList", marcaDaoImpl.findAllMarcas());
			request.getRequestDispatcher("./views/Marca/listMarca.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("marcaList", marcaDaoImpl.findAllMarcas());
			request.getRequestDispatcher("./views/Marca/listMarca.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String marca_name = ValidateNullPointer.validateToString(request.getParameter("marca"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		Proveedores proveedor = proveedorDaoImpl.findProveedorById(ValidateNullPointer.validateToLong(request.getParameter("proveedor")));
		long id_marca = ValidateNullPointer.validateToLong(request.getParameter("id_marca"));
		System.out.println(option);
		switch (option) {
		case "add":
			if (marca_name.equals("") || proveedor==null) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				MarcaDaoImpl marcaDaoImpl = new MarcaDaoImpl();
				Marcas marcas = new Marcas();
				marcas.setNombreMarca(marca_name);
				marcas.setProveedores(proveedor);
				long resultado = marcaDaoImpl.saveMarca(marcas);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.setAttribute("marcaList", marcaDaoImpl.findAllMarcas());
			request.getRequestDispatcher("./views/Marca/listMarca.jsp").forward(request, response);	
			break;
		case "delete_redirect":
			List<Marcas> listaMarcaDelete = new ArrayList<Marcas>();
			Marcas marcaDelete = new Marcas();
			marcaDelete.setIdMarca(id_marca);
			marcaDelete.setNombreMarca(marca_name);
			listaMarcaDelete.add(marcaDelete);
			request.setAttribute("datos", listaMarcaDelete);
			request.getRequestDispatcher("./views/Marca/deleteMarca.jsp").forward(request, response);
			break;
		case "delete":
      	  	marcaDaoImpl.deleteMarca(id_marca);
      	  	request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
      	  	request.setAttribute("marcaList", marcaDaoImpl.findAllMarcas());
			request.getRequestDispatcher("./views/Marca/listMarca.jsp").forward(request, response);
			break;	
		case "update_redirect":
			request.setAttribute("listProveedor", proveedorDaoImpl.findAllProveedores());
			List<Marcas> listaMarca = new ArrayList<Marcas>();
			Marcas marca = new Marcas(id_marca, marca_name, proveedor);
            listaMarca.add(marca);
            request.setAttribute("datos", listaMarca);
            request.getRequestDispatcher("./views/Marca/updateMarca.jsp").forward(request, response);
			break;
		case "update_data":
  	   		Marcas marcaUpdate = new Marcas(id_marca, marca_name, proveedor);
  	   		marcaDaoImpl.updateMarca(marcaUpdate);
  	   		request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
  	   		request.setAttribute("marcaList", marcaDaoImpl.findAllMarcas());
  	   		request.getRequestDispatcher("./views/Marca/listMarca.jsp").forward(request, response);
  	   		break;
		default: System.out.println(option);
			break;
		}
		
	}

}
