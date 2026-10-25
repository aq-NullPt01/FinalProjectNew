package project.tests;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.network.ComputeEngineAPI;
import project.network.ComputeEngineAPIImpl;
import project.network.JobRequest;
import project.network.JobResponse;
import project.process.DataStorageAPI;

public class TestComputeEngineAPI {

	 @Test
	    public void testSubmitJob() {

	        // Mock the two API dependencies
	        DataStorageAPI mockStorage = mock(DataStorageAPI.class);

	        ComputationAPI mockComputation = mock(ComputationAPI.class);

	        // Inject Mockito mocks through the constructor
	        ComputeEngineAPIImpl engine =
	                new ComputeEngineAPIImpl(mockStorage, mockComputation);

	        // Mock the job request
	        JobRequest mockRequest =   mock(JobRequest.class);

	        // Call the API method
	        JobResponse response = engine.submitJob(mockRequest);

	        // Will fail until the API is implemented
	        assertNotNull(response);
	    }
	 }
