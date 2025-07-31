<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="../template_superior.jsp"></jsp:include>
			<h1>Detalle del reclamo</h1>
		Id: ${reclamo.id}<br>
		Titulo: ${reclamo.titulo }<br>
		Categoria: ${reclamo.categoriaReclamo.nombre}<br>
		Fecha: ${reclamo.fechaAlta}<br>
		Descripcion: ${reclamo.descripcion }<br>
		
		
<jsp:include page="../template_inferior.jsp"></jsp:include>
