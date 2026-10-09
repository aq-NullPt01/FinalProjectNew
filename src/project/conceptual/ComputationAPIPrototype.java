package project.conceptual;

import project.annotations.ConceptualAPIPrototype;

/**
 * Prototype client for the computation API.
 */
public class ComputationAPIPrototype {

    /**
     * Demonstrates how the job handler uses the computation API.
     *
     * @param api conceptual API being demonstrated
     */
    @ConceptualAPIPrototype
    public void prototype(ComputationAPI api) {

        ComputationRequest request = new ComputationRequest() {
            @Override
            public int getMaximumValue() {
                return 10;
            }
        };

        ComputationResult result = api.compute(request);
    }
}