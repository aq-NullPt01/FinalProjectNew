package project.conceptual;

import java.util.List;

/**
 * Represents the result of a Pythagorean triple computation.
 */
public interface ComputationResult {

    int getInput();

    List<String> getPythagoreanTriples();
}