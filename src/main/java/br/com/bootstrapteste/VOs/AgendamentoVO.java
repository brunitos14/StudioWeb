package br.com.bootstrapteste.VOs;

import java.util.Date;

public class AgendamentoVO {

	private String name;
	private Integer tel;
	private String email;
	private Date dateScheduling;
	private Date hourScheduling;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateScheduling() {
		return dateScheduling;
	}
	public void setDateScheduling(Date dateScheduling) {
		this.dateScheduling = dateScheduling;
	}
	public Date getHourScheduling() {
		return hourScheduling;
	}
	public void setHourScheduling(Date hourScheduling) {
		this.hourScheduling = hourScheduling;
	}
	
}
