package com.cds.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.model.Productos;
import com.cds.model.Categorias;
import com.cds.model.Marcas;
import com.cds.daoImp.CategoriaDaoImpl;
import com.cds.daoImp.MarcaDaoImpl;
import com.cds.daoImp.ProductoDaoImpl;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
	private CategoriaDaoImpl categoriaDaoImpl = new CategoriaDaoImpl();
	private MarcaDaoImpl marcaDaoImpl = new MarcaDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
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
			request.setAttribute("listMarca", marcaDaoImpl.findAllMarcas());
			request.setAttribute("listCategoria", categoriaDaoImpl.findAllCategorias());
			request.getRequestDispatcher("./views/Producto/addProducto.jsp").forward(request, response);
			break;
		case "list":
			request.setAttribute("productoList", productoDaoImpl.findAllProductos());
			request.getRequestDispatcher("./views/Producto/listProducto.jsp").forward(request, response);
		default:
			request.setAttribute("productoList", productoDaoImpl.findAllProductos());
			request.getRequestDispatcher("./views/Producto/listProducto.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre_producto = ValidateNullPointer.validateToString(request.getParameter("nombre_producto"));
		String presentacion = ValidateNullPointer.validateToString(request.getParameter("presentacion"));
		String option = ValidateNullPointer.validateToString(request.getParameter("option"));
		Marcas marcas = marcaDaoImpl.findMarcaById(ValidateNullPointer.validateToLong(request.getParameter("marca")));
		Categorias categorias = categoriaDaoImpl.findCategoriaById(ValidateNullPointer.validateToLong(request.getParameter("categoria")));
		long id_producto = ValidateNullPointer.validateToLong(request.getParameter("id_producto"));
		System.out.println(option);
		switch (option) {
		case "add":
			if (nombre_producto.equals("")|| presentacion.equals("") || marcas ==null || categorias==null) {
				request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			} else {
				/*System.out.println(cantidad);System.out.println(id_producto);*/
				ProductoDaoImpl productoDaoImpl = new ProductoDaoImpl();
				Productos productos = new Productos();
				productos.setNombreProducto(nombre_producto);
				productos.setPresentacion(presentacion);
				productos.setMarcas(marcas);
				productos.setCategorias(categorias);
				long resultado = productoDaoImpl.saveProducto(productos);
				request.setAttribute("success", "DATOS AGREGADOS DE FORMA SATISFACTORIA");
			}
			request.getRequestDispatcher("./views/Producto/addProducto.jsp").forward(request, response);	
			break;
		case "delete_redirect":
			List<Productos> listaProductoDelete = new ArrayList<Productos>();
			Productos productoDelete = new Productos();
			productoDelete.setIdProducto(id_producto);
			productoDelete.setNombreProducto(nombre_producto);
			listaProductoDelete.add(productoDelete);
			request.setAttribute("datos", listaProductoDelete);
			request.getRequestDispatcher("./views/Producto/deleteProducto.jsp").forward(request, response);
			break;
		case "delete":
			productoDaoImpl.deleteProducto(id_producto);
			request.setAttribute("success", "DATOS ELIMINADOS DE FORMA SATISFACTORIA");
      	  	request.getRequestDispatcher("./views/Producto/deleteProducto.jsp").forward(request, response);
      	  	break;
		case "update_redirect":
			request.setAttribute("listMarca", marcaDaoImpl.findAllMarcas());
			request.setAttribute("listCategoria", categoriaDaoImpl.findAllCategorias());
			List<Productos> listaProducto = new ArrayList<Productos>();
			Productos producto = new Productos(id_producto, nombre_producto, presentacion, marcas, categorias);
			listaProducto.add(producto);
			request.setAttribute("datos", listaProducto);
      	  request.getRequestDispatcher("./views/Producto/updateProducto.jsp").forward(request, response);
      	  break;
		case "update_data":
			Productos productoUpdate = new Productos(id_producto, nombre_producto,presentacion, marcas, categorias);
			productoDaoImpl.updateProducto(productoUpdate);
			request.setAttribute("success", "DATOS ACTUALIZADOS DE FORMA SATISFACTORIA");
      	  	request.getRequestDispatcher("./views/Producto/updateProducto.jsp").forward(request, response);
      	  	break;
		default: System.out.println(option);
			break;
		}
	}

}
