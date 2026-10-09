package project.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPIImpl;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;

public class TestComputationAPI {

    @Test
    public void testCompute() {

        // Create the real API implementation
        ComputationAPIImpl api = new ComputationAPIImpl();

        // Mock the computation request
        ComputationRequest request = mock(ComputationRequest.class);

        // Set the maximum value to 10
        when(request.getMaximumValue()).thenReturn(10);

        // Call the computation method
        ComputationResult result = api.compute(request);

        // Verify that a result is returned
        assertNotNull(result);
    }
}
