package project.handler;



import project.conceptual.ComputationAPI;
import project.conceptual.ComputationRequest;
import project.conceptual.ComputationResult;
import project.network.JobRequest;
import project.process.DataStorageAPI;
import project.process.IntegerData;
import project.process.OutputData;

/**
 * Coordinates the computation workflow.
 */
public class JobHandler {

    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    public JobHandler(DataStorageAPI storage,
            ComputationAPI computation) {
        this.storage = storage;
        this.computation = computation;
    }

    /**
     * Loads input, computes results, and writes output.
     *
     * @param job configuration for the submitted job
     */
    public void execute(JobRequest job) {

        IntegerData input =
                storage.readInputData(job.getInputSource());

        // The input adapter should convert IntegerData
        // into one or more ComputationRequest objects.

        // For each computation request:
        // ComputationResult result =
        //         computation.compute(request);

        // Convert the results into OutputData, then:
        // storage.writeOutput(
        //         job.getOutputDestination(), output);
    }
}