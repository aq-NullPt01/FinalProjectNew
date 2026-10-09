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
    public void testSubmitJobPlaceholder() {

        // Mock dependencies.
        DataStorageAPI storage = mock(DataStorageAPI.class);
        ComputationAPI computation = mock(ComputationAPI.class);

        // Explicitly construct the network API implementation.
        ComputeEngineAPI api =
                new ComputeEngineAPIImpl(storage, computation);

        JobRequest request = mock(JobRequest.class);

        JobResponse response = api.submitJob(request);

        assertNull(response);
    }
}
