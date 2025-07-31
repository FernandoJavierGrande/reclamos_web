<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../template_superior.jsp"/>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
    
		<h2 style="color: red;">Acceso denegado</h2>
		<p>No tenés permisos para acceder a esta sección.</p>
		
		<a href="/login">Volver al inicio</a>

    </div>
  </div>
</div>

<jsp:include page="../template_inferior.jsp"/>