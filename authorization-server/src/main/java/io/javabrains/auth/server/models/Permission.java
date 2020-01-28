package io.javabrains.auth.server.models;

import java.io.Serializable;

public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Permission() {
	}

	private Integer id;
	private String name;

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

	public Permission(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
