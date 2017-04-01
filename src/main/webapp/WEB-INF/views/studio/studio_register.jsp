<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Estúdios</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/menu.jsp" />

	<div id="page-wrapper">

		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Estúdios</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> <a href="/index">Página
								Principal</a></li>
						<li class="active"><i class="fa fa-file"></i> Estúdios</li>
					</ol>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">

					<form action="/search_studio" method="GET" role="form">

						<div class="form-group">
							<label>Nome do Estúdio</label> <input class="form-control">
						</div>



						<div style="text-align: right" class="form-group">
							<a href="/insert_studio" class="btn btn-default">Incluir </a>

							<button type="submit" class="btn btn-default">Buscar</button>
						</div>

					</form>
				</div>
			</div>


		</div>


		<c:if test="${ studioList != null }">
		<div align="center" class="row">
			<form action="/edit_studio">
				<div class="col-lg-8">
					<h2>Lista de Estúdios</h2>
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>Nome do Estúdio</th>
									<th>Endereço</th>
									<th>Telefone</th>
									<th>Email</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${studioList}" var="studio">
									<tr class="active">
										<td>${ studio.name }</td>
										<td>${ studio.end }</td>
										<td>${ studio.tel }</td>
										<td>${ studio.email }</td>
										<td><p onclick="/edit_studio" align="center" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
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