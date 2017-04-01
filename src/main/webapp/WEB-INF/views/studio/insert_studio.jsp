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

<title>Incluir Est�dio</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/menu.jsp" />

	<div id="page-wrapper">

		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Incluir Est�dio
					</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> <a href="/index">P�gina Principal</a>
						</li>
						<li class="active"><i class="fa fa-file"></i> Est�dios</li>
						<li class="active"><i class="fa fa-file"></i> Incluir Est�dio</li>
					</ol>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">

					<form action="/studiocontroller/confirm_include" method="POST" role="form">

						<div class="form-group">
							<label>Nome do Est�dio</label> 
							<input class="form-control">
						</div>
						
						<div class="form-group">
							<label>Endere�o</label> 
							<input class="form-control">
						</div>
						
						<div class="form-group">
							<label>E-Mail</label> 
							<input class="form-control">
						</div>
						
						<div class="form-group">
							<label>Telefone</label> 
							<input class="form-control">
						</div>
						
						<div style="text-align: right" class="form-group">
							<button type="submit" class="btn btn-default" >Salvar</button>
						</div>
						
					</form>
				</div>
			</div>


		</div>
	</div>
	<!-- /.row -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>