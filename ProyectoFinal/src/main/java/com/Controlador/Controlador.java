package com.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Clases.Pacientes;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      RequestDispatcher rd = request.getRequestDispatcher("vistas/Pacientes.jsp");

      rd.forward(request, response);

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String btnRegistrar = request.getParameter("btnRegistrar");
		
		if(btnRegistrar!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String fecha = request.getParameter("fecha");
				String domicilio = request.getParameter("domicilio");
				int idPais = Integer.parseInt(request.getParameter("idPais"));
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String observacion = request.getParameter("observacion");
				
				Pacientes insertar = new Pacientes(id, nombre, apellido, fecha, domicilio, idPais, telefono, email, observacion);
				
				if(insertar.insert()) request.setAttribute("registro", "Registro exitoso");
			}catch (Exception e) {
				 request.setAttribute("registro", "Por favor verificar sus datos");
			}
		}
		
		
		String btnEditar = request.getParameter("btnEditar");
		
		if(btnEditar!=null) {
			
			try {
			
			int id = Integer.parseInt(request.getParameter("idM"));
			String nombre = request.getParameter("nombreM");
			String apellido = request.getParameter("apellidoM");
			String fecha = request.getParameter("fechaM");
			String domicilio = request.getParameter("domicilioM");
			int idPais = Integer.parseInt(request.getParameter("paisM"));
			String telefono = request.getParameter("telefonoM");
			String email = request.getParameter("emailM");
			String observacion = request.getParameter("observacionM");
			
			Pacientes editar = new Pacientes(id, nombre, apellido, fecha, domicilio, idPais, telefono, email, observacion);
			
			if(editar.update()) request.setAttribute("registro", "Registro actualizado");
			}catch (Exception e) {
				 request.setAttribute("registro", "Por favor verificar sus datos");
			}
			
		}
		
		String btnEliminar = request.getParameter("btnEliminar");
		
		if(btnEliminar!=null) {
			int id = Integer.parseInt(request.getParameter("idM"));
			Pacientes eliminar = new Pacientes(id);
			
			if(eliminar.delete()) request.setAttribute("registro", "Registro eliminado");
		}
		
		doGet(request, response);
	}

}
