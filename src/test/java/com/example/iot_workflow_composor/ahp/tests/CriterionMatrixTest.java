package com.example.iot_workflow_composor.ahp.tests;
import java.util.List;

import org.junit.Test;

import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Alternative;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Decision;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Goal;

public class CriterionMatrixTest {

	@Test
	public void testAddMatrixWeights() {

		Decision decision = new Decision();
		Goal goal = new Goal();
		goal.setName("destination");
		Criterion c1 = new Criterion("Landscape");
		Criterion c2 = new Criterion("Price");
		Criterion c3 = new Criterion("Food");
		Criterion c11 = new Criterion("c11");
		Criterion c12 = new Criterion("c12");
		Criterion c31 = new Criterion("c31");
		c1.addChild(c11);
		c1.addChild(c12);
		c3.addChild(c31);
		Criterion c111 = new Criterion("c111");
		Criterion c112 = new Criterion("c112");
		Criterion c113 = new Criterion("c113");
		c11.addChild(c111);
		c11.addChild(c112);
		c11.addChild(c113);
		Criterion c121 = new Criterion("c121");
		Criterion c122 = new Criterion("c122");
		Criterion c123 = new Criterion("c123");
		c12.addChild(c121);
		c12.addChild(c122);
		c12.addChild(c123);
		Criterion c21 = new Criterion("c21");
		Criterion c22 = new Criterion("c22");
		c2.addChild(c21);
		c2.addChild(c22);

		Alternative a1 = new Alternative();
		a1.setName("Japan");
		Alternative a2 = new Alternative();
		a2.setName("Thailand");
		Alternative a3 = new Alternative();
		a3.setName("America");
		Alternative a4 = new Alternative();
		a4.setName("Iceland");

		goal.addChild(c1);
		goal.addChild(c2);
		goal.addChild(c3);
		// c1.setWeight(0.3196);
		// c2.setWeight(0.5584);
		// c3.setWeight(0.1220);
		decision.addGoal(goal);
		decision.addAlternative(a1);
		decision.addAlternative(a2);
		decision.addAlternative(a3);
		decision.addAlternative(a4);

		System.out.println("Final place:");
		int i = 0;
		for (List<Criterion> list : goal.getCriteriaByLevels()) {
			System.out.println("level " + i);
			for (Criterion criterion : list) {
				System.out.println(criterion.getName());
			}
			i++;
		}
	}

}
