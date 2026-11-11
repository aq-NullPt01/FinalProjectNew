package project.handler;

import java.util.List;
import java.util.Objects;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;
import project.network.JobRequest;
import project.network.ResultDelimiters;
import project.process.DataStorageAPI;
import project.process.IntegerData;
import project.process.OutputData;

public class JobHandler {

    // API dependencies
    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    // Constructor injection with validation
    public JobHandler(
            DataStorageAPI storage,
            ComputationAPI computation) {

        this.storage = Objects.requireNonNull(
                storage, "DataStorageAPI cannot be null");

        this.computation = Objects.requireNonNull(
                computation, "ComputationAPI cannot be null");
    }

    // Execute a computation job
    public void execute(JobRequest job) {

        // Validate the job request
        Objects.requireNonNull(
                job, "JobRequest cannot be null");

        Objects.requireNonNull(
                job.getInputSource(),
                "Input source cannot be null");

        Objects.requireNonNull(
                job.getOutputDestination(),
                "Output destination cannot be null");

        // Read input data
        IntegerData input =
                storage.readInputData(job.getInputSource());

        if (input == null) {
            throw new IllegalStateException(
                    "Data storage returned null input");
        }

        List<Integer> limits = input.getValues();

        if (limits == null) {
            throw new IllegalStateException(
                    "Input values cannot be null");
        }

        StringBuilder text = new StringBuilder();

        // Get result delimiters
        ResultDelimiters delimiters = job.getDelimiters();

        // Null delimiters are valid: use defaults
        if (delimiters == null) {
            delimiters = ResultDelimiters.defaults();
        }

        // Process each input value
        for (int i = 0; i < limits.size(); i++) {

            Integer value = limits.get(i);

            if (value == null) {
                throw new IllegalArgumentException(
                        "Input value at index " + i
                        + " cannot be null");
            }

            final int limit = value;

            // Create computation request
            ComputationRequest request =
                    new ComputationRequest() {

                @Override
                public int getMaximumValue() {
                    return limit;
                }
            };

            // Compute Pythagorean triples
            ComputationResult result =
                    computation.compute(request);

            if (result == null) {
                throw new IllegalStateException(
                        "Computation returned null result");
            }

            if (result.getPythagoreanTriples() == null) {
                throw new IllegalStateException(
                        "Computation returned null triples");
            }

            // Add delimiter between results
            if (i > 0) {
                text.append(
                        delimiters.getResultDelimiter());
            }

            // Format output
            text.append(limit);

            text.append(
                    delimiters.getInputResultDelimiter());

            text.append(
                    String.join(
                            ",",
                            result.getPythagoreanTriples()));
        }

        // Create output data
        final String formatted = text.toString();

        OutputData output = new OutputData() {

            @Override
            public String getData() {
                return formatted;
            }
        };

        // Write results
        storage.writeOutputData(
                job.getOutputDestination(),
                output);
    }
}
