package com.cds.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.daoImp.EntradaDaoImpl;
import com.cds.model.Entradas;
import com.cds.model.Productos;
import com.cds.daoImp.ProductoDaoImpl;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class EntradaController
 */
@WebServlet("/EntradaController")
public class EntradaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntradaDaoImpl entradaDaoImpl = new EntradaDaoImpl();
    private ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntradaController() {
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
			request.setAttribute("listProduto", productoDaoImpl.findAllProductos());
			request.getRequestDispatcher("./views/Entrada/addEntrada.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("entradaList", entradaDaoImpl.findAllEntradas());
			request.getRequestDispatcher("./views/Entrada/listEntrada.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("entradaList", entradaDaoImpl.findAllEntradas());
			request.getRequestDispatcher("./views/Entrada/listEntrada.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		long cantidad = ValidateNullPointer.validateToLong(request.getParameter("cantidad"));
		Productos producto = productoDaoImpl.findProductosById(ValidateNullPointer.validateToLong(request.getParameter("producto")));
		long id_entrada = ValidateNullPointer.validateToLong(request.getParameter("id_entrada"));
		System.out.println(option);
		switch (option) {
		case "add":
			if (Long.valueOf(cantidad)==null || producto ==null) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				EntradaDaoImpl entradaDaoImpl = new EntradaDaoImpl();
				Entradas entradas = new Entradas();
				entradas.setCantidad(cantidad);
				entradas.setProductos(producto);
				long resultado = entradaDaoImpl.saveEntrada(entradas);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.setAttribute("entradaList", entradaDaoImpl.findAllEntradas());
			request.getRequestDispatcher("./views/Entrada/listEntrada.jsp").forward(request, response);	
			break;
		default: System.out.println(option);
			break;
		}
	}

}
