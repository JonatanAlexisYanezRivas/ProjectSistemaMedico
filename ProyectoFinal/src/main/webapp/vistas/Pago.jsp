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
<title>Pago</title>
</head>
<body>
	<div>
		<h1 class="title1">Generar pago</h1>
			
		
		<%
		Connector conexion = new Connector();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conexion.getConexion();
		String sql = "SELECT p.id_Paciente, p.nombre, p.apellidos, pais.pais, t.id_Turno, t.fecha_turno FROM paciente p inner join turnopaciente on turnopaciente.id_Paciente = p.id_Paciente inner join pais on pais.id_Pais = p.idPais inner join turno t on t.id_Turno = turnopaciente.id_Turno  ";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id paciente</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>País</th>
				<th>Id turno</th>
				<th>Fecha turno</th>
				<th>Id pago</th>
				<th>Id concepto</th>
				<th>Monto</th>
				<th>Estado</th>
				<th>Observacion</th>
			
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idPaciente" value="<%=rs.getInt("id_paciente")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="nombrePaciente" value="<%=rs.getString("nombre")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="apellidosPaciente" value="<%=rs.getString("apellidos")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="pais" value="<%=rs.getString("pais")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="idTurno" value="<%=rs.getInt("id_Turno")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="fechaTurno" value="<%=rs.getString("fecha_turno")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" name="idPago" value=""/></td>
					<td><input class="form-control" type="text" name="idConcepto" value=""/></td>
					<td><input class="form-control" type="text" name="monto" value=""/></td>
					<td><input class="form-control" type="text" name="estado" value=""/></td>
					<td><input class="form-control" type="text" name="observacion" value=""/></td>
					<td><input class="btn btn-info" type="submit" value="Generar pago" name="btnPago"/></td>	
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		
		<%
		
		ps = null;
		rs = null;
		con = conexion.getConexion();
		sql = "SELECT pp.id_Pago, p.nombre, p.apellidos, concepto.descripcion, pago.monto FROM paciente p inner join pago_paciente pp on p.id_Paciente = pp.id_Paciente inner join pago on pp.id_pago = pago.id_Pago inner join concepto on pago.id_Concepto = concepto.id_Concepto order by pp.id_Pago";
		
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
		%>
		
		<table class="table table-bordered">
			<tr>
				<th>Id pago</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Concepto</th>
				<th>Monto</th>
			
			</tr>
			<%while(rs.next()){ %>
			<form method="post">
				<tr>
					<td><input class="form-control" type="text" name="idPagoEliminar" value="<%=rs.getInt("id_Pago")%>" readonly="readonly"/></td>
					<td><input class="form-control" type="text" value="<%=rs.getString("nombre")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" value="<%=rs.getString("apellidos")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" value="<%=rs.getString("descripcion")%>"  readonly="readonly"/></td>
					<td><input class="form-control" type="text" value="<%=rs.getDouble("monto")%>" readonly="readonly"/></td>
					<td><input class="btn btn-info" type="submit" value="Eliminar pago" name="btnEliminarPago"/></td>	
				</tr>
			</form>
			<%}
			}catch(SQLException e){
				
			}%>
		</table>
		<h2 class="title2">${registro}</h2>
		
		<div class="container container-btn"><a class="btn btn-success" href="${pageContext.request.contextPath}/">Regresar al menu</a></div>
	</div>

</body>
</html>