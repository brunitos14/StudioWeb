var GoogleAuth;
var SCOPE = 'https://www.googleapis.com/auth/calendar';

$( document ).ready(function() {

});

$( window ).load(function() {

		handleClientLoad();

});

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

				// Handle initial sign-in state. (Determine if user is already
				// signed in.)
				var user = GoogleAuth.currentUser.get();
				setSigninStatus();

				// Call handleAuthClick function when user clicks on
				// "Sign In/Authorize" button.
				$('#sign-in-or-out-button').click(function() {
					handleAuthClick();
				});
				$('#revoke-access-button').click(function() {
					revokeAccess();
				});

			});
}

function handleAuthClick() {
		// User is authorized and has clicked 'Sign out' button.
	if (GoogleAuth.isSignedIn.get()) {
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
				'You have not authorized this app or you are ' + 'signed out.');
	}
}

function updateSigninStatus(isSignedIn) {
	setSigninStatus();
}

function getCookie() {
	var c_name = document.cookie; // listando o nome de todos os cookies
	if (c_name != undefined && c_name.length > 0) // verificando se o mesmo
													// existe
	{
		var posCookie = c_name.indexOf('G_AUTHUSER_H'); // checando se existe o
		// cookieSeuNome
		if (posCookie >= 0) // se existir o cookie mostra um alert no browser
		{
			setCookie('G_AUTHUSER_H',-1);
			alert("Cookie Deletado!!!");
		} else
			alert("Cookie não existe!!!");
	}
}

function setCookie(name, exdays) { // função universal para criar cookie
	var expires;

	var date;

	var value;
	date = new Date(); // criando o COOKIE com a data atual
	date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
	expires = date.toUTCString();
	value = 'G_AUTHUSER_H';
	document.cookie = name + "=" + value + "; expires=" + expires + "; path=/";
}