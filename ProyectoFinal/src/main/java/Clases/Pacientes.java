package Clases;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pacientes extends Connector {
	
	private int id_paciente;
	private String nombre;
	private String apellidos;
	private String date;
	private String domicilio;
	private int idPais;
	private String telefono;
	private String email;
	private String observacion;
	
	
	
	public Pacientes(int id_paciente) {
		super();
		this.id_paciente = id_paciente;
	}

	public Pacientes(int id_paciente, String nombre, String apellidos, String date, String domicilio, int idPais,
			String telefono, String email, String observacion) {
		super();
		this.id_paciente = id_paciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.date = date;
		this.domicilio = domicilio;
		this.idPais = idPais;
		this.telefono = telefono;
		this.email = email;
		this.observacion = observacion;
	}

	public int getId_paciente() { return id_paciente; }

	public void setId_paciente(int id_paciente) { this.id_paciente = id_paciente; }

	public String getNombre() { return nombre; }

	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellidos() { return apellidos; }

	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	public String getDate() {	return date; }

	public void setDate(String date) { this.date = date; }

	public String getDomicilio() { return domicilio; }

	public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

	public int getIdPais() { return idPais;	}

	public void setIdPais(int idPais) { this.idPais = idPais; }

	public String getTelefono() { return telefono; }

	public void setTelefono(String telefono) { this.telefono = telefono; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getObservacion() { return observacion; }

	public void setObservacion(String observacion) { this.observacion = observacion; }
	
	
	public boolean insert() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into paciente (id_Paciente, nombre, apellidos, fecha_nacimiento, domicilio, idPais, telefono, email, observacion)"
				+ "values (?,?,?,?,?,?,?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_paciente());
			ps.setString(2, getNombre());
			ps.setString(3, getApellidos());
			ps.setString(4, getDate());
			ps.setString(5, getDomicilio());
			ps.setInt(6, getIdPais());
			ps.setString(7, getTelefono());
			ps.setString(8, getEmail());
			ps.setString(9, getObservacion());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean update() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "update paciente set nombre = ?, apellidos = ? , fecha_nacimiento = ?, domicilio = ? , idPais = ?, telefono = ?, email = ?, observacion = ? where id_Paciente = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setString(2, getApellidos());
			ps.setString(3, getDate());
			ps.setString(4, getDomicilio());
			ps.setInt(5, getIdPais());
			ps.setString(6, getTelefono());
			ps.setString(7, getEmail());
			ps.setString(8, getObservacion());
			ps.setInt(9,getId_paciente());
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
		String sql = "delete from paciente where id_Paciente = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_paciente());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	

}

