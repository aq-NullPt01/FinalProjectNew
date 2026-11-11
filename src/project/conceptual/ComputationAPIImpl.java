

package project.conceptual;

import java.util.ArrayList;
import java.util.List;

public class ComputationAPIImpl implements ComputationAPI {

    public ComputationAPIImpl() {
        // No parameters to validate
    }

    @Override
    public ComputationResult compute(ComputationRequest request) {

        // Checkpoint 5: Validate the request
        if (request == null) {
            throw new IllegalArgumentException(
                    "Computation request cannot be null");
        }

        int maximumValue = request.getMaximumValue();

        List<String> triples = new ArrayList<>();

        // Zero and negative inputs produce no triples.
        // This preserves existing API behavior.
        if (maximumValue > 0) {
            triples = findPythagoreanTriples(maximumValue);
        }

        final List<String> results = triples;

        return new ComputationResult() {

            @Override
            public int getInput() {
                return maximumValue;
            }

            @Override
            public List<String> getPythagoreanTriples() {
                return results;
            }
        };
    }

    private List<String> findPythagoreanTriples(
            int maximumValue) {

        List<String> triples = new ArrayList<>();

        for (int a = 1; a <= maximumValue; a++) {

            for (int b = a + 1; b <= maximumValue; b++) {

                for (int c = b + 1; c <= maximumValue; c++) {

                    if (isPythagoreanTriple(a, b, c)) {
                        triples.add(a + "," + b + "," + c);
                    }
                }
            }
        }

        return triples;
    }

    private boolean isPythagoreanTriple(
            int a, int b, int c) {

        long squaredA = (long) a * a;
        long squaredB = (long) b * b;
        long squaredC = (long) c * c;

        return squaredA + squaredB == squaredC;
    }
}
