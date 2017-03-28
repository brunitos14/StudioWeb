//package br.com.bootstrapteste.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import br.com.bootstrapteste.VOs.RuleVO;
//import br.com.bootstrapteste.VOs.TutorialVO;
//import br.com.bootstrapteste.VOs.UserVO;
//
//@Service
//public class UserServiceImpl implements UserService, UserDetailsService {
//
////	@Autowired
////	private UserRepository userRepository;
////	@Autowired
////	private RoleRepository roleRepository;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Override
//	public UserVO findUserByEmail(String email) {
//		Gson gson = new Gson();
//		
//        String userJson = getUser(email);
//
//        UserVO user = gson.fromJson(userJson, UserVO.class);
//        
////        List<RuleVO> listRule = gson.fromJson(userJson, new TypeToken<List<RuleVO>>(){}.getType());
////        
////        user.setRule(listRule);
//		
//		return user;
//	}
//	
//	
//	 private String getUser(String email)
//		{
//		    final String uri = "http://localhost:9000/account";
//
//		    RestTemplate restTemplate = new RestTemplate();
//
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
//
//		    System.out.println(result);
//
//		    return result.getBody();
//		}
//
////	@Override
////	public void saveUser(User user) {
////		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
////		user.setActive(true);
////		Role userRole = roleRepository.findByRole("ADMIN");
////		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
////		userRepository.save(user);
////	}
//
//	@Override
////	@Transactional
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		UserVO user = findUserByEmail(userName);
//		List<GrantedAuthority> authorities = getUserAuthority(user.getRule());
//		return buildUserForAuthentication(user, authorities);
//	}
//
//	private List<GrantedAuthority> getUserAuthority(List<RuleVO> userRoles) {
//		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//		for (RuleVO role : userRoles) {
//			roles.add(new SimpleGrantedAuthority(role.getName()));
//		}
//
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
//		return grantedAuthorities;
//	}
//
//	private UserDetails buildUserForAuthentication(UserVO user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true, authorities);
//	}
//
//
//	@Override
//	public void saveUser(UserVO user) {
//		// TODO Auto-generated method stub
//		
//	}
//}
