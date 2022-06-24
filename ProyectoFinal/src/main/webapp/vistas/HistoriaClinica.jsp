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
<title>Historia Clinica</title>
</head>
<body>
	
	<div class="container">
		<h1 class="title1">Historia clinica</h1>
		<h2 class="title2">Crear historia clinica de paciente</h2>
		
		<form method = "post">
			<label for="id" class="textPaciente">Id historial clinico</label> <input class="form-control" type="text" name="idHistoria" id="id">
			<label for="fechaActual" class="textPaciente">fecha</label> <input class="form-control" type="date" name="fechaActual" id="fechaActual">
			<label for="observacion" class="textPaciente">observacion</label> <input class="form-control" type="text" name="observacion" id="observacion">
			<label for="id_paciente" class="textPaciente">Id paciente</label> <input class="form-control" type="text" name="id_paciente" id="id_paciente">
			<label for="id_medico" class="textPaciente">Id médico</label> <input class="form-control" type="text" name="id_medico" id="id_medico">
			
			<input class="btn btn-primary" type="submit" value="Registrar" name="btnRegistrar">
		</form>
		
		
		
		
	
		<h2 class="title2">Historias clinicas</h2>
		<%
		Connector conexion = new Connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conexion.getConexion();
		String sql = "SELECT h.id_Historia, h.fecha_historia, h.observacion, p.nombre, p.apellidos, pais.pais, m.nombre_medico, m.apellidos_medico from historiaclinica h inner join paciente p on p.id_Paciente = h.id_Paciente inner join medico m on m.id_Medico = h.id_Medico inner join pais on pais.id_Pais = p.idPais ";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id historial clinico</th>
				<th>fecha</th>
				<th>Observacion</th>
				<th>nombre paciente</th>
				<th>apellidos paciente</th>
				<th>país</th>
				<th>nombre médico</th>
				<th>apellidos medico</th>
			
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idHistoriaM" value="<%=rs.getInt("id_Historia")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("fecha_historia")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("observacion")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("nombre")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("apellidos")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" value="<%=rs.getString("pais.pais")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("nombre_medico")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text"  value="<%=rs.getString("apellidos_medico")%>"  readonly="readonly"/></td>
					<td><input class="btn btn-info" type="submit" value="Eliminar" name="btnEliminar"/></td>	
					

					
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				request.setAttribute("registro", e);
			}%>
		</table>
		
		<h2 class="title2">${registro}</h2>
		
		<div class="container container-btn"><a class="btn btn-success" href="${pageContext.request.contextPath}/">Regresar al menu</a></div>
	</div>

</body>
</html>