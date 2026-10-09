package project.conceptual;

import project.annotations.ConceptualAPIPrototype;

/**
 * Prototype client for the computation API.
 */
public class ComputationAPIPrototype {


	 public static void main(String[] args) {

		    // Create the computation API implementation
	        ComputationAPI api = new ComputationAPIImpl();

	        // Create a computation request
	        ComputationRequest request = new ComputationRequest() {

	            @Override
	            public int getMaximumValue() {
	                return 10;
	            }
	        };

	        // Call the computation API
	        ComputationResult result = api.compute(request);

	        // Display the result
	        System.out.println("Computation Result: " + result);
	    }
	}