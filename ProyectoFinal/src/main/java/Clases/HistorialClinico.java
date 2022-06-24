package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistorialClinico extends Connector {
	
	private int id_historia;
	private String fecha;
	private String observacion;
	private int id_paciente;
	private int id_medico;
	
	
	
	public HistorialClinico(int id_historia) {
		super();
		this.id_historia = id_historia;
	}


	public HistorialClinico(int id_historia, String fecha, String observacion, int id_paciente, int id_medico) {
		super();
		this.id_historia = id_historia;
		this.fecha = fecha;
		this.observacion = observacion;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
	}
	

	public int getId_historia() { return id_historia; }
	

	public void setId_historia(int id_historia) { this.id_historia = id_historia; }

	
	public String getFecha() { return fecha; }
	

	public void setFecha(String fecha) { this.fecha = fecha; }
	

	public String getObservacion() { return observacion; }
	

	public void setObservacion(String observacion) { this.observacion = observacion; }
	

	public int getId_paciente() { return id_paciente; }
	

	public void setId_paciente(int id_paciente) { this.id_paciente = id_paciente; }
	

	public int getId_medico() { return id_medico; }
	

	public void setId_medico(int id_medico) { this.id_medico = id_medico; }

	public boolean insert() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into historiaclinica (id_Historia, fecha_historia, observacion, id_Paciente, id_Medico) values (?,?,?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_historia());
			ps.setString(2, getFecha());
			ps.setString(3, getObservacion());
			ps.setInt(4, getId_paciente());
			ps.setInt(5, getId_medico());
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
		String sql = "delete from historiaclinica where id_Historia = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_historia());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
}
