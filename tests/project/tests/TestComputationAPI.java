package project.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.Test;


import project.conceptual.ComputationAPIImpl;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;

public class TestComputationAPI {

	 @Test
	    public void testCompute() {

	        ComputationRequest mockRequest =
	                mock(ComputationRequest.class);

	        when(mockRequest.getMaximumValue())
	                .thenReturn(10);

	        ComputationAPIImpl computation =
	                new ComputationAPIImpl();

	        ComputationResult result =
	                computation.compute(mockRequest);

	        assertNotNull(result);
	    }
}
