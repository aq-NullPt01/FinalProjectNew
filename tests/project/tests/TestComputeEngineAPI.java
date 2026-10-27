package project.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.network.ComputeEngineAPI;
import project.network.ComputeEngineAPIImpl;
import project.network.JobRequest;
import project.network.JobResponse;
import project.process.DataStorageAPI;

/**
 * Smoke tests for the network API.
 */
public class TestComputeEngineAPI {

    /**
     * Checks constructor injection and response handling.
     */
    @Test
    public void testComputeEngineAPI() {

        DataStorageAPI storage = mock(DataStorageAPI.class);
        ComputationAPI computation = mock(ComputationAPI.class);
        JobRequest request = mock(JobRequest.class);

        ComputeEngineAPI engine =
                new ComputeEngineAPIImpl(storage, computation);

        JobResponse response = engine.submitJob(request);

        assertNotNull(response);
        assertFalse(response.isAccepted());
    }
}
