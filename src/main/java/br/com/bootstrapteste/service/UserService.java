package br.com.bootstrapteste.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.bootstrapteste.VOs.UserVO;

@Service
public class UserService implements UserDetailsService {

	@Value("${controllerservices}")
    private String rest;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = findUserByEmail(username);
		if(user != null){
			return user;
		}else {
			throw new UsernameNotFoundException("Login Inválido");
		}
	}


	public UserVO findUserByEmail(String email) {
		Gson gson = new Gson();

        String userJson = getUser(email);

        UserVO user = gson.fromJson(userJson, UserVO.class);

//        List<RuleVO> listRule = gson.fromJson(userJson, new TypeToken<List<RuleVO>>(){}.getType());
//
//        user.setRule(listRule);

		return user;
	}


	 private String getUser(String email)
		{
//		    final String uri = rest + "account/{user}";

		    Client client = ClientBuilder.newClient();
		    WebTarget target = client.target(rest);
		    String conteudo = target.path("account/" + email).request().get(String.class);

//		    RestTemplate restTemplate = new RestTemplate();
//		    HttpHeaders headers = new HttpHeaders();
//		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		    headers.add("user", email);
//
//		    final Map<String, Object> param = new HashMap<>();
//	        param.put("user", email);
//
//	        final HttpEntity<?> entity = new HttpEntity<Object>(param, headers);
//
//		    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		    System.out.println(conteudo);

		    return conteudo;
		}
}
