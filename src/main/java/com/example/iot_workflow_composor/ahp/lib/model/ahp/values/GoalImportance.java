/**
 *
 */
package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Decision;

import java.io.Serializable;


public class GoalImportance implements Cloneable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8200740178971465972L;

    /**
     * @uml.property name="decision"
     * @uml.associationEnd inverse="importanceGoals:de.eorg.cumulusgenius.shared.cloudmapping.model.ahp.configuration.Decision"
     */
    private Decision decision;

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
    private double comparisonAToB = 1D;

    /**
     * @uml.property name="comment"
     */
    private String comment;

    /**
     *
     */
    public GoalImportance() {
        super();
    }

    /**
     * @param critA
     * @param critB
     * @param comparisonAToB
     */
    public GoalImportance(int critA, int critB, double comparisonAToB, String comment) {
        super();
        this.critA = critA;
        this.critB = critB;
        this.comparisonAToB = comparisonAToB;
        this.comment = comment;
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
        GoalImportance other = (GoalImportance) obj;
        if (critA != other.critA) {
            return false;
        }
        if (critB != other.critB) {
            return false;
        }
        return true;
    }

    /**
     * @return the comparisonAToB
     * @uml.property name="comparisonAToB"
     */
    public double getComparisonAToB() {
        return comparisonAToB;
    }

    /**
     * @return the critA
     * @uml.property name="critA"
     */
    public int getCritA() {
        return critA;
    }

    /**
     * @return the critB
     * @uml.property name="critB"
     */
    public int getCritB() {
        return critB;
    }

    /**
     * @return the parent
     * @uml.property name="decision"
     */
    public Decision getDecision() {
        return decision;
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
        result = prime * result + ((decision == null) ? 0 : decision.hashCode());
        return result;
    }

    /**
     * @param comparisonAToB the comparisonAToB to set
     * @uml.property name="comparisonAToB"
     */
    public void setComparisonAToB(double comparisonAToB) {
        this.comparisonAToB = comparisonAToB;
    }

    /**
     * @param critA the critA to set
     * @uml.property name="critA"
     */
    public void setCritA(int critA) {
        this.critA = critA;
    }

    /**
     * @param critB the critB to set
     * @uml.property name="critB"
     */
    public void setCritB(int critB) {
        this.critB = critB;
    }

    /**
     * @param parent the parent to set
     * @uml.property name="decision"
     */
    public void setDecision(Decision parent) {
        this.decision = parent;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GoalImportance [comparisonAToB=" + comparisonAToB
                + ", critA=" + critA + ", critB=" + critB + "]";
    }


    public GoalImportance clone() {
        return new GoalImportance(getCritA(), getCritB(),
                getComparisonAToB(), getComment());
    }

    /**
     * @param comment the comment to set
     * @uml.property name="comment"
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the comment
     * @uml.property name="comment"
     */
    public String getComment() {
        return comment;
    }
}
