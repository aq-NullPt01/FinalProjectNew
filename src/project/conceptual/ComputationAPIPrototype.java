package project.conceptual;

import project.annotations.ConceptualAPIPrototype;

public class ComputationAPIPrototype {

    @ConceptualAPIPrototype
    public static void prototype(ComputationAPI api) {

        ComputationRequest request = () -> 10;

        ComputationResult result = api.compute(request);

        System.out.println(result.getPythagoreanTriples());
    }

    
    public static void main(String[] args) {
        prototype(new ComputationAPIImpl());
    }
}