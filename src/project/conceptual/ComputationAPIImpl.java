package project.conceptual;

import project.annotations.ConceptualAPI;

/**
 * Conceptual @Override
	API between the job handler and computation component.
 */
@ConceptualAPI
public class ComputationAPIImpl implements ComputationAPI {

    @Override
    public ComputationResult compute( ComputationRequest request) {

        // TODO: Implement Pythagorean triples calculation
        return null;
    }
}
