<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template_superior.jsp"></jsp:include>
<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		<h2>Listado de Categorías</h2>
		
		<c:if test="${not empty error}">
		    <div class="alert alert-danger">${error}</div>
		</c:if>
		
		<c:if test="${not empty mensaje}">
		    <div class="alert alert-success">${mensaje}</div>
		</c:if>
		
		<a class="btn btn-success mb-3" href="/categorias/nueva">Nueva Categoría</a>
		
		<table class="table table-bordered table-striped table-hover">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Nombre</th>
		            <th>Acciones</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${categorias}" var="categoria">
		            <tr>
		                <td>${categoria.id}</td>
		                <td>${categoria.nombre}</td>
		                <td>
		                    <a class="btn btn-warning" href="/categorias/${categoria.id}/editar">Editar</a>
		                    <a class="btn btn-danger" onclick="borrarCategoria(${categoria.id})" href="#">Borrar</a>
		                </td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>

    </div>
  </div>
</div>

<script>
    function borrarCategoria(idCategoria) {
        bootbox.confirm("¿Desea eliminar la categoría n°: " + idCategoria + "?", function(result) {
            if(result) {
                window.location = '/admin/categoria/borrar/' + idCategoria;
            }
        });
    }
</script>

<jsp:include page="../template_inferior.jsp"></jsp:include>
