package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Medicos extends Connector{
	
	private int id_medico;
	private String nombre;
	private String apellido;
	private int id_especialidad;
	
	public Medicos(int id_medico) {	this.id_medico = id_medico;	}
	
	
	public Medicos(int id_medico, String nombre, String apellido) {
		this.id_medico = id_medico;
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public Medicos(int id_medico, String nombre, String apellido, int id_especialidad) {
		this.id_medico = id_medico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_especialidad = id_especialidad;
	}

	
	public int getId_medico() { return id_medico; }
	

	public void setId_medico(int id_medico) { this.id_medico = id_medico; }

	
	public String getNombre() {	return nombre; }
	

	public void setNombre(String nombre) { this.nombre = nombre; }
	

	public String getApellido() { return apellido; }
	

	public void setApellido(String apellido) { this.apellido = apellido; }
	

	public int getId_especialidad() { return id_especialidad; }
	

	public void setId_especialidad(int id_especialidad) { this.id_especialidad = id_especialidad; }
	
	public boolean insert() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into medico (id_Medico, nombre_medico, apellidos_medico) values (?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_medico());
			ps.setString(2, getNombre());
			ps.setString(3, getApellido());
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
		String sql = "update medico set nombre_medico = ?, apellidos_medico = ? where id_Medico = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setString(2, getApellido());
			ps.setInt(3,getId_medico());
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
		String sql = "delete from medico where id_Medico = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_medico());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	public boolean deleteMedicoEspecialidad() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "delete from medicoespecialidad where id_Medico = ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_medico());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	
	
	
	public boolean insertMedicoEspecialidad() {
		boolean estado;
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "insert into medicoespecialidad (id_Medico, id_especialidad) values (?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,getId_medico());
			ps.setInt(2, getId_especialidad());
			ps.execute();	
			estado = true;
		}catch (SQLException e) {
			System.out.println(e);
			estado = false;
		}
		return estado;
	}
	

	
	

}
