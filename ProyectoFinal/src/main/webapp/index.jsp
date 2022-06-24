<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Proyecto Final</title>
</head>
<body>
	
	<div class="container container-btn">
	
		<h1 class="title1">Sistema médico</h1>
		
		<a class="btn btn-success" href="${pageContext.request.contextPath}/Controlador">Pacientes</a>
		<a class="btn btn-success" href="${pageContext.request.contextPath}/ServletMedicos">Medicos</a>
		<a class="btn btn-success" href="${pageContext.request.contextPath}/ServletCita">Generar cita</a>
		<a class="btn btn-success" href="${pageContext.request.contextPath}/ServletHistoriaClinica">Historia clinica</a>
		<a class="btn btn-success" href="${pageContext.request.contextPath}/ServletPago">Pagos</a>
	
	</div>
	
	
	
	
	

</body>
</html>