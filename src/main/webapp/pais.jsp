<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Gestion pais</title>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" clas="navbar-brand"> Gestion de paises</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Paises </a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${pais!=null}">
					<form action="actualizar" method="post">
				</c:if>

				<c:if test="${pais == null}">
					<form action="insertar" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${pais!=null}">
			Editar pais
			</c:if>
						<c:if test="${pais==null}">
			Insertar pais
			</c:if>
					</h2>
				</caption>

		<c:if test="${pais!=null}">
			<input type="hidden" name="id" value="<c:out value='${pais.id}'/>"/> 
			</c:if>

			<fieldset class="form-group">
			<label> Id de pais</label> <input type="text" value="<c:out value='${pais.id}'/>" class="form-control" name="id" required="required"/>
			</fieldset>
			
			<fieldset class="form-group">
			<label> Nombre de pais</label> <input type="text" value="<c:out value='${pais.nombre}'/>" class="form-control" name="nombre" required="required"/>
			</fieldset>
			</fieldset>
			
			<button type="submit" class="btn btn-success"> Guardar </button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>