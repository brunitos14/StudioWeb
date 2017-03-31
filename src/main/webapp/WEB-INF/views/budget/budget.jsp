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

<title>Bem Vindo</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/layout/menu.jsp" />

	<div id="page-wrapper">

		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Or�amentos
					</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> <a href="index.html">Vis�o Geral</a>
						</li>
						<li class="active"><i class="fa fa-file"></i> Or�amentos</li>
					</ol>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">

					<form role="form">

						<div class="form-group">
							<label>Text Input</label> <input class="form-control">
							<p class="help-block">Example block-level help text here.</p>
						</div>

						<div class="form-group">
							<label>Text Input with Placeholder</label> <input
								class="form-control" placeholder="Enter text">
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