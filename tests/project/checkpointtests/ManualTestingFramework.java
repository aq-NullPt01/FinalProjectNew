package project.checkpointtests;

import project.conceptual.ComputationAPI;
import project.conceptual.ComputationAPIImpl;
import project.network.ComputeEngineAPI;
import project.network.ComputeEngineAPIImpl;
import project.network.JobRequest;
import project.network.JobResponse;
import project.network.ResultDelimiters;
import project.process.DataStorageAPI;
import project.process.DataStorageAPIImpl;
import project.process.InputSource;
import project.process.OutputDestination;

/**
 * Manual testing framework for Checkpoint 4.
 */
public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    /**
     * Runs the compute engine using file-based input and output.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // 1: Instantiate real implementations of all 3 APIs.

        ComputationAPI computation = new ComputationAPIImpl();

        DataStorageAPI storage = new DataStorageAPIImpl();

        ComputeEngineAPI engine = new ComputeEngineAPIImpl(storage, computation);

        // 2: Run a computation using the specified files.

        InputSource input = () -> INPUT;

        OutputDestination output = () -> OUTPUT;

        ResultDelimiters delimiters = new ResultDelimiters() {

            @Override
            public String getInputResultDelimiter() {
                return ",";
            }

            @Override
            public String getResultDelimiter() {
                return ",";
            }
        };

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
                return delimiters;
            }
        };

        JobResponse response = engine.submitJob(request);

        System.out.println(response.getMessage());
    }
}