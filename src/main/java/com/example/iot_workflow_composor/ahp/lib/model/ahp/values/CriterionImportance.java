/**
 *
 */
package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;

import java.io.Serializable;


public class CriterionImportance implements Cloneable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8980041770341071607L;

    /**
     * @uml.property name="parent"
     * @uml.associationEnd inverse="importanceChildren:de.eorg.cumulusgenius.shared.cloudmapping.model.ahp.configuration.Criterion"
     */
    private Criterion parent;

    /**
     * @uml.property name="critA"
     */
    private int critA;

    /**
     * @uml.property name="critB"
     */
    private int critB;

    /**
     * @uml.property name="comparisonAToB"
     */
    private double comparisonAToB;

    /**
     * @uml.property name="comment"
     */
    private String comment;

    /**
     *
     */
    public CriterionImportance() {
        super();
    }

    /**
     * @param critA
     * @param critB
     * @param comparisonAToB
     */
    public CriterionImportance(int critA, int critB, double comparisonAToB, String comment) {
        super();
        this.critA = critA;
        this.critB = critB;
        this.comparisonAToB = comparisonAToB;
        this.comment = comment;
    }


    public CriterionImportance clone() {
        return new CriterionImportance(getCritA(), getCritB(),
                getComparisonAToB(), getComment());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CriterionImportance other = (CriterionImportance) obj;
        if (critA != other.critA) {
            return false;
        }
        if (critB != other.critB) {
            return false;
        }
        return true;
    }

	/* (non-Javadoc)
     * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#getComment()
	 */

    /**
     * @return
     * @uml.property name="comment"
     */
    public String getComment() {
        return comment;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#getComparisonAToB()
	 */

    /**
     * @return
     * @uml.property name="comparisonAToB"
     */
    public double getComparisonAToB() {
        return comparisonAToB;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#getCritA()
	 */

    /**
     * @return
     * @uml.property name="critA"
     */
    public int getCritA() {
        return critA;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#getCritB()
	 */

    /**
     * @return
     * @uml.property name="critB"
     */
    public int getCritB() {
        return critB;
    }


    /**
     * @return the parent
     * @uml.property name="parent"
     */
    public Criterion getParent() {
        return parent;
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
        result = prime * result + critA;
        result = prime * result + critB;
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        return result;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#setComment(java.lang.String)
	 */

    /**
     * @param comment
     * @uml.property name="comment"
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#setComparisonAToB(java.lang.Double)
	 */

    /**
     * @param comparisonAToB
     * @uml.property name="comparisonAToB"
     */
    public void setComparisonAToB(double comparisonAToB) {
        this.comparisonAToB = comparisonAToB;
    }


	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#setCritA(int)
	 */

    /**
     * @param critA
     * @uml.property name="critA"
     */
    public void setCritA(int critA) {
        this.critA = critA;
    }

	/* (non-Javadoc)
	 * @see de.fzi.aotearoa.shared.model.ahp.values.Importance#setCritB(int)
	 */

    /**
     * @param critB
     * @uml.property name="critB"
     */
    public void setCritB(int critB) {
        this.critB = critB;
    }

    /**
     * @param parent the parent to set
     * @uml.property name="parent"
     */
    public void setParent(Criterion parent) {
        this.parent = parent;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CriterionImportance [comparisonAToB=" + comparisonAToB
                + ", critA=" + critA + ", critB=" + critB + "]";
    }
}
