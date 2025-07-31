<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../template_superior.jsp"/>

<div class="container my-4">
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
      <h2>Iniciar sesión</h2>

      <form method="post" action="/login">
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" required><br><br>

        <label for="password">Contraseña:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <!-- Botones alineados horizontalmente a la izquierda -->
        <div class="d-flex gap-2">
          <input type="submit" class="btn btn-primary" value="Ingresar">
          <a href="/registro" class="btn btn-warning">Registrarse</a>
        </div>
      </form>

      <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
      </c:if>
    </div>
  </div>
</div>


<jsp:include page="../template_inferior.jsp"/>
