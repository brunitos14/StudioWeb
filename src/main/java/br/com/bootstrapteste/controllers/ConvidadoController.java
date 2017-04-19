package br.com.bootstrapteste.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
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
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".credentials/calendar-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/calendar-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays.asList(CalendarScopes.CALENDAR);

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
		InputStream in = ConvidadoController.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
//		Credential credential = new Credential(null);// = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

		 AuthorizationCodeInstalledApp auth = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver());

		 Credential credential = auth.authorize("user");

		System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Calendar client service.
	 *
	 * @return an authorized Calendar client service
	 * @throws IOException
	 */
	public static com.google.api.services.calendar.Calendar getCalendarService() throws IOException {
		Credential credential = authorize();
		return new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

//	@Autowired
//	private ConvidadoRepository repository;

	@RequestMapping("/")
	public AuthorizationCodeFlow login() throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		 String url = new GoogleBrowserClientRequestUrl("983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com",
			      "https://localhost:8080", Arrays.asList(
			          "https://www.googleapis.com/auth/calendar")).setState("/profile").build();

		 GoogleAuthorizationCodeFlow build = new GoogleAuthorizationCodeFlow.Builder(
			        new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
			        "983136618644-scvkov1tlg50kvt76bjelrbjel2t7vk3.apps.googleusercontent.com" , "[[ENTER YOUR CLIENT SECRET]]",
			        Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(
			        DATA_STORE_FACTORY).setAccessType("offline").build();

		return build;

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		auth.getAuthorities();

//		try {

//		com.google.api.services.calendar.Calendar service = getCalendarService();

		// List the next 10 events from the primary calendar.
//		DateTime now = new DateTime(System.currentTimeMillis());
//
//		Event event = new Event();
//		event.setDescription("Teste da porra toda");
//		EventDateTime eventDateTime = new EventDateTime();
//		eventDateTime.setDate(now);
//		event.setStart(eventDateTime);
//
//		EventDateTime eventDateTime2 = new EventDateTime();
//		eventDateTime2.setDate(now);
//		event.setEnd(eventDateTime2);
//
//		service.events().insert("Novo evento", event).execute();
//
//		Events events = service.events().list("primary").setMaxResults(10).setTimeMin(now).setOrderBy("startTime")
//				.setSingleEvents(true).execute();
//		List<Event> items = events.getItems();
//		if (items.size() == 0) {
//			System.out.println("No upcoming events found.");
//		} else {
//			System.out.println("Upcoming events");
//			for (Event event1 : items) {
//				DateTime start = event1.getStart().getDateTime();
//				if (start == null) {
//					start = event1.getStart().getDate();
//				}
//				System.out.printf("%s (%s)\n", event1.getSummary(), start);
//			}
//		}

//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		return "index";
	}

}
