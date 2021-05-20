<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@page import="java.util.*, co.edu.java.modelo.*, co.edu.java.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Gestion equipo</title>
</head>

<% List<Pais> paises = (List<Pais>) request.getAttribute("lista");
			%> 
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" clas="navbar-brand"> Gestion de equipos</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Equipos </a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${equipo!=null}">
					<form action="actualizar" method="post">
				</c:if>

				<c:if test="${equipo == null}">
					<form action="insertar" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${equipo!=null}">
			Editar pais
			</c:if>
						<c:if test="${equipo==null}">
			Insertar pais
			</c:if>
					</h2>
				</caption>

		<c:if test="${equipo!=null}">
			<input type="hidden" name="id" value="<c:out value='${equipo.id}'/>"/> 
			</c:if>

			<fieldset class="form-group">
			<label> Id de pais</label> <input type="text" value="<c:out value='${equipo.id}'/>" class="form-control" name="id" required="required"/>
			</fieldset>
			
			<fieldset class="form-group">
			<label> Nombre de pais</label> <input type="text" value="<c:out value='${equipo.nombre}'/>" class="form-control" name="nombre" required="required"/>
			</fieldset>
			
			<fieldset class="form-group">
			
			<label> Nombre de pais</label> <select  class="form-control" name="nombre" required="required" "/>  <%=paises%>  </select>
			</fieldset>
			
			<button type="submit" class="btn btn-success"> Guardar </button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>