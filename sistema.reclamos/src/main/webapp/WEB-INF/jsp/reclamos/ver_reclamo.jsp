<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



		
<jsp:include page="../template_superior.jsp"></jsp:include>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		
		<h2>Vista de reclamo</h2>
		<form:form action="/admin/reclamos/guardar" method="post" id="formReclamo" modelAttribute="reclamoForm">
		
			<div class="row">

		<div class="col-md-6">	
			<div class="mb-3">
			  <label class="form-label">Número de reclamo</label>
			  <form:input cssClass="form-control" path="id" readonly="true"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:input cssClass="form-control required" path="titulo" readonly="true"/>
			  <form:errors path="titulo"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Categoría</label>
				<form:select cssClass="form-control required" path="categoria" readonly="true" >
					<form:options items="${categorias}" itemLabel="nombre" itemValue="id"></form:options>
				</form:select>
				<form:errors path="categoria"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Calle</label>
				<form:input cssClass="form-control required" path="calle" readonly="true"/>
				<form:errors path="calle"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Barrio</label>
				<form:input cssClass="form-control required" path="barrio" readonly="true"/>
				<form:errors path="barrio"></form:errors>
			</div>
				
		
			<div class="mb-3">
			  <label class="form-label">Descripcion</label>
			  <form:textarea cssClass="form-control required " path="descripcion" rows="5" cols="15" readonly="true"/>
			  <form:errors path="descripcion"></form:errors>
			</div>
			
			<br>
			<div class="mb-3">
			    <label class="form-label">Estado</label>
			    
			    <form:select path="estado.id"
			                 cssClass="form-select"
			                 disabled="${sessionScope.usuarioLogueado.rol != 'ADMIN'}">
			        <form:options items="${estados}" itemValue="id" itemLabel="nombre" />
			    </form:select>
			
			    <form:errors path="estado" cssClass="text-danger" />
			</div>
			
			<br>
			
			<div class="mb-3">
			  <label class="form-label">Resolución</label>
			  <form:textarea cssClass="form-control required " path="resolucion" rows="5" cols="15" readonly="${sessionScope.usuarioLogueado.rol != 'ADMIN'}"/>
			  <form:errors path="descripcion"></form:errors>
			</div>
			
			<c:if test="${sessionScope.usuarioLogueado.rol == 'ADMIN'}">
				<button class="btn btn-primary" id="buttonMod" type="button">Grabar</button>
			</c:if>
			
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>
		</div>

		</div>
			<script>
				$(document).ready(function() {
					
					$('#buttonMod').on('click', function() {
						if($('#formReclamo').valid() == true) {
							$('#formReclamo').submit();
						} else {
							bootbox.alert('For favor completar los campos faltantes');
						}
					});
					
					$('#buttonCancelar').on('click', function(){
						history.back()}
						);
				});
			</script>
		</form:form>
    </div>
  </div>
</div>
		
<jsp:include page="../template_inferior.jsp"></jsp:include>
