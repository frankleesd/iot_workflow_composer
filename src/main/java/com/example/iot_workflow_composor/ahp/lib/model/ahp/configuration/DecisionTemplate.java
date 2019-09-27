package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;

import java.io.Serializable;


public class DecisionTemplate extends Decision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3869418492398074682L;
	
	
	/**
	 * @uml.property  name="templateName"
	 */
	private String templateName;

	public DecisionTemplate() {
		super();
	}

	public DecisionTemplate(Decision dec) {
		super();
		Decision decision = dec.clone();
		setAlternatives(decision.getAlternatives());
		setGoals(decision.getGoals());
		setUserId(decision.getUserId());
		setName(decision.getName());
		setDescription(decision.getDescription());
		setTemplateName("New Template");

	}

	public Decision getDecision() {
		return clone();
	}

	/**
	 * @param templateName  the templateName to set
	 * @uml.property  name="templateName"
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return  the templateName
	 * @uml.property  name="templateName"
	 */
	public String getTemplateName() {
		return templateName;
	}

}
