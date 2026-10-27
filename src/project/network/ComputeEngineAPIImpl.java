package project.network;

import project.conceptual.ComputationAPI;
import project.process.DataStorageAPI;

public class ComputeEngineAPIImpl implements ComputeEngineAPI {

    // Dependencies
    private final DataStorageAPI storage;
    private final ComputationAPI computation;

    // Constructor
    public ComputeEngineAPIImpl(
            DataStorageAPI storage,
            ComputationAPI computation) {

        this.storage = storage;
        this.computation = computation;
    }

    @Override
    public JobResponse submitJob(JobRequest request) {

    	// Empty implementation for Checkpoint 3
        return null;
    }
}
