package com.cds.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cds.daoImp.UsuarioDaoImpl;
import com.cds.model.Usuarios;
import com.cds.util.ValidateNullPointer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
     private String user1 = "Admin";
     private String pass1 = "12345";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./views/Login/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String user = ValidateNullPointer.validateToString(request.getParameter("username"));
	  String password = ValidateNullPointer.validateToString(request.getParameter("pass"));
	      if (user.equals(user1) && password.equals(pass1)) {
	    	  request.getRequestDispatcher("./views/Home/Home.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "ERROR: VERIFIQUE LOS CAMPOS INGRESADOS");
			request.getRequestDispatcher("./views/Login/Login.jsp").forward(request, response);
		}
	}

}
