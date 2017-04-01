package br.com.bootstrapteste.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bootstrapteste.VOs.AgendamentoVO;

@Controller
public class ReportsController {


	@RequestMapping(value={"/reports"}, method = RequestMethod.GET)
	public ModelAndView init(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("reports/reports");
		
		return modelAndView;
	}

	
	@RequestMapping(value={"/search_reports"}, method = RequestMethod.GET)
	public ModelAndView searchReport(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("reports/reports");
		
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
	
}
