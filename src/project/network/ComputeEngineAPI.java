package project.network;

import project.annotations.NetworkAPI;

/**
 * API between the user and the compute engine.
 */
@NetworkAPI
public interface ComputeEngineAPI {

    /**
     * Submits a computation job to the compute engine.
     *
     * @param request the requested computation job
     */
    void submitJob(JobRequest request);
}
