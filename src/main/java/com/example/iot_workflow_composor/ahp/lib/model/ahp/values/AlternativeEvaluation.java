package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Alternative;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;

import java.io.Serializable;


public class AlternativeEvaluation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7866386142825158814L;

    /**
     * @uml.property name="criterion"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private Criterion criterion;

    /**
     * @uml.property name="alternative"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private Alternative alternative;

    /**
     * @uml.property name="value"
     */
    private Double value;

    /**
     * @param criterion
     * @param alternative
     * @param value
     */
    public AlternativeEvaluation(Criterion criterion, Alternative alternative,
                                 Double value) {
        super();
        this.criterion = criterion;
        this.alternative = alternative;
        this.value = value;
    }

    /**
     * @return the criterion
     * @uml.property name="criterion"
     */
    public Criterion getCriterion() {
        return criterion;
    }

    /**
     * @param criterion the criterion to set
     * @uml.property name="criterion"
     */
    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    /**
     * @return the alternative
     * @uml.property name="alternative"
     */
    public Alternative getAlternative() {
        return alternative;
    }

    /**
     * @param alternative the alternative to set
     * @uml.property name="alternative"
     */
    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    /**
     * @return the value
     * @uml.property name="value"
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     * @uml.property name="value"
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getAlternative().toString() + "/" + getCriterion().toString() + ":=" + value.toString();
    }


}
