package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Pago extends Connector {
	
	private int id_pago;
	private int id_concepto;
	private double monto;
	private String estado;
	private String observacion;
	
	private int id_Paciente;
	private int id_Turno;
	private String fecha;
	
	public Pago(int id_pago) {
		super();
		this.id_pago = id_pago;
	}

	public Pago(int id_pago, int id_concepto, double monto, String estado, String observacion, int id_Paciente,
			int id_Turno) {
		super();
		this.id_pago = id_pago;
		this.id_concepto = id_concepto;
		this.monto = monto;
		this.estado = estado;
		this.observacion = observacion;
		this.id_Paciente = id_Paciente;
		this.id_Turno = id_Turno;
	}
	
	public int getId_pago() { return id_pago; }
	
	public void setId_pago(int id_pago) { this.id_pago = id_pago; }
	
	public int getId_concepto() { return id_concepto; }
	
	public void setId_concepto(int id_concepto) { this.id_concepto = id_concepto; }
	
	public double getMonto() { return monto; }
	
	public void setMonto(double monto) { this.monto = monto; }
	
	public String getEstado() { return estado; }
	
	public void setEstado(String estado) { this.estado = estado; }
	
	public String getObservacion() { return observacion; }
	
	public void setObservacion(String observacion) { this.observacion = observacion; }
	
	public int getId_Paciente() { return id_Paciente; }
	
	public void setId_Paciente(int id_Paciente) { this.id_Paciente = id_Paciente; }
	
	public int getId_Turno() { return id_Turno; }
	
	public void setId_Turno(int id_Turno) { this.id_Turno = id_Turno; }
	
	public String getFecha() { return fecha; }
	
	public void setFecha(String fecha) { this.fecha = fecha; }
	
	public boolean insert() {
		boolean estado;
		LocalDate fechaActual = LocalDate.now();
		setFecha(fechaActual.toString());
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into pago (id_Pago, id_Concepto, fecha, monto, estado, observacion) values (?,?,?,?,?,?)";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_pago());
			ps.setInt(2, getId_concepto());
			ps.setString(3, getFecha());
			ps.setDouble(4, getMonto());
			ps.setString(5, getEstado());
			ps.setString(6, getObservacion());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean insertPagoPaciente() {
		boolean estado;
		LocalDate fechaActual = LocalDate.now();
		setFecha(fechaActual.toString());
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into pago_paciente (id_Pago, id_Paciente, id_Turno) values (?,?,?)";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_pago());
			ps.setInt(2, getId_Paciente());
			ps.setInt(3, getId_Turno());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean delete() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "delete from pago where id_Pago = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_pago());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean deletePagoPaciente() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "delete from pago_paciente where id_Pago = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_pago());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}

	
	

}
