package com.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Clases.Turno;

/**
 * Servlet implementation class ServletCita
 */
@WebServlet("/ServletCita")
public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCita() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      RequestDispatcher rd = request.getRequestDispatcher("vistas/Cita.jsp");

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
		
		String btnCita = request.getParameter("btnCita");
		
		if(btnCita!=null) {
			try {
				int idpaciente = Integer.parseInt(request.getParameter("idpacienteCitaM"));
				int id_medico = Integer.parseInt(request.getParameter("medicoCitaM"));
				int idturno = Integer.parseInt(request.getParameter("idCitaM"));
				String observacion = request.getParameter("observacionCitaM");
				String nombrepaciente = request.getParameter("nombreCitaM");
				
				Turno cita = new Turno(idpaciente, id_medico, idturno, observacion);
				request.setAttribute("fecha", cita.generar_turno() + nombrepaciente);
			}catch (Exception e) {
				request.setAttribute("fecha", "Verificar sus datos");
			}
		}
		
		String btnEliminar = request.getParameter("btnEliminarCita");
		
		if(btnEliminar!= null) {
			int idpaciente = Integer.parseInt(request.getParameter("citaPacienteM"));
			String nombrepaciente = request.getParameter("citaNombreM");
			Turno eliminar = new Turno(idpaciente);
			if(eliminar.deleteTurnoPaciente()) {
				eliminar.delete();
				request.setAttribute("fecha", "Se elimino la cita del paciente: " + nombrepaciente);
			}
		}
		doGet(request, response);
	}

}
