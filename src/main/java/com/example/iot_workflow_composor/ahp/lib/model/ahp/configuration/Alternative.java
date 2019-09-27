package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;

import java.io.Serializable;

public class Alternative implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3016699896490202374L;

	/**
	 * @uml.property name="name"
	 */
	private String name;

	/**
	 * @uml.property name="description"
	 */
	private String description;

	/**
	 * @uml.property name="decision"
	 * @uml.associationEnd inverse=
	 *                     "alternatives:de.eorg.cumulusgenius.shared.cloudmapping.model.ahp.configuration.Decision"
	 */
	private Decision decision;

	/**
	 * @return
	 * @uml.property name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @uml.property name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property name="decision"
	 */
	public Decision getDecision() {
		return decision;
	}

	/**
	 * @param decision
	 * @uml.property name="decision"
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	public Alternative() {
		super();
	}

	public Alternative(String name) {
		super();
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}

	/**
	 * @param description
	 * @uml.property name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 * @uml.property name="description"
	 */
	public String getDescription() {
		return description;
	}

	public Alternative clone() {
		Alternative alt = new Alternative(getName());
		alt.setDescription(getDescription());
		return alt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((decision == null) ? 0 : decision.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alternative))
			return false;
		Alternative other = (Alternative) obj;
		if (decision == null) {
			if (other.decision != null)
				return false;
		} else if (!decision.equals(other.decision))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
