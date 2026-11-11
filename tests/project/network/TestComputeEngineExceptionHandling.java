package project.network;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationAPIImpl;
import project.process.DataStorageAPIImpl;
import project.process.InputSource;
import project.process.OutputDestination;

public class TestComputeEngineExceptionHandling {

    @Test
    public void testMissingInputFileReturnsFailure() {

        // Use real implementations
        DataStorageAPIImpl storage =
                new DataStorageAPIImpl();

        ComputationAPI computation =
                new ComputationAPIImpl();

        ComputeEngineAPIImpl engine =
                new ComputeEngineAPIImpl(
                        storage, computation);

        // Input file deliberately does not exist
        InputSource source =
                () -> "checkpoint5_missing_input_12345.txt";

        OutputDestination destination =
                () -> "checkpoint5_output.txt";

        JobRequest request = new JobRequest() {

            @Override
            public InputSource getInputSource() {
                return source;
            }

            @Override
            public OutputDestination getOutputDestination() {
                return destination;
            }

            @Override
            public ResultDelimiters getDelimiters() {
                return ResultDelimiters.defaults();
            }
        };

        // An exception must not escape submitJob()
        JobResponse response =
                assertDoesNotThrow(
                        () -> engine.submitJob(request));

        assertNotNull(response);

        // Verify the error was converted to a response
        assertFalse(response.isAccepted());

        assertNotNull(response.getMessage());

        assertTrue(
                response.getMessage().contains("Job failed"));
    }

    @Test
    public void testNullRequestReturnsFailure() {

        ComputeEngineAPIImpl engine =
                new ComputeEngineAPIImpl(
                        new DataStorageAPIImpl(),
                        new ComputationAPIImpl());

        JobResponse response =
                assertDoesNotThrow(
                        () -> engine.submitJob(null));

        assertNotNull(response);
        assertFalse(response.isAccepted());

        assertTrue(
                response.getMessage().contains(
                        "Job request cannot be null"));
    }
}