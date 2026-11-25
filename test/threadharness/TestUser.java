package threadharness;

import java.io.File;
import project.network.ComputeEngineAPI;
import project.network.JobRequest;
import project.network.JobResponse;
import project.network.ResultDelimiters;
import project.process.InputSource;
import project.process.OutputDestination;


public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// @NetworkAPI interface; also update the parameter passed to the constructor
	private final ComputeEngineAPI coordinator;

	public TestUser(ComputeEngineAPI coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
        String inputPath = "test" + File.separatorChar
                + "testInputFile.test";

        // Specify the input file.
        InputSource input = () -> inputPath;

        // Specify the output file.
        OutputDestination output = () -> outputPath;

        // Create the job request.
        JobRequest request = new JobRequest() {

            @Override
            public InputSource getInputSource() {
                return input;
            }

            @Override
            public OutputDestination getOutputDestination() {
                return output;
            }

            @Override
            public ResultDelimiters getDelimiters() {
                return ResultDelimiters.defaults();
            }
        };
        // Submit the computation job.
        JobResponse response = coordinator.submitJob(request);

        // Verify that the computation was successful.
        if (response == null || !response.isAccepted()) {
            throw new IllegalStateException(
                    "Computation job failed: " + outputPath);
        }


	}

}
