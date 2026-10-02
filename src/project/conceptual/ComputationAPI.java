package project.conceptual;

import project.annotations.ConceptualAPI;

/**
 * Conceptual API between the job handler and computation component.
 */
@ConceptualAPI
public interface ComputationAPI {

    /**
     * Finds Pythagorean triples for one positive integer limit.
     *
     * @param input maximum value used in the search
     * @return results of the computation
     */
    ComputationResult compute(int input);
}
