package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;

import java.io.Serializable;

public enum GoalType implements Serializable {

	POSITIVE(1), NEGATIVE(-1);
	
	
	/**
	 * @uml.property  name="factor"
	 */
	int factor;
	
	GoalType(int i) {
		this.setFactor(i);
	}

	/**
	 * @param factor  the factor to set
	 * @uml.property  name="factor"
	 */
	public void setFactor(int factor) {
		this.factor = factor;
	}

	/**
	 * @return  the factor
	 * @uml.property  name="factor"
	 */
	public int getFactor() {
		return factor;
	}
}
