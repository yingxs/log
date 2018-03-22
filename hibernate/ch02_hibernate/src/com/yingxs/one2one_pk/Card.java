package com.yingxs.one2one_pk;

import java.io.Serializable;

public class Card implements Serializable {
	private Integer id;
	private String name;
	
	//关联公民
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
