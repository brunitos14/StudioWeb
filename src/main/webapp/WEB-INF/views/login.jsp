<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Studio Controller</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index">Studio Controller</a>
			</div>
			<!-- Top Menu Items -->
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<!-- /.navbar-collapse -->
		</nav>
	</div>

	<div id="page-wrapper">

		<div style="margin-bottom: 200px;" class="container-fluid">

			<!-- Page Heading -->
			<div style="width: 40%" class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Login</h1>
				</div>
			</div>
			<!-- /.row -->

			<div style="width: 50%" class="row">
				<div class="col-lg-6">

					<form action="/bootstrapteste/login" method="POST">

						<div class="form-group">
							<label>Usuario</label> <input id="user" name="user" class="form-control">
						</div>

						<div class="form-group">
							<label>Senha</label> <input id="password" name="password" class="form-control">
							<a href="index">Esqueci minha senha</a>
						</div>
						<c:choose>
							<c:when test="${param.error != null}">
								<div align="center"  >
									<p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
								</div>
							</c:when>
						</c:choose>

						<div class="form-group">
							<button type="submit" class="btn btn-default">Entrar</button>
						</div>

					</form>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->


	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
