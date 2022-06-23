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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="style.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
	
		<h1 class="title1">Sistema médico</h1>
		
		<h2 class="title2">Registrar Paciente</h2>
		
		<form method = "post">
			<label for="id" class="textPaciente">Id paciente</label> <input class="form-control" type="text" name="id" id="id">
			<label for="nombre" class="textPaciente">Nombres</label> <input class="form-control" type="text" name="nombre" id="nombre">
			<label for="apellido" class="textPaciente">Apellidos</label> <input class="form-control" type="text" name="apellido" id="apellido">
			<label for="fecha" class="textPaciente">Fecha de nacimiento</label> <input class="form-control" type="date" name="fecha" id="fecha">
			<label for="domicilio" class="textPaciente">Domicilio</label> <input class="form-control" type="text" name="domicilio" id="domicilio">
			<label for="idPais" class="textPaciente">Id país</label> <input class="form-control" type="text" name="idPais" id="idPais">
			<label for="telefono" class="textPaciente">Telefono</label> <input class="form-control" type="tel" name="telefono" id="telefono">
			<label for="email" class="textPaciente">Correo electrónico</label> <input class="form-control" type="email" name="email" id="email">
			<label for="observacion" class="textPaciente">Observacion</label> <input class="form-control" type="text" name="observacion" id="observacion">
			<input class="btn btn-primary" type="submit" value="Registrar" name="btnRegistrar">
		</form>
	</div>
	
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
				<th>Fecha de nacimiento</th>
				<th>Domicilio</th>
				<th>Id país</th>
				<th>Telefono</th>
				<th>Correo electrónico</th>
				<th>Observacion</th>
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idM" value="<%=rs.getInt("id_paciente")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="nombreM" value="<%=rs.getString("nombre")%>"/></td>
					<td><input class="form-control" type="text" name="apellidoM" value="<%=rs.getString("apellidos")%>"/></td>
					<td><input class="form-control" type="text" name="fechaM" value="<%=rs.getString("fecha_nacimiento")%>"/></td>
					<td><input class="form-control" type="text" name="domicilioM" value="<%=rs.getString("domicilio")%>"/></td>
					<td><input class="form-control" type="text" name="paisM" value="<%=rs.getInt("idPais")%>"/></td>
					<td><input class="form-control" type="text" name="telefonoM" value="<%=rs.getString("telefono")%>"/></td>
					<td><input class="form-control" type="text" name="emailM" value="<%=rs.getString("email")%>"/></td>
					<td><input class="form-control" type="text" name="observacionM" value="<%=rs.getString("observacion")%>"/></td>
					<td><input class="btn btn-info" type="submit" value="Editar" name="btnEditar"/></td>
					<td><input class="btn btn-info" type="submit" value="Eliminar" name="btnEliminar"/></td>					
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		
		<h2>${registro}</h2> 
</body>
</html>