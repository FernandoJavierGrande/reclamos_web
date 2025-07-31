<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		<h2>Agregar una nueva categoría de reclamo</h2>
		<form:form action="/admin/categoria/guardar" method="post" id="formcategoría" modelAttribute="categoriaForm">			
			<div class="row">
				<div class="col-md-6">
					
					<div class="mb-3">
				  		<label class="form-label">Nombre de la categoría</label>
				  		<form:input cssClass="form-control required" path="nombre"/>
				  		<form:errors path="nombre"></form:errors>
					</div>
					
					<button class="btn btn-primary" id="buttonEnviar" type="button">Enviar</button>
					
					<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>
				</div>
			</div>
			<script>
			$(document).ready(function() {
				
				$('#buttonEnviar').on('click', function() {
					if($('#formcategoría').valid() == true) {
						$('#formcategoría').submit();
					} else {
						bootbox.alert('Porfavor completar los campos faltantes');
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