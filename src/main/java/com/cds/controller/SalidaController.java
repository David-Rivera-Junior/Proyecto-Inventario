package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cds.daoImp.ProductoDaoImpl;
import com.cds.daoImp.SalidaDaoImpl;
import com.cds.model.Categorias;
import com.cds.model.Marcas;
import com.cds.model.Productos;
import com.cds.model.Proveedores;
import com.cds.model.Salidas;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class SalidaController
 */
@WebServlet("/SalidaController")
public class SalidaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalidaDaoImpl salidaDaoImpl = new SalidaDaoImpl();
	private ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalidaController() {
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
			request.getRequestDispatcher("./views/Salida/addSalida.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("salidaList", salidaDaoImpl.findAllSalidas());
			request.getRequestDispatcher("./views/Salida/listSalida.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("salidaList", salidaDaoImpl.findAllSalidas());
			request.getRequestDispatcher("./views/Salida/listSalida.jsp").forward(request, response);
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
		long id_salida = ValidateNullPointer.validateToLong(request.getParameter("id_salida"));
		System.out.println( producto.getCantidad());
		System.out.println(option);
		switch (option) {
		case "add":
			if (Long.valueOf(cantidad)==null || Long.valueOf(producto.getCantidad())==null || cantidad > 0) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
				if(cantidad >producto.getCantidad() ) {
					
					request.setAttribute("error", "ERROR: LA CANTIDAD NO PUEDE SER MENOR A CERO");
					
				}else {
					Salidas salida = new Salidas();
					Productos producto_salida = new Productos();
					producto_salida.setIdProducto(producto.getIdProducto());
					producto_salida.setCategorias(new Categorias(0l));
					producto_salida.setMarcas(new Marcas(0l, "marca", new Proveedores(0l)));
					salida.setProductos(producto_salida);
					salida.setCantidad(cantidad);
					long resultado = salidaDaoImpl.saveSalida(salida);
					}
			} else {
				request.setAttribute("error", "NO HAY SUFICIENTES EXISTENCIAS");
				
			}
			request.setAttribute("salidaList", salidaDaoImpl.findAllSalidas());
			request.getRequestDispatcher("./views/Salida/listSalida.jsp").forward(request, response);
			break;
		default: System.out.println(option);
			break;
		}
	}

}
