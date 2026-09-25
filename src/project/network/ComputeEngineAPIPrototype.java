package project.network;

import project.annotations.NetworkAPIPrototype;

/**
 * Prototype client for the network API.
 */
public class ComputeEngineAPIPrototype {

    /**
     * Demonstrates how a user can submit a computation job.
     *
     * @param api the compute engine API
     */
    @NetworkAPIPrototype
    public void prototype(ComputeEngineAPI api) {
        JobRequest request = null;
        
        api.submitJob(request);
    }
}