
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="google-signin-client_id" content="983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com">

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

						<div class="form-group">
							<button onclick="saveToken()" name="submit" type="submit" class="btn btn-default">Salvar</button>
						</div>

						<div class="g-signin2" data-onsuccess="onSignIn"></div>

						<a href="#" onclick="signOut();">Sign out</a>

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

	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

  	<script src="https://apis.google.com/js/client:platform.js?onload=verifyAuth" async defer></script>

 <script>

 	var possuiToken=false;

 	var id_token;

 	function saveToken(){

 		 id_token;

 		  $.ajax({
 			  	type: 'POST',
 			    url: "http://localhost:8080/studiocontroller/authtoken",
 			    async: false,
 			    data: {val: id_token},
 			    dataType: 'html',
 			    success: function (data) {
 			        console.log(data);
 			    }
 			});
 	}

 	function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	      auth2.disconnect();
	    });
	  }

	 function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

	  id_token = googleUser.getAuthResponse().id_token;

	}

	$('#signinButton').click(function() {
	    // signInCallback defined in step 6.
	    auth2.grantOfflineAccess().then(signInCallback);
	  });

	function start() {
	    gapi.load('auth2', function() {
	      auth2 = gapi.auth2.init({
    	  	'apiKey' : 'AIzaSyCWEHtMBKY5bIdcXT5TF3UuFDUoK-2AAvM',
        	'clientId' : '983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com',
			'scope' : 'https://www.googleapis.com/auth/calendar'
	        // Scopes to request in addition to 'profile' and 'email'
	        //scope: 'additional_scope'
	      }).then(function () {
		      console.log('Sucesso!');

		       possuiToken=true;
		    });
	    });
	  }

	function signInCallback(authResult) {
		  if (authResult['code']) {

		    // Hide the sign-in button now that the user is authorized, for example:
		    $('.signinButton').hide();

		    // Send the code to the server
		    $.ajax({
		      type: 'POST',
		      url: 'http://localhost:8080/studiocontroller/storetoken',
		      // Always include an `X-Requested-With` header in every AJAX request,
		      // to protect against CSRF attacks.
		      headers: {
		        'X-Requested-With': 'XMLHttpRequest'
		      },
		      contentType: 'application/octet-stream; charset=utf-8',
		      success: function(result) {
		        // Handle or verify the server response.
		      },
		      processData: false,
		      data: authResult['code']
		    });
		  } else {
		    // There was an error.
		  }
		}

	function verifyAuth(){
		if (possuiToken) {
			start();
		}

	}

	</script>

</body>
</html>