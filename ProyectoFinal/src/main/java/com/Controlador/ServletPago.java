package com.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Clases.Pago;

/**
 * Servlet implementation class ServletPago
 */
@WebServlet("/ServletPago")
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPago() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      RequestDispatcher rd = request.getRequestDispatcher("vistas/Pago.jsp");

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
		
		
		String btnPago = request.getParameter("btnPago");
		if(btnPago!=null) {
			try {
				int idPago = Integer.parseInt(request.getParameter("idPago"));
				int idConcepto = Integer.parseInt(request.getParameter("idConcepto"));
				double monto = Double.parseDouble(request.getParameter("monto"));
				String estado = request.getParameter("estado");
				String observacion = request.getParameter("observacion");
				
				int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
				int idTurno = Integer.parseInt(request.getParameter("idTurno"));
				
				Pago insertar = new Pago(idPago, idConcepto, monto, estado, observacion, idPaciente, idTurno);
				
				if(insertar.insert()) {
					insertar.insertPagoPaciente();
					request.setAttribute("registro", "Se ha registrado el pago correctamente");
				}
			}catch (Exception e) {
				request.setAttribute("registro", "Verificar sus datos");
			}
			
		}
		
		String btnEliminar = request.getParameter("btnEliminarPago");
		
		if(btnEliminar!=null) {
			int idPago = Integer.parseInt(request.getParameter("idPagoEliminar"));
			Pago eliminar = new Pago(idPago);
			if(eliminar.deletePagoPaciente()) {
				eliminar.delete();
				request.setAttribute("registro", "Se ha eliminado el pago correctamente");
			}
		}
		
		doGet(request, response);
	}

}
