package project.network;

import java.util.List;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;
import project.process.DataStorageAPI;
import project.process.IntegerData;
import project.process.OutputData;

public class ComputeEngineAPIImpl implements ComputeEngineAPI {

	//dependecy injection
    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public ComputeEngineAPIImpl(
            DataStorageAPI storage,
            ComputationAPI computation) {

        this.storage = storage;
        this.computation = computation;
    }

    @Override
    public JobResponse submitJob(JobRequest request) {

        try {

            // Step 1: Read the integers from storage
            IntegerData inputData = storage.readInputData(request.getInputSource());

            List<Integer> inputValues = inputData.getValues();

            // Step 2: Compute the results for each integer
            StringBuilder output = new StringBuilder();

            ResultDelimiters delimiters = request.getDelimiters();

            String inputSeparator = ":";
            String resultSeparator = ";";

            if (delimiters != null) {
                inputSeparator = delimiters.getInputResultDelimiter();

                resultSeparator = delimiters.getResultDelimiter();
            }
           
            //perform computtaion
            for (int maximumValue : inputValues) {

                // Create a computation request
                ComputationRequest computationRequest = () -> maximumValue;

                // Call the computation API
                ComputationResult result = computation.compute(computationRequest);

                // Format this input and its results
                output.append(maximumValue);
                output.append(inputSeparator);

                List<String> triples = result.getPythagoreanTriples();

                output.append(String.join(resultSeparator, triples));

                output.append(System.lineSeparator());
            }

            // Step 3: Write the formatted output
            String formattedOutput = output.toString();

            OutputData outputData = () -> formattedOutput;

            storage.writeOutputData(request.getOutputDestination(), outputData);

            // Step 4: Return a successful response
            return createResponse(true,"Job completed successfully");

        } catch (Exception exception) {

            // Return a failed response
            return createResponse(false, "Job failed: " + exception.getMessage());
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