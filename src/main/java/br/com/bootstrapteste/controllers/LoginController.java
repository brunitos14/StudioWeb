package br.com.bootstrapteste.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


//	@Autowired
//	private UserService userService;

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//		UserVO user = null;
//		if(sec != null){
//			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
//
//			if(auth != null && auth.getPrincipal() instanceof UserDetails){
//				user = ((UserVO) auth.getPrincipal());
//			}
//
//		}

		return modelAndView;
	}


//	@RequestMapping(value="/registration", method = RequestMethod.GET)
//	public ModelAndView registration(){
//		ModelAndView modelAndView = new ModelAndView();
//		UserVO user = new UserVO();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("registration");
//		return modelAndView;
//	}

//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public ModelAndView createNewUser(@Valid UserVO user, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
//		UserVO userExists = userService.findUserByEmail(user.getName());
//		if (userExists != null) {
//			bindingResult
//					.rejectValue("email", "error.user",
//							"There is already a user registered with the email provided");
//		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("registration");
//		} else {
//			userService.saveUser(user);
//			modelAndView.addObject("successMessage", "User has been registered successfully");
//			modelAndView.addObject("user", new UserVO());
//			modelAndView.setViewName("registration");
//
//		}
//		return modelAndView;
//	}

//	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
//	public ModelAndView home(){
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		UserVO user = userService.findUserByEmail(auth.getName());
//		modelAndView.addObject("userName", "Welcome " + user.getName());
//		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//		modelAndView.setViewName("admin/home");
//		return modelAndView;
//	}

//	@RequestMapping("/login")
//	public String index(){
//
//		return "login/login";
//	}

//	private String getEmployees()
//	{
//	    final String uri = "http://localhost:9000/tutorials";

//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class);
//
//	    System.out.println(result);

//	    RestTemplate restTemplate = new RestTemplate();
//
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//
//	    System.out.println(result);
//
//	    return result.getBody();
//	}

//	@RequestMapping(value="/login/loginAccount", method = RequestMethod.GET)
//	public String login(Model model){
//
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//		if(auth.isAuthenticated()){
//			modelAndView.setViewName("index");

//			User user = userService.findUserByEmail(auth.getName());
//			modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");

//			return "index";
//		}
//
//
//		modelAndView.setViewName("error");
//		return "index";
//	}


//	@RequestMapping("listaconvidados")
//	public String listaConvidados(Model model){

//		Iterable<Convidado> convidados = repository.findAll();

//		model.addAttribute("convidados", convidados);

//		return "listaconvidados";
//	}

}
