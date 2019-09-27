package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.jama.Matrix;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Decision;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Evaluation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1786731159904287894L;


    // evaluations
    /**
     * @uml.property name="evaluations"
     * @uml.associationEnd multiplicity="(0 -1)" elementType="de.eorg.cumulusgenius.shared.cloudmapping.model.jama.Matrix"
     */
    private List<Matrix> evaluations = new ArrayList<Matrix>();


    /**
     *
     */
    public Evaluation() {
        super();
    }

    /**
     * @return the evaluations
     */
    public List<Matrix> getEvaluations() {
        return evaluations;
    }

    public void update(Decision<?> decision) {
        if (decision.getGoals().size() > 0)
            for (int i = 0; i < decision.getGoals().get(0).getLeafCriteria()
                    .size(); i++)
                if (getEvaluations().size() <= i)
                    getEvaluations().add(
                            new Matrix(decision.getAlternatives().size(),
                                    decision.getAlternatives().size()));
                else if (getEvaluations().get(i) == null)
                    getEvaluations().set(
                            i,
                            new Matrix(decision.getAlternatives().size(),
                                    decision.getAlternatives().size()));
                else if (getEvaluations().get(i).getColumnDimension() != decision
                        .getAlternatives().size()
                        || getEvaluations().get(i).getRowDimension() != decision
                        .getAlternatives().size())
                    getEvaluations().set(
                            i,
                            Matrix.identity(decision.getAlternatives().size(),
                                    decision.getAlternatives().size()));
    }

}
