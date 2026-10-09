package project.tests;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationAPIImpl;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;

public class TestComputationAPI {

    @Test
    public void testComputePlaceholder() {
    	

        // Explicitly create the real API implementation.
        ComputationAPI api = new ComputationAPIImpl();

        // Mock the request object.
        ComputationRequest request =  mock(ComputationRequest.class);

        // Placeholder implementation currently returns null.
        ComputationResult result = api.compute(request);

        assertNull(result);
    }
}
