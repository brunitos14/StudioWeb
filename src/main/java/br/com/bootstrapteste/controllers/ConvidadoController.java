package br.com.bootstrapteste.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

@Controller
public class ConvidadoController {

	/** Application name. */
	private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"),
			".credentials/calendar-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/calendar-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays
			.asList(CalendarScopes.CALENDAR);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 *
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException {
		// Load client secrets.
		InputStream in = ConvidadoController.class
				.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
				JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline").build();
		// Credential credential = new Credential(null);// = new
		// AuthorizationCodeInstalledApp(flow, new
		// LocalServerReceiver()).authorize("user");

		AuthorizationCodeInstalledApp auth = new AuthorizationCodeInstalledApp(
				flow, new LocalServerReceiver());

		Credential credential = auth.authorize("user");

		System.out.println("Credentials saved to "
				+ DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Calendar client service.
	 *
	 * @return an authorized Calendar client service
	 * @throws IOException
	 */
	public static com.google.api.services.calendar.Calendar getCalendarService()
			throws IOException {
		Credential credential = authorize();
		return new com.google.api.services.calendar.Calendar.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(
				APPLICATION_NAME).build();
	}

	// @Autowired
	// private ConvidadoRepository repository;

	@RequestMapping("/")
	public String login() throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		String url = new GoogleBrowserClientRequestUrl(
				"983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com",
				"https://localhost:8080", Arrays
						.asList("https://www.googleapis.com/auth/calendar"))
				.build();

		GoogleAuthorizationCodeFlow build = new GoogleAuthorizationCodeFlow.Builder(
				new NetHttpTransport(),
				JacksonFactory.getDefaultInstance(),
				"983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com",
				"[[ENTER YOUR CLIENT SECRET]]", Collections
						.singleton(CalendarScopes.CALENDAR))
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline").build();

		return "index";
	}

	@RequestMapping(value = "/authtoken", method = RequestMethod.POST)
	public ModelAndView auth(
			@RequestParam(value = "val", required = true) String token)
			throws IOException, GeneralSecurityException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling");

		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
				HTTP_TRANSPORT, JSON_FACTORY)
				.setAudience(
						Collections
								.singletonList("983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com"))
				.build();

		// (Receive idTokenString by HTTPS POST)
		//eyJhbGciOiJSUzI1NiIsImtpZCI6IjE0MzY4NWY3YzQ2NmYwZWVlZGJmYjIwNWE4MmY2N2U0M2Y2YjE1YjgifQ.eyJhenAiOiI5ODMxMzY2MTg2NDQtc2N2a292MXRsZzUwa3Z0NzZiamVscmJqZWwydDd2azMuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI5ODMxMzY2MTg2NDQtc2N2a292MXRsZzUwa3Z0NzZiamVscmJqZWwydDd2azMuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDg3NzQwMzU0MTIwMzkzNjAzOTAiLCJlbWFpbCI6ImJydW5pdG9zMTQxNEBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6IkhHVVBrbnc3Zmg5QU5qazlNMm9XbmciLCJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiaWF0IjoxNDkyNzA4NzA2LCJleHAiOjE0OTI3MTIzMDYsIm5hbWUiOiJicnVubyBhbHZlcyBmZXJyZWlyYSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vLXRkeUh5TVZIamVJL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FNY0FZaThJUFlSbXJPT3F1dXhTYnM5SEd0YXF3R2lyYncvczk2LWMvcGhvdG8uanBnIiwiZ2l2ZW5fbmFtZSI6ImJydW5vIiwiZmFtaWx5X25hbWUiOiJhbHZlcyBmZXJyZWlyYSIsImxvY2FsZSI6InB0In0.IifNOPqgV_P8hivY-TkmAdbbML14KkddhPJjzzV0WYL_Tn99thJEFMo7fs_H94t6SP9WK-t2S142Hq3FL49GUdxXOWQfnDa0hebrw4h67YczCJnvnNd7t5u6c7SdapIATp0_mxpykWeiXR5CdEV7H-IgTuVxo5-QgrSnSypvMdumOloRVMNC_alCeJ_ykKg4X-p6px2R91jPkQhIZBgMIW9P7xJlNmlBLsr4UNEIsUG5nAoWWIBmCnGWoku6sseRDQCAB4ZvrJ7TKAkX9F_DJ-VASQRjxXFL8nvlOGxP29lOtsofMqprY2b4iQyjVcr5cOfFVIdi2bFErpuNcLoHIA
		GoogleIdToken idToken = verifier.verify(token);
		if (idToken != null) {
			Payload payload = idToken.getPayload();

			// Print user identifier
			String userId = payload.getSubject();
			System.out.println("User ID: " + userId);

			// Get profile information from payload
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
			String pictureUrl = (String) payload.get("picture");
			String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");

			// Use or store profile information
			// ...

		} else {
			System.out.println("Invalid ID token.");
			try {
				TokenResponse response = new GoogleRefreshTokenRequest(
						HTTP_TRANSPORT,
						JSON_FACTORY,
						token,
						"983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com",
						"AIzaSyCWEHtMBKY5bIdcXT5TF3UuFDUoK-2AAvM")
						.execute();
				System.out
						.println("Access token: " + response.getAccessToken());
			} catch (TokenResponseException e) {
				if (e.getDetails() != null) {
					System.err.println("Error: " + e.getDetails().getError());
					if (e.getDetails().getErrorDescription() != null) {
						System.err
								.println(e.getDetails().getErrorDescription());
					}
					if (e.getDetails().getErrorUri() != null) {
						System.err.println(e.getDetails().getErrorUri());
					}
				} else {
					System.err.println(e.getMessage());
				}

			}

		}

		return modelAndView;
	}

	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	//
	// auth.getAuthorities();

	// try {

	// com.google.api.services.calendar.Calendar service = getCalendarService();

	// List the next 10 events from the primary calendar.
	// DateTime now = new DateTime(System.currentTimeMillis());
	//
	// Event event = new Event();
	// event.setDescription("Teste da porra toda");
	// EventDateTime eventDateTime = new EventDateTime();
	// eventDateTime.setDate(now);
	// event.setStart(eventDateTime);
	//
	// EventDateTime eventDateTime2 = new EventDateTime();
	// eventDateTime2.setDate(now);
	// event.setEnd(eventDateTime2);
	//
	// service.events().insert("Novo evento", event).execute();
	//
	// Events events =
	// service.events().list("primary").setMaxResults(10).setTimeMin(now).setOrderBy("startTime")
	// .setSingleEvents(true).execute();
	// List<Event> items = events.getItems();
	// if (items.size() == 0) {
	// System.out.println("No upcoming events found.");
	// } else {
	// System.out.println("Upcoming events");
	// for (Event event1 : items) {
	// DateTime start = event1.getStart().getDateTime();
	// if (start == null) {
	// start = event1.getStart().getDate();
	// }
	// System.out.printf("%s (%s)\n", event1.getSummary(), start);
	// }
	// }

	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// return "index";

}
