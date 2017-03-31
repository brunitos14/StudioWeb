package br.com.bootstrapteste.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BudgetController {

//	@Autowired
//	private UserService userService;

	@RequestMapping(value={"/budget"}, method = RequestMethod.GET)
	public ModelAndView init(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("budget/budget");

		return modelAndView;
	}

}
