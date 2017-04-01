<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Studio Controller - Bem Vindo</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<title>Agendamentos</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/menu.jsp" />

	<div id="page-wrapper">

		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Agendamentos</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> <a href="/index">Página
								Principal</a></li>
						<li class="active"><i class="fa fa-file"></i>Agendamentos</li>
					</ol>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">

					<form action="/studiocontroller/search_scheduling_edit" method="GET" role="form">

						<div class="form-group">
							<label>Nome do Cliente</label> <input class="form-control">
						</div>
						
						<div class="form-group">
							<label>Telefone</label> <input class="form-control">
						</div>

						<div class="form-group">
            				<div class='input-group date'>						
							<label>De:</label> <input type="date" class="form-control">
						</div>
						</div>
							
						<div class="form-group">
            				<div class='input-group date'>
							<label>Até:</label> <input type="date" class="form-control">
							</div>
						</div>
						<div style="text-align: right" class="form-group">
							<a href="/studiocontroller/insert_scheduling" class="btn btn-default">Incluir Agendamento</a>

							<button type="submit" class="btn btn-default">Buscar Agendamentos</button>
						</div>

					</form>
				</div>
			</div>


		</div>


		<c:if test="${ schedulingList != null }">
		<div align="center" class="row">
			<form action="/studiocontroller/edit_scheduling">
				<div class="col-lg-8">
					<h2>Lista de Agendamentos</h2>
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Nome do Cliente</th>
									<th>Telefone</th>
									<th>Email</th>
									<th>Data do Agendamento</th>
									<th>Hora do Agendamento</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${schedulingList}" var="scheduling">
									<tr class="active">
										<td>${ scheduling.name }</td>
										<td>${ scheduling.tel }</td>
										<td>${ scheduling.email }</td>
										<td><fmt:formatDate pattern="dd/MM/yyyy" value="${ scheduling.dateScheduling}" />
										<td><fmt:formatDate pattern="HH:mm:ss" value="${ scheduling.hourScheduling}" />
										
										<td><p onclick="/studiocontroller/edit_scheduling" align="center" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
   										<td><p align="center" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</form>
		</div>
		</c:if>


	</div>
	<!-- /.row -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>