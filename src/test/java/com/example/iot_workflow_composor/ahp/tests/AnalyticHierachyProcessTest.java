package com.example.iot_workflow_composor.ahp.tests;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.example.iot_workflow_composor.ahp.lib.jama.Matrix;
import com.example.iot_workflow_composor.ahp.lib.logic.ahp.AnalyticHierarchyProcess;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Alternative;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Decision;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Goal;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.Evaluation;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.EvaluationResult;

public class AnalyticHierachyProcessTest {

	@Test
	public void testEvaluate() {

		double[][] criteria = { { 1, 1D / 2D, 5 }, { 2, 1, 4 },
					{ 1D / 5D, 1D / 4D, 1 } };
		Matrix criteriaMatrix = new Matrix(criteria);
		Decision decision = new Decision();
		Goal goal = new Goal();
		goal.setName("buy car");
		Criterion c1 = new Criterion();
		c1.setName("style");
		Criterion c2 = new Criterion();
		c2.setName("reliability");
		Criterion c3 = new Criterion();
		c3.setName("efficiency");

		Alternative a1 = new Alternative("VW Golf");
		Alternative a2 = new Alternative("BMW 1");
		Alternative a3 = new Alternative("Mercedes-Benz A");
		Alternative a4 = new Alternative("Porsche 911");


		goal.addChild(c1);
		goal.addChild(c2);
		goal.addChild(c3);
		c1.setWeight(0.3196);
		c2.setWeight(0.5584);
		c3.setWeight(0.1220);
		decision.addGoal(goal);
		decision.addAlternative(a1);
		decision.addAlternative(a2);
		decision.addAlternative(a3);
		decision.addAlternative(a4);

		AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);
		Evaluation ev = new Evaluation();

		ahp.setChildrenCriteriaWeights(goal, criteriaMatrix, 15);

		double[][] crit1 = { { 1, 1D / 4D, 4D, 1D / 6D },
				{ 4D, 1, 4D, 1D / 4D }, { 1D / 4D, 1D / 4D, 1, 1D / 5D },
				{ 6D / 1D, 4D / 1D, 5D / 1D, 1 } };
		ev.getEvaluations().add(new Matrix(crit1));
		double[][] crit2 = { { 1, 2D, 5D, 1 }, { 1D / 2D, 1, 3D, 2D },
				{ 1D / 5D, 1D / 3D, 1, 1D / 4D }, { 1, 1D / 2D, 4D, 1 } };
		ev.getEvaluations().add(new Matrix(crit2));
		double[][] crit3 = { { 1, 34D / 27D, 34D / 24D, 34D / 28D },
				{ 27D / 34D, 1, 27D / 24D, 27D / 28D },
				{ 24D / 34D, 24D / 27D, 1, 24D / 28D },
				{ 28D / 34D, 28D / 27D, 28D / 24D, 1 } };
		ev.getEvaluations().add(new Matrix(crit3));

		// Test Map
		Map<Criterion, Double> testMap = new HashMap<Criterion, Double>();
		testMap.put(c1, 0.3196);
		testMap.put(c2, 0.5584);
		testMap.put(c3, 0.1220);

		try {
			System.out.println(((Goal) decision.getGoals().iterator().next())
					.getLeafCriteria());
			List<Evaluation> evals = new ArrayList<Evaluation>();
			evals.add(ev);
			EvaluationResult results = ahp.evaluateFull(evals, 15);
			System.out.println(results);
			//Assert.assertEquals(testMap, results);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
