package br.com.bootstrapteste.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import br.com.bootstrapteste.VOs.TutorialVO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class ConvidadoController {

//	@Autowired
//	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index(){

		String json = getEmployees();

		Gson gson = new Gson();

//		TutorialVO staff = gson.fromJson(json, TutorialVO.class);

		List<TutorialVO> list = gson.fromJson(json, new TypeToken<List<TutorialVO>>(){}.getType());
		for (TutorialVO tutorialVO : list) {
			System.out.println(tutorialVO.getName());
		}

		return "index";
	}

	private String getEmployees()
	{
	    final String uri = "http://localhost:9000/tutorials";

//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class);
//
//	    System.out.println(result);

	    RestTemplate restTemplate = new RestTemplate();

	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

	    System.out.println(result);

	    return result.getBody();
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){

//		Iterable<Convidado> convidados = repository.findAll();

//		model.addAttribute("convidados", convidados);

		return "listaconvidados";
	}

}
