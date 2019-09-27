/**
 * 
 */
package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;

import java.io.Serializable;

public enum CriterionType implements Serializable {

	QUANTITATIVE("quantitative"), QUALITATIVE("qualitative"), BENCHMARK("benchmark");
	
	/**
	 * @uml.property  name="typeName"
	 */
	String typeName;
	
	private CriterionType(String type) {
		setTypeName(type);
	}

	/**
	 * @return  the type
	 * @uml.property  name="typeName"
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param type  the type to set
	 * @uml.property  name="typeName"
	 */
	private void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return getTypeName();
	}
	
	
	
	
}
