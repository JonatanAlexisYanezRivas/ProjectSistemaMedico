<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Clases.Connector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Cita</title>
</head>
<body>
	<div class="container">
		<h2 class="title2">Pacientes</h2>
		
		
		<%
		Connector conexion = new Connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conexion.getConexion();
		String sql = "SELECT * FROM paciente";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id paciente</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Ingrese id del médico</th>
				<th>Ingrese número de turno</th>
				<th>Observacion</th>
			
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idpacienteCitaM" value="<%=rs.getInt("id_paciente")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="nombreCitaM" value="<%=rs.getString("nombre")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="apellidoCItaM" value="<%=rs.getString("apellidos")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="medicoCitaM" value=""/></td>
					<td><input class="form-control" type="text" name="idCitaM" value=""/></td>
					<td><input class="form-control" type="text" name="observacionCitaM" value=""/></td>
					<td><input class="btn btn-info" type="submit" value="Generar cita" name="btnCita"/></td>	
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		
		<h2>${fecha}</h2>
		
		<%
		
		ps = null;
		rs = null;
		con = conexion.getConexion();
		sql = "SELECT p.id_Paciente, p.nombre, p.apellidos, turno.fecha_turno FROM paciente p inner join turnopaciente t on p.id_Paciente = t.id_Paciente inner join turno on turno.id_Turno = t.id_turno ";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id turno</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha de la cita</th>
				
			
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="citaPacienteM" value="<%=rs.getInt("id_paciente")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="citaNombreM" value="<%=rs.getString("nombre")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="citaApellidoM" value="<%=rs.getString("apellidos")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="citaFechaM" value="<%=rs.getString("fecha_turno")%>"  readonly="readonly"/></td>
					
					<td><input class="btn btn-info" type="submit" value="Eliminar cita" name="btnEliminarCita"/></td>	
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		
		<div class="container container-btn"><a class="btn btn-success" href="${pageContext.request.contextPath}/">Regresar al menu</a></div>
	</div>

</body>
</html>