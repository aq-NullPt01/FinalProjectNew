package project.process;

import project.annotations.ProcessAPIPrototype;

/**
 * Prototype client for the data storage API.
 */
public class DataStorageAPIPrototype {

    /**
     * Demonstrates how the compute engine can use the data storage API.
     *
     * @param api the data storage API
     */
    @ProcessAPIPrototype
    public void prototype(DataStorageAPI api) {
        InputSource source = null;
        OutputDestination destination = null;

       // IntegerData inputData = api.readInputData(source);

        OutputData outputData = null;
        
        api.readInputData(source);
        api.writeOutputData(destination, outputData);
    }
}