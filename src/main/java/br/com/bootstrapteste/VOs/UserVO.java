package br.com.bootstrapteste.VOs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

public class UserVO implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = -8079001840826672953L;

	private static final ShaPasswordEncoder shaEnc = new ShaPasswordEncoder();

	private String name;
	private String password;
	private int status;

	private Set<RuleVO> listRules;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = getEncodePassword(password, this.name);
	}

	private String getEncodePassword(String pass, String salt) {
		if (!StringUtils.isEmpty(pass)) {
			if (!StringUtils.isEmpty(salt)) {
				return shaEnc.encodePassword(pass, salt);
			} else {
				return null;
			}
		} else {
			return pass;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auto = new ArrayList<GrantedAuthority>();
		auto.addAll(getListRules());
		return auto;
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<RuleVO> getListRules() {
		return listRules;
	}

	public void setListRules(Set<RuleVO> listRules) {
		this.listRules = listRules;
	}

}
