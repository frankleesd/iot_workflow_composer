package com.example.iot_workflow_composor.ahp.lib.model.ahp.values;


import com.example.iot_workflow_composor.ahp.lib.jama.Matrix;
import com.example.iot_workflow_composor.ahp.lib.model.ahp.configuration.Criterion;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class AlternativeValuesMatrix implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2671684884977491386L;

    // the order of this list must not be changed
    /**
     * @uml.property name="numberOfAlternatives"
     */
    private int numberOfAlternatives = 1;

    /**
     * @uml.property name="values"
     */
    private final Set<AlternativeValue> values = new HashSet<AlternativeValue>();

    /**
     * @uml.property name="matrix"
     * @uml.associationEnd multiplicity="(1 1)"
     */
    private Matrix matrix = Matrix.identity(1, 1);

    /**
     * @param values
     */
    public AlternativeValuesMatrix(int alternatives,
                                   List<AlternativeValue> values, Criterion c) {
        super();

        numberOfAlternatives = alternatives;

        if (values != null && values.size() > 0)
            this.values.addAll(values);

        matrix = Matrix.identity(numberOfAlternatives, numberOfAlternatives);
        setMatrixWeights();
    }

    /**
     * @return
     * @uml.property name="matrix"
     */
    public Matrix getMatrix() {
        return matrix;
    }

    private void setMatrixWeights() {

        Vector<Double> vals = new Vector<Double>(numberOfAlternatives);
        for (int i = 0; i < numberOfAlternatives; i++)
            vals.add(1D);

        for (AlternativeValue value : values) {
            vals.set(value.getAlt(), value.getValue());
        }

        for (int i = 0; i < vals.size() - 1; i++) {
            for (int j = i + 1; j < vals.size(); j++) {
                if (vals.get(i) != null && vals.get(j) != null) {
                    matrix.set(i, j, vals.get(i) / vals.get(j));
                    matrix.set(j, i, vals.get(j) / vals.get(i));
                }
            }
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
