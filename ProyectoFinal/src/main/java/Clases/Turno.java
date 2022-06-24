package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Turno extends Connector {
	private int id_Paciente;
	private int id_Medico;
	private int id_Turno;
	private String fecha_turno;
	private String observacion;
	
	
	
	public Turno(int id_Turno) {
		super();
		this.id_Turno = id_Turno;

	}

	public Turno(int id_Paciente, int id_Medico, int id_Turno, String observacion) {
		super();
		this.id_Paciente = id_Paciente;
		this.id_Medico = id_Medico;
		this.id_Turno = id_Turno;
		this.observacion = observacion;
	}

	public int getId_Paciente() { return id_Paciente; }

	public void setId_Paciente(int id_Paciente) { this.id_Paciente = id_Paciente; }

	public int getId_Medico() { return id_Medico; }

	public void setId_Medico(int id_Medico) { this.id_Medico = id_Medico; }

	public int getId_Turno() { return id_Turno; }

	public void setId_Turno(int id_Turno) { this.id_Turno = id_Turno; }

	public String getFecha_turno() { return fecha_turno; }

	public void setFecha_turno(String fecha_turno) { this.fecha_turno = fecha_turno; }

	public String getObservacion() { return observacion; }

	public void setObservacion(String observacion) { this.observacion = observacion; }
	
	
	public String generar_turno() {
		
		LocalDate fechaActual = LocalDate.now();
		
		setFecha_turno(fechaActual.plusDays(8).toString());
		
		if(insert()) {
			insertTurnoPaciente();
			return "Su cita es el día: " + fechaActual.plusDays(8).toString() + " paciente: ";
		}else {
			return "Error al generar la cita";
		}
				
		
	}
	
	
	public boolean insert() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into turno (id_Turno, id_Estado, fecha_turno, observacion) values (?,?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_Turno());
			ps.setInt(2, 1);
			ps.setString(3, getFecha_turno());
			ps.setString(4, getObservacion());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean insertTurnoPaciente() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into turnopaciente (id_Turno, id_Paciente, id_Medico) values (?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_Turno());
			ps.setInt(2, getId_Paciente());
			ps.setInt(3, getId_Medico());
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
		String sql = "delete from turno where id_Turno = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_Turno());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean deleteTurnoPaciente() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "delete from turnopaciente where id_Turno = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_Turno());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	
	
}
