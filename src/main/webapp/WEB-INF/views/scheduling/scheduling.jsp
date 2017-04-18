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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script async defer src="https://apis.google.com/js/api.js"
		onload="this.onload=function(){};handleClientLoad()"
		onreadystatechange="if (this.readyState === 'complete') this.onload()">

	</script>


	<script>
		var GoogleAuth;
		var SCOPE = 'https://www.googleapis.com/auth/calendar';
		function handleClientLoad() {
			// Load the API's client and auth2 modules.
			// Call the initClient function after the modules load.
			gapi.load('client:auth2', initClient);
		}

		function initClient() {
			// Retrieve the discovery document for version 3 of Google Drive API.
			// In practice, your app can retrieve one or more discovery documents.
			var discoveryUrl = 'https://www.googleapis.com/discovery/v1/apis/drive/v3/rest';

			// Initialize the gapi.client object, which app uses to make API requests.
			// Get API key and client ID from API Console.
			// 'scope' field specifies space-delimited list of access scopes.
			gapi.client
					.init(
							{
								'apiKey' : 'AIzaSyCWEHtMBKY5bIdcXT5TF3UuFDUoK-2AAvM',
								'discoveryDocs' : [ discoveryUrl ],
								'clientId' : '983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com',
								'scope' : SCOPE
							}).then(function() {
						GoogleAuth = gapi.auth2.getAuthInstance();

						// Listen for sign-in state changes.
						GoogleAuth.isSignedIn.listen(updateSigninStatus);

						// Handle initial sign-in state. (Determine if user is already signed in.)
						var user = GoogleAuth.currentUser.get();
						setSigninStatus();

						// Call handleAuthClick function when user clicks on
						//      "Sign In/Authorize" button.
						$('#sign-in-or-out-button').click(function() {
							handleAuthClick();
						});
						$('#revoke-access-button').click(function() {
							revokeAccess();
						});
					});
		}

		function handleAuthClick() {
			if (GoogleAuth.isSignedIn.get()) {
				// User is authorized and has clicked 'Sign out' button.
				GoogleAuth.signOut();
			} else {
				// User is not signed in. Start Google auth flow.
				GoogleAuth.signIn();
			}
		}

		function revokeAccess() {
			GoogleAuth.disconnect();
		}

		function setSigninStatus(isSignedIn) {
			var user = GoogleAuth.currentUser.get();
			var isAuthorized = user.hasGrantedScopes(SCOPE);
			if (isAuthorized) {
				$('#sign-in-or-out-button').html('Sign out');
				$('#revoke-access-button').css('display', 'inline-block');
				$('#auth-status').html(
						'You are currently signed in and have granted '
								+ 'access to this app.');
			} else {
				$('#sign-in-or-out-button').html('Sign In/Authorize');
				$('#revoke-access-button').css('display', 'none');
				$('#auth-status').html(
						'You have not authorized this app or you are '
								+ 'signed out.');
			}
		}

		function updateSigninStatus(isSignedIn) {
			setSigninStatus();
		}
	</script>

</body>
</html>