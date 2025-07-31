<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../template_superior.jsp"/>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		<h2>Registro de usuario</h2>

		<form method="post" action="/registro">
		    <label>Nombre:</label><br>
		    <input type="text" name="nombre" required><br><br>
		
		    <label>Email:</label><br>
		    <input type="email" name="email" required><br><br>
		
		    <label>Contraseña:</label><br>
		    <input type="password" name="password" required><br><br>
		
		    <input type="submit"  class="btn btn-primary" value="Registrarme">
		</form>



		<c:if test="${not empty error}">
		    <p style="color:red;">${error}</p>
		</c:if>
		
		<c:if test="${not empty mensaje}">
		    <p style="color:green;">${mensaje}</p>
		</c:if>
    </div>
  </div>
</div>

<jsp:include page="../template_inferior.jsp"/>