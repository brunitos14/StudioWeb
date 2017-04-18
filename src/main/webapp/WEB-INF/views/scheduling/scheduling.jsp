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
					<h1 class="page-header">Agenda</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> <a href="index">Página
								Inicial</a></li>
						<li class="active"><i class="fa fa-file"></i> Agenda</li>
					</ol>

				</div>
			</div>


			<div class="row">
				<div class="col-lg-6">

					<form role="form">

						<div class="form-group">
							<p class="help-block">Essa tela preciso ver com vcs como vou
								desenvolver ... a principio acho que a tela de buscar
								agendamentos já atende o que vcs precisam mas podemos ver como
								funciona o componente de calendário para visualizar a agenda.</p>
						</div>

						<button id="sign-in-or-out-button" style="margin-left: 25px">Sign
							In/Authorize</button>
						<button id="revoke-access-button"
							style="display: none; margin-left: 25px">Revoke access</button>

						<div id="auth-status" style="display: inline; padding-left: 25px"></div>
						<hr>

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

	<script src="js/authenticate/auth.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script async defer src="https://apis.google.com/js/api.js"
		onload="this.onload=function(){};handleClientLoad()"
		onreadystatechange="if (this.readyState === 'complete') this.onload()">

	</script>

</body>
</html>