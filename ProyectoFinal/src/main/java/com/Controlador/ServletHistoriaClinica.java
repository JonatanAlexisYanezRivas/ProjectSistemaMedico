package com.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Clases.HistorialClinico;

/**
 * Servlet implementation class ServletHistoriaClinica
 */
@WebServlet("/ServletHistoriaClinica")
public class ServletHistoriaClinica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHistoriaClinica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      RequestDispatcher rd = request.getRequestDispatcher("vistas/HistoriaClinica.jsp");

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
				int id = Integer.parseInt(request.getParameter("idHistoria"));
				String fecha = request.getParameter("fechaActual");
				String observacion = request.getParameter("observacion");
				int idpaciente = Integer.parseInt(request.getParameter("id_paciente"));
				int idmedico = Integer.parseInt(request.getParameter("id_medico"));
				
				HistorialClinico historial = new HistorialClinico(id, fecha, observacion, idpaciente, idmedico);
				if(historial.insert()) request.setAttribute("registro", "Se ha registrado el historial");
			}catch (Exception e) {
				request.setAttribute("registro", "Verificar sus datos");
			}
		}
		
		String btnEliminar = request.getParameter("btnEliminar");
		
		if(btnEliminar!=null) {
			int id = Integer.parseInt(request.getParameter("idHistoriaM"));
			HistorialClinico eliminar = new HistorialClinico(id);
			if(eliminar.delete()) request.setAttribute("registro", "Se ha eliminado el historial");
		}
		
		doGet(request, response);
	}

}
