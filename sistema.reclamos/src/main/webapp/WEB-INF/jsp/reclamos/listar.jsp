<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		<h2>Listado de reclamos</h2>
		
		<a class="btn btn-success mb-3" href="/reclamos/nuevo">Nuevo reclamo</a>

		<table class ="table table-striped table-bordered align-middle">
			<thead>
				<tr>
					<th>N° Reclamo</th>
					<th>Ttitulo</th>
					<th>Descripcion</th>
					<th>Categoría</th>
					<th>Estado</th>	
					<th>Acciones</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${reclamos}" var="reclamo">
					<tr>
						<td>${reclamo.id}</td>
						<td>${reclamo.titulo}</td>
						<td>${reclamo.descripcion}</td>
						<td>${reclamo.categoriaReclamo.nombre}</td>
						<td>${reclamo.estado.nombre}</td>
						
						<td>
							<c:choose>
							    <c:when test="${sessionScope.usuarioLogueado.rol == 'ADMIN'}">
							        <a class="btn btn-sm btn-warning me-1" href="/admin/reclamos/${reclamo.id}/editar">Editar</a>
							        <a class="btn btn-sm btn-danger" onclick="borrarReclamo(${reclamo.id})" href="#">Borrar</a>
							    </c:when>
							    <c:otherwise>
							        <a class="btn btn-sm btn-primary" href="/reclamos/${reclamo.id}"> Ver</a>
							    </c:otherwise>
							</c:choose>				
						
						</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>

    </div>
  </div>
</div>

<script>
	function borrarReclamo(idReclamo) {
		bootbox.confirm("Desea eliminar el reclamo n°: " + idReclamo, function(result) {
        	if(result == true) {
        		window.location = '/reclamos/borrar/' + idReclamo;
        	}
		});
	}
</script>

<jsp:include page="../template_inferior.jsp"></jsp:include>