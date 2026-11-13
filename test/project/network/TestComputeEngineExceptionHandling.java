
package project.network;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import project.conceptual.ComputationAPI;
import project.process.DataStorageAPI;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.process.DataStorageAPI;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestComputeEngineExceptionHandling {

    @Test
    public void testStorageExceptionReturnsFailureResponse() {

        // Create mock dependencies
        DataStorageAPI storage = mock(DataStorageAPI.class);
        ComputationAPI computation = mock(ComputationAPI.class);

        JobRequest request = mock(JobRequest.class);

        // Simulate a storage component failure
        when(storage.readInputData(any()))
                .thenThrow(new IllegalStateException(
                        "Simulated storage failure"));

        // Create the real network implementation
        ComputeEngineAPIImpl engine =
                new ComputeEngineAPIImpl(storage, computation);

        // Submit the job
        JobResponse response = engine.submitJob(request);

        // Verify the exception became an error response
        assertNotNull(response);
        assertFalse(response.isAccepted());
        assertTrue(response.getMessage()
                .contains("Simulated storage failure"));
    }
}
