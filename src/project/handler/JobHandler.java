package project.handler;

import java.util.List;

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

    // Constructor
    public JobHandler(
            DataStorageAPI storage,
            ComputationAPI computation) {

        this.storage = storage;
        this.computation = computation;
    }

    // Execute a computation job
    public void execute(JobRequest job) {

        // Read input data
        IntegerData input =
                storage.readInputData(job.getInputSource());

        List<Integer> limits = input.getValues();

        StringBuilder text = new StringBuilder();

        // Get result delimiters
        ResultDelimiters delimiters = job.getDelimiters();

        if (delimiters == null) {
            delimiters = ResultDelimiters.defaults();
        }

        // Process each input value
        for (int i = 0; i < limits.size(); i++) {

            final int limit = limits.get(i);

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