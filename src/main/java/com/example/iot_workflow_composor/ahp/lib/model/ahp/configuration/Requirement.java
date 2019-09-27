package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;

import java.io.Serializable;

public class Requirement implements Serializable {

	/**
	 * @uml.property  name="name"
	 */
	private String name;


	/**
	 * @param name  the name to set
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return  the name
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	
}
