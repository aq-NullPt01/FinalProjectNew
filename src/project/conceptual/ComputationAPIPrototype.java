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
        int input = 10;

        api.compute(input);
    }
}