package project.process;

import project.annotations.ProcessAPI;

/**
 * Defines the API between the data storage system and the compute engine.
 */
@ProcessAPI
public interface DataStorageAPI {

    /**
     * Reads integer data from the specified input source.
     *
     * @param source the source of the input data
     * @return the integer data read from the source
     */
    IntegerData readInputData(InputSource source);

    /**
     * Writes computation results to the specified output destination.
     *
     * @param destination the destination for the output
     * @param data the computation results to write
     */
    void writeOutputData(OutputDestination destination, OutputData data);
}
