package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.jama.Matrix;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AlternativeWeightsMatrix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1861542902838232284L;

	// the order of this list must not be changed
	/**
	 * @uml.property  name="numberOfAlternatives"
	 */
	private int numberOfAlternatives = 1;

	/**
	 * @uml.property  name="values"
	 */
	private final Set<AlternativeImportance> values = new HashSet<AlternativeImportance>();

	/**
	 * @uml.property  name="matrix"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Matrix matrix = Matrix.identity(1, 1);

	/**
	 * @uml.property  name="comparison"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Double java.lang.Double"
	 */
	private final HashMap<Double, Double> comparison = new HashMap<Double, Double>();

	public AlternativeWeightsMatrix(int alternatives,
			List<AlternativeImportance> weights, Criterion c) {
		super();
		comparison.put(-9D, 1D / 10D);
		comparison.put(-8D, 1D / 9D);
		comparison.put(-7D, 1D / 8D);
		comparison.put(-6D, 1D / 7D);
		comparison.put(-5D, 1D / 6D);
		comparison.put(-4D, 1D / 5D);
		comparison.put(-3D, 1D / 4D);
		comparison.put(-2D, 1D / 3D);
		comparison.put(-1D, 1D / 2D);
		comparison.put(0D, 1D);
		comparison.put(1D, 2D);
		comparison.put(2D, 3D);
		comparison.put(3D, 4D);
		comparison.put(4D, 5D);
		comparison.put(5D, 6D);
		comparison.put(6D, 7D);
		comparison.put(7D, 8D);
		comparison.put(8D, 9D);
		comparison.put(9D, 10D);

		numberOfAlternatives = alternatives;

		if (weights != null && weights.size() > 0)
			values.addAll(weights);

		if (!(values.size() >= numberOfAlternatives * (numberOfAlternatives - 1) / 2))
			for (int i = 0; i < numberOfAlternatives - 1; i++)
				for (int j = i + 1; j < numberOfAlternatives; j++)
						values.add(new AlternativeImportance(i, j, c, 0D, null));
		
		matrix = Matrix.identity(numberOfAlternatives, numberOfAlternatives);
		setMatrixWeights();

	}

	/**
	 * @return
	 * @uml.property  name="matrix"
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	private void setMatrixWeights() {

		for (AlternativeImportance value : values) {
			Double val = value.getComparisonAToB();
			if (comparison.containsKey(value.getComparisonAToB())) {
				val = comparison.get(value.getComparisonAToB());
			}
			matrix.set(value.getAltA(), value.getAltB(), val);
			if (val.doubleValue() != 0D)
				matrix.set(value.getAltB(), value.getAltA(), 1D / val);
		}

	}

	public String checkMatrix() {

		// check matrix size
		int size = numberOfAlternatives;
		if (matrix.getColumnDimension() != size) {
			return "false column dimension";
		}

		if (matrix.getRowDimension() != size) {
			return "false row dimension";
		}

		// check diogonal in matrix (must be 1)
		for (int i = 0; i < size; i++) {
			if (matrix.get(i, i) != 1) {
				return "diagonal not 1";
			}
		}

		// check inverse
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix.get(i, j) != (1 / matrix.get(j, i))) {
					return "false inverse";
				}
			}
		}

		return "matrix ok";
	}

}
