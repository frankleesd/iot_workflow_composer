package com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration;


import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.AlternativeImportance;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.AlternativeValue;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.CriterionImportance;

import java.io.Serializable;

public class Goal extends Criterion implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1654628294916029944L;

    /**
     * @uml.property name="decision"
     * @uml.associationEnd inverse="goals:de.eorg.cumulusgenius.shared.cloudmapping.model.ahp.configuration.Decision"
     */
    private Decision decision;

    /**
     * @uml.property name="goalType"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private GoalType goalType = GoalType.POSITIVE;


    public Goal(Criterion c) {
        this.setDescription(c.getDescription());
        this.setType(c.getType());
        this.setWeight(c.getWeight());
        for (Criterion ch : c.getChildren())
            this.addChild(ch.clone());
        for (CriterionImportance ci : c.getImportanceChildren())
            this.getImportanceChildren().add(ci.clone());
        for (AlternativeImportance ai : c.getImportanceAlternatives())
            this.getImportanceAlternatives().add(ai.clone());
        for (AlternativeValue av : c.getValuesAlternatives())
            this.getValuesAlternatives().add(av.clone());
    }


    /**
     * @param decision the decision to set
     * @uml.property name="decision"
     */
    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    /**
     * @return the decision
     * @uml.property name="decision"
     */
    public Decision getDecision() {
        return decision;
    }

    public Goal() {
        super();
    }

    ;

    public Goal(String name) {
        super(name);
    }

    public boolean hasDecision() {
        return getDecision() != null;
    }


    public Goal clone() {
        Goal g = new Goal(getName());
        g.setDescription(getDescription());
        g.setType(getType());
        g.setGoalType(getGoalType());
        g.setWeight(getWeight());
        for (Criterion ch : getChildren())
            g.addChild(ch.clone());
        for (CriterionImportance ci : getImportanceChildren())
            g.getImportanceChildren().add(ci.clone());
        for (AlternativeImportance ai : getImportanceAlternatives())
            g.getImportanceAlternatives().add(ai.clone());
        for (AlternativeValue av : getValuesAlternatives())
            g.getValuesAlternatives().add(av.clone());

        return g;
    }

    /**
     * @param goalType the goalType to set
     * @uml.property name="goalType"
     */
    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    /**
     * @return the goalType
     * @uml.property name="goalType"
     */
    public GoalType getGoalType() {
        return goalType;
    }

}
