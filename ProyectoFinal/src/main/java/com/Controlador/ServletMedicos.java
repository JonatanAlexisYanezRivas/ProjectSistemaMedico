package com.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Clases.Medicos;
import Clases.Pacientes;

/**
 * Servlet implementation class ServletMedicos
 */
@WebServlet("/ServletMedicos")
public class ServletMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMedicos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      RequestDispatcher rd = request.getRequestDispatcher("vistas/Medicos.jsp");

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
		
		String btnRegistro = request.getParameter("btnRegistrar");
		
		if(btnRegistro!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("idMedico"));
				String nombre = request.getParameter("nombreMedico");
				String apellido = request.getParameter("apellidoMedico");
				int idEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
				
				Medicos insertar = new Medicos(id, nombre, apellido, idEspecialidad);
				if(insertar.insert()) { 
					request.setAttribute("registro", "Registro exitoso");
					insertar.insertMedicoEspecialidad();
				}
			}catch (Exception e) {
				request.setAttribute("registro", "Verificar sus datos");
			}
		}
		
		String btnEditar = request.getParameter("btnEditar");
		
		if(btnEditar!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("idMedicoM"));
				String nombre = request.getParameter("nombreMedicoM");
				String apellido = request.getParameter("apellidoMedicoM");
				
				Medicos editar = new Medicos(id, nombre, apellido);
				
				if(editar.update()) request.setAttribute("registro", "Registro actualizado");
			}catch (Exception e) {
				request.setAttribute("registro", "Verificar sus datos");
			}
			
		}
		
		String btnEliminar = request.getParameter("btnEliminar");
		
		if(btnEliminar!=null) {
			int id = Integer.parseInt(request.getParameter("idMedicoM"));
			Medicos eliminar = new Medicos(id);
			
			if(eliminar.deleteMedicoEspecialidad()) {
				request.setAttribute("registro", "Registro eliminado");
				eliminar.delete();
			}
		}
		
		
		doGet(request, response);
	}

}
