<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema de Reclamos</title>
		
		<script src="<c:url value="/js/jquery-3.7.1.js" />"></script>
		<script src="<c:url value="/js/bootstrap.js" />"></script>
		<script src="<c:url value="/js/bootbox.all.js" />"/></script>

		<script src="<c:url value="/js/jquery.validate.js" />"></script>
		<script src="<c:url value="/js/localization/messages_es_AR.js" />"></script>
		
		<link rel="stylesheet" href="<c:url value="/css/bootstrap.css" />">
		<link rel="stylesheet" href="<c:url value="/css/general.css" />">
		<link rel="stylesheet" href="<c:url value="/css/custom.css" />">
	</head>
	<body class="d-flex flex-column min-vh-100">
		<nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/reclamos/listar">Reclamos</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="/reclamos/nuevo">Nuevo reclamo</a>
		        </li>
		        <c:if test="${sessionScope.usuarioLogueado.rol == 'ADMIN'}">
			        <li class="nav-item">
			          <a class="nav-link" href="/admin/categoria/nueva">Nueva categoría</a>
			        </li>
			        <li class="nav-item">
					  <a class="nav-link" href="/admin/categoria/listar">Categorías</a>
					</li>
				</c:if>
		      </ul>
		      <c:choose>
				  <c:when test="${not empty sessionScope.usuarioLogueado}">
				    <ul class="navbar-nav ms-auto">
				      <li class="nav-item">
				        <a class="nav-link text-white" href="${pageContext.request.contextPath}/logout">Cerrar sesión</a>
				      </li>
				    </ul>
				  </c:when>
				  <c:otherwise>
				    <ul class="navbar-nav ms-auto">
				      <li class="nav-item">
				        <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">Login</a>
				      </li>
				    </ul>
				  </c:otherwise>
				</c:choose>
		    </div>
		  </div>
		</nav>
		
		<div class="flex-grow-1">
