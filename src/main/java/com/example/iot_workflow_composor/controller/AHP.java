package com.example.iot_workflow_composor.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.example.iot_workflow_composor.ahp.lib.jama.Matrix;
import com.example.iot_workflow_composor.ahp.lib.logic.ahp.AnalyticHierarchyProcess;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Alternative;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Decision;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Goal;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.GoalType;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.Evaluation;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.EvaluationResult;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.values.GoalImportance;
import com.example.iot_workflow_composor.utils.FractionToDouble;

public class AHP {

    public String AHPOperation(JSONObject jsonObj) throws ParseException {
        String ahpResult = "";

        Decision<Alternative> decision = new Decision<Alternative>();
        decision.setName("CKR selection");

        // set goals
        Goal g1 = new Goal("ResourceCost");
        // g1.setGoalType(GoalType.NEGATIVE);
        Goal g2 = new Goal("ResourceQoS");
        Goal g3 = new Goal("Data");

        // set criterion
        // ResourceCost
        Criterion c11 = new Criterion("HardwareCost");
        Criterion c12 = new Criterion("HostingCost");
        Criterion c13 = new Criterion("NetworkCost");
        g1.addChild(c11);
        g1.addChild(c12);
        g1.addChild(c13);

        // ResourceQoS
        Criterion c21 = new Criterion("Reliability");
        Criterion c22 = new Criterion("Mobility");
        Criterion c23 = new Criterion("Heterogeneity");
        Criterion c24 = new Criterion("Scalability");
        Criterion c25 = new Criterion("Capability");
        Criterion c26 = new Criterion("ResourceAvailability");
        g2.addChild(c21);
        g2.addChild(c22);
        g2.addChild(c23);
        g2.addChild(c24);
        g2.addChild(c25);
        g2.addChild(c26);

        // Data
        Criterion c31 = new Criterion("DataPrivacy");
        Criterion c32 = new Criterion("DataAvailability");
        Criterion c33 = new Criterion("LongTermStorage");
        Criterion c34 = new Criterion("DataReplication");
        Criterion c35 = new Criterion("DataIntegrity");
        Criterion c36 = new Criterion("DataFreshness");
        Criterion c37 = new Criterion("Latency");
        g3.addChild(c31);
        g3.addChild(c32);
        g3.addChild(c33);
        g3.addChild(c34);
        g3.addChild(c35);
        g3.addChild(c36);
        g3.addChild(c37);

        // get goal weights, g1g2 means comparing g1 to g2
        Object g1g2 = jsonObj.get("ResourceCost/ResourceQoS");
        Object g1g3 = jsonObj.get("ResourceCost/Data");
        Object g2g3 = jsonObj.get("ResourceQoS/Data");

        // parse fraction to double
        Double g1g2Double = new FractionToDouble().fractionToDouble(g1g2.toString());
        Double g1g3Double = new FractionToDouble().fractionToDouble(g1g3.toString());
        Double g2g3Double = new FractionToDouble().fractionToDouble(g2g3.toString());

        // get subcriterion weights for g1
        Object c11c12 = jsonObj.get("HardwareCost/HostingCost");
        Object c11c13 = jsonObj.get("HardwareCost/NetworkCost");
        Object c12c13 = jsonObj.get("HostingCost/NetworkCost");

        // parse fraction to double
        Double c11c12Double = new FractionToDouble().fractionToDouble(c11c12.toString());
        Double c11c13Double = new FractionToDouble().fractionToDouble(c11c13.toString());
        Double c12c13Double = new FractionToDouble().fractionToDouble(c12c13.toString());

        // get subcriterion weights for g2
        Object c21c22 = jsonObj.get("Reliability/Mobility");
        Object c21c23 = jsonObj.get("Reliability/Heterogeneity");
        Object c21c24 = jsonObj.get("Reliability/Scalability");
        Object c21c25 = jsonObj.get("Reliability/Capability");
        Object c21c26 = jsonObj.get("Reliability/ResourceAvaibility");
        Object c22c23 = jsonObj.get("Mobility/Heterogeneity");
        Object c22c24 = jsonObj.get("Mobility/Scalability");
        Object c22c25 = jsonObj.get("Mobility/Capability");
        Object c22c26 = jsonObj.get("Mobility/ResourceAvailability");
        Object c23c24 = jsonObj.get("Heterogeneity/Scalability");
        Object c23c25 = jsonObj.get("Heterogeneity/Capability");
        Object c23c26 = jsonObj.get("Heterogeneity/ResourceAvailability");
        Object c24c25 = jsonObj.get("Scalability/Capability");
        Object c24c26 = jsonObj.get("Scalability/ResourceAvailability");
        Object c25c26 = jsonObj.get("Capability/ResourceAvailability");

        // parse fraction to double
        Double c21c22Double = new FractionToDouble().fractionToDouble(c21c22.toString());
        Double c21c23Double = new FractionToDouble().fractionToDouble(c21c23.toString());
        Double c21c24Double = new FractionToDouble().fractionToDouble(c21c24.toString());
        Double c21c25Double = new FractionToDouble().fractionToDouble(c21c25.toString());
        Double c21c26Double = new FractionToDouble().fractionToDouble(c21c26.toString());
        Double c22c23Double = new FractionToDouble().fractionToDouble(c22c23.toString());
        Double c22c24Double = new FractionToDouble().fractionToDouble(c22c24.toString());
        Double c22c25Double = new FractionToDouble().fractionToDouble(c22c25.toString());
        Double c22c26Double = new FractionToDouble().fractionToDouble(c22c26.toString());
        Double c23c24Double = new FractionToDouble().fractionToDouble(c23c24.toString());
        Double c23c25Double = new FractionToDouble().fractionToDouble(c23c25.toString());
        Double c23c26Double = new FractionToDouble().fractionToDouble(c23c26.toString());
        Double c24c25Double = new FractionToDouble().fractionToDouble(c24c25.toString());
        Double c24c26Double = new FractionToDouble().fractionToDouble(c24c26.toString());
        Double c25c26Double = new FractionToDouble().fractionToDouble(c25c26.toString());

        // get subcriterion weights for g3
        Object c31c32 = jsonObj.get("DataPrivacy/DataAvailability");
        Object c31c33 = jsonObj.get("DataPrivacy/LongTermStorage");
        Object c31c34 = jsonObj.get("DataPrivacy/DataReplication");
        Object c31c35 = jsonObj.get("DataPrivacy/DataIntegrity");
        Object c31c36 = jsonObj.get("DataPrivacy/DataFreshness");
        Object c31c37 = jsonObj.get("DataPrivacy/Latency");
        Object c32c33 = jsonObj.get("DataAvailability/LongTermStorage");
        Object c32c34 = jsonObj.get("DataAvailability/DataReplication");
        Object c32c35 = jsonObj.get("DataAvailability/DataIntegrity");
        Object c32c36 = jsonObj.get("DataAvailability/DataFreshness");
        Object c32c37 = jsonObj.get("DataAvailability/Latency");
        Object c33c34 = jsonObj.get("LongTermStorage/DataReplication");
        Object c33c35 = jsonObj.get("LongTermStorage/DataIntegrity");
        Object c33c36 = jsonObj.get("LongTermStorage/DataFreshness");
        Object c33c37 = jsonObj.get("LongTermStorage/Latency");
        Object c34c35 = jsonObj.get("DataReplication/DataIntegrity");
        Object c34c36 = jsonObj.get("DataReplication/DataFreshness");
        Object c34c37 = jsonObj.get("DataReplication/Latency");
        Object c35c36 = jsonObj.get("DataIntegrity/DataFreshness");
        Object c35c37 = jsonObj.get("DataIntegrity/Latency");
        Object c36c37 = jsonObj.get("DataFreshness/Latency");

        // parse fraction to double
        Double c31c32Double = new FractionToDouble().fractionToDouble(c31c32.toString());
        Double c31c33Double = new FractionToDouble().fractionToDouble(c31c33.toString());
        Double c31c34Double = new FractionToDouble().fractionToDouble(c31c34.toString());
        Double c31c35Double = new FractionToDouble().fractionToDouble(c31c35.toString());
        Double c31c36Double = new FractionToDouble().fractionToDouble(c31c36.toString());
        Double c31c37Double = new FractionToDouble().fractionToDouble(c31c37.toString());
        Double c32c33Double = new FractionToDouble().fractionToDouble(c32c33.toString());
        Double c32c34Double = new FractionToDouble().fractionToDouble(c32c34.toString());
        Double c32c35Double = new FractionToDouble().fractionToDouble(c32c35.toString());
        Double c32c36Double = new FractionToDouble().fractionToDouble(c32c36.toString());
        Double c32c37Double = new FractionToDouble().fractionToDouble(c32c37.toString());
        Double c33c34Double = new FractionToDouble().fractionToDouble(c33c34.toString());
        Double c33c35Double = new FractionToDouble().fractionToDouble(c33c35.toString());
        Double c33c36Double = new FractionToDouble().fractionToDouble(c33c36.toString());
        Double c33c37Double = new FractionToDouble().fractionToDouble(c33c37.toString());
        Double c34c35Double = new FractionToDouble().fractionToDouble(c34c35.toString());
        Double c34c36Double = new FractionToDouble().fractionToDouble(c34c36.toString());
        Double c34c37Double = new FractionToDouble().fractionToDouble(c34c37.toString());
        Double c35c36Double = new FractionToDouble().fractionToDouble(c35c36.toString());
        Double c35c37Double = new FractionToDouble().fractionToDouble(c35c37.toString());
        Double c36c37Double = new FractionToDouble().fractionToDouble(c36c37.toString());

        // defining Alternatives
        Alternative a1 = new Alternative();
        a1.setName("CKR1");
        Alternative a2 = new Alternative();
        a2.setName("CKR2");
        Alternative a3 = new Alternative();
        a3.setName("CKR3");
        Alternative a4 = new Alternative();
        a4.setName("CKR4");
        Alternative a5 = new Alternative();
        a5.setName("CKR5");
        Alternative a6 = new Alternative();
        a6.setName("CKR6");

        decision.addGoal(g1);
        decision.addGoal(g2);
        decision.addGoal(g3);

        decision.addAlternative(a1);
        decision.addAlternative(a2);
        decision.addAlternative(a3);
        decision.addAlternative(a4);
        decision.addAlternative(a5);
        decision.addAlternative(a6);

        System.out.println("Tree:");
        int i = 0;
        for (List<Criterion> list : (List<List<Criterion>>) decision.getCriteriaByLevels()) {
            System.out.println("level " + i);
            for (Criterion criterion : list) {
                System.out.println(criterion);
            }
            i++;
        }

        AnalyticHierarchyProcess ahp = new AnalyticHierarchyProcess(decision);

        // set goal importance
        decision.getImportanceGoals(GoalType.POSITIVE).add(new GoalImportance(0, 1, g1g2Double - 1D, null));
        decision.getImportanceGoals(GoalType.POSITIVE).add(new GoalImportance(0, 2, g1g3Double - 1D, null));
        decision.getImportanceGoals(GoalType.POSITIVE).add(new GoalImportance(1, 2, g2g3Double - 1D, null));

        System.out.println("\n Weights of Criteria ResourceCost");
        double[][] crit1 = { { 1, c11c12Double, c11c13Double }, { 1 / c11c12Double, 1, c12c13Double },
                { 1 / c11c13Double, 1 / c12c13Double, 1 } };
        Matrix ccrit1 = new Matrix(crit1);
        System.out.println(Arrays.deepToString(crit1));
        ahp.setChildrenCriteriaWeights(g1, ccrit1, 15);

        System.out.println("\n Weights of Criteria ResourceQoS");
        double[][] crit2 = { { 1, c21c22Double, c21c23Double, c21c24Double, c21c25Double, c21c26Double },
                { 1 / c21c22Double, 1, c22c23Double, c22c24Double, c22c25Double, c22c26Double },
                { 1 / c21c23Double, 1 / c22c23Double, 1, c23c24Double, c23c25Double, c23c26Double },
                { 1 / c21c24Double, 1 / c22c24Double, 1 / c23c24Double, 1, c24c25Double, c24c26Double },
                { 1 / c21c25Double, 1 / c22c25Double, 1 / c23c25Double, 1 / c24c25Double, 1, c25c26Double },
                { 1 / c21c26Double, 1 / c22c26Double, 1 / c23c26Double, 1 / c24c26Double, 1 / c25c26Double, 1 } };
        Matrix ccrit2 = new Matrix(crit2);
        System.out.println(Arrays.deepToString(crit2));
        ahp.setChildrenCriteriaWeights(g2, ccrit2, 15);

        System.out.println("\n Weights of Criteria Data");
        double[][] crit3 = { { 1, c31c32Double, c31c33Double, c31c34Double, c31c35Double, c31c36Double, c31c37Double },
                { 1 / c31c32Double, 1, c32c33Double, c32c34Double, c32c35Double, c32c36Double, c32c37Double },
                { 1 / c31c33Double, 1 / c32c33Double, 1, c33c34Double, c33c35Double, c33c36Double, c33c37Double },
                { 1 / c31c34Double, 1 / c32c34Double, 1 / c33c34Double, 1, c34c35Double, c34c36Double, c34c37Double },
                { 1 / c31c35Double, 1 / c32c35Double, 1 / c33c35Double, 1 / c34c35Double, 1, c35c36Double,
                        c35c37Double },
                { 1 / c31c36Double, 1 / c32c36Double, 1 / c33c36Double, 1 / c34c36Double, 1 / c35c36Double, 1,
                        c36c37Double },
                { 1 / c31c37Double, 1 / c32c37Double, 1 / c33c37Double, 1 / c34c37Double, 1 / c35c37Double,
                        1 / c36c37Double, 1 } };
        Matrix ccrit3 = new Matrix(crit3);
        System.out.println(Arrays.deepToString(crit3));
        ahp.setChildrenCriteriaWeights(g3, ccrit3, 15);

        System.out.println("Assessment of Alternatives regarding Criteria");

        List<Evaluation> evals = new ArrayList<Evaluation>();

        // ResourceCost Goal Evaluation
        Evaluation ev = new Evaluation();

        // HardwareCost
        // set by admin
        double crit11[][] = { { 1, 1 / 3D, 1 / 9D, 9, 9, 9 }, { 3, 1, 1 / 3D, 9, 9, 9 }, { 9, 3, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit11M = new Matrix(crit11);
        // System.out.println(Arrays.deepToString(crit11));
        ev.getEvaluations().add(crit11M);

        // HostingCost
        // set by admin
        double crit12[][] = { { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D },
                { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 9, 9, 9, 1, 1 / 3D, 1 / 9D }, { 9, 9, 9, 3, 1, 1 / 3D },
                { 9, 9, 9, 9, 3, 1 } };
        Matrix crit12M = new Matrix(crit12);
        // System.out.println(Arrays.deepToString(crit12));
        ev.getEvaluations().add(crit12M);

        // NetworkCost
        // set by admin
        double crit13[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit13M = new Matrix(crit13);
        // System.out.println(Arrays.deepToString(crit13));
        ev.getEvaluations().add(crit13M);

        evals.add(ev);

        // ResourceQoS Goal Evaluation
        ev = new Evaluation();

        // Reliability
        // set by admin
        double crit21[][] = { { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D }, { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D },
                { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D }, { 5, 5, 5, 1, 1, 1 }, { 5, 5, 5, 1, 1, 1 }, { 5, 5, 5, 1, 1, 1 } };
        Matrix crit21M = new Matrix(crit21);
        // System.out.println(Arrays.deepToString(crit21));
        ev.getEvaluations().add(crit21M);

        // Mobility
        // set by admin
        double crit22[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit22M = new Matrix(crit22);
        // System.out.println(Arrays.deepToString(crit22));
        ev.getEvaluations().add(crit22M);

        // Heterogeneity
        // set by admin
        double crit23[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit23M = new Matrix(crit23);
        // System.out.println(Arrays.deepToString(crit23));
        ev.getEvaluations().add(crit23M);

        // Scalability
        // set by admin
        double crit24[][] = { { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D },
                { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 9, 9, 9, 1, 1, 1 }, { 9, 9, 9, 1, 1, 1 }, { 9, 9, 9, 1, 1, 1 } };
        Matrix crit24M = new Matrix(crit24);
        // System.out.println(Arrays.deepToString(crit24));
        ev.getEvaluations().add(crit24M);

        // Capability
        // set by admin
        double crit25[][] = { { 1, 1 / 3D, 1 / 5D, 1 / 5D, 1 / 7D, 1 / 9D }, { 3, 1, 1 / 3D, 1 / 3D, 1 / 3D, 1 / 5D },
                { 5, 3, 1, 1, 1 / 3D, 1 / 3D }, { 5, 3, 1, 1, 1 / 3D, 1 / 5D }, { 7, 3, 3, 3, 1, 1 / 3D },
                { 9, 5, 3, 5, 3, 1 } };
        Matrix crit25M = new Matrix(crit25);
        // System.out.println(Arrays.deepToString(crit25));
        ev.getEvaluations().add(crit25M);

        // Resource Availability
        // set by admin
        double crit26[][] = { { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D }, { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D },
                { 1, 1, 1, 1 / 5D, 1 / 5D, 1 / 5D }, { 5, 5, 5, 1, 1, 1 }, { 5, 5, 5, 1, 1, 1 }, { 5, 5, 5, 1, 1, 1 } };
        Matrix crit26M = new Matrix(crit26);
        // System.out.println(Arrays.deepToString(crit26));
        ev.getEvaluations().add(crit26M);

        evals.add(ev);

        // Data Goal Evaluation
        ev = new Evaluation();

        // Data Privacy
        // set by admin
        double crit31[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit31M = new Matrix(crit31);
        // System.out.println(Arrays.deepToString(crit31));
        ev.getEvaluations().add(crit31M);

        // Data Availability
        // set by admin
        double crit32[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit32M = new Matrix(crit32);
        // System.out.println(Arrays.deepToString(crit32));
        ev.getEvaluations().add(crit32M);

        // LongTerm Storage
        // set by admin
        double crit33[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit33M = new Matrix(crit33);
        // System.out.println(Arrays.deepToString(crit33));
        ev.getEvaluations().add(crit33M);

        // Data Replication
        // set by admin
        double crit34[][] = { { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D },
                { 1, 1, 1, 1 / 9D, 1 / 9D, 1 / 9D }, { 9, 9, 9, 1, 1, 1 }, { 9, 9, 9, 1, 1, 1 }, { 9, 9, 9, 1, 1, 1 } };
        Matrix crit34M = new Matrix(crit34);
        // System.out.println(Arrays.deepToString(crit34));
        ev.getEvaluations().add(crit34M);

        // Data Integrity
        // set by admin
        double crit35[][] = { { 1, 1, 1, 5, 5, 5 }, { 1, 1, 1, 5, 5, 5 }, { 1, 1, 1, 5, 5, 5 },
                { 1 / 5D, 1 / 5D, 1 / 5D, 1, 1, 1 }, { 1 / 5D, 1 / 5D, 1 / 5D, 1, 1, 1 },
                { 1 / 5D, 1 / 5D, 1 / 5D, 1, 1, 1 } };
        Matrix crit35M = new Matrix(crit35);
        // System.out.println(Arrays.deepToString(crit35));
        ev.getEvaluations().add(crit35M);

        // Data Freshness
        // set by admin
        double crit36[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit36M = new Matrix(crit36);
        // System.out.println(Arrays.deepToString(crit36));
        ev.getEvaluations().add(crit36M);

        // Latency
        // set by admin
        double crit37[][] = { { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 }, { 1, 1, 1, 9, 9, 9 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 }, { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 },
                { 1 / 9D, 1 / 9D, 1 / 9D, 1, 1, 1 } };
        Matrix crit37M = new Matrix(crit37);
        // System.out.println(Arrays.deepToString(crit37));
        ev.getEvaluations().add(crit37M);

        evals.add(ev);

        try {
            System.out.println(((Goal) decision.getGoals().iterator().next()).getLeafCriteria());

            EvaluationResult results = ahp.evaluateFull(evals);
            // System.out.println(results);
            System.out.println("Multiplicative: " + results.getResultMultiplicativeIndexMap());
            System.out.println("Additive: " + results.getResultAdditiveIndexMap());
            System.out.println("Positive: " + results.getResultPositiveGoalsMap());
            System.out.println("Negative: " + results.getResultNegativeGoalsMap());

            List<Map.Entry<Alternative, Double>> list_Data = new ArrayList<Map.Entry<Alternative, Double>>(
                    results.getResultPositiveGoalsMap().entrySet());
            Collections.sort(list_Data, new Comparator<Map.Entry<Alternative, Double>>() {
                public int compare(Map.Entry<Alternative, Double> o1, Map.Entry<Alternative, Double> o2) {
                    if ((o2.getValue() - o1.getValue()) > 0)
                        return 1;
                    else if ((o2.getValue() - o1.getValue()) == 0)
                        return 0;
                    else
                        return -1;
                }
            });
            ahpResult = list_Data.get(0).getKey().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ahpResult;
    }
}