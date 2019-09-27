package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.model.Categorias;
import com.cds.daoImp.CategoriaDaoImpl;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/CategoriaController")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDaoImpl categoriaDaoImpl = new CategoriaDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaController() {
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
			request.getRequestDispatcher("./views/Categoria/addCategoria.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("categoriaList", categoriaDaoImpl.findAllCategorias());
			request.getRequestDispatcher("./views/Categoria/listCategoria.jsp").forward(request, response);
		default:
			request.setAttribute("categoriaList", categoriaDaoImpl.findAllCategorias());
			request.getRequestDispatcher("./views/Categoria/listCategoria.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria_name = ValidateNullPointer.validateToString(request.getParameter("categoria"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		long id_categoria = ValidateNullPointer.validateToLong(request.getParameter("id_categoria"));
		System.out.println(option);
		switch (option) {
		case "add":
			if (categoria_name.equals("")) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				Categorias categoria = new Categorias(0l, categoria_name, null);
				categoriaDaoImpl.saveCategoria(categoria);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.setAttribute("categoriaList", categoriaDaoImpl.findAllCategorias());
			request.getRequestDispatcher("./views/Categoria/listCategoria.jsp").forward(request, response);	
			break;
		case "delete_redirect":
			List<Categorias> listaCategoriaDelete = new ArrayList<Categorias>();
			Categorias categoriaDelete = new Categorias();
			categoriaDelete.setIdCategoria(id_categoria);
			categoriaDelete.setNombreCategoria(categoria_name);
			listaCategoriaDelete.add(categoriaDelete);
			request.setAttribute("datos", listaCategoriaDelete);
			request.getRequestDispatcher("./views/Categoria/deleteCategoria.jsp").forward(request, response);
			break;
		case "delete":
      	  	categoriaDaoImpl.deleteCategoria(id_categoria);
      	  	request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
      	  request.setAttribute("categoriaList", categoriaDaoImpl.findAllCategorias());
			request.getRequestDispatcher("./views/Categoria/listCategoria.jsp").forward(request, response);
			break;	
		case "update_redirect":
			List<Categorias> listaCategoria = new ArrayList<Categorias>();
			Categorias categoria = new Categorias(id_categoria, categoria_name, null);
            listaCategoria.add(categoria);
            request.setAttribute("datos", listaCategoria);
            request.getRequestDispatcher("./views/Categoria/updateCategoria.jsp").forward(request, response);
			break;
		case "update_data":
  	   		Categorias categoriaUpdate = new Categorias(id_categoria, categoria_name, null);
  	   		categoriaDaoImpl.updateCategoria(categoriaUpdate);
  	   		request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
  	   		request.setAttribute("categoriaList", categoriaDaoImpl.findAllCategorias());
  	   		request.getRequestDispatcher("./views/Categoria/listCategoria.jsp").forward(request, response);
  	   		break;	
		default: System.out.println(option);
			break;
		}
		
	}

}
