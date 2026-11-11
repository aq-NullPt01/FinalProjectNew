package project.network;

import java.util.List;
import java.util.Objects;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;
import project.process.DataStorageAPI;
import project.process.IntegerData;
import project.process.OutputData;

public class ComputeEngineAPIImpl implements ComputeEngineAPI {

    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public ComputeEngineAPIImpl(
            DataStorageAPI storage,
            ComputationAPI computation) {

        this.storage = Objects.requireNonNull(
                storage, "Storage cannot be null");

        this.computation = Objects.requireNonNull(
                computation, "Computation cannot be null");
    }

    @Override
    public JobResponse submitJob(JobRequest request) {

        try {
            // Checkpoint 5: Validate job request
            if (request == null) {
                throw new IllegalArgumentException(
                        "Job request cannot be null");
            }

            if (request.getInputSource() == null) {
                throw new IllegalArgumentException(
                        "Input source cannot be null");
            }

            if (request.getOutputDestination() == null) {
                throw new IllegalArgumentException(
                        "Output destination cannot be null");
            }

            // Step 1: Read input
            IntegerData inputData =
                    storage.readInputData(
                            request.getInputSource());

            if (inputData == null ||
                    inputData.getValues() == null) {
                throw new IllegalStateException(
                        "Input data cannot be null");
            }

            List<Integer> inputValues =
                    inputData.getValues();

            // Step 2: Compute results
            StringBuilder output = new StringBuilder();

            for (Integer maximumValue : inputValues) {

                if (maximumValue == null) {
                    throw new IllegalArgumentException(
                            "Input integer cannot be null");
                }

                ComputationRequest computationRequest =
                        () -> maximumValue;

                ComputationResult result =
                        computation.compute(
                                computationRequest);

                if (result == null ||
                        result.getPythagoreanTriples() == null) {
                    throw new IllegalStateException(
                            "Computation result cannot be null");
                }

                if (output.length() > 0) {
                    output.append(",");
                }

                String formattedResult = String.join(
                        ";", result.getPythagoreanTriples());

                output.append(
                        formattedResult.isEmpty()
                                ? "none"
                                : formattedResult.replace(",", "-"));
            }

            // Step 3: Write output
            String formattedOutput = output.toString();

            OutputData outputData =
                    () -> formattedOutput;

            storage.writeOutputData(
                    request.getOutputDestination(),
                    outputData);

            // Step 4: Success response
            return createResponse(
                    true,
                    "Job completed successfully");

        } catch (Exception exception) {

            // Checkpoint 5: Convert exceptions
            // into a non-exception failure response
            return createResponse(
                    false,
                    "Job failed: "
                            + exception.getMessage());
        }
    }

    private JobResponse createResponse(
            boolean accepted,
            String message) {

        return new JobResponse() {

            @Override
            public boolean isAccepted() {
                return accepted;
            }

            @Override
            public String getJobId() {
                return "job-1";
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }
}