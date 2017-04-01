package br.com.bootstrapteste.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bootstrapteste.VOs.StudioVO;

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

	@RequestMapping(value={"/budget_studio"}, method = RequestMethod.GET)
	public ModelAndView initInsert(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("budget/insert_budget");

		return modelAndView;
	}

	@RequestMapping(value={"/confirm_include_budget"}, method = RequestMethod.POST)
	public ModelAndView confirmInclude(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("budget/studio_register");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/search_budget"}, method = RequestMethod.GET)
	public ModelAndView search(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("budget/budget_register");
		
		List<StudioVO> list = new ArrayList<StudioVO>();
		StudioVO studio = new StudioVO();
		studio.setName("teste");
		studio.setEnd("teste");
		studio.setTel(99999999);
		studio.setEmail("teste@teste");
		
		StudioVO studio1 = new StudioVO();
		studio1.setName("teste");
		studio1.setEnd("teste");
		studio1.setTel(99999999);
		studio1.setEmail("teste@teste");
		
		StudioVO studio2 = new StudioVO();
		studio2.setName("teste");
		studio2.setEnd("teste");
		studio2.setTel(99999999);
		studio2.setEmail("teste@teste");

		list.add(studio);
		list.add(studio1);
		list.add(studio2);
		
		modelAndView.addObject("studioList", list);
		
		return modelAndView;
	}

	@RequestMapping(value={"/edit_budget"}, method = RequestMethod.GET)
	public ModelAndView editStudio(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("budget/edit_budget");
		
		return modelAndView;
	}
	
}
