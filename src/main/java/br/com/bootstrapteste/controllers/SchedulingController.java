package br.com.bootstrapteste.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bootstrapteste.VOs.AgendamentoVO;
import br.com.bootstrapteste.VOs.StudioVO;

@Controller
public class SchedulingController {

	@RequestMapping(value={"/scheduling"}, method = RequestMethod.GET)
	public ModelAndView init(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling/scheduling");


		return modelAndView;
	}
	
	@RequestMapping(value={"/search_scheduling"}, method = RequestMethod.GET)
	public ModelAndView initScheduing(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling/search_scheduling");

		return modelAndView;
	}

	@RequestMapping(value={"/insert_scheduling"}, method = RequestMethod.GET)
	public ModelAndView initInsert(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling/insert_scheduling");

		return modelAndView;
	}

	@RequestMapping(value={"/confirm_scheduling"}, method = RequestMethod.POST)
	public ModelAndView confirmInclude(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling/search_scheduling");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/search_scheduling_edit"}, method = RequestMethod.GET)
	public ModelAndView searchScheduling(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/scheduling/search_scheduling");
		
		List<AgendamentoVO> list = new ArrayList<AgendamentoVO>();
		AgendamentoVO studio = new AgendamentoVO();
		studio.setName("teste");
		studio.setTel(99999999);
		studio.setEmail("teste@teste");
		studio.setDateScheduling(new Date());
		studio.setHourScheduling(new Date());
		
		AgendamentoVO studio1 = new AgendamentoVO();
		studio1.setName("teste");
		studio1.setTel(99999999);
		studio1.setEmail("teste@teste");
		studio1.setDateScheduling(new Date());
		studio1.setHourScheduling(new Date());
		
		AgendamentoVO studio2 = new AgendamentoVO();
		studio2.setName("teste");
		studio2.setTel(99999999);
		studio2.setEmail("teste@teste");
		studio2.setDateScheduling(new Date());
		studio2.setHourScheduling(new Date());

		list.add(studio);
		list.add(studio1);
		list.add(studio2);
		
		modelAndView.addObject("schedulingList", list);
		
		return modelAndView;
	}

	@RequestMapping(value={"/edit_scheduling"}, method = RequestMethod.GET)
	public ModelAndView editStudio(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scheduling/edit_scheduling");
		
		return modelAndView;
	}

}
