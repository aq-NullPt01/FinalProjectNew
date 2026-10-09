package project.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.network.ComputeEngineAPIImpl;
import project.network.JobRequest;
import project.network.JobResponse;
import project.process.DataStorageAPI;

public class TestComputeEngineAPI {

    @Test
    public void testSubmitJob() {

        // Mock the API dependencies
        DataStorageAPI storage =  mock(DataStorageAPI.class);

        ComputationAPI computation =  mock(ComputationAPI.class);

        // Explicitly create the real network implementation
        ComputeEngineAPIImpl engine = new ComputeEngineAPIImpl(storage, computation);

        // Mock the job request
        JobRequest request = mock(JobRequest.class);

        // Submit the job
        JobResponse response = engine.submitJob(request);

        // Verify that a response is returned
        assertNotNull(response);
    }
}