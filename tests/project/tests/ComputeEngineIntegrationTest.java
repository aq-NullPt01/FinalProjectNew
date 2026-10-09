package project.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import project.conceptual.ComputationAPIImpl;
import project.network.ComputeEngineAPIImpl;
import project.network.JobRequest;
import project.network.ResultDelimiters;
import project.process.InputSource;
import project.process.OutputDestination;
import project.tests.memory.InMemoryDataStorage;
import project.tests.memory.InMemoryInputSource;
import project.tests.memory.InMemoryOutputDestination;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngine() {

        // Create test-only data storage
        InMemoryDataStorage storage =
                new InMemoryDataStorage();

        // Create real computation implementation
        ComputationAPIImpl computation =
                new ComputationAPIImpl();

        // Create real network implementation
        ComputeEngineAPIImpl engine =
                new ComputeEngineAPIImpl(storage, computation);

        // Set input values
        InMemoryInputSource input =
                new InMemoryInputSource(
                        Arrays.asList(1, 10, 25));

        // Create output destination
        InMemoryOutputDestination output =
                new InMemoryOutputDestination();

        // Create job request
        JobRequest request = new JobRequest() {

            @Override
            public InputSource getInputSource() {
                return (InputSource) input;
            }

            @Override
            public OutputDestination getOutputDestination() {
                return output;
            }

            @Override
            public ResultDelimiters getDelimiters() {
                return null;
            }
        };

        // Submit computation job
        engine.submitJob(request);

        // Verify that output was generated
        assertFalse(output.getResults().isEmpty());
    }
}
