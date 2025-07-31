<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<jsp:include page="../template_superior.jsp"></jsp:include>

<div class="container my-4" >
  <div class="card shadow-sm borde-gral">
    <div class="card-body">
		
		<h2>Nuevo reclamo</h2>
		<form:form action="/reclamos/guardar" method="post" id="formReclamo" modelAttribute="reclamoForm">
		
			<div class="row">

			<div class="col-md-6">	
			<%-- <div class="mb-3">
			  <label class="form-label">Id</label>
			  <form:input cssClass="form-control" path="id" readonly="true"/>
			</div> --%>
		
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:input cssClass="form-control required" path="titulo"/>
			  <form:errors path="titulo"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Categoría</label>
				<form:select cssClass="form-control required" path="categoria" >
					<form:options items="${categorias}" itemLabel="nombre" itemValue="id"></form:options>
				</form:select>
				<form:errors path="categoria"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Calle</label>
				<form:input cssClass="form-control required" path="calle"/>
				<form:errors path="calle"></form:errors>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Barrio</label>
				<form:input cssClass="form-control required" path="barrio"/>
				<form:errors path="barrio"></form:errors>
			</div>
			
		
			<div class="mb-3">
			  <label class="form-label">Descripcion</label>
			  <form:textarea cssClass="form-control required " path="descripcion" rows="5" cols="15" />
			  <form:errors path="descripcion"></form:errors>
			</div>
		
		
			<button class="btn btn-primary" id="buttonEnviar" type="button">Enviar</button>
			
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>
			</div>
		</div>
		</form:form>
    </div>
  </div>
</div>	
	<script>
		$(document).ready(function() {
			
			$('#buttonEnviar').on('click', function() {
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


		
		<jsp:include page="../template_inferior.jsp"></jsp:include>
