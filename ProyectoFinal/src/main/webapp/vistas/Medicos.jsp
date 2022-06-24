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
<title>Medicos</title>
</head>
<body>
	<div class="container">
		<h1 class="title1">Sistema médico</h1>
		<h2 class="title2">Registro de médicos</h2>
		
		<form method = "post">
			<label for="id" class="textPaciente">Id médico</label> <input class="form-control" type="text" name="idMedico" id="id">
			<label for="nombre" class="textPaciente">Nombres</label> <input class="form-control" type="text" name="nombreMedico" id="nombre">
			<label for="apellido" class="textPaciente">Apellidos</label> <input class="form-control" type="text" name="apellidoMedico" id="apellido">
			<label for="especialidad" class="textPaciente">Id especialidad</label> <input class="form-control" type="text" name="especialidad" id="especialidad">
			<input class="btn btn-primary" type="submit" value="Registrar" name="btnRegistrar">
		</form>
		
		<%
		Connector conexion = new Connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conexion.getConexion();
		String sql = "SELECT * FROM medico";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id médico</th>
				<th>Nombre</th>
				<th>Apellido</th>
				
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idMedicoM" value="<%=rs.getInt("id_medico")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="nombreMedicoM" value="<%=rs.getString("nombre_medico")%>"/></td>
					<td><input class="form-control" type="text" name="apellidoMedicoM" value="<%=rs.getString("apellidos_medico")%>"/></td>
					<td><input class="btn btn-info" type="submit" value="Editar" name="btnEditar"/></td>
					<td><input class="btn btn-info" type="submit" value="Eliminar" name="btnEliminar"/></td>					
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		
		<h2>${registro}</h2>
		
		<div class="container container-btn"><a class="btn btn-success" href="${pageContext.request.contextPath}/">Regresar al menu</a></div>
	</div>
	
	
</body>
</html>