package br.com.bootstrapteste.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvidadoController {

//	@Autowired
//	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index(){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		auth.getAuthorities().iterator();



		return "index";
	}

}
