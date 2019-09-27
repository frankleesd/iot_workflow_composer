package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;

import java.io.Serializable;


public interface Importance extends Serializable {

	/**
	 * @return  the comparisonAToB
	 * @uml.property  name="comparisonAToB"
	 */
	public Double getComparisonAToB();

	/**
	 * @return the critA
	 */
	public int getCritA();

	/**
	 * @return the critB
	 */
	public int getCritB();

	/**
	 * @param comparisonAToB  the comparisonAToB to set
	 * @uml.property  name="comparisonAToB"
	 */
	public void setComparisonAToB(Double comparisonAToB);

	/**
	 * @param critA
	 *            the critA to set
	 */
	public void setCritA(int critA);

	/**
	 * @param critB
	 *            the critB to set
	 */
	public void setCritB(int critB);

	/**
	 * @param comment  the comment to set
	 * @uml.property  name="comment"
	 */
	public void setComment(String comment);

	/**
	 * @return  the comment
	 * @uml.property  name="comment"
	 */
	public String getComment();

}