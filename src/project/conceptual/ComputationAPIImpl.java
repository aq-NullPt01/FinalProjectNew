package project.conceptual;

import java.util.ArrayList;
import java.util.List;
/**
 * Conceptual @Override
	API between the job handler and computation component.
 */

public class ComputationAPIImpl implements ComputationAPI {

	 // Constructor: no parameters require validation
    public ComputationAPIImpl() {
        // No external dependencies needed
    }

    @Override
    public ComputationResult compute(ComputationRequest request) {

        // Checkpoint 5: Validate the request
        if (request == null) {
            throw new IllegalArgumentException(
                    "Computation request cannot be null");
        }

        // Get the maximum value from the request
        int maximumValue = request.getMaximumValue();

        // Checkpoint 5: Validate the maximum value
        if (maximumValue <= 0) {
            throw new IllegalArgumentException(
                    "Maximum value must be greater than zero");
        }

        // Find all Pythagorean triples
        List<String> triples =
                findPythagoreanTriples(maximumValue);

        // Return the result through the API
        return new ComputationResult() {

            @Override
            public int getInput() {
                return maximumValue;
            }

            @Override
            public List<String> getPythagoreanTriples() {
                return triples;
            }
        };
    }

    // Find all triples up to the maximum value
    private List<String> findPythagoreanTriples(int maximumValue) {

        List<String> triples = new ArrayList<>();

        for (int a = 1; a <= maximumValue; a++) {

            for (int b = a + 1; b <= maximumValue; b++) {

                for (int c = b + 1; c <= maximumValue; c++) {

                    if (isPythagoreanTriple(a, b, c)) {

                        String triple = a + "," + b + "," + c;

                        triples.add(triple);
                    }
                }
            }
        }

        return triples;
    }

    // Check whether three integers form a triple
    private boolean isPythagoreanTriple(int a, int b, int c) {

        long squaredA = (long) a * a;
        long squaredB = (long) b * b;
        long squaredC = (long) c * c;

        return squaredA + squaredB == squaredC;
    }

}
